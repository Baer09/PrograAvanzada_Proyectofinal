
public class Node {
    private Object item;
    private Node next;

    public Node(){
        this.item = null;
        this.next = null;
    }

    public Node(Object item){
        this.setItem(item);
        this.setNext(null);
    }

    public void setItem(Object item){
        this.item = item;
    }
    public void setNext(Node next){
        this.next = next;
    }

    public Object getItem(){
        return this.item;
    }
    public Node getNext(){
        return this.next;
    }
    
}