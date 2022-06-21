import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class guess  implements ActionListener{
    JFrame ventana;
    JLabel lbl_info, lbl_reiniciar,lbl_res;
    JTextField tf_num1,tf_res;
    JButton btn_reiniciar,btn_comprobar,btn_inicio;

    public static void main(String[]args)
    { 
        new guess();
    }

    guess()
    {
        ventana=new JFrame("Adivinanza");
        ventana.setBounds(100,100,500,500);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Label //
        lbl_info= new JLabel("Juego de Adivinanza");
        lbl_info.setBounds(40,40,200,20);
        ventana.add(lbl_info);

        //Casilla de Texto//
        tf_num1 = new JTextField();
        tf_num1.setBounds(50,90,50,20);
        ventana.add(tf_num1);

        //Botones//
        btn_reiniciar= new JButton("Reiniciar el juego");
        btn_reiniciar.setBounds(40,190,150,20);
        btn_reiniciar.addActionListener(this);
        ventana.add(btn_reiniciar);

        btn_comprobar = new JButton("comprobar");
        btn_comprobar.setBounds(200,190,120,20);
        btn_comprobar.addActionListener(this);
       ventana.add(btn_comprobar);

        btn_inicio = new JButton("Iniciar");
        btn_inicio.setBounds(40,150,100,20);
        btn_inicio.addActionListener(this);
        ventana.add(btn_inicio);


        ventana.setVisible(true);
    }

public void actionPerformed(ActionEvent e)
{
    
    //int num1 = Integer.parseInt(tf_num1.getText());

    if(e.getSource()==btn_inicio)
    {
        Random rnd= new Random();
        tf_num1.setText(String.valueOf(rnd.nextInt(100)));
    }

}

}
