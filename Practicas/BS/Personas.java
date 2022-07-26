package BS;

import java.sql.*;

import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

public class Personas 
{
    private String cedula,nombre,apellido,provincia,nomprovincia,direccion,telefono,edad,sexo,codigo,especialidad,pacientes_mes,pacientes_anual;
    private String sql;
    db db = new db();
    Bd_medico bd_medico = new Bd_medico();
    Bd_pacientes bd_pacientes = new Bd_pacientes();
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
    public void setDireccion(String d)
    {
        direccion=d;
    }

    public String getDireccion()
    {
        return direccion;
    }
    public void setTelefono(String t)
    {
        telefono=t;
    }

    public String getTelefono()
    {
        return telefono;
    }
    public void setEdad(String e)
    {
        edad=e;
    }

    public String getEdad()
    {
        return edad;
    }

    public void setSexo(String s)
    {
        sexo=s;
    }

    public String getSexo()
    {
        return sexo;
    }
    /* -----------Medico---------- */
    public void setCodigo(String q)
    {
        codigo=q;
    }

    public String getCodigo()
    {
        return codigo;
    }
    public void setEspecialidad(String w)
    {
        especialidad=w;
    }

    public String getEspecilidad()
    {
        return especialidad;
    }
    public void setPacienteM(String M)
    {
        pacientes_mes=M;
    }

    public String getPacienteM()
    {
        return pacientes_mes;
    }
    public void setPacienteAnual(String AA)
    {
        pacientes_anual=AA;
    }

    public String getPacienteanual()
    {
        return pacientes_anual;
    }
    public void inicializar()
    {
        cedula="";
        apellido="";
        nombre="";
        direccion="";
        telefono="";
        edad="";
        sexo="";

    }

    public void listar(DefaultTableModel dtm)
    {
        sql="";
        dtm.setColumnCount(0);
        dtm.setRowCount(0);
        dtm.addColumn("Cedula");
        dtm.addColumn("Nombre");
        dtm.addColumn("Apellido");
        dtm.addColumn("Dirección");
        dtm.addColumn("Telefono");
        dtm.addColumn("Provincia");
        dtm.addColumn("Edad");
        dtm.addColumn("Sexo");

        Object[] fila= new Object[8];
        try 
        {
            sql = "select * from Pacientes,Provincia where Pacientes.Provincia = Provincia.codigo";
            ResultSet rs = db.executeQuery(sql);
            while(rs.next())
            {
                fila[0] = rs.getString("cedula");
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getString("apellido");
                fila[3] = rs.getString("direccion");
                fila[4] = rs.getString("telefono");
                fila[5] = rs.getString("descripcion");
                fila[6] = rs.getString("edad");
                fila[7] = rs.getString("sexo");
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
            sql = "select * from Pacientes where cedula='"+ced+"'";
            ResultSet rs = db.executeQuery(sql);
            cedula = ced;
            if(rs.next())
            {
               
                nombre = rs.getString("nombre");
                apellido = rs.getString("apellido");
                direccion = rs.getString("direccion");
                telefono = rs.getString("telefono");
                edad = rs.getString("edad");
                sexo = rs.getString("sexo");
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

            //INSERT INTO `Pacientes` (`ID`, `cedula`, `nombre`, `apellido`, `direccion`, `telefono`, `provincia`, `edad`, `sexo`) VALUES (NULL, '3-593-123', 'Adair', 'Ardines', 'Tecal Vacamonte', '2554433', '03', '28', 'M');
            sql = "insert into Pacientes(cedula,nombre,apellido,direccion,telefono,provincia,edad,sexo) values('";
            sql = sql+cedula+"','"+ nombre+"','"+apellido+"','";
            sql = sql+direccion+"','"+ telefono+"','"+provincia+"','";
            sql= sql+edad+"','"+ sexo+"')";
            System.out.println(sql);
            bd_pacientes.executeUpdate(sql);

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
            sql = "update Pacientes set nombre='"+nombre+"',";
            sql=sql+"apellido='"+apellido+"',";
            sql=sql+"direccion='"+direccion+"',";
            sql=sql+"telefono='"+telefono+"',";
            //sql=sql+"provincia='"+provincia+"',";
            sql=sql+"edad='"+edad+"',";
            sql=sql+"sexo='"+sexo+"'";
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
         sql = "delete from Pacientes where cedula='"+cedula+"'";
            
            System.out.println(sql);
            bd_pacientes.executeUpdate(sql);
           
        } 
        catch (Exception e) 
        {
            System.out.println("error "+ e.toString());
        }
    }

    /*---------------------------------------- */

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
            bd_medico.cerrar();
        } 
        catch (Exception e) 
        {
            System.out.println("error "+ e.toString());
        }
    }


    public boolean buscarMED(String cod)
    {   boolean find=false;
        inicializar();

        try 
        {
            sql = "select * from Medico where codigo='"+cod+"'";
            ResultSet rs = db.executeQuery(sql);
            codigo = cod;
            if(rs.next())
            {
                
                nombre = rs.getString("nombre");
                apellido = rs.getString("apellido");
                cedula = rs.getString("cedula");
                direccion = rs.getString("direccion");
                telefono = rs.getString("telefono");
                especialidad = rs.getString("especialidad");
                pacientes_mes = rs.getString("pacientes_mes");
                pacientes_anual = rs.getString("pacientes_anual");
                
                find=true;
            }   
            bd_medico.cerrar();
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
            sql = "insert into Medico(codigo,cedula,nombre,apellido,direccion,telefono,especialidad,pacientes_mes,pacientes_anual) values('";
            sql = sql+codigo+"','"+cedula+"','"+ nombre+"','"+apellido+"','";
            sql = sql+direccion+"','"+ telefono+"','"+especialidad+"','";
            sql= sql+pacientes_mes+"','"+ pacientes_anual+"')";
            System.out.println(sql);
            bd_medico.executeUpdate(sql);

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
            sql = "update Medico set nombre='"+nombre+"',";
            sql=sql+"apellido='"+apellido+"',";
            sql=sql+"direccion='"+direccion+"',";
            sql=sql+"cedula='"+cedula+"',";
            sql=sql+"telefono='"+telefono+"',";
            sql=sql+"especialidad='"+especialidad+"',";
            sql=sql+"pacientes_mes='"+pacientes_mes+"',";
            sql=sql+"pacientes_anual='"+pacientes_anual+"'";
            sql=sql+"where codigo='"+codigo+"'";
            System.out.println(sql);
            bd_medico.executeUpdate(sql);

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
         sql = "delete from Medico where cod='"+codigo+"'";
            
            System.out.println(sql);
            bd_medico.executeUpdate(sql);
           
        } 
        catch (Exception e) 
        {
            System.out.println("error "+ e.toString());
        }
    }
    /*
    public String seleccionarProvincia(String provincia){
        sql = "select * from provincia where descripcion = '"+provincia+"';";
        String codigo="";

        try{
            ResultSet resultSet = bd_medico.executeQuery(sql);
            if(resultSet.next()){
                codigo = resultSet.getString("codigo");
            }
            bd_medico.cerrar();
        }catch (Exception e){
            System.err.println("error seleccionar provincia ==> "+e.toString());
        }
        return codigo;
    }

     */

    }

