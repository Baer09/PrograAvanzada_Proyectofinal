public class TestProject {

    public static void main(String[]args){
        List list = new List();

        System.out.println("Esta limpia la lista: " + list.isEmpty());
        
        list.insertFirst("one");
        list.insertFirst(2);
        list.insertFirst("two");

        System.out.println("Numero de Nodos: " + list.getLength());

        System.out.println("Imprimiendo Datos de Nodos: \n");
        list.print();
        
    }
    
}