/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import java.text.DateFormat;
import Clases.Carga_ComboBox;
import Clases.Panel;
import Clases.Ultimo_Numero;
import Jdbc.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author anthony
 */
      
public class Form_Pedidos extends javax.swing.JFrame {

    /**
     * Creates new form Form_Pedidos
     */
    public Form_Pedidos() {
        DateFormat varfe = DateFormat.getDateInstance();
        
        initComponents();
        setTitle("Pedidos");
        setLocationRelativeTo(null);
        deshabilitar();
        UltimoNum();
        Cargar();
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/pruebass.png")).getImage());
        ((JPanel)getContentPane()).setOpaque(fal­se);
        ImageIcon uno=new ImageIcon(this.getClass().getResource("/Imagenes/pruebass.png"));
        JLabel fondo= new JLabel(); 
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
        fondo.setBounds(0,0,uno.getIconWidth(),u­no.getIconHeight());
    }
    
    void deshabilitar()
    {
        Panel pa = new Panel();
        txtFe_Pe.setText(pa.Fecha());
        txtCod.setEnabled(false);
        txtFe_Pe.setEnabled(false);
    }
    public void Cargar()
    {
        ResultSet rs;
        Carga_ComboBox combo = new Carga_ComboBox();
        try
        {
            rs = combo.Combo("Proveedores");
            while(rs.next())
            {
                CmbProv.addItem(rs.getString(1));
            }
        }
                catch(Exception x)
        {
            JOptionPane.showMessageDialog(null,x);
        }
    }
    public String Fecha_Entrega()
    {
        int años = Jaño.getYear();
        int meses = Jmes.getMonth() + 1;
        String dia = CmbDia.getSelectedItem().toString();
        String mes = Integer.toString(meses);
        String año = Integer.toString(años);
        String Fecha = dia+"/"+mes+"/"+año;
        System.out.println(Fecha);
        return Fecha;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox();
        btnAceptar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtPed = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDes = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtFe_Pe = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        CmbProv = new javax.swing.JComboBox();
        Jaño = new com.toedter.calendar.JYearChooser();
        Jmes = new com.toedter.calendar.JMonthChooser();
        CmbDia = new javax.swing.JComboBox();
        lblDia_llegada = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Apply medi.png"))); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.setBorderPainted(false);
        btnAceptar.setContentAreaFilled(false);
        btnAceptar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAceptar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Apply.png"))); // NOI18N
        btnAceptar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Apply.png"))); // NOI18N
        btnAceptar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 374, 92, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), null));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Codigo");

        txtCod.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCod)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 11, 373, -1));

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reload me.png"))); // NOI18N
        btnCancel.setText("Cancelar");
        btnCancel.setBorderPainted(false);
        btnCancel.setContentAreaFilled(false);
        btnCancel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancel.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reload gr.png"))); // NOI18N
        btnCancel.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reload gr.png"))); // NOI18N
        btnCancel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 374, 91, -1));

        jLabel1.setText("Nombre de Pedido");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 103, 112, -1));
        getContentPane().add(txtPed, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 100, 223, -1));

        jLabel4.setText("Descripcion");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 164, -1, -1));

        txtDes.setColumns(20);
        txtDes.setRows(5);
        jScrollPane1.setViewportView(txtDes);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 164, 223, 113));

        jLabel5.setText("Fecha de Pedido");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 286, -1, -1));

        jLabel6.setText("Fecha de Entrega");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 321, -1, -1));
        getContentPane().add(txtFe_Pe, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 283, 223, -1));

        jLabel7.setText("Proveedor");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 135, -1, -1));

        CmbProv.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "......" }));
        CmbProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbProvActionPerformed(evt);
            }
        });
        getContentPane().add(CmbProv, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 132, 223, -1));
        getContentPane().add(Jaño, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 314, -1, 24));
        getContentPane().add(Jmes, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 314, -1, 24));

        CmbDia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        CmbDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbDiaActionPerformed(evt);
            }
        });
        getContentPane().add(CmbDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 318, -1, -1));
        getContentPane().add(lblDia_llegada, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 349, 211, 14));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/Nuevo Pedido.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        String combo = CmbProv.getSelectedItem().toString();
        Conexion co = new Conexion();
        Connection link = co.Conec();
        if(combo.equals("......"))
        {
            JOptionPane.showMessageDialog(null,"Escoja un Proveedor");
        }
        else
        {
            try
            {
                PreparedStatement pst = link.prepareStatement("INSERT INTO pedidos (Codigo,Nombre,Proveedor,Descripcion,Fecha_Ped,Fecha_Entrega) VALUES (?,?,?,?,?,?)");
                pst.setString(1, txtCod.getText());
                pst.setString(2, txtPed.getText());
                pst.setString(3, combo);
                pst.setString(4, txtDes.getText());
                pst.setString(5, txtFe_Pe.getText());
                pst.setString(6, Fecha_Entrega());
                int verificador = pst.executeUpdate();
                if(verificador > 0)
                {
                    JOptionPane.showMessageDialog(null, "Pedido Registrado");
                    actualizar_numero(UltimoNum());
                    dispose();
                }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"Error "+e);
            }
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void CmbProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbProvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CmbProvActionPerformed

    private void CmbDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbDiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CmbDiaActionPerformed
    
    public int UltimoNum()
    {
        Ultimo_Numero u = new Ultimo_Numero();
        int recogerlo = u.Ultimo_numero("Pedidos");
        String t = Integer.toString(recogerlo);
        t = "JAM_PED000"+recogerlo;
        txtCod.setText(t);
        return recogerlo;
    }
    
    public void actualizar_numero(int x)
    {
        Ultimo_Numero u = new Ultimo_Numero();
        int numero = x + 1;
        u.Actualizar_Ultimo("Pedidos", numero);
    }
    
    
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
            java.util.logging.Logger.getLogger(Form_Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_Pedidos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox CmbDia;
    public javax.swing.JComboBox CmbProv;
    public com.toedter.calendar.JYearChooser Jaño;
    public com.toedter.calendar.JMonthChooser Jmes;
    public javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancel;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lblDia_llegada;
    public javax.swing.JTextField txtCod;
    public javax.swing.JTextArea txtDes;
    public javax.swing.JTextField txtFe_Pe;
    public javax.swing.JTextField txtPed;
    // End of variables declaration//GEN-END:variables
}
