public class TestProject {

    public static void main(String[]args){
        List list = new List();

        list.insertFirst(100);
        list.insertFirst(3);
        list.insertFirst("hola");
        list.insertLast("last");
        list.insertFirst("new First");
        list.insertLast("new Last");
        
        list.print();
        System.out.println("");
        
        try {
            System.out.println("delete by reference: " + list.deleteItem(100)+"\n");
            list.print();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        
        
        
        


        
        
    }
    
}