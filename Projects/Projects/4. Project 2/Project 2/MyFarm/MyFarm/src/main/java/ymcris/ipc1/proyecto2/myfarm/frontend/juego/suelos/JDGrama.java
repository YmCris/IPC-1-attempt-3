package ymcris.ipc1.proyecto2.myfarm.frontend.juego.suelos;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import ymcris.ipc1.proyecto2.myfarm.backend.a.exceptions.ColaException;
import ymcris.ipc1.proyecto2.myfarm.backend.a.exceptions.ListaDobleException;
import ymcris.ipc1.proyecto2.myfarm.backend.c.suelos.Grama;
import ymcris.ipc1.proyecto2.myfarm.backend.c.plantas.Semillas;
import ymcris.ipc1.proyecto2.myfarm.backend.b.granjero.Granjero;
import ymcris.ipc1.proyecto2.myfarm.backend.c.animales.Animales;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Alimentos;
import ymcris.ipc1.proyecto2.myfarm.frontend.creadores.JDElegirProduccion;
import ymcris.ipc1.proyecto2.myfarm.frontend.elementos.JDElegirAlimentoParaAnimal;
import ymcris.ipc1.proyecto2.myfarm.frontend.elementos.JDElegirSemilla;
import ymcris.ipc1.proyecto2.myfarm.frontend.elementos.PanelPersonalizado;
import ymcris.ipc1.proyecto2.myfarm.frontend.elementos.JDElegirFertilizante;

/**
 *
 * @author YmCris
 */
public class JDGrama extends javax.swing.JDialog {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private Grama grama;
    private Granjero granjero;
    private Semillas semillaAPlantar;
    private JButton boton;
    private Animales animalCriado;

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private int fertilidad;

    // COSNTANTES --------------------------------------------------------------
    private static final String RUTA_IMAGEN = "/grama.png";

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public JDGrama(Grama grama, Granjero granjero) {
        initComponents();
        this.grama = grama;
        this.granjero = granjero;
        this.setModal(true);
        this.setResizable(false);
        this.setTitle("Suelo de Grama");
        this.setLocationRelativeTo(null);
        pnlFondo.add(new PanelPersonalizado(pnlFondo, RUTA_IMAGEN)).repaint();
        lblFertilidad.setText(String.valueOf(grama.getFertilidad()));
        lblEstaOcupado.setText(String.valueOf(grama.estaOpupado()));
        lblEstaSucio.setText(String.valueOf(grama.estaSucio()));
        lblEsParcela.setText(String.valueOf(grama.esParcela()));
        lblAnimalesPermitidos.setText(String.valueOf(grama.getAnimalesPermitidos()));
        this.boton = btnCosechar;
        this.animalCriado = grama.getAnimalCriado();
        desactivarBotones();
    }

    private void desactivarBotones() {
        if (grama.estaBloqueado()) {
            btnAgregarFertilizante.setEnabled(false);
            btnCosechar.setEnabled(false);
            btnCriarAnimales.setEnabled(false);
            btnSembrar.setEnabled(false);
            btnDestazar.setEnabled(false);
            btnAlimentarAnimal.setEnabled(false);
            return;
        }
        if (grama.tienePlanta() == true && grama.estaOpupado()) {
            btnAgregarFertilizante.setEnabled(false);
            btnCosechar.setEnabled(false);
            btnCriarAnimales.setEnabled(false);
            btnDestazar.setEnabled(false);
            btnSembrar.setEnabled(false);
            btnAlimentarAnimal.setEnabled(false);
        } else if (grama.tienePlanta() == false && grama.estaOpupado() == false) {
            activarBotones();
        } else if (grama.tienePlanta() == false) {
            btnAgregarFertilizante.setEnabled(false);
            btnCosechar.setEnabled(true);
            btnCriarAnimales.setEnabled(false);
            btnSembrar.setEnabled(false);
        } else {
            activarBotones();
        }

    }

