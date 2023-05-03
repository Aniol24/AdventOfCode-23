package Personal.Calendari10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static int total;
    private static String[] sprite_pos = new String[40];
    private static String[][] CRT = new String[][]{
            {".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",},
            {".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",},
            {".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",},
            {".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",},
            {".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",},
            {".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",},};

    private static int resta_cycle = 0;

    private static int act_pos = 0;

    public static void main(String[] args) {
        Arrays.fill(sprite_pos, ".");
        File file = new File("src/main/java/Personal/Calendari10/input");
        int x = 1;
        int cycle = 0;
        int volta = 1;
        int ant_num = 0;
        int new_num = 0;
        int sum = 0;
        sprite_pos[0] = "#";
        sprite_pos[1] = "#";
        sprite_pos[2] = "#";

        try{

            Scanner scanner = new Scanner(file);
            for (int i = 0; i < volta; i++) {

                if(scanner.hasNextLine()){

                    if(i == 0){

                        String line = scanner.nextLine();
                        String[] line_split = line.split(" ");
                        if(line_split[0].equals("noop")){
                            cycle++;
                            i = -1;
                            new_num = 0;
                            drawCRT(cycle);
                        }
                        if(line_split[0].equals("addx")){

                            cycle++;
                            new_num = Integer.parseInt(line_split[1]);
                            volta = 2;
                            drawCRT(cycle);
                        }
                        if(sum == 1){
                            x+= ant_num;
                            sum = 0;
                        }

                    }
                    else if(i == 1){
                        cycle++;
                        drawCRT(cycle);
                        ant_num = new_num;
                        sum = 1;
                        i = -1;
                        moveSprite(new_num);
                    }

                    sumTotal(cycle, x);
                }
            }

            for (int i = 0; i < CRT.length; i++) {
                System.out.println(Arrays.toString(CRT[i]));
            }
        }
        catch(FileNotFoundException e){

            System.out.println("ERROR");
        }
    }

    private static void moveSprite(int new_num) {

        Arrays.fill(sprite_pos, ".");
        //System.out.println(new_num);
        act_pos = act_pos + new_num;

        for (int i = act_pos; i <= act_pos + 2; i = i+1) {

            if(i < 0 || i > sprite_pos.length - 1){
                System.out.println("error");
            }
            else{
                sprite_pos[i] = "#";
            }


        }

        //.out.println(Arrays.toString(sprite_pos));

    }

    private static void drawCRT(int cycle) {

        int CRT_line = getCRTline(cycle);

        cycle = cycle - resta_cycle;

        System.out.println(sprite_pos[cycle - 1]);
        System.out.println(Arrays.toString(sprite_pos));
        System.out.println(cycle);

        if(sprite_pos[cycle - 1].equals("#")){


            CRT[CRT_line][cycle - 1] = "#";
        }
        else{
            CRT[CRT_line][cycle - 1] = ".";
        }

    }

    private static int getCRTline(int cycle) {

        int CTR_line = 7;

        if(cycle <= 40){
            CTR_line = 0;
            resta_cycle = 0;
        }
        if(cycle > 40 && cycle <= 80){
            CTR_line = 1;
            resta_cycle = 40;
        }
        if(cycle > 80 && cycle <= 120){
            CTR_line = 2;
            resta_cycle = 80;
        }
        if(cycle > 120 && cycle <= 160){
            CTR_line = 3;
            resta_cycle = 120;
        }
        if(cycle > 160 && cycle <= 200){
            CTR_line = 4;
            resta_cycle = 160;
        }
        if(cycle > 200 && cycle <= 240){
            CTR_line = 5;
            resta_cycle = 200;
        }
        return CTR_line;
    }

    private static void sumTotal(int cycle, int x) {

        if(cycle == 20 || cycle == 60 || cycle == 100  || cycle == 180 || cycle == 140|| cycle == 220){

            total += x * cycle;
        }

    }

}
