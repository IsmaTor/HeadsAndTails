package ismaApp.tortosa.fieldraffle;

import android.content.Context;
import android.widget.ImageView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import ismaApp.tortosa.fieldraffle.model.ImageChange;
import ismaApp.tortosa.fieldraffle.model.ToastHelper;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MainActivityTest {

    @Mock
    private ImageView imageView;
    @Mock
    private ToastHelper toastHelper;
    @Mock
    private Context context;
    @InjectMocks
    private ImageChange imageChange;
    private AutoCloseable closeable;

    @Before
    public void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @After
    public void setClose() throws Exception{
        closeable.close();
    }


    @Test
    public void testSetImageResource() {
        imageChange = new ImageChange(imageView, new ToastHelper());
        int resource = R.drawable.heads;

        imageChange.setImageResource(resource);

        // verifica que se llamó a setImageResource en el imageView con el recurso esperado.
        verify(imageView).setImageResource(resource);
    }

    @Test
    public void testShowResult() {
        when(imageView.getContext()).thenReturn(context);

        ImageChange imageChange = new ImageChange(imageView, toastHelper);
        String message = "Heads";

        imageChange.showResult(message);

        // verificar que se llamó a showToast con el mensaje esperado.
        verify(toastHelper).showToast(context, message);
        verify(imageView).getContext();
    }
}
