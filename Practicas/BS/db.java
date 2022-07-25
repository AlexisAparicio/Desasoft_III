package BS;

import java.sql.*;

public class db 
{
    String URL,user,pass;
    Connection con;
    Statement stmt;
    ResultSet rs;

    db()
    {
        URL = "jdbc:mysql://192.168.64.2/UTP?useSSL=false";
        user = "root";
        pass = "root";
    }

public void abrir()
{
    try 
        {
        con = DriverManager.getConnection(URL,user,pass);
        stmt = con.createStatement();
            
        }
        catch (Exception e) 
        {
            System.out.println("error "+ e.toString());
        }
      
}

public void cerrar()
{
    try{
    rs.close();
    stmt.close();
    con.close();
    }
    catch(Exception e)
    {
        System.out.println("el error "+e.toString());
    }
}

public ResultSet executeQuery(String sql)
{
    try 
    {   abrir();
        rs= stmt.executeQuery(sql);
    } catch (Exception e) 
    {
        System.out.println("el error "+e.toString());    
    }
    return rs;
}

public void executeUpdate(String sql)
{
    try 
    {   abrir();
      stmt.executeUpdate(sql);
      cerrar();
    } 
    catch (Exception e) 
    {
        System.out.println("el error "+e.toString());    
    }
    
} 


}

