import javax.swing.*;
import java.awt.event.*;

public class Mover implements ActionListener{
    private JFrame ventana;
    private JButton btn_boton,btn_arriba,btn_abajo,btn_izq,btn_derecha,btn_auto,btn_stop;
    private int dir,dir2;
    Timer timer = new Timer(500, new ActionListener()
    {
        public void actionPerformed(ActionEvent e){
            int x,y;
            x=btn_boton.getLocation().x;
            y=btn_boton.getLocation().y;
            btn_boton.setLocation(x+dir2,y+dir);
            if(y+dir<0|| y+dir>ventana.getHeight() -40) 
            dir=-dir;

            if(x+dir2<0|| x+dir2>ventana.getWidth() -40) 
            dir2=-dir2;

            //             dir=+10;
            //           if(y+dir>ventana.getHeight()) 
            //         dir=-10;

            /* if(x+dir2<0) 
             dir2=+10;
             if(x+dir2>ventana.getWidth()) 
             dir2=-10;
             */

            
    }
    }
    );
    public static void main(String[]args)
    {
        new Mover();
    }

    Mover()
    {
        ventana = new JFrame("Animación");
        ventana.setBounds(100,100,1000,1000);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btn_boton = new JButton("Boton");
        btn_boton.setBounds(40,40,60,30);
        ventana.add(btn_boton);

        btn_auto = new JButton("Auto");
        btn_auto.setBounds(105,10,50,20);
        btn_auto.addActionListener(this);
        ventana.add(btn_auto);

        btn_stop = new JButton("Stop");
        btn_stop.setBounds(160,10,50,20);
        btn_stop.addActionListener(this);
        ventana.add(btn_stop);

        btn_arriba= new JButton("subir");
        btn_arriba.setBounds(105,40,60,30);
        btn_arriba.addActionListener(this);
        ventana.add(btn_arriba);
        
        btn_abajo = new JButton("Bajar");
        btn_abajo.setBounds(105,75,60,30);
        btn_abajo.addActionListener(this);
        ventana.add(btn_abajo);

        btn_izq = new JButton("izq");
        btn_izq.setBounds(170,40,60,30);
        btn_izq.addActionListener(this);
        ventana.add(btn_izq);

        btn_derecha = new JButton("derecha");
        btn_derecha.setBounds(170,75,60,30);
        btn_derecha.addActionListener(this);
        ventana.add(btn_derecha);

        ventana.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==btn_abajo)
           dir=+10;
        if(e.getSource()==btn_arriba) 
        dir=-10;
        if(e.getSource()==btn_izq)
        dir2=-10;
         if(e.getSource()==btn_derecha) 
        dir2=+10;
        if(e.getSource()==btn_auto)
        {
            timer.start();
        }
        if(e.getSource()==btn_stop)
        {
            timer.stop();
        }

    }


}
