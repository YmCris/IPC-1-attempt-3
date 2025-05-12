package ymcris.ipc1.proyecto2.myfarm.frontend.juego;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ymcris.ipc1.proyecto2.myfarm.backend.b.granja.Mercado;
import ymcris.ipc1.proyecto2.myfarm.backend.c.plantas.Semillas;
import ymcris.ipc1.proyecto2.myfarm.backend.c.animales.Animales;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Alimentos;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Fertilizantes;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.MateriasPrimas;
import ymcris.ipc1.proyecto2.myfarm.frontend.elementos.PanelPersonalizado;

/**
 *
 * @author YmCris
 */
public class JDMercado extends javax.swing.JDialog {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private Mercado mercado;
    private DefaultTableModel tblFertilizantes;
    private DefaultTableModel tblComprarAlimentos;
    private DefaultTableModel tblComprarSemillas;
    private DefaultTableModel tblComprarAnimales;
    private DefaultTableModel tblVenderAlimentos;
    private DefaultTableModel tblVenderMateria;

    // CONSTANTES --------------------------------------------------------------
    private static final String RUTA_IMAGEN = "/fondoCreadores.png";

    public JDMercado(Mercado mercado) {
        initComponents();
        this.mercado = mercado;
        this.mercado.setAlimentosGranjero(mercado.getGranjero().obtenerAlimentosDeAnimalesDelGranjero());
        this.mercado.setMateriasGranjero(mercado.getGranjero().obtenerMateriaDelGranjero());
        this.setModal(true);
        this.setResizable(false);
        this.setTitle("Mercado");
        this.setLocationRelativeTo(null);
        pnlFondo.add(new PanelPersonalizado(pnlFondo, RUTA_IMAGEN)).repaint();
        agregarFertilizantes();
        agregarAlimentos();
        agregarSemillas();
        agregarAnimales();
        agregarAlimentosAVender();
        agregarMaretiaAVender();
    }

    private void agregarAlimentosAVender() {
        tblVenderAlimentos = (DefaultTableModel) tblVAlimentos.getModel();
        Alimentos[] alimentosAVender = mercado.getAlimentosGranjero();
        for (Alimentos alimento : alimentosAVender) {
            tblVenderAlimentos.addRow(new Object[]{alimento.getNombre(), alimento.getPrecioDeVenta()});
        }
    }

    private void agregarMaretiaAVender() {
        tblVenderMateria = (DefaultTableModel) tblVMateria.getModel();
        MateriasPrimas[] materiasAVender = mercado.getMateriasGranjero();
        for (MateriasPrimas materias : materiasAVender) {
            tblVenderMateria.addRow(new Object[]{materias.getNombre(), materias.getPrecioDeVenta()});
        }
    }

    private void agregarFertilizantes() {
        tblFertilizantes = (DefaultTableModel) tblCFertilizantes.getModel();
        Fertilizantes[] fertilizantes = mercado.getFertilizantes();
        for (Fertilizantes fertilizante : fertilizantes) {
            tblFertilizantes.addRow(new Object[]{fertilizante.getNombre(), fertilizante.getFertilidad(), fertilizante.getPrecio()});
        }
    }

    private void agregarAlimentos() {
        tblComprarAlimentos = (DefaultTableModel) tblCAlimento.getModel();
        Alimentos[] alimentos = mercado.getAlimentosParaAnimales();
        for (Alimentos alimento : alimentos) {
            tblComprarAlimentos.addRow(new Object[]{alimento.getNombre(), alimento.getPrecioDeVenta(), alimento.esParaHerbivoros()});
        }
    }

    private void agregarSemillas() {
        tblComprarSemillas = (DefaultTableModel) tblCSemillas.getModel();
        Semillas[] semillas = mercado.getSemillas();
        for (Semillas semilla : semillas) {
            tblComprarSemillas.addRow(new Object[]{semilla.getNombre(), semilla.getPrecio(), semilla.produceFruta(), semilla.getCantidadDeSemillasRequerida(), semilla.getAlimento().getNombre()});
        }
    }

    private void agregarAnimales() {
        tblComprarAnimales = (DefaultTableModel) tblCAnimales.getModel();
        Animales[] animales = mercado.getAnimales();
        for (Animales animal : animales) {
            tblComprarAnimales.addRow(new Object[]{animal.getNombre(), animal.getPrecio(), animal.getEspacio(), animal.getEdadMaxima(), animal.isEsHerbivoro(), animal.isEsDestazable(), animal.getProductosDestazables().length(), animal.getProductosNoDestazables().length()});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFondo = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVAlimentos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVMateria = new javax.swing.JTable();
        btnVenderAlimentos = new javax.swing.JButton();
        btnVenderMateriaPrima = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCSemillas = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblCAnimales = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblCFertilizantes = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblCAlimento = new javax.swing.JTable();
        btnComprarSemillas = new javax.swing.JButton();
        btnComprarAnimales = new javax.swing.JButton();
        btnComprarFertilizantes = new javax.swing.JButton();
        btnComprarAlimentoParaAnimales = new javax.swing.JButton();
        spnCantidadSemillas = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("COMPRA");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("VENTA");

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));

        tblVAlimentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblVAlimentos);

        tblVMateria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblVMateria);

        btnVenderAlimentos.setText("Vender Alimentos");
        btnVenderAlimentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVenderAlimentosActionPerformed(evt);
            }
        });

        btnVenderMateriaPrima.setText("Vender Materia Prima");
        btnVenderMateriaPrima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVenderMateriaPrimaActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ALIMENTOS");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("MATERIA PRIMA");

        tblCSemillas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Precio", "Produce Fruta", "Semillas Requeridas", "Alimento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class
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
        jScrollPane3.setViewportView(tblCSemillas);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("SEMILLAS");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("ANIMALES");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("FERETILIZANTES");

        tblCAnimales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Precio", "Espacio", "Edad Máxima", "Es Herbivoro", "Es Destazable", "PCD", "PSD"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblCAnimales);

        tblCFertilizantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Fertilidad", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tblCFertilizantes);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("ALIMENTO PARA ANIMALES");

        tblCAlimento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Precio", "Es Para Herbivoros"
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
        jScrollPane6.setViewportView(tblCAlimento);

        btnComprarSemillas.setText("Comprar Semillas");
        btnComprarSemillas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarSemillasActionPerformed(evt);
            }
        });

        btnComprarAnimales.setText("Comprar Animales");
        btnComprarAnimales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarAnimalesActionPerformed(evt);
            }
        });

        btnComprarFertilizantes.setText("Comprar Fertilizantes");
        btnComprarFertilizantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarFertilizantesActionPerformed(evt);
            }
        });

        btnComprarAlimentoParaAnimales.setText("Comprar Alimento Para Animales");
        btnComprarAlimentoParaAnimales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarAlimentoParaAnimalesActionPerformed(evt);
            }
        });

        spnCantidadSemillas.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        javax.swing.GroupLayout pnlFondoLayout = new javax.swing.GroupLayout(pnlFondo);
        pnlFondo.setLayout(pnlFondoLayout);
        pnlFondoLayout.setHorizontalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane4)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane6)
                            .addGroup(pnlFondoLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnComprarAlimentoParaAnimales))
                            .addGroup(pnlFondoLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(spnCantidadSemillas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnComprarSemillas))
                            .addGroup(pnlFondoLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnComprarAnimales))
                            .addGroup(pnlFondoLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnComprarFertilizantes))))
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlFondoLayout.createSequentialGroup()
                                .addGap(256, 256, 256)
                                .addComponent(jLabel5))
                            .addGroup(pnlFondoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 8, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(233, 233, 233)
                        .addComponent(btnVenderAlimentos)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                            .addComponent(jSeparator2)
                            .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(206, 206, 206))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                            .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                                    .addGroup(pnlFondoLayout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnVenderMateriaPrima))))
                            .addContainerGap()))))
        );
        pnlFondoLayout.setVerticalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)))
                .addGap(18, 18, 18)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(btnVenderAlimentos))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(btnVenderMateriaPrima))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(btnComprarSemillas)
                            .addComponent(spnCantidadSemillas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(btnComprarAnimales))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(btnComprarFertilizantes))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(btnComprarAlimentoParaAnimales))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 63, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                .addComponent(jSeparator1)
                .addContainerGap())
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

    private void btnVenderAlimentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVenderAlimentosActionPerformed
        if (tblVAlimentos.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar una fila", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int fila = tblVAlimentos.getSelectedRow();
        String nombreAlimento = (String) tblVAlimentos.getValueAt(fila, 0);
        int precioAlimento = (int) tblVAlimentos.getValueAt(fila, 1);
        if (mercado.existeAlimento(nombreAlimento)) {
            mercado.venderAlimento(nombreAlimento);
            mercado.ganarOro(precioAlimento);
            tblVenderAlimentos.removeRow(fila);
            JOptionPane.showMessageDialog(null, "Has vendido un alimento " + nombreAlimento, "Venta exitosa", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnVenderAlimentosActionPerformed

    private void btnComprarSemillasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarSemillasActionPerformed
        if (tblCSemillas.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar una fila", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int fila = tblCSemillas.getSelectedRow();
        int cantidadSemillas = (int) spnCantidadSemillas.getValue();
        String nombreSemilla = (String) tblCSemillas.getValueAt(fila, 0);
        int precioSemilla = (int) tblCSemillas.getValueAt(fila, 1);
        if (mercado.jugadorTieneDineroSufiente(precioSemilla * cantidadSemillas)) {
            mercado.agregarSemillaAlJugador(nombreSemilla, cantidadSemillas);
            mercado.perderOro(precioSemilla * cantidadSemillas);
            JOptionPane.showMessageDialog(null, "Has adquirido " + cantidadSemillas + " semillas de la planta " + nombreSemilla, "Nueva semilla", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No tienes el dinero suficiente", "Compra fallida", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnComprarSemillasActionPerformed

    private void btnComprarAnimalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarAnimalesActionPerformed
        if (tblCAnimales.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar una fila", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int fila = tblCAnimales.getSelectedRow();
        int precioAnimal = (int) tblCAnimales.getValueAt(fila, 1);
        String nombreAnimal = (String) tblCAnimales.getValueAt(fila, 0);
        if (mercado.jugadorTieneDineroSufiente(precioAnimal)) {
            mercado.agregarAnimalAlJugador(nombreAnimal);
            mercado.perderOro(precioAnimal);
            JOptionPane.showMessageDialog(null, "Has adquirido el animal " + nombreAnimal, "Nuevo animal", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No tienes el dinero suficiente", "Compra fallida", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnComprarAnimalesActionPerformed

    private void btnComprarFertilizantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarFertilizantesActionPerformed
        if (tblCFertilizantes.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar una fila", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int fila = tblCFertilizantes.getSelectedRow();
        int precioFertilizante = (int) tblCFertilizantes.getValueAt(fila, 2);
        String nombreFertilizante = (String) tblCFertilizantes.getValueAt(fila, 0);
        if (mercado.jugadorTieneDineroSufiente(precioFertilizante)) {
            mercado.perderOro(precioFertilizante);
            mercado.agregarFertilizanteAlJugador(nombreFertilizante);
            JOptionPane.showMessageDialog(null, "Has adquirido el fertilizante " + nombreFertilizante, "Nuevo fertilizante", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No tienes el dinero suficiente", "Compra fallida", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnComprarFertilizantesActionPerformed

    private void btnComprarAlimentoParaAnimalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarAlimentoParaAnimalesActionPerformed
        if (tblCAlimento.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar una fila", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int fila = tblCAlimento.getSelectedRow();
        int precioAlimento = (int) tblCAlimento.getValueAt(fila, 1);
        String nombreAlimento = (String) tblCAlimento.getValueAt(fila, 0);
        if (mercado.jugadorTieneDineroSufiente(precioAlimento)) {
            mercado.agregarAlimentoParaAnimalAlJugador(nombreAlimento);
            mercado.perderOro(precioAlimento);
            JOptionPane.showMessageDialog(null, "Has adquirido el fertilizante " + nombreAlimento, "Nuevo fertilizante", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No tienes el dinero suficiente", "Compra fallida", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnComprarAlimentoParaAnimalesActionPerformed

    private void btnVenderMateriaPrimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVenderMateriaPrimaActionPerformed
        if (tblVMateria.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar una fila", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int fila = tblVMateria.getSelectedRow();
        String nombreMateria = (String) tblVMateria.getValueAt(fila, 0);
        int precioMateria = (int) tblVMateria.getValueAt(fila, 1);
        if (mercado.existeMateria(nombreMateria)) {
            mercado.venderMateria(nombreMateria);
            mercado.ganarOro(precioMateria);
            tblVenderMateria.removeRow(fila);
            JOptionPane.showMessageDialog(null, "Has vendido la materia " + nombreMateria, "Venta exitosa", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnVenderMateriaPrimaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComprarAlimentoParaAnimales;
    private javax.swing.JButton btnComprarAnimales;
    private javax.swing.JButton btnComprarFertilizantes;
    private javax.swing.JButton btnComprarSemillas;
    private javax.swing.JButton btnVenderAlimentos;
    private javax.swing.JButton btnVenderMateriaPrima;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JSpinner spnCantidadSemillas;
    private javax.swing.JTable tblCAlimento;
    private javax.swing.JTable tblCAnimales;
    private javax.swing.JTable tblCFertilizantes;
    private javax.swing.JTable tblCSemillas;
    private javax.swing.JTable tblVAlimentos;
    private javax.swing.JTable tblVMateria;
    // End of variables declaration//GEN-END:variables
}
