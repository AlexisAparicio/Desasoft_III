package BS;

import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

public class Facturacion 
{
    JFrame ventana2;
    JLabel lbl_Facturacion,lbl_prueba;
    Font fnt_prueba;

    Facturacion(JFrame v)
    {   ventana2 = v;
        //Borrado de ventana
        ventana2.getContentPane().removeAll();
        ventana2.getContentPane().setBackground(new ColorUIResource(120,90,200));
        ventana2.revalidate();
         /*
        ventana2 = new JFrame("Contabilidad");
        ventana2.setBounds(100,100,500,500);
        ventana2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana2.setLayout(null);
        ventana2.setExtendedState(JFrame.NORMAL);
         */

        lbl_Facturacion= new JLabel("Facturación");
        lbl_Facturacion.setBounds(20,20,150,20);
        ventana2.add(lbl_Facturacion);

        fnt_prueba = new Font("Arial",Font.ITALIC,14); //BOLD,PLain

        lbl_prueba = new JLabel("Prueba");
        lbl_prueba.setBounds(40,40,100,20);
        lbl_prueba.setFont(fnt_prueba);
        ventana2.add(lbl_prueba);

        //ventana2.setVisible(true);
        ventana2.repaint();
    }
}
