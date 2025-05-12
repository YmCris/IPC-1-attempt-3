package ymcris.ipc1.proyecto2.myfarm.frontend.elementos;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ymcris.ipc1.proyecto2.myfarm.backend.b.granjero.Granjero;
import ymcris.ipc1.proyecto2.myfarm.backend.c.animales.Animales;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Alimentos;
import ymcris.ipc1.proyecto2.myfarm.frontend.creadores.JFCreadorDeMateriaPrima;

/**
 *
 * @author crist
 */
public class JDElegirAlimentoParaAnimal extends javax.swing.JDialog {
    
    private Granjero granjero;
    private Animales animalAAlimentar;
    private Alimentos[] alimentosParaAnimales;
    private DefaultTableModel tablaAlimentos;
    
    public JDElegirAlimentoParaAnimal(Alimentos[] alimentosParaAnimales, Animales animalAAlimentar, Granjero granjero) {
        initComponents();
        this.granjero = granjero;
        this.alimentosParaAnimales = alimentosParaAnimales;
        this.animalAAlimentar = animalAAlimentar;
        this.setLocationRelativeTo(null);
        this.setTitle("Elegir alimento para animales");
        this.setResizable(false);
        this.setModal(true);
        pnlFondo.add(new PanelPersonalizado(pnlFondo, JFCreadorDeMateriaPrima.RUTA_IMAGEN));
        agregarAlimentos();
    }
    
    private void agregarAlimentos() {
        tablaAlimentos = (DefaultTableModel) tblAlimentosAnimales.getModel();
        if (animalAAlimentar.esHerbivoro() == false) {//es omnivoro
            System.out.println("Animal es omnivoro");
            for (Alimentos alimento : alimentosParaAnimales) {
                if (alimento.esParaHerbivoros() == true) {
                    tablaAlimentos.addRow(new Object[]{alimento.getNombre(), alimento.getCantidad(), alimento.esParaHerbivoros()});
                }
            }
        } else {//es herbivoro
            System.out.println("Animal es herbivoro");
            for (Alimentos alimento : alimentosParaAnimales) {
                if (alimento.esParaHerbivoros() == false) {//animalAAlimentar.esHerbivoro() == false
                    tablaAlimentos.addRow(new Object[]{alimento.getNombre(), alimento.getCantidad(), alimento.esParaHerbivoros()});
                }
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFondo = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAlimentosAnimales = new javax.swing.JTable();
        btnSeleccionar = new javax.swing.JButton();
        spnCantidad = new javax.swing.JSpinner();
        lblAlimentos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblAlimentosAnimales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Cantidad", "Es para Omnivoros"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
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
        jScrollPane1.setViewportView(tblAlimentosAnimales);
        if (tblAlimentosAnimales.getColumnModel().getColumnCount() > 0) {
            tblAlimentosAnimales.getColumnModel().getColumn(0).setResizable(false);
            tblAlimentosAnimales.getColumnModel().getColumn(2).setResizable(false);
        }

        btnSeleccionar.setBackground(new java.awt.Color(51, 51, 51));
        btnSeleccionar.setForeground(new java.awt.Color(255, 255, 255));
        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        spnCantidad.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        lblAlimentos.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblAlimentos.setForeground(new java.awt.Color(255, 255, 255));
        lblAlimentos.setText("ALIMENTOS:");

        javax.swing.GroupLayout pnlFondoLayout = new javax.swing.GroupLayout(pnlFondo);
        pnlFondo.setLayout(pnlFondoLayout);
        pnlFondoLayout.setHorizontalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(lblAlimentos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(spnCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        pnlFondoLayout.setVerticalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(spnCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblAlimentos, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        if (tblAlimentosAnimales.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar alguna fila en la tabla de alimentos", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int fila = tblAlimentosAnimales.getSelectedRow();
        int cantidad = (int) spnCantidad.getValue();
        String nombreAlimento = (String) tblAlimentosAnimales.getValueAt(fila, 0);
        if (granjero.tieneAlimentoDeAnimalSuficiente(nombreAlimento, cantidad)) {
            granjero.quitarCantidadAlimentoParaAnimales(nombreAlimento, cantidad);
            animalAAlimentar.setCantidadDeAlimentoConsumido(animalAAlimentar.getCantidadDeAlimentoConsumido() + cantidad);
            animalAAlimentar.setHaComido(true);
            JOptionPane.showMessageDialog(null, "Se ha alimentado al animal correctamente", "Animal alimentado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No tienes el alimento suficiente", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSeleccionarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAlimentos;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JSpinner spnCantidad;
    private javax.swing.JTable tblAlimentosAnimales;
    // End of variables declaration//GEN-END:variables
}
