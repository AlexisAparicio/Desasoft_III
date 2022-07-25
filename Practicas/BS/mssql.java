package BS;

import javax.swing.*;
import javax.swing.table.*;

import java.awt.event.*;
import java.sql.*;

public class mssql implements ActionListener
{
    JFrame ventana;
    JComboBox<String> cb_provincia;
    DefaultListModel<String> listModel;
    JList<String> lst_cliente;
    JScrollPane sp_cliente;
    JButton btn_listar,btn_add,btn_busc,btn_mod,btn_delete,btn_listar2,btn_escoger;

    DefaultTableModel dtm_cliente;
    JTable jt_cliente;
    JScrollPane sp_cliente2;
    String URL,user,pass;

    JLabel lbl_cedula,lbl_nombre,lbl_apellido,lbl_provincia;
    JTextField tf_cedula,tf_nombre,tf_apellido;
    
    db db = new db();
    Cliente cliente = new Cliente();
    provincia provincia =  new provincia();

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

        dtm_cliente = new DefaultTableModel();
        jt_cliente = new JTable(dtm_cliente);
        sp_cliente2 = new JScrollPane(jt_cliente);
        sp_cliente2.setBounds(50,260,200,200);
        ventana.add(sp_cliente2);

        btn_busc = new JButton("Buscar");
        btn_busc.setBounds(260,50,85,20);
        btn_busc.addActionListener(this);
        ventana.add(btn_busc);

        btn_listar = new JButton("Listar");
        btn_listar.setBounds(260,80,85,20);
        btn_listar.addActionListener(this);
        ventana.add(btn_listar);

        btn_listar2 = new JButton("Listar2 ");
        btn_listar2.setBounds(260,260,120,20);
        btn_listar2.addActionListener(this);
        ventana.add(btn_listar2);

        btn_escoger = new JButton("Escoger");
        btn_escoger.setBounds(260,285,120,20);
        btn_escoger.addActionListener(this);
        ventana.add(btn_escoger);

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

        lbl_provincia = new JLabel("Provincia");
        lbl_provincia.setBounds(350,135,80,20);
        ventana.add(lbl_provincia);

        cb_provincia = new JComboBox<String>();
        provincia.cargar(cb_provincia);
        cb_provincia.setBounds(435,135,90,20);
        ventana.add(cb_provincia);

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
       if(e.getSource()==btn_listar2)
       listar2();
       if(e.getSource()==btn_escoger)
       escoger();
    }

    public void listar()
    {
        cliente.listar(listModel);
    }
    public void listar2()
    {
        cliente.listar(dtm_cliente);
    }

    public void Agregar()
    {
        cliente.setCedula(tf_cedula.getText());
        cliente.setNombre(tf_nombre.getText());
        cliente.setApellido(tf_apellido.getText());
        cliente.agregar();

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
        cb_provincia.setSelectedItem(cliente.getNombreProvincia());
        //tf_cedula.setEnabled(false);
    }
       

    public void Modificar()
    {
        cliente.setCedula(tf_cedula.getText());
        cliente.setNombre(tf_nombre.getText());
        cliente.setApellido(tf_apellido.getText());
        cliente.modificar();   
    }

    public void Borrar()
    {
        cliente.setCedula(tf_cedula.getText());
       // cliente.setNombre(tf_nombre.getText());
        //cliente.setApellido(tf_apellido.getText());
        cliente.eliminar(); 
    }
    public void escoger()
    {
        int fila;
        fila= jt_cliente.getSelectedRow();
        tf_cedula.setText(jt_cliente.getValueAt(fila,0).toString());
        // tf_nombre.setText(jt_cliente.getValueAt(fila,1).toString());
        // tf_apellido.setText(jt_cliente.getValueAt(fila,2).toString());
        Buscar();
    }
}
