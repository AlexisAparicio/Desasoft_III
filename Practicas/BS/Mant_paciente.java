package BS;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.sql.*;

public class Mant_paciente implements ActionListener
{
    JFrame ventana2;
    Font fnt_text;
    JComboBox<String> cb_provincia;
    DefaultListModel<String> listModel;
    JList<String> lst_cliente;
    JScrollPane sp_cliente;
    JButton btn_listar,btn_add,btn_busc,btn_mod,btn_delete,btn_listar2,btn_escoger,btn_limpiar;
    DefaultTableModel dtm_cliente;
    JTable jt_cliente;
    JScrollPane sp_cliente2;
    String URL,user,pass;
    JLabel lbl_cedula,lbl_nombre,lbl_apellido,lbl_provincia,lbl_direccion,lbl_telefono,lbl_edad,lbl_sexo;
    JTextField tf_cedula,tf_nombre,tf_apellido,tf_direccion,tf_telefono,tf_edad,tf_sexo;
    // Instancias de clases
    db db = new db();
    Personas personas = new Personas();
    provincia provincia =  new provincia();

    Mant_paciente()
    {
        ventana2 = new JFrame("Mantenimiento de Pacientes");
        ventana2.setBounds(100,100,800,800);
        ventana2.getContentPane().setBackground(Color.DARK_GRAY);
        ventana2.setLayout(null);

        dtm_cliente = new DefaultTableModel();
        jt_cliente = new JTable(dtm_cliente);
        sp_cliente2 = new JScrollPane(jt_cliente);
        sp_cliente2.setBounds(50,260,500,500);
        ventana2.add(sp_cliente2);

        btn_busc = new JButton("Buscar");
        btn_busc.setBounds(200,50,85,20);
        btn_busc.addActionListener(this);
        ventana2.add(btn_busc);

        btn_limpiar = new JButton("Limpiar");
        btn_limpiar.setBounds(200,75,85,20);
        btn_limpiar.addActionListener(this);
        ventana2.add(btn_limpiar);

        btn_listar2 = new JButton("Listar ");
        btn_listar2.setBounds(200,185,120,20);
        btn_listar2.addActionListener(this);
        ventana2.add(btn_listar2);

        btn_escoger = new JButton("Escoger");
        btn_escoger.setBounds(200,210,120,20);
        btn_escoger.addActionListener(this);
        ventana2.add(btn_escoger);

        btn_add = new JButton("Agregar");
        btn_add.setBounds(200,110,85,20);
        btn_add.addActionListener(this);
        btn_add.setEnabled(false);
        ventana2.add(btn_add);

        btn_mod = new JButton("Modificar");
        btn_mod.setBounds(200,135,85,20);
        btn_mod.addActionListener(this);
        btn_mod.setEnabled(false);
        ventana2.add(btn_mod);

        btn_delete = new JButton("Borrar");
        btn_delete.setBounds(200,160,85,20);
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

        lbl_direccion = new JLabel("Direccion: ");
        lbl_direccion.setBounds(350,135,100,20);
        ventana2.add(lbl_direccion);

        tf_direccion = new JTextField();
        tf_direccion.setBounds(455,135,100,20);
        ventana2.add(tf_direccion);

        lbl_telefono = new JLabel("Telefono: ");
        lbl_telefono.setBounds(350,160,100,20);
        ventana2.add(lbl_telefono);

        tf_telefono = new JTextField();
        tf_telefono.setBounds(455,160,100,20);
        ventana2.add(tf_telefono);

        lbl_edad = new JLabel("Edad: ");
        lbl_edad.setBounds(350,185,100,20);
        ventana2.add(lbl_edad);

        tf_edad = new JTextField();
        tf_edad.setBounds(455,185,100,20);
        ventana2.add(tf_edad);

        lbl_sexo = new JLabel("Sexo: ");
        lbl_sexo.setBounds(350,210,100,20);
        ventana2.add(lbl_sexo);

        tf_sexo = new JTextField();
        tf_sexo.setBounds(455,201,100,20);
        ventana2.add(tf_sexo);
        /*---------Combo Box-------------- */

        lbl_provincia = new JLabel("Provincia");
        lbl_provincia.setBounds(350,225,80,20);
        ventana2.add(lbl_provincia);

        cb_provincia = new JComboBox<String>();
        provincia.cargar(cb_provincia);
        cb_provincia.setBounds(455,225,150,20);
        ventana2.add(cb_provincia);


        ventana2.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==btn_add)
        Agregar();
        if(e.getSource()==btn_limpiar)
        limpiar();

        if(e.getSource()==btn_busc)
        Buscar();

        if(e.getSource()==btn_mod)
       Modificar();

       if(e.getSource()==btn_delete)
       Borrar();
       if(e.getSource()==btn_listar2)
       listar();
       if(e.getSource()==btn_escoger)
       escoger();
    }

    public void listar()
    {
        personas.listar(dtm_cliente);
    }

    public void limpiar()
    {
        tf_cedula.setEnabled(true);
        tf_cedula.setText("");
        tf_nombre.setText("");
        tf_apellido.setText("");
        tf_direccion.setText("");
        tf_telefono.setText("");
        tf_edad.setText("");
        tf_sexo.setText("");
        cb_provincia.setSelectedItem("");
    }

    public void Agregar()
    {
        personas.setCedula(tf_cedula.getText());
        personas.setNombre(tf_nombre.getText());
        personas.setApellido(tf_apellido.getText());
        personas.setDireccion(tf_direccion.getText());
        personas.setTelefono(tf_telefono.getText());
        personas.setEdad(tf_edad.getText());
        personas.setSexo(tf_sexo.getText());
       // personas.setProvincia(personas.seleccionarProvincia((String) cb_provincia.getSelectedItem()));
        personas.agregar();

    }

    public void Buscar()
    {
        if(personas.buscar(tf_cedula.getText()))
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
        tf_cedula.setText(personas.getCedula());
        tf_nombre.setText(personas.getNombre());
        tf_apellido.setText(personas.getApellido());
        tf_direccion.setText(personas.getDireccion());
        tf_telefono.setText(personas.getTelefono());
        tf_edad.setText(personas.getEdad());
        tf_sexo.setText(personas.getSexo());
        cb_provincia.setSelectedItem(personas.getNombreProvincia());
        tf_cedula.setEnabled(false);
    }
       

    public void Modificar()
    {
        personas.setCedula(tf_cedula.getText());
        personas.setNombre(tf_nombre.getText());
        personas.setApellido(tf_apellido.getText());
        personas.setDireccion(tf_direccion.getText());
        personas.setTelefono(tf_telefono.getText());
        personas.setEdad(tf_edad.getText());
        personas.setSexo(tf_sexo.getText());
        //cb_provincia.setSelectedItem(personas.setNombreProvincia());
        personas.modificar();   
    }

    public void Borrar()
    {
        personas.setCedula(tf_cedula.getText());
       // cliente.setNombre(tf_nombre.getText());
        //cliente.setApellido(tf_apellido.getText());
        personas.eliminar(); 
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

