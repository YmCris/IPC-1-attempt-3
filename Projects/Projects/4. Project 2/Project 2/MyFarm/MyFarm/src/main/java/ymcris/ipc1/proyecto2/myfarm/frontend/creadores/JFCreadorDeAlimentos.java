package ymcris.ipc1.proyecto2.myfarm.frontend.creadores;

import java.io.File;
import javax.swing.JOptionPane;
import ymcris.ipc1.proyecto2.myfarm.backend.a.archivos.texto.ArchivosDeTexto;
import ymcris.ipc1.proyecto2.myfarm.backend.a.exceptions.ArchivoException;
import ymcris.ipc1.proyecto2.myfarm.frontend.elementos.PanelPersonalizado;
import ymcris.ipc1.proyecto2.myfarm.frontend.menu.JFMenuPrincipal;

/**
 *
 * @author YmCris
 */
public class JFCreadorDeAlimentos extends javax.swing.JFrame {

    // CONSTANTES --------------------------------------------------------------
    private final static String RUTA_IMAGEN = "/fondoCreadores.png";

    // INSTANCIAS --------------------------------------------------------------
    private ArchivosDeTexto archivo = new ArchivosDeTexto();

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public JFCreadorDeAlimentos() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        PanelPersonalizado panel = new PanelPersonalizado(pnlFondo, RUTA_IMAGEN);
        pnlFondo.add(panel).repaint();
    }

    // CÓDIGO AUTOGENERADO -----------------------------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFondo = new javax.swing.JPanel();
        lblTitulo2 = new javax.swing.JLabel();
        lblTitulo1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        cbEsParaHerbivoros = new javax.swing.JCheckBox();
        spnPorcentajeDeProduccion = new javax.swing.JSpinner();
        btnCrearAlimento = new javax.swing.JButton();
        btnIrAlMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo2.setBackground(java.awt.SystemColor.activeCaptionText);
        lblTitulo2.setFont(new java.awt.Font("Snap ITC", 1, 100)); // NOI18N
        lblTitulo2.setForeground(new java.awt.Color(51, 51, 51));
        lblTitulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo2.setText("Creador");
        lblTitulo2.setToolTipText("");
        lblTitulo2.setMaximumSize(new java.awt.Dimension(300, 300));
        lblTitulo2.setMinimumSize(new java.awt.Dimension(300, 300));
        lblTitulo2.setName(""); // NOI18N
        lblTitulo2.setPreferredSize(new java.awt.Dimension(300, 300));

        lblTitulo1.setBackground(java.awt.SystemColor.activeCaptionText);
        lblTitulo1.setFont(new java.awt.Font("Snap ITC", 1, 100)); // NOI18N
        lblTitulo1.setForeground(new java.awt.Color(51, 51, 51));
        lblTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo1.setText("De Alimentos");
        lblTitulo1.setToolTipText("");
        lblTitulo1.setMaximumSize(new java.awt.Dimension(300, 300));
        lblTitulo1.setMinimumSize(new java.awt.Dimension(300, 300));
        lblTitulo1.setName(""); // NOI18N
        lblTitulo1.setPreferredSize(new java.awt.Dimension(300, 300));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Es para herbivoros");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Porcentaje De Producción");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        cbEsParaHerbivoros.setPreferredSize(new java.awt.Dimension(25, 25));
        cbEsParaHerbivoros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEsParaHerbivorosActionPerformed(evt);
            }
        });

        spnPorcentajeDeProduccion.setModel(new javax.swing.SpinnerNumberModel(10, 10, 100, 5));

        btnCrearAlimento.setBackground(new java.awt.Color(51, 51, 51));
        btnCrearAlimento.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCrearAlimento.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearAlimento.setText("CREAR");
        btnCrearAlimento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCrearAlimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearAlimentoActionPerformed(evt);
            }
        });

        btnIrAlMenu.setBackground(new java.awt.Color(51, 51, 51));
        btnIrAlMenu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnIrAlMenu.setForeground(new java.awt.Color(255, 255, 255));
        btnIrAlMenu.setText("REGRESAR AL MENÚ PRINCIPAL");
        btnIrAlMenu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnIrAlMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIrAlMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFondoLayout = new javax.swing.GroupLayout(pnlFondo);
        pnlFondo.setLayout(pnlFondoLayout);
        pnlFondoLayout.setHorizontalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTitulo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(lblTitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(124, 124, 124))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(296, 296, 296)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                        .addComponent(cbEsParaHerbivoros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(152, 152, 152))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(spnPorcentajeDeProduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                        .addComponent(btnIrAlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(267, 267, 267))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                        .addComponent(btnCrearAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(331, 331, 331))))
        );
        pnlFondoLayout.setVerticalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblTitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbEsParaHerbivoros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addComponent(jLabel2))
                    .addComponent(spnPorcentajeDeProduccion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(86, 86, 86)
                .addComponent(btnCrearAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btnIrAlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(110, Short.MAX_VALUE))
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

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
    }//GEN-LAST:event_txtNombreActionPerformed

    private void cbEsParaHerbivorosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEsParaHerbivorosActionPerformed
    }//GEN-LAST:event_cbEsParaHerbivorosActionPerformed

    private void btnCrearAlimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearAlimentoActionPerformed
        String nombre = txtNombre.getText().toLowerCase();
        boolean esParaHerbivoros = cbEsParaHerbivoros.isSelected();
        int porcentajeDeProduccion = (int) spnPorcentajeDeProduccion.getValue();
        if (nombre.isBlank()) {
            JOptionPane.showMessageDialog(null, "No puedes crear una limento con un nombre vacío", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                if (!archivo.existeArchivo(archivo.getRutaCarpetaProductos(), nombre + ".txt")) {
                    File alimento = archivo.crearArchivo(archivo.getRutaCarpetaProductos(), nombre);
                    archivo.escribirEnArchivo(alimento, nombre);
                    archivo.escribirEnArchivo(alimento, String.valueOf(porcentajeDeProduccion));
                    archivo.escribirEnArchivo(alimento, String.valueOf(esParaHerbivoros));
                    JOptionPane.showMessageDialog(null, "Se ha creado el alimento " + nombre + " exitosamente", "Nuevo Alimento", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No puedes crear un alimento con el nombre " + nombre + " porque ya existe", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } catch (ArchivoException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnCrearAlimentoActionPerformed

    private void btnIrAlMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIrAlMenuActionPerformed
        this.dispose();
        new JFMenuPrincipal().setVisible(true);
    }//GEN-LAST:event_btnIrAlMenuActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearAlimento;
    private javax.swing.JButton btnIrAlMenu;
    private javax.swing.JCheckBox cbEsParaHerbivoros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblTitulo2;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JSpinner spnPorcentajeDeProduccion;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
