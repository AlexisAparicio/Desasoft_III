import javax.swing.*;
import java.awt.event.*;


public class Contador implements ActionListener {
    private JFrame ventana;
    private JLabel lbl_contador;
    private JTextField tf_contador;
    private JButton btn_contador,btn_stop;
    Timer timer = new Timer(1000, new ActionListener()
    {
        public void actionPerformed(ActionEvent e){
        int v;
        v=Integer.parseInt(tf_contador.getText());
        tf_contador.setText(String.valueOf(v+1));
    }
    }
    );
    public static void main(String[]args)
    {
       new Contador();
    }

    Contador()
    {
        ventana = new JFrame("Contador");
        ventana.setBounds(100,100,1000,1000);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lbl_contador = new JLabel("Contador");
        lbl_contador.setBounds(40,40,80,20);
        ventana.add(lbl_contador);

        tf_contador = new JTextField("0");
        tf_contador.setBounds(125,40,50,20);
        ventana.add(tf_contador);

        btn_contador = new JButton("Contar");
        btn_contador.setBounds(180,40,100,20);
        btn_contador.addActionListener(this);
        ventana.add(btn_contador);

        btn_stop = new JButton("STOP");
        btn_stop.setBounds(285,40,100,20);
        btn_stop.addActionListener(this);
        ventana.add(btn_stop);



        ventana.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==btn_contador)
        {
            timer.start();
        }
        if(e.getSource()==btn_stop)
        {
            timer.stop();
        }
    }

}
