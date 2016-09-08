import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.OutputStream;
import java.io.PrintStream;


public class Consola extends JFrame implements ActionListener {

    public JFrame consolaOpc;
    public JTextArea txtResultado;
    public JScrollPane scrollTxt;

    public JMenuBar jMenuBarra;
    public JMenu archivoBarra;
    public JMenuItem opcionesBarra,salirBarra;

    public JButton botonGuardarConsola,boton2;


    public Consola() {
        JPanel panel = new JPanel();

        setSize(700, 350);
        setTitle("Resultados");
        setLocation(100, 100);

        GridLayout grLayout = new GridLayout(2,1,10,10);
        FlowLayout flLayout= new FlowLayout();
        setLayout(grLayout);
        panel.setLayout(flLayout);


        jMenuBarra=new JMenuBar();
        setJMenuBar(jMenuBarra);
        archivoBarra =new JMenu("Archivo");
        jMenuBarra.add(archivoBarra);

        opcionesBarra=new JMenuItem("Opciones");
        archivoBarra.add(opcionesBarra);
        opcionesBarra.addActionListener(this);
        salirBarra=new JMenuItem("Salir");
        salirBarra.addActionListener(this);
        salirBarra.add(new JSeparator());
        archivoBarra.add(salirBarra);



        txtResultado = new JTextArea();
        txtResultado.setColumns(50);
        txtResultado.setRows(15);
        txtResultado.setText("...");

        scrollTxt = new JScrollPane(txtResultado);
        add(scrollTxt,BorderLayout.SOUTH);

        botonGuardarConsola = new JButton("Guardar");
        botonGuardarConsola.addActionListener(this);
        panel.add(botonGuardarConsola);

        boton2=new JButton("Botonprueba");

        add(panel);

        System.setOut(new PrintStream(new SalidaAJtext(txtResultado)));
        System.setErr(new PrintStream(new SalidaAJtext(txtResultado)));
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==opcionesBarra){
            consolaOpc=new ConfigConsola();
        }

    }

    public class SalidaAJtext extends OutputStream {
        JTextArea t;

        public SalidaAJtext(JTextArea t) {
            super();
            this.t = t;
        }

        public void write(int i) {
            t.append(Character.toString((char) i));
        }

        public void write(char[] buf, int off, int len) {
            String s = new String(buf, off, len);
            t.append(s);
        }
    }
}

