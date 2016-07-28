import com.google.common.collect.*;
import java.util.*;

public class Graph {
    private Map<String , Node> nodesByName =new HashMap<>();
    private ListMultimap<Node, Node> multimapNodeConnection = ArrayListMultimap.create();

    public void addNode(Node node){
        nodesByName.put(node.getName(), node);
    }
    public void connect(Node node, Node anotherNode){
        multimapNodeConnection.put(node, anotherNode);
    }
    public Node getNode(String name){
        return nodesByName.get(name);
    }
    public List<Node> getAdjacents(Node node){
        return (multimapNodeConnection.get(node));
    }

    public List<Node> getConexionPath(String nodeStart, String nodeEnd,Integer numberOfChecksAllowed) {
        Node primeroLista= nodesByName.get(nodeStart);
        Node nodeDestino = nodesByName.get(nodeEnd);

        Set<Node> visitado = new HashSet<>();
        Map<Node, Node> predecesor = new HashMap<>();

        List camino = new LinkedList();
        Queue<Node> cola = new LinkedList<>();

        cola.add(primeroLista);
        visitado.add(primeroLista);
        
        int numberOfChecks=1;

        boolean encontrado=false;
            while(!cola.isEmpty()){
                primeroLista = cola.poll();
                System.out.print("Visitando el nodo:");
                System.out.println(primeroLista);
                System.out.print("El objetivo es:");
                System.out.println(nodeDestino);
                System.out.println("Comprobación número: ["+(numberOfChecks+"]"));
                System.out.println("-------------------------------------");
                if (numberOfChecks>numberOfChecksAllowed){
                    break;
                }
                numberOfChecks++;
                if (primeroLista.equals(nodeDestino)){
                    encontrado=true;
                    break;
                }else{
                        for (Node adjacent:getAdjacents(primeroLista)) {
                            if(!visitado.contains(adjacent)){
                                cola.add(adjacent);
                                visitado.add(adjacent);
                                predecesor.put(adjacent, primeroLista);
                            }
                        }
                    }
                }
            if (encontrado){
                for(Node node = nodeDestino; node != null; node = predecesor.get(node)) {
                    camino.add(node);
                }
                Collections.reverse(camino);
                System.out.println("Se encuentran a una distancia de "+(camino.size()-1));
                }else{
                    if(numberOfChecks>numberOfChecksAllowed){
                        System.out.println("La busqueda necesita mas comprobaciones");
                    }else {
                        System.out.println("No hay conexión posible o uno de los nodos no existe");
                    }
            }
            return camino;
        }
    public void getNodeAdjacentQuantity(String node){
        Node n=getNode(node);
        if (n!=null){
            List<Node>adjacentNodes= getAdjacents(n);
            System.out.println(adjacentNodes.size()+", los cuales son "+adjacentNodes);
        }else
            System.out.println("El nodo no existe");
    }

    public List <Node> getNodeCR(){
        List <Node>nodeList=new ArrayList<>(nodesByName.values());
        Collections.sort(nodeList, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                int num1=getAdjacents(o1).size();
                int num2=getAdjacents(o2).size();
                if (num1<num2){
                    return -1;
                }else if (num1>num2){
                    return 1;
                }else{
                    return 0;
                }
            }
        });
        return nodeList;
    }


    //Experimental methods (not working yet)
    /*public Integer experimental(String n1,String n2) {
        Node primeroLista= nodesByName.get(n1);
        Node nodeDestino = nodesByName.get(n2);

        HashBiMap<Integer, Node>distanciaDeInicio=HashBiMap.create();
        int distancia=0;
        distanciaDeInicio.put(0,primeroLista);

        Queue<Node> cola=new LinkedList<>();
        HashSet<Node> visitado = new HashSet<>();
        visitado.add(primeroLista);

        globalLoop:
        while (primeroLista != null) {
            distancia++;
            for (Node adjacents : getAdjacents(primeroLista)) {
                if (adjacents.equals(nodeDestino)) {
                    distanciaDeInicio.put(distancia, nodeDestino);
                    break globalLoop;
                }
                if (!visitado.contains(adjacents)) {
                    visitado.add(adjacents);
                    cola.offer(adjacents);
                    distanciaDeInicio.put(distancia,adjacents);
                }
            }
            primeroLista = cola.poll();
        }
        return distanciaDeInicio.inverse().get(nodeDestino);
    }*/
}
