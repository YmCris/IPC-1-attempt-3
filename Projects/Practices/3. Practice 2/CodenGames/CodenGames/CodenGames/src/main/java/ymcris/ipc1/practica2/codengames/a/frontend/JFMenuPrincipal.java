/*
 * Paquete encargado de contener las clases que se visualizarán en todo el proceso de estadía en el juego (es decir menús, pero no juegos ni reportes)
 */
package ymcris.ipc1.practica2.codengames.a.frontend;

import java.net.URL;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import ymcris.ipc1.practica2.codengames.hunting.frontend.JFIniciarHunter;
import ymcris.ipc1.practica2.codengames.buscaminas.frontend.JFIniciarNuevaPartidaBuscaminas;
import static ymcris.ipc1.practica2.codengames.buscaminas.backend.Buscaminas.contadorDeMinasMarcadas;
import static ymcris.ipc1.practica2.codengames.buscaminas.backend.Buscaminas.partidaGanadaBuscaminas;
import static ymcris.ipc1.practica2.codengames.buscaminas.backend.Buscaminas.partidaTerminadaBuscaminas;

/**
 * Clase JFMenuPrincipal es el frame que muestra todo el menú principal
 *
 * @author YmCris
 * @since Apr 4, 2025
 */
public class JFMenuPrincipal extends javax.swing.JFrame {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    public static Clip musicaMenu;
    private static final String RUTA_IMAGEN_MENU = "/fondoOficial.png";
    private static final String NOMBRE_CANCION_MENU = "/sonidoMenu.wav";

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    /**
     * Método constructor encargado de inicializar los componentes importantes
     * del jFrame ademas de ponerle musiquita.
     */
    public JFMenuPrincipal() {
        //1. Inicializar todos los elementos importantes del JFrame
        initComponents();
        partidaTerminadaBuscaminas = false;
        partidaGanadaBuscaminas = false;
        contadorDeMinasMarcadas = 0;
        //2. Modificar atributos del frame para que sea más chido
        this.setResizable(false);//Para que no se deforme todo
        this.setLocationRelativeTo(null);//Lo centra
        //3. Ponerle un fondo chingon al panel.
        JPanelPersonalizado panelDiseñado = new JPanelPersonalizado(pnlMenu, RUTA_IMAGEN_MENU);
        pnlMenu.add(panelDiseñado).repaint();//Añade el panel diseñado al pnlMenu
        //4. Poner musica
        try {
            URL rutaMusica = getClass().getResource(NOMBRE_CANCION_MENU);
            if (rutaMusica == null) {
                System.out.println("No se encontró el archivo, ya valiste");
            } else {
                AudioInputStream audio = AudioSystem.getAudioInputStream(rutaMusica);
                musicaMenu = AudioSystem.getClip();
                musicaMenu.open(audio);
                musicaMenu.stop();
                musicaMenu.loop(Clip.LOOP_CONTINUOUSLY);
            }
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {//No funciono poner música
        }
    }

    // MÉTODOS CONCRETOS -------------------------------------------------------
    /**
     * Método autogenerado por netbeans encargado de inicializar todo lo del
     * editor de frontend.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMenu = new javax.swing.JPanel();
        lblTitulo2 = new javax.swing.JLabel();
        lblTitulo1 = new javax.swing.JLabel();
        btnHunter = new javax.swing.JButton();
        btnBuscaminas = new javax.swing.JButton();
        btnReportes = new javax.swing.JButton();
        btnInformación = new javax.swing.JButton();
        btnMusica = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Code'n Games");
        setBackground(new java.awt.Color(0, 0, 0));
        setName("JMenuPrincipal"); // NOI18N

        pnlMenu.setMaximumSize(new java.awt.Dimension(0, 0));
        pnlMenu.setMinimumSize(new java.awt.Dimension(0, 0));
        pnlMenu.setPreferredSize(new java.awt.Dimension(1100, 800));

        lblTitulo2.setBackground(java.awt.SystemColor.activeCaptionText);
        lblTitulo2.setFont(new java.awt.Font("Snap ITC", 1, 100)); // NOI18N
        lblTitulo2.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo2.setText("GAMES");
        lblTitulo2.setToolTipText("");
        lblTitulo2.setMaximumSize(new java.awt.Dimension(300, 300));
        lblTitulo2.setMinimumSize(new java.awt.Dimension(300, 300));
        lblTitulo2.setName(""); // NOI18N
        lblTitulo2.setPreferredSize(new java.awt.Dimension(300, 300));

        lblTitulo1.setBackground(java.awt.SystemColor.activeCaptionText);
        lblTitulo1.setFont(new java.awt.Font("Snap ITC", 1, 100)); // NOI18N
        lblTitulo1.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo1.setText("CODE'N");
        lblTitulo1.setToolTipText("");
        lblTitulo1.setMaximumSize(new java.awt.Dimension(300, 300));
        lblTitulo1.setMinimumSize(new java.awt.Dimension(300, 300));
        lblTitulo1.setName(""); // NOI18N
        lblTitulo1.setPreferredSize(new java.awt.Dimension(300, 300));

        btnHunter.setBackground(new java.awt.Color(51, 51, 51));
        btnHunter.setFont(new java.awt.Font("Ravie", 0, 36)); // NOI18N
        btnHunter.setForeground(new java.awt.Color(255, 255, 255));
        btnHunter.setText("DUCK HUNTER");
        btnHunter.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnHunter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHunterActionPerformed(evt);
            }
        });

        btnBuscaminas.setBackground(new java.awt.Color(51, 51, 51));
        btnBuscaminas.setFont(new java.awt.Font("Ravie", 0, 36)); // NOI18N
        btnBuscaminas.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscaminas.setText("BUSCAMINAS");
        btnBuscaminas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBuscaminas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaminasActionPerformed(evt);
            }
        });

        btnReportes.setBackground(new java.awt.Color(51, 51, 51));
        btnReportes.setFont(new java.awt.Font("Ravie", 0, 36)); // NOI18N
        btnReportes.setForeground(new java.awt.Color(255, 255, 255));
        btnReportes.setText("REPORTES");
        btnReportes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportesActionPerformed(evt);
            }
        });

        btnInformación.setBackground(new java.awt.Color(51, 51, 51));
        btnInformación.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnInformación.setForeground(new java.awt.Color(255, 255, 255));
        btnInformación.setText("!");
        btnInformación.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnInformación.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInformaciónActionPerformed(evt);
            }
        });

        btnMusica.setBackground(new java.awt.Color(51, 51, 51));
        btnMusica.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMusica.setForeground(new java.awt.Color(255, 255, 255));
        btnMusica.setText("M");
        btnMusica.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnMusica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMusicaActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(51, 51, 51));
        btnSalir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("X");
        btnSalir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblTitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(531, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnBuscaminas, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnHunter, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addComponent(btnMusica, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnInformación, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)))
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
            .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlMenuLayout.createSequentialGroup()
                    .addGap(31, 31, 31)
                    .addComponent(lblTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(519, Short.MAX_VALUE)))
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInformación, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMusica, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(151, 151, 151)
                .addComponent(lblTitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                .addComponent(btnBuscaminas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHunter, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
            .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlMenuLayout.createSequentialGroup()
                    .addGap(117, 117, 117)
                    .addComponent(lblTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(593, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHunterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHunterActionPerformed
        musicaMenu.stop();
        new JFIniciarHunter().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnHunterActionPerformed

    /**
     * Método encargado de iniciar el frame para pedir los datos necesarios del
     * buscaminas
     *
     * @param evt evento
     */
    private void btnBuscaminasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaminasActionPerformed
        musicaMenu.stop();
        JFIniciarNuevaPartidaBuscaminas buscaminas = new JFIniciarNuevaPartidaBuscaminas();
        buscaminas.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBuscaminasActionPerformed

    private void btnReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportesActionPerformed
    }//GEN-LAST:event_btnReportesActionPerformed

    private void btnMusicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMusicaActionPerformed
        if (musicaMenu.isActive()) {
            musicaMenu.stop();
        } else if (!musicaMenu.isActive()) {
            musicaMenu.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }//GEN-LAST:event_btnMusicaActionPerformed

    private void btnInformaciónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInformaciónActionPerformed
        JOptionPane.showMessageDialog(null, "¡Code'n Games ahora gráfico!", "Code'n Games 2", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnInformaciónActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscaminas;
    private javax.swing.JButton btnHunter;
    private javax.swing.JButton btnInformación;
    private javax.swing.JButton btnMusica;
    private javax.swing.JButton btnReportes;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblTitulo2;
    private javax.swing.JPanel pnlMenu;
    // End of variables declaration//GEN-END:variables
}
