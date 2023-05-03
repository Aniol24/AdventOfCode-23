package buscaminas;

import java.util.Arrays;

public class mapa {

    public static int tamany = 6;
    public static int[][] mapa = new int[tamany][tamany];
    public static int num_bombes = 5;
    public int[][] crearMapa(){


        for(int i = 0; i < tamany; i++){

            Arrays.fill(mapa[i], 0);
        }

        for(int i = 0; i < num_bombes; i++){

            boolean newBomb = false;

            while(!newBomb){

                bomb bomba = new bomb();

                if(mapa[bomba.coordenades.x][bomba.coordenades.y] != -1){
                    afegirBomba(bomba);
                    newBomb = true;
                }
            }

        }

        return mapa;
    }
    private void afegirBomba(bomb bomba){

        mapa[bomba.coordenades.x][bomba.coordenades.y] = -1;

        afegirNumeros(bomba);

    }

    private void afegirNumeros(bomb bomba) {

        if(bomba.coordenades.x < tamany - 1 && bomba.coordenades.x > 0 && bomba.coordenades.y < tamany - 1 && bomba.coordenades.y > 0 ){
            if(mapa[bomba.coordenades.x + 1][bomba.coordenades.y] != -1){
                mapa[bomba.coordenades.x + 1][bomba.coordenades.y] ++;
            }
            if(mapa[bomba.coordenades.x - 1][bomba.coordenades.y] != -1){
                mapa[bomba.coordenades.x - 1][bomba.coordenades.y] ++;
            }
            if(mapa[bomba.coordenades.x][bomba.coordenades.y - 1] != -1){
                mapa[bomba.coordenades.x][bomba.coordenades.y - 1] ++;
            }
            if(mapa[bomba.coordenades.x][bomba.coordenades.y + 1] != -1){
                mapa[bomba.coordenades.x][bomba.coordenades.y + 1] ++;
            }
            if(mapa[bomba.coordenades.x + 1][bomba.coordenades.y + 1] != -1){
                mapa[bomba.coordenades.x + 1][bomba.coordenades.y + 1] ++;
            }
            if(mapa[bomba.coordenades.x - 1][bomba.coordenades.y + 1] != -1){
                mapa[bomba.coordenades.x - 1][bomba.coordenades.y + 1] ++;
            }
            if(mapa[bomba.coordenades.x + 1][bomba.coordenades.y - 1] != -1){
                mapa[bomba.coordenades.x + 1][bomba.coordenades.y - 1] ++;
            }
            if(mapa[bomba.coordenades.x - 1][bomba.coordenades.y - 1] != -1){
                mapa[bomba.coordenades.x - 1][bomba.coordenades.y - 1] ++;
            }
        }

        if(bomba.coordenades.x == tamany - 1 && bomba.coordenades.y > 0 && bomba.coordenades.y < tamany - 1){

            /*
            [0, 1, 1]
            [0, 1, -1]
            [0, 1, 1]
            */



            if(mapa[bomba.coordenades.x][bomba.coordenades.y - 1] != -1){
                mapa[bomba.coordenades.x][bomba.coordenades.y - 1] ++;
            }
            if(mapa[bomba.coordenades.x][bomba.coordenades.y + 1] != -1){
                mapa[bomba.coordenades.x][bomba.coordenades.y  + 1] ++;
            }
            if(mapa[bomba.coordenades.x - 1][bomba.coordenades.y] != -1){
                mapa[bomba.coordenades.x - 1][bomba.coordenades.y] ++;
            }
            if(mapa[bomba.coordenades.x - 1][bomba.coordenades.y - 1] != -1){
                mapa[bomba.coordenades.x - 1][bomba.coordenades.y - 1] ++;
            }
            if(mapa[bomba.coordenades.x - 1][bomba.coordenades.y + 1] != -1){
                mapa[bomba.coordenades.x - 1][bomba.coordenades.y + 1] ++;
            }
        }

        if(bomba.coordenades.x == 0 && bomba.coordenades.y > 0 && bomba.coordenades.y < tamany - 1) {


            if(mapa[bomba.coordenades.x][bomba.coordenades.y - 1] != -1){
                mapa[bomba.coordenades.x][bomba.coordenades.y - 1] ++;
            }
            if(mapa[bomba.coordenades.x][bomba.coordenades.y + 1] != -1){
                mapa[bomba.coordenades.x][bomba.coordenades.y + 1] ++;
            }
            if(mapa[bomba.coordenades.x + 1][bomba.coordenades.y] != -1){
                mapa[bomba.coordenades.x + 1][bomba.coordenades.y] ++;
            }
            if(mapa[bomba.coordenades.x + 1][bomba.coordenades.y + 1] != -1){
                mapa[bomba.coordenades.x + 1][bomba.coordenades.y + 1] ++;
            }
            if(mapa[bomba.coordenades.x + 1][bomba.coordenades.y - 1] != -1){
                mapa[bomba.coordenades.x + 1][bomba.coordenades.y - 1] ++;
            }
        }

        if(bomba.coordenades.y == tamany - 1 && bomba.coordenades.x > 0 && bomba.coordenades.x < tamany - 1){


            /*
            [0,0,0]
            [0,0,0]
            [0,-1,0]
             */

            if(mapa[bomba.coordenades.x][bomba.coordenades.y - 1] != -1){
                mapa[bomba.coordenades.x][bomba.coordenades.y - 1] ++;
            }
            if(mapa[bomba.coordenades.x + 1][bomba.coordenades.y] != -1){
                mapa[bomba.coordenades.x + 1][bomba.coordenades.y] ++;
            }
            if(mapa[bomba.coordenades.x - 1][bomba.coordenades.y] != -1){
                mapa[bomba.coordenades.x - 1][bomba.coordenades.y] ++;
            }
            if(mapa[bomba.coordenades.x - 1][bomba.coordenades.y - 1] != -1){
                mapa[bomba.coordenades.x - 1][bomba.coordenades.y - 1] ++;
            }
            if(mapa[bomba.coordenades.x + 1][bomba.coordenades.y - 1] != -1){
                mapa[bomba.coordenades.x + 1][bomba.coordenades.y - 1] ++;
            }
        }

        if(bomba.coordenades.y == 0 && bomba.coordenades.x != 0 && bomba.coordenades.x != tamany - 1){

            if(mapa[bomba.coordenades.x][bomba.coordenades.y + 1] != -1){
                mapa[bomba.coordenades.x][bomba.coordenades.y + 1] ++;
            }
            if(mapa[bomba.coordenades.x - 1][bomba.coordenades.y] != -1){
                mapa[bomba.coordenades.x - 1][bomba.coordenades.y] ++;
            }
            if(mapa[bomba.coordenades.x + 1][bomba.coordenades.y] != -1){
                mapa[bomba.coordenades.x + 1][bomba.coordenades.y] ++;
            }
            if(mapa[bomba.coordenades.x + 1][bomba.coordenades.y + 1] != -1){
                mapa[bomba.coordenades.x + 1][bomba.coordenades.y + 1] ++;
            }
            if(mapa[bomba.coordenades.x - 1][bomba.coordenades.y + 1] != -1){
                mapa[bomba.coordenades.x - 1][bomba.coordenades.y + 1] ++;
            }

        }

        if(bomba.coordenades.x == 0 && bomba.coordenades.y == 0){

            if(mapa[bomba.coordenades.x + 1][bomba.coordenades.y + 1] != -1){
                mapa[bomba.coordenades.x + 1][bomba.coordenades.y + 1] ++;
            }
            if(mapa[bomba.coordenades.x + 1][bomba.coordenades.y] != -1){
                mapa[bomba.coordenades.x + 1][bomba.coordenades.y] ++;
            }
            if(mapa[bomba.coordenades.x][bomba.coordenades.y + 1] != -1){
                mapa[bomba.coordenades.x][bomba.coordenades.y + 1] ++;
            }
        }

        if(bomba.coordenades.x == tamany - 1 && bomba.coordenades.y == 0){

            if(mapa[bomba.coordenades.x - 1][bomba.coordenades.y] != -1){
                mapa[bomba.coordenades.x - 1][bomba.coordenades.y] ++;
            }
            if(mapa[bomba.coordenades.x - 1][bomba.coordenades.y + 1] != -1){
                mapa[bomba.coordenades.x - 1][bomba.coordenades.y + 1] ++;
            }
            if(mapa[bomba.coordenades.x][bomba.coordenades.y + 1] != -1){
                mapa[bomba.coordenades.x][bomba.coordenades.y + 1] ++;
            }
        }

        if(bomba.coordenades.x == 0 && bomba.coordenades.y == tamany - 1){

            if(mapa[bomba.coordenades.x + 1][bomba.coordenades.y] != -1){
                mapa[bomba.coordenades.x + 1][bomba.coordenades.y] ++;
            }
            if(mapa[bomba.coordenades.x + 1][bomba.coordenades.y - 1] != -1){
                mapa[bomba.coordenades.x + 1][bomba.coordenades.y - 1] ++;
            }
            if(mapa[bomba.coordenades.x][bomba.coordenades.y + 1] != -1){
                mapa[bomba.coordenades.x][bomba.coordenades.y + 1] ++;
            }
        }

        if(bomba.coordenades.x == tamany - 1 && bomba.coordenades.y == tamany - 1){

            if(mapa[bomba.coordenades.x - 1][bomba.coordenades.y - 1] != -1){
                mapa[bomba.coordenades.x - 1][bomba.coordenades.y - 1] ++;
            }
            if(mapa[bomba.coordenades.x - 1][bomba.coordenades.y] != -1){
                mapa[bomba.coordenades.x - 1][bomba.coordenades.y] ++;
            }
            if(mapa[bomba.coordenades.x][bomba.coordenades.y - 1] != -1){
                mapa[bomba.coordenades.x][bomba.coordenades.y - 1] ++;
            }
        }

    }

    public void printarMapa(){

        for (int[] ints : mapa) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
