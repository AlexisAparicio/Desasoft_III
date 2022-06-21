import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class boton implements ActionListener {
    private JFrame ventana;
    private JButton[] btn_prueba;
    private JButton btn_iniciar;
    private JTextField tf_prueba,tf_prueba1;
     public  int cont=0;
     public int num;

    public static void main(String[]args)
    {
        new boton();
    }
    
    boton()
    {

        ventana = new JFrame("Boton");
        ventana.setBounds(20,20,300,300);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        btn_prueba= new JButton[10];
        for(int i=0;i<10;i++)
        {
            btn_prueba[i]= new JButton(String.valueOf(i));
            btn_prueba[i].setBounds(50+45*(i%5),75+45*(i/5),40,40);
            btn_prueba[i].addActionListener(this);
            ventana.add(btn_prueba[i]);
        }

        tf_prueba = new JTextField();
        tf_prueba.setBounds(250,35,25,25);
        ventana.add(tf_prueba);

        tf_prueba1 = new JTextField();
        tf_prueba1.setBounds(200,35,25,25);
        ventana.add(tf_prueba1);

        btn_iniciar=new JButton("iniciar");
        btn_iniciar.setBounds(200,10,60,20);
        btn_iniciar.addActionListener(this);
        ventana.add(btn_iniciar);


        ventana.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    { 
        if(e.getSource()== btn_iniciar)
       { cont=0;
        num=Randoms(num);
        tf_prueba1.setText(String.valueOf(num));
       }
       
   
        cont++;
        tf_prueba.setText(String.valueOf(cont));
       
    }

    public static int Randoms( int rndd )
    {
        Random rnd = new Random();
        int upperbound = 5;
        int int_rnd= rnd.nextInt(upperbound);
        rndd=int_rnd;
        return rndd;
    }

  

}
