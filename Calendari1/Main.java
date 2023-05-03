package Personal.Calendari1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        File file = new File("src/main/java/Personal/Calendari1/text.txt");
        int num = 0;
        int tot = 0;
        int[] array = new int[2236];
        int i = 0;
        boolean max_found = false;
        int max = 0;

        try{
            Scanner scanner = new Scanner(file);

            while(scanner.hasNextLine()){

                String value = scanner.nextLine();

                if(value.isEmpty()){
                    array[i] = tot;
                    tot = 0;
                    i++;
                }
                else{
                    num = Integer.parseInt(value);
                    tot = tot + num;
                    System.out.println(num);
                }
            }
            Arrays.sort(array);
            max = array[array.length - 1] + array[array.length - 2] + array[array.length - 3];
            System.out.println(max);

        }
        catch(FileNotFoundException e){

            System.out.println("Error");
        }


    }
}
