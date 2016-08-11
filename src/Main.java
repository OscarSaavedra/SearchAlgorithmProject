import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Window formulario1=new Window();
        formulario1.setBounds(10,10,1280,425);
        formulario1.setResizable(false);
        formulario1.setTitle("Graphs v3.5");
        formulario1.setVisible(true);




        Graph graph = GraphCreation.createGraph1();

        Menus.getTitle();
        int lang=sc.nextInt();
        while (true) {
            switch (lang){
                case 1:
                    Menus.getMenuEng();
                    break;
                case 2:
                    Menus.getMenuEsp();
                    break;
                case 3:
                    Menus.getMenuCat();
                    break;
                default:
                    Menus.getMenuEng();
            }

            try{
                int eleccion=sc.nextInt();
                switch (eleccion){
                    case 1:
                        System.out.println("Camino entre dos nodos");
                        System.out.println("Node 1:");
                        String nodeStart = sc.next();
                        System.out.println("Node 2:");
                        String nodeEnd = sc.next();
                        System.out.println("Cuantas comprobaciones le permites al programa?");
                        int checks = sc.nextInt();
                        try{
                            System.out.println(graph.getConexionPath(nodeStart, nodeEnd, checks));
                            System.out.println("Quieres guardar la búsqueda? (si) (no)");
                            String respuesta=sc.next();
                            if(respuesta.equals("si")){
                                System.out.println("Introduce el nombre para guardar la búsqueda");
                                String nombre=sc.next();
                                graph.setSavedSearch(nombre,new ArrayList<>(graph.getConexionPath(nodeStart, nodeEnd, checks)));
                            }
                        }catch(NullPointerException npe) {
                            System.out.println("Nombre invalido, recuerda que debes introducir una letra");
                        }
                        System.out.println("--------------------------------------");
                        break;
                    case 2:
                        System.out.println("Introduce el nodo:");
                        String node=sc.next();
                        graph.getNodeAdjacentQuantity(node);
                        System.out.println("-------------------");
                        break;
                    case 3:
                        System.out.println("De menor a mayor, cantidades de conexiones");
                        System.out.println(graph.getNodeCR());
                        System.out.println("------------------------------------------");
                        break;
                    case 4:
                        System.out.println("Número de nodos (vertices)");
                        System.out.println(graph.getNodeQuantity());
                        System.out.println("---------------");
                        System.out.println("Número de conexiones (edges)");
                        System.out.println("En proceso...");
                        //System.out.println(graph.getEdgeQuantity());
                        break;
                    case 5:
                        System.out.println("Introduce el nombre de la búsqueda");
                        String nombre=sc.next();
                        System.out.println(graph.getSavedSearch(nombre));
                        break;
                    case 6:
                        System.out.println("Cuantas conexiones quieres que se realicen");
                        int cantidad=sc.nextInt();
                        Graph rndGraph=GraphCreation.createRandomGraph(cantidad);
                        System.out.println(rndGraph);
                        break;
                    case 7:
                        Menus.getGitHub();
                }
            }catch (InputMismatchException ime){
                System.out.println("Introduce una opción válida");
                break;
            }
        }
    }
}


