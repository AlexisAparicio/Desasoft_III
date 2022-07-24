import java.sql.*;

public class Mysql2
{

    String URL, user, pass;
    String sql;    
    String cedula, nombre, apellido;

    public static void main(String[] args)
    {
        new Mysql2();
    }

    Mysql2()
    {
        URL = "jdbc:mysql://127.0.0.1/utp?useSSL=false";
        user = "root";
        pass = "root";

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL,user,pass);
            Statement stmt = con.createStatement();
            sql = "select * from cliente";
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