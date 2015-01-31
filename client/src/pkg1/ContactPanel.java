package pkg1;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Comparator;
import model.Contact;
import model.Room;
import view.ClientInputHandler;
import view.IClientInputHandler;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Radwa Manssour
 */
public class ContactPanel extends javax.swing.JPanel {

    /**
     * Creates new form contact
     */
    Contact cont;

    public ContactPanel(chatCui gui, Contact cont) {

        initComponents();
        this.cont = cont;
        ContactPanel c = this;
        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {

                c.setBackground(new Color(204, 255, 204));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    Room room = new Room();
                    room.contactVector.add(new Contact(gui.user.getUserEmail(), TOOL_TIP_TEXT_KEY, TOOL_TIP_TEXT_KEY, null, WIDTH));
                    room.contactVector.add(cont);
                    if (room.contactVector.get(0).getEmail().compareToIgnoreCase(room.contactVector.get(1).getEmail()) > 0) {
                        room.setRoomId(room.contactVector.get(0).getEmail() + "*" + room.contactVector.get(1).getEmail());
                    } else {
                        room.setRoomId(room.contactVector.get(1).getEmail() + "*" + room.contactVector.get(0).getEmail());
                    }
                    boolean found = false;
                    /*for (int i = 0; i < gui.room.rooms_tabs.getTabCount(); i++) {
                        if (((conversation) gui.room.rooms_tabs.getComponent(i)).getRoomId().equals(room.getRoomId())) {
                            found = true;
                            break;
                        }
                    }*/
                    if(!gui.rooms.containsKey(room.getRoomId())){
                        conversation conv = new conversation(gui);
                        conv.setRoomId(room.getRoomId());
                        conv.setRoom(room);
                        gui.rooms.put(room.getRoomId(), conv);
                        conv.setVisible(true);
                    }
                    
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("dddhh");
                c.setBackground(new Color(255, 255, 255));
            }

        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        name = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        img = new javax.swing.JLabel();
        state = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setMaximumSize(new java.awt.Dimension(32767, 80));
        setMinimumSize(new java.awt.Dimension(0, 80));

        name.setText("name");

        status.setText("status");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(name)
                    .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(state, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(name)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(state, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel img;
    public javax.swing.JLabel name;
    public static javax.swing.JLabel state;
    public javax.swing.JLabel status;
    // End of variables declaration//GEN-END:variables
}
