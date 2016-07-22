import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //---------CREACIÓN GRAFO----------------//
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

        Graph graph = new Graph();
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
        //---------FINAL CREACIÓN GRAFO----------------//

        while (true) {
            System.out.println("1.Mostrar camino corto entre dos nodos");
            System.out.println("2.Mostrar la cantidad de conexiones de un nodo");
            System.out.println("3.Mostrar de menor a mayor, cantidad de conexiones");
            int eleccion=sc.nextInt();
            switch (eleccion){
                case 1:
                    System.out.println("Camino entre dos personas");
                    System.out.println("Node 1:");
                    String nodeStart=sc.next();
                    System.out.println("Node 2:");
                    String nodeEnd=sc.next();
                    System.out.println(graph.getConexionPath(nodeStart,nodeEnd));
                    System.out.println("-----------------------------------------");
                    break;
                case 2:
                    System.out.println("Introduce el nodo:");
                    String node=sc.next();
                    System.out.println(graph.getNodeAdjacentQuantity(node));
                    System.out.println("-------------------");
                    break;
                case 3:
                    System.out.println("De menor a mayor, cantidades de conexiones");
                    System.out.println(graph.getNodeCR());
                    System.out.println("------------------------------------------");
                }
            }
        }
    }


