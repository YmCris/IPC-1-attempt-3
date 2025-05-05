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
public class JFCreadorDeMateriaPrima extends javax.swing.JFrame {

    // CONSTANTES --------------------------------------------------------------
    private final static String RUTA_IMAGEN = "/fondoCreadores.png";

    // INSTANCIAS --------------------------------------------------------------
    private ArchivosDeTexto archivo = new ArchivosDeTexto();

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public JFCreadorDeMateriaPrima() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        PanelPersonalizado panel = new PanelPersonalizado(jPanel1, RUTA_IMAGEN);
        jPanel1.add(panel).repaint();
    }

    // CÓDIGO AUTOGENERADO -----------------------------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo2 = new javax.swing.JLabel();
        lblTitulo1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        spnPorcentajeDeProducción = new javax.swing.JSpinner();
        btnCrearMateriaPrima = new javax.swing.JButton();
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
        lblTitulo1.setText("De Materia");
        lblTitulo1.setToolTipText("");
        lblTitulo1.setMaximumSize(new java.awt.Dimension(300, 300));
        lblTitulo1.setMinimumSize(new java.awt.Dimension(300, 300));
        lblTitulo1.setName(""); // NOI18N
        lblTitulo1.setPreferredSize(new java.awt.Dimension(300, 300));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Porcentaje de Producción");

        spnPorcentajeDeProducción.setModel(new javax.swing.SpinnerNumberModel(10, 10, 100, 5));
        spnPorcentajeDeProducción.setToolTipText("");

        btnCrearMateriaPrima.setBackground(new java.awt.Color(51, 51, 51));
        btnCrearMateriaPrima.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCrearMateriaPrima.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearMateriaPrima.setText("CREAR");
        btnCrearMateriaPrima.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCrearMateriaPrima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearMateriaPrimaActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTitulo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnCrearMateriaPrima, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(326, 326, 326))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnIrAlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(262, 262, 262))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spnPorcentajeDeProducción, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(spnPorcentajeDeProducción, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(129, 129, 129)
                .addComponent(btnCrearMateriaPrima, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnIrAlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearMateriaPrimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearMateriaPrimaActionPerformed
        String nombre = txtNombre.getText().toLowerCase();
        int porcentajeDeProducción = (int) spnPorcentajeDeProducción.getValue();
        if (nombre.isBlank()) {
            JOptionPane.showMessageDialog(null, "No puedes crear una materia prima con un nombre vacio", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                if (!archivo.existeArchivo(archivo.getRutaCarpetaProductos(), nombre + ".txt")) {
                    File producto = archivo.crearArchivo(archivo.getRutaCarpetaProductos(), nombre);
                    archivo.escribirEnArchivo(producto, nombre);
                    archivo.escribirEnArchivo(producto, String.valueOf(porcentajeDeProducción));
                    JOptionPane.showMessageDialog(null, "Se ha creado la materia prima " + nombre + " exitosamente", "Nueva Materia Prima", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No puedes crear una materia prima con el nombre " + nombre + " porque ya existe", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } catch (ArchivoException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnCrearMateriaPrimaActionPerformed

    private void btnIrAlMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIrAlMenuActionPerformed
        this.dispose();
        new JFMenuPrincipal().setVisible(true);
    }//GEN-LAST:event_btnIrAlMenuActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearMateriaPrima;
    private javax.swing.JButton btnIrAlMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblTitulo2;
    private javax.swing.JSpinner spnPorcentajeDeProducción;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
