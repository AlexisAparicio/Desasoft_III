package BS.lib;

import java.sql.*;

public class mysql
{

    String URL, user, pass;
    String sql;    
    String cedula, nombre, apellido;

    public static void main(String[] args)
    {
        new mysql();
    }

    mysql()
    {
        URL = "jdbc:Mysql://http://192.168.64.2/UTP";
        user = "root";
        pass = "root";

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL,user,pass);
            Statement stmt = con.createStatement();
            sql = "select * from clientes";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next())
            {
                cedula = rs.getString("cedula");
                nombre = rs.getString("nombre");
                apellido = rs.getString("apellido");
                System.out.println(cedula+"  "+nombre+"  "+apellido);
            }
            rs.close();
            stmt.close();
            con.close();
        }
        catch(Exception e)
        { 
            System.out.println("Error "+e.toString());
        }
    }
}  