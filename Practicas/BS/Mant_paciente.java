package BS;

import java.awt.*;
import javax.swing.*;

public class Mant_paciente 
{
    JFrame ventana2;
    Font fnt_text;
    JButton btn_buscar,btn_add,btn_mod,btn_delete,btn_list;
    JLabel lbl_name,lbl_curso,lbl_prof,lbl_year,lbl_uni;

    Mant_paciente()
    {
        ventana2 = new JFrame("Mantenimiento de Pacientes");
        ventana2.setBounds(100,100,500,500);
        ventana2.setLayout(null);

        ventana2.setVisible(true);
    }
}
