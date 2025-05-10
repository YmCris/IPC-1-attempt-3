package ymcris.ipc1.proyecto2.myfarm.frontend.juego;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ymcris.ipc1.proyecto2.myfarm.backend.b.granja.Bodega;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Alimentos;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.MateriasPrimas;
import ymcris.ipc1.proyecto2.myfarm.frontend.elementos.PanelPersonalizado;

/**
 *
 * @author YmCris
 */
public class JDBodega extends javax.swing.JDialog {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private Bodega bodega;
    private DefaultTableModel tablaMateria;
    private DefaultTableModel tablaAlimentos;

    // CONSTANTES --------------------------------------------------------------
    private final static String RUTA_IMAGEN = "/fondoCreadores.png";

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public JDBodega(Bodega bodega) {
        initComponents();
        this.bodega = bodega;
        bodega.setAlimentos(bodega.getGranjero().obtenerAlimentosDeAnimalesDelGranjero());
        bodega.setMaterias(bodega.getGranjero().obtenerMateriaDelGranjero());
        this.setTitle("Bodega");
        this.setModal(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.tablaAlimentos = (DefaultTableModel) tblAlimentos.getModel();
        this.tablaMateria = (DefaultTableModel) tblMateriaPrima.getModel();
        pnlFondo.add(new PanelPersonalizado(pnlFondo, RUTA_IMAGEN)).repaint();
        agregarAlimentos();
        agregarMateria();
    }

    // MÉTODOS CONCRETOS -------------------------------------------------------
    private void agregarAlimentos() {
        Alimentos[] alimentos = bodega.getAlimentos();
        for (Alimentos alimento : alimentos) {
            tablaAlimentos.addRow(new Object[]{alimento.getNombre(), alimento.getPrecioDeVenta(), alimento.getPrecioDeCompra(), alimento.esParaHerbivoros()});
        }
    }

    private void agregarMateria() {
        MateriasPrimas[] materiaPrima = bodega.getMaterias();
        for (MateriasPrimas materia : materiaPrima) {
            tablaMateria.addRow(new Object[]{materia.getNombre(), materia.getPrecioDeVenta(), materia.getPrecioDeCompra()});
        }
    }

    // CÓDIGO AUTOGENERADO -----------------------------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFondo = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAlimentos = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblMateriaPrima = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnComer = new javax.swing.JButton();
        btnAgregarMercadoAlimento = new javax.swing.JButton();
        btnAgregarMercadoMateria = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblAlimentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Cantidad", "Porcentaje de producción", "Es para Herbivoros"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Boolean.class
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
        jScrollPane1.setViewportView(tblAlimentos);
        if (tblAlimentos.getColumnModel().getColumnCount() > 0) {
            tblAlimentos.getColumnModel().getColumn(0).setResizable(false);
            tblAlimentos.getColumnModel().getColumn(1).setResizable(false);
            tblAlimentos.getColumnModel().getColumn(2).setResizable(false);
            tblAlimentos.getColumnModel().getColumn(3).setResizable(false);
        }

        tblMateriaPrima.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Cantidad", "Porcentaje de producción"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblMateriaPrima);
        if (tblMateriaPrima.getColumnModel().getColumnCount() > 0) {
            tblMateriaPrima.getColumnModel().getColumn(0).setResizable(false);
            tblMateriaPrima.getColumnModel().getColumn(1).setResizable(false);
            tblMateriaPrima.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ALIMENTOS");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("MATERIA PRIMA");

        btnComer.setText("Comer");
        btnComer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComerActionPerformed(evt);
            }
        });

        btnAgregarMercadoAlimento.setText("Agregar al Mercado");
        btnAgregarMercadoAlimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarMercadoAlimentoActionPerformed(evt);
            }
        });

        btnAgregarMercadoMateria.setText("Agregar al Mercado");
        btnAgregarMercadoMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarMercadoMateriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFondoLayout = new javax.swing.GroupLayout(pnlFondo);
        pnlFondo.setLayout(pnlFondoLayout);
        pnlFondoLayout.setHorizontalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
            .addComponent(jScrollPane1)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnComer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAgregarMercadoAlimento)
                        .addGap(295, 295, 295)
                        .addComponent(jLabel5))
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(btnAgregarMercadoMateria)
                        .addGap(349, 349, 349)
                        .addComponent(jLabel6)))
                .addContainerGap(505, Short.MAX_VALUE))
        );
        pnlFondoLayout.setVerticalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(btnComer)
                    .addComponent(btnAgregarMercadoAlimento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(btnAgregarMercadoMateria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void btnComerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComerActionPerformed
        if (tblAlimentos.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar alguna fila en la tabla de alimentos", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            int fila = tblAlimentos.getSelectedRow();
            String nombreAlimento = (String) tblAlimentos.getValueAt(fila, 0);
            bodega.getGranjero().comer(nombreAlimento);
            tablaAlimentos.removeRow(tblAlimentos.getSelectedRow());
        }
    }//GEN-LAST:event_btnComerActionPerformed

    private void btnAgregarMercadoAlimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarMercadoAlimentoActionPerformed
        if (tblAlimentos.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar alguna fila en la tabla de alimentos", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            tablaAlimentos.removeRow(tblAlimentos.getSelectedRow());
        }
    }//GEN-LAST:event_btnAgregarMercadoAlimentoActionPerformed

    private void btnAgregarMercadoMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarMercadoMateriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarMercadoMateriaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarMercadoAlimento;
    private javax.swing.JButton btnAgregarMercadoMateria;
    private javax.swing.JButton btnComer;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JTable tblAlimentos;
    private javax.swing.JTable tblMateriaPrima;
    // End of variables declaration//GEN-END:variables
}
