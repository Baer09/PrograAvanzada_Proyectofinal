public class TestProject {

    public static void main(String[]args){
        List list = new List();
        Student student1 = new Student(1,"Brayan","Escobar",true);
        Student student2 = new Student(2,"Angela","Amarilis",true);
        Student student3 = new Student(3,"Mine","Fear",false);

        list.insertFirst(student1);
        list.insertLast(student2);
        list.insertLast(student3);

        try{
            list.forEach(intForEach -> {
            Student student = (Student) intForEach;
            System.out.println(student);
            });
    
        }catch(Exception exc){
            System.out.println("error: " + exc.getMessage());
        }
        
        
        
        
        


        
        
    }
    
}