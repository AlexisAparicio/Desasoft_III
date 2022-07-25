package BS;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;

import java.sql.*;

public class Mant_medico implements ActionListener
{
    JFrame ventana2;
    Font fnt_text;
    JComboBox<String> cb_especialidad;
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
    // Instancias de clases
    db db = new db();
    Personas Personas = new Personas();
    Especialidad especialidad =  new Especialidad();

    Mant_medico()
    {
        ventana2 = new JFrame("Mantenimiento de Medicos");
        ventana2.setBounds(100,100,1000,1000);
        ventana2.getContentPane().setBackground(Color.gray);
        ventana2.setLayout(null);

        dtm_cliente = new DefaultTableModel();
        jt_cliente = new JTable(dtm_cliente);
        sp_cliente2 = new JScrollPane(jt_cliente);
        sp_cliente2.setBounds(50,260,400,400);
        ventana2.add(sp_cliente2);

        btn_busc = new JButton("Buscar");
        btn_busc.setBounds(260,50,85,20);
        btn_busc.addActionListener(this);
        ventana2.add(btn_busc);

        btn_listar2 = new JButton("Listar2 ");
        btn_listar2.setBounds(260,185,120,20);
        btn_listar2.addActionListener(this);
        ventana2.add(btn_listar2);

        btn_escoger = new JButton("Escoger");
        btn_escoger.setBounds(260,210,120,20);
        btn_escoger.addActionListener(this);
        ventana2.add(btn_escoger);

        btn_add = new JButton("Agregar");
        btn_add.setBounds(260,110,85,20);
        btn_add.addActionListener(this);
        btn_add.setEnabled(false);
        ventana2.add(btn_add);

        btn_mod = new JButton("Modificar");
        btn_mod.setBounds(260,135,85,20);
        btn_mod.addActionListener(this);
        btn_mod.setEnabled(false);
        ventana2.add(btn_mod);

        btn_delete = new JButton("Borrar");
        btn_delete.setBounds(260,160,85,20);
        btn_delete.addActionListener(this);
        btn_delete.setEnabled(false);
        ventana2.add(btn_delete);

        lbl_cedula = new JLabel("Cedula: ");
        lbl_cedula.setBounds(350,50,85,20);
        ventana2.add(lbl_cedula);

        tf_cedula = new JTextField();
        tf_cedula.setBounds(455,50,80,20);
        ventana2.add(tf_cedula);

        lbl_nombre = new JLabel("Nombre: ");
        lbl_nombre.setBounds(350,80,80,20);
        ventana2.add(lbl_nombre);

        tf_nombre = new JTextField();
        tf_nombre.setBounds(455,80,80,20);
        ventana2.add(tf_nombre);

        lbl_apellido = new JLabel("Apellido: ");
        lbl_apellido.setBounds(350,110,80,20);
        ventana2.add(lbl_apellido);

        tf_apellido = new JTextField();
        tf_apellido.setBounds(455,110,80,20);
        ventana2.add(tf_apellido);

        lbl_provincia = new JLabel("Provincia");
        lbl_provincia.setBounds(350,135,80,20);
        ventana2.add(lbl_provincia);

        cb_especialidad = new JComboBox<String>();
        especialidad.cargar(cb_especialidad);
        cb_especialidad.setBounds(435,135,90,20);
        ventana2.add(cb_especialidad);


        ventana2.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
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

    public void listar2()
    {
        Personas.listarMED(dtm_cliente);
    }

    public void Agregar()
    {
        Personas.setCedula(tf_cedula.getText());
        Personas.setNombre(tf_nombre.getText());
        Personas.setApellido(tf_apellido.getText());
        Personas.agregarMED();

    }

    public void Buscar()
    {
        if(Personas.buscarMED(tf_cedula.getText()))
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
        tf_cedula.setText(Personas.getCedula());
        tf_nombre.setText(Personas.getNombre());
        tf_apellido.setText(Personas.getApellido());
        cb_especialidad.setSelectedItem(Personas.getNombreProvincia());
        //tf_cedula.setEnabled(false);
    }
       

    public void Modificar()
    {
        Personas.setCedula(tf_cedula.getText());
        Personas.setNombre(tf_nombre.getText());
        Personas.setApellido(tf_apellido.getText());
        Personas.modificarMED();   
    }

    public void Borrar()
    {
        Personas.setCedula(tf_cedula.getText());
       // cliente.setNombre(tf_nombre.getText());
        //cliente.setApellido(tf_apellido.getText());
        Personas.eliminarMED(); 
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



