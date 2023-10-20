package ismaApp.tortosa.fieldraffle.model;

import android.view.Gravity;
import android.widget.ImageView;
import android.widget.Toast;

public class ImageChange implements ImageChangeI{

    private ImageView coinImageView;
    private ToastHelper toastHelper;

    public ImageChange(ImageView coinImageView, ToastHelper toastHelper) {
        this.coinImageView = coinImageView;
        this.toastHelper = toastHelper;
    }

    @Override
    public void setImageResource(int resource) {
        coinImageView.setImageResource(resource);
    }

    @Override
    public void showResult(String message) {
        toastHelper.showToast(coinImageView.getContext(), message);
    }
}
