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
            // applying map and then forEach to print new list
            List listUpdated = new List(); // new list to store objects 

            listUpdated = list.map(intMap -> {
                Student student = (Student) intMap;// casting
                if(student.scholarship){// if true
                    student.monthlyPayment = 100; // paymetn is 100
                }
                else{
                    student.monthlyPayment = 900;// payment is 900
                }

                return student; // return object with new changes or no changes if scholarshop is false
            });

            list.forEach(intForEach -> {
            Student student = (Student) intForEach;
            System.out.println(student);
            }); 


    
        }catch(Exception exc){
            System.out.println("error: " + exc.getMessage());
        }
        
        
        
        
        


        
        
    }
    
}