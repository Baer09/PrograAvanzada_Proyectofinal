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

    public boolean insertLast(Object item){
        try{
            Node newNode = new Node();// create new node
            newNode.setItem(item);// assign value to new node (item)
            if(isEmpty()){
                first = last = newNode;
            }
            else{
                last.setNext(newNode);// current last(become 1 before new lat) now points to newNode which is new Last
                last = newNode;// last points to newNode and newNode is now last and points to null.
            }
            this.totalNodes++;
            return true;            
        }catch(Exception exc){
            System.out.println("Exception in insertLast: "+ exc.getMessage());
            return false;
        }


    }
    

    /**
     * Insert a Node in an specific Index
     * @param index
     * @param item
     * @return true or  an exception.
     * @throws Exception
     */
    public boolean insert(int index, Object item) throws Exception {
        try{
            if(isEmpty()){// list is empty
                return this.insertFirst(item);
             }
             else if(this.isValidIndex(index)){// if is a valid index
                  if(index == 0){// if index is equal to first node
                      return this.insertFirst(item);
                  }
                  else if(index == totalNodes){// if index is equal to last node
                      return this.insertLast(item);
                  }
                  else{
                      Node newNode = new Node(item);// create and assign item to newNode
                      Node aux = this.getNode(index - 1);// assign previous node
                      newNode.setNext(aux.getNext());// newNode and aux points to the same Node
                      aux.setNext(newNode);//aux now points to aux to keep the linear reference.
                      this.totalNodes++;// in the other the methods already add 1 to the total Nodes, that's why we do not place it outside the brackets
                      return true;                                                          
                  }                
                
            }
            else {
                throw new Exception("Index out of List Bounds");
            }
        }// end of try
        catch(Exception exc){
            throw exc;
        }

    }
    

    public boolean isEmpty(){
        return (this.first == null);
    }
    public boolean isEndOfList(Node node){
        return (node == null);
    }
    
    private boolean isValidIndex(int index){
        return (index >= 0 && index <= this.totalNodes);
    }

    public void print(){
        Node aux = new Node();
        aux = this.first;
        int contador = 1 ;
        while(!isEndOfList(aux)){
            Object p = aux.getItem();
            System.out.println(contador + " - " + p.toString()+" .");
            aux = aux.getNext();
            contador++;           
        }

    }




    

    //--------------------------------------- SEARCH METHODS -----------------------------------------------//
    
    /**
     * get totalNodes
     * @return totalNodes
     */
    public int getLength(){
        return this.totalNodes;
    }

    public Object getFirstItem()throws Exception {
        if(this.first != null){
            return this.first.getItem();
        }
        throw new Exception("The list is Empty");        
    }

    public Object getLastItem()throws Exception{
        if(this.last != null){
            return this.last.getItem();
        }
        throw new Exception("The list is empty");
    }

    public Object getItemByPosition(int index)throws Exception{
        if(!isEmpty()){// check if is not empty list
            if(isValidIndex(index)){// verify valid index
                Node newNode = this.getNode(index);// get node by index
                return newNode.getItem();
            }
            else 
            throw new Exception("This is not a valid Index" ); 
        }
        return null;           
                  
    }

    public int getIndexOf(Object reference) throws Exception{
        if(!isEmpty()){// check if is not empty
            Node aux = this.first;//aux Node and pointed to first
            int index = 0;
            while(!isEndOfList(aux)){// continue until is not end of list
                if(aux.getItem().equals(reference)){
                    return index;
                }
                index++;
                aux = aux.getNext();

            }// end while
            
            throw new Exception("Object not found");  // unable to find node     

        }
        else{
            throw new Exception("List is empty");
        }
        

    }

    public boolean contains(Object reference){
        try {
            int index = this.getIndexOf(reference);
            return (index >= 0);
        } catch (Exception e) {
            return false;
        }
        
        
    }



    /**
     * find a Node by its index
     * @param index
     * @return return the node
     * @throws Exception
     */
    public Node getNode(int index) throws Exception{
        if(isEmpty()){
            throw new Exception("The list is empty");
        }
         else if(isValidIndex(index)){
              if(index == 1){
                  return this.first;
                }
              else if (index == (totalNodes - 1)){
                  return this.last;
                }
              else{
                  Node aux = new Node();
                  aux = first;
                  for(int i = 0; i < totalNodes;i++){
                      aux = aux.getNext();
                    }
                    return aux;
                }
                
            }
            else{
                throw new Exception("Index out of list bounds");
            }
            
        
    }    
}// End of Class.