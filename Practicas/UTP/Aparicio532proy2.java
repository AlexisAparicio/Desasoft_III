import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.*;
import java.util.*;
import java.io.*;



public class Aparicio532proy2 implements ActionListener{
private JFrame ventana;
private JButton btn_solve,btn_iniciar2,btn_iniciar,btn_tmp,btn_iniciar3;
private Integer[] btn_validar = new Integer[16];
private JButton[] btn_boton;
private JLabel jl_select,jl_try,jl_location;
private JLabel l_nombre,l_uni,l_curso,l_prof,l_time;
private JTextField tf_boton,tf_try,tf_lock,tf_time;
private int dirX=5,dirY=5,control=0,control2=0;
public int cont=0,time=0;
public int num;

DefaultListModel<String> listModel;
JList<String> lst_lista;
JScrollPane listScroller;

Random rnd = new Random();

Timer timer = new Timer(1000, new ActionListener()
{
    public void actionPerformed(ActionEvent e)
    {   
        time++;
        tf_time.setText(String.valueOf(time));
        validar();
    }
});

    Timer timerIni2 = new Timer(9, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            int x = btn_boton[14].getLocation().x, y = btn_boton[14].getLocation().y;
            int x2 = btn_boton[15].getLocation().x;
            btn_boton[14].setLocation(x + dirX, y);
            btn_boton[15].setLocation(x2 - dirX, y);
            if (x + dirX >= control && x2 - dirX == control2) {
              timerIni2.stop();
              
            }
        }
    });

    Timer timerMoveXX = new Timer(9, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            int x = btn_tmp.getLocation().x, y = btn_tmp.getLocation().y;
            int x2 = btn_boton[15].getLocation().x;
            btn_tmp.setLocation(x + dirX, y);
            btn_boton[15].setLocation(x2 - dirX, y);
            if (x + dirX >= control && x2 - dirX == control2) {
                timerMoveXX.stop();
            }
        }
    });

    Timer timerMoveXT= new Timer(9, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            int x = btn_tmp.getLocation().x, y = btn_tmp.getLocation().y;
            int x2 = btn_boton[15].getLocation().x;
            btn_tmp.setLocation(x - dirX, y);
            btn_boton[15].setLocation(x2 + dirX, y);
            if (x - dirX >= control && x2 + dirX == control2) {
                timerMoveXT.stop();
            }
        }
    });

    Timer timerMoveYT = new Timer(9, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            int x = btn_tmp.getLocation().x, y = btn_tmp.getLocation().y;
            int y2 = btn_boton[15].getLocation().y;
            btn_tmp.setLocation(x, y + dirY);
            btn_boton[15].setLocation(x, y2 - dirY);
            if (y + dirY >= control && y2 - dirY == control2) {
                timerMoveYT.stop();
            }
        }
    });

    Timer timerMoveYY = new Timer(9, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            int x = btn_tmp.getLocation().x, y = btn_tmp.getLocation().y;
            int y2 = btn_boton[15].getLocation().y;
            btn_tmp.setLocation(x, y - dirY);
            btn_boton[15].setLocation(x, y2 + dirY);
            if (y - dirY >= control && y2 + dirY == control2) {
                timerMoveYY.stop();
            }

        }
    });
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

        l_time = new JLabel("Tiempo");
        l_time.setBounds(600,25,75,20);
        ventana.add(l_time);

        tf_time = new JTextField();
        tf_time.setBounds(790,25,50,20);
        ventana.add(tf_time);

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
        btn_solve = new JButton("Resolver");
        btn_solve.setBounds(600,125,80,35);
        btn_solve.addActionListener(this);
        ventana.add(btn_solve);
        btn_iniciar2 = new JButton("Iniciar 2");
        btn_iniciar2.setBounds(685,125,80,35);
        btn_iniciar2.setActionCommand("white");
        btn_iniciar2.addActionListener(this);
        ventana.add(btn_iniciar2);
        btn_iniciar = new JButton("Iniciar");
        btn_iniciar.setBounds(770,125,80,35);
        btn_iniciar.setActionCommand("white");
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
            btn_boton[i].setBounds(75+45*(i%4),75+45*(i/4),40,40);
            btn_boton[i].addActionListener(this);
            ventana.add(btn_boton[i]);
        }
        btn_boton[15].setActionCommand("white");
        btn_boton[15].setVisible(false);

        listModel = new DefaultListModel<String>();
        lst_lista = new JList<String>(listModel);

        listScroller = new JScrollPane(lst_lista);
        listScroller.setBounds(600,340,300,100);
        ventana.add(listScroller);


        ventana.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==btn_iniciar)
            {  
                leer();
                int x,y,j;
                 for (int i=0;i<15;i++)
                        {
                        j=rnd.nextInt(15);
                        x=btn_boton[i].getLocation().x;
                        y=btn_boton[i].getLocation().y;

                        btn_boton[i].setLocation(btn_boton[j].getLocation().x,btn_boton[j].getLocation().x);
                        btn_boton[i].setLocation(btn_boton[j].getLocation().x,btn_boton[j].getLocation().y);
                        btn_boton[j].setLocation(x,y);
                        }   
                        timer.start();
             }
             if(e.getActionCommand()!=("white"))
             {btn_tmp = (JButton) e.getSource();
             if (e.getSource() == btn_tmp && e.getSource() != btn_iniciar ) 
             {
                  btn_tmp = (JButton)e.getSource();
                  if (btn_tmp.getLocation().x + 45 == btn_boton[15].getLocation().x
                  && btn_tmp.getLocation().y == btn_boton[15].getLocation().y) {
                control = btn_boton[15].getLocation().x;
                control2 = btn_tmp.getLocation().x;
                timerMoveXX.start();

          }

          if (btn_tmp.getLocation().x - 45 == btn_boton[15].getLocation().x
                  && btn_tmp.getLocation().y == btn_boton[15].getLocation().y) {
              control = btn_boton[15].getLocation().x;
              control2 = btn_tmp.getLocation().x;
              timerMoveXT.start();
          }

          if (btn_tmp.getLocation().y + 45 == btn_boton[15].getLocation().y
                  && btn_tmp.getLocation().x == btn_boton[15].getLocation().x) {
              control = btn_boton[15].getLocation().y;
              control2 = btn_tmp.getLocation().y;
              timerMoveYT.start();
          }

          if (btn_tmp.getLocation().y - 45 == btn_boton[15].getLocation().y
                  && btn_tmp.getLocation().x == btn_boton[15].getLocation().x) {
              control = btn_boton[15].getLocation().y;
              control2 = btn_tmp.getLocation().y;
              timerMoveYY.start();
          }
                 cont++;
             }
          tf_try.setText(String.valueOf(cont));   
    }
    if(e.getSource()==btn_solve)
    {     leer();
         timer.stop();
        grabar();
    }
    if(e.getSource()==btn_iniciar2)
{
        leer();
        timer.start();
        control = btn_boton[15].getLocation().x;
        control2 = btn_boton[14].getLocation().x;
        timerIni2.start();
      
    }
}
    public void grabar()
    {
        JOptionPane.showMessageDialog(ventana,"Lo Lograste, tu tiempo fue de : "+time+" Segundos");
        String nombre = JOptionPane.showInputDialog("Ingresa tu nombre");
        FileWriter fw;
        btn_iniciar3.setText("Reiniciar");
        timer.stop();
        try{
            fw= new FileWriter("Jugadores.txt",true);
            fw.write("Jugador con mejor tiempo; "+nombre+" con "+time+"Segundos"+"\r\n");
            fw.close();
        }
        catch(Exception i)
        {
            System.out.println("Error al grabar"+i.toString());
        }
    }
    public void leer()
    {
        try
        {
            File f = new File("Jugadores.txt");
            Scanner sc;
            String nombre, jugador,jugador2;
            sc = new Scanner(f);
            while (sc.hasNextLine())
            {
                nombre = sc.nextLine();
                jugador = sc.nextLine();
                jugador2 = sc.nextLine();
 
                listModel.addElement(nombre +"  "+"\n\r"); 
                sc.close();
            }
        }
        catch (Exception e)
        {
            System.out.println("Error lectura "+e.toString());
        }
    }

    public void validar() {
        boolean Win = true;
        for (int i = 0; i < 15; i++) {
            if (btn_validar[i] == (btn_boton[i].getLocation().x + btn_boton[i].getLocation().y)) {
                continue;
            } else {
                Win = false;
                break;
            }
        }
        if (Win == true) {
            timer.stop();
            JOptionPane.showMessageDialog(ventana,"Ganaste, tu tiempo fue de: " + time + " segundos: ");
            tf_time.setText(String.valueOf("0"));
            btn_iniciar.setText("Reiniciar");
        }
    }

}
