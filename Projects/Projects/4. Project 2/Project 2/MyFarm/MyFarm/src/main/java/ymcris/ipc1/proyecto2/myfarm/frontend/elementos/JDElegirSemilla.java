package ymcris.ipc1.proyecto2.myfarm.frontend.elementos;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ymcris.ipc1.proyecto2.myfarm.backend.a.archivos.binarios.ArchivosBinarios;
import ymcris.ipc1.proyecto2.myfarm.backend.a.exceptions.ListaDobleException;
import ymcris.ipc1.proyecto2.myfarm.backend.b.granjero.Granjero;
import ymcris.ipc1.proyecto2.myfarm.backend.c.plantas.Semillas;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Alimentos;
import ymcris.ipc1.proyecto2.myfarm.frontend.juego.suelos.JDGrama;

/**
 *
 * @author crist
 */
public class JDElegirSemilla extends javax.swing.JDialog {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private JDGrama dialog;
    private Granjero granjero;
    private Semillas[] semillas;
    private DefaultTableModel tablaSemillas;

    // INSTANCIAS --------------------------------------------------------------
    ArchivosBinarios binario = new ArchivosBinarios();

    // CONSTANTES --------------------------------------------------------------
    private final static String RUTA_IMAGEN = "/fondoCreadores.png";

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public JDElegirSemilla(JDGrama dialog, Granjero granjero) {
        initComponents();
        this.dialog = dialog;
        this.granjero = granjero;
        this.setModal(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Elegir semilla");
        this.semillas = granjero.obtenerSemillasDelGranjero();
        pnlFondo.add(new PanelPersonalizado(pnlFondo, RUTA_IMAGEN)).repaint();
        agregarSemillas();
    }

    private void agregarSemillas() {
        tablaSemillas = (DefaultTableModel) tblSemillas.getModel();
        for (Semillas semilla : semillas) {
            tablaSemillas.addRow(new Object[]{semilla.getNombre(), semilla.getAlimento().getNombre(), semilla.getCantidad(), semilla.getCantidadDeSemillasRequerida(), semilla.produceFruta()});
        }
    }

    private void seleccionarSemilla() {
        if (tblSemillas.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar alguna fila en la tabla de alimentos", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int fila = tblSemillas.getSelectedRow();
        int cantidadDeSemillasRequeridas = (int) tblSemillas.getValueAt(fila, 3);
        String nombreSemilla = (String) tblSemillas.getValueAt(fila, 0);
        if (!granjero.tieneLasSemillasSuficientes(nombreSemilla, cantidadDeSemillasRequeridas)) {
            JOptionPane.showMessageDialog(null, "No tienes las suficientes semillas para sembrar esta planta, compra las semillas en la tienda y regresa", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Semillas semilla = (Semillas) binario.obtenerObjeto(binario.getRutaCarpetaSemillas(), nombreSemilla);
        Alimentos alimento = semilla.getAlimento();
        alimento.setProduccion(100);
        alimento.setCantidad(1);
        semilla.setAlimento(alimento);
        granjero.quitarCantidadASemilla(nombreSemilla, cantidadDeSemillasRequeridas);
        try {
            granjero.getAlimentos().existeNodoConContenido(alimento.getNombre());
        } catch (ListaDobleException e) {
            granjero.getAlimentos().agregar(alimento, alimento.getNombre());
            System.out.println("Error al seleccionar la semilla " + e.getMessage());
        }
        dialog.setSemillaAPlantar(semilla);
        this.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFondo = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSemillas = new javax.swing.JTable();
        lblAlimentos = new javax.swing.JLabel();
        btnSeleccionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblSemillas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Alimento Producido", "Semillas obtenidas", "Semillas requeridas", "Produce fruta"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblSemillas);

        lblAlimentos.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblAlimentos.setForeground(new java.awt.Color(255, 255, 255));
        lblAlimentos.setText("SEMILLAS:");

        btnSeleccionar.setBackground(new java.awt.Color(51, 51, 51));
        btnSeleccionar.setForeground(new java.awt.Color(255, 255, 255));
        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFondoLayout = new javax.swing.GroupLayout(pnlFondo);
        pnlFondo.setLayout(pnlFondoLayout);
        pnlFondoLayout.setHorizontalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAlimentos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlFondoLayout.setVerticalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblAlimentos, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnSeleccionar, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        seleccionarSemilla();
    }//GEN-LAST:event_btnSeleccionarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAlimentos;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JTable tblSemillas;
    // End of variables declaration//GEN-END:variables

}
