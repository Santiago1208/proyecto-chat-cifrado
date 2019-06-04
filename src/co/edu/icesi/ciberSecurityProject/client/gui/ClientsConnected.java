package co.edu.icesi.ciberSecurityProject.client.gui;

import co.edu.icesi.ciberSecurityProject.model.Commands;
import co.edu.icesi.ciberSecurityProject.model.ConversationDataPackage;
import co.edu.icesi.ciberSecurityProject.model.User;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;

/**
 *
 * @author azo_6
 */
public class ClientsConnected extends javax.swing.JFrame {

    private DefaultListModel listModel;

    private User userLoggedIn;

    /**
     * Creates new form ClientsConnected
     */
    public ClientsConnected(User newUser) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        userLoggedIn = newUser;
        jList1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {

                if (evt.getClickCount() == 2) {

                    Rectangle r = jList1.getCellBounds(0, jList1.getLastVisibleIndex());

                    if (r != null && r.contains(evt.getPoint())) {
                        //int index = jList1.locationToIndex(evt.getPoint());
                        User u = (User)jList1.getSelectedValue();
                        try {
                            Socket channel = new Socket("host del server", 9999);
                            ObjectOutputStream in = new ObjectOutputStream(channel.getOutputStream());
                            ConversationDataPackage data = new ConversationDataPackage();
                            KeyPair keys = generateKeyPair();
                            data.setUserKeys(keys);
                            data.setUserNickName(userLoggedIn.getNickname());
                            data.setIpAddress(userLoggedIn.getIpAddress());
                            data.setFriendIPAddress(u.getIpAddress());
                            data.setCode(Commands.START_CONVERSATION);
                            in.writeObject(data);
                            in.close();
                            channel.close();
                            
                        } catch (IOException ex) {
                            Logger.getLogger(ClientsConnected.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (NoSuchAlgorithmException ex) {
                            Logger.getLogger(ClientsConnected.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } else if (evt.getClickCount() == 3) {

                    Rectangle r = jList1.getCellBounds(0, jList1.getLastVisibleIndex());

                    if (r != null && r.contains(evt.getPoint())) {
                        int index = jList1.locationToIndex(evt.getPoint());
                    }
                }
            }
        });
    }
    
    private KeyPair generateKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyGenerator = KeyPairGenerator.getInstance("DH");
        keyGenerator.initialize(1024);
        KeyPair pair = keyGenerator.generateKeyPair();
        return pair;
    }

    public void fulfillOnlineUserList() {
        Socket s;
        try {
            s = new Socket("", 9999);
            ObjectOutputStream OUS = new ObjectOutputStream(s.getOutputStream());

        } catch (IOException ex) {
            Logger.getLogger(ClientsConnected.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConversationDataPackage CDP = new ConversationDataPackage();

        // ClientChat nuevoChat = new ClientChat(onlineUserList().get(index));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Usuarios conectados en este momento:");

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Nada por aquí..." };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public ArrayList onlineUserList() {
        ArrayList list = new ArrayList();
        ListModel model = jList1.getModel();

        for (int i = 0; i < model.getSize(); i++) {
            Object o = model.getElementAt(i);
            list.add((String) o);
        }
        return list;
    }

    public void updateUserList(User user) {
        if (user.getState().equals(Commands.CONNECTED)) {
            listModel.addElement(user);
        } else if (user.getState().equals("offline")) {
            DefaultListModel model = (DefaultListModel) jList1.getModel();
            int index = model.indexOf(user);
            listModel.remove(index);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
