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
public class JFCreadorDeAnimales extends javax.swing.JFrame {

    // CONSTANTES --------------------------------------------------------------
    private final static String RUTA_IMAGEN = "/fondoCreadores.png";

    // INSTANCIAS --------------------------------------------------------------
    private ArchivosDeTexto archivo = new ArchivosDeTexto();

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public JFCreadorDeAnimales() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        PanelPersonalizado panel = new PanelPersonalizado(pnlFondo, RUTA_IMAGEN);
        pnlFondo.add(panel).repaint();
        cbProduciraProductosConDestace.setEnabled(false);
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnCrearAnimal = new javax.swing.JButton();
        btnIrAlMenu = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        cbEsHerbivoro = new javax.swing.JCheckBox();
        cbEsDestazable = new javax.swing.JCheckBox();
        cbProduciraProductosConDestace = new javax.swing.JCheckBox();
        spnPrecio = new javax.swing.JSpinner();
        spnEspacio = new javax.swing.JSpinner();

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
        lblTitulo1.setText("De Animales");
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
        jLabel2.setText("Precio");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Espacio en Parcela");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Es Herbivoro");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Es Destazable");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Producirá productos con destace");

        btnCrearAnimal.setBackground(new java.awt.Color(51, 51, 51));
        btnCrearAnimal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCrearAnimal.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearAnimal.setText("CREAR");
        btnCrearAnimal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCrearAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearAnimalActionPerformed(evt);
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

        cbEsHerbivoro.setPreferredSize(new java.awt.Dimension(25, 25));
        cbEsHerbivoro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEsHerbivoroActionPerformed(evt);
            }
        });

        cbEsDestazable.setPreferredSize(new java.awt.Dimension(25, 25));
        cbEsDestazable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEsDestazableActionPerformed(evt);
            }
        });

        cbProduciraProductosConDestace.setPreferredSize(new java.awt.Dimension(25, 25));
        cbProduciraProductosConDestace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProduciraProductosConDestaceActionPerformed(evt);
            }
        });

        spnPrecio.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        spnEspacio.setModel(new javax.swing.SpinnerNumberModel(0.5d, 0.5d, null, 0.5d));

        javax.swing.GroupLayout pnlFondoLayout = new javax.swing.GroupLayout(pnlFondo);
        pnlFondo.setLayout(pnlFondoLayout);
        pnlFondoLayout.setHorizontalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(lblTitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                                .addComponent(btnCrearAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63))
                            .addComponent(btnIrAlMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlFondoLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(spnPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlFondoLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(spnEspacio, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlFondoLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(pnlFondoLayout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                                        .addComponent(cbProduciraProductosConDestace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlFondoLayout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbEsDestazable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlFondoLayout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbEsHerbivoro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(66, 66, 66)))))
                .addGap(14, 14, 14))
        );
        pnlFondoLayout.setVerticalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlFondoLayout.createSequentialGroup()
                                .addComponent(lblTitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(jLabel1))
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addComponent(spnPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(spnEspacio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlFondoLayout.createSequentialGroup()
                                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(cbEsHerbivoro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5))
                            .addComponent(cbEsDestazable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6))
                    .addComponent(cbProduciraProductosConDestace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(btnCrearAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnIrAlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
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

    private void btnCrearAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearAnimalActionPerformed
        String nombre = txtNombre.getText().toLowerCase();
        int precio = (int) spnPrecio.getValue();
        double espacio = (double) spnEspacio.getValue();
        boolean esHerbivoro = cbEsHerbivoro.isSelected();
        boolean esDestazable = cbEsDestazable.isSelected();
        boolean produciraProductosConDestace = cbProduciraProductosConDestace.isSelected();
        if (nombre.isBlank()) {
            JOptionPane.showMessageDialog(null, "No puedes crear un animal con un nombre vacío", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                if (!archivo.existeArchivo(archivo.getRutaCarpetaAnimales(), nombre + ".txt")) {
                    File animal = archivo.crearArchivo(archivo.getRutaCarpetaAnimales(), nombre);
                    archivo.escribirEnArchivo(animal, nombre);
                    archivo.escribirEnArchivo(animal, String.valueOf(precio));
                    archivo.escribirEnArchivo(animal, String.valueOf(espacio));
                    archivo.escribirEnArchivo(animal, String.valueOf(esHerbivoro));
                    archivo.escribirEnArchivo(animal, String.valueOf(esDestazable));
                    archivo.escribirEnArchivo(animal, String.valueOf(produciraProductosConDestace));
                    JOptionPane.showMessageDialog(null, "Se ha creado el animal " + nombre + " correctamente", "Nuevo Animal", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No puedes crear un animal con el nombre " + nombre + " porque ya existe", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } catch (ArchivoException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnCrearAnimalActionPerformed

    private void btnIrAlMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIrAlMenuActionPerformed
        this.dispose();
        new JFMenuPrincipal().setVisible(true);
    }//GEN-LAST:event_btnIrAlMenuActionPerformed

    private void cbEsHerbivoroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEsHerbivoroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbEsHerbivoroActionPerformed

    private void cbEsDestazableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEsDestazableActionPerformed
        if (cbEsDestazable.isSelected()) {
            cbProduciraProductosConDestace.setEnabled(true);
        } else if (!cbEsDestazable.isSelected()) {
            cbProduciraProductosConDestace.setSelected(false);
            cbProduciraProductosConDestace.setEnabled(false);
        }
    }//GEN-LAST:event_cbEsDestazableActionPerformed

    private void cbProduciraProductosConDestaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProduciraProductosConDestaceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbProduciraProductosConDestaceActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearAnimal;
    private javax.swing.JButton btnIrAlMenu;
    private javax.swing.JCheckBox cbEsDestazable;
    private javax.swing.JCheckBox cbEsHerbivoro;
    private javax.swing.JCheckBox cbProduciraProductosConDestace;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblTitulo2;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JSpinner spnEspacio;
    private javax.swing.JSpinner spnPrecio;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
