/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import matrizAdjacente.Dijkstra;
import matrizAdjacente.MatrizAdjacente;
import matrizAdjacente.Prim;
import matrizAdjacente.Vertice;

/**
 *
 * @author Gomes
 */
public class Interface extends javax.swing.JFrame {

    public static final Color DARK_GREEN = new Color(0, 100, 0);

    private final LinkedList<Vertice> vertices = new LinkedList();
    private int qtdVertices = 0;

    /**
     * Creates new form Interface
     */
    public Interface() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        quadro = new java.awt.Canvas();
        limpar = new javax.swing.JButton();
        setCM = new javax.swing.JButton();
        setAGM = new javax.swing.JButton();
        verticeInicial = new javax.swing.JSpinner();
        textoVerticeInicial = new javax.swing.JLabel();
        verticeFinal = new javax.swing.JSpinner();
        textoVerticeFinal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("Trabalho de Grafos"), this, org.jdesktop.beansbinding.BeanProperty.create("title"));
        bindingGroup.addBinding(binding);

        quadro.setBackground(new java.awt.Color(255, 255, 255));
        quadro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quadroMouseClicked(evt);
            }
        });

        limpar.setText("Limpar");
        limpar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                limparMouseClicked(evt);
            }
        });

        setCM.setText("Caminho Minimo");
        setCM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                setCMMouseClicked(evt);
            }
        });

        setAGM.setText("Arvore Geradora Minima");
        setAGM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                setAGMMouseClicked(evt);
            }
        });

        textoVerticeInicial.setText("Vertice Inicial");

        textoVerticeFinal.setText("Vertice Final");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(quadro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(setCM)
                        .addGap(18, 18, 18)
                        .addComponent(setAGM)
                        .addGap(18, 18, 18)
                        .addComponent(limpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textoVerticeInicial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(verticeInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textoVerticeFinal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(verticeFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(quadro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(verticeInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(limpar)
                        .addComponent(setCM)
                        .addComponent(setAGM)
                        .addComponent(verticeFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textoVerticeFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textoVerticeInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void quadroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quadroMouseClicked
        // TODO add your handling code here:
        Graphics2D g = (Graphics2D) quadro.getGraphics();
        vertices.add(new Vertice(qtdVertices++, evt.getX(), evt.getY()));//adiciona vertice
        g = limpar(g);//limpa quadro antes de desenhar 
        g = desenhaLinha(g);//desenha linha
        g = desenhaVertices(g);//desenha circulo
    }//GEN-LAST:event_quadroMouseClicked

    public Graphics2D desenhaVertices(Graphics2D g) {
        g.setColor(Color.black);
        for (Vertice vertice : vertices) {
            g.drawString(String.valueOf(vertice.index), vertice.X - 5, vertice.Y - 10);
            g.fillOval(vertice.X - 5, vertice.Y - 5, 10, 10);
        }
        return g;
    }

    public Graphics2D desenhaLinha(Graphics2D g) {
        g.setColor(Color.LIGHT_GRAY);
        for (int i = 0; i < vertices.size(); i++) {
            for (int j = i + 1; j < vertices.size(); j++) {
                g.drawLine(vertices.get(i).X, vertices.get(i).Y, vertices.get(j).X, vertices.get(j).Y);
            }
        }
        return g;
    }

    public Graphics2D limpar(Graphics2D g) {
        g.setBackground(Color.white);
        g.clearRect(0, 0, quadro.getWidth(), quadro.getHeight());
        return g;
    }


    private void limparMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_limparMouseClicked
        // TODO add your handling code here:
        Graphics2D g = (Graphics2D) quadro.getGraphics();
        g = limpar(g);
        vertices.clear();
        qtdVertices = 0;
    }//GEN-LAST:event_limparMouseClicked

    private void setCMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_setCMMouseClicked
        // TODO add your handling code here:
        if (!vertices.isEmpty()) {
            int vi = (int) verticeInicial.getValue();
            int vf = (int) verticeFinal.getValue();
            java.awt.Graphics2D g = (java.awt.Graphics2D) quadro.getGraphics();
            MatrizAdjacente grafo = new MatrizAdjacente(qtdVertices);
            Vertice[] vl = new Vertice[qtdVertices];
            for (int i = 0; i < qtdVertices; i++) {
                vl[i] = vertices.get(i);
                for (int j = 0; j < qtdVertices; j++) {
                    grafo.adicionarAresta(vertices.get(i), vertices.get(j));
                }
            }
            Dijkstra d = new Dijkstra(grafo, vl);
            try {
                d.solucao(vi);
            } catch (Exception ex) {
                Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
            }
            g.setColor(DARK_GREEN);
            for (int i = 0; i < qtdVertices; i++) {
                if (d.vertices[i].pai != Vertice.NAO_TEM) {
                    g.drawLine(d.vertices[i].X, d.vertices[i].Y, d.vertices[d.vertices[i].pai].X, d.vertices[d.vertices[i].pai].Y);
                }
            }
            g = desenhaVertices(g);
            g.setColor(DARK_GREEN);
            g.fillOval(d.vertices[vf].X - 5, d.vertices[vf].Y - 5, 10, 10);
            g.setColor(Color.blue);
            g.fillOval(d.vertices[vi].X - 5, d.vertices[vi].Y - 5, 10, 10);
        }
    }//GEN-LAST:event_setCMMouseClicked

    private void setAGMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_setAGMMouseClicked
        // TODO add your handling code here:
        if (!vertices.isEmpty()) {
            int vi = (int) verticeInicial.getValue();
            int vf = (int) verticeFinal.getValue();
            java.awt.Graphics2D g = (java.awt.Graphics2D) quadro.getGraphics();
            MatrizAdjacente grafo = new MatrizAdjacente(qtdVertices);
            Vertice[] vl = new Vertice[qtdVertices];
            for (int i = 0; i < qtdVertices; i++) {
                vl[i] = vertices.get(i);
                for (int j = 0; j < qtdVertices; j++) {
                    grafo.adicionarAresta(vertices.get(i), vertices.get(j));
                }
            }
            Prim p = new Prim(grafo, vl);
            try {
                p.solucao(vi);
            } catch (Exception ex) {
                Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
            }
            g.setColor(Color.blue);
            for (int i = 0; i < qtdVertices; i++) {
                if (p.vertices[i].pai != Vertice.NAO_TEM) {
                    g.drawLine(p.vertices[i].X, p.vertices[i].Y, p.vertices[p.vertices[i].pai].X, p.vertices[p.vertices[i].pai].Y);
                }
            }
            g = desenhaVertices(g);
            g.setColor(DARK_GREEN);
            g.fillOval(p.vertices[vf].X - 5, p.vertices[vf].Y - 5, 10, 10);
            g.setColor(Color.blue);
            g.fillOval(p.vertices[vi].X - 5, p.vertices[vi].Y - 5, 10, 10);
        }
    }//GEN-LAST:event_setAGMMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton limpar;
    private java.awt.Canvas quadro;
    private javax.swing.JButton setAGM;
    private javax.swing.JButton setCM;
    private javax.swing.JLabel textoVerticeFinal;
    private javax.swing.JLabel textoVerticeInicial;
    private javax.swing.JSpinner verticeFinal;
    private javax.swing.JSpinner verticeInicial;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
