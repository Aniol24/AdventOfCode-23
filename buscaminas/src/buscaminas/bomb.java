package buscaminas;

import java.awt.*;
import java.util.Random;

import static buscaminas.mapa.tamany;

public class bomb {

    Point coordenades = new Point();

    public bomb(){

        //Random random = new Random();

        coordenades.x = getRandomNumberInRange(0,tamany - 1);
        coordenades.y = getRandomNumberInRange(0,tamany - 1);
    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

}
