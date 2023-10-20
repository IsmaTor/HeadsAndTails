package ismaApp.tortosa.fieldraffle;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

import ismaApp.tortosa.fieldraffle.model.CoinEntity;
import ismaApp.tortosa.fieldraffle.model.ImageChange;
import ismaApp.tortosa.fieldraffle.model.ToastHelper;

public class MainActivity extends Activity implements View.OnClickListener {
    //Attributes
    private ImageView coinImageView;
    private Button startButton;
    private boolean lotteryStarted = false;
    private CoinEntity coinEntity;
    private final Random random = new Random();

    @Override //inicialización incial de la aplicación
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coinImageView = findViewById(R.id.coinImageView);
        startButton = findViewById(R.id.startButton);
        coinEntity = new CoinEntity();

        coinImageView.setVisibility(View.INVISIBLE);
        startButton.setOnClickListener(this);
    }

    @Override //cuando se ha hecho click en START y el sorteo a inciado.
    public void onClick(View view) {
        if(!lotteryStarted){
            startButton.setEnabled(false);
            startButton.setVisibility(View.INVISIBLE);
            startFlipAnimation();
        } else {
            coinImageView.setVisibility(View.INVISIBLE);
            startButton.setText(getText(R.string.start));
            lotteryStarted = false;
        }
    }

    private void startFlipAnimation(){
        lotteryStarted = true;
        coinEntity.reset();
        coinImageView.setVisibility(View.VISIBLE);
        startImageChangeSequence();
    }

    public void startImageChangeSequence() {
        final Handler handler = new Handler(Looper.getMainLooper());

        ImageChange imageChange = new ImageChange(coinImageView, new ToastHelper());

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                int imageResource = coinEntity.getCurrentImageResource();
                if (imageResource != -1) {
                    imageChange.setImageResource(imageResource);
                    coinEntity.nextImage();
                    handler.postDelayed(this, 300);
                } else {
                    int heads = 1;
                    int lottery = random.nextInt(2) + 1;

                    if (lottery == heads) {
                        imageChange.setImageResource(R.drawable.heads);
                        imageChange.showResult("Heads");
                    } else {
                        imageChange.setImageResource(R.drawable.tails);
                        imageChange.showResult("Tails");
                    }

                    handler.postDelayed(() -> {
                        startButton.setText(getText(R.string.reset));
                        startButton.setVisibility(View.VISIBLE);
                        startButton.setEnabled(true);
                    }, 1000);
                }
            }
        }, 0);
    }

}
