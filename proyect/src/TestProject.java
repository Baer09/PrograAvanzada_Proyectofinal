public class TestProject {

    public static void main(String[]args){
        List list = new List();

        list.insertFirst(1);
        list.insertFirst(3);
        list.insertLast("hola");
        
        
        
        list.print();
        System.out.println("findng reference : hola ");
        String find = (list.contains("hol")) ? "Item is in the list":"Item is not in the list";
        System.out.println(find);


        
        
    }
    
}