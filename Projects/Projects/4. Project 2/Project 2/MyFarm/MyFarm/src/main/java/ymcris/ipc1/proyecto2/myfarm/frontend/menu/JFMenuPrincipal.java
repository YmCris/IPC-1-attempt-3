package ymcris.ipc1.proyecto2.myfarm.frontend.menu;

import javax.swing.JLabel;
import java.awt.TextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import ymcris.ipc1.proyecto2.myfarm.backend.a.archivos.texto.Archivos;
import ymcris.ipc1.proyecto2.myfarm.backend.a.archivos.texto.Creador;
import ymcris.ipc1.proyecto2.myfarm.backend.b.granja.Granja;
import ymcris.ipc1.proyecto2.myfarm.backend.b.granjero.Granjero;
import ymcris.ipc1.proyecto2.myfarm.frontend.creadores.JFCreadorDeAlimentos;
import ymcris.ipc1.proyecto2.myfarm.frontend.creadores.JFCreadorDeAnimales;
import ymcris.ipc1.proyecto2.myfarm.frontend.creadores.JFCreadorDeMateriaPrima;
import ymcris.ipc1.proyecto2.myfarm.frontend.creadores.JFCreadorDePlantas;
import ymcris.ipc1.proyecto2.myfarm.frontend.creadores.JFEditoDeAnimales;
import ymcris.ipc1.proyecto2.myfarm.frontend.elementos.JDCargarPartida;
import ymcris.ipc1.proyecto2.myfarm.frontend.juego.JFGranja;
import ymcris.ipc1.proyecto2.myfarm.frontend.elementos.PanelPersonalizado;

/**
 *
 * @author YmCris
 */
public class JFMenuPrincipal extends javax.swing.JFrame {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private JDialog dialog;

    Archivos archivo = new Archivos();

