package BS;

import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner;
import java.io.*;

public class Aparicio532ProyFinal implements ActionListener
{
    JFrame ventana;
    JMenuBar menuBar;
    JMenu mnu_ini,mnu_archivo_sub,mnu_mant,mnu_reportes;
    JMenuItem mi_arch_pres,mi_arch_salir;
    JMenuItem mi_sub_opc1,mi_sub_opc2;
    JMenuItem mnu_mod_paciente,mnu_mod_Medico,mnu_rep_pacientes,mnu_rep_medicos;

    DefaultListModel<String> lstModel;
    JList<String> lst_lista;
    JScrollPane sp_lista;
    public static void main(String[]args)
    {
        new Aparicio532ProyFinal();
    }

    Aparicio532ProyFinal()
    {
        ventana =  new JFrame("Consultorio");
        ventana.setBounds(100,100,500,500);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(null);
        // para maximixar la ventana al tope<>
        //ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
        // para dejarla del tamaño definido.
        ventana.setExtendedState(JFrame.NORMAL);
        // para dejarla minimizada.
        //ventana.setExtendedState(JFrame.ICONIFIED);

        menuBar = new JMenuBar();

        	mnu_ini = new JMenu("Inicio");

		        mi_arch_pres = new JMenuItem("Presentación");
		        mi_arch_pres.addActionListener(this);
		        mnu_ini.add(mi_arch_pres);

        /*
        mnu_ini.addSeparator();

        mnu_archivo_sub = new JMenu("Sub");
        mi_sub_opc1 = new JMenuItem("Opcion 1");
        mnu_archivo_sub.add(mi_sub_opc1);

        mi_sub_opc2 =  new JMenuItem("Opcion 2");
        mnu_archivo_sub.add(mi_sub_opc2);

        mnu_ini.add(mnu_archivo_sub);
        mnu_ini.addSeparator();
        */

        mi_arch_salir= new JMenuItem("Salir");
        mi_arch_salir.addActionListener(this);
        mnu_ini.add(mi_arch_salir);

        menuBar.add(mnu_ini);

        	mnu_mant = new JMenu("Mantenimiento");

	        	mnu_mod_paciente = new JMenuItem("Paciente");
	        	mnu_mod_paciente.addActionListener(this);
	        	mnu_mant.add(mnu_mod_paciente);
	
	        	mnu_mant.addSeparator();
	
	        	mnu_mod_Medico = new JMenuItem("Medico");
	        	mnu_mod_Medico.addActionListener(this);
	        	mnu_mant.add(mnu_mod_Medico);

        menuBar.add(mnu_mant);
        
        //mnu_rep_pacientes,mnu_rep_medicos
        
        	mnu_reportes = new JMenu("Reportes");

		        mnu_rep_pacientes = new JMenuItem("Pacientes");
		        mnu_rep_pacientes.addActionListener(this);
		    	mnu_reportes.add(mnu_rep_pacientes);
		
		    	mnu_mant.addSeparator();
	
		    	mnu_rep_medicos = new JMenuItem("Medico");
		    	mnu_rep_medicos.addActionListener(this);
		    	mnu_reportes.add(mnu_rep_medicos);

    	menuBar.add(mnu_reportes);



        // Cuadro de lista
        lstModel = new DefaultListModel<String>();
        lst_lista = new JList<String>(lstModel);
        sp_lista = new JScrollPane(lst_lista);

        sp_lista.setBounds(50,50,200,200);
        ventana.add(sp_lista);

        ventana.setJMenuBar(menuBar);

        ventana.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
   {
    if(e.getSource()==mi_arch_pres)
        new Presentacion();
    if(e.getSource()==mnu_mod_paciente)
        new Mant_paciente();
    if(e.getSource()==mnu_mod_Medico)
        new Mant_medico();
    if(e.getSource()==mnu_rep_pacientes)
        new Reporte_pacientes();
    if(e.getSource()==mnu_rep_medicos)
        new Reportes_medicos();
    if (e.getSource()== mi_arch_salir)
    System.exit(0);
   }

   public void abrir()
   { String linea;
    try
    {
        JFileChooser jfc= new JFileChooser();
        jfc.showOpenDialog(null);

        File archivo = jfc.getSelectedFile();

        Scanner sc = new Scanner(archivo);

        while (sc.hasNextLine())
        {
            linea = sc.nextLine();
            lstModel.addElement(linea);
           // System.out.println(linea);
        }
        sc.close();
    }
    catch (Exception e) 
    {
        System.out.println("Error al abrir"+e.toString());
    }
    
   }
   
}