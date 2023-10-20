package ismaApp.tortosa.fieldraffle.model;

import android.content.Context;
import android.widget.Toast;

public class ToastHelper implements ToastHelperI{
    @Override
    public void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
