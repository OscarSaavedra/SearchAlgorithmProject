import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;

import java.util.List;

public class Window extends JFrame implements ActionListener,ItemListener,ChangeListener{

    JFrame consola;

    private JButton botonRecorrer;
    private JTextField casillaNodoInic, casillaNodoDest, busquedasPermit,textField4,conexionesRndm;


    protected JTextArea resultado, NodeCRtextArea,textArea3;
    private JScrollPane scrollResult;
    private JLabel label1, graph1Image,graphk6image;

    private JMenuBar mb;
    private JMenu archivo,options, menuSize,menuColor,menuLenguaje,ayuda;
    private JMenuItem redOpt, greenOpt, blueOpt,
            resOpt1, resOpt2,mi6,español,ingles,ayudaItem,salir;

    private JRadioButton opc1,opc2,opc3;
    private ButtonGroup bg;

    private JList list;
    private JScrollPane listScroll;
    private String[] graphs=new String[]{"Grafo 1","Grafo 2","Grafo 3","Grafo 4",
            "Grafo 5","Grafo 6","Grafo 7","Grafo 8","Grafo aleatorio"};
    String path="C:\\Users\\"+System.getProperty("user.name")+"\\Desktop\\SAProject\\Graphs\\imagen1.jpg";
    String path2="C:\\Users\\"+System.getProperty("user.name")+"\\Desktop\\SAProject\\Graphs\\k6graph.jpg";

    String idioma;

    public Window(){
        Container ventana=getContentPane();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ventana.setLayout(null);



        idioma="Español";

        try{
            BufferedImage icon=ImageIO.read(new File("C:\\Users\\"
                    +System.getProperty("user.name")+"\\Desktop\\SAProject\\Otros\\icon.jpg"));
            setIconImage(icon);
        }catch (IOException ioe){
            System.out.println("no se puede cargar el icono");
        }

        try{
            BufferedImage image= ImageIO.read(new File(path));
            this.graph1Image =new JLabel(new ImageIcon(image));
            this.graph1Image.setVisible(false);
            this.graph1Image.setBounds(750,10,550,400);
            add(this.graph1Image);

            BufferedImage image2=ImageIO.read(new File(path2));
            this.graphk6image=new JLabel(new ImageIcon(image2));
            this.graphk6image.setVisible(false);
            this.graphk6image.setBounds(750,10,550,400);
            add(this.graphk6image);
        }catch (IOException ioe){
            System.out.println("error cargando la imágen");
        }


        list=new JList(graphs);
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL_WRAP);
        list.setVisibleRowCount(-1);


        listScroll=new JScrollPane(list);
        listScroll.setBounds(10,5,600,40);
        add(listScroll);




        opc1=new JRadioButton("Mostrar camino corto entre dos nodos");
        opc1.setBounds(400,50,325,15);
        add(opc1);
        opc1.addChangeListener(this);

        opc2=new JRadioButton("Mostrar la cantidad de conexiones de un nodo");
        opc2.setBounds(400,75,325,15);
        add(opc2);
        opc2.addChangeListener(this);

        opc3=new JRadioButton("Mostrar de menor a mayor, cantidad de conexiones");
        opc3.setBounds(400,100,324,15);
        add(opc3);
        opc3.addChangeListener(this);

        bg=new ButtonGroup();
        bg.add(opc1);
        bg.add(opc2);
        bg.add(opc3);


        mb=new JMenuBar();
        setJMenuBar(mb);

        menuLenguaje=new JMenu("Lenguaje");
        mb.add(menuLenguaje);
        options=new JMenu("Opciones");
        mb.add(options);
        archivo=new JMenu("Archivo");
        mb.add(archivo);
        archivo.add(options);
        ayuda=new JMenu("Ayuda");
        mb.add(ayuda);


        menuSize =new JMenu("Tamaño de la ventana");
        options.add(menuSize);
        menuColor=new JMenu("Color");
        options.add(menuColor);

        ayudaItem =new JMenuItem("Abrir ayuda");
        ayuda.add(ayudaItem);
        ayudaItem.addActionListener(this);

        redOpt =new JMenuItem("Rojo");
        redOpt.addActionListener(this);
        menuColor.add(redOpt);
        greenOpt =new JMenuItem("Verde");
        greenOpt.addActionListener(this);
        menuColor.add(greenOpt);
        blueOpt =new JMenuItem("Azul");
        blueOpt.addActionListener(this);
        menuColor.add(blueOpt);

