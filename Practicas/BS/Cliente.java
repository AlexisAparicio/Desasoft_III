package BS;

import java.sql.*;

import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

public class Cliente 
{
    private String cedula,nombre,apellido,provincia,nomprovincia;
    private String sql;
    db db = new db();
    provincia dbprovincia = new provincia();

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

    public void setProvincia(String p)
    {
        provincia = p;
    }
    public String getProvincia()
    {
        return provincia;
    }
    public String getNombreProvincia()
    {
        return dbprovincia.getDescripcion(provincia);
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

    public void listar(DefaultTableModel dtm)
    {
        sql="";
        dtm.setColumnCount(0);
        dtm.setRowCount(0);
        dtm.addColumn("Cedula");
        dtm.addColumn("Nombre");
        dtm.addColumn("Apellido");
        dtm.addColumn("Provincia");

        Object[] fila= new Object[4];
        try 
        {
            sql = "select * from Clientes,Provincia where Clientes.Provincia = Provincia.codigo";
            ResultSet rs = db.executeQuery(sql);
            while(rs.next())
            {
                fila[0] = rs.getString("cedula");
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getString("apellido");
                fila[3] = rs.getString("Descripcion");
                dtm.addRow(fila);
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
                provincia = rs.getString("Provincia");
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
    public void agregar()
    {
        sql="";

        try 
        {
            sql = "insert into Clientes(cedula,nombre,apellido) values('";
            sql = sql+cedula+"','"+ nombre+"','"+apellido+"')";
            System.out.println(sql);
            db.executeUpdate(sql);

        } 
        catch (Exception e) 
        {
            System.out.println("error "+ e.toString());
        }
    }

    public void modificar()
    {
        sql="";
        try 
        {
             sql = "update Clientes set nombre='"+nombre+"', ";
            sql=sql+"apellido='"+apellido+"'";
            sql=sql+"where cedula='"+cedula+"'";
            System.out.println(sql);
            db.executeUpdate(sql);

        } 
        catch (Exception e) 
        {
            System.out.println("error "+ e.toString());
        }
    }

    public void eliminar()
    {   sql="";
        try 
        {
         sql = "delete from Clientes where cedula='"+cedula+"'";
            
            System.out.println(sql);
            db.executeUpdate(sql);
           
        } 
        catch (Exception e) 
        {
            System.out.println("error "+ e.toString());
        }
    }
    }

