package BS;

import javax.swing.*;

public class menu1 
{
    JFrame ventana;
    JMenuBar menuBar;
    JMenu mnu_Archivo,mnu_archivo_sub;
    JMenuItem mi_arch_abrir,mi_arch_salir;
    JMenuItem mi_sub_opc1,mi_sub_opc2;
    public static void main(String[]args)
    {
        new menu1();
    }

    menu1()
    {
        ventana =  new JFrame("menu1");
        ventana.setBounds(100,100,500,500);
        ventana.setLayout(null);

        menuBar = new JMenuBar();

        mnu_Archivo = new JMenu("Archivo");

        mi_arch_abrir = new JMenuItem("Abrir");
        mnu_Archivo.add(mi_arch_abrir);

        mnu_archivo_sub = new JMenu("Sub");
        mi_sub_opc1 = new JMenuItem("Opcion 1");
        mnu_archivo_sub.add(mi_sub_opc1);

        mi_sub_opc2 =  new JMenuItem("Opcion 2");
        mnu_archivo_sub.add(mi_sub_opc2);

        mnu_Archivo.add(mnu_archivo_sub);

        mi_arch_salir= new JMenuItem("Salir");
        mnu_Archivo.add(mi_arch_salir);

        menuBar.add(mnu_Archivo);

        ventana.setJMenuBar(menuBar);

        ventana.setVisible(true);
    }
}
