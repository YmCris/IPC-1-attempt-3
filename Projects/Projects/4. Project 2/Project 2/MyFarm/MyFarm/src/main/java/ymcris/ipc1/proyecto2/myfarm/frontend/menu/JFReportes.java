package ymcris.ipc1.proyecto2.myfarm.frontend.menu;

import ymcris.ipc1.proyecto2.myfarm.backend.a.archivos.texto.Archivos;
import ymcris.ipc1.proyecto2.myfarm.backend.reportes.Reportes;
import ymcris.ipc1.proyecto2.myfarm.frontend.creadores.JFCreadorDeMateriaPrima;
import ymcris.ipc1.proyecto2.myfarm.frontend.elementos.PanelPersonalizado;

/**
 *
 * @author crist
 */
public class JFReportes extends javax.swing.JFrame {
    
    Archivos archivos = new Archivos();
    Reportes reportes = new Reportes();
    
    public JFReportes() {
        initComponents();
        this.setTitle("Reportes");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.txtInformacion.setText("");
        pnlFondo.add(new PanelPersonalizado(pnlFondo, JFCreadorDeMateriaPrima.RUTA_IMAGEN)).repaint();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFondo = new javax.swing.JPanel();
        btnSemillas = new javax.swing.JButton();
        btnPartidas = new javax.swing.JButton();
        btnAnimales = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtInformacion = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnSemillas.setText("Ver reportes Semillas");
        btnSemillas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSemillasActionPerformed(evt);
            }
        });

        btnPartidas.setText("Ver reportes Partida");
        btnPartidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPartidasActionPerformed(evt);
            }
        });

        btnAnimales.setText("Ver reportes Animales");
        btnAnimales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnimalesActionPerformed(evt);
            }
        });

        txtInformacion.setEditable(false);
        txtInformacion.setColumns(20);
        txtInformacion.setRows(5);
        jScrollPane1.setViewportView(txtInformacion);

        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFondoLayout = new javax.swing.GroupLayout(pnlFondo);
        pnlFondo.setLayout(pnlFondoLayout);
        pnlFondoLayout.setHorizontalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlFondoLayout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlFondoLayout.createSequentialGroup()
                                .addGap(161, 161, 161)
                                .addComponent(btnSemillas)
                                .addGap(33, 33, 33)
                                .addComponent(btnPartidas)
                                .addGap(30, 30, 30)
                                .addComponent(btnAnimales)))
                        .addGap(0, 95, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        pnlFondoLayout.setVerticalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSemillas)
                    .addComponent(btnPartidas)
                    .addComponent(btnAnimales))
                .addGap(47, 47, 47))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPartidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPartidasActionPerformed
        String contenido = archivos.leerArchivo(reportes.getReportesPartidas());
        txtInformacion.setText(contenido);
    }//GEN-LAST:event_btnPartidasActionPerformed

    private void btnSemillasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSemillasActionPerformed
        String contenido = archivos.leerArchivo(reportes.getReportesPlantas());
        txtInformacion.setText(contenido);
    }//GEN-LAST:event_btnSemillasActionPerformed

    private void btnAnimalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnimalesActionPerformed
        String contenido = archivos.leerArchivo(reportes.getReportesAnimales());
        txtInformacion.setText(contenido);
    }//GEN-LAST:event_btnAnimalesActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        new JFMenuPrincipal().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnimales;
    private javax.swing.JButton btnPartidas;
    private javax.swing.JButton btnSemillas;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JTextArea txtInformacion;
    // End of variables declaration//GEN-END:variables
}
