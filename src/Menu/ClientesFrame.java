/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Jdbc.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author anthony
 */
public class ClientesFrame extends javax.swing.JFrame {

    Conexion cn = new Conexion();
    Connection link = cn.Conec();
    Sistema_Ventas sis = new Sistema_Ventas();
    String recaudador [] = new String [9];
    
    public ClientesFrame() {
        initComponents();
        setTitle("Seleccionar Cliente");
        setLocationRelativeTo(null);
        Tablas();
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/pruebass.png")).getImage());
        ((JPanel)getContentPane()).setOpaque(fal­se);
        ImageIcon uno=new ImageIcon(this.getClass().getResource("/Imagenes/pruebass.png"));
        JLabel fondo= new JLabel(); 
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
        fondo.setBounds(0,0,uno.getIconWidth(),u­no.getIconHeight());
    }

    
    
    
    public void Tablas()
    {
        String fila[] = new String[2];
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Cedula");
        modelo.addColumn("Nombre");
        try
        {
            PreparedStatement pst = link.prepareStatement("SELECT * FROM clientes");
            ResultSet rs = pst.executeQuery();
            while(rs.next())
            {
                String Recogedor1 = rs.getString(3), Recogedor2 = rs.getString(4);
                String Nombres = Recogedor1 + " " + Recogedor2;
                fila[0] = rs.getString(2);
                fila[1] = Nombres;
                modelo.addRow(fila);
            }
            tabla.setModel(modelo);
        }
        catch(Exception e)
        {
           JOptionPane.showMessageDialog(null,"Error"); 
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btnSelec = new javax.swing.JButton();
        btnCan = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tabla);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 467, 272));

        btnSelec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ID me.png"))); // NOI18N
        btnSelec.setText("Seleccionar");
        btnSelec.setBorderPainted(false);
        btnSelec.setContentAreaFilled(false);
        btnSelec.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSelec.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ID gr.png"))); // NOI18N
        btnSelec.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ID gr.png"))); // NOI18N
        btnSelec.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSelec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSelecMouseClicked(evt);
            }
        });
        btnSelec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecActionPerformed(evt);
            }
        });
        getContentPane().add(btnSelec, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 294, -1, -1));

        btnCan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reload me.png"))); // NOI18N
        btnCan.setText("Cancelar");
        btnCan.setBorderPainted(false);
        btnCan.setContentAreaFilled(false);
        btnCan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCan.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reload gr.png"))); // NOI18N
        btnCan.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reload gr.png"))); // NOI18N
        btnCan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCanActionPerformed(evt);
            }
        });
        getContentPane().add(btnCan, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 294, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/ClientesFrame.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanActionPerformed
        dispose();
    }//GEN-LAST:event_btnCanActionPerformed

    private void btnSelecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecActionPerformed
        int fila = tabla.getSelectedRow();
        String filaseleccionada = tabla.getValueAt(fila, 0).toString();
        int convertidor = Integer.parseInt(filaseleccionada);
        if(fila >= 0)
        {
            try
            {
                PreparedStatement pst = link.prepareStatement("SELECT * FROM Clientes WHERE Cedula = '"+convertidor+"'");
                ResultSet rs = pst.executeQuery();
                rs.next();
                sis.txtCod.setText(rs.getString(1));
                sis.txtCi.setText(rs.getString(2));
                sis.txtNom.setText(rs.getString(3));
                sis.txtApe.setText(rs.getString(4));
                sis.txtDir.setText(rs.getString(5));
                sis.txtCor.setText(rs.getString(6));
                sis.txtSexo.setText(rs.getString(7));
                sis.txtCel.setText(rs.getString(8));
                sis.txtTel.setText(rs.getString(9));
                dispose();
                sis.setVisible(true);
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"Error "+e);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Seleccione un Cliente");
        }
    }//GEN-LAST:event_btnSelecActionPerformed

    private void btnSelecMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSelecMouseClicked

    }//GEN-LAST:event_btnSelecMouseClicked

    
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
            java.util.logging.Logger.getLogger(ClientesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientesFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCan;
    public javax.swing.JButton btnSelec;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
