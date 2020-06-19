public class DoubleList {
    protected Multinodo first;
    protected Multinodo last;
    int contador;

    // valid transition in double list
    public static final String NEXT = "next";
    public static final String PREVIOUS = "previous";

    public DoubleList(){
        this.first = null;
        this.last = null;
        this.contador = 0;
    }

    public boolean isEmpty(){
        return this.first != null;
    }

    public boolean insertFirst(Object item)throws Exception{
        Multinodo newNode = new Multinodo(item);
        if(isEmpty()){
            this.first = newNode;
            this.last = newNode;
        }
        else{
            newNode.setTransition(NEXT, this.first);
            this.first.setTransition(PREVIOUS, newNode);
            this.first = newNode;
        }
        contador++;
        return true;
    }

    public boolean insertLast(Object item)throws Exception{
        if(isEmpty()){
            return this.insertFirst(item);
        }
        else{
            Multinodo newNode = new Multinodo(item);
            newNode.setTransition(PREVIOUS, this.last);
            this.last.setTransition(NEXT,newNode);
            this.last = newNode;
            this.contador++;
            return true;
        }
    }

    
  

    
}