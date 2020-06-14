public interface Iterable {
     //ITERABLE Interface:
//public void initIterator(); //hace que el nodo iterador se igual al primer nodo
 public boolean isValid(); //verifica que el nodo iterador no sea null o después final de la lista
 public Object getItem() throws Exception; //retorna el item del nodo iterador (aux)
 public boolean setItem(Object item) throws Exception;
 public Object peekNextItem() throws Exception; //pickNext
 public boolean insertAfter(Object item) throws Exception; 
 public boolean iterate(); //returns the actual index y hace que el iterador apunte a su siguiente.
 public int getIterations();
    
}