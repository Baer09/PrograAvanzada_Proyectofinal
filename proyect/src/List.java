public class List implements ListInterface{

    // Attributes
    protected Node first;
    protected Node last;
    public int totalNodes;

    public List (){
        this.first = null;
        this.last = null;
        this.totalNodes = 0;
    }

    
    public boolean insertFirst(Object item){
        try {
            Node newNode = new Node();
            newNode.setItem(item);
            if(isEmpty()){
                first= last= newNode;
            }
            else{
                newNode.setNext(this.first);
                first = newNode;
            }
            totalNodes++;
            return true;
                        
        } catch (Exception e) {
            System.out.println("Exception in insertFirst " + e.getMessage());
            return false;
        }
        

    }

    public boolean isEmpty(){
        return (this.first == null);
    }
    public boolean isEndOfList(Node node){
        return (node == null);
    }
    public int getLength(){
        return this.totalNodes;
    }

    public void print(){
        Node aux = new Node();
        aux = this.first;
        int contador = 0 ;
        while(!isEndOfList(aux)){
            Object p = aux.getItem();
            System.out.println(contador + " - " + p.toString()+" .");
            aux = aux.getNext();
            contador++;           
        }

    }






    
}// End of Class.