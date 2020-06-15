public class Student {

    public int idStudent;
    public String name;
    public String lastName;
    public Boolean scholarship;
    public double monthlyPayment;

    public Student (int idStudent,String name,String lastName,Boolean scholarship){
        this.idStudent = idStudent;
        this.name = name;
        this.lastName = lastName;
        this.scholarship = scholarship;
        this.monthlyPayment = 0;
    }

    @Override
    public String toString(){
        return "\nID Student: " + idStudent+"\nName: "+name+"\nLastName: "+ lastName+"\nScholarship: "+scholarship+"\nmonthly payment: " + monthlyPayment;
    }


    
}