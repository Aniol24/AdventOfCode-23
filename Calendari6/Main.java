package Personal.Calendari6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        File file = new File("src/main/java/Personal/Calendari6/text.txt");

        try{

            int i = 0;
            boolean error = false;
            boolean end = false;

            Scanner scanner = new Scanner(file);

            String full = scanner.next();

            while(i < full.length() && !error && !end){

                if(full.length() - i < 14){
                    error = true;
                }
                else{

                    end = checkIfSamePack(i, i+1, i+2, i + 13, full);
                }
                i++;
            }
            i = i + 3;
            i = i + 10;
            System.out.println(i);
        }
        catch(FileNotFoundException e){
            System.out.println("Error");
        }
    }

    public static boolean areDistinct(Integer arr[]){

        for (int i = 0; i < arr.length - 1; i++){
            for (int j = i + 1; j < arr.length; j++){
                if(Objects.equals(arr[i], arr[j])){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkIfSamePack(int i, int i1, int i2, int i3,String full) {

        Integer[] array = new Integer[14];
        int k = 0;
        //System.out.println(i);
        //System.out.println(i3);

        for (int j = i; j <= i3; j++ ){

            array[k] = (int) full.charAt(j);
            k++;
        }

        return areDistinct(array);

    }
}
