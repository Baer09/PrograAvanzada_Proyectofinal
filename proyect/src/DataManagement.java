import java.io.File;
import java.io.FileWriter;
import java.net.URI;
import java.net.URLEncoder;
import java.util.Scanner;
import business.Student;
import java.awt.Desktop;
import business.Asignacion;
import business.Seccion;


public class DataManagement{

    String folder;
    String fileName;
    String delimiter;
    File file;
    Scanner input;
    String column;

    public DataManagement(String folder,String fileName,String delimiter)throws Exception{
        this.folder = folder;
        this.fileName = fileName;
        this.delimiter = delimiter;

        this.file = new File(folder+"\\"+fileName);
        this.input = new Scanner(file);
        this.column = this.input.nextLine();

    }
    public DataManagement(){};
    
    
    //-------------------------------------DataStudent--------------------------------------------------//
    /**
     * read and convert one line to a string then it  stored it on an Object
     * @return returns  one line as an Object
     * @throws Exception
     */
    public Object readOneLineStudent()throws Exception{       
        String line;
        line = input.nextLine();// read one line
        String [] dataValue = line.split(this.delimiter);// convert the line in an array, use .split ","
        for(int i =0; i < dataValue.length; i++){
            dataValue[i] = dataValue[i].trim();// remove white spaces
        }
        Student student = new Student(dataValue);// save array in Student
        Object result = student;//stored student in an Object
        return result;// return Object                 
    }   

    
    /**
     * save each object in a list
     * @return return list with all the lines as Objects
     * @throws Exception
     */
    public List loadDataStudent()throws Exception{
        List list = new List();
        while(this.input.hasNextLine()){// while it still has lines
            list.insert(this.readOneLineStudent());// insert object in list
        }
        return list;// return list
    }

    //------------------------------------DataSeccion--------------------------------------------------//
    /**
     * read and convert one line to a string then it  stored it on an Object
     * @return returns  one line as an Object
     * @throws Exception
     */
    public Object readOneLineSeccion()throws Exception{       
        String line;
        line = input.nextLine();// read one line
        String [] dataValue = line.split(this.delimiter);// convert the line in an array, use .split ","
        for(int i =0; i < dataValue.length; i++){
            dataValue[i] = dataValue[i].trim();// remove white spaces
        }
        Seccion seccion = new Seccion(dataValue);// save array in Student
        Object result = seccion;//stored student in an Object
        return result;// return Object                 
    }   

    
    /**
     * save each object in a list
     * @return return list with all the lines as Objects
     * @throws Exception
     */
    public List loadDataSeccion()throws Exception{
        List list = new List();
        while(this.input.hasNextLine()){// while it still has lines
            list.insert(this.readOneLineSeccion());// insert object in list
        }
        return list;// return list
    }

    //---------------------------------DataAsignacion-------------------------------------------------//
    /**
     * read and convert one line to a string then it  stored it on an Object
     * @return returns  one line as an Object
     * @throws Exception
     */
    public Object readOneLineAsignacion()throws Exception{       
        String line;
        line = input.nextLine();// read one line
        String [] dataValue = line.split(this.delimiter);// convert the line in an array, use .split ","
        for(int i =0; i < dataValue.length; i++){
            dataValue[i] = dataValue[i].trim();// remove white spaces
        }
        
        Asignacion asignacion = new Asignacion(dataValue);// save array in Student
        Object result = asignacion;//stored student in an Object
        return result;// return Object                 
    }   

    
    /**
     * save each object in a list
     * @return return list with all the lines as Objects
     * @throws Exception
     */
    public List loadDataAsignacion()throws Exception{
        List list = new List();
        while(this.input.hasNextLine()){// while it still has lines
            list.insert(this.readOneLineAsignacion());// insert object in list
        }
        return list;// return list
    }


    //----------------------------------reportes-------------------------------------------------------//

    /**
     * create file to stored reports
     */
    private File createFile(String fileName) throws Exception{
        File reporte = new File(fileName);//inicializar file y enviar nombre de new file
        reporte.createNewFile();
        return reporte;
    }

    public void storedDataFile(List listReporte,String fileName,int anio,String nivel,int grado,String seccion)throws Exception{
        Student printHtml = new Student();
        FileWriter writeInTheFile = new FileWriter(createFile(fileName));
        writeInTheFile.write(printHtml.tableHtml(anio,nivel,grado,seccion));
        listReporte.forEach(intForEach ->{// use intForEach to print each object in the file
            Student estudiante = (Student) intForEach;
            writeInTheFile.write(estudiante.toString()+"\r\n");

        });
        writeInTheFile.write("</table>");
        writeInTheFile.close();
        

        
        URI oURL = new URI("reporte1.html");
        
        Desktop.getDesktop().browse(oURL);
       
     


        

    }

    


    

        
           
}//End of class