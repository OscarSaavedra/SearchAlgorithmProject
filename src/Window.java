import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame implements ActionListener,ItemListener,ChangeListener{

    private JButton exitButton,button2;
    private JTextField casillaNodoInic, casillaNodoDest, busquedasPermit,textField4;



    protected JTextArea resultado, NodeCRtextArea,textArea3;
    private JScrollPane scrollResult;
    private JLabel label1;

    private JMenuBar mb;
    private JMenu options, menuSize,menuColor,ayuda;
    private JMenuItem redOpt, greenOpt, blueOpt, resOpt1, resOpt2,mi6,ayudaItem;

    private JRadioButton opc1,opc2,opc3;
    private ButtonGroup bg;

    private JList list;
    private JScrollPane listScroll;
    private String[] graphs=new String[]{"Grafo 1","Grafo 2","Grafo 3","Grafo aleatorio","Grafo 4",
            "Grafo 5","Grafo 6","Grafo 7","Grafo 8"};




    public Window(){
        setLayout(null);

        list=new JList(graphs);
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL_WRAP);
        list.setVisibleRowCount(-1);

        listScroll=new JScrollPane(list);
        listScroll.setBounds(10,5,300,40);
        add(listScroll);

        opc1=new JRadioButton("Mostrar camino corto entre dos nodos");
        opc1.setBounds(400,50,400,15);
        add(opc1);
        opc1.addChangeListener(this);

        opc2=new JRadioButton("Mostrar la cantidad de conexiones de un nodo");
        opc2.setBounds(400,75,400,15);
        add(opc2);
        opc2.addChangeListener(this);

        opc3=new JRadioButton("Mostrar de menor a mayor, cantidad de conexiones");
        opc3.setBounds(400,100,400,15);
        add(opc3);
        opc3.addChangeListener(this);

        bg=new ButtonGroup();
        bg.add(opc1);
        bg.add(opc2);
        bg.add(opc3);


        mb=new JMenuBar();
        setJMenuBar(mb);

        options=new JMenu("Opciones");
        mb.add(options);
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


        exitButton =new JButton("Exit");
        exitButton.setBounds(250,300,100,30);
        add(exitButton);
        exitButton.addActionListener(this);

        button2=new JButton("Recorrer");
        button2.setBounds(250,50,100,30);
        button2.setToolTipText("Se recorrerá el grafo");
        button2.setVisible(false);
        add(button2);
        button2.addActionListener(this);


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
        scrollResult.setBounds(10,200,200,130);
        resultado.setVisible(false);
        scrollResult.setVisible(false);
        add(scrollResult);

        NodeCRtextArea =new JTextArea();
        NodeCRtextArea.setBounds(400,300,365,40);
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

        if (ae.getSource()==exitButton){
            System.exit(0);
        }

        if (ae.getSource()==button2){
            String nodeStart= casillaNodoInic.getText();
            String nodeEnd= casillaNodoDest.getText();
            int conn=Integer.parseInt(busquedasPermit.getText());
            Graph graph = GraphCreation.createGraph1();
            resultado.setText(graph.getConexionPath(nodeStart,nodeEnd,conn).toString());

        }
    }

    public void itemStateChanged (ItemEvent ie){
    }

    public void stateChanged (ChangeEvent ce){
        if(opc1.isSelected()){
            if (list.isSelectedIndex(0)) {
                resultado.setVisible(true);
                scrollResult.setVisible(true);
                casillaNodoInic.setVisible(true);
                casillaNodoDest.setVisible(true);
                busquedasPermit.setVisible(true);
                button2.setVisible(true);
            }
        }else{
            resultado.setVisible(false);
            scrollResult.setVisible(false);
            casillaNodoInic.setVisible(false);
            casillaNodoDest.setVisible(false);
            busquedasPermit.setVisible(false);
            button2.setVisible(false);
        }

        if(opc2.isSelected()){
            if (list.isSelectedIndex(0)){
                Graph graph = GraphCreation.createGraph1();
                textField4.setVisible(true);
                label1.setVisible(true);
                String connections=graph.getAdjacents(graph.getNode(textField4.getText())).toString();
                int connectionSize=graph.getAdjacents(graph.getNode(textField4.getText())).size();
                label1.setText(connectionSize+" conexiones: "+connections);
            }
        }else{
            textField4.setVisible(false);
            label1.setVisible(false);
        }

        if (opc3.isSelected()){
            if (list.isSelectedIndex(0)) {
                Graph graph = GraphCreation.createGraph1();
                NodeCRtextArea.setVisible(true);
                NodeCRtextArea.setText(graph.getNodeCR().toString());
            }
        }else{
            NodeCRtextArea.setVisible(false);
        }
    }
}
