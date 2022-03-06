package Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Conexion_cat {

    public String link = "jdbc:mysql://localhost:3306/Categorias";
    public String usuario = "root";
    public String contraseña = "";

    public Connection ConecCat() {
        Connection cn = null;
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(link, usuario, contraseña);
        } 
        catch (Exception e) 
        {
            
        }
        return cn;
    }
}
