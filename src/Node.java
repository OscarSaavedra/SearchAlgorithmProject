public class Node {

    public Node(String name) {
        this.name = name;
    }
    private String name;

    public String getName(){
        return name;
    }
    public String toString() {
        return "["+name+"]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        return name != null ? name.equals(node.name) : node.name == null;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
