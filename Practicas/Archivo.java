import javax.swing.*;
import java.awt.event.*;
import java.io.FileWriter;

public class Archivo implements ActionListener{
private JFrame ventana;
private JLabel lbl_nombre,lbl_apellido;
private JTextField tf_nombre,tf_apellido;
private JButton btn_grabar;
    public static void main(String[]args)
    {
        new Archivo();
    }

    Archivo(){

        //Ventana
        ventana = new JFrame("Archivo");
        ventana.setBounds(100,100,400,400);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lbl_nombre =new JLabel("Nombre");
        lbl_nombre.setBounds(20,20,80,20);
        ventana.add(lbl_nombre);

        tf_nombre = new JTextField();
        tf_nombre.setBounds(105,20,80,20);
        ventana.add(tf_nombre);

        lbl_apellido =new JLabel("Apellido");
        lbl_apellido.setBounds(20,45,80,20);
        ventana.add(lbl_apellido);

        tf_apellido = new JTextField();
        tf_apellido.setBounds(105,45,80,20);
        ventana.add(tf_apellido);

        btn_grabar = new JButton("Grabar");
        btn_grabar.setBounds(50,70,70,40);
        btn_grabar.addActionListener(this);
        ventana.add(btn_grabar);


        ventana.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == btn_grabar) grabar();
    }

    public void grabar()
    {
        FileWriter fw;
        try{
            fw= new FileWriter("cliente.txt",true);
            fw.write(tf_nombre.getText()+"\r\n");
            fw.write(tf_apellido.getText()+"\r\n");
            fw.close();
        }
        catch(Exception e)
        {
            System.out.println("Error al grabar"+e.toString());
        }
    }


}
