package BS;

import java.sql.*;

import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

public class Personas 
{
    private String cedula,nombre,apellido,provincia,nomprovincia;
    private String sql;
    db db = new db();
    Bd_medico bd_medico = new Bd_medico();
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

    /*---------------------------------------- */

    public void listarMed(DefaultListModel<String> listModel)
    {
        sql="";
        //listModel.addElement(cedula+ " "+ nombre + " "+ apellido);
        try 
        {
            sql = "select * from Medico";
            ResultSet rs = db.executeQuery(sql);
            listModel.clear();
            while(rs.next())
            {
                cedula = rs.getString("cedula");
                nombre = rs.getString("nombre");
                apellido = rs.getString("apellido");
                listModel.addElement(cedula+ " "+ nombre + " "+ apellido);
            }
            bd_medico.cerrar();
        } 
        catch (Exception e) 
        {
            System.out.println("error "+ e.toString());
        }
    }

    public void listarMED(DefaultTableModel dtm)
    {
        sql="";
        dtm.setColumnCount(0);
        dtm.setRowCount(0);
        dtm.addColumn("Codigo");
        dtm.addColumn("Cedula");
        dtm.addColumn("Nombre");
        dtm.addColumn("Apellido");
        dtm.addColumn("Dirección");
        dtm.addColumn("Telefono");
        dtm.addColumn("Especialidad");
        dtm.addColumn("Pacientes_mes");
        dtm.addColumn("Paciente_anual");

        Object[] fila= new Object[9];
        try 
        {
            sql = "select * from Medico,Especialidad where Medico.Especialidad = Especialidad.codigo";
            ResultSet rs = db.executeQuery(sql);
            while(rs.next())
            {
                fila[0] = rs.getString("codigo");
                fila[1] = rs.getString("cedula");
                fila[2] = rs.getString("nombre");
                fila[3] = rs.getString("apellido");
                fila[4] = rs.getString("direccion");
                fila[5] = rs.getString("telefono");
                fila[6] = rs.getString("especialidad");
                fila[7] = rs.getString("pacientes_mes");
                fila[8] = rs.getString("pacientes_anual");
                
                dtm.addRow(fila);
            }
            db.cerrar();
        } 
        catch (Exception e) 
        {
            System.out.println("error "+ e.toString());
        }
    }


    public boolean buscarMED(String ced)
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
    public void agregarMED()
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

    public void modificarMED()
    {
        sql="";
        try 
        {
             sql = "update Medico set nombre='"+nombre+"', ";
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

    public void eliminarMED()
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

