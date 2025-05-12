package ymcris.ipc1.proyecto2.myfarm.frontend.elementos;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ymcris.ipc1.proyecto2.myfarm.backend.a.archivos.binarios.ArchivosBinarios;
import ymcris.ipc1.proyecto2.myfarm.backend.b.terreno.Terreno;
import ymcris.ipc1.proyecto2.myfarm.backend.c.animales.Animales;

/**
 *
 * @author YmCris
 */
public class JDCrearParcela extends javax.swing.JDialog {

    private Terreno terreno;
    private String nombreAnimal;
    private Animales[] animales;
    private DefaultTableModel tablaAnimales;

    ArchivosBinarios binario = new ArchivosBinarios();
    private final String RUTA_IMAGEN = "/fondoCreadores.png";

    public JDCrearParcela(Terreno terreno) {
        initComponents();
        this.terreno = terreno;
        this.setTitle("Crear Parcela");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setModal(true);
        pnlFondo.add(new PanelPersonalizado(pnlFondo, RUTA_IMAGEN)).repaint();
        this.animales = binario.obtenerAnimales();
        agregarAnimales();
    }

    private void agregarAnimales() {
        tablaAnimales = (DefaultTableModel) tblAnimales.getModel();
        for (Animales animal : animales) {
            tablaAnimales.addRow(new Object[]{animal.getNombre(), animal.esHerbivoro(), animal.esDestazable(), animal.getEspacio()});
        }
    }

    private void seleccionarAnimal() {
        if (tblAnimales.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar alguna fila en la tabla de animales", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int fila = tblAnimales.getSelectedRow();
        nombreAnimal = (String) tblAnimales.getValueAt(fila, 0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFondo = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAnimales = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        spnFilaInicio = new javax.swing.JSpinner();
        lblNombre5 = new javax.swing.JLabel();
        lblNombre6 = new javax.swing.JLabel();
        spnColumnaInicio = new javax.swing.JSpinner();
        spnColumnaFin = new javax.swing.JSpinner();
        lblNombre7 = new javax.swing.JLabel();
        spnFilaFin = new javax.swing.JSpinner();
        lblNombre8 = new javax.swing.JLabel();
        btnSeleccionarAnimal = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnCrearParcela = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnEliminarParcela = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblAnimales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Es Herbivoro", "Es Destazable", "Espacio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblAnimales);
        if (tblAnimales.getColumnModel().getColumnCount() > 0) {
            tblAnimales.getColumnModel().getColumn(0).setResizable(false);
            tblAnimales.getColumnModel().getColumn(1).setResizable(false);
            tblAnimales.getColumnModel().getColumn(2).setResizable(false);
            tblAnimales.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CASILLA SUPERIOR IZQUIERDA");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("CASILLA INFERIOR DERECHA");

        spnFilaInicio.setModel(new javax.swing.SpinnerNumberModel(0, 0, 4, 1));

        lblNombre5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNombre5.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre5.setText("Fila");

        lblNombre6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNombre6.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre6.setText("Columna");

        spnColumnaInicio.setModel(new javax.swing.SpinnerNumberModel(0, 0, 4, 1));

        spnColumnaFin.setModel(new javax.swing.SpinnerNumberModel(0, 0, 4, 1));

        lblNombre7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNombre7.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre7.setText("Columna");

        spnFilaFin.setModel(new javax.swing.SpinnerNumberModel(0, 0, 4, 1));

        lblNombre8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNombre8.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre8.setText("Fila");

        btnSeleccionarAnimal.setText("SELECCIONAR TIPO DE ANIMAL");
        btnSeleccionarAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarAnimalActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ANIMALES");

        btnCrearParcela.setText("CREAR PARCELA");
        btnCrearParcela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearParcelaActionPerformed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(51, 51, 51));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnEliminarParcela.setText("ELIMINAR PARCELA");
        btnEliminarParcela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarParcelaActionPerformed(evt);
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
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(10, 10, 10))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                                .addComponent(lblNombre6)
                                .addGap(5, 5, 5)
                                .addComponent(spnColumnaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                                                .addComponent(lblNombre5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(spnFilaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(pnlFondoLayout.createSequentialGroup()
                                                .addComponent(lblNombre8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(spnFilaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblNombre7))
                                    .addComponent(btnCrearParcela, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(5, 5, 5)
                                .addComponent(spnColumnaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                        .addComponent(btnEliminarParcela)
                        .addGap(66, 66, 66)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(149, 149, 149)
                        .addComponent(btnSeleccionarAnimal)
                        .addContainerGap())))
        );
        pnlFondoLayout.setVerticalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spnColumnaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre6))
                        .addGap(76, 76, 76)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spnColumnaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre7)))
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spnFilaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre5))
                        .addGap(113, 113, 113)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spnFilaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre8))))
                .addGap(29, 29, 29)
                .addComponent(btnCrearParcela)
                .addGap(18, 18, 18)
                .addComponent(btnEliminarParcela)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1)
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlFondoLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel3))
                            .addGroup(pnlFondoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnSeleccionarAnimal)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(256, 256, 256))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarAnimalActionPerformed
        seleccionarAnimal();
    }//GEN-LAST:event_btnSeleccionarAnimalActionPerformed

    private void btnCrearParcelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearParcelaActionPerformed
        int filaInicio = (int) spnFilaInicio.getValue();
        int columnaInicio = (int) spnColumnaInicio.getValue();
        int filaFin = (int) spnFilaFin.getValue();
        int columnaFin = (int) spnColumnaFin.getValue();
        if (filaFin <= filaInicio || columnaFin <= columnaInicio) {
            JOptionPane.showMessageDialog(null, "NO PUEDES HACER ESO");
            return;
        }
        if (nombreAnimal == null) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar un animal primero");
        } else {
            if (terreno.parcelaCreada(filaInicio, columnaInicio, filaFin, columnaFin, nombreAnimal)) {
                JOptionPane.showMessageDialog(null, "Se ha creado la parcela", "Nueva parcela", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se ha creado parcela porque algún suelo no es grama o algun suelo está ocupado", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnCrearParcelaActionPerformed

    private void btnEliminarParcelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarParcelaActionPerformed
        int filaInicio = (int) spnFilaInicio.getValue();
        int columnaInicio = (int) spnColumnaInicio.getValue();
        int filaFin = (int) spnFilaFin.getValue();
        int columnaFin = (int) spnColumnaFin.getValue();
        if (filaFin <= filaInicio || columnaFin <= columnaInicio) {
            JOptionPane.showMessageDialog(null, "NO PUEDES HACER ESO");
            return;
        }
        if (nombreAnimal == null) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar un animal primero");
        } else {
            if (terreno.parcelaEliminada(filaInicio, columnaInicio, filaFin, columnaFin, nombreAnimal)) {
                JOptionPane.showMessageDialog(null, "Se ha eliminado la parcela", "Parcela eliminada", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se ha eliminar la parcela verifica que no esté ocupada o que exista", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnEliminarParcelaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearParcela;
    private javax.swing.JButton btnEliminarParcela;
    private javax.swing.JButton btnSeleccionarAnimal;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblNombre5;
    private javax.swing.JLabel lblNombre6;
    private javax.swing.JLabel lblNombre7;
    private javax.swing.JLabel lblNombre8;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JSpinner spnColumnaFin;
    private javax.swing.JSpinner spnColumnaInicio;
    private javax.swing.JSpinner spnFilaFin;
    private javax.swing.JSpinner spnFilaInicio;
    private javax.swing.JTable tblAnimales;
    // End of variables declaration//GEN-END:variables
}
