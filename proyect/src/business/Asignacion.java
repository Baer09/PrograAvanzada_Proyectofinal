package business;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Asignacion {
    private int id;
    private String carnet;
    private int idSeccion;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;

    public Asignacion(String [] data){
        this.id = Integer.parseInt(data[0]);
        this.carnet = data[1];
        this.idSeccion = Integer.parseInt(data[2]);
        this.fechaInicio = LocalDate.parse(data[3], DateTimeFormatter.ofPattern("M/d/yyyy"));
        this.fechaFinal = LocalDate.parse(data[4], DateTimeFormatter.ofPattern("M/d/yyyy"));
    }
    //----------------------------------------getter & setters ----------------------------------------//

    public void setId(int id){
        this.id= id;
    }
    public void setCarnet(String carnet){
        this.carnet = carnet;
    }
    public void setIdSeccion(int idSeccion){
        this.idSeccion = idSeccion;
    }
    public void setFechaInicio(LocalDate fechaInicio){
        this.fechaInicio = fechaInicio;
    }
    public void setFechaFinal(LocalDate fechaFinal){
        this.fechaFinal = fechaFinal;
    }

    public int getId(){
        return this.id;
    }
    public String getCarnet(){
        return this.carnet;
    }
    public int getIdSeccion(){
        return this.idSeccion;
    }
    public LocalDate getFechaInicio(){
        return this.fechaInicio;
    }
    public LocalDate getFechaFinal(){
        return this.fechaFinal;    
    }

    @Override
    public String toString(){
        return this.id+"-"+this.carnet+"-"+this.idSeccion+"-"+this.fechaInicio+"-"+this.fechaFinal;
    }
}// end of class