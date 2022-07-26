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
    JButton btn_listar,btn_add,btn_busc,btn_mod,btn_delete,btn_listar2,btn_escoger,btn_limpiar;
    DefaultTableModel dtm_cliente;
    JTable jt_cliente;
    JScrollPane sp_cliente2;
    String URL,user,pass;
    JLabel lbl_cedula,lbl_nombre,lbl_apellido,lbl_provincia,lbl_codigo,lbl_direccion,lbl_telefono,lbl_pacientes_M,lbl_pacientes_A;
    JTextField tf_cedula,tf_nombre,tf_apellido,tf_codigo,tf_direccion,tf_telefono,tf_pacientesM,tf_pacientesA;
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

        lbl_codigo = new JLabel("Codigo: ");
        lbl_codigo.setBounds(350,25,85,20);
        ventana2.add(lbl_codigo);

        tf_codigo = new JTextField();
        tf_codigo.setBounds(455,25,80,20);
        ventana2.add(tf_codigo);
  
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
        lbl_direccion.setBounds(350,135,80,20);
        ventana2.add(lbl_direccion);

        tf_direccion = new JTextField();
        tf_direccion.setBounds(455,135,80,20);
        ventana2.add(tf_direccion);

        lbl_telefono = new JLabel("Telefono: ");
        lbl_telefono.setBounds(350,160,80,20);
        ventana2.add(lbl_telefono);

        tf_telefono = new JTextField();
        tf_telefono.setBounds(455,160,80,20);
        ventana2.add(tf_telefono);

        lbl_pacientes_M = new JLabel("Pacientes Mes: ");
        lbl_pacientes_M.setBounds(350,185,80,20);
        ventana2.add(lbl_pacientes_M);

        tf_pacientesM = new JTextField();
        tf_pacientesM.setBounds(455,185,80,20);
        ventana2.add(tf_pacientesM);

        lbl_pacientes_A = new JLabel("Pacientes Anual: ");
        lbl_pacientes_A.setBounds(350,210,80,20);
        ventana2.add(lbl_pacientes_A);

        tf_pacientesA = new JTextField();
        tf_pacientesA.setBounds(455,210,80,20);
        ventana2.add(tf_pacientesA);

        /*--------------Combo BOX--------------- */
        lbl_provincia = new JLabel("Especialidad");
        lbl_provincia.setBounds(350,230,80,20);
        ventana2.add(lbl_provincia);

        cb_especialidad = new JComboBox<String>();
        especialidad.cargar(cb_especialidad);
        cb_especialidad.setBounds(455,235,90,20);
        ventana2.add(cb_especialidad);


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
       listar2();
       if(e.getSource()==btn_escoger)
       escoger();
    }

    public void listar2()
    {
        Personas.listarMED(dtm_cliente);
    }

    public void limpiar()
    {
        tf_codigo.setEnabled(true);
        tf_cedula.setText("");
        tf_nombre.setText("");
        tf_apellido.setText("");
        tf_direccion.setText("");
        tf_telefono.setText("");
        tf_pacientesA.setText("");
        tf_pacientesM.setText("");
        cb_especialidad.setSelectedItem("");
    }

    public void Agregar()
    {
        Personas.setCodigo(tf_codigo.getText());
        Personas.setCedula(tf_cedula.getText());
        Personas.setNombre(tf_nombre.getText());
        Personas.setApellido(tf_apellido.getText());
        Personas.setDireccion(tf_direccion.getText());
        Personas.setTelefono(tf_telefono.getText());
        Personas.setPacienteM(tf_pacientesM.getText());
        Personas.setPacienteAnual(tf_pacientesA.getText());
       // Personas.setProvincia(Personas.seleccionarProvincia((String) cb_especialidad.getSelectedItem()));
        Personas.agregarMED();

    }

    public void Buscar()
    {
        if(Personas.buscarMED(tf_codigo.getText()))
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
        tf_direccion.setText(Personas.getDireccion());
        tf_telefono.setText(Personas.getTelefono());
        tf_pacientesM.setText(Personas.getPacienteM());
        tf_pacientesA.setText(Personas.getPacienteanual());
        cb_especialidad.setSelectedItem(Personas.getNombreProvincia());
        tf_codigo.setEnabled(false);
    }
       

    public void Modificar()
    {
        Personas.setCedula(tf_cedula.getText());
        Personas.setNombre(tf_nombre.getText());
        Personas.setApellido(tf_apellido.getText());
        Personas.setDireccion(tf_direccion.getText());
        Personas.setTelefono(tf_telefono.getText());
        Personas.setPacienteM(tf_pacientesM.getText());
        Personas.setPacienteAnual(tf_pacientesA.getText());
        cb_especialidad.setSelectedItem(Personas.getNombreProvincia());
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
        tf_codigo.setText(jt_cliente.getValueAt(fila,0).toString());
        // tf_nombre.setText(jt_cliente.getValueAt(fila,1).toString());
        // tf_apellido.setText(jt_cliente.getValueAt(fila,2).toString());
        Buscar();
    }
}



