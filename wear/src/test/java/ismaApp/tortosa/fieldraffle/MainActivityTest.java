package ismaApp.tortosa.fieldraffle;

import android.content.Context;
import android.content.res.Resources;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.Toast;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;

import ismaApp.tortosa.fieldraffle.model.CoinEntity;
import ismaApp.tortosa.fieldraffle.model.ImageChange;
import ismaApp.tortosa.fieldraffle.model.ToastHelper;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import androidx.test.runner.permission.RequestPermissionCallable;

import junit.textui.ResultPrinter;

import java.util.Random;

@RunWith(MockitoJUnitRunner.class)
public class MainActivityTest {

    @Mock
    private ImageView imageView;
    @InjectMocks
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
        imageChange = new ImageChange(imageView, new ToastHelper());
        int resource = R.drawable.heads;

        imageChange.setImageResource(resource);

        // Verifica que se llamó a setImageResource en el mockImageView con el recurso esperado
        verify(imageView).setImageResource(resource);
    }

    @Test
    public void testShowResult() {
        // Crear un mock de ToastHelper
        ToastHelper mockToastHelper = mock(ToastHelper.class);

        // Crear un mock de ImageView y configurar su contexto
        ImageView mockImageView = mock(ImageView.class);
        Context mockImageViewContext = mock(Context.class);
        when(mockImageView.getContext()).thenReturn(mockImageViewContext);

        // Usar el mockImageView y el mockToastHelper en tus pruebas
        ImageChange imageChange = new ImageChange(mockImageView, mockToastHelper);

        String message = "Heads";

        // Ejecutar el método que se va a probar
        imageChange.showResult(message);

        // Verificar que se llamó a showToast en el mock de ToastHelper con el mensaje esperado
        verify(mockToastHelper).showToast(mockImageViewContext, message);
    }
}