    private void activarBotones() {
        btnAgregarFertilizante.setEnabled(true);
        btnCosechar.setEnabled(true);
        btnCriarAnimales.setEnabled(true);
        btnSembrar.setEnabled(true);
    }

    public void setSemillaAPlantar(Semillas semillaAPlantar) {
        this.semillaAPlantar = semillaAPlantar;
    }

    public void setFertilidad(int fertilidad) {
        this.fertilidad = fertilidad;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFondo = new javax.swing.JPanel();
        lblTitulo2 = new javax.swing.JLabel();
        btnSembrar = new javax.swing.JButton();
        btnCriarAnimales = new javax.swing.JButton();
        btnAgregarFertilizante = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblFertilidad = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblEstaOcupado = new javax.swing.JLabel();
        btnCosechar = new javax.swing.JButton();
        lblEstaSucio = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblEsParcela = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblAnimalesPermitidos = new javax.swing.JLabel();
        btnAlimentarAnimal = new javax.swing.JButton();
        btnDestazar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblTitulo2.setBackground(java.awt.SystemColor.activeCaptionText);
        lblTitulo2.setFont(new java.awt.Font("Snap ITC", 1, 100)); // NOI18N
        lblTitulo2.setForeground(new java.awt.Color(51, 51, 51));
        lblTitulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo2.setText("GRAMA");
        lblTitulo2.setToolTipText("");
        lblTitulo2.setMaximumSize(new java.awt.Dimension(300, 300));
        lblTitulo2.setMinimumSize(new java.awt.Dimension(300, 300));
        lblTitulo2.setName(""); // NOI18N
        lblTitulo2.setPreferredSize(new java.awt.Dimension(300, 300));

        btnSembrar.setBackground(new java.awt.Color(51, 51, 51));
        btnSembrar.setFont(new java.awt.Font("Ravie", 1, 36)); // NOI18N
        btnSembrar.setForeground(new java.awt.Color(51, 51, 51));
        btnSembrar.setText("SEMBRAR");
        btnSembrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSembrar.setOpaque(false);
        btnSembrar.setBorderPainted(false);
        btnSembrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSembrarActionPerformed(evt);
            }
        });

        btnCriarAnimales.setBackground(new java.awt.Color(51, 51, 51));
        btnCriarAnimales.setFont(new java.awt.Font("Ravie", 1, 36)); // NOI18N
        btnCriarAnimales.setForeground(new java.awt.Color(51, 51, 51));
        btnCriarAnimales.setText("CRIAR ANIMAL");
        btnCriarAnimales.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCriarAnimales.setOpaque(false);
        btnCriarAnimales.setBorderPainted(false);
        btnCriarAnimales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarAnimalesActionPerformed(evt);
            }
        });

        btnAgregarFertilizante.setBackground(new java.awt.Color(51, 51, 51));
        btnAgregarFertilizante.setFont(new java.awt.Font("Ravie", 1, 36)); // NOI18N
        btnAgregarFertilizante.setForeground(new java.awt.Color(51, 51, 51));
        btnAgregarFertilizante.setText("AÑADIR FERTILIZANTE");
        btnAgregarFertilizante.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAgregarFertilizante.setOpaque(false);
        btnAgregarFertilizante.setBorderPainted(false);
        btnAgregarFertilizante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarFertilizanteActionPerformed(evt);
            }
        });

        jLabel1.setText("Fertilidad:");

        lblFertilidad.setText("120");

        jLabel2.setText("Esta Ocupado:");

        lblEstaOcupado.setText("true");

        btnCosechar.setBackground(new java.awt.Color(51, 51, 51));
        btnCosechar.setFont(new java.awt.Font("Ravie", 1, 36)); // NOI18N
        btnCosechar.setForeground(new java.awt.Color(51, 51, 51));
        btnCosechar.setText("COSECHAR");
        btnCosechar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCosechar.setOpaque(false);
        btnCosechar.setBorderPainted(false);
        btnCosechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCosecharActionPerformed(evt);
            }
        });

        lblEstaSucio.setText("true");

        jLabel3.setText("Esta Sucio");

        lblEsParcela.setText("true");

        jLabel4.setText("Es Parcela");

        jLabel5.setText("Animales permitidos");

        lblAnimalesPermitidos.setText("vaca");

        btnAlimentarAnimal.setBackground(new java.awt.Color(51, 51, 51));
        btnAlimentarAnimal.setFont(new java.awt.Font("Ravie", 1, 36)); // NOI18N
        btnAlimentarAnimal.setForeground(new java.awt.Color(51, 51, 51));
        btnAlimentarAnimal.setText("Alimentar animal");
        btnAlimentarAnimal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAlimentarAnimal.setOpaque(false);
        btnAlimentarAnimal.setBorderPainted(false);
        btnAlimentarAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlimentarAnimalActionPerformed(evt);
            }
        });

        btnDestazar.setBackground(new java.awt.Color(51, 51, 51));
        btnDestazar.setFont(new java.awt.Font("Ravie", 1, 36)); // NOI18N
        btnDestazar.setForeground(new java.awt.Color(51, 51, 51));
        btnDestazar.setText("Destazar Animal");
        btnDestazar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDestazar.setOpaque(false);
        btnDestazar.setBorderPainted(false);
        btnDestazar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDestazarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFondoLayout = new javax.swing.GroupLayout(pnlFondo);
        pnlFondo.setLayout(pnlFondoLayout);
        pnlFondoLayout.setHorizontalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addGap(484, 484, 484)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblEstaOcupado)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblEstaSucio))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblFertilidad)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblEsParcela)
                        .addGap(12, 12, 12))
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblAnimalesPermitidos)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDestazar)
                .addGap(46, 46, 46)
                .addComponent(btnAgregarFertilizante)
                .addGap(28, 28, 28))
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlFondoLayout.createSequentialGroup()
                                .addGap(198, 198, 198)
                                .addComponent(btnSembrar, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlFondoLayout.createSequentialGroup()
                                .addGap(153, 153, 153)
                                .addComponent(btnCriarAnimales, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(130, 130, 130)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAlimentarAnimal)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                                .addComponent(btnCosechar, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(84, 84, 84))))
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGap(319, 319, 319)
                        .addComponent(lblTitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        pnlFondoLayout.setVerticalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblTitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblFertilidad)
                    .addComponent(jLabel4)
                    .addComponent(lblEsParcela))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(lblEstaSucio))
                    .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(lblEstaOcupado)))
                .addGap(18, 18, 18)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblAnimalesPermitidos))
                .addGap(40, 40, 40)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSembrar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCosechar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCriarAnimales, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlimentarAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarFertilizante, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDestazar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54))
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

    private void btnSembrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSembrarActionPerformed
        if (grama.tieneAnimales()) {
            JOptionPane.showMessageDialog(null, "No puedes sembrar porque hay un animal criandose", "ERROR", JOptionPane.WARNING_MESSAGE);
            return;
        }
        semillaAPlantar = null;
        new JDElegirSemilla(this, granjero).setVisible(true);
        if (semillaAPlantar != null) {
            grama.setEstaOpupado(true);
            grama.setTienePlanta(true);
            desactivarBotones();
            grama.sembrar(semillaAPlantar, boton);
            lblEstaOcupado.setText(String.valueOf(grama.estaOpupado()));
            grama.setText("Cosechando la planta " + semillaAPlantar.getNombre());
        }
    }//GEN-LAST:event_btnSembrarActionPerformed

    private void btnCriarAnimalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarAnimalesActionPerformed
        if (grama.esParcela()) {
            if (granjero.tieneAnimal(grama.getAnimalesPermitidos())) {
                try {
                    JOptionPane.showMessageDialog(null, "Empieza la crianza del animal", "Crianza", JOptionPane.INFORMATION_MESSAGE);
                    grama.setAnimalCriado(granjero.getAnimales().usar(grama.getAnimalesPermitidos()));
                    grama.setText("Animal " + grama.getAnimalCriado().getNombre() + " en parcela");
                    grama.criarAnimales(grama.getAnimalCriado());
                    grama.setTieneAnimales(true);
                    grama.setEstaOpupado(true);
                } catch (ListaDobleException ex) {
                    System.out.println("No se usar el animal porque " + ex.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(null, "No tienes el animal que es requerido", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No puedes criar animales porque no es parcela", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCriarAnimalesActionPerformed

    private void btnAgregarFertilizanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarFertilizanteActionPerformed
        new JDElegirFertilizante(this, granjero).setVisible(true);
        if (fertilidad != 0) {
            grama.setFertilidad(grama.getFertilidad() + fertilidad);
            lblFertilidad.setText(String.valueOf(grama.getFertilidad()));
        }
    }//GEN-LAST:event_btnAgregarFertilizanteActionPerformed

    private void btnCosecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCosecharActionPerformed
        if (grama.estaOpupado() == true) {
            try {//Cosecha terminada
                Alimentos alimentoObtenido = grama.getOrdenDeProduccionAlimentos().sacarElemento();
                //granjero.agregarCantidadAAlimento(alimento.getNombre(), cantidadDeAlimentos);
                grama.setEstaOpupado(false);
                grama.setEstaSucio(false);
                grama.detenerHilo();
                grama.colocarImagen();
                lblEstaOcupado.setText(String.valueOf(grama.estaOpupado()));
                lblEstaSucio.setText(String.valueOf(grama.estaSucio()));
                JOptionPane.showMessageDialog(null, "Alimento obtenido " + alimentoObtenido.getNombre() + " cantidad " + alimentoObtenido.getCantidad(), "Cosecha", JOptionPane.INFORMATION_MESSAGE);
            } catch (ColaException | ListaDobleException ex) {
                JOptionPane.showMessageDialog(null, "No puedes recolectar la cosecha porque se ha podrido", "Cosecha podrida", JOptionPane.INFORMATION_MESSAGE);
                grama.detenerHilo();
                desactivarBotones();
                lblEstaOcupado.setText(String.valueOf(grama.estaOpupado()));
                lblEstaSucio.setText(String.valueOf(grama.estaSucio()));
            }
        } else {
            JOptionPane.showMessageDialog(null, "No puedes cosechar este alimento porque no estas sembrando nada", "Cosecha podrida", JOptionPane.INFORMATION_MESSAGE);
        }
        activarBotones();
    }//GEN-LAST:event_btnCosecharActionPerformed

    private void btnAlimentarAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlimentarAnimalActionPerformed
        if (animalCriado != null) {
            new JDElegirAlimentoParaAnimal(granjero.getAlimentosParaAnimales(), animalCriado, granjero).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "No puedes alimentar a algun animal porque no estas criando a ninguno", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAlimentarAnimalActionPerformed

    private void btnDestazarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDestazarActionPerformed
        new JDElegirProduccion(grama.getAnimalCriado(), granjero).setVisible(true);
    }//GEN-LAST:event_btnDestazarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarFertilizante;
    private javax.swing.JButton btnAlimentarAnimal;
    private javax.swing.JButton btnCosechar;
    private javax.swing.JButton btnCriarAnimales;
    private javax.swing.JButton btnDestazar;
    private javax.swing.JButton btnSembrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblAnimalesPermitidos;
    private javax.swing.JLabel lblEsParcela;
    private javax.swing.JLabel lblEstaOcupado;
    private javax.swing.JLabel lblEstaSucio;
    private javax.swing.JLabel lblFertilidad;
    private javax.swing.JLabel lblTitulo2;
    private javax.swing.JPanel pnlFondo;
    // End of variables declaration//GEN-END:variables
}
