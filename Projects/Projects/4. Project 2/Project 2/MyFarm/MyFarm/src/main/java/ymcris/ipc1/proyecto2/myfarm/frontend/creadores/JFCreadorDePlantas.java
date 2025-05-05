package ymcris.ipc1.proyecto2.myfarm.frontend.creadores;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ymcris.ipc1.proyecto2.myfarm.backend.a.archivos.texto.ArchivosDeTexto;
import ymcris.ipc1.proyecto2.myfarm.backend.a.exceptions.ArchivoException;
import ymcris.ipc1.proyecto2.myfarm.frontend.elementos.PanelPersonalizado;
import ymcris.ipc1.proyecto2.myfarm.frontend.menu.JFMenuPrincipal;

/**
 *
 * @author YmCris
 */
public class JFCreadorDePlantas extends javax.swing.JFrame {

    // CONSTANTES --------------------------------------------------------------
    private static final String RUTA_IMAGEN = "/fondoCreadores.png";

    // INSTANCIAS --------------------------------------------------------------
    private ArchivosDeTexto archivoTxt = new ArchivosDeTexto();

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public JFCreadorDePlantas() {
        initComponents();
        this.setTitle("Creador de Plantas");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        PanelPersonalizado panel = new PanelPersonalizado(pnlFondo, RUTA_IMAGEN);
        pnlFondo.add(panel).repaint();
    }

    // MÉTODOS CONCRETOS -------------------------------------------------------
    private String verificarEntradas(String nombre, int precioSemillas, int semillasRequeridas) {
        if (nombre.isBlank()) {
            return "Debes darle un nombre a la planta";
        } else if (precioSemillas <= 0 || semillasRequeridas <= 0) {
            return "No puedes tener una cantidad menor o igual a cero";
        }
        return "";
    }

    private boolean hayErrores(String nombre, int precioSemillas, int semillasRequeridas) {
        return nombre.isBlank() || precioSemillas <= 0 || semillasRequeridas <= 0;
    }

    // CÓDIGO AUTOGENERADO -----------------------------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFondo = new javax.swing.JPanel();
        lblTitulo2 = new javax.swing.JLabel();
        lblTitulo1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnCrearPlanta = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        chbProduceFruta = new javax.swing.JCheckBox();
        spnPrecio = new javax.swing.JSpinner();
        spnSemillas = new javax.swing.JSpinner();
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
        lblTitulo1.setText("De Plantas");
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
        jLabel2.setText("Produce Fruta");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Precio Semillas");

        btnCrearPlanta.setBackground(new java.awt.Color(51, 51, 51));
        btnCrearPlanta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCrearPlanta.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearPlanta.setText("CREAR");
        btnCrearPlanta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCrearPlanta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearPlantaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Semillas Requeridas");

        chbProduceFruta.setPreferredSize(new java.awt.Dimension(25, 25));
        chbProduceFruta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbProduceFrutaActionPerformed(evt);
            }
        });

        spnPrecio.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        spnSemillas.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                        .addComponent(btnCrearPlanta, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(274, 274, 274))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                        .addComponent(btnIrAlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(211, 211, 211))))
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                                .addComponent(chbProduceFruta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(107, 107, 107))
                            .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spnPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spnSemillas, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlFondoLayout.createSequentialGroup()
                            .addGap(39, 39, 39)
                            .addComponent(lblTitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(lblTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        pnlFondoLayout.setVerticalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lblTitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(chbProduceFruta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(spnPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4))
                    .addComponent(spnSemillas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addComponent(btnCrearPlanta, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnIrAlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
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

    private void btnCrearPlantaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearPlantaActionPerformed
        String nombre = txtNombre.getText().toLowerCase();
        boolean produceFruta = chbProduceFruta.isSelected();
        int precioSemillas = (int) spnPrecio.getValue();
        int semillasRequeridas = (int) spnSemillas.getValue();
        if (hayErrores(nombre, precioSemillas, semillasRequeridas)) {
            String mensaje = verificarEntradas(nombre, precioSemillas, semillasRequeridas);
            JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                if (!archivoTxt.existeArchivo(archivoTxt.getRutaCarpetaPlantas(), nombre + ".txt")) {
                    File archivo = archivoTxt.crearArchivo(archivoTxt.getRutaCarpetaPlantas(), nombre);
                    archivoTxt.escribirEnArchivo(archivo, nombre);
                    archivoTxt.escribirEnArchivo(archivo, String.valueOf(produceFruta));
                    System.out.println("Precio semilla: " + precioSemillas);
                    archivoTxt.escribirEnArchivo(archivo, String.valueOf(precioSemillas));
                    System.out.println("Semillas requeridas: " + semillasRequeridas);
                    archivoTxt.escribirEnArchivo(archivo, String.valueOf(semillasRequeridas));
                    JOptionPane.showMessageDialog(null, "Se ha creado la planta " + nombre + " correctamente", "Nueva Planta", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No puedes crear una planta con el nombre " + nombre + " porque ya existe", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } catch (ArchivoException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_btnCrearPlantaActionPerformed

    private void chbProduceFrutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbProduceFrutaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chbProduceFrutaActionPerformed

    private void btnIrAlMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIrAlMenuActionPerformed
        this.dispose();
        new JFMenuPrincipal().setVisible(true);
    }//GEN-LAST:event_btnIrAlMenuActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearPlanta;
    private javax.swing.JButton btnIrAlMenu;
    private javax.swing.JCheckBox chbProduceFruta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblTitulo2;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JSpinner spnPrecio;
    private javax.swing.JSpinner spnSemillas;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