        resOpt1 =new JMenuItem("640*480");
        resOpt1.addActionListener(this);
        menuSize.add(resOpt1);
        resOpt2 =new JMenuItem("1024*768");
        resOpt2.addActionListener(this);
        menuSize.add(resOpt2);
        mi6=new JMenuItem("Permitir redimensionar");
        mi6.addActionListener(this);
        menuSize.add(mi6);

        español=new JMenuItem("Español");
        español.addActionListener(this);
        ingles=new JMenuItem("Inglés");
        ingles.addActionListener(this);
        menuLenguaje.add(español);
        menuLenguaje.add(ingles);

        options.add(menuLenguaje);

        salir=new JMenuItem("Salir");
        salir.addActionListener(this);
        archivo.add(salir);


        botonRecorrer =new JButton("Recorrer");
        botonRecorrer.setBounds(250,50,100,30);
        botonRecorrer.setToolTipText("Se recorrerá el grafo");
        botonRecorrer.setVisible(false);
        add(botonRecorrer);
        botonRecorrer.addActionListener(this);


        casillaNodoInic=new JTextField("Introduce el nodo inicio");
        casillaNodoInic.setBounds(10,50,200,30);
        casillaNodoInic.setVisible(false);
        casillaNodoInic.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                casillaNodoInic.setText("");
            }
        });
        add(casillaNodoInic);

        casillaNodoDest=new JTextField("Introduce el nodo destino");
        casillaNodoDest.setBounds(10,100,200,30);
        casillaNodoDest.setVisible(false);
        casillaNodoDest.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                casillaNodoDest.setText("");
            }
        });
        add(casillaNodoDest);

        busquedasPermit=new JTextField("Cantidad de búsquedas permitidas");
        busquedasPermit.setBounds(10,150,200,30);
        busquedasPermit.setVisible(false);
        busquedasPermit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                busquedasPermit.setText("");
            }
        });
        add(busquedasPermit);

        conexionesRndm=new JTextField("Repeticiones del bucle de connexiones");
        conexionesRndm.setBounds(10,200,200,30);
        conexionesRndm.setVisible(false);
        conexionesRndm.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                conexionesRndm.setText("");
            }
        });
        add(conexionesRndm);


        textField4=new JTextField();
        textField4.setBounds(400,300,50,20);
        textField4.setVisible(false);

        add(textField4);

        label1=new JLabel();
        label1.setBounds(475,300,200,20);
        label1.setVisible(false);
        add(label1);

        resultado =new JTextArea();
        scrollResult =new JScrollPane(resultado);
        scrollResult.setBounds(10,430,1335,250);
        resultado.setVisible(false);
        scrollResult.setVisible(false);
        add(scrollResult);



        NodeCRtextArea =new JTextArea();
        NodeCRtextArea.setBounds(400,300,365,20);
        NodeCRtextArea.setVisible(false);
        add(NodeCRtextArea);

        textArea3=new JTextArea();
        textArea3.setBounds(320,10,50,30);
        textArea3.setVisible(false);
        add(textArea3);
    }


    public void actionPerformed(ActionEvent ae){

        Container f=this.getContentPane();
        if (ae.getSource()==redOpt){
            f.setBackground(new Color(250,0,0));
        }
        if (ae.getSource()==greenOpt){
            f.setBackground(new Color(0,250,0));
        }
        if (ae.getSource()==blueOpt){
            f.setBackground(new Color(0,0,250));
        }

        if (ae.getSource()==resOpt1){
            setSize(640,480);
        }
        if(ae.getSource()==resOpt2){
            setSize(1024,768);
        }

        if (ae.getSource()==salir){
            System.exit(0);
        }

        if (ae.getSource()==ingles){
            translateToEnglish();
        }

        if (ae.getSource()==mi6&&mi6.getText().equals("Bloquear redimensionado")){
            setResizable(false);
            mi6.setText("Permitir redimensionar");
        }else{
            if(ae.getSource()==mi6){
                setResizable(true);
                mi6.setText("Bloquear redimensionado");
            }
        }

        if (ae.getSource()==ayudaItem){
            helpWindow helpwi=new helpWindow();
            helpwi.setVisible(true);
        }

        if (ae.getSource()== botonRecorrer){

            consola= new Consola();
            consola.setVisible(true);

            String nodeStart= casillaNodoInic.getText();
            String nodeEnd= casillaNodoDest.getText();
            int conn=Integer.parseInt(busquedasPermit.getText());
            resultado.setText("Camino recorrido:");
            switch (list.getSelectedIndex()){
                case 0:
                    Graph graph = GraphCreation.createGraph1();
                    resultado.append(" "+graph.getConexionPath(nodeStart,nodeEnd,conn)
                            .toString().replace(", ","-->"));
                    break;
                case 1:
                    Graph graph6k=GraphCreation.k6Graph();
                    resultado.setText(" "+graph6k.getConexionPath(nodeStart,nodeEnd,conn).toString());

                    break;
                case 8:

            }
        }
    }

    public void itemStateChanged (ItemEvent ie){
    }

    public void stateChanged (ChangeEvent ce){

        Graph graph = GraphCreation.createGraph1();
        Graph k6GraphObject=GraphCreation.k6Graph();

        if (list.isSelectedIndex(0)){
                graph1Image.setVisible(true);
            Consola.grafoSeleccionado="Grafo 1";
            }else{
                graph1Image.setVisible(false);
        }

        if (list.isSelectedIndex(1)){
            graphk6image.setVisible(true);
            Consola.grafoSeleccionado="Grafo 2";
        }else{
            graphk6image.setVisible(false);
        }

        if (list.isSelectedIndex(8)){

        }

        if(opc1.isSelected()){
            if (!list.isSelectionEmpty()) {
                casillaNodoInic.setVisible(true);
                casillaNodoDest.setVisible(true);
                if (list.isSelectedIndex(8)){
                    conexionesRndm.setVisible(true);
                }else{
                    conexionesRndm.setVisible(false);
                }
                busquedasPermit.setVisible(true);
                resultado.setVisible(true);
                scrollResult.setVisible(true);
                botonRecorrer.setVisible(true);
            }
        }else{
            resultado.setVisible(false);
            scrollResult.setVisible(false);
            casillaNodoInic.setVisible(false);
            casillaNodoDest.setVisible(false);
            busquedasPermit.setVisible(false);
            botonRecorrer.setVisible(false);
        }

        if(opc2.isSelected()){
            if (!list.isSelectionEmpty()){
                textField4.setVisible(true);
                label1.setVisible(true);
                switch (list.getSelectedIndex()){
                    case 0:
                        List<Node>list=graph.getAdjacents(graph.getNode(textField4.getText()));
                        String connections=list.toString();
                        int connectionSize=list.size();
                        label1.setText(connectionSize+" conexiones: "+connections);
                        break;
                    case 1:
                        List<Node> list1=k6GraphObject.getAdjacents(k6GraphObject.getNode(textField4.getText()));
                        String connections1=list1.toString();
                        int connectionSize1=list1.size();
                        label1.setText(connectionSize1+" conexiones: "+connections1);
                }
            }
        }else{
            textField4.setVisible(false);
            label1.setVisible(false);
        }

        if (opc3.isSelected()){
            if (!list.isSelectionEmpty()) {
                list.getSelectedIndex();
                switch (list.getSelectedIndex()){
                    case 0:
                        NodeCRtextArea.setVisible(true);
                        NodeCRtextArea.setText(graph.getNodeCR().toString());
                        break;
                    case 1:
                        NodeCRtextArea.setVisible(true);
                        NodeCRtextArea.setText(k6GraphObject.getNodeCR().toString());
                        break;
                }
            }
        }else{
            NodeCRtextArea.setVisible(false);
        }
    }

    private void translateToEnglish() {
        idioma="Ingles";

        botonRecorrer.setText("Search");

        casillaNodoInic.setText("Starting node");
        casillaNodoDest.setText("Destination node");
        busquedasPermit.setText("Allowed searches");
        conexionesRndm.setText("Number of connection bucles");

        opc1.setText("Show shortest path between 2 nodes");
        opc2.setText("Show node connections quantity");
        opc3.setText("Show connection rank");

        archivo.setText("File");
        salir.setText("Exit");
        options.setText("Options");
        ayuda.setText("Help");
        ayudaItem.setText("Open help");
        menuLenguaje.setText("Language");
        español.setText("Spanish");
        ingles.setText("English");
        menuSize.setText("Window size");
        greenOpt.setText("Green");
        redOpt.setText("Red");
        blueOpt.setText("Blue");
    }
}
