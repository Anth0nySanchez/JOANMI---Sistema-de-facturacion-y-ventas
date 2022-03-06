/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Clases.Control;
import Jdbc.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class Lista_Proveedores extends javax.swing.JFrame {

    String recogedor = "";
    String añadido = "";
    String tabla_Codigo;
    
    public Lista_Proveedores() {
        initComponents();
        txtBus.setEnabled(false);
        setLocationRelativeTo(null);
        setTitle("Lista de Proveedores");
        Tablas();
    setIconImage(new ImageIcon(getClass().getResource("/Imagenes/pruebass.png")).getImage());
        ((JPanel)getContentPane()).setOpaque(fal­se);
        ImageIcon uno=new ImageIcon(this.getClass().getResource("/Imagenes/pruebass.png"));
        JLabel fondo= new JLabel(); 
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
        fondo.setBounds(0,0,uno.getIconWidth(),u­no.getIconHeight());
    }

    public void Tablas() {
        String sql;
        Conexion con = new Conexion();
        Connection cn = con.Conec();
        try {
            Statement st = cn.createStatement();
            sql = "Select * from proveedores";
            ResultSet rs = st.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int col = rsmd.getColumnCount();
            DefaultTableModel modelo = new DefaultTableModel();
            for (int j = 1; j <= col; j++) {
                modelo.addColumn(rsmd.getColumnLabel(j));
            }
            while (rs.next()) {
                String fila[] = new String[col];
                for (int cont = 0; cont < col; cont++) {
                    fila[cont] = rs.getString(cont + 1);
                }
                modelo.addRow(fila);
            }
            tabla.setModel(modelo);
            rs.close();
            cn.close();

        } catch (SQLException x) {
            JOptionPane.showMessageDialog(null, x);
        }

    }
    public String getTabla_Codigo()
    {
        return tabla_Codigo;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        clasifican = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        txtBus = new javax.swing.JTextField();
        rdioCod = new javax.swing.JRadioButton();
        rdioNom = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("LISTA DE PROVEEDORES");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 20, 324, 34));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 154, 634, 160));

        txtBus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusKeyReleased(evt);
            }
        });
        getContentPane().add(txtBus, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 75, 291, -1));

        rdioCod.setBackground(new java.awt.Color(255, 255, 255));
        clasifican.add(rdioCod);
        rdioCod.setText("Por Codigo");
        rdioCod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdioCodMouseClicked(evt);
            }
        });
        rdioCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdioCodActionPerformed(evt);
            }
        });
        getContentPane().add(rdioCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(224, 113, -1, -1));

        rdioNom.setBackground(new java.awt.Color(255, 255, 255));
        clasifican.add(rdioNom);
        rdioNom.setText("Por Nombre");
        rdioNom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdioNomMouseClicked(evt);
            }
        });
        getContentPane().add(rdioNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(347, 113, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/Lista de Proveedores.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 340));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void txtBusKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusKeyReleased
        String m,Clasificacion;
        m = txtBus.getText();
        recogedor = añadido+m;
        System.out.println(recogedor);
        Control co = new Control();
        Conexion con = new Conexion();
        Connection link = con.Conec();
        Clasificacion = getTabla_Codigo();
        System.out.println(Clasificacion);
        try
        {
            String sql = "SELECT * FROM proveedores WHERE "+Clasificacion+" like "+"'"+recogedor+"%\'";
            System.out.println(sql);
            PreparedStatement pst = link.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int col = rsmd.getColumnCount();
            DefaultTableModel modelo = new DefaultTableModel();
            for (int j = 1; j <= col; j++) {
                modelo.addColumn(rsmd.getColumnLabel(j));
            }
            while (rs.next()) {
                String fila[] = new String[col];
                for (int cont = 0; cont < col; cont++) {
                    fila[cont] = rs.getString(cont + 1);
                }
                modelo.addRow(fila);
            }
            tabla.setModel(modelo);
            rs.close();
            link.close();
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,ex);
        }
        
    }//GEN-LAST:event_txtBusKeyReleased

    private void rdioCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdioCodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdioCodActionPerformed

    private void rdioCodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdioCodMouseClicked
        txtBus.setEnabled(true);
        Control co = new Control();
        tabla_Codigo = rdioCod.getText();
        if(tabla_Codigo.equals("Por Codigo"))
            tabla_Codigo = "Codigo";
        co.Clasifica(tabla_Codigo);
        añadido = "JAM_PROV000";
    }//GEN-LAST:event_rdioCodMouseClicked

    private void rdioNomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdioNomMouseClicked
        txtBus.setEnabled(true);
        Control co = new Control();
        tabla_Codigo = rdioNom.getText();
        if(tabla_Codigo.equals("Por Nombre"))
            tabla_Codigo = "Nombre";
        co.Clasifica(tabla_Codigo);
        añadido = "";
    }//GEN-LAST:event_rdioNomMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Lista_Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lista_Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lista_Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lista_Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Lista_Proveedores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.ButtonGroup clasifican;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdioCod;
    private javax.swing.JRadioButton rdioNom;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtBus;
    // End of variables declaration//GEN-END:variables
}
