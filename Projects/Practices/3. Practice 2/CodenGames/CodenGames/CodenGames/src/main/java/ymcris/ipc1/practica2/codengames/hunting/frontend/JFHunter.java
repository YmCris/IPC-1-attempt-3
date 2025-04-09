package ymcris.ipc1.practica2.codengames.hunting.frontend;

import java.net.URL;
import javax.swing.Timer;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.sound.sampled.Clip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import ymcris.ipc1.practica2.codengames.a.backend.Threads.PatoThread;
import ymcris.ipc1.practica2.codengames.a.backend.Threads.Tiempo;
import ymcris.ipc1.practica2.codengames.a.frontend.JFMenuPrincipal;
import ymcris.ipc1.practica2.codengames.a.frontend.JPanelPersonalizado;
import static ymcris.ipc1.practica2.codengames.hunting.frontend.JFIniciarHunter.hController;

/**
 * JFHunter es el frame encargado de mostrar todos los componentes del juego
 * hunter.
 *
 * @author YmCris
 */
public class JFHunter extends javax.swing.JFrame {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private Timer contador;
    private Clip musicaPatos;
    private Tiempo threadTiempo;
    private JButton[][] botones;

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private boolean acerto;
    private int botonDondeSeEncuentraElPato;

    // CONSTANTES --------------------------------------------------------------
    public static final int FILAS_TABLERO_PATO = 5;
    public static final int COLUMNAS_TABLERO_PATO = 5;
    public static final String NOMBRE_IMAGEN_PATO = "/patoVolador.png";
    private static final String NOMBRE_MUSICA_PATOS = "/musicaPatos.wav";
    private static final String NOMBRE_IMAGEN_FONDO = "/escenarioPatos.png";

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public JFHunter() {
        //1. Inicializar atributos del frame
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        //2. Agregar fondo al panel de los patos
        JPanelPersonalizado panelPersonalizado = new JPanelPersonalizado(pnlJuego, NOMBRE_IMAGEN_FONDO);
        pnlJuego.add(panelPersonalizado).repaint();
        //4. Iniciar el contador de tiempo del juego
        iniciarContador();
        //4.5 agregar botones al panel 
        agregarBotones();
        //4.5.5 Ocultar botones
        ocultarBotones(botones);
        pnlJuego.setComponentZOrder(panelPersonalizado, pnlJuego.getComponentCount() - 1);
        mostrarPatos();
        try {//5. Poner música
            URL rutaMusica = getClass().getResource(NOMBRE_MUSICA_PATOS);
            if (rutaMusica != null) {
                AudioInputStream audio = AudioSystem.getAudioInputStream(rutaMusica);
                musicaPatos = AudioSystem.getClip();
                musicaPatos.open(audio);
                musicaPatos.stop();
                musicaPatos.loop(Clip.LOOP_CONTINUOUSLY);
            }
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {//No hay musica xddd
        }
    }

    // MÉTODOS CONCRETOS -------------------------------------------------------
    /**
     * Método encargado de iniciar el hilo tiempo e aplicarlo al frame
     */
    private void iniciarContador() {
        threadTiempo = new Tiempo();
        threadTiempo.start();
        contador = new Timer(1000, new ActionListener() {//Para que se actualice con el frame
            @Override
            public void actionPerformed(ActionEvent e) {
                txtTiempoJugado.setText(String.valueOf(threadTiempo.getTiempoTotal()));
            }
        });
        contador.start();
    }

    /**
     * Método encargado de agregar los botones al pnlJuego
     */
    private void agregarBotones() {
        botones = new JButton[FILAS_TABLERO_PATO][COLUMNAS_TABLERO_PATO];
        pnlJuego.setLayout(null);//Para personalizar el panel con el fondo de patos con los botones
        for (int i = 0; i < botones.length; i++) {
            for (int j = 0; j < botones[0].length; j++) {
                botones[i][j] = new JButton();
                int x = 100 + j * 150;
                int y = 100 + i * 100;
                botones[i][j].setBounds(x, y, 120, 80);//Posiciona todos los botones para ponerlos en el panel
                botones[i][j].setBorderPainted(false);
                int fila = i;
                int columna = j;
                botones[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evento) {
                        //1. Mostrar el pato de forma aleatoria (Realizado en el thread)
                        //2. Capturar el teclazo (Realizado en este action lister)
                        //3. Verificar si el boton tiene pato (botonConPato())
                        botonConPato(botones[fila][columna]);
                        //4. Comunicarle al backende si es un acierto o no
                    }
                });
                pnlJuego.add(botones[i][j]);
            }
        }
        pnlJuego.revalidate();
        pnlJuego.repaint();
    }

    private boolean botonConPato(JButton btn) {
        if (btn.getIcon() != null && btn.getIcon().getIconHeight() == 167&& btn.getIcon().getIconWidth() == 190 ) {
            System.out.println("Yo tengo al pato!");
            return true;
        } else {
            System.out.println("Yo no tengo ningun pato");
            return false;
        }
    }

    private void mostrarPatos() {
        int velocidadInicial = hController.getHunter().getPato().getVelocidad();
        int cantidadDeAciertos = hController.getHunter().getAciertosParaAumentarVelocidad();
        int reduccionDeTiempo = hController.getHunter().getReduccionDeTiempo();
        Thread patoThread = new PatoThread(pnlJuego, botones, velocidadInicial, reduccionDeTiempo, cantidadDeAciertos);
        patoThread.start();
    }

    private void ocultarBotones(JButton[][] btns) {
        for (JButton[] btn : btns) {
            for (int j = 0; j < btns[0].length; j++) {
                btn[j].setOpaque(false);
                btn[j].setContentAreaFilled(false);
            }
        }
    }

    // CÓDIGO "AUTOGENERADO" ---------------------------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlOpciones = new javax.swing.JPanel();
        btnMusica = new javax.swing.JButton();
        btnInformacion = new javax.swing.JButton();
        btnSalirDelJuego = new javax.swing.JButton();
        btnRegresarAlMenu = new javax.swing.JButton();
        lblNombreJugador = new javax.swing.JLabel();
        pnlJuego = new javax.swing.JPanel();
        pnlInformacion = new javax.swing.JPanel();
        lblTiempoJugado = new javax.swing.JLabel();
        txtTiempoJugado = new javax.swing.JTextField();
        lblTiempoJugado1 = new javax.swing.JLabel();
        txtTiempoJugado1 = new javax.swing.JTextField();
        txtTiempoJugado2 = new javax.swing.JTextField();
        lblTiempoJugado2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hunter");
        setBackground(new java.awt.Color(0, 0, 0));

        pnlOpciones.setBackground(new java.awt.Color(102, 102, 0));

        btnMusica.setBackground(new java.awt.Color(51, 51, 51));
        btnMusica.setForeground(new java.awt.Color(255, 255, 255));
        btnMusica.setText("M");
        btnMusica.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnMusica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMusicaActionPerformed(evt);
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

        btnSalirDelJuego.setBackground(new java.awt.Color(51, 51, 51));
        btnSalirDelJuego.setForeground(new java.awt.Color(255, 255, 255));
        btnSalirDelJuego.setText("X");
        btnSalirDelJuego.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSalirDelJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirDelJuegoActionPerformed(evt);
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

        lblNombreJugador.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNombreJugador.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreJugador.setText("PARTIDA DE:");

        javax.swing.GroupLayout pnlOpcionesLayout = new javax.swing.GroupLayout(pnlOpciones);
        pnlOpciones.setLayout(pnlOpcionesLayout);
        pnlOpcionesLayout.setHorizontalGroup(
            pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegresarAlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(lblNombreJugador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMusica, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnInformacion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalirDelJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlOpcionesLayout.setVerticalGroup(
            pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlOpcionesLayout.createSequentialGroup()
                        .addGroup(pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnMusica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSalirDelJuego, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnInformacion))
                        .addGap(34, 34, 34))
                    .addGroup(pnlOpcionesLayout.createSequentialGroup()
                        .addComponent(btnRegresarAlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(pnlOpcionesLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblNombreJugador)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlJuego.setMaximumSize(new java.awt.Dimension(0, 0));

        javax.swing.GroupLayout pnlJuegoLayout = new javax.swing.GroupLayout(pnlJuego);
        pnlJuego.setLayout(pnlJuegoLayout);
        pnlJuegoLayout.setHorizontalGroup(
            pnlJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1100, Short.MAX_VALUE)
        );
        pnlJuegoLayout.setVerticalGroup(
            pnlJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 665, Short.MAX_VALUE)
        );

        pnlInformacion.setBackground(new java.awt.Color(51, 51, 0));

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

        lblTiempoJugado1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTiempoJugado1.setForeground(new java.awt.Color(255, 255, 255));
        lblTiempoJugado1.setText("PATOS CAZADOS:");

        txtTiempoJugado1.setEditable(false);
        txtTiempoJugado1.setBackground(new java.awt.Color(51, 51, 51));
        txtTiempoJugado1.setForeground(new java.awt.Color(255, 255, 255));
        txtTiempoJugado1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtTiempoJugado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTiempoJugado1ActionPerformed(evt);
            }
        });

        txtTiempoJugado2.setEditable(false);
        txtTiempoJugado2.setBackground(new java.awt.Color(51, 51, 51));
        txtTiempoJugado2.setForeground(new java.awt.Color(255, 255, 255));
        txtTiempoJugado2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtTiempoJugado2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTiempoJugado2ActionPerformed(evt);
            }
        });

        lblTiempoJugado2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTiempoJugado2.setForeground(new java.awt.Color(255, 255, 255));
        lblTiempoJugado2.setText("DISPAROS CONSECUTIVOS FALLADOS");

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
                .addComponent(lblTiempoJugado1)
                .addGap(18, 18, 18)
                .addComponent(txtTiempoJugado1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTiempoJugado2)
                .addGap(18, 18, 18)
                .addComponent(txtTiempoJugado2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
        );
        pnlInformacionLayout.setVerticalGroup(
            pnlInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInformacionLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnlInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTiempoJugado2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTiempoJugado2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTiempoJugado1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTiempoJugado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTiempoJugado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTiempoJugado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlInformacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlOpciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlJuego, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlJuego, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlInformacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMusicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMusicaActionPerformed
        if (musicaPatos.isActive()) {
            musicaPatos.stop();
        } else if (!musicaPatos.isActive()) {
            musicaPatos.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }//GEN-LAST:event_btnMusicaActionPerformed

    private void btnInformacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInformacionActionPerformed
        JOptionPane.showMessageDialog(null, "¡CAPTURALOS A TODOS!", "PATOOS", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_btnInformacionActionPerformed

    private void btnSalirDelJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirDelJuegoActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirDelJuegoActionPerformed

    private void btnRegresarAlMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarAlMenuActionPerformed
        musicaPatos.stop();
        threadTiempo.detenerTimer();
        this.dispose();
        new JFMenuPrincipal().setVisible(true);
    }//GEN-LAST:event_btnRegresarAlMenuActionPerformed

    private void txtTiempoJugadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTiempoJugadoActionPerformed
    }//GEN-LAST:event_txtTiempoJugadoActionPerformed

    private void txtTiempoJugado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTiempoJugado1ActionPerformed
    }//GEN-LAST:event_txtTiempoJugado1ActionPerformed

    private void txtTiempoJugado2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTiempoJugado2ActionPerformed
    }//GEN-LAST:event_txtTiempoJugado2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInformacion;
    private javax.swing.JButton btnMusica;
    private javax.swing.JButton btnRegresarAlMenu;
    private javax.swing.JButton btnSalirDelJuego;
    private javax.swing.JLabel lblNombreJugador;
    private javax.swing.JLabel lblTiempoJugado;
    private javax.swing.JLabel lblTiempoJugado1;
    private javax.swing.JLabel lblTiempoJugado2;
    private javax.swing.JPanel pnlInformacion;
    private javax.swing.JPanel pnlJuego;
    private javax.swing.JPanel pnlOpciones;
    private javax.swing.JTextField txtTiempoJugado;
    private javax.swing.JTextField txtTiempoJugado1;
    private javax.swing.JTextField txtTiempoJugado2;
    // End of variables declaration//GEN-END:variables

}
