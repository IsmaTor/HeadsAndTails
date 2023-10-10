package ismaApp.tortosa.fieldraffle.model;

import ismaApp.tortosa.fieldraffle.R;

public class CoinEntity {
    //Attributes
    private int currentImageIndex = 0; //índice de la imagen actual.
    private int[] imageResources = {
            R.drawable.heads, R.drawable.headsint, R.drawable.tails, R.drawable.tailsint,
            R.drawable.heads, R.drawable.headsint, R.drawable.tails, R.drawable.tailsint,
            R.drawable.heads, R.drawable.headsint, R.drawable.tails, R.drawable.tailsint
    };

    public int getCurrentImageResource(){
        if (currentImageIndex < imageResources.length){
            return imageResources[currentImageIndex];
        }
        return -1; //la secuencia de imagenes a terminado.
    }

    public void nextImage(){
        currentImageIndex++;
    }

    public void reset(){
        currentImageIndex = 0;
    }



}
