package Clases;
import Jdbc.Conexion;
import Jdbc.Conexion_cat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Carga_ComboBox {
    Connection cn;
    Conexion con = new Conexion();
    Conexion_cat con_cat = new Conexion_cat();
    int contador = 0;
    
    public ResultSet Combo(String x) throws Exception
    {
        cn = con.Conec();
        String sql = "SELECT Nombre FROM "+x;
        PreparedStatement pst = cn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        return rs;
    }
    public ResultSet Categoria() throws Exception
    {
        cn = con_cat.ConecCat();
        String sql = "show tables";
        PreparedStatement pst = cn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        return rs;
    }
}
