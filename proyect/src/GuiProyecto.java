import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class GuiProyecto extends JFrame {
    JPanel panel;
    JMenuBar menuOptions;
    JMenu options, subMenu;
    JMenuItem menu1,menu2,menu3,menu4,menu5,menu6,menu7,menu8,menu9,menu10,menu11,menu12;
    JLabel etiqueta;

    public GuiProyecto(){
        this.setSize(700,200);// window's size
        this.setTitle("Final Project - Programacion Avanzada");// title
        this.setLocationRelativeTo(null);// place window on the center
        //this.setDefaultCloseOperation(EXIT_ON_CLOSE);// close window when pressing X button
        this.setResizable(false);
        this.setUndecorated(true);
        

       components();
    }

    private void components(){
        menuPanel();
        menuBarOptions();
        colocarEtiqueta();

    }

    private void menuPanel(){
        panel = new JPanel();
        panel.setLayout(null);
        //panel.setBackground(Color.BLACK);      
        this.getContentPane().add(panel);
    }

    private void menuBarOptions(){
        menuOptions = new JMenuBar();// create menu bar
        
        options = new JMenu("Menu");// create main menu
        subMenu = new JMenu("Reportes");// create sub menu
        // creating items for main menu
        menu1 = new JMenuItem("Cargar Catalogos");
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

        menuOptions.add(options);// adding menubar      
        setJMenuBar(menuOptions);// show menu bar  

        ActionListener aListener = new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent ae){
                System.exit(0);

            }
        };


        menu3.addActionListener(aListener);  
    }



    //--------------------------------

    private void colocarEtiqueta() {
        etiqueta = new JLabel("working ......");
        etiqueta.setBounds(20, 10, 250, 100);
        panel.add(etiqueta);
    }

    

    


    
}