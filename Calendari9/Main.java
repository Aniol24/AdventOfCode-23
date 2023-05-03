package Personal.Calendari9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        File file = new File("src/main/java/Personal/Calendari9/text.txt");

        String start = "S";
        String head = "H";
        String tails = "T";

        try{
            int max_r = 0;
            int max_v = 0;
            int max_h = 0;
            int max_l = 0;
            int max_u = 0;
            int max_d = 0;
            Scanner scanner = new Scanner(file);

            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] split = line.split(" ");
                int num = Integer.parseInt(split[1]);
                //System.out.println(split[1]);
                if(split[0].equals("R")){
                    max_r += num;
                    max_h += num;
                }
                if(split[0].equals("L")){
                    max_l += num;
                    max_h += num;
                }
                if(split[0].equals("U")){
                    max_v+= num;
                    max_u += num;
                }
                if(split[0].equals("D")){
                    max_v+= num;
                    max_d += num;
                }

                //System.out.println(max_h + " " + max_v);
            } //miro maximo

            String[][] matrix = new String[max_v + 1][max_h + 1];
            String[][] final_mat = new String[max_v + 1][max_h + 1];

            for (int i = 0; i < max_v + 1 ; i++) {

                for (int j = 0; j < max_h + 1; j++) {

                    matrix[i][j] = String.valueOf('.');
                }

            } //crear matriz

            for (int i = 0; i < max_v + 1; i++) {

                for (int j = 0; j < max_h + 1; j++) {

                    final_mat[i][j] = String.valueOf('.');
                }

            } //crear matriz final
            /*
            System.out.println(max_r);
            System.out.println(max_l);
            System.out.println(max_d);
            System.out.println(max_u);
            */

            int count = 0;

            count = startScript(matrix, head, tails,start, file, max_v, max_h, final_mat, max_d, max_r, max_u, max_l);

            /*for (int i = 0; i < final_mat.length; i++) {
                for (int j = 0; j < final_mat[0].length; j++) {
                    if(final_mat[i][j].equals("#")){
                        count++;
                    }
                }
            } //contar #

             */
           // System.out.println(count);
        }
        catch (FileNotFoundException e){

            System.out.println("ERROR");
        }
    }

    private static int startScript(String[][] matrix, String head, String tails,
                                    String start, File file, int max_v, int max_h,
                                    String[][] final_mat, int max_d, int max_r, int max_u,
                                    int max_l) {


        matrix[((matrix.length - 1) - max_d) - 1][max_l + 1] = head;
        int[] h_pos = new int[] {((matrix.length - 1) - max_d) - 1, max_l + 1};
        String point = ".";
        int[][] t_pos = new int[][] {
                {((matrix.length - 1) - max_d) - 1, max_l + 1},
                {((matrix.length - 1) - max_d) - 1, max_l + 1},
                {((matrix.length - 1) - max_d) - 1, max_l + 1},
                {((matrix.length - 1) - max_d) - 1, max_l + 1},
                {((matrix.length - 1) - max_d) - 1, max_l + 1},
                {((matrix.length - 1) - max_d) - 1, max_l + 1},
                {((matrix.length - 1) - max_d) - 1, max_l + 1},
                {((matrix.length - 1) - max_d) - 1, max_l + 1},
                {((matrix.length - 1) - max_d) - 1, max_l + 1},
                {((matrix.length - 1) - max_d) - 1, max_l + 1},};
                

        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        System.out.println();
        System.out.println();

        try{

            Scanner scanner = new Scanner(file);
            int count = 0;

            while(scanner.hasNextLine()){

                if(!matrix[((matrix.length - 1) - max_d) - 1][max_l + 1].equals(head) && !matrix[(matrix.length - 1) - max_d][max_l].equals(tails)){
                    matrix[((matrix.length - 1) - max_d) - 1][max_l + 1] = start;
                }

                String line = scanner.nextLine();
                String[] splited = line.split(" ");
                int move = Integer.parseInt(splited[1]);
                int[] h_anterior = new int[] {h_pos[0], h_pos[1]};
                //System.out.println(move);
                //move Heads
                matrix[h_pos[0]][h_pos[1]] = point;
                if(line.charAt(0) == 'R'){

                    for (int i = 0; i < move; i++) {

                        for (int j = 0; j < t_pos.length; j++) {

                            matrix[t_pos[i + 1][0]][t_pos[i + 1][1]] = ".";
                            matrix[t_pos[i + 1][0]][t_pos[i + 1][1] + 1] = head;
                            t_pos[i + 1][1] = t_pos[i + 1][1] + 1;

                            if(t_pos[i] != t_pos[i+1]){

                                if(!checkT(matrix,t_pos[i + 1], t_pos[i])){

                                    matrix[t_pos[i][0]][t_pos[i][1]] = ".";
                                    t_pos[i][0] = t_pos[i+1][0];
                                    t_pos[i][1] = t_pos[i+1][1] - 1;
                                    matrix[t_pos[i][0]][t_pos[i][1]] = tails;

                                    if(!final_mat[t_pos[i][0]][t_pos[i][1]].equals("#")){
                                        final_mat[t_pos[i][0]][t_pos[i][1]] = "#";
                                        count++;
                                    }

                                }
                            }
                            matrix[t_pos[i][0]][t_pos[i][1]] = tails;
                        }


                    }

                }
                if(line.charAt(0) == 'L'){
                    for (int i = 0; i < move; i++) {

                        for (int j = 0; j < t_pos.length; j++) {
                            matrix[t_pos[i + 1][0]][t_pos[i + 1][1]] = ".";
                            matrix[t_pos[i + 1][0]][t_pos[i + 1][1] - 1] = head;
                            t_pos[i + 1][1] = t_pos[i + 1][1] - 1;
                            if (t_pos[i + 1] != t_pos[i]) {
                                if (!checkT(matrix, t_pos[i + 1], t_pos[i])) {
                                    matrix[t_pos[i][0]][t_pos[i][1]] = ".";
                                    t_pos[i][0] = t_pos[i + 1][0];
                                    t_pos[i][1] = t_pos[i + 1][1] + 1;
                                    if (!final_mat[t_pos[i][0]][t_pos[i][1]].equals("#")) {
                                        final_mat[t_pos[i][0]][t_pos[i][1]] = "#";
                                        count++;
                                    }
                                    matrix[t_pos[i][0]][t_pos[i][1]] = tails;

                                }
                            }
                            matrix[t_pos[i][0]][t_pos[i][1]] = tails;
                        }
                    }

                }
                if(line.charAt(0) == 'U'){

                    for (int i = 0; i < move; i++) {
                        for (int j = 0; j < t_pos.length; j++) {
                            matrix[t_pos[i + 1][0]][t_pos[i + 1][1]] = ".";
                            matrix[t_pos[i + 1][0] - 1][t_pos[i + 1][1]] = head;
                            t_pos[i + 1][0] = t_pos[i + 1][0] - 1;
                            if (t_pos[i + 1] != t_pos[i]) {
                                if (!checkT(matrix, t_pos[i + 1], t_pos[i])) {
                                    matrix[t_pos[i][0]][t_pos[i][1]] = ".";
                                    t_pos[i][0] = t_pos[i + 1][0] + 1;
                                    t_pos[i][1] = t_pos[i + 1][1];
                                    if (!final_mat[t_pos[i][0]][t_pos[i][1]].equals("#")) {
                                        final_mat[t_pos[i][0]][t_pos[i][1]] = "#";
                                        count++;
                                    }
                                    matrix[t_pos[i][0]][t_pos[i][1]] = tails;


                                }
                            }
                        }
                        matrix[t_pos[i][0]][t_pos[i][1]] = tails;
                    }

                }
                if(line.charAt(0) == 'D'){
                    for (int i = 0; i < move; i++) {

                        for (int j = 0; j < t_pos.length; j++) {

                            matrix[t_pos[i + 1][0]][t_pos[i + 1][1]] = ".";
                            matrix[t_pos[i + 1][0] + 1][t_pos[i + 1][1]] = head;
                            t_pos[i + 1][0] = t_pos[i + 1][0] + 1;
                            if (t_pos[i + 1] != t_pos[i]) {
                                if (!checkT(matrix, t_pos[i + 1], t_pos[i])) {
                                    matrix[t_pos[i][0]][t_pos[i][1]] = ".";
                                    t_pos[i][0] = t_pos[i + 1][0] - 1;
                                    t_pos[i][1] = t_pos[i + 1][1];
                                    if (!final_mat[t_pos[i][0]][t_pos[i][1]].equals("#")) {
                                        final_mat[t_pos[i][0]][t_pos[i][1]] = "#";
                                        count++;
                                    }
                                    matrix[t_pos[i][0]][t_pos[i][1]] = tails;
                                }
                            }
                        }

                    }
                }

                System.out.println();
            }

            for (int i = 0; i < final_mat.length; i++) {
                System.out.println(Arrays.toString(final_mat[i]));
            }
            System.out.println(count + 1);

            return count;
        }
        catch(FileNotFoundException e){

            System.out.println("ERROR");
            return 0;
        }

    }

    private static boolean checkT(String[][] matrix, int[] h_pos, int[] t_pos) {

        boolean t_nextto_h = false;

        if(matrix[t_pos[0] + 1][t_pos[1]].equals("H")){
            t_nextto_h = true;
        }
        if(matrix[t_pos[0] - 1][t_pos[1]].equals("H")){
            t_nextto_h = true;
        }
        if(matrix[t_pos[0]][t_pos[1] - 1].equals("H")){
            t_nextto_h = true;
        }
        if(matrix[t_pos[0]][t_pos[1] + 1].equals("H")){
            t_nextto_h = true;
        }
        if(matrix[t_pos[0] + 1][t_pos[1] + 1].equals("H")){
            t_nextto_h = true;
        }
        if(matrix[t_pos[0] - 1][t_pos[1] + 1].equals("H")){
            t_nextto_h = true;
        }
        if(matrix[t_pos[0] + 1][t_pos[1] - 1].equals("H")){
            t_nextto_h = true;
        }
        if(matrix[t_pos[0] - 1][t_pos[1] - 1].equals("H")){
            t_nextto_h = true;
        }
        if(t_pos[0] == h_pos[0] && t_pos[1] == h_pos[1]){
            t_nextto_h = true;
        }


        return t_nextto_h;
    }
    
}
