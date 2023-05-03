package Personal.Calendari7;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.*;
import java.util.concurrent.DelayQueue;

public class Main {


    private static List<Integer> array = new ArrayList<Integer>();

    public static void main(String[] args) {

        File file = new File("src/main/java/Personal/Calendari7/text.txt");
        List<Node> arbol = new ArrayList<Node>();
        boolean end = false;


        try{

            Scanner scanner = new Scanner(file);
            String line = scanner.nextLine(); //em poso al cd /
            int total_barra = 0;

            while(scanner.hasNextLine()){ //mientras se pueda leer

                if(line.contains("..")){ //si te .. el salto fins arribr al cd
                    while(line.contains("..")){
                        line = scanner.nextLine();
                    }
                }
                String[] split = line.split(" ");//agafo el nom del directori
                String name = split[2];
                Node node = new Node(name,0); //creo el node del directori

                line = scanner.nextLine(); //llegeixo ls

                line = scanner.nextLine(); //llegim primer fitxer o directori

                while(!(line.charAt(0) == '$') && !end){ //mentre no hi hagi una altra comanda

                    if(line.contains("dir")){ // si la linea es un directori l'afegim com a fill

                        Node new_node = new Node(line,0);
                        node.addSon(new_node);
                    }

                    else{ // si es un fitxer, sumem el valor del fitxer al driectori

                        String[] splited = line.split(" ");
                        node.setValor(node.getValor() + Integer.parseInt(splited[0]));

                    }
                    if(scanner.hasNextLine()){ //si hi ha més lineas per llegir, seguim llegin
                        line = scanner.nextLine();
                        //System.out.println(line);
                    }
                    else{ //si no hi ha més lineas s'acaba el programa
                        end = true;
                    }
                }

                arbol.add(node);
            }

            int total = 0;

            ListIterator<Node> it = arbol.listIterator();
            Node aux = it.next();
            int num = 0;
            while(it.hasNext()){
                num = sum(arbol, it);
                total += num;
            }
            int fina = 0;

            ListIterator<Node> it2 = arbol.listIterator();

            array.add(total + aux.getValor());

            for (int i = 0; i < array.size(); i++) {

                if(array.get(i) <= 100000){

                    fina += array.get(i);
                }
            }

            System.out.println(array.toString());
            System.out.println(fina);
        }
        catch(FileNotFoundException e){
            System.out.println("Error");
        }



    }

    private static int sum(List<Node> arbol, ListIterator<Node> it){

        Node aux = it.next();

        int num = 0;

        if(aux.getHijos().size() == 0){
            //System.out.println(aux.getName());
            num = num + aux.getValor();
            //System.out.println(num);
            array.add(num);
            return num;
        }
        else {
            num = sum(arbol, it) + aux.getValor();
            array.add(num);
            return num;
        }

    }
}
