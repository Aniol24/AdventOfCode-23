package buscaminas;

import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static buscaminas.mapa.mapa;
import static buscaminas.mapa. tamany;

public class window {

    static JFrame f;
    static JLabel l;

    public void abrirVentana(){


        f = new JFrame("BuscaMinas");

        for(int i = 0; i < tamany; i++){
            for(int j = 0; j < tamany; j++){
                JButton button = new JButton();
                button.setBounds(j * 400/tamany,i * 400/tamany,400/tamany,400/tamany);
                int finalJ = j;
                int finalI = i;
                button.addActionListener(
                        new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        if(mapa[finalI][finalJ] == -1){
                            button.setVisible(false);
                            JTextField text = new JTextField();
                            text.setForeground(Color.RED);
                            text.setText("B");
                            text.setEditable(false);
                            text.setFont(text.getFont().deriveFont(40f));
                            text.setHorizontalAlignment(JTextField.CENTER);
                            text.setBounds(finalJ * 400/tamany,finalI * 400/tamany,400/tamany,400/tamany);
                            f.add(text);

                        }
                        if(mapa[finalI][finalJ] == 0){
                            button.setVisible(false);
                        }
                        if(mapa[finalI][finalJ] != -1){
                            button.setVisible(false);
                            JTextField text = new JTextField();
                            text.setEditable(false);
                            text.setText(String.valueOf(mapa[finalI][finalJ]));
                            text.setFont(text.getFont().deriveFont(40f));
                            text.setHorizontalAlignment(JTextField.CENTER);
                            text.setBounds(finalJ * 400/tamany,finalI * 400/tamany,400/tamany,400/tamany);
                            f.add(text);

                        }
                    }
                });
                f.add(button);
            }
        }


        f.setSize(410,430);
        f.setLayout(null);
        f.show();

    }

}
