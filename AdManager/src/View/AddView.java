/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import Controller.Controller;
/**
 * @author christopheraramswayne
 * @author xjosh
 */
public class AddView extends javax.swing.JFrame {
    
    private String title;
    private String desc;
    private String cat;
    private String price;
    private String userID;
    private String username;
    private Controller master;

    /**
     * Creates new form AddView
     * with reference to the Controller, the ID of the user creating the ad,
     * and the username of said user.
     * @param c
     * @param userID
     * @param username
     */
    public AddView(Controller c, String userID, String username) {
        initComponents();
        master = c;
        this.userID = userID;
        this.username = username;   
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title_Lable = new javax.swing.JLabel();
        titleField = new javax.swing.JTextField();
        details_Label = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        detailsField = new javax.swing.JTextArea();
        category_Label = new javax.swing.JLabel();
        category_box = new javax.swing.JComboBox<>();
        price_Label = new javax.swing.JLabel();
        price_field = new javax.swing.JTextField();
        add_Advertisement_Button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        title_Lable.setText("Title:");

        details_Label.setText("Details:");

        detailsField.setColumns(20);
        detailsField.setRows(5);
        jScrollPane1.setViewportView(detailsField);

        category_Label.setText("Category:");

        category_box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Electronics", "Cars and Trucks", "Housing", "Child Care" }));

        price_Label.setText("Price:");

        add_Advertisement_Button.setText("Add Advertisement");
        add_Advertisement_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_Advertisement_ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(price_Label)
                    .addComponent(category_Label)
                    .addComponent(details_Label)
                    .addComponent(title_Lable))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(add_Advertisement_Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(category_box, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(titleField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(price_field, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(title_Lable)
                    .addComponent(titleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(details_Label)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(category_Label)
                    .addComponent(category_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(price_Label)
                    .addComponent(price_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(add_Advertisement_Button)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //When the "Add Advertisemnet" button is pressed, the data from the text fields
    //for the ad to be created, and added to the database, is taken, and sent to the 
    //Controller for the data to be handled. After the data is handled, the view should
    //be closed, and refresh the user's "My Advertisements" table in the UserView.
    private void add_Advertisement_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_Advertisement_ButtonActionPerformed
        // TODO add your handling code here:
        this.title = titleField.getText();
        this.desc = detailsField.getText();
        this.cat = category_box.getSelectedItem().toString();
        this.price = price_field.getText();
        master.handleAddRequest(title, desc, cat, price, userID);
        master.handleUserMyTableRequest(userID);
    }//GEN-LAST:event_add_Advertisement_ButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_Advertisement_Button;
    private javax.swing.JLabel category_Label;
    private javax.swing.JComboBox<String> category_box;
    private javax.swing.JTextArea detailsField;
    private javax.swing.JLabel details_Label;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel price_Label;
    private javax.swing.JTextField price_field;
    private javax.swing.JTextField titleField;
    private javax.swing.JLabel title_Lable;
    // End of variables declaration//GEN-END:variables
}
