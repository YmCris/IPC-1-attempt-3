package ymcris.ipc1.proyecto2.myfarm.frontend.creadores;

import static java.awt.image.ImageObserver.HEIGHT;
import static java.awt.image.ImageObserver.PROPERTIES;
import javax.swing.JOptionPane;
import ymcris.ipc1.proyecto2.myfarm.backend.a.archivos.binarios.ArchivosBinarios;
import ymcris.ipc1.proyecto2.myfarm.backend.a.archivos.texto.Archivos;
import ymcris.ipc1.proyecto2.myfarm.backend.c.animales.Animales;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Alimentos;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.MateriasPrimas;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Productos;
import ymcris.ipc1.proyecto2.myfarm.frontend.elementos.PanelPersonalizado;
import ymcris.ipc1.proyecto2.myfarm.frontend.menu.JFMenuPrincipal;

/**
 *
 * @author YmCris
 */
public class JFEditoDeAnimales extends javax.swing.JFrame {

    // CONSTANTES --------------------------------------------------------------
    private static final String RUTA_IMAGEN = "/fondoCreadores.png";

    // INSTANCIAS --------------------------------------------------------------
    ArchivosBinarios binario = new ArchivosBinarios();
    Archivos archivo = new Archivos();

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public JFEditoDeAnimales() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Editor de animales");
        pnlFondo.add(new PanelPersonalizado(pnlFondo, RUTA_IMAGEN)).repaint();
        agregarAnimales();
    }
    
    private void agregarAnimales() {
        Animales[] animales = binario.obtenerAnimales();
        for (Animales animal : animales) {
            cbAnimal.addItem(animal.getNombre());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFondo = new javax.swing.JPanel();
        lblTitulo2 = new javax.swing.JLabel();
        lblTitulo3 = new javax.swing.JLabel();
        cbAnimal = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        spnPorcentajeProducción = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbProductos = new javax.swing.JComboBox<>();
        btnCrearPlanta = new javax.swing.JButton();
        btnIrAlMenu = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        chbSeObtieneAlDestazar = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo2.setBackground(java.awt.SystemColor.activeCaptionText);
        lblTitulo2.setFont(new java.awt.Font("Snap ITC", 1, 100)); // NOI18N
        lblTitulo2.setForeground(new java.awt.Color(51, 51, 51));
        lblTitulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo2.setText("Animales");
        lblTitulo2.setToolTipText("");
        lblTitulo2.setMaximumSize(new java.awt.Dimension(300, 300));
        lblTitulo2.setMinimumSize(new java.awt.Dimension(300, 300));
        lblTitulo2.setName(""); // NOI18N
        lblTitulo2.setPreferredSize(new java.awt.Dimension(300, 300));

        lblTitulo3.setBackground(java.awt.SystemColor.activeCaptionText);
        lblTitulo3.setFont(new java.awt.Font("Snap ITC", 1, 100)); // NOI18N
        lblTitulo3.setForeground(new java.awt.Color(51, 51, 51));
        lblTitulo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo3.setText("Editor de");
        lblTitulo3.setToolTipText("");
        lblTitulo3.setMaximumSize(new java.awt.Dimension(300, 300));
        lblTitulo3.setMinimumSize(new java.awt.Dimension(300, 300));
        lblTitulo3.setName(""); // NOI18N
        lblTitulo3.setPreferredSize(new java.awt.Dimension(300, 300));

        cbAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAnimalActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Animal");

        spnPorcentajeProducción.setModel(new javax.swing.SpinnerNumberModel(10, 10, null, 5));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("% de producción");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Producto");

        cbProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProductosActionPerformed(evt);
            }
        });

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

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("El producto se obtiene al destazar");

        chbSeObtieneAlDestazar.setPreferredSize(new java.awt.Dimension(25, 25));
        chbSeObtieneAlDestazar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbSeObtieneAlDestazarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFondoLayout = new javax.swing.GroupLayout(pnlFondo);
        pnlFondo.setLayout(pnlFondoLayout);
        pnlFondoLayout.setHorizontalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel2)
                        .addGap(111, 111, 111)
                        .addComponent(jLabel3))
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addComponent(jLabel4))
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGap(215, 215, 215)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbProductos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnPorcentajeProducción, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbAnimal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63))
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                        .addComponent(btnCrearPlanta, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63))
                    .addComponent(btnIrAlMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel6)
                .addGap(142, 142, 142)
                .addComponent(chbSeObtieneAlDestazar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(160, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitulo3, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(146, 146, 146))
        );
        pnlFondoLayout.setVerticalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(lblTitulo3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbAnimal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                        .addComponent(chbSeObtieneAlDestazar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addGap(27, 27, 27)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spnPorcentajeProducción, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(38, 38, 38)))
                .addComponent(btnCrearPlanta, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnIrAlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
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

    private void cbAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAnimalActionPerformed
    }//GEN-LAST:event_cbAnimalActionPerformed

    private void cbProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProductosActionPerformed
    }//GEN-LAST:event_cbProductosActionPerformed

    private void btnCrearPlantaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearPlantaActionPerformed
        String nombreAnimal = (String) cbAnimal.getSelectedItem();
        String nombreProducto = (String) cbProductos.getSelectedItem();
        int porcentajeDeProduccion = (int) spnPorcentajeProducción.getValue();
        boolean esConDestace = chbSeObtieneAlDestazar.isSelected();
        if (nombreProducto == null || nombreAnimal.isBlank()) {
            JOptionPane.showMessageDialog(null, "Debes agregar algún producto, primero define si el producto será con destace o no", "Erero", JOptionPane.ERROR_MESSAGE);
        } else {
            Animales animal = (Animales) binario.obtenerObjeto(binario.getRutaCarpetaAnimales(), nombreAnimal);
            if (animal.getPorcentajeDeProduccionConDestaze() + porcentajeDeProduccion < 100 || animal.getPorcentajeDeProduccionSinDestaze() + porcentajeDeProduccion < 100) {
                Productos producto;
                if (archivo.existeArchivo(binario.getRutaCarpetaMateriaPrima(), nombreProducto + ".bin")) {
                    producto = (Productos) binario.obtenerObjeto(binario.getRutaCarpetaMateriaPrima(), nombreProducto);
                    producto.setProduccion(porcentajeDeProduccion);
                    String mensaje = binario.editarAnimal(animal, producto, esConDestace);
                    JOptionPane.showMessageDialog(null, mensaje, "Animal Modificado", JOptionPane.INFORMATION_MESSAGE);
                } else if (archivo.existeArchivo(binario.getRutaCarpetaAlimentos(), nombreProducto + ".bin")) {
                    producto = (Productos) binario.obtenerObjeto(binario.getRutaCarpetaAlimentos(), nombreProducto);
                    String mensaje = binario.editarAnimal(animal, producto, esConDestace);
                    JOptionPane.showMessageDialog(null, mensaje, "Animal Modificado", JOptionPane.INFORMATION_MESSAGE);
                }
                System.out.println("Terminado");
            } else {
                JOptionPane.showMessageDialog(null, "No puedes agregar ese producto al animal porque sobrepasa el límite de producción, el animal tiene una producción con destace del " + animal.getPorcentajeDeProduccionConDestaze() + " % y una producción sin destace del " + animal.getPorcentajeDeProduccionSinDestaze() + " %", "Animal sobreexplotado", JOptionPane.WARNING_MESSAGE);
            }
            
        }
    }//GEN-LAST:event_btnCrearPlantaActionPerformed

    private void btnIrAlMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIrAlMenuActionPerformed
        this.dispose();
        new JFMenuPrincipal().setVisible(true);
    }//GEN-LAST:event_btnIrAlMenuActionPerformed

    private void chbSeObtieneAlDestazarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbSeObtieneAlDestazarActionPerformed
        if (chbSeObtieneAlDestazar.isSelected()) {
            cbProductos.removeAllItems();
            MateriasPrimas[] materias = binario.obtenerMaterias();
            for (MateriasPrimas materia : materias) {
                cbProductos.addItem(materia.getNombre());
            }
        } else {
            cbProductos.removeAllItems();
            Alimentos[] alimentos = binario.obtenerAlimentos();
            for (Alimentos alimento : alimentos) {
                cbProductos.addItem(alimento.getNombre());
            }
        }
    }//GEN-LAST:event_chbSeObtieneAlDestazarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearPlanta;
    private javax.swing.JButton btnIrAlMenu;
    private javax.swing.JComboBox<String> cbAnimal;
    private javax.swing.JComboBox<String> cbProductos;
    private javax.swing.JCheckBox chbSeObtieneAlDestazar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblTitulo2;
    private javax.swing.JLabel lblTitulo3;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JSpinner spnPorcentajeProducción;
    // End of variables declaration//GEN-END:variables

}