    // CONSTANTES --------------------------------------------------------------
    private static final String RUTA_IMAGEN = "/imagenMenu.png";

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public JFMenuPrincipal() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Menú Principal");
        PanelPersonalizado panel = new PanelPersonalizado(pnlMenu, RUTA_IMAGEN);
        pnlMenu.add(panel).repaint();
    }

    public JFMenuPrincipal(Creador creador) {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Menú Principal");
        PanelPersonalizado panel = new PanelPersonalizado(pnlMenu, RUTA_IMAGEN);
        pnlMenu.add(panel).repaint();
        creador.crearProductosPredeterminados();
        creador.crearAnimalesPredeterminados();
        creador.crearSemillasPredeterminadas();
    }

    // CÓDIGO "AUTOGENERADO" ---------------------------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMenu = new javax.swing.JPanel();
        lblTitulo1 = new javax.swing.JLabel();
        lblTitulo2 = new javax.swing.JLabel();
        btnCrearProductos = new javax.swing.JButton();
        btnReportes = new javax.swing.JButton();
        btnCrearAnimales = new javax.swing.JButton();
        btnNuevaPartida = new javax.swing.JButton();
        btnPartidaExistente = new javax.swing.JButton();
        btnCrearPlantas = new javax.swing.JButton();
        btnEditarAnimales = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnInformación = new javax.swing.JButton();
        btnMusica = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1200, 900));

        pnlMenu.setMaximumSize(new java.awt.Dimension(555555, 5555555));
        pnlMenu.setMinimumSize(new java.awt.Dimension(0, 0));

        lblTitulo1.setBackground(java.awt.SystemColor.activeCaptionText);
        lblTitulo1.setFont(new java.awt.Font("Snap ITC", 1, 100)); // NOI18N
        lblTitulo1.setForeground(new java.awt.Color(51, 51, 51));
        lblTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo1.setText("FARM");
        lblTitulo1.setToolTipText("");
        lblTitulo1.setMaximumSize(new java.awt.Dimension(300, 300));
        lblTitulo1.setMinimumSize(new java.awt.Dimension(300, 300));
        lblTitulo1.setName(""); // NOI18N
        lblTitulo1.setPreferredSize(new java.awt.Dimension(300, 300));

        lblTitulo2.setBackground(java.awt.SystemColor.activeCaptionText);
        lblTitulo2.setFont(new java.awt.Font("Snap ITC", 1, 100)); // NOI18N
        lblTitulo2.setForeground(new java.awt.Color(51, 51, 51));
        lblTitulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo2.setText("MY");
        lblTitulo2.setToolTipText("");
        lblTitulo2.setMaximumSize(new java.awt.Dimension(300, 300));
        lblTitulo2.setMinimumSize(new java.awt.Dimension(300, 300));
        lblTitulo2.setName(""); // NOI18N
        lblTitulo2.setPreferredSize(new java.awt.Dimension(300, 300));

        btnCrearProductos.setBackground(new java.awt.Color(51, 51, 51));
        btnCrearProductos.setFont(new java.awt.Font("Ravie", 0, 36)); // NOI18N
        btnCrearProductos.setForeground(new java.awt.Color(51, 51, 51));
        btnCrearProductos.setText("Crear Productos");
        btnCrearProductos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCrearProductos.setOpaque(false);
        btnCrearProductos.setBorderPainted(false);
        btnCrearProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearProductosActionPerformed(evt);
            }
        });

        btnReportes.setBackground(new java.awt.Color(51, 51, 51));
        btnReportes.setFont(new java.awt.Font("Ravie", 0, 36)); // NOI18N
        btnReportes.setForeground(new java.awt.Color(51, 51, 51));
        btnReportes.setText("Reportes");
        btnReportes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnReportes.setOpaque(false);
        btnReportes.setBorderPainted(false);
        btnReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportesActionPerformed(evt);
            }
        });

        btnCrearAnimales.setBackground(new java.awt.Color(51, 51, 51));
        btnCrearAnimales.setFont(new java.awt.Font("Ravie", 0, 36)); // NOI18N
        btnCrearAnimales.setForeground(new java.awt.Color(51, 51, 51));
        btnCrearAnimales.setText("Crear Animales");
        btnCrearAnimales.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCrearAnimales.setOpaque(false);
        btnCrearAnimales.setBorderPainted(false);
        btnCrearAnimales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearAnimalesActionPerformed(evt);
            }
        });

        btnNuevaPartida.setBackground(new java.awt.Color(51, 51, 51));
        btnNuevaPartida.setFont(new java.awt.Font("Ravie", 0, 36)); // NOI18N
        btnNuevaPartida.setForeground(new java.awt.Color(51, 51, 51));
        btnNuevaPartida.setText("Nueva Partida");
        btnNuevaPartida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnNuevaPartida.setOpaque(false);
        btnNuevaPartida.setBorderPainted(false);
        btnNuevaPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaPartidaActionPerformed(evt);
            }
        });

        btnPartidaExistente.setBackground(new java.awt.Color(51, 51, 51));
        btnPartidaExistente.setFont(new java.awt.Font("Ravie", 0, 36)); // NOI18N
        btnPartidaExistente.setForeground(new java.awt.Color(51, 51, 51));
        btnPartidaExistente.setText("Partida Existente");
        btnPartidaExistente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPartidaExistente.setOpaque(false);
        btnPartidaExistente.setBorderPainted(false);
        btnPartidaExistente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPartidaExistenteActionPerformed(evt);
            }
        });

        btnCrearPlantas.setBackground(new java.awt.Color(51, 51, 51));
        btnCrearPlantas.setFont(new java.awt.Font("Ravie", 0, 36)); // NOI18N
        btnCrearPlantas.setForeground(new java.awt.Color(51, 51, 51));
        btnCrearPlantas.setText("Crear Plantas");
        btnCrearPlantas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCrearPlantas.setOpaque(false);
        btnCrearPlantas.setBorderPainted(false);
        btnCrearPlantas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearPlantasActionPerformed(evt);
            }
        });

        btnEditarAnimales.setBackground(new java.awt.Color(51, 51, 51));
        btnEditarAnimales.setFont(new java.awt.Font("Ravie", 0, 36)); // NOI18N
        btnEditarAnimales.setForeground(new java.awt.Color(51, 51, 51));
        btnEditarAnimales.setText("Editar Animales");
        btnEditarAnimales.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEditarAnimales.setOpaque(false);
        btnEditarAnimales.setBorderPainted(false);
        btnEditarAnimales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarAnimalesActionPerformed(evt);
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
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuLayout.createSequentialGroup()
                        .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(318, 318, 318))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuLayout.createSequentialGroup()
                        .addComponent(btnMusica, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnInformación, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuLayout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCrearAnimales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNuevaPartida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCrearProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPartidaExistente, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrearPlantas, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditarAnimales, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(97, 97, 97))
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGap(353, 353, 353)
                .addComponent(btnReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInformación, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMusica, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblTitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPartidaExistente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevaPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrearPlantas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrearAnimales, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditarAnimales, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrearProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(btnReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pedirNombre() {
        dialog = new JDialog();
        dialog.setSize(500, 300);
        dialog.setLayout(null);
        dialog.setLocationRelativeTo(null);
        dialog.setModal(true);
        dialog.setTitle("Nueva Partida");
        JLabel lblNombre = new JLabel("Ingrese el nombre del jugador:");
        lblNombre.setBounds(50, 25, 300, 50);
        dialog.add(lblNombre);
        TextField txtNombre = new TextField();
        txtNombre.setBounds(50, 75, 300, 30);
        dialog.add(txtNombre);
        JLabel lblNick = new JLabel("Ingrese el nick del jugador:");
        lblNick.setBounds(50, 100, 300, 50);
        dialog.add(lblNick);
        TextField txtNick = new TextField();
        txtNick.setBounds(50, 150, 300, 30);
        dialog.add(txtNick);
        JButton btnGuardar = new JButton();
        btnGuardar.setText("Guardar");
        btnGuardar.setOpaque(false);
        btnGuardar.setBounds(100, 200, 250, 30);
        btnGuardar.setBorderPainted(false);
        btnGuardar.addActionListener((e) -> {
            btnGuardarActionPerformed(e, txtNombre.getText(), txtNick.getText());
        });
        dialog.add(btnGuardar);
        dialog.setVisible(true);
    }

    private void crearProductos() {
        dialog = new JDialog();
        dialog.setSize(600, 150);
        dialog.setLayout(null);
        dialog.setLocationRelativeTo(null);
        dialog.setModal(true);
        dialog.setTitle("Nuevo Producto");
        JButton btnProducto = new JButton();
        btnProducto.setText("Crear una Nueva Materia Prima");
        btnProducto.setOpaque(false);
        btnProducto.setBounds(20, 30, 250, 30);
        btnProducto.setBorderPainted(false);
        btnProducto.addActionListener((e) -> {
            dialog.dispose();
            this.dispose();
            new JFCreadorDeMateriaPrima().setVisible(true);
        });
        dialog.add(btnProducto);
        JButton btnAlimento = new JButton();
        btnAlimento.setText("Crear un Nuevo Alimento");
        btnAlimento.setOpaque(false);
        btnAlimento.setBounds(350, 30, 200, 30);
        btnAlimento.setBorderPainted(false);
        btnAlimento.addActionListener((e) -> {
            dialog.dispose();
            this.dispose();
            new JFCreadorDeAlimentos().setVisible(true);
        });
        dialog.add(btnAlimento);
        dialog.setVisible(true);
    }

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt, String nombre, String nick) {
        if (nombre.isBlank() || nick.isBlank()) {
            JOptionPane.showMessageDialog(null, "No puedes tener un nombre o nick vacios", "ERROR", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (archivo.existeArchivo(archivo.getRutaCarpetaGranjeros(), nombre)) {
            JOptionPane.showMessageDialog(null, "No puedes tener ese nombre porque ya existe una partida con ese nombre", "ERROR", JOptionPane.WARNING_MESSAGE);
        } else {
            this.dispose();
            dialog.dispose();
            JFGranja granjaF = new JFGranja(new Granja(new Granjero(nick, nombre)));
            Thread hiloGranaF = new Thread(granjaF);
            hiloGranaF.start();
            granjaF.setVisible(true);
        }
    }

    private void btnCrearProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearProductosActionPerformed
        crearProductos();
    }//GEN-LAST:event_btnCrearProductosActionPerformed

    private void btnReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportesActionPerformed
        this.dispose();
        new JFReportes().setVisible(true);
    }//GEN-LAST:event_btnReportesActionPerformed

    private void btnCrearAnimalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearAnimalesActionPerformed
        this.dispose();
        new JFCreadorDeAnimales().setVisible(true);
    }//GEN-LAST:event_btnCrearAnimalesActionPerformed

    private void btnNuevaPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaPartidaActionPerformed
        pedirNombre();
    }//GEN-LAST:event_btnNuevaPartidaActionPerformed

    private void btnPartidaExistenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPartidaExistenteActionPerformed
        this.dispose();
        new JDCargarPartida().setVisible(true);
    }//GEN-LAST:event_btnPartidaExistenteActionPerformed

    private void btnCrearPlantasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearPlantasActionPerformed
        this.dispose();
        new JFCreadorDePlantas().setVisible(true);
    }//GEN-LAST:event_btnCrearPlantasActionPerformed

    private void btnEditarAnimalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarAnimalesActionPerformed
        this.dispose();
        new JFEditoDeAnimales().setVisible(true);
    }//GEN-LAST:event_btnEditarAnimalesActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnInformaciónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInformaciónActionPerformed
        JOptionPane.showMessageDialog(null, "Crea, produce, diseña y revoluciona tu propio mundo\nBienvenido a:\n                                   MY FARM\n\n\n                               De CodenBugs", "My Farm", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnInformaciónActionPerformed

    private void btnMusicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMusicaActionPerformed
    }//GEN-LAST:event_btnMusicaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearAnimales;
    private javax.swing.JButton btnCrearPlantas;
    private javax.swing.JButton btnCrearProductos;
    private javax.swing.JButton btnEditarAnimales;
    private javax.swing.JButton btnInformación;
    private javax.swing.JButton btnMusica;
    private javax.swing.JButton btnNuevaPartida;
    private javax.swing.JButton btnPartidaExistente;
    private javax.swing.JButton btnReportes;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblTitulo2;
    private javax.swing.JPanel pnlMenu;
    // End of variables declaration//GEN-END:variables
}
