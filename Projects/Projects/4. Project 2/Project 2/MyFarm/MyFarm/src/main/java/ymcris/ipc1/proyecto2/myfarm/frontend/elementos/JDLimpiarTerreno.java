package ymcris.ipc1.proyecto2.myfarm.frontend.elementos;

import javax.swing.JOptionPane;
import ymcris.ipc1.proyecto2.myfarm.backend.a.exceptions.ListaOrtogonalException;
import ymcris.ipc1.proyecto2.myfarm.backend.b.granjero.Granjero;
import ymcris.ipc1.proyecto2.myfarm.backend.b.terreno.Terreno;

/**
 *
 * @author crist
 */
public class JDLimpiarTerreno extends javax.swing.JDialog {

    private Terreno terreno;
    private Granjero granjero;

    private final String RUTA_IMAGEN = "/fondoCreadores.png";

    public JDLimpiarTerreno(Granjero granjero, Terreno terreno) {
        initComponents();
        this.terreno = terreno;
        this.granjero = granjero;
        this.setTitle("Limpiar terreno");
        this.setLocationRelativeTo(null);
        this.setModal(true);
        this.setResizable(false);
        lblPrecioCelda.setText(String.valueOf(Terreno.PRECIO_LIMPIEZA_CELDA));
        lblPrecioTerreno.setText(String.valueOf(Terreno.PRECIO_LIMPIEZA_TODO_EL_TERRENO));
        jPanel1.add(new PanelPersonalizado(jPanel1, RUTA_IMAGEN)).repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        spnFila = new javax.swing.JSpinner();
        btnLimpiarTodoElTerreno = new javax.swing.JButton();
        btnLimpiarCelda = new javax.swing.JButton();
        lblNombre = new javax.swing.JLabel();
        lblNombre1 = new javax.swing.JLabel();
        lblNombre2 = new javax.swing.JLabel();
        lblNombre3 = new javax.swing.JLabel();
        lblNombre4 = new javax.swing.JLabel();
        spnColumna = new javax.swing.JSpinner();
        lblNombre5 = new javax.swing.JLabel();
        lblNombre6 = new javax.swing.JLabel();
        lblPrecioTerreno = new javax.swing.JLabel();
        lblPrecioCelda = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        spnFila.setModel(new javax.swing.SpinnerNumberModel(0, 0, 4, 1));

        btnLimpiarTodoElTerreno.setText("LIMPIAR TODO EL TERRENO");
        btnLimpiarTodoElTerreno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarTodoElTerrenoActionPerformed(evt);
            }
        });

        btnLimpiarCelda.setText("LIMPIAR CELDA");
        btnLimpiarCelda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarCeldaActionPerformed(evt);
            }
        });

        lblNombre.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));

        lblNombre1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNombre1.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre1.setText("LIMPIAR TODO EL TERRENO");

        lblNombre2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNombre2.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre2.setText("PRECIO: ");

        lblNombre3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNombre3.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre3.setText("PRECIO: ");

        lblNombre4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNombre4.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre4.setText("LIMPIAR UNA CELDA");

        spnColumna.setModel(new javax.swing.SpinnerNumberModel(0, 0, 4, 1));

        lblNombre5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNombre5.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre5.setText("Fila");

        lblNombre6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNombre6.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre6.setText("Columna");

        lblPrecioTerreno.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblPrecioTerreno.setForeground(new java.awt.Color(255, 255, 255));
        lblPrecioTerreno.setText("PRECIO: ");

        lblPrecioCelda.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblPrecioCelda.setForeground(new java.awt.Color(255, 255, 255));
        lblPrecioCelda.setText("PRECIO: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblNombre4)
                        .addGap(72, 72, 72))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblNombre2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPrecioTerreno))
                            .addComponent(lblNombre1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblNombre3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPrecioCelda)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(btnLimpiarTodoElTerreno)
                        .addGap(78, 78, 78))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnLimpiarCelda)
                                .addGap(13, 13, 13))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblNombre5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spnFila, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblNombre6)))
                        .addGap(5, 5, 5)
                        .addComponent(spnColumna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblNombre)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(btnLimpiarTodoElTerreno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblNombre1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre2)
                            .addComponent(lblPrecioTerreno))
                        .addGap(28, 28, 28)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spnFila, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spnColumna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre5)
                            .addComponent(lblNombre6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLimpiarCelda))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblNombre4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre3)
                            .addComponent(lblPrecioCelda))))
                .addGap(66, 66, 66))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblNombre)
                    .addGap(0, 208, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarTodoElTerrenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarTodoElTerrenoActionPerformed
        if (granjero.getOro() >= Terreno.PRECIO_LIMPIEZA_TODO_EL_TERRENO) {
            terreno.limpiarTerreno();
            JOptionPane.showMessageDialog(null, "Se ha limpiado todo el terreno", "Terreno limpio", JOptionPane.INFORMATION_MESSAGE);
            granjero.setOro(granjero.getOro() - Terreno.PRECIO_LIMPIEZA_TODO_EL_TERRENO);
        } else {
            JOptionPane.showMessageDialog(null, "No tienes el dinero suficiente", "Dinerio insuficiente", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnLimpiarTodoElTerrenoActionPerformed

    private void limpiarCelda(int fila, int columna) {
        if (granjero.getOro() >= Terreno.PRECIO_LIMPIEZA_CELDA) {
            terreno.limpiarTerreno(fila, columna);
            JOptionPane.showMessageDialog(null, "Se ha limpiado la celda", "Terreno limpio", JOptionPane.INFORMATION_MESSAGE);
            granjero.setOro(granjero.getOro() - Terreno.PRECIO_LIMPIEZA_CELDA);
        } else {
            JOptionPane.showMessageDialog(null, "No tienes el dinero suficiente", "Dinerio insuficiente", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void btnLimpiarCeldaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarCeldaActionPerformed
        int fila = (int) spnFila.getValue();
        int columna = (int) spnColumna.getValue();
        try {
            if (terreno.getTablero().obtenerNodo(fila, columna).getSuelo().estaSucio()) {
                limpiarCelda(fila, columna);
            } else {
                JOptionPane.showMessageDialog(null, "La celda está limpia", "Limpieza innecesaria", JOptionPane.WARNING_MESSAGE);
            }
        } catch (ListaOrtogonalException ex) {
            System.out.println("Hubo un error al limpiar la celda [" + fila + "," + columna + "] porque " + ex.getMessage());
        }
    }//GEN-LAST:event_btnLimpiarCeldaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpiarCelda;
    private javax.swing.JButton btnLimpiarTodoElTerreno;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JLabel lblNombre2;
    private javax.swing.JLabel lblNombre3;
    private javax.swing.JLabel lblNombre4;
    private javax.swing.JLabel lblNombre5;
    private javax.swing.JLabel lblNombre6;
    private javax.swing.JLabel lblPrecioCelda;
    private javax.swing.JLabel lblPrecioTerreno;
    private javax.swing.JSpinner spnColumna;
    private javax.swing.JSpinner spnFila;
    // End of variables declaration//GEN-END:variables
}
