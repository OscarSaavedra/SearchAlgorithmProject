import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


public class Consola extends JFrame implements ActionListener {
    public static String grafoSeleccionado;
    private String sl=(String.format("%n"));
    private JFrame consolaOpc;
    private JTextArea txtResultado;
    private JScrollPane scrollTxt;

    private JMenuBar jMenuBarra;
    private JMenu archivoBarra;
    private JMenuItem opcionesBarra,guardarComo,abrir,salirBarra;

    private JButton botonGuardarConsola,boton2;

    private JFileChooser guardarOabrir;
    public Consola() {
        JPanel panel = new JPanel();

        setSize(700, 350);
        setTitle("Resultados");
        setLocation(100, 100);

        GridLayout grLayout = new GridLayout(2,1,10,10);
        FlowLayout flLayout= new FlowLayout();
        setLayout(grLayout);
        panel.setLayout(flLayout);


        guardarOabrir=new JFileChooser();
        FileNameExtensionFilter filtro=new FileNameExtensionFilter("TEXT FILES","txt","text");
        guardarOabrir.setFileFilter(filtro);

        jMenuBarra=new JMenuBar();
        setJMenuBar(jMenuBarra);
        archivoBarra =new JMenu("Archivo");
        jMenuBarra.add(archivoBarra);


        guardarComo=new JMenuItem("Guardar como...");
        archivoBarra.add(guardarComo);
        guardarComo.addActionListener(this);

        abrir=new JMenuItem("Abrir");
        archivoBarra.add(abrir);
        abrir.addActionListener(this);

        opcionesBarra=new JMenuItem("Opciones");
        archivoBarra.add(opcionesBarra);
        opcionesBarra.addActionListener(this);

        txtResultado = new JTextArea();
        txtResultado.setColumns(50);
        txtResultado.setRows(15);

        scrollTxt = new JScrollPane(txtResultado);
        add(scrollTxt);

        botonGuardarConsola = new JButton("Guardar por defecto en la carpeta del programa");
        botonGuardarConsola.addActionListener(this);
        panel.add(botonGuardarConsola);

        boton2=new JButton("Botonprueba");

        add(panel);

        System.setOut(new PrintStream(new SalidaAJtext(txtResultado)));
        System.setErr(new PrintStream(new SalidaAJtext(txtResultado)));
    }


    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==guardarComo){
            int val=guardarOabrir.showSaveDialog(Consola.this);

            if (val==guardarOabrir.APPROVE_OPTION){
                File file=guardarOabrir.getSelectedFile();
                try(FileWriter salida=new FileWriter(file+".txt")){
                    salida.append("Búsqueda en: "+grafoSeleccionado);
                    salida.append(sl);
                    salida.append(sl);
                    salida.append(txtResultado.getText());
                    //no funcionaba porque no cerraba el filewriter
                    //(ahora está autoclosable
                }catch (IOException ioe){
                    System.out.println(ioe.toString());
                    JOptionPane.showMessageDialog(null,"Error al leer el archivo");
                }
            }
        }

        if (e.getSource()==abrir){
            guardarOabrir.showOpenDialog(Consola.this);
        }


        if (e.getSource()==opcionesBarra){
            consolaOpc=new ConfigConsola();
            JFileChooser guardarventana=new JFileChooser();
            guardarventana.setVisible(true);
        }
        if (e.getSource()==botonGuardarConsola){
            File ruta=new File("C:\\Users\\"+System.getProperty("user.name")+"\\Desktop\\SAProject\\Saved");
            if (!ruta.exists()){
                ruta.mkdirs();
            }
            File archivo=new File(ruta,"save1.txt");
            try(FileWriter output=new FileWriter(archivo)){

                output.write(txtResultado.getText());
            }catch (IOException ioe){
                JOptionPane.showMessageDialog(null,"Error al leer el archivo");
            }
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

