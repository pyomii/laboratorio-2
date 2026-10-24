
package laboratorio_2_progra2;

import javax.swing.JOptionPane;
import java.awt.Image;
import javax.swing.ImageIcon;

public class PanelPrestamos extends javax.swing.JPanel {
    
   private Biblioteca biblioteca;
private VentanaPrincipal ventana; 
    public PanelPrestamos(Biblioteca biblioteca, VentanaPrincipal ventana) {
    initComponents();
    this.biblioteca = biblioteca;
    this.ventana = ventana;
}    
    private void mostrarImagen(String ruta) {
        imagen1.setIcon(null);
        imagen1.setText("Sin imagen");
        ImageIcon icono = new ImageIcon(ruta);
        if (icono.getIconWidth() <= 0) {
            return;
        }
        Image img = icono.getImage().getScaledInstance(imagen1.getWidth(), imagen1.getHeight(), Image.SCALE_SMOOTH);
        imagen1.setText("");
        imagen1.setIcon(new ImageIcon(img));
    }
    
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        imagen = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        codigo = new javax.swing.JTextField();
        btn_Buscar = new javax.swing.JButton();
        btn_Prestar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        recibo = new javax.swing.JTextArea();
        imagen1 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable1);

        imagen.setText(".");

        jLabel1.setText("Ingrese el codigo del material:");

        codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoActionPerformed(evt);
            }
        });

        btn_Buscar.setText("Buscar");
        btn_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BuscarActionPerformed(evt);
            }
        });

        btn_Prestar.setText("Prestar");
        btn_Prestar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PrestarActionPerformed(evt);
            }
        });

        recibo.setColumns(20);
        recibo.setRows(5);
        jScrollPane1.setViewportView(recibo);

        imagen1.setText(".");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(imagen1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btn_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_Prestar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Buscar)
                    .addComponent(btn_Prestar))
                .addGap(18, 18, 18)
                .addComponent(imagen1, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                .addGap(10, 10, 10))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BuscarActionPerformed
     if (codigo.getText().trim().isEmpty()) {            JOptionPane.showMessageDialog(this, "Error! todas las casillas deben estar llenadas...", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        biblioteca.consultar(codigo.getText());
        JOptionPane.showMessageDialog(this, biblioteca.getMensaje());
    }//GEN-LAST:event_btn_BuscarActionPerformed

    private void btn_PrestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PrestarActionPerformed
        Prestamo p = biblioteca.prestar(codigo.getText());
        if (p == null) {
            JOptionPane.showMessageDialog(this, biblioteca.getMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            recibo.setText(biblioteca.Recibo(p));
           mostrarImagen(p.getMaterial().getRutaImagen());
            JOptionPane.showMessageDialog(this, biblioteca.getMensaje());
            codigo.setText("");
            ventana.actualizarTabla();
        }
    }//GEN-LAST:event_btn_PrestarActionPerformed

    private void codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Buscar;
    private javax.swing.JButton btn_Prestar;
    private javax.swing.JTextField codigo;
    private javax.swing.JLabel imagen;
    private javax.swing.JLabel imagen1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea recibo;
    // End of variables declaration//GEN-END:variables
}
