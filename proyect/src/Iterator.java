public class Iterator implements Iterable{
    private Node node;
    private int iterations;
    private boolean isFirstIteration;

    //--------------------------------------------- CONSTRUCTORS ---------------------------------------------//
    public Iterator(){
        this.node = null;
        this.iterations = 0;
        this.isFirstIteration = true;
    }

    /**
     * wrapper class for a node, it do not allow the user to modify it.
     * @param first
     */
    public Iterator(Node first){
        this.node = first;
        this.iterations = 0;
        this.isFirstIteration = true;

    }
    //---------------------------------------------------------------------------------------------------------
    
    /**
     * return item
     */
    public Object getItem(){
        return this.node.getItem();
    }

    public boolean setItem(Object item){
        this.node.setItem(item);
        return true;
    }

    public int getIterations(){
        return this.iterations;
    }

    /**
     * validate if a node contains data
     * @param n
     * @return true if node isn't null
     */
    private boolean validate(Node n){
        return (n != null);
    }

    /**
     * vefiry that iterator (node) is not null
     * @param none
     * @return true if iterator is not null
     */
    public boolean isValid(){
        return this.validate(this.node);
    }

    /**
     * get next item
     * @param none
     * @return next item if next node is not null
     */
    public Object peekNextItem () throws Exception{
        if( this.isValid() && this.validate(this.node.getNext())){// if current node and next node aren't null
            return this.node.getNext().getItem();// return item from next node
        }
        return null;
    }

    /**
     * returns actual index and makes the iterator points to the nextNode
     * @param none
     * @return true if is valid node
     */
    public boolean iterate(){
        if(this.isValid()){// if node is not null
            if(this.isFirstIteration){
                isFirstIteration = false;// if is first iteration,set attrivue to false
            }
            else{
                this.node = node.getNext();// else go to next node
            }
        }
        return this.isValid();// false if is null
    }

    public boolean insertAfter(Object item) throws Exception{
        if(this.isValid()){// check if node is not null
            Node newNode = new Node(item, this.node.getNext());// create new node, assign item and points next (the same node that the current node is pointed to)
            this.node.setNext(newNode);// current node now points to new node
            return true;
        }

        throw new Exception("Exception: unable to insert item after iteration ");


    }


    


}// end of class 