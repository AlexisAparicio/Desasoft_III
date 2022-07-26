package BS;
import java.sql.*;
import javax.swing.*;

import javax.swing.JComboBox;

public class provincia
{
    String codigo,descripcion;

    public void setCodigo(String c)
    {
        codigo = c;
    }
    public String getCodigo(String c)
    {
        return codigo;
    }

    public void setDescripcion(String d)
    {
        descripcion = d;
    }
    public String getDescripcion()
    {
        return descripcion;
    }
    public String getDescripcion(String cod)
    {
        String sql;
        ResultSet rs;
        try 
        {
            Bd_provincia bd_provincia = new Bd_provincia();
            sql="select * from Provincia where codigo='"+cod+"'";
            rs =  bd_provincia.executeQuery(sql);
            if(rs.next())
            {
               codigo = rs.getString("codigo");
               descripcion = rs.getString("descripcion");
            }
            bd_provincia.cerrar();
           } 
           catch (Exception e)
           {
               System.out.println("el error es "+ e.toString());
           }
           return descripcion;
    }
    public void cargar(JComboBox<String> cb)
    {
        String sql;
        ResultSet rs;

        try 
        {
         db db = new db();
         sql="select * from Provincia order by codigo";
         rs =  db.executeQuery(sql);
         while(rs.next())
         {
            cb.addItem(rs.getString("descripcion"));
         }
         db.cerrar();
        } 
        catch (Exception e)
        {
            System.out.println("el error es "+ e.toString());
        }
    }
}
