import javax.swing.*;
import java.awt.event.*;

public class CrearBotones implements ActionListener{

   private  JFrame ventana;
   private JButton btn_boton1,btn_boton2,btn_boton3;
   private JButton btn_boton;
   private JTextField tf_boton;
    
    public static void main(String[]args)
    {
        new CrearBotones();
    }

    CrearBotones()
    {
        ventana= new JFrame("Crear Botones");
        ventana.setBounds(100,100,400,400);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tf_boton= new JTextField("");
        tf_boton.setBounds(100,25,50,20);
        ventana.add(tf_boton);

        btn_boton1 = new JButton("A");
        btn_boton1.setBounds(50,50,50,20);
        btn_boton1.addActionListener(this);
        ventana.add(btn_boton1);

        btn_boton2 = new JButton("B");
        btn_boton2.setBounds(105,50,50,20);
        btn_boton2.addActionListener(this);
        ventana.add(btn_boton2);

        btn_boton3 = new JButton("C");
        btn_boton3.setBounds(160,50,50,20);
        btn_boton3.addActionListener(this);
        ventana.add(btn_boton3);

        for(int i=0;i<3;i++)
        {
            btn_boton = new JButton(String.valueOf(i+1));
            btn_boton.setBounds(50+55*i,75,50,20);
            btn_boton.addActionListener(this);
            ventana.add(btn_boton);
        }

        ventana.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()== btn_boton1)
        tf_boton.setText(btn_boton1.getText());
    }
}