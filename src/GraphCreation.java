import java.util.ArrayList;
import java.util.Random;

public class GraphCreation {

    public static Graph createGraph1() {
        Graph graph=new Graph();
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");
        Node g = new Node("G");
        Node h = new Node("H");
        Node i = new Node("I");
        Node j = new Node("J");
        Node k = new Node("K");
        Node l = new Node("L");
        Node m = new Node("M");
        Node n = new Node("N");
        Node o = new Node("O");
        Node p = new Node("P");
        Node extra=new Node("Extra");

        graph.addNode(a);
        graph.addNode(b);
        graph.addNode(c);
        graph.addNode(d);
        graph.addNode(e);
        graph.addNode(f);
        graph.addNode(g);
        graph.addNode(h);
        graph.addNode(i);
        graph.addNode(j);
        graph.addNode(k);
        graph.addNode(l);
        graph.addNode(m);
        graph.addNode(n);
        graph.addNode(o);
        graph.addNode(p);
        graph.addNode(extra);

        graph.connect(a,b);
        graph.connect(a,c);

        graph.connect(b,a);
        graph.connect(b,h);
        graph.connect(b,g);
        graph.connect(b,p);

        graph.connect(c,a);
        graph.connect(c,d);
        graph.connect(c,g);

        graph.connect(d,e);
        graph.connect(d,c);
        graph.connect(d,f);

        graph.connect(e,d);

        graph.connect(f,d);
        graph.connect(f,h);
        graph.connect(f,g);

        graph.connect(g,f);
        graph.connect(g,c);
        graph.connect(g,h);

        graph.connect(h,f);
        graph.connect(h,g);
        graph.connect(h,b);

        graph.connect(i,l);
        graph.connect(i,m);
        graph.connect(i,j);

        graph.connect(j,i);
        graph.connect(j,k);

        graph.connect(k,j);
        graph.connect(k,m);
        graph.connect(k,n);

        graph.connect(l,i);
        graph.connect(l,m);

        graph.connect(m,i);
        graph.connect(m,l);
        graph.connect(m,k);

        graph.connect(n,k);
        graph.connect(n,o);

        graph.connect(o,p);
        graph.connect(o,n);

        graph.connect(p,o);
        graph.connect(p,b);

        graph.connect(p,extra);
        graph.connect(extra,p);
        return graph;
    }

    public static Graph createRandomGraph(int connectionsQuantity){
        Graph graph=new Graph();
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");
        Node g = new Node("G");
        Node h = new Node("H");
        Node i = new Node("I");
        Node j = new Node("J");
        Node k = new Node("K");
        Node l = new Node("L");
        Node m = new Node("M");
        Node n = new Node("N");
        Node o = new Node("O");
        Node p = new Node("P");
        graph.addNode(a);
        graph.addNode(b);
        graph.addNode(c);
        graph.addNode(d);
        graph.addNode(e);
        graph.addNode(f);
        graph.addNode(g);
        graph.addNode(h);
        graph.addNode(i);
        graph.addNode(j);
        graph.addNode(k);
        graph.addNode(l);
        graph.addNode(m);
        graph.addNode(n);
        graph.addNode(o);
        graph.addNode(p);

        ArrayList<Node>array=new ArrayList<>();
        array.add(a);
        array.add(b);
        array.add(c);
        array.add(d);
        array.add(e);
        array.add(f);
        array.add(g);
        array.add(h);
        array.add(i);
        array.add(j);
        array.add(k);
        array.add(l);
        array.add(m);
        array.add(n);
        array.add(o);
        array.add(p);


        final int arraySize=array.size();
        Random rnd=new Random();
        Random rnd2=new Random();

        for (int x = 0; x < connectionsQuantity; x++){
            int random = rnd.nextInt(arraySize);
            int random2= rnd2.nextInt(arraySize);
            graph.connect(array.get(random),array.get(random2));
        }
        return graph;
    }
}
