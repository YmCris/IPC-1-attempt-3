package ymcris.ipc1.practica2.codengames.buscaminas.frontend;

import java.net.URL;
import java.awt.Color;
import java.awt.GridLayout;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.JToggleButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.BevelBorder;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Timer;
import ymcris.ipc1.practica2.codengames.a.backend.Threads.Tiempo;
import ymcris.ipc1.practica2.codengames.a.frontend.JFMenuPrincipal;
import static ymcris.ipc1.practica2.codengames.buscaminas.backend.Buscaminas.contadorDeMinasMarcadas;
import static ymcris.ipc1.practica2.codengames.buscaminas.backend.Buscaminas.partidaGanadaBuscaminas;
import ymcris.ipc1.practica2.codengames.buscaminas.controllers.BuscaminasController;
import static ymcris.ipc1.practica2.codengames.buscaminas.frontend.JFIniciarNuevaPartidaBuscaminas.jBuscaminas;
import static ymcris.ipc1.practica2.codengames.buscaminas.backend.Buscaminas.partidaTerminadaBuscaminas;

/**
 * JBuscaminas Frame es el frame encargado de mostrar todo el juego de
 * buscaminas y de comunicarle lo sucedido a buscaminas controller.
 *
 * @author YmCris
 * @see BuscaminasController
 */
public class JFBuscaminas extends javax.swing.JFrame {

    // CONSTANTES --------------------------------------------------------------
    private static final String NOMBRE_MUSICA_BUSCAMINAS = "/misterioMinas.wav";

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private String avatar;
    private Clip musicaBuscaminas;
    private JToggleButton[][] botones;
    private Tiempo threadTiempo;

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private int filasTablero;
    private int columnasTablero;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public JFBuscaminas() {
        initComponents();
        this.avatar = jBuscaminas.getAvatar();
        lblNombreJugador.setText("PARTIDA DE " + avatar.toUpperCase());
        this.filasTablero = jBuscaminas.getFilasTablero();
        this.columnasTablero = jBuscaminas.getColumnasTablero();
        jBuscaminas.setOpcionJuego(2);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        agregarBotonesAPanel();
        iniciarContador();
        try {
            URL rutaMusicaBuscaminas = getClass().getResource(JFBuscaminas.NOMBRE_MUSICA_BUSCAMINAS);
            if (rutaMusicaBuscaminas == null) {
                System.out.println("Perdiste");
            } else {
                AudioInputStream audio = AudioSystem.getAudioInputStream(rutaMusicaBuscaminas);
                musicaBuscaminas = AudioSystem.getClip();
                musicaBuscaminas.open(audio);
                musicaBuscaminas.stop();
                musicaBuscaminas.loop(Clip.LOOP_CONTINUOUSLY);
            }
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
        }
        btnDescubrirCasillas.setSelected(true);
        btnMarcarMinas.setEnabled(false);
    }

