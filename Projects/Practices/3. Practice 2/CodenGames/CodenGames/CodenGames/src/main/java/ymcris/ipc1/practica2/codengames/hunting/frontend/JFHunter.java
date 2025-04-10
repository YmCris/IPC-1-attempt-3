package ymcris.ipc1.practica2.codengames.hunting.frontend;

import java.net.URL;
import javax.swing.Timer;
import javax.swing.JButton;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.sound.sampled.Clip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import ymcris.ipc1.practica2.codengames.a.frontend.JFMenuPrincipal;
import ymcris.ipc1.practica2.codengames.a.backend.Threads.PatoThread;
import ymcris.ipc1.practica2.codengames.a.backend.Threads.TiempoThread;
import ymcris.ipc1.practica2.codengames.a.frontend.JPanelPersonalizado;
import static ymcris.ipc1.practica2.codengames.hunting.backend.Hunter.ACIERTOS_PARA_PERDER;
import static ymcris.ipc1.practica2.codengames.hunting.frontend.JFIniciarHunter.hController;

/**
 * JFHunter es el frame encargado de mostrar todos los componentes del juego
 * hunter.
 *
 * @author YmCris
 * @see PatoThread
 * @see TiempoThread
 * @see JFIniciarHunter
 * @since Apr 8, 2025
 */
public class JFHunter extends javax.swing.JFrame {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private Timer contador;
    private Clip musicaPatos;
    private Thread patoThread;
    private JButton[][] botones;
    private TiempoThread threadTiempo;

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
        //5. Agregar botones al panel 
        agregarBotones();
        //6. Ocultar botones
        ocultarBotones(botones);
        pnlJuego.setComponentZOrder(panelPersonalizado, pnlJuego.getComponentCount() - 1);
        mostrarPatos();
        lblNombreJugador.setText("PARTIDA DE: " + hController.getHunter().getJugador().getNombre().toUpperCase());
        try {//7. Poner música
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
     * Método encargado de iniciar el hilo tiempo y aplicarlo al frame
     */
    private void iniciarContador() {
        threadTiempo = new TiempoThread();
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
                        //3. Verificar si el boton tiene pato (botonConPato()) y aplica las consecuencias
                        botonConPato(botones[fila][columna]);
                        //4. Verificar si se ha terminado la partida
                        if (hController.getHunter().getDisparosFallidos() >= ACIERTOS_PARA_PERDER) {
                            terminarPartida();
                            JOptionPane.showMessageDialog(null, "Has terminado la partida");
                            System.out.println("Se guarda el registro");
                            cerrarVentana();
                        }
                    }
                });
                pnlJuego.add(botones[i][j]);
            }
        }
        pnlJuego.revalidate();
        pnlJuego.repaint();
    }

    /**
     * Método encargado de verificar si se ha acertado al clickear.
     *
     * @param boton - boton a evaluar si tiene patoIcon
     */
    private void botonConPato(JButton boton) {
        if (boton.getIcon() != null && boton.getIcon().getIconHeight() == 167 && boton.getIcon().getIconWidth() == 190) {//Le ha disparado a un pato
            System.out.println("Has acertado");
            hController.getHunter().setAcertó(true);
            txtPatosCazados.setText(String.valueOf(hController.getHunter().getJugador().getPuntaje()));
            hController.getHunter().setDisparosFallidos(0);//Se reinicia el contador de fallos
            txtFallos.setText(String.valueOf(hController.getHunter().getDisparosFallidos()));
            hController.jugar();
        } else {//Ha fallado
            System.out.println("Tiro no acertado");
            hController.getHunter().setAcertó(false);
            hController.getHunter().setDisparosFallidos(hController.getHunter().getDisparosFallidos() + 1);
            txtFallos.setText(String.valueOf(hController.getHunter().getDisparosFallidos()));
        }
    }

    /**
     * Método encargado de cerrar la ventana correctamente (Problemas al perder
     * una partida this.dispose())
     */
    private void cerrarVentana() {
        new JFMenuPrincipal().setVisible(true);
        this.dispose();
    }

    /**
     * Método encargado de terminar la partida terminando los hilos y parando la
     * música
     */
    private void terminarPartida() {
        try {
            musicaPatos.stop();
            threadTiempo.detenerTimer();
            threadTiempo.interrupt();
            patoThread.interrupt();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    /**
     * Método encargado de iniciar el hilo de los patos
     */
    private void mostrarPatos() {
        int velocidadInicial = hController.getHunter().getPato().getVelocidad();
        int reduccionDeTiempo = hController.getHunter().getReduccionDeTiempo();
        patoThread = new PatoThread(botones, velocidadInicial, reduccionDeTiempo);
        patoThread.start();
    }

    /**
     * Método encargado de ocultar (Transparentar) los botones
     * @param arregloBotones 
     */
    private void ocultarBotones(JButton[][] arregloBotones) {
        for (JButton[] btn : arregloBotones) {
            for (int j = 0; j < arregloBotones[0].length; j++) {
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
        txtPatosCazados = new javax.swing.JTextField();
        txtFallos = new javax.swing.JTextField();
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

        txtPatosCazados.setEditable(false);
        txtPatosCazados.setBackground(new java.awt.Color(51, 51, 51));
        txtPatosCazados.setForeground(new java.awt.Color(255, 255, 255));
        txtPatosCazados.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtPatosCazados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPatosCazadosActionPerformed(evt);
            }
        });

        txtFallos.setEditable(false);
        txtFallos.setBackground(new java.awt.Color(51, 51, 51));
        txtFallos.setForeground(new java.awt.Color(255, 255, 255));
        txtFallos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtFallos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFallosActionPerformed(evt);
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
                .addComponent(txtPatosCazados, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTiempoJugado2)
                .addGap(18, 18, 18)
                .addComponent(txtFallos, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
        );
        pnlInformacionLayout.setVerticalGroup(
            pnlInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInformacionLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnlInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTiempoJugado2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtFallos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTiempoJugado1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPatosCazados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        System.out.println("No se guardan los registros");
        terminarPartida();
        cerrarVentana();
    }//GEN-LAST:event_btnRegresarAlMenuActionPerformed

    private void txtTiempoJugadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTiempoJugadoActionPerformed
    }//GEN-LAST:event_txtTiempoJugadoActionPerformed

    private void txtPatosCazadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPatosCazadosActionPerformed
    }//GEN-LAST:event_txtPatosCazadosActionPerformed

    private void txtFallosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFallosActionPerformed
    }//GEN-LAST:event_txtFallosActionPerformed

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
    private javax.swing.JTextField txtFallos;
    private javax.swing.JTextField txtPatosCazados;
    private javax.swing.JTextField txtTiempoJugado;
    // End of variables declaration//GEN-END:variables

}
