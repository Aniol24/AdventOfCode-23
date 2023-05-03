package Personal.Calendari7;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private String name;
    private int valor;
    private List<Node> hijos;

    public Node(String name, int valor){
        this.name = name;
        this.valor = valor;
        hijos = new ArrayList<Node>();
    }

    public String getName() {
        return name;
    }

    public int getValor() {
        return valor;
    }

    public List<Node> getHijos() {
        return hijos;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void addSon(Node node){
        this.hijos.add(node);
    }

    @Override
    public String toString() {
        String str = "";

        str += "\nName: " + this.name + " ;";
        str += "Value: " + this.valor + " ";
        for (Node node : this.hijos) {
            str += "[" + node.toString() + "]";
        }

        return str;
    }
}
