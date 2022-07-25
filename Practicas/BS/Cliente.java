package BS;

import java.sql.*;

import javax.swing.DefaultListModel;

public class Cliente 
{
    private String cedula,nombre,apellido;
    private String sql;
    db db = new db();

    public void setCedula(String c)
    {
        cedula=c;
    }

    public String getCedula()
    {
        return cedula;
    }
    public void setNombre(String n)
    {
        nombre = n;
    }
    public String getNombre()
    {
        return nombre;
    }
    public void setApellido(String a)
    {
        apellido = a;
    }
    public String getApellido()
    {
        return apellido;
    }

    public void inicializar()
    {
        cedula="";
        apellido="";
        nombre="";
    }

    public void listar(DefaultListModel<String> listModel)
    {
        sql="";
        //listModel.addElement(cedula+ " "+ nombre + " "+ apellido);
        try 
        {
            sql = "select * from Clientes";
            ResultSet rs = db.executeQuery(sql);
            listModel.clear();
            while(rs.next())
            {
                cedula = rs.getString("cedula");
                nombre = rs.getString("nombre");
                apellido = rs.getString("apellido");
                listModel.addElement(cedula+ " "+ nombre + " "+ apellido);
            }
            db.cerrar();
        } 
        catch (Exception e) 
        {
            System.out.println("error "+ e.toString());
        }
    }

    public boolean buscar(String ced)
    {   boolean find=false;
        inicializar();

        try 
        {
            sql = "select * from Clientes where cedula='"+ced+"'";
            ResultSet rs = db.executeQuery(sql);
            cedula = ced;
            if(rs.next())
            {
               
                nombre = rs.getString("nombre");
                apellido = rs.getString("apellido");
                find=true;
            }   
            db.cerrar();
        } 
        catch (Exception e) 
        {
            System.out.println("error "+ e.toString());
        }
        return find;
    }
    }

