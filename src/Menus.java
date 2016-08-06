public class Menus {

    private static final String reset = "\u001B[0m";
    private static final String red= "\u001B[31m";
    private static final String green = "\u001B[32m";

    protected static void getTitle(){
        System.out.println(green+"+++++++++++++++++++"+reset);
        System.out.println(green+"+++"+red+"GRAPH APP V.3"+reset+green+"+++");
        System.out.println("+++++++++++++++++++"+reset);
        System.out.println("___________________");
        System.out.println();
        System.out.println(red+"+-----------+");
        System.out.println("|"+reset+"Select lang"+red+"|");
        System.out.println("+-----------+");
        System.out.println("|"+reset+"[1].English"+red+"|");
        System.out.println("|"+reset+"[2].Spanish"+red+"|");
        System.out.println("|"+reset+"[3].Catalan"+red+"|");
        System.out.println("+-----------+"+reset);
    }

    protected static void getMenuEsp(){
        System.out.println();
        System.out.println("1.Mostrar camino corto entre dos nodos");
        System.out.println("2.Mostrar la cantidad de conexiones de un nodo");
        System.out.println("3.Mostrar de menor a mayor, cantidad de conexiones");
        System.out.println("4.Mostrar detalles del grafo");
        System.out.println("5.Mostrar búsquedas guardadas");
        System.out.println("6.Crear un grafo aleatorio");
        System.out.println("7.Visita mi GitHub");
    }

    protected static void getMenuEng(){
        System.out.println();
        System.out.println("1.Show short path between nodes");
        System.out.println("2.Show node connection quantity");
        System.out.println("3.Show in ascendent number, node connection quanti  ties");
        System.out.println("4.Show graph details");
        System.out.println("5.Show saved searches");
        System.out.println("6.Create a random graph");
        System.out.println("7.Visit my Github");
    }

    protected static void getMenuCat(){
        System.out.println();
        System.out.println("1.Mostra el camí més curt entre dos nodes");
        System.out.println("2.Mostra la quantitat de conexions d'un node");
        System.out.println("3.Mostra de menor a major, quantitat de conexions");
        System.out.println("4.Mostra detalls del graf");
        System.out.println("5.Mostra cerques guardades");
        System.out.println("6.Crear un graf aleatori");
        System.out.println("7.Visita el meu GitHub");
    }

    protected static void getGitHub(){
        String web = "https://github.com/OscarSaavedra";
        try {
            Process proc = Runtime.getRuntime().exec("\"/Program Files (x86)/Google/Chrome/Application/chrome.exe\""+web);
            proc.waitFor();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
