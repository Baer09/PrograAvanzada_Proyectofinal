public class Multinodo {
    private Object item;
    private List transitions;

    //------------------------------------------- constructors------------------------------------------//

    public Multinodo(){
        this.item = null;
        this.transitions = null;
    }

    public Multinodo(Object item){
        this.setItem(item);
        this.transitions = new List();
    }

    public Multinodo(Object item, String transition,Multinodo nextNode)throws Exception{
        this.setItem(item);
        this.setTransition(transition, nextNode);
    }


    //--------------------------------------------Setters ----------------------------------------------//


    public boolean setItem(Object item){
        return (this.item = item) != null;
    }

    public boolean setTransition(String transition, Multinodo nextNode)throws Exception{
        if(this.transitions == null){// if transition is empty
            this.transitions = new List();// create a new list
        }

        Iterator iteSearch = this.searchTransitions(transition);// check if List already include the transition
        if(iteSearch != null){// the transition exist
            KeyValuePair par = (KeyValuePair) iteSearch.getItem();  // modify nextNode
            par.value = nextNode;
            return iteSearch.setItem(par);
        }
        else{// if the list do not have already the transition
            return this.transitions.insert(new KeyValuePair (transition,nextNode));//insert a new key value
        }

    }

    //--------------------------------------------GETTERS-----------------------------------------------//
    public Object getItem(){
        return this.item;
    }

    public Multinodo getTransition(String transition)throws Exception{
        Iterator iteSearch = this.searchTransitions(transition);//search transition in list
        if(iteSearch != null){// if exist
            KeyValuePair par = (KeyValuePair) iteSearch.getItem();
            Multinodo nextNode = (Multinodo) par.value;
            return nextNode;
        }
        else{
            throw new Exception ("Exception: Transition not found");
        }

    }

    //--------------------------------------------------------------------------------------------------//

    /**
     * verify if item is null
     */
    public boolean isEmpty(){
        return (this.item != null);
    }

    public Iterator searchTransitions(String transition)throws Exception{
        return this.transitions.search(finder -> ((KeyValuePair) finder).key.equals(transition));// verify if the transition is already in the list

    }

    public boolean exist(String transition)throws Exception{
        Iterator ite = this.searchTransitions(transition);// verify if transition alreay exist
        return (ite != null);// return true if it finds the transition

    }

    public List getTransitions(){
        return this.transitions;
    }





    
}