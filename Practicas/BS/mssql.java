package BS;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class mssql implements ActionListener
{
    JFrame ventana;
    DefaultListModel<String> listModel;
    JList<String> lst_cliente;
    JScrollPane sp_cliente;
    JButton btn_listar,btn_add,btn_busc,btn_mod,btn_delete;

    String URL,user,pass;

    JLabel lbl_cedula,lbl_nombre,lbl_apellido;
    JTextField tf_cedula,tf_nombre,tf_apellido;
    
    db db = new db();
    Cliente cliente = new Cliente();

    public static void main(String[]args)
    {
        new mssql();
    }

    mssql()
    {
        ventana =  new JFrame("Ventana");
        ventana.setBounds(100,100,800,800);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(null);

        listModel = new DefaultListModel<String>();
        lst_cliente = new JList<String>(listModel);
        sp_cliente = new JScrollPane(lst_cliente);
        sp_cliente.setBounds(50,50,200,200);
        ventana.add(sp_cliente);

        btn_busc = new JButton("Buscar");
        btn_busc.setBounds(260,50,85,20);
        btn_busc.addActionListener(this);
        ventana.add(btn_busc);

        btn_listar = new JButton("Listar");
        btn_listar.setBounds(260,80,85,20);
        btn_listar.addActionListener(this);
        ventana.add(btn_listar);

        btn_add = new JButton("Agregar");
        btn_add.setBounds(260,110,85,20);
        btn_add.addActionListener(this);
        btn_add.setEnabled(false);
        ventana.add(btn_add);

        btn_mod = new JButton("Modificar");
        btn_mod.setBounds(260,135,85,20);
        btn_mod.addActionListener(this);
        btn_mod.setEnabled(false);
        ventana.add(btn_mod);

        btn_delete = new JButton("Borrar");
        btn_delete.setBounds(260,160,85,20);
        btn_delete.addActionListener(this);
        btn_delete.setEnabled(false);
        ventana.add(btn_delete);

        lbl_cedula = new JLabel("Cedula: ");
        lbl_cedula.setBounds(350,50,85,20);
        ventana.add(lbl_cedula);

        tf_cedula = new JTextField();
        tf_cedula.setBounds(455,50,80,20);
        ventana.add(tf_cedula);

        lbl_nombre = new JLabel("Nombre: ");
        lbl_nombre.setBounds(350,80,80,20);
        ventana.add(lbl_nombre);

        tf_nombre = new JTextField();
        tf_nombre.setBounds(455,80,80,20);
        ventana.add(tf_nombre);

        lbl_apellido = new JLabel("Apellido: ");
        lbl_apellido.setBounds(350,110,80,20);
        ventana.add(lbl_apellido);

        tf_apellido = new JTextField();
        tf_apellido.setBounds(455,110,80,20);
        ventana.add(tf_apellido);

        ventana.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==btn_listar)
        listar();

        if(e.getSource()==btn_add)
        Agregar();

        if(e.getSource()==btn_busc)
        Buscar();

        if(e.getSource()==btn_mod)
       Modificar();

       if(e.getSource()==btn_delete)
       Borrar();
    }

    public void listar()
    {
        cliente.listar(listModel);
    }

    public void Agregar()
    {
        String cedula,nombre,apellido;
        String sql;

        cedula="";
        nombre="";
        apellido="";
        sql="";

        try 
        {
            sql = "insert into Clientes(cedula,nombre,apellido) values('";
            sql = sql+tf_cedula.getText()+"','"+ tf_nombre.getText()+"','"+tf_apellido.getText()+"')";
            System.out.println(sql);
            db.executeUpdate(sql);

        } 
        catch (Exception e) 
        {
            System.out.println("error "+ e.toString());
        }
    }

    public void Buscar()
    {
        if(cliente.buscar(tf_cedula.getText()))
        {
            btn_mod.setEnabled(true);
            btn_add.setEnabled(false);
            btn_delete.setEnabled(true);
        }
        else
        {
            btn_mod.setEnabled(false);
            btn_add.setEnabled(true);
            btn_delete.setEnabled(false);
        }
        tf_cedula.setText(cliente.getCedula());
        tf_nombre.setText(cliente.getNombre());
        tf_apellido.setText(cliente.getApellido());
    }
       

    public void Modificar()
    {
        String cedula,nombre,apellido;
        String sql;

        cedula="";
        nombre="";
        apellido="";
        sql="";

        try 
        {
          //sql = "update Clientes set nombre='Maria_c', apellido='Rodriguez_c' where cedula='8-877-1532'";
            sql = "update Clientes set nombre='"+tf_nombre.getText()+"', ";
            sql=sql+"apellido='"+tf_apellido.getText()+"'";
            sql=sql+"where cedula='"+tf_cedula.getText()+"'";
            System.out.println(sql);
            db.executeUpdate(sql);

        } 
        catch (Exception e) 
        {
            System.out.println("error "+ e.toString());
        }
    }

    public void Borrar()
    {
        String cedula,nombre,apellido;
        String sql;

        cedula="";
        nombre="";
        apellido="";
        sql="";

        try 
        {
         sql = "delete from Clientes where cedula='"+tf_cedula.getText()+"'";
            
            System.out.println(sql);
            db.executeUpdate(sql);
            tf_apellido.setText(apellido);
            tf_nombre.setText(nombre);
        } 
        catch (Exception e) 
        {
            System.out.println("error "+ e.toString());
        }
    }
}
