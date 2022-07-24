package BS;

import java.awt.*;
import javax.swing.*;

public class Contabilidad 
{
    JFrame ventana2;
    JLabel lbl_contabilidad;

    Contabilidad(JFrame v)
    {   ventana2 = v;
        //Borrado de ventana
        ventana2.getContentPane().removeAll();
        ventana2.getContentPane().setBackground(Color.gray);
        ventana2.revalidate();
         /*
        ventana2 = new JFrame("Contabilidad");
        ventana2.setBounds(100,100,500,500);
        ventana2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana2.setLayout(null);
        ventana2.setExtendedState(JFrame.NORMAL);
         */

        lbl_contabilidad= new JLabel("Contabilidad");
        lbl_contabilidad.setBounds(20,20,150,20);
        ventana2.add(lbl_contabilidad);

        //ventana2.setVisible(true);
        ventana2.repaint();
    }
}
