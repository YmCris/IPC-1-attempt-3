package ymcris.ipc1.proyecto2.myfarm.frontend.elementos;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ymcris.ipc1.proyecto2.myfarm.frontend.juego.JFGranja;
import ymcris.ipc1.proyecto2.myfarm.backend.b.granja.Granja;
import ymcris.ipc1.proyecto2.myfarm.frontend.creadores.JFCreadorDeMateriaPrima;
import ymcris.ipc1.proyecto2.myfarm.backend.a.archivos.binarios.ArchivosBinarios;

/**
 *
 * @author crist
 */
public class JDCargarPartida extends javax.swing.JDialog {

    //
    private Granja[] partidas;
    private DefaultTableModel tablaPartidas;

    //
    ArchivosBinarios binarios = new ArchivosBinarios();

    public JDCargarPartida() {
        initComponents();
        this.setResizable(false);
        this.setTitle("Cargar Partida");
        this.setModal(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pnlFondo.add(new PanelPersonalizado(pnlFondo, JFCreadorDeMateriaPrima.RUTA_IMAGEN)).repaint();
        this.partidas = binarios.obtenerPartidas();
        agregarPartidas();
    }

    private void agregarPartidas() {
        tablaPartidas = (DefaultTableModel) tblPartidas.getModel();
        if (partidas != null) {
            for (Granja partida : partidas) {
                tablaPartidas.addRow(new Object[]{partida.getNombre(), partida.getGranjero().getNick()});
            }
            return;
        }
        JOptionPane.showMessageDialog(null, "Aún no tienes partidas guardadas", "PELIGRO", JOptionPane.WARNING_MESSAGE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFondo = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPartidas = new javax.swing.JTable();
        btnSeleccionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ANIMALES");

        tblPartidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Nick"
            }
        ));
        jScrollPane1.setViewportView(tblPartidas);
        if (tblPartidas.getColumnModel().getColumnCount() > 0) {
            tblPartidas.getColumnModel().getColumn(0).setResizable(false);
            tblPartidas.getColumnModel().getColumn(1).setResizable(false);
        }

        btnSeleccionar.setBackground(new java.awt.Color(51, 51, 51));
        btnSeleccionar.setForeground(new java.awt.Color(255, 255, 255));
        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFondoLayout = new javax.swing.GroupLayout(pnlFondo);
        pnlFondo.setLayout(pnlFondoLayout);
        pnlFondoLayout.setHorizontalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSeleccionar)
                .addGap(20, 20, 20))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        pnlFondoLayout.setVerticalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(btnSeleccionar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
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

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        if (tblPartidas.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar alguna fila", "Cargar partida", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int fila = tblPartidas.getSelectedRow();
        String nombrePartida = (String) tblPartidas.getValueAt(fila, 0);
        for (Granja partida : partidas) {
            if (partida.getNombre().equals(nombrePartida)) {
                JFGranja granjaF = new JFGranja(partida);
                Thread hiloGranaF = new Thread(granjaF);
                hiloGranaF.start();
                granjaF.setVisible(true);
                this.dispose();
            }
        }
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JTable tblPartidas;
    // End of variables declaration//GEN-END:variables
}
