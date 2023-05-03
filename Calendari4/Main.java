package Personal.Calendari4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File ("src/main/java/Personal/Calendari4/text.txt");

        try{
            int tot = 0;
            Scanner scanner = new Scanner(file);

            while(scanner.hasNext()){

                String array =  scanner.nextLine();

                String[] pair = array.split(",");

                String first = pair[0];
                String second = pair[1];

                int[] firstArray = convertToArray(first);
                int[] secondArray = convertToArray(second);

                boolean contains = checkSolution(firstArray, secondArray);
                if(contains){
                    tot ++;
                }

            }
            System.out.println(tot);
        }
        catch(FileNotFoundException e){

            System.out.println("ERROR");
        }
    }

    private static boolean checkSolution(int[] firstArray, int[] secondArray) {

        int i = 0;
        int j = 0;
        boolean found_first = false;
        boolean found_second = false;

        while(i < firstArray.length){

            j = 0;
            while(j < secondArray.length && !found_first){

                if(firstArray[i]==secondArray[j] && !found_first){
                    found_first = true;
                    return true;
                }
                j++;
            }
            i++;
        }

        return false;
    }

    private static int[] convertToArray(String cadena) {

        String[] split_cadena = cadena.split("-");

        String first = split_cadena[0];
        String second = split_cadena[1];

        int i = Integer.parseInt(first);
        int fin = Integer.parseInt(second);
        int[] newArray = new int[Math.abs((fin - i) + 1)];
        int j = 0;

        while(i <= fin){

            newArray[j] = i;
            j++;
            i++;
        }


        System.out.println(Arrays.toString(newArray));
        return newArray;
    }
}
