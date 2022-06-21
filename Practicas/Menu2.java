import javax.swing.*;

public class Menu2 {
private JFrame ventana;
public JMenuBar menuBar;
public JMenu mnu_Archivo,mnu_archivo_sub;
public  JMenuItem mi_arch_abrir,mi_Arch_salir;
public JMenuItem mi_sub_opc1,mi_sub_opc2;
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
        mnu_Archivo.add(mi_arch_abrir);

        mnu_archivo_sub = new JMenu("sub");
        mi_sub_opc1 =  new JMenuItem("Opcion 1");
        mnu_archivo_sub.add(mi_sub_opc1);

        mi_sub_opc2 =  new JMenuItem("Opcion 2");
        mnu_archivo_sub.add(mi_sub_opc2);

        mnu_Archivo.add(mnu_archivo_sub);

        mi_Arch_salir = new JMenuItem("Salir");
        mnu_Archivo.add(mi_Arch_salir);

        menuBar.add(mnu_Archivo);

        ventana.setJMenuBar(menuBar);

        ventana.setVisible(true);
    }
}
