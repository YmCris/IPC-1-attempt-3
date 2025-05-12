package ymcris.ipc1.proyecto2.myfarm.frontend.elementos;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ymcris.ipc1.proyecto2.myfarm.backend.b.granjero.Granjero;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Fertilizantes;
import ymcris.ipc1.proyecto2.myfarm.frontend.juego.suelos.JDGrama;

/**
 *
 * @author crist
 */
public class JDElegirFertilizante extends javax.swing.JDialog {

    private JDGrama grama;
    private Granjero granjero;
    private DefaultTableModel tablaFertilizantes;
    private Fertilizantes[] fertilizantesDelGranjero;

    // CONSTANTES --------------------------------------------------------------
    private final static String RUTA_IMAGEN = "/fondoCreadores.png";

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public JDElegirFertilizante(JDGrama grama, Granjero granjero) {
        initComponents();
        this.grama = grama;
        this.granjero = granjero;
        this.fertilizantesDelGranjero = granjero.getFertilizantes();
        this.setModal(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        pnlFondo.add(new PanelPersonalizado(pnlFondo, RUTA_IMAGEN)).repaint();
        agregarFertilizantes();
    }

    private void agregarFertilizantes() {
        tablaFertilizantes = (DefaultTableModel) tblFertilizantes.getModel();
        for (Fertilizantes fertilizante : fertilizantesDelGranjero) {
            tablaFertilizantes.addRow(new Object[]{fertilizante.getNombre(), fertilizante.getCantidad(), fertilizante.getFertilidad()});
        }
    }

    private void agregarFertilizantesASuelo() {
        if (tblFertilizantes.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar alguna fila en la tabla de fertilizantes", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int fila = tblFertilizantes.getSelectedRow();
        int cantidad = (int) spnCantidad.getValue();
        int fertilidad = (int) tblFertilizantes.getValueAt(fila, 2);
        String nombreFertilizante = (String) tblFertilizantes.getValueAt(fila, 0);
        if (granjero.tieneLosFertilizantesSuficientes(nombreFertilizante, cantidad)) {
            granjero.quitarCantidadAFertilizantes(nombreFertilizante, cantidad);
            grama.setFertilidad(fertilidad * cantidad);
            JOptionPane.showMessageDialog(null, "Has fertilizado el suelo, tus plantas te lo agradecerán", "Mejora", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No tienes los fertilizantes suficientes", ":(", JOptionPane.WARNING_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFondo = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFertilizantes = new javax.swing.JTable();
        lblAlimentos = new javax.swing.JLabel();
        btnSeleccionar = new javax.swing.JButton();
        spnCantidad = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblFertilizantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Cantidad", "Fertilidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblFertilizantes);

        lblAlimentos.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblAlimentos.setForeground(new java.awt.Color(255, 255, 255));
        lblAlimentos.setText("FERTILIZANTES:");

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

        javax.swing.GroupLayout pnlFondoLayout = new javax.swing.GroupLayout(pnlFondo);
        pnlFondo.setLayout(pnlFondoLayout);
        pnlFondoLayout.setHorizontalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lblAlimentos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(spnCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlFondoLayout.setVerticalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAlimentos, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        agregarFertilizantesASuelo();
    }//GEN-LAST:event_btnSeleccionarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAlimentos;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JSpinner spnCantidad;
    private javax.swing.JTable tblFertilizantes;
    // End of variables declaration//GEN-END:variables
}
