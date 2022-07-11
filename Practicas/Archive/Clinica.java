import javax.swing.*;
import java.awt.event.*;

public class Clinica  implements ActionListener{
    JFrame ventana;
    JLabel lbl_Padre,lbl_Madre,lbl_hijo,lbl_instruccion,lbl_res;
    JTextField tf_Padre,tf_Madre,tf_Hijo;
    JButton btn_Res;

    public static void main(String[]args)
    {
        new Clinica();
    }

    Clinica()
    {
        ventana = new JFrame("Clinica de Ojos");
        ventana.setBounds(100,100,700,500);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Labels

        lbl_instruccion = new JLabel("Indicar el color de ojos con las siguientes indicaciones marrón (M) o verdes (V). ");
        lbl_instruccion.setBounds(40,15,550,20);
        ventana.add(lbl_instruccion);

        lbl_Padre = new JLabel("Color de Ojos del Padre");
        lbl_Padre.setBounds(40,40,200,30);
        ventana.add(lbl_Padre);

        lbl_Madre= new JLabel("Color de Ojos de la Madre");
        lbl_Madre.setBounds(40,75,200,30);
        ventana.add(lbl_Madre);

        lbl_res = new JLabel("Resultado");
        lbl_res.setBounds(40,100,150,20);
        ventana.add(lbl_res);

        lbl_hijo = new JLabel("Color de Ojos del Hijo");
        lbl_hijo.setBounds(40,140,200,30);
        ventana.add(lbl_hijo);

        // Casillas de Texto
        tf_Padre= new JTextField();
        tf_Padre.setBounds(250,40,30,20);
        ventana.add(tf_Padre);

        tf_Madre= new JTextField();
        tf_Madre.setBounds(250,75,30,20);
        ventana.add(tf_Madre);

        tf_Hijo= new JTextField();
        tf_Hijo.setBounds(250,140,30,20);
        ventana.add(tf_Hijo);


        //Botones

        btn_Res = new JButton("Resultado");
        btn_Res.setBounds(250,110,100,30);
        btn_Res.addActionListener(this);
        ventana.add(btn_Res);


        ventana.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        String res;
        if(e.getSource()==btn_Res)
        {
            if(tf_Padre.getText().equals("V")&&tf_Madre.getText().equals("V"))
            res="V";

           else if(tf_Padre.getText().equals("M")&&tf_Madre.getText().equals("M"))
          {  res="M";
        } 
          else{
        
            res="M";
          }
        tf_Hijo.setText(String.valueOf(res));
        }
    }
    
}
