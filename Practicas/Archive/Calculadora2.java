import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class Calculadora2 implements ActionListener{
    JFrame ventana;
    JLabel lbl_num1, lbl_num2,lbl_res;
    JTextField tf_num1,tf_num2,tf_res;
    JButton btn_calcular,btn_sumar,btn_resta,btn_multi,btn_division;

    public static void main(String[]args)
    {
        new Calculadora2();
    }

    Calculadora2()
    {
        ventana=new JFrame("Calculadora");
        ventana.setBounds(100,100,500,500);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Labels//
        lbl_num1 = new JLabel("Valor A ");
        lbl_num1.setBounds(40,40,50,20);
        ventana.add(lbl_num1);

        lbl_num2 = new JLabel("Valor B");
        lbl_num2.setBounds(40,75,50,20);
        ventana.add(lbl_num2);

        lbl_res= new JLabel("Resultado");
        lbl_res.setBounds(20,100,70,20);
        ventana.add(lbl_res);

        // Casilla de texto
        tf_num1 = new JTextField();
        tf_num1.setBounds(95,40,50,20);
        ventana.add(tf_num1);

        tf_num2 =  new JTextField();
        tf_num2.setBounds(95,75,50,20);
        ventana.add(tf_num2);

        tf_res = new JTextField();
        tf_res.setBounds(95,100,50,20);
        ventana.add(tf_res);

        //Botones
        btn_sumar = new JButton("Sumar");
        btn_sumar.setBounds(50,125,70,20);
        btn_sumar.addActionListener(this);
        ventana.add(btn_sumar);

        btn_resta = new JButton("resta");
        btn_resta.setBounds(120,125,70,20);
        btn_resta.addActionListener(this);
        ventana.add(btn_resta);

        btn_multi = new JButton("Multiplicar");
        btn_multi.setBounds(50,150,100,20);
        btn_multi.addActionListener(this);
        ventana.add(btn_multi);

        btn_division = new JButton("Dividir");
        btn_division.setBounds(155,150,100,20);
        btn_division.addActionListener(this);
        ventana.add(btn_division);

        ventana.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {
       int num1=0,num2=0,res=0;
       num1= Integer.parseInt(tf_num1.getText());
       num2= Integer.parseInt(tf_num2.getText());

          //Boton de calcular por el cuadro de operador
        if(e.getSource()==btn_sumar)
       { System.out.println("sumar");
        res= num1+num2;
    }

        if(e.getSource()==btn_resta)
       { System.out.println("Resta");
        res=num1-num2;
}
        if(e.getSource()==btn_multi)
        {System.out.println("multi");
        res=num1*num2;
}
        if(e.getSource()==btn_division)
        {
            System.out.println("división");
        if (num1 % num2 == 0) {
         res=num1/num2;
        } else {
        JOptionPane.showMessageDialog(ventana,"NO es divisible ");
        }
    }
       tf_res.setText(String.valueOf(res));
    }

}
