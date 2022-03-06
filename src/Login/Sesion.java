package Login;
import Clases.Control;
import Menu.Menu_Admin;
import Jdbc.*;
import Menu.Menu_Empleado;
import java.sql.*;
import java.util.logging.*;
import javax.swing.*;

public class Sesion extends javax.swing.JFrame {

    public Sesion() {
        initComponents();
        BaseDatoCategoria();
        BaseDatoProyecto();
        setTitle("JOANMI S.A.");
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/pruebass.png")).getImage());
        ((JPanel)getContentPane()).setOpaque(fal­se);
        ImageIcon uno=new ImageIcon(this.getClass().getResource("/Imagenes/pruebass.png"));
        JLabel fondo= new JLabel(); 
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
        fondo.setBounds(0,0,uno.getIconWidth(),u­no.getIconHeight());
    }

    Control p = new Control();

    
    @SuppressWarnings("unchecked")
    Conexion_nada t = new Conexion_nada();
    Connection cnn = t.Conec();
    Conexion cn = new Conexion();
    Connection cc = cn.Conec();
    Conexion_cat con = new Conexion_cat();
    Connection con2 = con.ConecCat();
    
     public void BaseDatoProyecto()
     {
         Statement st = null;
         String arreglo[] = new String[7];
                 arreglo[0] = "CREATE TABLE IF NOT EXISTS `clientes` (\n" +
                        "  `Codigo` varchar(15) NOT NULL,\n" +
                        "  `Cedula` int(11) NOT NULL,\n" +
                        "  `Nombres` varchar(40) NOT NULL,\n" +
                        "  `Apellidos` varchar(40) NOT NULL,\n" +
                        "  `Direccion` varchar(50) NOT NULL,\n" +
                        "  `Correo` varchar(50) NOT NULL,\n" +
                        "  `Sexo` varchar(2) NOT NULL,\n" +
                        "  `Celular` int(15) NOT NULL,\n" +
                        "  `Telefono` int(15) NOT NULL,\n" +
                        "  `Fecha` varchar(20) NOT NULL\n" +
                        ") ENGINE=InnoDB DEFAULT CHARSET=latin1; ";
                 arreglo[1] = "CREATE TABLE IF NOT EXISTS `detalle_factura` (\n" +
                        "  `Num_Factura` varchar(30) NOT NULL,\n" +
                        "  `codigo` varchar(20) NOT NULL,\n" +
                        "  `Nom_Pro` varchar(50) NOT NULL,\n" +
                        "  `cantidad` int(15) NOT NULL,\n" +
                        "  `Precio_Unit` float NOT NULL,\n" +
                        "  `Total` float NOT NULL\n" +
                        ") ENGINE=InnoDB DEFAULT CHARSET=latin1;";
                 arreglo[2] = "CREATE TABLE IF NOT EXISTS `facturas` (\n"
                        + "  `Num_Fac` varchar(30) NOT NULL,\n"
                        + "  `CI` int(11) NOT NULL,\n"
                        + "  `Fecha` varchar(15) NOT NULL,\n"
                        + "  `Hora` varchar(15) NOT NULL,\n"
                        + "  `Subtotal` float NOT NULL,\n"
                        + "  `Iva` float NOT NULL,\n"
                        + "  `Total` float NOT NULL\n"
                        + ") ENGINE=InnoDB DEFAULT CHARSET=latin1;";
                 arreglo[3] = "CREATE TABLE IF NOT EXISTS `formulario` (\n" +
                        "  `Nombres` text NOT NULL,\n" +
                        "  `Apellidos` text NOT NULL,\n" +
                        "  `Fecha_nac` date NOT NULL,\n" +
                        "  `Cedula` int(11) NOT NULL,\n" +
                        "  `Telefono` int(10) NOT NULL,\n" +
                        "  `Celular` int(10) NOT NULL,\n" +
                        "  `Direccion` varchar(50) NOT NULL,\n" +
                        "  `Usuario` varchar(10) NOT NULL,\n" +
                        "  `Contraseña` varchar(15) NOT NULL,\n" +
                        "  `Sexo` text NOT NULL,\n" +
                        "  `Tipo_Usuario` text NOT NULL,\n" +
                        "  `Correo` varchar(40) NOT NULL\n" +
                        ") ENGINE=InnoDB DEFAULT CHARSET=latin1;";
                 arreglo[4] = "CREATE TABLE IF NOT EXISTS `pedidos` (\n" +
                        "  `Codigo` varchar(15) NOT NULL,\n" +
                        "  `Nombre` varchar(45) NOT NULL,\n" +
                        "  `Cantidad` int(11) NOT NULL,\n" +
                        "  `Proveedor` varchar(45) NOT NULL,\n" +
                        "  `Descripcion` varchar(500) NOT NULL,\n" +
                        "  `Fecha_Ped` varchar(11) NOT NULL,\n" +
                        "  `Fecha_Entrega` varchar(11) NOT NULL\n" +
                        ") ENGINE=InnoDB DEFAULT CHARSET=latin1;";
                 arreglo[5] = "CREATE TABLE IF NOT EXISTS `proveedores` (\n" +
                        "  `Codigo` varchar(25) NOT NULL,\n" +
                        "  `Nombre` varchar(25) DEFAULT NULL,\n" +
                        "  `Direccion` varchar(50) DEFAULT NULL,\n" +
                        "  `Telefono` int(20) DEFAULT NULL,\n" +
                        "  `Correo` varchar(50) DEFAULT NULL,\n" +
                        "  `Productos` varchar(200) DEFAULT NULL,\n" +
                        "  `Celular` int(11) DEFAULT NULL\n" +
                        ") ENGINE=InnoDB DEFAULT CHARSET=latin1;";
                 arreglo[6] = "CREATE TABLE IF NOT EXISTS `ultimo_numero` (\n" +
                        "  `Clientes` int(11) NOT NULL,\n" +
                        "  `Formulario` int(11) NOT NULL,\n" +
                        "  `Pedidos` int(11) NOT NULL,\n" +
                        "  `Proveedores` int(11) NOT NULL,\n" +
                        "  `Factura` int(11) NOT NULL,\n" +
                        "  `Mercaderia` int(11) NOT NULL\n" +
                        ") ENGINE=InnoDB DEFAULT CHARSET=latin1;";
                try
                {
                     st = cnn.createStatement();
                     int c = st.executeUpdate("CREATE DATABASE IF NOT EXISTS proyecto");
                     st.close();
                }
                catch(SQLException e)
                {
                    System.out.println("Error db proyecto");
                }
                
                for(int a=0; a<=6; a++)
                    {
                       try
                        {
                        st = cc.createStatement();
                        st.executeUpdate(arreglo[a]);
                        }
                       catch(Exception e)
                        {
                            //e.printStackTrace();
                        }  
                    }
                try
                {
                    PreparedStatement pst = cc.prepareStatement("SELECT * FROM Formulario");
                    ResultSet rs = pst.executeQuery();
                    if(!rs.next())
                    {
                        Reseteo();
                    }
                }
                catch(Exception e)
                {
                    
                }
                
     }
    public void BaseDatoCategoria()
    {
        Statement st = null;
        try
        {
            st = cnn.createStatement();
            int a = st.executeUpdate("CREATE DATABASE IF NOT EXISTS categorias");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
     public void Reseteo()
     {
         PreparedStatement pst;
         try
         {
             pst = cc.prepareStatement("INSERT INTO Formulario (Nombres,Apellidos,Fecha_nac,Cedula,Telefono,Celular,Direccion,Usuario,Contraseña,Sexo,Tipo_Usuario,Correo) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
             pst.setString(1,"Admin");
             pst.setString(2,"A");
             pst.setString(3,"1990/01/01");
             pst.setInt(4,0);
             pst.setInt(5,0);
             pst.setInt(6,0);
             pst.setString(7,"0");
             pst.setString(8,"Admin");
             pst.setString(9,"Admin");
             pst.setString(10,"D");
             pst.setString(11,"Administrador");
             pst.setString(12,"Admin");
                int c = pst.executeUpdate();
             if(c > 0)
                 System.out.println("Se reseteo el formulario");
             pst.close();
         }
         catch(Exception e)
         {
             //e.printStackTrace();
         }
         
         try
         {
             pst = cc.prepareStatement("INSERT INTO ultimo_numero(Clientes,Formulario,Pedidos,Proveedores,Factura,mercaderia) VALUES(?,?,?,?,?,?)");
             pst.setInt(1,1);
             pst.setInt(2,1);
             pst.setInt(3,1);
             pst.setInt(4,1);
             pst.setInt(5,1);
             pst.setInt(6,1);
             pst.executeUpdate();
         }
         catch(Exception ex)
         {
             //ex.printStackTrace();
         }
         cnn = t.Conec();
         cc = cn.Conec();
         con2 = con.ConecCat(); 
     }

     
     void iniciar(String usu, String con) {
         cc = cn.Conec();
        String sql = "SELECT * FROM formulario WHERE Usuario = '" + usu + "' && Contraseña = '" + con + "'";
        String x,y,z,w;
        try {
            Statement st = cc.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) 
                {
                   x = rs.getString(11);
                   y = rs.getString(1);
                   z = rs.getString(2);
                   w = y+" "+z;
                        if(x.equals("Administrador"))
                    {
                           dispose();
                           JOptionPane.showMessageDialog(null, "Bienvenido");
                           Menu_Admin n = new Menu_Admin();
                           n.setVisible(true);
                           n.lblUsu.setText(w);
                    }
                    else
                    {
                        dispose();
                        JOptionPane.showMessageDialog(null, "Bienvenido");
                        Menu_Empleado n = new Menu_Empleado();
                        n.setVisible(true);
                        n.lblUsu.setText(w);
                        
                    }
                }
            else if ((usu.equals("")) || (con.equals("")))
                {
                JOptionPane.showMessageDialog(null, "Indique su Usuario y su Contraseña");
                }
            else
                {
                JOptionPane.showMessageDialog(null, "Su cuenta no existe");
                }
            } 
        catch (SQLException ex) 
        {
            Logger.getLogger(Sesion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Contraseña = new javax.swing.JLabel();
        btnIni = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        txtUser = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 11, -1, 216));

        jLabel2.setText("Usuario");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 260, 57, -1));

        Contraseña.setText("Contraseña");
        getContentPane().add(Contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 292, 66, -1));

