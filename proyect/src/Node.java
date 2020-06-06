
public class Node {
    private Object item;
    private Node next;

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