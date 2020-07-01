package business;

public class Seccion {
    private String id;
    private int anio;
    private String nivel;
    private int grado;
    private char seccion;
    private int idProfesorEncargado;
    private int salon;

    public Seccion(String [] data){
        this.id = data[0];
        this.anio = Integer.parseInt(data[1]);
        this.nivel= data[2];
        this.grado = Integer.parseInt(data[3]);
        this.seccion = data[4].charAt(0);
        this.idProfesorEncargado = Integer.parseInt(data[5]);
        this.salon = Integer.parseInt(data[6]);

    }

    //------------------------------------getters-------------------------------------------------------//
    public String getId(){
        return this.id;
    }
    public int getAnio(){
        return this.anio;
    }
    public String getNivel(){
        return this.nivel;
    }
    public int getGrado(){
        return this.grado;
    }
    public char getSeccion(){
        return this.seccion;
    }
    public int getIdProfesorEncargado(){
        return this.idProfesorEncargado;
    }
    public int getSalon(){
        return this.salon;
    }
    //--------------------------------------setters-----------------------------------------------------//
    public void setId(String id){
        this.id = id;
    }
    public void setAnio(int anio){
        this.anio = anio;
    }
    public void setNivel(String nivel){
        this.nivel = nivel;
    }
    public void setGrado(int grado){
        this.grado = grado;
    }
    public void setSeccion(char seccion){
        this.seccion = seccion;
    }
    public void setIdProfesorEncargado(int idProfesorEncargado){
        this.idProfesorEncargado = idProfesorEncargado;
    }
    public void setSalon(int salon){
        this.salon = salon;
    }

    //--------------------------------------------------------------------------------------------------//

    @Override
    public String toString(){
        return this.id+"-"+this.anio+"-"+this.nivel+"-"+this.grado+"-"+this.seccion+"-"+this.idProfesorEncargado+"-"+this.salon;
    }
    
}