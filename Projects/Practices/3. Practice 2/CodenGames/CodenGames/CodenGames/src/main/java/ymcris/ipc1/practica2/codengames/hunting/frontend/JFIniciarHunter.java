package ymcris.ipc1.practica2.codengames.hunting.frontend;

import javax.swing.JOptionPane;
import javax.sound.sampled.Clip;
import java.util.InputMismatchException;
import ymcris.ipc1.practica2.codengames.a.frontend.JFMenuPrincipal;
import ymcris.ipc1.practica2.codengames.a.frontend.JPanelPersonalizado;
import ymcris.ipc1.practica2.codengames.hunting.controllers.HunterController;
import static ymcris.ipc1.practica2.codengames.a.frontend.JFMenuPrincipal.musicaMenu;

/**
 * JFIniciarHunter es el frame encargado de pedir los datos requeridos para
 * iniciar el juego de Hunter.
 *
 * @author YmCris
 * @see JFHunter
 * @see JFMenuPrincipal
 */
public class JFIniciarHunter extends javax.swing.JFrame {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    public static HunterController hController = new HunterController();

    // CONSTANTES --------------------------------------------------------------
    private static final String NOMBRE_IMAGEN_FONDO = "/fondoMenuPatos.png";

    // MÉTODO CONSTRUCTOR -----------------------------------------------------
    public JFIniciarHunter() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        JPanelPersonalizado panelDiseñado = new JPanelPersonalizado(pnlMenu, NOMBRE_IMAGEN_FONDO);
        pnlMenu.add(panelDiseñado).repaint();//Añade el panel diseñado al panel
    }

    // CÓDIGO "AUTOGENERADO" ---------------------------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMenu = new javax.swing.JPanel();
        lblTitulo1 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblNombre1 = new javax.swing.JLabel();
        lblNombre2 = new javax.swing.JLabel();
        lblNombre3 = new javax.swing.JLabel();
        lblNombre4 = new javax.swing.JLabel();
        lblNombre5 = new javax.swing.JLabel();
        txtReduccionDeTiempo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtVelocidadInicial = new javax.swing.JTextField();
        txtAciertos = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnInformación = new javax.swing.JButton();
        btnMusica = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nueva Partida Hunter");
        setMaximumSize(new java.awt.Dimension(0, 0));
        setPreferredSize(new java.awt.Dimension(1100, 800));

        pnlMenu.setMaximumSize(new java.awt.Dimension(0, 0));
        pnlMenu.setMinimumSize(new java.awt.Dimension(0, 0));

        lblTitulo1.setBackground(java.awt.SystemColor.activeCaptionText);
        lblTitulo1.setFont(new java.awt.Font("Snap ITC", 1, 100)); // NOI18N
        lblTitulo1.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo1.setText("HUNTER");
        lblTitulo1.setToolTipText("");
        lblTitulo1.setMaximumSize(new java.awt.Dimension(300, 300));
        lblTitulo1.setMinimumSize(new java.awt.Dimension(300, 300));
        lblTitulo1.setName(""); // NOI18N
        lblTitulo1.setPreferredSize(new java.awt.Dimension(300, 300));

        lblNombre.setFont(new java.awt.Font("Ravie", 0, 36)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(51, 102, 0));
        lblNombre.setText("la velocidad de los patos");

        lblNombre1.setFont(new java.awt.Font("Ravie", 0, 36)); // NOI18N
        lblNombre1.setForeground(new java.awt.Color(51, 102, 0));
        lblNombre1.setText("Nombre");

        lblNombre2.setFont(new java.awt.Font("Ravie", 0, 36)); // NOI18N
        lblNombre2.setForeground(new java.awt.Color(51, 102, 0));
        lblNombre2.setText("Velocidad Inicial de los Patos");

        lblNombre3.setFont(new java.awt.Font("Ravie", 0, 36)); // NOI18N
        lblNombre3.setForeground(new java.awt.Color(51, 102, 0));
        lblNombre3.setText("mostrarán los patos");

        lblNombre4.setFont(new java.awt.Font("Ravie", 0, 36)); // NOI18N
        lblNombre4.setForeground(new java.awt.Color(51, 102, 0));
        lblNombre4.setText("Cantidad de aciertos para aumentar");

        lblNombre5.setFont(new java.awt.Font("Ravie", 0, 36)); // NOI18N
        lblNombre5.setForeground(new java.awt.Color(51, 102, 0));
        lblNombre5.setText("Reducción del tiempo en el que se");

        txtReduccionDeTiempo.setBackground(new java.awt.Color(255, 255, 204));
        txtReduccionDeTiempo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtReduccionDeTiempo.setForeground(new java.awt.Color(0, 0, 0));
        txtReduccionDeTiempo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtReduccionDeTiempo.setCaretColor(new java.awt.Color(0, 0, 0));

        txtNombre.setBackground(new java.awt.Color(255, 255, 204));
        txtNombre.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(0, 0, 0));
        txtNombre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtNombre.setCaretColor(new java.awt.Color(0, 0, 0));

        txtVelocidadInicial.setBackground(new java.awt.Color(255, 255, 204));
        txtVelocidadInicial.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtVelocidadInicial.setForeground(new java.awt.Color(0, 0, 0));
        txtVelocidadInicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtVelocidadInicial.setCaretColor(new java.awt.Color(0, 0, 0));
        txtVelocidadInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVelocidadInicialActionPerformed(evt);
            }
        });

        txtAciertos.setBackground(new java.awt.Color(255, 255, 204));
        txtAciertos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtAciertos.setForeground(new java.awt.Color(0, 0, 0));
        txtAciertos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtAciertos.setCaretColor(new java.awt.Color(0, 0, 0));

        btnGuardar.setBackground(new java.awt.Color(51, 51, 51));
        btnGuardar.setFont(new java.awt.Font("Ravie", 0, 36)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("GUARDAR");
        btnGuardar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(51, 51, 51));
        btnSalir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("<-");
        btnSalir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
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

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btnMusica, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnInformación, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre)
                    .addComponent(lblNombre4)
                    .addComponent(lblNombre1)
                    .addComponent(lblNombre2)
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAciertos, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtVelocidadInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre5)
                            .addGroup(pnlMenuLayout.createSequentialGroup()
                                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNombre3)
                                    .addComponent(txtReduccionDeTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 225, Short.MAX_VALUE)
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(62, 62, 62))
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(lblTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnInformación, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMusica, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(lblNombre1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblNombre2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtVelocidadInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNombre4)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAciertos, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblNombre5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNombre3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtReduccionDeTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(82, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65))))
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

    private void txtVelocidadInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVelocidadInicialActionPerformed
    }//GEN-LAST:event_txtVelocidadInicialActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        //1. Verificar que los recuadros no esten vacios
        if (txtNombre.getText().isBlank() || txtVelocidadInicial.getText().isBlank() || txtAciertos.getText().isBlank() || txtReduccionDeTiempo.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los recuadros", "Error", JOptionPane.WARNING_MESSAGE);
        } else {//2. Verificar que ingrese los datos adecuados
            try {
                //3. Verificar si todo está en orden y empezar
                if (hController.todoEnOrden(txtNombre.getText(), Integer.parseInt(txtVelocidadInicial.getText()), Integer.parseInt(txtAciertos.getText()), Integer.parseInt(txtReduccionDeTiempo.getText())) == true) {
                    musicaMenu.stop();
                    this.dispose();
                } else {//4. Si no está en orden se muestra el mensaje por el cual está mal.
                    String mensaje = hController.encontrarErrores(txtNombre.getText(), Integer.parseInt(txtVelocidadInicial.getText()), Integer.parseInt(txtAciertos.getText()), Integer.parseInt(txtReduccionDeTiempo.getText()));
                    JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.WARNING_MESSAGE);
                }
            } catch (NumberFormatException | InputMismatchException e) {
                JOptionPane.showMessageDialog(null, "Debes colocar el tipo de datos adecuados", "ERROR", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        musicaMenu.stop();
        new JFMenuPrincipal().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnInformaciónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInformaciónActionPerformed
        JOptionPane.showMessageDialog(null, "¡Dá el tiempo en milisegundos! Y NO FALLES", "Hunter", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_btnInformaciónActionPerformed

    private void btnMusicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMusicaActionPerformed
        if (musicaMenu.isActive()) {
            musicaMenu.stop();
        } else if (!musicaMenu.isActive()) {
            musicaMenu.stop();
            musicaMenu.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }//GEN-LAST:event_btnMusicaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnInformación;
    private javax.swing.JButton btnMusica;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JLabel lblNombre2;
    private javax.swing.JLabel lblNombre3;
    private javax.swing.JLabel lblNombre4;
    private javax.swing.JLabel lblNombre5;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JTextField txtAciertos;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtReduccionDeTiempo;
    private javax.swing.JTextField txtVelocidadInicial;
    // End of variables declaration//GEN-END:variables
}
