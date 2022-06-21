import javax.swing.JFrame;

public class Menu2 {
private JFrame ventana;
    public static void main(String[]args)
    {
        new Menu();
    }

    Menu2() 
    {
        ventana =  new JFrame ("Menu");
        ventana.setBounds(100,100,500,500);
        ventana.setLayout(null);

        ventana.setVisible(true);
    }
}
