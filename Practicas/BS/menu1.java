package BS;

import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders.MenuBarBorder;

public class menu1 
{
    JFrame ventana;
    JMenuBar menuBar;
    JMenu mnu_Archivo;
    JMenuItem mi_arch_abrir,mi_arch_salir;
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

        mi_arch_salir= new JMenuItem("Salir");
        mnu_Archivo.add(mi_arch_salir);

        ventana.setVisible(true);
    }
}
