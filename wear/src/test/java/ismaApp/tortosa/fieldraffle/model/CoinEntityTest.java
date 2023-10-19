package ismaApp.tortosa.fieldraffle.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ismaApp.tortosa.fieldraffle.R;

public class CoinEntityTest {
    private CoinEntity coinEntity;

    @Before
    public void setUp() {
        coinEntity = new CoinEntity();
    }

    @Test
    public void testGetCurrentImageResource() {
        assertEquals(R.drawable.heads, coinEntity.getCurrentImageResource());
        coinEntity.nextImage();
        assertEquals(R.drawable.headsint, coinEntity.getCurrentImageResource());
        coinEntity.nextImage();
        assertEquals(R.drawable.tails, coinEntity.getCurrentImageResource());
        coinEntity.nextImage();
        assertEquals(R.drawable.tailsint, coinEntity.getCurrentImageResource());
        coinEntity.nextImage();
    }

    @Test
    public void testReset() {
        coinEntity.nextImage();
        coinEntity.reset();
        assertEquals(R.drawable.heads, coinEntity.getCurrentImageResource());
    }
}
