package Personal.Calendari11;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Mono> monoList = new ArrayList<Mono>();
    private static List<Long> lecturaMono = new ArrayList<Long>();

    public static void main(String[] args) {

        leerInput();

        //començar

        for (int i = 0; i < 10000; i++) {

            for (int j = 0; j < monoList.size(); j++) {

                Mono mono = monoList.get(j);
                int max = mono.getObjects().size();
                int m = 0;

                while(m < max){
                    mono.throwObject(0);
                    m++;
                }

            }
            System.out.println();
            System.out.println(monoList.toString());
        }
        List<Long> array = new ArrayList<Long>();

        for (int i = 0; i < monoList.size(); i++) {
            Mono mono = monoList.get(i);
            System.out.println();
            mono.showMonkeyBussiness();

            array.add(mono.getMonkey_buss());
        }
        array.sort(Comparator.naturalOrder());

        Long final_monkey_bus = array.get(monoList.size() - 1) * array.get(monoList.size() - 2);
        System.out.println(final_monkey_bus);
    }

    private static void leerInput() {

        File file = new File("src/main/java/Personal/Calendari11/input");

        try{

            Scanner scanner = new Scanner(file);

            while(scanner.hasNextLine()){

                //LLEGIR ID
                String line = scanner.nextLine();
                String[] splited = line.split(" ");
                String[] splited2 = splited[1].split(":");
                int id = Integer.parseInt(splited2[0]);

                //LLEGIR ITEMS
                line = scanner.nextLine();
                String[] primer = line.split(" ");

                for (int i = 4; i < primer.length; i++) {

                    if(primer[i].contains(",")){
                        String[] coma = primer[i].split(",");
                        lecturaMono.add(Long.parseLong(coma[0]));
                    }
                    else{
                        lecturaMono.add(Long.parseLong(primer[i]));
                    }
                }

                //LLEGIR OPERACIÓ
                line = scanner.nextLine();
                String[] line_split = line.split(" ");
                String op = line_split[6];
                String num = line_split[7];

                //LLEGIR DIV
                line = scanner.nextLine();
                String[] line_split2 = line.split(" ");
                Long div = Long.parseLong(line_split2[5]);

                //LLEGIR IF TRUE
                line = scanner.nextLine();
                String[] line_split3 = line.split(" ");
                int if_true = Integer.parseInt(line_split3[9]);
                //LLEGIR IF FALSE
                line = scanner.nextLine();
                String[] line_split4 = line.split(" ");
                int if_false = Integer.parseInt(line_split4[9]);

                Mono mono = new Mono(id,op,num,div,if_true,if_false);

                for (int i = 0; i < lecturaMono.size(); i++) {
                    mono.addObject(lecturaMono.get(i));
                }

                monoList.add(mono);
                lecturaMono.clear();

                if(scanner.hasNextLine()){
                    scanner.nextLine();
                }

            }
            System.out.println(monoList.toString());
        }
        catch(FileNotFoundException e){

            System.out.println("ERROR");
        }


    }
}

