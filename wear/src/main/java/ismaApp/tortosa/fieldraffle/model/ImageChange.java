package ismaApp.tortosa.fieldraffle.model;

import android.view.Gravity;
import android.widget.ImageView;
import android.widget.Toast;

public class ImageChange implements ImageChangeI{

    private ImageView coinImageView;

    public ImageChange(ImageView coinImageView) {
        this.coinImageView = coinImageView;
    }

    @Override
    public void setImageResource(int resource) {
        coinImageView.setImageResource(resource);
    }

    @Override
    public void showResult(String message) {
        Toast toast = Toast.makeText(coinImageView.getContext(), message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.show();
    }
}
