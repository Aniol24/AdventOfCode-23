package Personal.Calendari5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    private static Stack<String>[] total = new Stack[10];

    private static Stack<String> uno = new Stack<String>();
    private static Stack<String> dos = new Stack<String>();
    private static Stack<String> tres = new Stack<String>();
    private static Stack<String> cuatro = new Stack<String>();
    private static Stack<String> cinco = new Stack<String>();
    private static Stack<String> seis = new Stack<String>();
    private static Stack<String> siete = new Stack<String>();
    private static Stack<String> buit = new Stack<String>();
    private static Stack<String> nou = new Stack<String>();
    private static Stack<String> aux = new Stack<String>();



    public static void main(String[] args) {

        File file = new File("src/main/java/Personal/Calendari5/text.txt");
        int num = 0;

        try {
            Scanner scanner = new Scanner(file);

            fillStacks();

            while(!scanner.hasNextInt()){
                scanner.next();
            }
            scanner.nextLine();
            scanner.nextLine();
            scanner.nextLine();

            while(scanner.hasNextLine()){

                String line = scanner.nextLine();
                String[] split = line.split(" ");
                int qty = Integer.parseInt(split[1]);
                int org = Integer.parseInt(split[3]);
                int dest = Integer.parseInt(split[5]);

                move(qty, org,dest);

            }

            for(int j = 0; j < 9; j++){
                System.out.println(j + 1 + ". " + total[j]);
            }

        } catch (FileNotFoundException e) {
            System.out.println("ERROR");
        }
    }

    private static void move(int qty, int org, int dest) {

        for(int j = 0; j < qty; j++){

            String aux_str = total[org - 1].pop();
            total[9].push(aux_str);
        }

        for(int i = qty; i > 0; i--){

            String pop = total[9].pop();
            total[dest - 1].push(pop);
        }

    }

    private static void fillStacks() {

        uno.push("T");
        uno.push("D");
        uno.push("W");
        uno.push("Z");
        uno.push("V");
        uno.push("P");

        dos.push("L");
        dos.push("S");
        dos.push("W");
        dos.push("V");
        dos.push("F");
        dos.push("J");
        dos.push("D");

        tres.push("Z");
        tres.push("M");
        tres.push("L");
        tres.push("S");
        tres.push("V");
        tres.push("T");
        tres.push("B");
        tres.push("H");

        cuatro.push("R");
        cuatro.push("S");
        cuatro.push("J");

        cinco.push("C");
        cinco.push("Z");
        cinco.push("B");
        cinco.push("G");
        cinco.push("F");
        cinco.push("M");
        cinco.push("L");
        cinco.push("W");

        seis.push("Q");
        seis.push("W");
        seis.push("V");
        seis.push("H");
        seis.push("Z");
        seis.push("R");
        seis.push("G");
        seis.push("B");

        siete.push("V");
        siete.push("J");
        siete.push("P");
        siete.push("C");
        siete.push("B");
        siete.push("D");
        siete.push("N");

        buit.push("P");
        buit.push("T");
        buit.push("B");
        buit.push("Q");

        nou.push("H");
        nou.push("G");
        nou.push("Z");
        nou.push("R");
        nou.push("C");

        total[0] = uno;
        total[1] = dos;
        total[2] = tres;
        total[3] = cuatro;
        total[4] = cinco;
        total[5] = seis;
        total[6] = siete;
        total[7] = buit;
        total[8] = nou;
        total[9] = aux;

    }

}
