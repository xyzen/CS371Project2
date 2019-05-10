package View;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Controller.Controller;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author christopheraramswayne
 */
public class UserView extends javax.swing.JFrame {

    private Controller master;
    
    private String username;
    private String userID;
    
    private String category;
    private String title;
    private String description;
    private String price;
    private String keyword;
    private String Sdate;
    private int date;
    private String Advertisement_ID;
    
    private String[] advertisementsTableColumns = { "Category", "Title", "Description", "Price" , "Date" };
    private String[] myAdvertisementsTableColumns = { "ID" , "Title", "Description", "Price", "Status", "Date" };
    
    
    /**
     * Creates new form UserView
     */
    public UserView(Controller c, String usrID) {
        initComponents();
        userID = usrID;
        master = c;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        advertisementsTabPane = new javax.swing.JTabbedPane();
        advertisementsPanel = new javax.swing.JPanel();
        categoryLabel = new javax.swing.JLabel();
        categoryComboBox = new javax.swing.JComboBox<>();
        periodComboBox = new javax.swing.JComboBox<>();
        periodLabel = new javax.swing.JLabel();
        descriptionTextField = new javax.swing.JTextField();
        goButton = new javax.swing.JButton();
        descriptionLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        advertisementsTable = new javax.swing.JTable();
        lastLabel = new javax.swing.JLabel();
        monthsLabel = new javax.swing.JLabel();
        myAdvertisementsPanel = new javax.swing.JPanel();
        deleteButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        myAdvertisementsTable = new javax.swing.JTable();
        addAdvertisementButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        categoryLabel.setText("Category:");

        categoryComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Electronics", "Cars and Trucks", "Housing", "Child Care" }));
        categoryComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryComboBoxActionPerformed(evt);
            }
        });

        periodComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "all", "3", "6", "12", " " }));
        periodComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                periodComboBoxActionPerformed(evt);
            }
        });

        periodLabel.setText("Period:");

        goButton.setText("Go");
        goButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goButtonActionPerformed(evt);
            }
        });

        descriptionLabel.setText("Title, Description:");

        advertisementsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title", "Description", "Price", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(advertisementsTable);

        lastLabel.setText("Last");

        monthsLabel.setText("Months");

        javax.swing.GroupLayout advertisementsPanelLayout = new javax.swing.GroupLayout(advertisementsPanel);
        advertisementsPanel.setLayout(advertisementsPanelLayout);
        advertisementsPanelLayout.setHorizontalGroup(
            advertisementsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(advertisementsPanelLayout.createSequentialGroup()
                .addGroup(advertisementsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(advertisementsPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(categoryLabel)))
                .addGap(18, 18, 18)
                .addGroup(advertisementsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(advertisementsPanelLayout.createSequentialGroup()
                        .addComponent(lastLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(periodComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(monthsLabel))
                    .addGroup(advertisementsPanelLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(periodLabel)))
                .addGap(0, 143, Short.MAX_VALUE)
                .addGroup(advertisementsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(advertisementsPanelLayout.createSequentialGroup()
                        .addComponent(descriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(goButton))
                    .addComponent(descriptionLabel))
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        advertisementsPanelLayout.setVerticalGroup(
            advertisementsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(advertisementsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(advertisementsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoryLabel)
                    .addComponent(periodLabel)
                    .addComponent(descriptionLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(advertisementsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(periodComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(goButton)
                    .addComponent(lastLabel)
                    .addComponent(monthsLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        advertisementsTabPane.addTab("Advertisements", advertisementsPanel);

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        editButton.setText("Edit");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        myAdvertisementsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Title", "Description", "Price", "Status", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(myAdvertisementsTable);

        javax.swing.GroupLayout myAdvertisementsPanelLayout = new javax.swing.GroupLayout(myAdvertisementsPanel);
        myAdvertisementsPanel.setLayout(myAdvertisementsPanelLayout);
        myAdvertisementsPanelLayout.setHorizontalGroup(
            myAdvertisementsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myAdvertisementsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(myAdvertisementsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
                    .addGroup(myAdvertisementsPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(editButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton)))
                .addContainerGap())
        );
        myAdvertisementsPanelLayout.setVerticalGroup(
            myAdvertisementsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myAdvertisementsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(myAdvertisementsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteButton)
                    .addComponent(editButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                .addContainerGap())
        );

        advertisementsTabPane.addTab("My Advertisements", myAdvertisementsPanel);

        addAdvertisementButton.setText("Add Advertisement");
        addAdvertisementButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAdvertisementButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(advertisementsTabPane)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addAdvertisementButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addAdvertisementButton)
                .addGap(5, 5, 5)
                .addComponent(advertisementsTabPane)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //When the "Add Advertisement" button is pushed, the view will tell the controller
    //that the button was pushed. The controller will handle the action afterwards.
    private void addAdvertisementButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAdvertisementButtonActionPerformed
        master.handleAddButton(userID);
        //Controller "master" will open the AddAdvertisement window
        
    }//GEN-LAST:event_addAdvertisementButtonActionPerformed

    //When the "Edit" button is pushed, the view will tell the controller that the
    //button was pressed. The controller will be given the Advertisement ID to handle
    //editing the correct ad.
    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        int row = this.myAdvertisementsTable.getSelectedRow();
        
        if(row>=0){
            Advertisement_ID=(String)myAdvertisementsTable.getValueAt(row, 0);
        }
        master.handleEditButton(Advertisement_ID, userID);
    }//GEN-LAST:event_editButtonActionPerformed

    //When the "Delete" button is pushed, the view will tell the controller that
    //the button was pushed. The controller will be given the Advertisement ID to 
    //handle deleting the correct ad.
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int row = this.myAdvertisementsTable.getSelectedRow();
        
        if(row>=0){
            Advertisement_ID=(String)myAdvertisementsTable.getValueAt(row, 0);
        }
        master.handleDeleteRequest(Advertisement_ID);
        
        //Controller "master" will handle deleting the advertisement from the database.
        
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButtonActionPerformed

    //When the "Go" button is pressed, the view will tell the controller that the
    //button was pushed. The controller will be given the query terms to handle
    //a request to fill the table
    private void goButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goButtonActionPerformed
       this.category=categoryComboBox.getSelectedItem().toString();
        this.Sdate = periodComboBox.getSelectedItem().toString();
        this.date = Integer.parseInt(Sdate);
        this.keyword = descriptionTextField.getText();

        master.handleUserSTDTableRequest(category, date, keyword);

        // TODO add your handling code here:
    }//GEN-LAST:event_goButtonActionPerformed

    //Add description for method
    private void categoryComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryComboBoxActionPerformed

    //Add description for method
    private void periodComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_periodComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_periodComboBoxActionPerformed

    /**
     * @param args the command line arguments
     */
    
    //Populates the STD table for users in the view
    public void populateSTDTable(String[][] published_data){
        this.advertisementsTable.setModel(new DefaultTableModel(published_data, advertisementsTableColumns));
    }
    
    //Populates the personal table for the users in the view
    public void populateMyTable(String[][] published_data){
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addAdvertisementButton;
    private javax.swing.JPanel advertisementsPanel;
    private javax.swing.JTabbedPane advertisementsTabPane;
    private javax.swing.JTable advertisementsTable;
    private javax.swing.JComboBox<String> categoryComboBox;
    private javax.swing.JLabel categoryLabel;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JTextField descriptionTextField;
    private javax.swing.JButton editButton;
    private javax.swing.JButton goButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lastLabel;
    private javax.swing.JLabel monthsLabel;
    private javax.swing.JPanel myAdvertisementsPanel;
    private javax.swing.JTable myAdvertisementsTable;
    private javax.swing.JComboBox<String> periodComboBox;
    private javax.swing.JLabel periodLabel;
    // End of variables declaration//GEN-END:variables
}
