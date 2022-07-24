package BS;

import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner;
import java.io.*;

public class menu1 implements ActionListener
{
    JFrame ventana;
    JMenuBar menuBar;
    JMenu mnu_Archivo,mnu_archivo_sub,mnu_modulo;
    JMenuItem mi_arch_abrir,mi_arch_salir;
    JMenuItem mi_sub_opc1,mi_sub_opc2;
    JMenuItem mnu_mod_Contabilidad,mnu_mod_Facturacion;

    DefaultListModel<String> lstModel;
    JList<String> lst_lista;
    JScrollPane sp_lista;
    public static void main(String[]args)
    {
        new menu1();
    }

    menu1()
    {
        ventana =  new JFrame("menu1");
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

        mnu_Archivo = new JMenu("Archivo");

        mi_arch_abrir = new JMenuItem("Abrir");
        mi_arch_abrir.addActionListener(this);
        mnu_Archivo.add(mi_arch_abrir);

        mnu_Archivo.addSeparator();

        mnu_archivo_sub = new JMenu("Sub");
        mi_sub_opc1 = new JMenuItem("Opcion 1");
        mnu_archivo_sub.add(mi_sub_opc1);

        mi_sub_opc2 =  new JMenuItem("Opcion 2");
        mnu_archivo_sub.add(mi_sub_opc2);

        mnu_Archivo.add(mnu_archivo_sub);
        mnu_Archivo.addSeparator();

        mi_arch_salir= new JMenuItem("Salir");
        mi_arch_salir.addActionListener(this);
        mnu_Archivo.add(mi_arch_salir);

        menuBar.add(mnu_Archivo);

        mnu_modulo = new JMenu("Modulos");

        mnu_mod_Contabilidad = new JMenuItem("Contabilidad");
        mnu_mod_Contabilidad.addActionListener(this);
        mnu_modulo.add(mnu_mod_Contabilidad);

        mnu_modulo.addSeparator();

        mnu_mod_Facturacion = new JMenuItem("Facturación");
        mnu_mod_Facturacion.addActionListener(this);
        mnu_modulo.add(mnu_mod_Facturacion);

        menuBar.add(mnu_modulo);



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
    if (e.getSource()== mi_arch_salir)
    System.exit(0);

    if(e.getSource()==mi_arch_abrir)
        abrir();
    if(e.getSource()==mnu_mod_Contabilidad)
        new Contabilidad(ventana);
    if(e.getSource()==mnu_mod_Facturacion)
    new Facturacion(ventana);
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
