import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class Pizza  implements ActionListener{
    JFrame ventana;
    JLabel lbl_G,lbl_M,lbl_p,lbl_instruccion,lbl_instruccion2,lbl_ing,lbl_res;
    JTextField tf_p,tf_ing,tf_res;
    JButton btn_Res;

    public static void main(String[]args)
    {
        new Pizza();
    }

    Pizza()
    {
        //Ventana
        ventana = new JFrame("Pedidos de Pizza");
        ventana.setBounds(100,100,800,500);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Labels
        lbl_instruccion = new JLabel("Seleccionar su pizza Costos: Pizza pequeña =1.00, Mediana=2.00 y Grande=4.00 ");
        lbl_instruccion.setBounds(40,15,550,20);
        ventana.add(lbl_instruccion);

        lbl_instruccion = new JLabel("1.50 por ingrediente. Si es Mediana, adicionar 0.25 por ingrediente y si es Grande adicionar 0.50 por ingrediente.");
        lbl_instruccion.setBounds(40,40,750,20);
        ventana.add(lbl_instruccion);

        lbl_G =  new JLabel("Pizza Grande ingresar (G)");
        lbl_G.setBounds(40,75,150,20);
        ventana.add(lbl_G);

        lbl_M=  new JLabel("Pizza Mediana ingresar (M)");
        lbl_M.setBounds(220,75,200,20);
        ventana.add(lbl_M);

        lbl_p=  new JLabel("Pizza Pequeña ingresar (P)");
        lbl_p.setBounds(420,75,200,20);
        ventana.add(lbl_p);

        lbl_ing=  new JLabel("El monto total es ");
        lbl_ing.setBounds(40,155,200,20);
        ventana.add(lbl_ing);

        //Casilla de texto
        tf_p = new JTextField("Ingresar su tamaño");
        tf_p.setBounds(40,100,150,30);
        ventana.add(tf_p);

        tf_ing= new JTextField("Ingresar la cantidad de ingrediente");
        tf_ing.setBounds(200,100,250,30);
        ventana.add(tf_ing);

        tf_res=new JTextField();
        tf_res.setBounds(175,155,100,20);
        ventana.add(tf_res);

        //Boton
        btn_Res = new JButton("Ordenar");
        btn_Res.setBounds(40,130,100,20);
        btn_Res.addActionListener(this);
        ventana.add(btn_Res);

        ventana.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        double res=0.00,ing=1.50,size=0.00,adM=0.25,adG=0.50;
        int num1=0;
        num1= Integer.parseInt(tf_ing.getText()); 

        if(e.getSource()==btn_Res)
        {
            if(tf_p.getText().equals("P"))
            {System.out.println("ProtocoloP");
            size=1.00;
            res=ing+size;
        }
            if(tf_p.getText().equals("M"))
            {System.out.println("ProtocoloM");
            size=2.00;
            res=(size+ing)+(adM*num1);
        }
            if(tf_p.getText().equals("G"))
            {System.out.println("ProtocoloG");
            size=4.00;
            res=(size+ing)+(adG*num1);
        }
        }
        tf_res.setText(String.valueOf(res));

    }
    
}
