package pkg1;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Radwa Manssour
 */
public class conversation extends javax.swing.JPanel {

    /**
     * Creates new form conversation
     */
    public conversation() {
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

        img = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        text2 = new javax.swing.JTextArea();
        send = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        attach = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        attach2 = new javax.swing.JButton();
        attach3 = new javax.swing.JButton();
        attach4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        text1 = new javax.swing.JTextArea();

        img.setText("jLabel1");

        name.setText("name");

        text2.setColumns(20);
        text2.setRows(5);
        jScrollPane1.setViewportView(text2);

        send.setText("send");

        jPanel1.setMaximumSize(new java.awt.Dimension(20, 20));
        jPanel1.setMinimumSize(new java.awt.Dimension(20, 20));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        attach.setMaximumSize(new java.awt.Dimension(35, 35));
        attach.setMinimumSize(new java.awt.Dimension(0, 35));
        attach.setPreferredSize(new java.awt.Dimension(35, 35));
        jPanel1.add(attach);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jComboBox1);

        attach2.setMaximumSize(new java.awt.Dimension(35, 35));
        attach2.setMinimumSize(new java.awt.Dimension(0, 0));
        attach2.setPreferredSize(new java.awt.Dimension(35, 35));
        jPanel1.add(attach2);

        attach3.setText("add member");
        attach3.setMaximumSize(new java.awt.Dimension(100, 35));
        attach3.setMinimumSize(new java.awt.Dimension(0, 0));
        attach3.setPreferredSize(new java.awt.Dimension(100, 35));
        attach3.setRolloverEnabled(false);
        jPanel1.add(attach3);

        attach4.setText("leave conversation");
        attach4.setMaximumSize(new java.awt.Dimension(130, 35));
        attach4.setMinimumSize(new java.awt.Dimension(0, 0));
        attach4.setPreferredSize(new java.awt.Dimension(130, 35));
        jPanel1.add(attach4);

        text1.setColumns(20);
        text1.setRows(5);
        jScrollPane2.setViewportView(text1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane2)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(name))
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(send, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(name)
                    .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(send, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton attach;
    private javax.swing.JButton attach2;
    private javax.swing.JButton attach3;
    private javax.swing.JButton attach4;
    private javax.swing.JLabel img;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel name;
    private javax.swing.JButton send;
    private javax.swing.JTextArea text1;
    private javax.swing.JTextArea text2;
    // End of variables declaration//GEN-END:variables
}