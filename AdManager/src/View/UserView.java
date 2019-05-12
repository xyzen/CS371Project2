package View;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Controller.Controller;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author christopheraramswayne
 */
public class UserView extends javax.swing.JFrame {

    private final Controller master;
    
    private final String username;
    private final String userID;
    private String category;
    private String keyword;
    private String str_date;
    private String advID;
    
    private final Object[] advertisementsTableColumns = { "Title", "Description", "Price" , "Date" };
    private final Object[] myAdvertisementsTableColumns = { "ID" , "Title", "Description", "Price", "Status", "Date" };
    
    
    /**
     * Creates new form UserView
     * @param c
     * @param usrID
     * @param usrName
     * Instantiates the UserView window
     */
    public UserView(Controller c, String usrID, String usrName) {
        initComponents();
        noResultLabel.setVisible(false);
        noResultsLabel1.setVisible(false);
        userID = usrID;
        username = usrName;
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
        noResultLabel = new javax.swing.JLabel();
        myAdvertisementsPanel = new javax.swing.JPanel();
        deleteButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        myAdvertisementsTable = new javax.swing.JTable();
        addAdvertisementButton = new javax.swing.JButton();
        noResultsLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        categoryLabel.setText("Category:");

        categoryComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Electronics", "Cars and Trucks", "Housing", "Child Care" }));

        periodComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Last 3 Months", "Last 6 Months", "Last 12 Months", "Life" }));

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
        advertisementsTable.setFillsViewportHeight(true);
        jScrollPane1.setViewportView(advertisementsTable);

        noResultLabel.setText("No results found.");

        javax.swing.GroupLayout advertisementsPanelLayout = new javax.swing.GroupLayout(advertisementsPanel);
        advertisementsPanel.setLayout(advertisementsPanelLayout);
        advertisementsPanelLayout.setHorizontalGroup(
            advertisementsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(advertisementsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(advertisementsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(categoryLabel)
                    .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(advertisementsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(periodComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(periodLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(advertisementsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(advertisementsPanelLayout.createSequentialGroup()
                        .addComponent(descriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(goButton)
                        .addGap(25, 25, 25)
                        .addComponent(noResultLabel))
                    .addComponent(descriptionLabel))
                .addContainerGap(338, Short.MAX_VALUE))
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
                    .addComponent(noResultLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE))
        );

        periodComboBox.getAccessibleContext().setAccessibleName("");

        advertisementsTabPane.addTab("Advertisements", advertisementsPanel);

        myAdvertisementsPanel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                myAdvertisementsPanelComponentShown(evt);
            }
        });

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
        myAdvertisementsTable.setFillsViewportHeight(true);
        jScrollPane2.setViewportView(myAdvertisementsTable);

        addAdvertisementButton.setText("Add Advertisement");
        addAdvertisementButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAdvertisementButtonActionPerformed(evt);
            }
        });

        noResultsLabel1.setText("No results found.");

        javax.swing.GroupLayout myAdvertisementsPanelLayout = new javax.swing.GroupLayout(myAdvertisementsPanel);
        myAdvertisementsPanel.setLayout(myAdvertisementsPanelLayout);
        myAdvertisementsPanelLayout.setHorizontalGroup(
            myAdvertisementsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myAdvertisementsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addAdvertisementButton)
                .addGap(18, 18, 18)
                .addComponent(editButton)
                .addGap(18, 18, 18)
                .addComponent(deleteButton)
                .addGap(18, 18, 18)
                .addComponent(noResultsLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1042, Short.MAX_VALUE)
        );
        myAdvertisementsPanelLayout.setVerticalGroup(
            myAdvertisementsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myAdvertisementsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(myAdvertisementsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editButton)
                    .addComponent(addAdvertisementButton)
                    .addComponent(deleteButton)
                    .addComponent(noResultsLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE))
        );

        advertisementsTabPane.addTab("My Advertisements", myAdvertisementsPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(advertisementsTabPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(advertisementsTabPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //When the "Add Advertisement" button is pushed, the view will tell the controller
    //that the button was pushed. The controller will handle the action afterwards.
    private void addAdvertisementButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAdvertisementButtonActionPerformed
        master.handleAddButton(userID, username);
        //Controller "master" will open the AddAdvertisement window
    }//GEN-LAST:event_addAdvertisementButtonActionPerformed

    //When the "Edit" button is pushed, the view will tell the controller that the
    //button was pressed. The controller will be given the Advertisement ID to handle
    //editing the correct ad.
    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        int row = this.myAdvertisementsTable.getSelectedRow();
        
        if(row>=0){
            advID=(String)myAdvertisementsTable.getValueAt(row, 0);
        }
        master.handleEditButton(advID, userID);
        master.handleUserMyTableRequest(userID);
    }//GEN-LAST:event_editButtonActionPerformed

    //When the "Delete" button is pushed, the view will tell the controller that
    //the button was pushed. The controller will be given the Advertisement ID to 
    //handle deleting the correct ad.
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int row = this.myAdvertisementsTable.getSelectedRow();
        
        if(row>=0){
            advID=(String)myAdvertisementsTable.getValueAt(row, 0);
        }
        master.handleDeleteRequest(advID);
        master.handleUserMyTableRequest(userID);
        
        //Controller "master" will handle deleting the advertisement from the database.        
    }//GEN-LAST:event_deleteButtonActionPerformed

    //When the "Go" button is pressed, the view will tell the controller that the
    //button was pushed. The controller will be given the query terms to handle
    //a request to fill the table
    private void goButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goButtonActionPerformed
        
        category=categoryComboBox.getSelectedItem().toString();
        str_date = periodComboBox.getSelectedItem().toString();
        keyword = descriptionTextField.getText();
        master.handleUserSTDTableRequest(category, str_date, keyword);
    }//GEN-LAST:event_goButtonActionPerformed

    //Unnecessary code, that is unable to be removed. 
    private void periodComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_periodComboBoxActionPerformed
    }//GEN-LAST:event_periodComboBoxActionPerformed

    
    //When the panel under myAdvertisements are shown to the user, the table is then requested, and populated.
    private void myAdvertisementsPanelComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_myAdvertisementsPanelComponentShown
        master.handleUserMyTableRequest(userID);
    }//GEN-LAST:event_myAdvertisementsPanelComponentShown

    //Populates the STD table for users in the view
    public void populateSTDTable(Object[][] published_data){
        this.advertisementsTable.setModel(new DefaultTableModel(published_data, advertisementsTableColumns));
        noResultLabel.setVisible(false);
    }
    
    //Populates the personal table for the users in the view
    public void populateMyTable(Object[][] user_data){
        this.myAdvertisementsTable.setModel(new DefaultTableModel(user_data, myAdvertisementsTableColumns));
        noResultsLabel1.setVisible(false);
    }
    
    //When an empty table returned from a query, the displayed table needs to be set to a default value.
    //thus, an empty table.
    public void resetSTDTable () {
        DefaultTableModel model = (DefaultTableModel) advertisementsTable.getModel();
        model.setRowCount(0);
        noResultLabel.setVisible(true);
    }
    
    //When the user has no advertisements, the query returns empty, and thus the
    //table displayed will reflect that.
    public void resetMyTable () {
        DefaultTableModel model = (DefaultTableModel) myAdvertisementsTable.getModel();
        model.setRowCount(0);
        noResultsLabel1.setVisible(true);
        
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
    private javax.swing.JPanel myAdvertisementsPanel;
    private javax.swing.JTable myAdvertisementsTable;
    private javax.swing.JLabel noResultLabel;
    private javax.swing.JLabel noResultsLabel1;
    private javax.swing.JComboBox<String> periodComboBox;
    private javax.swing.JLabel periodLabel;
    // End of variables declaration//GEN-END:variables
}
