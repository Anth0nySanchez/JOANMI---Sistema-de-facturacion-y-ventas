package Menu;

import Clases.Carga_ComboBox;
import Clases.Codigo;
import Jdbc.Conexion_cat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class Inventario extends javax.swing.JFrame {

    Conexion_cat cn = new Conexion_cat();
    Connection link = cn.ConecCat();

    public Inventario() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Inventario");
        Columnas();
        Cargar();
        Combo();
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/pruebass.png")).getImage());
        ((JPanel)getContentPane()).setOpaque(fal­se);
        ImageIcon uno=new ImageIcon(this.getClass().getResource("/Imagenes/pruebass.png"));
        JLabel fondo= new JLabel(); 
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
        fondo.setBounds(0,0,uno.getIconWidth(),u­no.getIconHeight());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        Modificar = new javax.swing.JMenuItem();
        Eliminar = new javax.swing.JMenuItem();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        CmbCat = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        lblTip_Pro = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        Modificar.setText("Modificar");
        Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(Modificar);

        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(Eliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        tabla.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tabla);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 156, 966, 333));

        jLabel2.setText("Filtrar por Categoria: ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 109, -1, -1));

        CmbCat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "......" }));
        CmbCat.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CmbCatItemStateChanged(evt);
            }
        });
        CmbCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbCatActionPerformed(evt);
            }
        });
        getContentPane().add(CmbCat, new org.netbeans.lib.awtextra.AbsoluteConstraints(488, 106, 173, -1));

        jLabel3.setText("Tipo de Producto: ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 509, -1, -1));
        getContentPane().add(lblTip_Pro, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 509, 62, 14));

        jLabel5.setText("Cantidad de Productos:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(567, 509, -1, -1));
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(698, 509, 67, 14));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/configuration me.png"))); // NOI18N
        jButton1.setText("Modificar");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/configuration grande.png"))); // NOI18N
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/configuration grande.png"))); // NOI18N
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/recycle-full me.png"))); // NOI18N
        jButton2.setText("Eliminar");
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/recycle-full grande.png"))); // NOI18N
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/recycle-full grande.png"))); // NOI18N
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/print me.png"))); // NOI18N
        jButton3.setText("Imprimir");
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/print grande.png"))); // NOI18N
        jButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/print grande.png"))); // NOI18N
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reload me.png"))); // NOI18N
        jButton4.setText("Cancelar");
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reload gr.png"))); // NOI18N
        jButton4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reload gr.png"))); // NOI18N
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 156, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel1.setText("INVENTARIO");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel1)
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 11, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/Inventario.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void Cantidades() {
        int num_filas = tabla.getRowCount(), acum = 0, c;
        String converter = Integer.toString(num_filas);
        lblTip_Pro.setText(converter);
        for (int cont = 0; cont < num_filas; cont++) {
            converter = tabla.getValueAt(cont, 2).toString();
            c = Integer.parseInt(converter);
            acum = acum + c;
        }
        converter = Integer.toString(acum);
        jLabel6.setText(converter);
    }

    private void ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarActionPerformed
        modificar();
    }//GEN-LAST:event_ModificarActionPerformed

    public void modificar()
    {
        try {
            New_Mercaderia merc = new New_Mercaderia();
            merc.btnSave.setEnabled(false);
            merc.btnMod.setEnabled(true);
            merc.btnFechaHora.setEnabled(false);
            merc.btnEli.setEnabled(true);

            int fila = tabla.getSelectedRow();
            if (fila >= 0) {
                merc.txtCod.setText(tabla.getValueAt(fila, 0).toString());
                merc.txtNom_Pro.setText(tabla.getValueAt(fila, 1).toString());
                merc.txtCanti.setText(tabla.getValueAt(fila, 2).toString());
                merc.CmbPro.setSelectedItem(tabla.getValueAt(fila, 3).toString());
                merc.CmbCat.setSelectedItem(tabla.getValueAt(fila, 4).toString());
                merc.tare_desc.setText(tabla.getValueAt(fila, 5).toString());
                merc.txtPre_uni.setText(tabla.getValueAt(fila, 6).toString());
                merc.txtDia_lle.setText(tabla.getValueAt(fila, 7).toString());
                merc.txtHora_lle.setText(tabla.getValueAt(fila, 8).toString());
                
                merc.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una fila");
            }
        } catch (Exception e) {
          e.printStackTrace();
        }
    }
    
    public void Eliminar()
    {
        Conexion_cat cn = new Conexion_cat();
        Connection link = cn.ConecCat();
        int fila = tabla.getSelectedRow();
        String cod = tabla.getValueAt(fila, 0).toString();
        if (fila >= 0) {
            String Cate = tabla.getValueAt(fila, 9).toString();
            if (Cate.equals("....")) {
                JOptionPane.showMessageDialog(null, "Escoja una Categoria");
            }
            try {
                PreparedStatement pst = link.prepareStatement("DELETE FROM " + Cate + " WHERE Codigo = '" + cod + "'");
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Eliminado con Exito");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una Fila");
        }
    }
    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        Eliminar();
    }//GEN-LAST:event_EliminarActionPerformed

    private void CmbCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbCatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CmbCatActionPerformed

    private void CmbCatItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CmbCatItemStateChanged
        filtrar();
        Cantidades();
    }//GEN-LAST:event_CmbCatItemStateChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Eliminar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     modificar();   
    }//GEN-LAST:event_jButton1ActionPerformed

    public void Combo() {
        ResultSet rs;
        Carga_ComboBox combo = new Carga_ComboBox();
        try {
            rs = combo.Categoria();
               while (rs.next()) {
                CmbCat.addItem(rs.getString(1));
                 }
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

    public void filtrar() {
        String combo = CmbCat.getSelectedItem().toString();
        if (combo.equals("......")) {
            Cargar();
        }
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Proveedor");
        modelo.addColumn("Categoria");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Precio_Unit");
        modelo.addColumn("Dia_Llegada");
        modelo.addColumn("Hora_Llegada");
        
        String vector[] = new String[9];
        if (!(combo.equals("......"))) {
            try {
                PreparedStatement pst = link.prepareStatement("SELECT * FROM " + combo);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    vector[0] = rs.getString(1);
                    vector[1] = rs.getString(2);
                    vector[2] = rs.getString(3);
                    vector[3] = rs.getString(4);
                    vector[4] = rs.getString(5);
                    vector[5] = rs.getString(6);
                    vector[6] = rs.getString(7);
                    vector[7] = rs.getString(8);
                    vector[8] = rs.getString(9);
                    modelo.addRow(vector);
                }
                pst.close();
                rs.close();
                tabla.setModel(modelo);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error " + e);
            }
        }
    }

    public void Columnas()
    {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Proveedor");
        modelo.addColumn("Categoria");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Precio_Unit");
        modelo.addColumn("Dia_Llegada");
        modelo.addColumn("Hora_Llegada");
        tabla.setModel(modelo);
    }
    
    public void Cargar()  {
        int limite,tables;
        Codigo co = new Codigo();
        String arreglo[] = co.Codigos();
        limite = co.retornador();
        DefaultTableModel modelo = new DefaultTableModel();
        
        //Se agregan etiquetas a las tablas
         modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Proveedor");
        modelo.addColumn("Categoria");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Precio_Unit");
        modelo.addColumn("Dia_Llegada");
        modelo.addColumn("Hora_Llegada");
        
        
        
        //Se llenan las filas con los datoas de los productos
        
        for(tables = 1; tables <= limite; tables++)
        { 
          try
          {
            String sql = "SELECT * FROM "+arreglo[tables];
            PreparedStatement pst = link.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int col = rsmd.getColumnCount();
            while (rs.next()) 
            {
                String fila[] = new String[col];
                for (int cont = 0; cont < col; cont++) 
                {
                    fila[cont] = rs.getString(cont + 1);
                }
                modelo.addRow(fila); 
            }   
          }

          
          catch(SQLException e)
          {
            JOptionPane.showMessageDialog(null,e);
          }
          catch(Exception ex)
          {
            JOptionPane.showMessageDialog(null, ex);
          }
        }
        tabla.setModel(modelo);
        Cantidades();
    }
        
    

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox CmbCat;
    private javax.swing.JMenuItem Eliminar;
    private javax.swing.JMenuItem Modificar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTip_Pro;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
