public class TestProject {

    public static void main(String[]args){
        List list = new List();
        Student student1 = new Student(3,"Brayan","Escobar",true);
        Student student2 = new Student(2,"Angela","Amarilis",true);
        Student student3 = new Student(1,"Mine","Fear",false);

        list.insertFirst(student1);
        list.insertLast(student2);
        list.insertLast(student3);

        try{
            // applying map and then forEach to print new list
            List listUpdated = new List(); // new list to store objects 

           /* listUpdated = list.map(intMap -> {
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
            String nombre = "Brayan";

            list.filter(intFilter -> ((Student) intFilter).name.equalsIgnoreCase(nombre))// compare names and if equals = true, stored the object in the list
            .print(intPrint -> (String) intPrint.toString());   

            list.sort((item1,item2) ->{
                return ((Student) item1).idStudent - ((Student) item2).idStudent;
            }).print(intPrint -> (String) intPrint.toString());  

            Iterator searched = list.search(finder -> ((Student) finder).name.contains("z"));// check if name has an "y"
            Student encontrado = (Student)searched.getItem(); 
            System.out.println(encontrado.toString()); 
            
            boolean letter = list.find(finder -> ((Student) finder).lastName.contains("i"));
            System.out.println("\nfind letter 'i' " + letter);  */

            String names = (String) list.reduce(new String(),(initialValue, reducer) ->{// received an object and interface received 2 objects
                String nombres = (String)initialValue;// savind names(acumulator)
                Student student = (Student) reducer;// casting object to String
                return nombres + " " + student.name;// concatenae names

            });

            System.out.println("Names" + names +"\n");

            
           


    
        }catch(Exception exc){
            System.out.println("error: item not found " + exc.getMessage());
        }
        
        
        
        
        


        
        
    }
    
}