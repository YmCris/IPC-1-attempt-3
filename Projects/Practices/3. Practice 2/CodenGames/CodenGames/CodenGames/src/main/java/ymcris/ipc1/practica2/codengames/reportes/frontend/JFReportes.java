package ymcris.ipc1.practica2.codengames.reportes.frontend;

import java.io.File;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;
import ymcris.ipc1.practica2.codengames.a.frontend.JFMenuPrincipal;
import static ymcris.ipc1.practica2.codengames.a.frontend.JFMenuPrincipal.musicaMenu;
import ymcris.ipc1.practica2.codengames.reportes.backend.Archivos;
import static ymcris.ipc1.practica2.codengames.reportes.backend.Archivos.nombreRutaCarpetaHunter;
import static ymcris.ipc1.practica2.codengames.reportes.backend.Archivos.leerCarpetas;

/**
 *
 * @author YmCris
 */
public class JFReportes extends javax.swing.JFrame {

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public JFReportes() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    // CÓDIGO AUTOGENERADO -----------------------------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnInformacion = new javax.swing.JButton();
        btnMusica = new javax.swing.JButton();
        btnSalirDelJuego = new javax.swing.JButton();
        btnHunter = new javax.swing.JButton();
        btnPartidasGanadas = new javax.swing.JButton();
        btnPartidasPerdidas = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtReportes = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Reportes");
        setBackground(new java.awt.Color(102, 102, 102));
        setMaximumSize(new java.awt.Dimension(0, 0));
        setName("JFReportes"); // NOI18N

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        btnInformacion.setBackground(new java.awt.Color(51, 51, 51));
        btnInformacion.setForeground(new java.awt.Color(255, 255, 255));
        btnInformacion.setText("!");
        btnInformacion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnInformacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInformacionActionPerformed(evt);
            }
        });

        btnMusica.setBackground(new java.awt.Color(51, 51, 51));
        btnMusica.setForeground(new java.awt.Color(255, 255, 255));
        btnMusica.setText("M");
        btnMusica.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnMusica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMusicaActionPerformed(evt);
            }
        });

        btnSalirDelJuego.setBackground(new java.awt.Color(51, 51, 51));
        btnSalirDelJuego.setForeground(new java.awt.Color(255, 255, 255));
        btnSalirDelJuego.setText("<-");
        btnSalirDelJuego.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSalirDelJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirDelJuegoActionPerformed(evt);
            }
        });

        btnHunter.setBackground(new java.awt.Color(51, 51, 51));
        btnHunter.setForeground(new java.awt.Color(255, 255, 255));
        btnHunter.setText("PARTIDAS DE HUNTER");
        btnHunter.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnHunter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHunterActionPerformed(evt);
            }
        });

        btnPartidasGanadas.setBackground(new java.awt.Color(51, 51, 51));
        btnPartidasGanadas.setForeground(new java.awt.Color(255, 255, 255));
        btnPartidasGanadas.setText("PARTIDAS GANADAS BUSCAMINAS");
        btnPartidasGanadas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPartidasGanadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPartidasGanadasActionPerformed(evt);
            }
        });

        btnPartidasPerdidas.setBackground(new java.awt.Color(51, 51, 51));
        btnPartidasPerdidas.setForeground(new java.awt.Color(255, 255, 255));
        btnPartidasPerdidas.setText("PARTIDAS PERDIDAS BUSCAMINAS");
        btnPartidasPerdidas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPartidasPerdidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPartidasPerdidasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(434, Short.MAX_VALUE)
                .addComponent(btnHunter)
                .addGap(394, 394, 394)
                .addComponent(btnMusica, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnInformacion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalirDelJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(btnPartidasGanadas)
                    .addContainerGap(892, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(227, 227, 227)
                    .addComponent(btnPartidasPerdidas)
                    .addContainerGap(683, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnMusica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSalirDelJuego, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnInformacion))
                        .addGap(24, 24, 24))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnHunter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btnPartidasGanadas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btnPartidasPerdidas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        txtReportes.setColumns(20);
        txtReportes.setRows(5);
        jScrollPane1.setViewportView(txtReportes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMusicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMusicaActionPerformed
        if (musicaMenu.isActive()) {
            musicaMenu.stop();
        } else if (!musicaMenu.isActive()) {
            musicaMenu.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }//GEN-LAST:event_btnMusicaActionPerformed

    private void btnInformacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInformacionActionPerformed
        JOptionPane.showMessageDialog(null, "¡ROMPE TODOS LOS RECORDS!", "REPORTES", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnInformacionActionPerformed

    private void btnSalirDelJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirDelJuegoActionPerformed
        musicaMenu.stop();
        new JFMenuPrincipal().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalirDelJuegoActionPerformed

    private void btnHunterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHunterActionPerformed
        File[] archivosHunter = Archivos.obtenerArchivosDeUnaCarpeta(nombreRutaCarpetaHunter);
        txtReportes.setText(leerCarpetas(archivosHunter));
    }//GEN-LAST:event_btnHunterActionPerformed

    private void btnPartidasGanadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPartidasGanadasActionPerformed
        File[] archivoBuscaminasG = Archivos.obtenerArchivosDeUnaCarpeta(Archivos.nombreRutaCarpetaBuscaminasGanadas);
        txtReportes.setText(leerCarpetas(archivoBuscaminasG));
    }//GEN-LAST:event_btnPartidasGanadasActionPerformed

    private void btnPartidasPerdidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPartidasPerdidasActionPerformed
        File[] archivoBuscaminasP = Archivos.obtenerArchivosDeUnaCarpeta(Archivos.nombreRutaCarpetaBuscaminasPerdidas);
        txtReportes.setText(leerCarpetas(archivoBuscaminasP));
    }//GEN-LAST:event_btnPartidasPerdidasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHunter;
    private javax.swing.JButton btnInformacion;
    private javax.swing.JButton btnMusica;
    private javax.swing.JButton btnPartidasGanadas;
    private javax.swing.JButton btnPartidasPerdidas;
    private javax.swing.JButton btnSalirDelJuego;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtReportes;
    // End of variables declaration//GEN-END:variables
}
