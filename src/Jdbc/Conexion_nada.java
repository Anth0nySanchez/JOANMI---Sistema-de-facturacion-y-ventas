package Jdbc;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion_nada {

    public String link = "jdbc:mysql://localhost:3306";
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
           JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos","Error",JOptionPane.ERROR_MESSAGE);
        }
        return cn;
    }
}