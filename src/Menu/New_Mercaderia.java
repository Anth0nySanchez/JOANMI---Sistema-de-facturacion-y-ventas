package Menu;

import Clases.Carga_ComboBox;
import Clases.Asignacion_Provee;
import Clases.Codigo;
import Clases.Panel;
import Clases.Control;
import Clases.Ultimo_Numero;
import Jdbc.Conexion;
import Jdbc.Conexion_cat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class New_Mercaderia extends javax.swing.JFrame {

    
    public New_Mercaderia()  {
        initComponents();
        setLocationRelativeTo(null);
        Codigo();
        proveedores();
        Categoria();
        deshabilitar();
        setTitle("Nueva Mercaderia");
        btnMod.setEnabled(false);
        btnEli.setEnabled(false);
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/pruebass.png")).getImage());
        ((JPanel)getContentPane()).setOpaque(fal­se);
        ImageIcon uno=new ImageIcon(this.getClass().getResource("/Imagenes/pruebass.png"));
        JLabel fondo= new JLabel(); 
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
        fondo.setBounds(0,0,uno.getIconWidth(),u­no.getIconHeight());
    }

    
    public void proveedores()
    {
        ResultSet rs;
        Carga_ComboBox combo = new Carga_ComboBox();
        try
        {
            rs = combo.Combo("Proveedores");
            while(rs.next())
            {
                CmbPro.addItem(rs.getString(1));
            }
        }
                catch(Exception x)
        {
            JOptionPane.showMessageDialog(null,x);
        }
    }
    public void Categoria()
    {
        ResultSet rs;
        Carga_ComboBox combo = new Carga_ComboBox();
        try
        {
            rs = combo.Categoria();
            while(rs.next())
            {
                CmbCat.addItem(rs.getString(1));
            }
        }
        catch(Exception x)
        {
            JOptionPane.showMessageDialog(null, x);
        }
    }
    
  public void deshabilitar()
  {
      txtCod.setEnabled(false);
      txtDia_lle.setEnabled(false);
      txtHora_lle.setEnabled(false);
  }
  public void fecha()
  {
      String x;
      Panel y = new Panel();
      x = y.Fecha();
      System.out.println(x);
      txtDia_lle.setText(x); 
  }
  public void hora()
  {
      Control p = new Control();
        Calendar hour = new GregorianCalendar();
        int h,m,s;
        String x;
        h = hour.get(Calendar.HOUR_OF_DAY);
        m = hour.get(Calendar.MINUTE);
        s = hour.get(Calendar.SECOND);
        x = h+":"+m+":"+s;
        System.out.println(x);
        txtHora_lle.setText(x);
  }
  
  
  
  
  public void Mercaderia(String x)
  {
        Conexion_cat cn = new Conexion_cat();
        Connection link = cn.ConecCat();
        try
        {
            int contador = 1;
            String combo = CmbPro.getSelectedItem().toString();
            String categoria = CmbCat.getSelectedItem().toString();
            String fecha = txtDia_lle.getText();
            String hora = txtHora_lle.getText();
            String textarea = tare_desc.getText();
                    
            PreparedStatement pst;
            pst = link.prepareStatement("INSERT INTO "+x+"(Codigo,Nombre,Cantidad,Proveedor,Categoria,Descripcion,Precio_Unit,Dia_Llegada,Hora_Llegada) VALUES(?,?,?,?,?,?,?,?,?)");
            pst.setString(1, txtCod.getText());
            pst.setString(2, txtNom_Pro.getText());
            pst.setString(3, txtCanti.getText());
            pst.setString(4, combo);
            pst.setString(5, categoria);
            pst.setString(6, textarea);
            pst.setString(7, txtPre_uni.getText());
            pst.setString(8, fecha);
            pst.setString(9, hora);

            if(fecha.equals(" "))
            {
                JOptionPane.showMessageDialog(null,"Asigne Dia y Hora");
                contador = 0;
            }
            
            if(hora.equals(" "))
            {
                JOptionPane.showMessageDialog(null,"Asigne Dia y Hora");
                contador = 0;
            }

            if(combo == "....")
            {
                JOptionPane.showMessageDialog(null,"Escoja un Proveedor");
                contador = 0;
            }
            if(contador > 0)
            {
                contador = pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Mercaderia Registrada con Exito");
                txtNom_Pro.setText(null);
                txtCanti.setText(null);
                tare_desc.setText(null);
                txtPre_uni.setText(null);
                txtDia_lle.setText(null);
                txtHora_lle.setText(null);
                txtNom_Pro.requestFocus();
                Ultimo_Numero num = new Ultimo_Numero();
                num.Actualizar_Ultimo("Mercaderia", Codigo());
                Codigo();
            }
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null,"Error: llene Correctamentamente todos los campos");
        } 
  }
  
  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCanti = new javax.swing.JTextField();
        txtNom_Pro = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        CmbPro = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tare_desc = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        txtPre_uni = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtDia_lle = new javax.swing.JTextField();
        txtHora_lle = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        CmbCat = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnEli = new javax.swing.JButton();
        btnMod = new javax.swing.JButton();
        btnFechaHora = new javax.swing.JButton();
        btnCan = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 26)); // NOI18N
        jLabel1.setText("NUEVA MERCADERIA");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 25, 286, 42));

        jLabel2.setText("Codigo");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 94, 56, 15));

        txtCod.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        getContentPane().add(txtCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 85, 185, -1));

        jLabel3.setText("Nombre del Producto");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 132, 121, -1));

        jLabel5.setText("Cantidad");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 74, -1));

        txtCanti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantiActionPerformed(evt);
            }
        });
        txtCanti.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantiKeyTyped(evt);
            }
        });
        getContentPane().add(txtCanti, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 165, 185, -1));

        txtNom_Pro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNom_ProActionPerformed(evt);
            }
        });
        getContentPane().add(txtNom_Pro, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 129, 185, -1));

        jLabel4.setText("Proveedor");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 74, 30));

        CmbPro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "...." }));
        CmbPro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CmbProMouseClicked(evt);
            }
        });
        CmbPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbProActionPerformed(evt);
            }
        });
        getContentPane().add(CmbPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 201, 185, -1));

        jLabel6.setText("Descripcion del Producto");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 275, 156, -1));

        tare_desc.setColumns(20);
        tare_desc.setRows(5);
        tare_desc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tare_descKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tare_desc);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 348, -1));

        jLabel7.setText("Precio Unitario");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 417, 108, -1));

        txtPre_uni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPre_uniActionPerformed(evt);
            }
        });
        getContentPane().add(txtPre_uni, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 414, 59, -1));

        jLabel9.setText("Hora de Llegada");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 489, 119, -1));

        jLabel10.setText("Dia de llegada");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 453, 119, -1));

        txtDia_lle.setText(" ");
        txtDia_lle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDia_lleActionPerformed(evt);
            }
        });
        getContentPane().add(txtDia_lle, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 450, 196, -1));

        txtHora_lle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHora_lleActionPerformed(evt);
            }
        });
        getContentPane().add(txtHora_lle, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 486, 196, -1));

        jLabel11.setText("Categoria");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, -1, -1));

        CmbCat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "...." }));
        CmbCat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CmbCatMouseEntered(evt);
            }
        });
        CmbCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbCatActionPerformed(evt);
            }
        });
        getContentPane().add(CmbCat, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 237, 185, -1));

        jLabel12.setText("$");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 417, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/save me.png"))); // NOI18N
        btnSave.setText("Guardar");
        btnSave.setBorderPainted(false);
        btnSave.setContentAreaFilled(false);
        btnSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSave.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/save grande.png"))); // NOI18N
        btnSave.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/save grande.png"))); // NOI18N
        btnSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        btnSave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnSaveKeyPressed(evt);
            }
        });

        btnEli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/recycle-full me.png"))); // NOI18N
        btnEli.setText("Eliminar");
        btnEli.setBorderPainted(false);
        btnEli.setContentAreaFilled(false);
        btnEli.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEli.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/recycle-full grande.png"))); // NOI18N
        btnEli.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/recycle-full grande.png"))); // NOI18N
        btnEli.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliActionPerformed(evt);
            }
        });

        btnMod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/configuration me.png"))); // NOI18N
        btnMod.setText("Modificar");
        btnMod.setBorderPainted(false);
        btnMod.setContentAreaFilled(false);
        btnMod.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMod.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/configuration grande.png"))); // NOI18N
        btnMod.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/configuration grande.png"))); // NOI18N
        btnMod.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModActionPerformed(evt);
            }
        });

        btnFechaHora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/calendar me.png"))); // NOI18N
        btnFechaHora.setText("Asignar Tiempo");
        btnFechaHora.setBorderPainted(false);
        btnFechaHora.setContentAreaFilled(false);
        btnFechaHora.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFechaHora.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/calendar gr.png"))); // NOI18N
        btnFechaHora.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/calendar gr.png"))); // NOI18N
        btnFechaHora.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnFechaHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFechaHoraActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMod, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEli, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnCan, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnFechaHora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEli)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFechaHora)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMod)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(398, 106, 124, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Downloads\\Compressed\\photos\\Nueva Mercaderia.jpg")); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDia_lleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDia_lleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDia_lleActionPerformed

    private void txtHora_lleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHora_lleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHora_lleActionPerformed

    private void btnCanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanActionPerformed
        dispose();
    }//GEN-LAST:event_btnCanActionPerformed

    private void btnFechaHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFechaHoraActionPerformed
        fecha();
        hora();
    }//GEN-LAST:event_btnFechaHoraActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        Mercaderia(CmbCat.getSelectedItem().toString());
    }//GEN-LAST:event_btnSaveActionPerformed

    private void CmbProMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CmbProMouseClicked
   
    }//GEN-LAST:event_CmbProMouseClicked

    private void CmbCatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CmbCatMouseEntered

    }//GEN-LAST:event_CmbCatMouseEntered

    private void CmbCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbCatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CmbCatActionPerformed

    private void txtCantiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantiKeyTyped
        char c = evt.getKeyChar();
        if(c>'0'&&c>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtCantiKeyTyped

    private void txtNom_ProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNom_ProActionPerformed
        txtNom_Pro.transferFocus();
    }//GEN-LAST:event_txtNom_ProActionPerformed

    private void txtCantiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantiActionPerformed
        txtCanti.transferFocus();
    }//GEN-LAST:event_txtCantiActionPerformed

    private void tare_descKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tare_descKeyPressed

    }//GEN-LAST:event_tare_descKeyPressed

    private void txtPre_uniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPre_uniActionPerformed
        txtPre_uni.transferFocus();
    }//GEN-LAST:event_txtPre_uniActionPerformed

    private void btnSaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSaveKeyPressed
        Mercaderia(CmbCat.getSelectedItem().toString());
    }//GEN-LAST:event_btnSaveKeyPressed

    private void btnModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModActionPerformed
        Conexion_cat Conexion = new Conexion_cat();
        Connection link = Conexion.ConecCat();
        String Prov = CmbPro.getSelectedItem().toString();
        String cate = CmbCat.getSelectedItem().toString();
        float Pre_uni = Float.parseFloat(txtPre_uni.getText());
        int cant = Integer.parseInt(txtCanti.getText());
        if(Prov.equals("...."))
        {
            JOptionPane.showMessageDialog(null,"Escoja un proveedor");
        }
        else if(cate.equals("...."))
        {
            JOptionPane.showMessageDialog(null,"Escoja una categoria");
        }
        
        else
        {
            
        
        try
        {
           PreparedStatement pst = link.prepareStatement("UPDATE "+cate+" SET Codigo = '"+txtCod.getText()+"', Dia_Llegada = '"+txtDia_lle.getText()+"', Hora_Llegada = '"+txtHora_lle.getText()+"', Categoria = '"+cate+"' WHERE Codigo = '"+txtCod.getText()+"'");
           int cont = pst.executeUpdate();
           if(cont > 0)
           {
            JOptionPane.showMessageDialog(null,"Datos Modificados");
            dispose();
           }          
    }//GEN-LAST:event_btnModActionPerformed
      
        catch(Exception e)
       {
           JOptionPane.showMessageDialog(null,"Error");
       }
        }
    }
    private void btnEliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliActionPerformed
        Conexion_cat cn = new Conexion_cat();
        Connection link = cn.ConecCat();
        String Cate = CmbCat.getSelectedItem().toString();
        if(Cate.equals("...."))
        {
            JOptionPane.showMessageDialog(null,"Escoja una Categoria");
        }
        try
        {
            PreparedStatement pst = link.prepareStatement("DELETE FROM "+Cate+" WHERE Codigo = '"+txtCod.getText()+"'");
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Eliminado con Exito");
            dispose();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error");
        }
    }//GEN-LAST:event_btnEliActionPerformed

    private void CmbProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CmbProActionPerformed
       
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
            java.util.logging.Logger.getLogger(New_Mercaderia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(New_Mercaderia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(New_Mercaderia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(New_Mercaderia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new New_Mercaderia().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox CmbCat;
    public javax.swing.JComboBox CmbPro;
    public javax.swing.JButton btnCan;
    public javax.swing.JButton btnEli;
    public javax.swing.JButton btnFechaHora;
    public javax.swing.JButton btnMod;
    public javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextArea tare_desc;
    public javax.swing.JTextField txtCanti;
    public javax.swing.JTextField txtCod;
    public javax.swing.JTextField txtDia_lle;
    public javax.swing.JTextField txtHora_lle;
    public javax.swing.JTextField txtNom_Pro;
    public javax.swing.JTextField txtPre_uni;
    // End of variables declaration//GEN-END:variables

public int Codigo()
  {
    Ultimo_Numero num = new Ultimo_Numero();
    int recogedor = num.Ultimo_numero("Mercaderia");
    String Conver = Integer.toString(recogedor);
    Conver = "JAM_MERC000"+Conver;
    txtCod.setText(Conver);
    recogedor++;
    return recogedor;
  }
}

