package ymcris.ipc1.proyecto2.myfarm.frontend.juego;

import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Window;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import ymcris.ipc1.proyecto2.myfarm.backend.c.suelos.Agua;
import ymcris.ipc1.proyecto2.myfarm.backend.c.suelos.Grama;
import ymcris.ipc1.proyecto2.myfarm.backend.c.suelos.Suelo;
import ymcris.ipc1.proyecto2.myfarm.backend.b.granja.Bodega;
import ymcris.ipc1.proyecto2.myfarm.backend.b.granja.Granja;
import ymcris.ipc1.proyecto2.myfarm.backend.b.granja.Mercado;
import ymcris.ipc1.proyecto2.myfarm.backend.c.suelos.Desierto;
import ymcris.ipc1.proyecto2.myfarm.backend.b.granjero.Granjero;
import ymcris.ipc1.proyecto2.myfarm.frontend.juego.suelos.JDAgua;
import ymcris.ipc1.proyecto2.myfarm.frontend.menu.JFMenuPrincipal;
import ymcris.ipc1.proyecto2.myfarm.frontend.juego.suelos.JDGrama;
import ymcris.ipc1.proyecto2.myfarm.frontend.juego.suelos.JDDesierto;
import ymcris.ipc1.proyecto2.myfarm.backend.a.exceptions.ListaOrtogonalException;

/**
 *
 * @see Granja
 * @author YmCris
 */
public class JFGranja extends javax.swing.JFrame implements Runnable {
    
    private Granja granja;
    private Bodega bodega;
    private Mercado mercado;
    private Granjero granjero;
    
    public JFGranja(Granja granja) {
        initComponents();
        this.granja = granja;
        this.granjero = granja.getGranjero();
        this.bodega = granja.getBodega();
        this.mercado = granja.getMercado();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        actualizarContenido();
        try {
            colocarBotones();
        } catch (ListaOrtogonalException e) {
            System.out.println("Hubo un error al colocar la lista ortogonal en el panel porque " + e.getMessage());
        }
        try {
            Thread hiloJuego = new Thread(granja);
            hiloJuego.start();
        } catch (Exception e) {
        }
    }

