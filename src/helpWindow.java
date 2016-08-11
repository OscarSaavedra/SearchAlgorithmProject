import javax.swing.*;
import java.awt.*;

public class helpWindow extends JFrame {
    private JLabel label1,label2,label3;

    public helpWindow(){
        setLayout(null);
        setTitle("Acerca del programa");
        setBounds(10,10,600,400);


        label1=new JLabel("-El programa tiene por defecto 10 grafos");
        label1.setBounds(10,10,500,30);
        add(label1);

        label2=new JLabel("-A la derecha encontrarás la representación del grafo (en proceso)");
        label2.setBounds(10,40,500,30);
        add(label2);

        label3=new JLabel("-La función \"grafo aleatorio\" puede resultar direccionado o no");
        label3.setBounds(10,70,500,30);
        add(label3);
    }
}
