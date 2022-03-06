package Jdbc;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {

    public String link = "jdbc:mysql://localhost:3306/Proyecto";
    public String usuario = "root";
    public String contraseña = "";

    public Connection Conec() {
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
