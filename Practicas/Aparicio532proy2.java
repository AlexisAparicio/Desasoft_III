import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class Aparicio532proy2 implements ActionListener{
private JFrame ventana;
private JButton btn_show,btn_hide,btn_iniciar;
private JButton[] btn_boton;
private JLabel jl_select,jl_try,jl_location;
private JLabel l_nombre,l_uni,l_curso,l_prof;
private JTextField tf_boton,tf_try,tf_lock;
public int cont;
public int num;


    public static void main(String[]args)
    {
        new Aparicio532proy2();
    }

    Aparicio532proy2()
    {
        //Ventana
        ventana = new JFrame("Rompecabeza");
        ventana.setBounds(100,100,1000,1000);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jl_select = new JLabel("Boton Seleccionado");
        jl_select.setBounds(600,50,150,20);
        ventana.add(jl_select);

        //TextField
        tf_boton=new JTextField();
        tf_boton.setBounds(790,50,50,20);
        ventana.add(tf_boton);

        jl_try = new JLabel("Cantidad de intentos");
        jl_try.setBounds(600,75,150,20);
        ventana.add(jl_try);

        //TextField
        tf_try=new JTextField();
        tf_try.setBounds(790,75,50,20);
        ventana.add(tf_try);

        jl_location = new JLabel("Resolver");
        jl_location.setBounds(600,100,200,20);
        ventana.add(jl_location);

        //TextField
        tf_lock=new JTextField();
        tf_lock.setBounds(790,100,50,20);
        ventana.add(tf_lock);

        //Botones
        btn_show = new JButton("Mostrar");
        btn_show.setBounds(600,125,80,35);
        btn_show.addActionListener(this);
        ventana.add(btn_show);
        btn_hide = new JButton("Ocultar");
        btn_hide.setBounds(685,125,80,35);
        btn_hide.addActionListener(this);
        ventana.add(btn_hide);
        btn_iniciar = new JButton("Iniciar");
        btn_iniciar.setBounds(770,125,80,35);
        btn_iniciar.addActionListener(this);
        ventana.add(btn_iniciar);

        l_nombre = new JLabel("Bolivar Alexis Aparicio Bedoya");
        l_nombre.setBounds(600,200,300,30);
        ventana.add(l_nombre);
        l_uni = new JLabel("Universidad Tecnologica de Panama");
        l_uni.setBounds(600,235,300,30);
        ventana.add(l_uni);
        l_prof= new JLabel("Ricardo Chan");
        l_prof.setBounds(600,270,300,30);
        ventana.add(l_prof);
        l_curso = new JLabel("Licenciatura en Desarrollo de Software Grupo ILS-221");
        l_curso.setBounds(600,305,400,30);
        ventana.add(l_curso);

        btn_boton = new JButton[16];
        for(int i=0;i<16;i++)
        {
            btn_boton[i]=new JButton(String.valueOf(i+1));
            btn_boton[i].setBounds(75+41*(i%4),75+41*(i/4),40,40);
            btn_boton[i].addActionListener(this);
            ventana.add(btn_boton[i]);
        }

        btn_boton[15].setVisible(false);
        ventana.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
            {
               
        }
     public static int pescado( int rndd )
     {
         Random rnd = new Random();
         int upperbound = 100;
         int int_rnd= rnd.nextInt(upperbound);
         rndd=int_rnd;
         return rndd;
     }
}
