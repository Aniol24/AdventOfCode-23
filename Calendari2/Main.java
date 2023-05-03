package Personal.Calendari2;

import java.io.*;
import java.util.Scanner;




public class Main {


    private static int total = 0;

    public static void main(String[] args) {

        File file = new File("src/main/java/Personal/Calendari2/text.txt");

        try {
            Scanner scanner = new Scanner(file);

            while(scanner.hasNext()){

                String line = scanner.nextLine();
                String[] array = line.split(" ");

                String ABC = array[0];
                String XYZ = array[1];
                total += puntuacioJugada(ABC, XYZ);

            }

            System.out.println(total);
        }
        catch(FileNotFoundException e){
            System.out.println("Error");
        }
    }

    private static int puntuacioJugada(String ABC, String XYZ) {

        int total = 0;

        if(ABC.equals("A") ){
            if(XYZ.equals("X")){
                total += 0;
                total += 3;
            }
            if(XYZ.equals("Y")){
                total += 3;
                total += 1;
            }
            if (XYZ.equals("Z")) {
                total += 6;
                total += 2;
            }
        }
        if(ABC.equals("B") ){
            if(XYZ.equals("X")){
                total += 0;
                total += 1;
            }
            if(XYZ.equals("Y")){
                total += 3;
                total += 2;
            }
            if (XYZ.equals("Z")) {
                total += 6;
                total += 3;
            }
        }
        if (ABC.equals("C")) {
            if(XYZ.equals("X")){
                total += 0;
                total += 2;
            }
            if(XYZ.equals("Y")){
                total += 3;
                total += 3;
            }
            if (XYZ.equals("Z")) {
                total += 6;
                total += 1;
            }
        }

        return total;
    }
}
