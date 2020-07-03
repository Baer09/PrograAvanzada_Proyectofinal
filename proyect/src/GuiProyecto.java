import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import business.*;



public class GuiProyecto extends JFrame {
    JPanel panel;
    JMenuBar menuOptions;
    JMenu options, subMenu;
    JMenuItem menu1,menu2,menu3,menu4,menu5,menu6,menu7,menu8,menu9,menu10,menu11,menu12;
    JLabel etiquetaImagen,etiqueta1,etiqueta2;
    ActionListener aListener,loadCatalogos,reporte1;

    private static List listaEstudiantes = new List();
    private static List listaSecciones = new List();
    private static List listaAsignaciones = new List();
    //---------------------------------Constructor-------------------------------------------------------//
    public GuiProyecto(){
        this.setSize(700,250);// window's size
        this.setTitle("Final Project - Programacion Avanzada");// title
        this.setLocationRelativeTo(null);// place window on the center
        //this.setDefaultCloseOperation(EXIT_ON_CLOSE);// close window when pressing X button
        this.setResizable(false);
        this.setUndecorated(true);// removed (- [] X) buttons
        this.setBackground(Color.blue);
        
        
        

       components();
    }

    /**
     * adding comptonet to JFrame
     */
    private void components(){
        menuPanel();
        menuBarOptions();
        colocarEtiquetas();

    }

