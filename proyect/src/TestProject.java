public class TestProject {

    public static void main(String[]args){
        List list = new List();

        list.insertFirst(1);
        list.insertFirst(3);
        list.insertLast("hola");
        
        try {
            list.insert(11, "Penultimo nodo");
        } catch (Exception e) {
           System.out.println("Index out of bounds");
        }

                
        
        list.print();
        
    }
    
}