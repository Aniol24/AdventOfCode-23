
package Personal.Calendari3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File("src/main/java/Personal/Calendari3/text.txt");
        int i = 0;
        int j = 0;
        int k = 0;
        boolean found = false;
        int total = 0;
        try{

            Scanner scanner = new Scanner(file);

            while(scanner.hasNext()){

                String linea = scanner.nextLine();
                String lineados = scanner.nextLine();
                String lineatres = scanner.nextLine();
                System.out.println(lineados);
                System.out.println(linea);
                System.out.println(lineatres);
                System.out.println();


                i = 0;
                found = false;

                while(i < linea.length() && !found){

                    j = 0;
                    while(j < lineados.length() && !found){

                        if(linea.charAt(i) == lineados.charAt(j)){

                            k = 0;
                            while(k < lineatres.length() && !found){

                                if(lineatres.charAt(k) == lineados.charAt(j) ){

                                    total = total + chackPuntuacio(String.valueOf(linea.charAt(i)));
                                    //System.out.println(total);
                                    found = true;
                                }
                                k++;
                            }
                        }
                        j++;
                    }
                    i++;
                }

            }

            System.out.println(total);

        }
        catch(FileNotFoundException e){
            System.out.println("ERROR");
        }
    }

    private static int chackPuntuacio(String lletra) {
        int num = 0;

        if(Character.isUpperCase(lletra.charAt(0))){
            num = lletra.charAt(0) - 38;
        }
        else{
            num = lletra.charAt(0) - 96;
        }
        System.out.println(num);

        return num;
    }
}