    /**
     * adding panel to JFrame
     */
    private void menuPanel(){
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.BLACK);      
        this.getContentPane().add(panel);
    }

    /**
     * menu options
     */
    private void menuBarOptions(){
        menuOptions = new JMenuBar();// create menu bar

        
        options = new JMenu("Menu");// create main menu
        //options.setOpaque(false);
        options.setForeground(Color.gray);
        
        subMenu = new JMenu("Reportes");// create sub menu
        // creating items for main menu
        menu1 = new JMenuItem("Cargar Catalogos");
        menu1.setForeground(Color.green);
        menu3 = new JMenuItem("Salir");
        // creating item for submenu
        menu4 = new JMenuItem("1. Estudiantes Asignados a una seccion");
        menu5 = new JMenuItem("2. Notas Actuales por seccion y materia");
        menu6 = new JMenuItem("3. Notas por estudiante por materia");
        menu7 = new JMenuItem("4. Estudiantes con cursos reprobados por año y nivel");
        menu8 = new JMenuItem("5. Estudiantes abanderados por año y nivel");
        menu9 = new JMenuItem("6. Estudiantes Cumpleañerps del año, mes indicado");
        menu10 = new JMenuItem("7. Total de aprobados/reprobados por profesor y rango de fechas");
        menu11 = new JMenuItem("8. Compracion becados por aprobacion");
        menu12 = new JMenuItem("9. Comparacion de becados por genero");
        // adding item in main menu
        options.add(menu1);
        options.add(subMenu);// ading submenu in main menu
        options.add(menu3);
        // adding item in subMenu   
        subMenu.add(menu4);
        subMenu.add(menu5);
        subMenu.add(menu6);
        subMenu.add(menu7);
        subMenu.add(menu8);
        subMenu.add(menu9);
        subMenu.add(menu10);
        subMenu.add(menu11);
        subMenu.add(menu12);       
        menuOptions.setBackground(Color.black);
        menuOptions.add(options);// adding menubar  
            
        setJMenuBar(menuOptions);// show menu bar  

        //-----------------------------Adding Actions to each menu bar ------------------------------------//


        aListener = new ActionListener(){ // adding action 
            @Override
            public void actionPerformed (ActionEvent ae){
                System.exit(0);// close program

            }
        };
        //-------------------------------------cargar Catalogos -------------------------------------//
        loadCatalogos = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                try{
                    DataManagement dataStudent = new DataManagement("..\\catalogos", "estudiantes.csv", ",");
                    DataManagement dataSeccion = new DataManagement("..\\catalogos", "secciones.csv", ",");
                    DataManagement dataAsignacion = new DataManagement("..\\catalogos","asignaciones.csv",",");
                    listaEstudiantes = dataStudent.loadDataStudent();
                    listaSecciones = dataSeccion.loadDataSeccion();
                    listaAsignaciones = dataAsignacion.loadDataAsignacion();
                    if(listaEstudiantes != null && listaSecciones != null && listaAsignaciones != null){//todas las listas tiene que tener data
                        JOptionPane.showMessageDialog(null,"The files were successfully added");
                    }
                    //listaSecciones.print(intPrint -> (String) intPrint.toString());
                    
                }
                catch(Exception exc){
                     System.err.println("Error while loading files: "+exc.getMessage());
                     JOptionPane.showMessageDialog(null,"Erro while loading files");
            }
                

            }
        };
    //-----------------------------------------Reporte 1 ---------------------------------------------//
    
    reporte1 = new ActionListener(){
        
        int grado=4;//------------------
        @Override
        public void actionPerformed(ActionEvent ae){
            if(listaAsignaciones.isEmpty() || listaEstudiantes.isEmpty() || listaSecciones.isEmpty()){
                JOptionPane.showMessageDialog(null,"Error: Catalogos Incompletos,cargue los catalogos primero");
            }
            // parametro de busqueda
            int anio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el anio: "));
            String nivel = JOptionPane.showInputDialog("Ingrese Nivel: 1.Primaria 2.Basicos 3.Deiversificado : ");
                        
            if(nivel.equalsIgnoreCase("primaria")){
                grado = Integer.parseInt(JOptionPane.showInputDialog("Ingrese grado de primaria(1,2,3,4,5,6): "));
            }
            else if(nivel.equalsIgnoreCase("basicos")){
                grado = Integer.parseInt(JOptionPane.showInputDialog("Ingrese grado de basicos(1,2,3): "));
            }
            else if(nivel.equalsIgnoreCase("diversificado")){
                grado = Integer.parseInt(JOptionPane.showInputDialog("Ingrese grado de diversificado(4,5,6):  "));
            }
            else{JOptionPane.showMessageDialog(null,"Opcion invalida");}

            String seccion = JOptionPane.showInputDialog("Ingrese seccion (A-F): ");
            System.out.println(anio+"-"+nivel+"-"+grado+"-"+seccion);

            //Obtener seccion
            try{
            Iterator iteSeccion = GuiProyecto.listaSecciones.search(objecto -> {
                
                Seccion sec = (Seccion) objecto;// convertir objeto a seccion
                return sec.getAnio() == anio &&// comparando items
                       sec.getNivel().equalsIgnoreCase(nivel) &&
                       sec.getGrado() == grado &&
                       sec.getSeccion() == seccion.charAt(0);
                

            });      
            if(iteSeccion != null){
                System.out.println(iteSeccion.getItem().toString());
            }
            else{
                System.out.println("no existen registros.");
                
            }
           //System.out.println(iteSeccion.getItem().toString());

            //listaSecciones.print(intPrint -> (String) intPrint.toString());

            Seccion seccionEncontrada = (Seccion) iteSeccion.getItem();


        }catch(Exception exc){System.out.println("error "+exc.getMessage());}

        
         


        }//end actionPerformance
    

      
    };// end actionListener
    
    





    //------------------------------------------------------------------------------------------------//


        menu3.addActionListener(aListener);  // adding action (close program).
        menu1.addActionListener(loadCatalogos);// load files
        menu4.addActionListener(reporte1);

    }
    //---------------------------------------End Menu Options---------------------------------------------//



    //------------------------------------Labels---------------------------------------------------------//

    private void colocarEtiquetas() {
        etiquetaImagen = new JLabel(new ImageIcon("..\\images\\logo2.png"));
        etiquetaImagen.setBounds(275,50, 127, 100);//X,Y,ancho,alto

        etiqueta1 = new JLabel("PROGRAMACION AVANZADA: PROYECTO FINAL");
        etiqueta1.setBounds(200,10,400,50);//X,Y,ancho,alto
        etiqueta1.setForeground(Color.gray);

        etiqueta2 = new JLabel("BRAYAN ESCOBAR");
        etiqueta2.setBounds(575,180,400,50);//X,Y,ancho,alto
        etiqueta2.setForeground(Color.gray);
        
        panel.add(etiquetaImagen);
        panel.add(etiqueta1);
        panel.add(etiqueta2);
    }

    

    


    
}