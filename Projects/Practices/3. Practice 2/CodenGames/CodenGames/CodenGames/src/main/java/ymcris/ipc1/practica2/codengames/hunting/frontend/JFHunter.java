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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import ymcris.ipc1.practica2.codengames.a.backend.Threads.Tiempo;
import ymcris.ipc1.practica2.codengames.a.frontend.JFMenuPrincipal;
import ymcris.ipc1.practica2.codengames.a.frontend.JPanelPersonalizado;

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

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private boolean acerto;
    private int botonDondeSeEncuentraElPato;

    // CONSTANTES --------------------------------------------------------------
    private static final String NOMBRE_MUSICA_PATOS = "/musicaPatos.wav";
    private static final String NOMBRE_IMAGEN_FONDO = "/escenarioPatos.png";
    private static final String NOMBRE_IMAGEN_PATO = "/pato.png";

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public JFHunter() {
        //1. Inicializar atributos del frame
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        //2. Agregar fondo al panel de los patos
        JPanelPersonalizado panelPersonalizado = new JPanelPersonalizado(pnlJuego, NOMBRE_IMAGEN_FONDO);
        pnlJuego.add(panelPersonalizado).repaint();
        //3. Hacer que los botones sean transparentes
        transparentarBotones();
        //4. Iniciar el contador de tiempo del juego
        iniciarContador();
        //4.5 Mostrar el icono de los patos
        actualizarPatos();
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
                System.out.println(threadTiempo.getTiempoTotal());
                txtTiempoJugado.setText(String.valueOf(threadTiempo.getTiempoTotal()));
            }
        });
        contador.start();
    }
    
    private void actualizarPatos() {
        ImageIcon iconPato = new ImageIcon(getClass().getResource(NOMBRE_IMAGEN_PATO));
        btn1.setIcon(iconPato);
        btn1.setHorizontalTextPosition(SwingConstants.CENTER);
        btn1.setVerticalTextPosition(SwingConstants.BOTTOM);
    }

    /**
     * Método encargado de transparentar los botones del frame
     */
    private void transparentarBotones() {
        btn1.setOpaque(false);
        btn1.setContentAreaFilled(false);
        btn1.setBorderPainted(false);
        btn2.setOpaque(false);
        btn2.setContentAreaFilled(false);
        btn2.setBorderPainted(false);
        btn3.setOpaque(false);
        btn3.setContentAreaFilled(false);
        btn3.setBorderPainted(false);
        btn4.setOpaque(false);
        btn4.setContentAreaFilled(false);
        btn4.setBorderPainted(false);
        btn5.setOpaque(false);
        btn5.setContentAreaFilled(false);
        btn5.setBorderPainted(false);
        btn6.setOpaque(false);
        btn6.setContentAreaFilled(false);
        btn6.setBorderPainted(false);
        btn7.setOpaque(false);
        btn7.setContentAreaFilled(false);
        btn7.setBorderPainted(false);
        btn8.setOpaque(false);
        btn8.setContentAreaFilled(false);
        btn8.setBorderPainted(false);
        btn9.setOpaque(false);
        btn9.setContentAreaFilled(false);
        btn9.setBorderPainted(false);
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
        pnlJuego = new javax.swing.JPanel();
        btn5 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
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

        javax.swing.GroupLayout pnlOpcionesLayout = new javax.swing.GroupLayout(pnlOpciones);
        pnlOpciones.setLayout(pnlOpcionesLayout);
        pnlOpcionesLayout.setHorizontalGroup(
            pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegresarAlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        );

        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });

        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });

        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });

        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });

        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });

        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });

        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn9ActionPerformed(evt);
            }
        });

        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlJuegoLayout = new javax.swing.GroupLayout(pnlJuego);
        pnlJuego.setLayout(pnlJuegoLayout);
        pnlJuegoLayout.setHorizontalGroup(
            pnlJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlJuegoLayout.createSequentialGroup()
                .addGap(237, 237, 237)
                .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(152, 152, 152)
                .addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlJuegoLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(158, 158, 158)
                .addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
            .addGroup(pnlJuegoLayout.createSequentialGroup()
                .addGroup(pnlJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlJuegoLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlJuegoLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(126, 126, 126)))
                .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107)
                .addComponent(btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        pnlJuegoLayout.setVerticalGroup(
            pnlJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlJuegoLayout.createSequentialGroup()
                .addGroup(pnlJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlJuegoLayout.createSequentialGroup()
                        .addGroup(pnlJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlJuegoLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34))
                            .addGroup(pnlJuegoLayout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlJuegoLayout.createSequentialGroup()
                        .addGroup(pnlJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlJuegoLayout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlJuegoLayout.createSequentialGroup()
                                .addGap(115, 115, 115)
                                .addComponent(btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(62, 62, 62)
                        .addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)))
                .addGroup(pnlJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlJuegoLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(pnlJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlJuegoLayout.createSequentialGroup()
                                .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(109, 109, 109))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlJuegoLayout.createSequentialGroup()
                                .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(125, 125, 125))))
                    .addGroup(pnlJuegoLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
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

    private void btn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn9ActionPerformed
        System.out.println("9");
    }//GEN-LAST:event_btn9ActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
        System.out.println("8");
    }//GEN-LAST:event_btn8ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        System.out.println("5");
    }//GEN-LAST:event_btn5ActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        System.out.println("7");
    }//GEN-LAST:event_btn7ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        System.out.println("6");
    }//GEN-LAST:event_btn6ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        System.out.println("2");
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        System.out.println("4");
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        System.out.println("1");
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        System.out.println("3");
    }//GEN-LAST:event_btn3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JButton btnInformacion;
    private javax.swing.JButton btnMusica;
    private javax.swing.JButton btnRegresarAlMenu;
    private javax.swing.JButton btnSalirDelJuego;
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
