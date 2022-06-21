import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class Aparicio532proy1 implements ActionListener{
private JFrame ventana;
private JButton btn_show,btn_hide,btn_iniciar;
private JButton[] btn_boton;
private JLabel jl_select,jl_try,jl_location,jl_sr,jl_nr,jl_es,jl_oe,jl_cor;
private JLabel l_nombre,l_uni,l_curso,l_prof;
private JTextField tf_boton,tf_try,tf_lock;
public int cont;
public int num;


    public static void main(String[]args)
    {
        new Aparicio532proy1();
    }

    Aparicio532proy1()
    {
        //Ventana
        ventana = new JFrame("Pesca de cardumen");
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

        jl_location = new JLabel("Localización del cardumen");
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

        jl_sr =new JLabel("Sur");
        jl_sr.setBounds(260,545,35,20);
        ventana.add(jl_sr);

        jl_es =new JLabel("Este");
        jl_es.setBounds(530,270,35,20);
        ventana.add(jl_es);

        jl_nr =new JLabel("Norte");
        jl_nr.setBounds(260,35,35,20);
        ventana.add(jl_nr);

        jl_oe =new JLabel("Oeste");
        jl_oe.setBounds(5,270,45,20);
        ventana.add(jl_oe);
 
        btn_boton = new JButton[100];
        for(int i=0;i<100;i++)
        {
            btn_boton[i]=new JButton(String.valueOf(i));
            btn_boton[i].setBounds(75+45*(i%10),75+45*(i/10),40,40);
            btn_boton[i].addActionListener(this);
            ventana.add(btn_boton[i]);
        }
        for(int y=0;y<10;y++)
        {
            for(int x=0;x<10;x++)
        {   //Coordenadas de numeros izquierdos
            jl_cor=new JLabel(String.valueOf(x+1));
            jl_cor.setBounds(55+45*(x/10),75+45*(x%10),40,40);
            ventana.add(jl_cor);
        }
            //Coordenadas de numeros Inferiores
            jl_cor=new JLabel(String.valueOf(y+1));
            jl_cor.setBounds(90+45*(y%10),510+45*(y/10),40,40);
            ventana.add(jl_cor);
        }
    
        
        ventana.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
            {
                if(e.getSource()== btn_iniciar)
                { cont=0;
                num=pescado(num);
                }
                if(e.getSource()!=btn_boton[num])
            {
                cont++;
                tf_try.setText(String.valueOf(cont));          
            }
                if(e.getSource()==btn_show)
                {   
                    tf_lock.setText(String.valueOf(num));
                    tf_lock.setVisible(true);
                }
                if(e.getSource()==btn_hide)
                {
                    tf_lock.setText(String.valueOf(num));
                    tf_lock.setVisible(false);
                }
                    if(e.getSource()==btn_boton[num])
                    { 
                    JOptionPane.showMessageDialog(ventana,"Lo Lograste");
                    }
                    if(e.getSource()==btn_boton[num-10])
                {
                    num=pescado(num);
                    JOptionPane.showMessageDialog(ventana,"Oh el cardumen se movio");
                }
                if(e.getSource()==btn_boton[num-11])
                {
                    num=pescado(num);
                    JOptionPane.showMessageDialog(ventana,"Oh el cardumen se movio");
                }
                if(e.getSource()==btn_boton[num-9])
                    {
                        num=pescado(num);
                        JOptionPane.showMessageDialog(ventana,"Oh el cardumen se movio");
                    }
                if(e.getSource()==btn_boton[num-1])
                    {
                        num=pescado(num);
                        JOptionPane.showMessageDialog(ventana,"Oh el cardumen se movio");
                    }
                if(e.getSource()==btn_boton[num+1])
                {
                    num=pescado(num);
                    JOptionPane.showMessageDialog(ventana,"Oh el cardumen se movio");
                }
                if(e.getSource()==btn_boton[num+10])
                {
                    num=pescado(num);
                    JOptionPane.showMessageDialog(ventana,"Oh el cardumen se movio");
                }
                if(e.getSource()==btn_boton[num+11])
                {
                    num=pescado(num);
                    JOptionPane.showMessageDialog(ventana,"Oh el cardumen se movio");
                }
                if(e.getSource()==btn_boton[num+9])
                {
                    num=pescado(num);
                    JOptionPane.showMessageDialog(ventana,"Oh el cardumen se movio");
                }
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
