package ymcris.ipc1.proyecto2.myfarm.frontend.creadores;

import javax.swing.JOptionPane;
import ymcris.ipc1.proyecto2.myfarm.backend.b.granjero.Granjero;
import ymcris.ipc1.proyecto2.myfarm.backend.c.animales.Animales;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Alimentos;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.MateriasPrimas;

/**
 *
 * @author crist
 */
public class JDElegirProduccion extends javax.swing.JDialog {

    private Animales animal;
    private Granjero granjero;

    public JDElegirProduccion(Animales animal, Granjero granjero) {
        initComponents();
        this.animal = animal;
        this.granjero = granjero;
        this.setLocationRelativeTo(null);
        this.setModal(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnDestace = new javax.swing.JButton();
        btnSinDestace = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnDestace.setText("PRODUCIR ANIMAL CON DESTACE");
        btnDestace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDestaceActionPerformed(evt);
            }
        });

        btnSinDestace.setText("PRODUCIR ANIMAL SIN DESTACE");
        btnSinDestace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSinDestaceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDestace)
                    .addComponent(btnSinDestace))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(btnDestace)
                .addGap(40, 40, 40)
                .addComponent(btnSinDestace)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDestaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDestaceActionPerformed
        if (animal == null) {
            JOptionPane.showMessageDialog(null, "No hay ningún animal criandose", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!animal.produciraProductosConDestace()) {
            JOptionPane.showMessageDialog(null, "El animal no produce productos con destace", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        MateriasPrimas[] materias = animal.producirMateriaPrima();
        for (MateriasPrimas materia : materias) {
            granjero.getMaterias().agregar(materia, materia.getNombre());
        }
        btnDestace.setEnabled(false);
        animal.setHiloTerminado(true);
    }//GEN-LAST:event_btnDestaceActionPerformed

    private void btnSinDestaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSinDestaceActionPerformed
        if (animal == null) {
            JOptionPane.showMessageDialog(null, "No hay ningún animal criandose", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Alimentos[] alimentos = animal.producirAlimentos();
        for (Alimentos alimento : alimentos) {
            granjero.agregarCantidadAAlimento(alimento, alimento.getProduccion());
        }
        btnSinDestace.setEnabled(false);
        animal.setHiloTerminado(true);
    }//GEN-LAST:event_btnSinDestaceActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDestace;
    private javax.swing.JButton btnSinDestace;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
