package ismaApp.tortosa.fieldraffle;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

import android.content.Context;
import android.view.Gravity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import ismaApp.tortosa.fieldraffle.model.ImageChange;

@RunWith(MockitoJUnitRunner.class)
public class MainActivityTest {

    @Mock
    private ImageView mockImageView;
    @Mock
    private Toast mockToast;
    @InjectMocks
    private ImageChange imageChange;

    @Before
    public void setUp() {
        // Inicializa los mocks
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSetImageResource() { //funciona
        imageChange = new ImageChange(mockImageView);
        int resource = R.drawable.heads; // Reemplaza con el recurso que quieras utilizar

        imageChange.setImageResource(resource);

        // Verifica que se llamó a setImageResource en el mockImageView con el recurso esperado
        verify(mockImageView).setImageResource(resource);
    }

    @Test
    public void testShowResult() {
        imageChange = new ImageChange(mockImageView);
        String message = "Test message";

        // Mock para el contexto
        Context mockContext = Mockito.mock(Context.class);

        // Configura el Toast para verificar que se llama con los parámetros correctos
        mockToast = Mockito.mock(Toast.class);
        Mockito.when(Toast.makeText(mockContext, message, Toast.LENGTH_SHORT)).thenReturn(mockToast);

        imageChange.showResult(message);

        // Verifica que se llamó a Toast.makeText con el contexto y mensaje esperados
        Mockito.verify(mockToast).setGravity(Gravity.BOTTOM, 0, 0);
        Mockito.verify(mockToast).show();
    }
}











