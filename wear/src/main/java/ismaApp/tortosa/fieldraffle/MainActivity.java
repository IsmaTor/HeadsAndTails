package ismaApp.tortosa.fieldraffle;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import ismaApp.tortosa.fieldraffle.model.CoinEntity;

public class MainActivity extends Activity implements View.OnClickListener {
    //Attributes
    private ImageView coinImageView;
    private Button startButton;
    private boolean lotteryStarted = false;
    private CoinEntity coinEntity;

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
            startButton.setText("START");
            lotteryStarted = false;
        }
    }

    private void startFlipAnimation(){
        lotteryStarted = true;
        coinEntity.reset();
        coinImageView.setVisibility(View.VISIBLE);
        startImageChangeSequence();
    }

    private void startImageChangeSequence(){
        final Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                int imageResource = coinEntity.getCurrentImageResource();
                if(imageResource != -1){
                    coinImageView.setImageResource(imageResource);
                    coinEntity.nextImage();
                    handler.postDelayed(this, 100);
                } else {
                    int heads = 1;
                    int tails = 2;
                    int lottery = (int) (Math.random() * 2 + 1);

                    if(lottery == heads){
                        coinImageView.setImageResource(R.drawable.heads);
                        showResult("Heads");
                    } else {
                        coinImageView.setImageResource(R.drawable.tails);
                        showResult("Tails");
                    }

                    handler.postDelayed(() -> {
                        startButton.setText("RESET");
                        startButton.setVisibility(View.VISIBLE);
                        startButton.setEnabled(true);
                    }, 1000);
                }
            }
        }, 0);
    }

    //muestra el resultado final en la parte de abajo.
    private void showResult(String message){
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.show();
    }

}