    // MÉTODOS CONCRETOS -------------------------------------------------------
    private void iniciarContador() {
        threadTiempo = new Tiempo();
        threadTiempo.start();
        Timer contador = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                txtTiempoJugado.setText(String.valueOf(threadTiempo.getTiempoTotal()));
            }
        });
        contador.start();
    }

    private void agregarBotonesAPanel() {
        botones = new JToggleButton[filasTablero][columnasTablero];
        pnlTablero.setLayout(new GridLayout(filasTablero, columnasTablero));
        for (int i = 0; i < botones.length; i++) {
            for (int j = 0; j < botones[0].length; j++) {
                botones[i][j] = new JToggleButton();
                botones[i][j].setBackground(new Color(230, 230, 230));
                botones[i][j].setForeground(Color.BLACK);
                botones[i][j].setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
                final int fila = i;
                final int columna = j;
                botones[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evento) {
                        if (jBuscaminas.getOpcionJuego() == 1) {//Marcar casilla
                            marcarBotones(fila, columna);
                        } else {//Descubrir casillas
                            descubrirBotones(fila, columna);
                        }
                    }
                });
                pnlTablero.add(botones[i][j]);
            }
        }
        pnlTablero.revalidate();
        pnlTablero.repaint();
    }

    private void marcarBotones(int fila, int columna) {
        if (botones[fila][columna].isSelected()) {//Marca una casilla
            botones[fila][columna].setText("🚩");
            jBuscaminas.recibirDatosCasillas(fila, columna);
            contadorDeMinasMarcadas++;
        } else {//Desmarcar una casilla
            botones[fila][columna].setText("");
            contadorDeMinasMarcadas = contadorDeMinasMarcadas - 1;
        }
        if (partidaGanadaBuscaminas) {//Partida Ganada
            contadorDeMinasMarcadas++;
            threadTiempo.detenerTimer();
            threadTiempo.interrupt();
            jugadorGanador();
        } else {
            jBuscaminas.jugar();
        }
        txtMinasMarcadas.setText(String.valueOf(contadorDeMinasMarcadas));
    }

    private void descubrirBotones(int fila, int columna) {
        if (botones[fila][columna].getText().equals("🚩")) {//Verifica que no se pueda desmarcar una casilla mina
            botones[fila][columna].setSelected(true);
        }
        if (!botones[fila][columna].getText().equals("🚩")) {//descrubre una casilla si es que no es una casilla mina
            jBuscaminas.recibirDatosCasillas(fila, columna);
            botones[fila][columna].setText(jBuscaminas.cantidadDeMinasAdyacentes());
            if (partidaGanadaBuscaminas) {
                threadTiempo.detenerTimer();
                threadTiempo.interrupt();
                jugadorGanador();
            }
            if (!partidaTerminadaBuscaminas) {
                jBuscaminas.jugar();
                if (partidaTerminadaBuscaminas) {
                    threadTiempo.detenerTimer();
                    threadTiempo.interrupt();
                    JOptionPane.showMessageDialog(null, "HAS ENCONTRADO UNA MINA, HAS PERDIDO", "Buscaminas terminado", JOptionPane.ERROR_MESSAGE);
                    eliminarFrame();
                }
            }
            botones[fila][columna].setEnabled(false);
        }
    }

    private void eliminarFrame() {
        musicaBuscaminas.stop();
        this.dispose();
        new JFMenuPrincipal().setVisible(true);
    }

    private void jugadorGanador() {
        JOptionPane.showMessageDialog(null, "FELICIDADES HAS GANADO", "Buscaminas terminado", JOptionPane.ERROR_MESSAGE);
        eliminarFrame();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBotones = new javax.swing.JPanel();
        btnMusica = new javax.swing.JButton();
        btnRegresarAlMenu = new javax.swing.JButton();
        btnSalirDelJuego = new javax.swing.JButton();
        btnInformacion = new javax.swing.JButton();
        lblNombreJugador = new javax.swing.JLabel();
        btnDescubrirCasillas = new javax.swing.JToggleButton();
        btnMarcarMinas = new javax.swing.JToggleButton();
        pnlTablero = new javax.swing.JPanel();
        pnlInformacion = new javax.swing.JPanel();
        lblTiempoJugado = new javax.swing.JLabel();
        txtTiempoJugado = new javax.swing.JTextField();
        lblMinasMarcadas = new javax.swing.JLabel();
        txtMinasMarcadas = new javax.swing.JTextField();
        txtMinasRestantes = new javax.swing.JTextField();
        lblMinasRestantes = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Buscaminas");
        setBackground(new java.awt.Color(51, 51, 51));

        pnlBotones.setBackground(new java.awt.Color(102, 102, 102));

        btnMusica.setBackground(new java.awt.Color(51, 51, 51));
        btnMusica.setForeground(new java.awt.Color(255, 255, 255));
        btnMusica.setText("M");
        btnMusica.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnMusica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMusicaActionPerformed(evt);
            }
        });

        btnRegresarAlMenu.setBackground(new java.awt.Color(51, 51, 51));
        btnRegresarAlMenu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRegresarAlMenu.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresarAlMenu.setText("Regresar al Menú");
        btnRegresarAlMenu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRegresarAlMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarAlMenuActionPerformed(evt);
            }
        });

        btnSalirDelJuego.setBackground(new java.awt.Color(51, 51, 51));
        btnSalirDelJuego.setForeground(new java.awt.Color(255, 255, 255));
        btnSalirDelJuego.setText("X");
        btnSalirDelJuego.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSalirDelJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirDelJuegoActionPerformed(evt);
            }
        });

        btnInformacion.setBackground(new java.awt.Color(51, 51, 51));
        btnInformacion.setForeground(new java.awt.Color(255, 255, 255));
        btnInformacion.setText("!");
        btnInformacion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnInformacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInformacionActionPerformed(evt);
            }
        });

        lblNombreJugador.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNombreJugador.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreJugador.setText("PARTIDA DE:");

        btnDescubrirCasillas.setBackground(new java.awt.Color(51, 51, 51));
        btnDescubrirCasillas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDescubrirCasillas.setForeground(new java.awt.Color(255, 255, 255));
        btnDescubrirCasillas.setText("Descubrir Casillas");
        btnDescubrirCasillas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDescubrirCasillas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescubrirCasillasActionPerformed(evt);
            }
        });

        btnMarcarMinas.setBackground(new java.awt.Color(51, 51, 51));
        btnMarcarMinas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnMarcarMinas.setForeground(new java.awt.Color(255, 255, 255));
        btnMarcarMinas.setText("Marcar Minas");
        btnMarcarMinas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnMarcarMinas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMarcarMinasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBotonesLayout = new javax.swing.GroupLayout(pnlBotones);
        pnlBotones.setLayout(pnlBotonesLayout);
        pnlBotonesLayout.setHorizontalGroup(
            pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBotonesLayout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addComponent(btnDescubrirCasillas, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnRegresarAlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblNombreJugador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMusica, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnInformacion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalirDelJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlBotonesLayout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addComponent(btnMarcarMinas, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(927, Short.MAX_VALUE)))
        );
        pnlBotonesLayout.setVerticalGroup(
            pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnMusica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalirDelJuego, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnInformacion))
                    .addGroup(pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnRegresarAlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                        .addComponent(lblNombreJugador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnDescubrirCasillas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlBotonesLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btnMarcarMinas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pnlTablero.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout pnlTableroLayout = new javax.swing.GroupLayout(pnlTablero);
        pnlTablero.setLayout(pnlTableroLayout);
        pnlTableroLayout.setHorizontalGroup(
            pnlTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1100, Short.MAX_VALUE)
        );
        pnlTableroLayout.setVerticalGroup(
            pnlTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 684, Short.MAX_VALUE)
        );

        pnlInformacion.setBackground(new java.awt.Color(102, 102, 102));

        lblTiempoJugado.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTiempoJugado.setForeground(new java.awt.Color(255, 255, 255));
        lblTiempoJugado.setText("TIEMPO JUGADO:");

        txtTiempoJugado.setEditable(false);
        txtTiempoJugado.setBackground(new java.awt.Color(51, 51, 51));
        txtTiempoJugado.setForeground(new java.awt.Color(255, 255, 255));
        txtTiempoJugado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtTiempoJugado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTiempoJugadoActionPerformed(evt);
            }
        });

        lblMinasMarcadas.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblMinasMarcadas.setForeground(new java.awt.Color(255, 255, 255));
        lblMinasMarcadas.setText("MINAS MARCADAS:");

        txtMinasMarcadas.setEditable(false);
        txtMinasMarcadas.setBackground(new java.awt.Color(51, 51, 51));
        txtMinasMarcadas.setForeground(new java.awt.Color(255, 255, 255));
        txtMinasMarcadas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtMinasMarcadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMinasMarcadasActionPerformed(evt);
            }
        });

        txtMinasRestantes.setEditable(false);
        txtMinasRestantes.setBackground(new java.awt.Color(51, 51, 51));
        txtMinasRestantes.setForeground(new java.awt.Color(255, 255, 255));
        txtMinasRestantes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblMinasRestantes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblMinasRestantes.setForeground(new java.awt.Color(255, 255, 255));
        lblMinasRestantes.setText("MINAS RESTANTES");

        javax.swing.GroupLayout pnlInformacionLayout = new javax.swing.GroupLayout(pnlInformacion);
        pnlInformacion.setLayout(pnlInformacionLayout);
        pnlInformacionLayout.setHorizontalGroup(
            pnlInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInformacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTiempoJugado)
                .addGap(18, 18, 18)
                .addComponent(txtTiempoJugado, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblMinasMarcadas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMinasMarcadas, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(lblMinasRestantes)
                .addGap(18, 18, 18)
                .addComponent(txtMinasRestantes, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(228, Short.MAX_VALUE))
        );
        pnlInformacionLayout.setVerticalGroup(
            pnlInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInformacionLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTiempoJugado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTiempoJugado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMinasMarcadas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtMinasMarcadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMinasRestantes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtMinasRestantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlTablero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlInformacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlTablero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlInformacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMusicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMusicaActionPerformed
        if (musicaBuscaminas.isActive()) {
            musicaBuscaminas.stop();
        } else if (!musicaBuscaminas.isActive()) {
            musicaBuscaminas.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }//GEN-LAST:event_btnMusicaActionPerformed

    private void btnRegresarAlMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarAlMenuActionPerformed
        musicaBuscaminas.stop();
        threadTiempo.detenerTimer();
        this.dispose();
        new JFMenuPrincipal().setVisible(true);
    }//GEN-LAST:event_btnRegresarAlMenuActionPerformed

    private void btnSalirDelJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirDelJuegoActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirDelJuegoActionPerformed

    private void btnInformacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInformacionActionPerformed
        JOptionPane.showMessageDialog(null, "¡CUIDADO! ESTO ES MUY PELIGROSO", "Ayuda", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_btnInformacionActionPerformed

    private void txtMinasMarcadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMinasMarcadasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMinasMarcadasActionPerformed

    private void txtTiempoJugadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTiempoJugadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTiempoJugadoActionPerformed

    private void btnMarcarMinasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMarcarMinasActionPerformed
        if (btnMarcarMinas.isSelected()) {
            jBuscaminas.setOpcionJuego(1);
            btnDescubrirCasillas.setEnabled(false);
        } else if (!btnMarcarMinas.isSelected()) {
            //Marcar el otro boton como abilitado y seleccionado
            btnDescubrirCasillas.setEnabled(true);
            btnDescubrirCasillas.setSelected(true);
            jBuscaminas.setOpcionJuego(2);
            //Desseleccionar este y deshabilitarlo
            btnMarcarMinas.setEnabled(false);
            btnMarcarMinas.setSelected(false);
        }
    }//GEN-LAST:event_btnMarcarMinasActionPerformed

    private void btnDescubrirCasillasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescubrirCasillasActionPerformed
        if (btnDescubrirCasillas.isSelected()) {
            jBuscaminas.setOpcionJuego(2);
            btnMarcarMinas.setEnabled(false);
        } else if (!btnDescubrirCasillas.isSelected()) {
            //Marcar el otro boton como abilitado y seleccionado
            btnMarcarMinas.setEnabled(true);
            btnMarcarMinas.setSelected(true);
            jBuscaminas.setOpcionJuego(1);
            //Desseleccionar este y deshabilitarlo
            btnDescubrirCasillas.setEnabled(false);
            btnDescubrirCasillas.setSelected(false);
        }
    }//GEN-LAST:event_btnDescubrirCasillasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnDescubrirCasillas;
    private javax.swing.JButton btnInformacion;
    private javax.swing.JToggleButton btnMarcarMinas;
    private javax.swing.JButton btnMusica;
    private javax.swing.JButton btnRegresarAlMenu;
    private javax.swing.JButton btnSalirDelJuego;
    private javax.swing.JLabel lblMinasMarcadas;
    private javax.swing.JLabel lblMinasRestantes;
    private javax.swing.JLabel lblNombreJugador;
    private javax.swing.JLabel lblTiempoJugado;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlInformacion;
    private javax.swing.JPanel pnlTablero;
    private javax.swing.JTextField txtMinasMarcadas;
    private javax.swing.JTextField txtMinasRestantes;
    private javax.swing.JTextField txtTiempoJugado;
    // End of variables declaration//GEN-END:variables

}
