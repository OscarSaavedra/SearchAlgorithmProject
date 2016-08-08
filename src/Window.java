import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame implements ActionListener,ItemListener,ChangeListener{

    private JButton button1,button2;

    private JTextField casillaNodoInic, casillaNodoDest, busquedasPermit,textField4;

    protected JTextArea resultado,textArea2,textArea3;
    private JScrollPane scrollResult;
    private JLabel label1;

    private JMenuBar mb;
    private JMenu options, menuSize,menuColor;
    private JMenuItem mi1,mi2,mi3,mi4,mi5;

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

        menuSize =new JMenu("Tamaño de la ventana");
        options.add(menuSize);
        menuColor=new JMenu("Color");
        options.add(menuColor);

        mi1=new JMenuItem("Rojo");
        mi1.addActionListener(this);
        menuColor.add(mi1);
        mi2=new JMenuItem("Verde");
        mi2.addActionListener(this);
        menuColor.add(mi2);
        mi3=new JMenuItem("Azul");
        mi3.addActionListener(this);
        menuColor.add(mi3);

        mi4=new JMenuItem("640*480");
        mi4.addActionListener(this);
        menuSize.add(mi4);
        mi5=new JMenuItem("1024*768");
        mi5.addActionListener(this);
        menuSize.add(mi5);


        button1=new JButton("Exit");
        button1.setBounds(250,300,100,30);
        add(button1);
        button1.addActionListener(this);

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

        textArea2=new JTextArea();
        textArea2.setBounds(400,300,365,40);
        textArea2.setVisible(false);
        add(textArea2);

        textArea3=new JTextArea();
        textArea3.setBounds(320,10,50,30);
        textArea3.setVisible(false);
        add(busquedasPermit);
    }

    public void actionPerformed(ActionEvent ae){


        Container f=this.getContentPane();
        if (ae.getSource()==mi1){
            f.setBackground(new Color(250,0,0));
        }
        if (ae.getSource()==mi2){
            f.setBackground(new Color(0,250,0));
        }
        if (ae.getSource()==mi3){
            f.setBackground(new Color(0,0,250));
        }

        if (ae.getSource()==mi4){
            setSize(640,480);
        }
        if(ae.getSource()==mi5){
            setSize(1024,768);
        }


        if (ae.getSource()==button1){
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
                textArea2.setVisible(true);
                textArea2.setText(graph.getNodeCR().toString());
            }
        }else{
            textArea2.setVisible(false);
        }
    }
}
