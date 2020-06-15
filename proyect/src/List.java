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

    public boolean insert(Object item) throws Exception{
        return this.insertLast(item);
    }

    

    public boolean isEmpty(){
        return (this.first == null);
    }
    public boolean isEndOfList(Node node){
        return (node == null);
    }
    
    private boolean isValidIndex(int index){
        return (index > 0 && index <= this.totalNodes);
    }

    public void print(){
        Node aux = new Node();
        aux = this.first;
        int contador = 1 ;
        while(!isEndOfList(aux)){
            Object p = aux.getItem();
            System.out.println(contador + " - " +"Total Nodes: "+this.totalNodes+" "+ p.toString()+" .");
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
            int index = 1;
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
              else if (index == (totalNodes)){
                  return this.last;
                }
              else{
                  Node aux = new Node();
                  aux = first;
                  //System.out.println(" aux : " + aux.getItem());
                  for(int i = 1; i < index; i++){
                      aux = aux.getNext();
                     // System.out.println("node inside FOR: " + aux.getItem());
                    }
                    return aux;
                }
                
            }
            else{
                throw new Exception("Index out of list bounds");
            }
            
        
    }    

//---------------------------------- DELETE METHODS -------------------------------------------------------//
/**
 * Delete first element in the list
 * @return deleted Object
 * @throws Exception
 */
public Object deleteFirst() throws Exception {
    try {
        Node aux = this.first;//pointed to first
        Object item = first.getItem();// stored item 
        this.first = first.getNext();// assign new first
        aux = null; // delelte old first
        totalNodes--;// 
        return item;
    } catch (Exception e) {
        throw new Exception("Unable to delete first: Empty list" + e.getMessage());
    }
} 

public Object deleteLast() throws Exception{
    try {
        if(this.totalNodes > 1){
            
            Node aux = this.getNode(this.totalNodes - 1);// assign penultimo            
            Object auxItem = this.last.getItem();// stored deleted object 
            this.last = aux;// new last
            aux.setNext(null);// last points to null
            totalNodes --;// reduce total nodes by 1
            return auxItem;// return deleted object
        }
        else{
            return this.deleteFirst();
        }
    } catch (Exception e) {
        throw new Exception("Empty List : " + e.getMessage());
    }

}

public Object deleteItemByPosition(int index) throws Exception{
    if( index == 1){
        return this.deleteFirst();
    }
    else if (index == this.totalNodes){
        return this.deleteLast();
    }
    else {
        if( !isEmpty()){
            if(isValidIndex(index)){
                Node previous = this.getNode(index - 1);
                Node actual = previous.getNext();
                Object item = actual.getItem();
                previous.setNext(actual.getNext());
                actual = null;
                totalNodes --;
                return item;
            }
            else{
                throw new Exception("Invalid Index ");
            }
        }
        else{
            throw new Exception("The list is Empty");
        }

    }// last else

}

public Object deleteItem(Object reference) throws Exception{
    if(!isEmpty()){
        int position = this.getIndexOf(reference);// get index of reference
        if(position == 1){
            return this.deleteFirst();
        }
        else if(position == this.totalNodes){
           return  this.deleteLast();
        }
        else{
            return this.deleteItemByPosition(position);// delte item by index
        }

    }
    else{   
        throw new Exception("The list is empty");
    }// last else

};

/**
 * initialized new iterator that point to first
 * @return returns a new instance of Iterator that points to FIRST
 * @throws Exception
 */
public Iterator getIterator() throws Exception{
    return new Iterator(this.first);

}

//-------------------------------------------------LAMBDA EXPRESSIONS ------------------------------------//

public void  forEach(IntForEach intForEach) throws Exception{
    Iterator ite = this.getIterator(); // new aux node that point to the begining of the list
    while(ite.iterate()){ // while auxNode != null or is not endOfList
        intForEach.forEach(ite.getItem()); // applies forEach to each Node

    }

}

/**
 * applies a function to each element of the list
 * @return new list with changes in each element
 * @throws Exception
 */
public List map(IntMap intMap) throws Exception{
    List newList = new List();// create new list to store objects after new changes
    Iterator ite = this.getIterator();// create iterator and pinted to first node
    while(ite.iterate()){// while node is not null or end of list
        Object result = intMap.map(ite.getItem());// apply map method from interface that receives an Object as argument
        newList.insert(result);// apply inserLast to insert object in new list
    }
    return newList;// return new List

}


}// End of Class.