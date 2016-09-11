import com.google.common.collect.*;

import javax.swing.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.*;

public class Graph extends Window {
    private Map<String , Node> nodesByName =new HashMap<>();
    private ListMultimap<Node, Node> multimapNodeConnection = ArrayListMultimap.create();
    private ListMultimap<String, List<Node>>savedSearch=ArrayListMultimap.create();

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

        Set<Node> visited = new HashSet<>();
        Map<Node, Node> predecesor = new HashMap<>();

        List<Node> path = new LinkedList<>();
        Queue<Node> cola = new LinkedList<>();

        cola.add(primeroLista);
        visited.add(primeroLista);
        
        int numberOfChecks=1;

        List<Node>finalAddedNodes=new ArrayList<>();

        boolean encontrado=false;
            while(!cola.isEmpty()){
                primeroLista = cola.poll();
                System.out.print("Visitando el nodo:");
                System.out.println(primeroLista);
                System.out.print("El objetivo es:");
                System.out.println(nodeDestino);
                System.out.println("Comprobación número: ["+(numberOfChecks+"]"));
                System.out.println("-------------------------------------------");
                if (numberOfChecks>numberOfChecksAllowed){
                    break;
                }
                numberOfChecks++;
                if (primeroLista.equals(nodeDestino)){
                    encontrado=true;
                    System.out.println("Se han añadido "+finalAddedNodes.size()+" " +
                            "nodos en total para conseguir realizar la búsqueda: "+finalAddedNodes);
                    System.out.println();
                    break;
                }else{
                        for (Node adjacent:getAdjacents(primeroLista)) {
                            //bloque1:saber si un nodo solo tiene una conexion y no es el destino
                            boolean cond1=getAdjacents(adjacent).size()==1;
                            boolean cond2=getAdjacents(adjacent).contains(primeroLista);
                            boolean cond3=adjacent!=nodeDestino;
                            //fin bloque1

                            //bloque2:
                            //fin bloque2

                            if((!visited.contains(adjacent))&&(!((cond1)&&(cond2)&&(cond3)))){
                                visited.add(adjacent);
                                predecesor.put(adjacent, primeroLista);
                                cola.add(adjacent);
                                finalAddedNodes.add(adjacent);
                            }
                        }
                    }
                }
            if (encontrado){
                for(Node node = nodeDestino; node != null; node = predecesor.get(node)) {
                    path.add(node);
                }
                Collections.reverse(path);
                System.out.println("Se encuentran a una distancia de "+(path.size()-1));
                }else{
                    if(numberOfChecks>numberOfChecksAllowed){
                        System.out.println("La busqueda necesita mas comprobaciones");
                    }else {
                        System.out.println("No hay conexión posible o uno de los nodos no existe");
                    }
            }
            System.out.println("Camino recorrido: "+path.toString().replace(", ","-->"));
            return path;
        }

    public void setSavedSearch(String name, List<Node> searchlist){
        savedSearch.put(name,searchlist);
    }
    public List<List<Node>>getSavedSearch (String name){
        return savedSearch.get(name);
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
    public int getNodeQuantity(){
        return nodesByName.size();
    }

    @Override
    public String toString() {
        return "Graph{" +
                "nodesByName=" + nodesByName +
                ", connections=" + multimapNodeConnection +
                ", savedSearch=" + savedSearch +
                '}';
    }


    //----------------------------------------------------///////////
    //----------------------------------------------------///////////
    //----------------------------------------------------///////////
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


    /*public int  getEdgeQuantity(){
        int contador=0;
        Set<Node> visited = new HashSet<>();
        String table[]={"A","B","C","D","E",
                "F","G","H","I","J",
                "K","L","M","N","O","P"};
        for (String lista:table) {
            if (!getAdjacents((getNode(lista))).contains(visited)){
                contador=contador+(getAdjacents(getNode(lista)).size());
                Node actualVisited=getNode(lista);
                visited.add(actualVisited);
            }
        }
        return contador;
    }*/
}
