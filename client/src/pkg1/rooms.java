package pkg1;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Radwa Manssour
 */
public class rooms extends javax.swing.JPanel {

    /**
     * Creates new form rooms
     */
    public rooms() {
        initComponents();
        setSize(700, 700);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rooms_tabs = new javax.swing.JTabbedPane();

        setMinimumSize(new java.awt.Dimension(550, 0));

        rooms_tabs.setBackground(new java.awt.Color(51, 255, 0));
        rooms_tabs.setMinimumSize(new java.awt.Dimension(600, 5));
        rooms_tabs.setPreferredSize(new java.awt.Dimension(550, 5));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(rooms_tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rooms_tabs, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTabbedPane rooms_tabs;
    // End of variables declaration//GEN-END:variables
}
