package BS;

import java.awt.*;
import javax.swing.*;

public class Presentacion 
{
    JFrame ventana2;
    Font fnt_text;
    JLabel lbl_name,lbl_curso,lbl_prof,lbl_year,lbl_uni;


Presentacion()
    {
        ventana2 = new JFrame("Presentación");
        ventana2.setBounds(100,100,500,500);
        ventana2.setLayout(null);


        fnt_text = new Font("Arial",Font.ITALIC,14);

        //Nombre
        lbl_name = new JLabel("Bolivar alexis Aparicio Bedoya");
        lbl_name.setBounds(40,40,400,20);
        lbl_name.setFont(fnt_text);
        ventana2.add(lbl_name);

        lbl_curso = new JLabel("Lic. Desarrollo de Software III ");
        lbl_curso.setBounds(40,65,400,20);
        lbl_curso.setFont(fnt_text);
        ventana2.add(lbl_curso);

        lbl_prof = new JLabel("Ricardo Chan ");
        lbl_prof.setBounds(40,90,200,20);
        lbl_prof.setFont(fnt_text);
        ventana2.add(lbl_prof);

        lbl_uni = new JLabel("Universidad Técnologica de Panamá ");
        lbl_uni.setBounds(40,105,400,20);
        lbl_uni.setFont(fnt_text);
        ventana2.add(lbl_uni);

        lbl_year = new JLabel("2022");
        lbl_year.setBounds(40,130,400,20);
        lbl_year.setFont(fnt_text);
        ventana2.add(lbl_year);

        ventana2.setVisible(true);
    }

}

