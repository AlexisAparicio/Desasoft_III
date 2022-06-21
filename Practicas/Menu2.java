import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner;
import java.io.*;

public class Menu2 implements ActionListener {
private JFrame ventana;
public JMenuBar menuBar;
public JMenu mnu_Archivo,mnu_archivo_sub;
public  JMenuItem mi_arch_abrir,mi_Arch_salir;
public JMenuItem mi_sub_opc1,mi_sub_opc2;

DefaultListModel<String> listModel;
JList<String> lst_lista;
JScrollPane sp_lista;
    public static void main(String[]args)
    {
        new Menu2();
    }

    Menu2() 
    {
        ventana =  new JFrame ("Menu");
        ventana.setBounds(100,100,500,500);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuBar=new JMenuBar();

        mnu_Archivo = new JMenu("Archivo");

        mi_arch_abrir = new JMenuItem("Abrir");
        mi_arch_abrir.addActionListener(this);
        mnu_Archivo.add(mi_arch_abrir);

        mnu_Archivo.addSeparator();

        mnu_archivo_sub = new JMenu("sub");
        mi_sub_opc1 =  new JMenuItem("Opcion 1");
        mnu_archivo_sub.add(mi_sub_opc1);

        mi_sub_opc2 =  new JMenuItem("Opcion 2");
        mnu_archivo_sub.add(mi_sub_opc2);

        mnu_Archivo.add(mnu_archivo_sub);

        mnu_Archivo.addSeparator();

        mi_Arch_salir = new JMenuItem("Salir");
        mi_Arch_salir.addActionListener(this);
        mnu_Archivo.add(mi_Arch_salir);

        menuBar.add(mnu_Archivo);

        listModel = new DefaultListModel<String>();
        lst_lista = new JList<String>(listModel);
        sp_lista = new JScrollPane(lst_lista);

        sp_lista.setBounds(50,50,200,200);
        ventana.add(sp_lista);

        ventana.setJMenuBar(menuBar);

        ventana.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==mi_Arch_salir)
        System.exit(0);
        if(e.getSource()== mi_arch_abrir)
        abrir();
    }

    public void abrir()
    {   String linea;
        try
        {
            JFileChooser jfc = new JFileChooser();
            jfc.showOpenDialog(null);
            File archivo=jfc.getSelectedFile();

            Scanner sc = new Scanner(archivo);
            while(sc.hasNextLine())
            {
                linea= sc.nextLine();
                listModel.addElement(linea);
                //System.out.println(linea);
            }
            sc.close();
        }
        catch(Exception e)
        {
            System.out.println("Error al Abrir el Archivo "+e.toString());
        }
    }

}