        btnIni.setText("Iniciar Sesion");
        btnIni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniActionPerformed(evt);
            }
        });
        btnIni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnIniKeyPressed(evt);
            }
        });
        getContentPane().add(btnIni, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 327, -1, -1));

        btnExit.setText("Salir");
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
        });
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        getContentPane().add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 327, 94, -1));

        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });
        getContentPane().add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 257, 154, -1));

        txtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassActionPerformed(evt);
            }
        });
        getContentPane().add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 289, 154, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Icono_Camaleon_Logueo.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 0, 226, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/Fondo Login.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked

    }//GEN-LAST:event_btnExitMouseClicked

    private void btnIniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniActionPerformed
        String usua = txtUser.getText();
        String pass = new String(txtPass.getPassword());
        iniciar(usua, pass);
    }//GEN-LAST:event_btnIniActionPerformed

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        txtUser.transferFocus();
    }//GEN-LAST:event_txtUserActionPerformed

    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassActionPerformed
        String usua = txtUser.getText();
        String pass = new String(txtPass.getPassword());
        iniciar(usua, pass);
        txtPass.transferFocus();
    }//GEN-LAST:event_txtPassActionPerformed

    private void btnIniKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnIniKeyPressed
        String usua = txtUser.getText();
        String pass = new String(txtPass.getPassword());
        iniciar(usua, pass);
    }//GEN-LAST:event_btnIniKeyPressed

    public static void main(String args[]) {
                new Thread(new Cargar()).start();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
          try
          {
            //UIManager.setLookAndFeel(new UpperEssentialLookAndFeel("C:\\Users\\User\\Documents\\Programacion en Java\\Login\\Prueba.theme"));
            //UIManager.setLookAndFeel(new UpperEssentialLookAndFeel());
              //SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.CremeSkin");
              //SubstanceLookAndFeel.setCurrentTheme("org.jvnet.substance.theme.SubstanceLightAquaTheme");
              //SubstanceLookAndFeel.setCurrentWatermark("org.jvnet.substance.watermark.SubstanceBinaryWatermark");
          }
          catch(Exception e)
           {
            JOptionPane.showMessageDialog(null, "Error");
           }
           new Sesion().setVisible(false);
            }
        }
        );
    }
   
    



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Contraseña;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnIni;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables

}
