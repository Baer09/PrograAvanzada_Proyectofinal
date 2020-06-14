public class Student {

    public int idStudent;
    public String name;
    public String lastName;
    public Boolean scholarship;

    public Student (int idStudent,String name,String lastName,Boolean scholarship){
        this.idStudent = idStudent;
        this.name = name;
        this.lastName = lastName;
        this.scholarship = scholarship;
    }

    @Override
    public String toString(){
        return "\nID Student: " + idStudent+"\nName: "+name+"\nLastName: "+ lastName+"\nScholarship: "+scholarship;
    }


    
}