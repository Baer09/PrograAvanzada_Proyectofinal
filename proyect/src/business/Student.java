package business;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Student {
    private String id;
    private String name;
    private String lastName;
    private String gender;
    private LocalDate dateOfBirth;
    private String scholarship;

    public Student(String[] data){
        this.id = data[0];
        this.name = data[1];
        this.lastName = data[2];
        this.gender = data[3];
        this.dateOfBirth = LocalDate.parse(data[4],DateTimeFormatter.ofPattern("M/d/yyy"));
        this.scholarship = data[5];
    }
    public Student(){}
    //---------------------------------getters--------------------------------------------------------------//
    public String getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getLastName(){
        return this.lastName;
    }
    public String getGender(){
        return this.gender;
    }
    public LocalDate getDateOfBirth(){
        return this.dateOfBirth;
    }
    public String getScholarship(){
        return this.scholarship;
    }
    //----------------------------------setters-------------------------------------------------------------//
    public void setId(String id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
    public void setDateOfBirth(LocalDate dateOfBirth){
        this.dateOfBirth = dateOfBirth;
    }
    public void setScholarship(String scholarship){
        this.scholarship = scholarship;
    }

    //------------------------------------------------------------------------------------------------------//
    @Override
    public String toString(){
        return "<tr>\n"+
                "<td>"+this.id+"</td><td>"+this.name+"</td><td>"+this.lastName+"</td><td>"+this.gender+"</td><td>"+this.dateOfBirth.toString()+"</td><td>"+this.scholarship+"</td>\n"+
                "</tr>";

    }
    public String tableHtml(int year,String level,int grade,String section){
        return "<style>table,td{border: 1px solid black;}</style><p>anio: "+year+"</p><p>nivel: "+level+"</p><p>grado: "+grade+"</p><p>seccion: "+section+"</p>"+
                "\n<table><tr><td>carnet</td><td>nombre</td><td>apellido</td><td>genero</td><td>Dateofbirth</td><td>esbecado</td></tr>";
    }
    

    
}