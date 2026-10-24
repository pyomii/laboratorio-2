
package laboratorio_2_progra2;

import javax.swing.JOptionPane;
import java.awt.Image;
import javax.swing.ImageIcon;

public class PanelDevoluciones extends javax.swing.JPanel {

    private Biblioteca biblioteca;
private VentanaPrincipal ventana;

public PanelDevoluciones(Biblioteca biblioteca, VentanaPrincipal ventana) {
    initComponents();
    this.biblioteca = biblioteca;
    this.ventana = ventana;
}

    private void mostrarImagen(String ruta) {
        imagen.setIcon(null);
        imagen.setText("Sin imagen");
        ImageIcon icono = new ImageIcon(ruta);
        if (icono.getIconWidth() <= 0) {
            return;
        }
        Image img = icono.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_SMOOTH);
        imagen.setText("");
        imagen.setIcon(new ImageIcon(img));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        codigo = new javax.swing.JTextField();
        btn_Devolver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        recibo = new javax.swing.JTextArea();
        imagen = new javax.swing.JLabel();

        codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoActionPerformed(evt);
            }
        });

        btn_Devolver.setText("Devolver");
        btn_Devolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DevolverActionPerformed(evt);
            }
        });

        jLabel1.setText("Ingrese el codigo del material:");

        recibo.setColumns(20);
        recibo.setRows(5);
        jScrollPane1.setViewportView(recibo);

        imagen.setText(".");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(btn_Devolver, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Devolver)
                        .addGap(18, 18, 18)
                        .addComponent(imagen, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoActionPerformed

    private void btn_DevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DevolverActionPerformed
        Prestamo p = biblioteca.devolver(codigo.getText());
        if (p == null) {
            JOptionPane.showMessageDialog(this, biblioteca.getMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            recibo.setText(biblioteca.Recibo(p));
            mostrarImagen(p.getMaterial().getRutaImagen());
            JOptionPane.showMessageDialog(this, biblioteca.getMensaje());
            codigo.setText("");
        }
    }//GEN-LAST:event_btn_DevolverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Devolver;
    private javax.swing.JTextField codigo;
    private javax.swing.JLabel imagen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea recibo;
    // End of variables declaration//GEN-END:variables
}
