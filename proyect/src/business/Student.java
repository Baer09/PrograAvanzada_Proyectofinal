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
        return this.id+"-"+this.name+"-"+this.lastName+"-"+this.gender+"-"+this.dateOfBirth.toString()+"-"+this.scholarship;

    }
    

    
}