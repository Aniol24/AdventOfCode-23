package Personal.Calendari11;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static Personal.Calendari11.Main.monoList;

public class Mono {

    private int id;

    private String operation_type;

    private String operation_num;

    private Long divisible;

    private int if_true;

    private int if_false;

    private List<Long> objects;

    private Long monkey_buss = 0L;

    public Mono(int id, String operation_type, String operation_num, Long divisible, int if_true, int if_false) {
        this.id = id;
        this.operation_type = operation_type;
        this.operation_num = operation_num;
        this.divisible = divisible;
        this.if_true = if_true;
        this.if_false = if_false;
        objects = new ArrayList<Long>();
    }

    public void addObject(Long object){

        this.objects.add(object);

    }

    @Override
    public String toString() {
        return "Mono{"+ " " + id + " " +
                "objects=" + objects +
                '}' + " " + divisible;
    }

    public List<Long> getObjects() {
        return objects;
    }

    public void throwObject(int item){

        Long object = objects.get(item);
        boolean divi = false;
        Long nuevo = 0L;

        if(this.operation_type.equals("*")){

            nuevo = object * getNumOp(object);
        }
        if(this.operation_type.equals("+")){

            nuevo = object + getNumOp(object);
        }

        divi = checkDivi(nuevo, divisible);
        this.addMonBuss();

        if(divi){
            Mono new_mono = monoList.get(if_true);
            new_mono.addObject(nuevo);
        }
        if(!divi){
            Mono new_mono = monoList.get(if_false);
            //System.out.println("MONO: " + id + "OBJETO FALSE: " + object + " DIVISION: " + divisible);
            //System.out.println();
            new_mono.addObject(nuevo);
        }

        objects.remove(item);
    }

    private Long getNumOp(Long object) {

        if(operation_num.contains("old")){
            return object;
        }
        else{
            return Long.parseLong(operation_num);
        }
    }

    private boolean checkDivi(Long object, Long divisible){

        //System.out.println(object + " " + divisible);
        //System.out.println("checkDiv" + object % divisible);
        //System.out.println();
        if(object % divisible == 0){
            return true;
        }
        else{
            return false;
        }

    }
    public void addMonBuss(){
        monkey_buss++;
    }

    public void showMonkeyBussiness(){
        System.out.println("Monkey " + id + " inspected " + monkey_buss + " items");
    }

    public Long getMonkey_buss() {
        return monkey_buss;
    }
}
