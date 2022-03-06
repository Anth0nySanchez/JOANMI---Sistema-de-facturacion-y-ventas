package Menu;
import Jdbc.Conexion;
import static Menu.Buscar.*;
import java.sql.Connection;
import java.sql.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
public class Lista_Empleados extends javax.swing.JFrame {

    public Lista_Empleados() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Empleados");
        tabla.setEnabled(true);
        Tablas();
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/pruebass.png")).getImage());
        ((JPanel)getContentPane()).setOpaque(fal­se);
        ImageIcon uno=new ImageIcon(this.getClass().getResource("/Imagenes/pruebass.png"));
        JLabel fondo= new JLabel(); 
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
        fondo.setBounds(0,0,uno.getIconWidth(),u­no.getIconHeight());
    }
    @SuppressWarnings("unchecked")
    
    public void UsuPass()
    {
        Conexion cn = new Conexion(); 
        Connection link = cn.Conec();
        try
            { 
                PreparedStatement usu = link.prepareStatement("SELECT * FROM formulario WHERE Nombres = '"+txtnom.getText()+"' && Apellidos = '"+txtape.getText()+"'");
                ResultSet rs = usu.executeQuery();
                if(rs.next())
                {
                String x = rs.getString(8);
                String y = rs.getString(9);
                txtusu.setText(x);
                txtcon.setText(y);
                }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Error");
            }
    }
    
    public void Tablas() 
    { 
        String sql,s;
        Conexion con = new Conexion();
        Connection cn = con.Conec();
       try
       {
           int conta = 0,repe = 0;
        Statement st = cn.createStatement();
        sql = "Select * from formulario";
        ResultSet rs = st.executeQuery(sql);
        ResultSetMetaData rsmd =  rs.getMetaData();
        int col = rsmd.getColumnCount();
        DefaultTableModel modelo = new DefaultTableModel();
        for(int j=1; j<= col;j++)
        {
            s = rsmd.getColumnLabel(j);
            if(s.equals("Usuario"))
                continue;
            if(s.equals("Contraseña"))
                continue;
            modelo.addColumn(rsmd.getColumnLabel(j));
           
            conta++;
        }
        while(rs.next())
        {
        String fila[] = new String [col];
        for(int cont=0;cont<=col ;cont++)
        {
            if(cont == 7)
            {
                fila[cont] = rs.getString(10);
                continue;
            }
            if(cont == 8)
            {
                fila[cont] = rs.getString(11);
                continue;
            }
            if(cont == 9)
            {
                fila[cont] = rs.getString(12);
                break;
            }
         fila[cont] = rs.getString(cont+1);
        }
        modelo.addRow(fila);
        }
        tabla.setModel(modelo);
        rs.close();
        cn.close();
        
    }
    catch(SQLException x)
    {
        JOptionPane.showMessageDialog(null,x);
    }  

    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MEclic = new javax.swing.JPopupMenu();
        ELmod = new javax.swing.JMenuItem();
        ELel = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        btnBus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btnActu = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        ELmod.setText("Modificar");
        ELmod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ELmodActionPerformed(evt);
            }
        });
        MEclic.add(ELmod);

        ELel.setText("Eliminar");
        ELel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ELelMouseClicked(evt);
            }
        });
        ELel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ELelActionPerformed(evt);
            }
        });
        MEclic.add(ELel);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Gabriola", 0, 48)); // NOI18N
        jLabel1.setText("LISTA DE EMPLEADOS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 370, 46));

        btnBus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/search me.png"))); // NOI18N
        btnBus.setText("Buscar");
        btnBus.setBorderPainted(false);
        btnBus.setContentAreaFilled(false);
        btnBus.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBus.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/search gr.png"))); // NOI18N
        btnBus.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/search gr.png"))); // NOI18N
        btnBus.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusActionPerformed(evt);
            }
        });
        getContentPane().add(btnBus, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 80, 88, -1));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombres", "Apellidos", "Cedula", "Nacimiento", "Sexo", "Correo", "Telefono", "Celular", "Direccion", "Tipo de Usuario"
            }
        ));
        tabla.setComponentPopupMenu(MEclic);
        jScrollPane1.setViewportView(tabla);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 160, 1185, 204));

        btnActu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reload me.png"))); // NOI18N
        btnActu.setText("Actualizar");
        btnActu.setBorderPainted(false);
        btnActu.setContentAreaFilled(false);
        btnActu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnActu.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reload gr.png"))); // NOI18N
        btnActu.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reload gr.png"))); // NOI18N
        btnActu.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnActu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActuActionPerformed(evt);
            }
        });
        getContentPane().add(btnActu, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, -1, -1));

        jButton1.setText("Modificar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(486, 382, -1, -1));

        jButton2.setText("Eliminar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(628, 382, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Downloads\\Compressed\\photos\\Lista de Empleados.jpg")); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1220, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusActionPerformed
        Buscar t = new Buscar();
        t.setVisible(true);
    }//GEN-LAST:event_btnBusActionPerformed

    private void ELmodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ELmodActionPerformed
        Conexion cn = new Conexion(); 
        Connection link = cn.Conec();
         String usua = "", contra = "";
        Buscar b = new Buscar();
        
        b.txtci.setEnabled(true);
        b.txtnom.setEnabled(true);
        b.txtape.setEnabled(true);
        b.txtfn.setEnabled(true);
        b.txtsex.setEnabled(true);
        b.txtcor.setEnabled(true);
        b.txtdir.setEnabled(true);
        b.txtusu.setEnabled(false);
        b.txtcon.setEnabled(false);
        b.txttip_usu.setEnabled(true);
        b.txtcel.setEnabled(true);
        b.txttel.setEnabled(true);
        b.btnbus.setEnabled(false);
        b.btnEli.setEnabled(true);
        int fila = tabla.getSelectedRow();
        if(fila >=0)
        {
        b.txtnom.setText(tabla.getValueAt(fila, 0).toString());
        b.txtape.setText(tabla.getValueAt(fila, 1).toString());
        b.txtfn.setText(tabla.getValueAt(fila, 2).toString());
        b.txtci.setText(tabla.getValueAt(fila, 3).toString());
        b.txttel.setText(tabla.getValueAt(fila, 4).toString());
        b.txtcel.setText(tabla.getValueAt(fila, 5).toString());
        b.txtdir.setText(tabla.getValueAt(fila, 6).toString());
        b.txtsex.setText(tabla.getValueAt(fila, 7).toString());
        b.txttip_usu.setText(tabla.getValueAt(fila, 8).toString());
        b.txtcor.setText(tabla.getValueAt(fila, 9).toString());
        b.txtusu.setText(usua);
        b.txtcon.setText(contra);
        UsuPass();
        b.setVisible(true);
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Seleccione una fila");
        }
                          
    }//GEN-LAST:event_ELmodActionPerformed

    private void btnActuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActuActionPerformed
        Tablas();
    }//GEN-LAST:event_btnActuActionPerformed

    private void ELelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ELelMouseClicked

    }//GEN-LAST:event_ELelMouseClicked

    private void ELelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ELelActionPerformed
        Conexion con = new Conexion();
        Connection link = con.Conec();
        try
        {
            int fila = tabla.getSelectedRow();
            int ced = Integer.parseInt(tabla.getValueAt(fila, 3).toString());
            PreparedStatement pst = link.prepareStatement("DELETE FROM formulario WHERE Cedula = '"+ced+"'");
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Datos Eliminados Satisfactoriamente");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }//GEN-LAST:event_ELelActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Conexion con = new Conexion();
        Connection link = con.Conec();
        
        try
        {
            int fila = tabla.getSelectedRow();
            int ced = Integer.parseInt(tabla.getValueAt(fila, 3).toString());
            PreparedStatement pst = link.prepareStatement("DELETE FROM formulario WHERE Cedula = '"+ced+"'");
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Datos Eliminados Satisfactoriamente");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Conexion cn = new Conexion(); 
        Connection link = cn.Conec();
         String usua = "", contra = "";
        Buscar b = new Buscar();
        
        b.txtci.setEnabled(true);
        b.txtnom.setEnabled(true);
        b.txtape.setEnabled(true);
        b.txtfn.setEnabled(true);
        b.txtsex.setEnabled(true);
        b.txtcor.setEnabled(true);
        b.txtdir.setEnabled(true);
        b.txtusu.setEnabled(false);
        b.txtcon.setEnabled(false);
        b.txttip_usu.setEnabled(true);
        b.txtcel.setEnabled(true);
        b.txttel.setEnabled(true);
        b.btnbus.setEnabled(false);
        b.btnEli.setEnabled(true);
        int fila = tabla.getSelectedRow();
        if(fila >=0)
        {
        b.txtnom.setText(tabla.getValueAt(fila, 0).toString());
        b.txtape.setText(tabla.getValueAt(fila, 1).toString());
        b.txtfn.setText(tabla.getValueAt(fila, 2).toString());
        b.txtci.setText(tabla.getValueAt(fila, 3).toString());
        b.txttel.setText(tabla.getValueAt(fila, 4).toString());
        b.txtcel.setText(tabla.getValueAt(fila, 5).toString());
        b.txtdir.setText(tabla.getValueAt(fila, 6).toString());
        b.txtsex.setText(tabla.getValueAt(fila, 7).toString());
        b.txttip_usu.setText(tabla.getValueAt(fila, 8).toString());
        b.txtcor.setText(tabla.getValueAt(fila, 9).toString());
        b.txtusu.setText(usua);
        b.txtcon.setText(contra);
        UsuPass();
        b.setVisible(true);
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Seleccione una fila");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Lista_Empleados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ELel;
    private javax.swing.JMenuItem ELmod;
    private javax.swing.JPopupMenu MEclic;
    private javax.swing.JButton btnActu;
    private javax.swing.JButton btnBus;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