    // MÉTODOS CONCRETOS -------------------------------------------------------
    @Override
    public void run() {
        while (!granja.partidaTerminada()) {
            try {
                Thread.sleep(500);
                if (granja.partidaTerminada()) {
                    cerrarTodasLasVentanas();
                    JOptionPane.showMessageDialog(null, "Juego Terminado, Puedes revisar los datos de tu partida en los reportes", "Noob", JOptionPane.INFORMATION_MESSAGE);
                    new JFMenuPrincipal().setVisible(true);
                }
                actualizarContenido();
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
            
        }
        System.out.println("Partida terminada frontend");
    }
    
    public void cerrarTodasLasVentanas() {
    for (Window window : Window.getWindows()) {
        if (window.isDisplayable()) {
            window.dispose();
        }
    }
}
    
    private void actualizarContenido() {
        lblNombre.setText(granjero.getNick().toUpperCase());
        lblOro.setText(String.valueOf(granjero.getOro()));
        lblVida.setText(String.valueOf(granjero.getVida()));
    }
    
    private void colocarBotones() throws ListaOrtogonalException {
        int filas = granja.getTerreno().getTablero().getFilas();
        int columnas = granja.getTerreno().getTablero().getColumnas();
        pnlTablero.setSize(1200, 700);
        pnlTablero.setLayout(new GridLayout(filas, columnas));
        pnlTablero.setSize(1200, 700);
        System.out.println("Filas: " + filas + " Columnas: " + columnas);
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                int fila = i;
                int columna = j;
                Suelo sueloActual = granja.getTerreno().getTablero().obtenerNodo(i, j).getSuelo();
                sueloActual.addActionListener((e) -> {
                    System.out.println("Soy el boton en la posición: " + fila + columna);
                    switch (sueloActual) {
                        case Agua agua ->
                            new JDAgua(agua).setVisible(true);
                        case Desierto desierto ->
                            new JDDesierto(desierto).setVisible(true);
                        case Grama grama ->
                            new JDGrama(grama).setVisible(true);
                        default -> {
                        }
                    }
                });
                pnlTablero.add(sueloActual);
            }
        }
        pnlTablero.revalidate();
        pnlTablero.repaint();
    }

    // CÓDIGO AUTOGENERADO------------------------------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPantalla = new javax.swing.JPanel();
        pnlOpciones = new javax.swing.JPanel();
        btnBodega = new javax.swing.JButton();
        btnGuardarPartida = new javax.swing.JButton();
        btnMercado = new javax.swing.JButton();
        btnLimpiarTerreno = new javax.swing.JButton();
        btnProcesar = new javax.swing.JButton();
        btnPreseleccionarAlimentos = new javax.swing.JButton();
        btnMusica = new javax.swing.JButton();
        btnInformación = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnPreseleccionarAlimentos1 = new javax.swing.JButton();
        pnlTablero = new javax.swing.JPanel();
        pnlInformacion = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblOro = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblCultivosListos = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblAnimalesMuertos = new javax.swing.JLabel();
        lblVida = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("My Farm");

        pnlPantalla.setBackground(new java.awt.Color(0, 0, 0));

        pnlOpciones.setBackground(new java.awt.Color(0, 102, 204));
        pnlOpciones.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlOpciones.setMaximumSize(new java.awt.Dimension(1200, 92));
        pnlOpciones.setMinimumSize(new java.awt.Dimension(1200, 92));
        pnlOpciones.setPreferredSize(new java.awt.Dimension(1200, 92));

        btnBodega.setBackground(new java.awt.Color(51, 51, 51));
        btnBodega.setForeground(new java.awt.Color(255, 255, 255));
        btnBodega.setText("BODEGA");
        btnBodega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBodegaActionPerformed(evt);
            }
        });

        btnGuardarPartida.setBackground(new java.awt.Color(51, 51, 51));
        btnGuardarPartida.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarPartida.setText("GUARDAR PARTIDA");

        btnMercado.setBackground(new java.awt.Color(51, 51, 51));
        btnMercado.setForeground(new java.awt.Color(255, 255, 255));
        btnMercado.setText("MERCADO");
        btnMercado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMercadoActionPerformed(evt);
            }
        });

        btnLimpiarTerreno.setBackground(new java.awt.Color(51, 51, 51));
        btnLimpiarTerreno.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiarTerreno.setText("LIMPIAR TERRENO");
        btnLimpiarTerreno.setToolTipText("");

        btnProcesar.setBackground(new java.awt.Color(51, 51, 51));
        btnProcesar.setForeground(new java.awt.Color(255, 255, 255));
        btnProcesar.setText("PROCESAR ALIMENTOS");

        btnPreseleccionarAlimentos.setBackground(new java.awt.Color(51, 51, 51));
        btnPreseleccionarAlimentos.setForeground(new java.awt.Color(255, 255, 255));
        btnPreseleccionarAlimentos.setText("PRESELECCIONAR ALIMENTOS");

        btnMusica.setBackground(new java.awt.Color(51, 51, 51));
        btnMusica.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMusica.setForeground(new java.awt.Color(255, 255, 255));
        btnMusica.setText("<-");
        btnMusica.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnMusica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMusicaActionPerformed(evt);
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

        btnPreseleccionarAlimentos1.setBackground(new java.awt.Color(51, 51, 51));
        btnPreseleccionarAlimentos1.setForeground(new java.awt.Color(255, 255, 255));
        btnPreseleccionarAlimentos1.setText("COMPRAR TIERRA");
        btnPreseleccionarAlimentos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreseleccionarAlimentos1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlOpcionesLayout = new javax.swing.GroupLayout(pnlOpciones);
        pnlOpciones.setLayout(pnlOpcionesLayout);
        pnlOpcionesLayout.setHorizontalGroup(
            pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBodega)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardarPartida)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMercado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimpiarTerreno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnProcesar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPreseleccionarAlimentos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPreseleccionarAlimentos1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMusica, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnInformación, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        pnlOpcionesLayout.setVerticalGroup(
            pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpcionesLayout.createSequentialGroup()
                .addGroup(pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlOpcionesLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBodega)
                            .addComponent(btnGuardarPartida)
                            .addComponent(btnMercado)
                            .addComponent(btnLimpiarTerreno)
                            .addComponent(btnProcesar)
                            .addComponent(btnPreseleccionarAlimentos)
                            .addComponent(btnPreseleccionarAlimentos1)))
                    .addGroup(pnlOpcionesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnInformación, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMusica, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pnlTablero.setBackground(new java.awt.Color(102, 102, 102));
        pnlTablero.setMaximumSize(new java.awt.Dimension(1200, 712));
        pnlTablero.setMinimumSize(new java.awt.Dimension(1200, 712));
        pnlTablero.setName(""); // NOI18N
        pnlTablero.setPreferredSize(new java.awt.Dimension(1200, 712));

        javax.swing.GroupLayout pnlTableroLayout = new javax.swing.GroupLayout(pnlTablero);
        pnlTablero.setLayout(pnlTableroLayout);
        pnlTableroLayout.setHorizontalGroup(
            pnlTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlTableroLayout.setVerticalGroup(
            pnlTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 712, Short.MAX_VALUE)
        );

        pnlInformacion.setBackground(new java.awt.Color(51, 51, 0));
        pnlInformacion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlInformacion.setMaximumSize(new java.awt.Dimension(1200, 84));
        pnlInformacion.setMinimumSize(new java.awt.Dimension(1200, 84));
        pnlInformacion.setPreferredSize(new java.awt.Dimension(1200, 84));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ORO:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("JUGADOR: ");

        lblNombre.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setText("NOMBRE");

        lblOro.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblOro.setForeground(new java.awt.Color(255, 255, 255));
        lblOro.setText("ORO");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("CULTIVOS LISTOS:");

        lblCultivosListos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCultivosListos.setForeground(new java.awt.Color(255, 255, 255));
        lblCultivosListos.setText("0");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ANIMALES MUERTOS:");

        lblAnimalesMuertos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblAnimalesMuertos.setForeground(new java.awt.Color(255, 255, 255));
        lblAnimalesMuertos.setText("0");

        lblVida.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblVida.setForeground(new java.awt.Color(255, 255, 255));
        lblVida.setText("NOMBRE");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("VIDA: ");

        javax.swing.GroupLayout pnlInformacionLayout = new javax.swing.GroupLayout(pnlInformacion);
        pnlInformacion.setLayout(pnlInformacionLayout);
        pnlInformacionLayout.setHorizontalGroup(
            pnlInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInformacionLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNombre)
                .addGap(45, 45, 45)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblVida)
                .addGap(55, 55, 55)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblOro)
                .addGap(62, 62, 62)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCultivosListos)
                .addGap(45, 45, 45)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblAnimalesMuertos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlInformacionLayout.setVerticalGroup(
            pnlInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInformacionLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnlInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(lblOro)
                        .addComponent(jLabel5)
                        .addComponent(lblCultivosListos)
                        .addComponent(jLabel7)
                        .addComponent(lblAnimalesMuertos))
                    .addGroup(pnlInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(lblVida))
                    .addGroup(pnlInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(lblNombre)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlPantallaLayout = new javax.swing.GroupLayout(pnlPantalla);
        pnlPantalla.setLayout(pnlPantallaLayout);
        pnlPantallaLayout.setHorizontalGroup(
            pnlPantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlOpciones, javax.swing.GroupLayout.DEFAULT_SIZE, 1202, Short.MAX_VALUE)
            .addComponent(pnlInformacion, javax.swing.GroupLayout.DEFAULT_SIZE, 1202, Short.MAX_VALUE)
            .addComponent(pnlTablero, javax.swing.GroupLayout.DEFAULT_SIZE, 1202, Short.MAX_VALUE)
        );
        pnlPantallaLayout.setVerticalGroup(
            pnlPantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPantallaLayout.createSequentialGroup()
                .addComponent(pnlOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlTablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlInformacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPantalla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPantalla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void btnMusicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMusicaActionPerformed
        JDialog dialog = new JDialog(this);
        dialog.setModal(true);
        dialog.setLocationRelativeTo(null);
        dialog.setTitle("Ir al menú principal");
        dialog.setSize(700, 400);
        dialog.setLayout(new FlowLayout());
        dialog.add(new JLabel("Si regresar al menú principal sin haber guardado la partida"));
        dialog.add(new JLabel(" perderás el progreso"));
        dialog.add(new JLabel(" ¿Estas seguro de ir al menú principal?"));
        JButton boton = new JButton(" Ir al menú principal");
        boton.addActionListener((e) -> {
            this.dispose();
            dialog.dispose();
            new JFMenuPrincipal().setVisible(true);
        });
        dialog.add(boton);
        dialog.pack();
        dialog.setVisible(true);
    }//GEN-LAST:event_btnMusicaActionPerformed

    private void btnInformaciónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInformaciónActionPerformed
        JOptionPane.showMessageDialog(null, "¡" + granja.getGranjero().getNombre().toUpperCase() + " RECUERDA COMER!", "Granja de " + granja.getGranjero().getNombre(), JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnInformaciónActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnBodegaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBodegaActionPerformed
        new JDBodega(bodega).setVisible(true);
    }//GEN-LAST:event_btnBodegaActionPerformed

    private void btnMercadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMercadoActionPerformed
        new JDMercado(mercado).setVisible(true);
    }//GEN-LAST:event_btnMercadoActionPerformed

    private void btnPreseleccionarAlimentos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreseleccionarAlimentos1ActionPerformed

    }//GEN-LAST:event_btnPreseleccionarAlimentos1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBodega;
    private javax.swing.JButton btnGuardarPartida;
    private javax.swing.JButton btnInformación;
    private javax.swing.JButton btnLimpiarTerreno;
    private javax.swing.JButton btnMercado;
    private javax.swing.JButton btnMusica;
    private javax.swing.JButton btnPreseleccionarAlimentos;
    private javax.swing.JButton btnPreseleccionarAlimentos1;
    private javax.swing.JButton btnProcesar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lblAnimalesMuertos;
    private javax.swing.JLabel lblCultivosListos;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblOro;
    private javax.swing.JLabel lblVida;
    private javax.swing.JPanel pnlInformacion;
    private javax.swing.JPanel pnlOpciones;
    private javax.swing.JPanel pnlPantalla;
    private javax.swing.JPanel pnlTablero;
    // End of variables declaration//GEN-END:variables

}
