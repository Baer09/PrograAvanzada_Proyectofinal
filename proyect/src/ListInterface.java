
public interface ListInterface{

    /**
     * Verify if it is the last node
     * @param node
     * @return null if the Node is empty
     */
    public boolean isEndOfList(Node node);

    /**
     * Insert an Object to the list
     * @param item
     * @return true if the object is added to the list
     */
    public boolean insert(int index,Object item) throws Exception;

    /**
     * verify if the list is empty
     * @return true if is empty
     */
    public boolean isEmpty();

    
    /**
     * List length
     * @return number of Nodes in the list
     */
    public int getLength();


    //---------------------------- SEARCH METHODS --------------------------------------//

    public Object  getItemByPosition(int index) throws Exception;
    public boolean contains(Object reference);
    public Object getFirstItem() throws Exception;
    public Object getLastItem() throws Exception;
    public int getIndexOf(Object reference) throws Exception;
    public Iterator getIterator() throws Exception;

    //----------------------------- DELETE MOTHODS -------------------------------------//
    
    /**
     * Delete Item by position(Index)
     * @param index
     * @return the deleted item or null if it does not found it.
     * @throws Exception
     */
    public Object deleteItemByPosition(int index) throws Exception;

    /**
     * Delete Item by reference
     * @param reference
     * @return deleted Item or null if it is not in the list.
     */
    public Object deleteItem(Object reference) throws Exception;

    //------------------------------------------------------------------------------------//

    public void print();

    //-------------------------------- LAMBDA EXPRESSIONS --------------------------------//
    
    public void  forEach(IntForEach intForEach) throws Exception;

    /**
     * applied a function to each node and it returns an object, it go throughout all the list.
     * @param intMap
     * @return a List with the results.
     * @throws Exception
     */
    public List map(IntMap intMap) throws Exception;

    /**
     * Applies a function if the result is true and the item is added to the a new list.
     * @param intFilter
     * @return List with Item that were affeced.
     * @throws Exception
     */
    public List filter(IntFilter intFilter) throws Exception;

    public void print(IntPrint intPrint) throws Exception;

    //public List sort(IntCompare intSort) throws Exception;

    //public boolean find(IntFind finder) throws Exception;

    /**
     * Search for an Iterator
     * @param finder
     * @return an Iterator or null if it is not found
     * @throws Exception
     */
    //public Iterator search(IntFind finder) throws Exception;

    //public Object reduce(Object initialValue,IntReducer reducer) throws Exception;

    



}