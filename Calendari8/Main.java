package Personal.Calendari8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<List<Integer>> array = new ArrayList<List<Integer>>();

    public static void main(String[] args) {

        File file = new File("src/main/java/Personal/Calendari8/text.txt");

        int j = 0;

        int tot = 0;
        int lat = 0;
        int max = 0;
        int esc = 0;

        try{

            Scanner scanner = new Scanner(file);

            while(scanner.hasNextLine()){

                String line = scanner.nextLine();
                array.add(new ArrayList<Integer>());

                for (int i = 0; i < line.length(); i++) {

                    array.get(j).add(Integer.parseInt(String.valueOf(line.charAt(i))));
                }

                j++;
            } //creació de l'array

            //System.out.println(array.toString());

            tot = array.size();
            int num = tot;
            tot += (num - 1) * 2;
            tot += num - 2;

            for (int i = 1; i < array.get(1).size() - 1; i++) {
                for (int k = 1; k < array.size() - 1; k++) {

                    int numero = array.get(i).get(k);

                    boolean top_is = true;
                    boolean bot_is = true;
                    boolean r_is = true;
                    boolean left_is = true;

                    int num_top = 0;
                    int num_bot = 0;
                    int num_r = 0;
                    int num_l = 0;

                    int top = array.get(i - 1).get(k);
                    for (int m = i - 1; m >= 0 ; m--) {

                        top = array.get(m).get(k);
                        if (numero <= top) {
                            top_is = false;
                            num_top += 1;
                            break;
                        }
                        else{
                            num_top += 1;
                        }
                    }

                    int bot = array.get(i + 1).get(k);
                    for (int m = i + 1; m < array.size(); m++) {
                        bot = array.get(m).get(k);
                        if (numero <= bot) {
                            bot_is = false;
                            num_bot += 1;
                            break;
                        }
                        else{
                            num_bot += 1;
                        }
                    }

                    int r = array.get(i).get(k + 1);
                    for (int m = k + 1; m < array.get(i).size(); m++) {

                        r = array.get(i).get(m);
                        if (numero <= r) {
                            r_is = false;
                            num_r += 1;
                            break;
                        }
                        else{
                            num_r += 1;
                        }
                    }

                    int l = array.get(i).get(k - 1);
                    for (int m = k - 1; m >= 0 ; m--) {

                        l = array.get(i).get(m);
                        if (numero <= l) {
                            left_is = false;
                            num_l += 1;
                            break;
                        }
                        else{
                            num_l += 1;
                        }
                    }

                    esc = num_top * num_bot * num_r * num_l;

                    if(esc > max){
                        max = esc;
                    }
                    //System.out.println(numero + " " + esc);
                }
            } //mirar costats

            System.out.println(max);
        }
        catch (FileNotFoundException e){
            System.out.println("error");
        }

    }
}
