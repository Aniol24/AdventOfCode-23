package buscaminas;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.util.Arrays;
import java.util.Random;

import static buscaminas.mapa.tamany;
import static buscaminas.mapa.mapa;

public class main {

    static JFrame f;
    static JLabel l;

    public static void main(String[] args) {

        mapa newMap = new mapa();

        newMap.crearMapa();

        window ventana = new window();

        ventana.abrirVentana();
    }
}
