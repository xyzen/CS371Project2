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
public class ModView extends javax.swing.JFrame {

    private Controller master;
    private String category;
    private String keyword;
    private String Sdate;
    private int date;
    private int Advertisement_ID;
    
    private String[] advertisementsTableColumns = { "Category", "Title", "Description", "Price" , "Date" };
    private String[] myAdvertisementsTableColumns = { "ID" , "Title", "Description", "Price", "Status", "Date" };
    
    
    /**
     * Creates new form UserView
     */
    public ModView(Controller c) {
        initComponents();
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

        unclaimedAdvertisementsTabPane = new javax.swing.JTabbedPane();
        myAdvertisementsPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        myAdvertisementsTable = new javax.swing.JTable();
        approveButton = new javax.swing.JButton();
        advertisementsPanel = new javax.swing.JPanel();
        categoryLabel = new javax.swing.JLabel();
        categoryComboBox = new javax.swing.JComboBox<>();
        periodComboBox = new javax.swing.JComboBox<>();
        periodLabel = new javax.swing.JLabel();
        descriptionTextField = new javax.swing.JTextField();
        goButton = new javax.swing.JButton();
        descriptionLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        unclaimedAdvertisementsTable = new javax.swing.JTable();
        claimAdButton = new javax.swing.JButton();
        lastLabel = new javax.swing.JLabel();
        monthsLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        approveButton.setText("Approve");
        approveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout myAdvertisementsPanelLayout = new javax.swing.GroupLayout(myAdvertisementsPanel);
        myAdvertisementsPanel.setLayout(myAdvertisementsPanelLayout);
        myAdvertisementsPanelLayout.setHorizontalGroup(
            myAdvertisementsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myAdvertisementsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(myAdvertisementsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
                    .addGroup(myAdvertisementsPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(approveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        myAdvertisementsPanelLayout.setVerticalGroup(
            myAdvertisementsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myAdvertisementsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(approveButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );

        unclaimedAdvertisementsTabPane.addTab("My Advertisements", myAdvertisementsPanel);

        categoryLabel.setText("Category:");

        categoryComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Electronics", "Cars and Trucks", "Housing", "Child Care" }));
        categoryComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryComboBoxActionPerformed(evt);
            }
        });

        periodComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3", "6", "12", " " }));
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

        unclaimedAdvertisementsTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(unclaimedAdvertisementsTable);

        claimAdButton.setText("Claim Ad");
        claimAdButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                claimAdButtonActionPerformed(evt);
            }
        });

        lastLabel.setText("Last");

        monthsLabel.setText("Months");

        javax.swing.GroupLayout advertisementsPanelLayout = new javax.swing.GroupLayout(advertisementsPanel);
        advertisementsPanel.setLayout(advertisementsPanelLayout);
        advertisementsPanelLayout.setHorizontalGroup(
            advertisementsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(advertisementsPanelLayout.createSequentialGroup()
                .addGroup(advertisementsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(advertisementsPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(advertisementsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(categoryLabel)
                            .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(advertisementsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(advertisementsPanelLayout.createSequentialGroup()
                                .addComponent(periodLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(advertisementsPanelLayout.createSequentialGroup()
                                .addComponent(lastLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(periodComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(monthsLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(advertisementsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(advertisementsPanelLayout.createSequentialGroup()
                                .addComponent(descriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(goButton))
                            .addComponent(descriptionLabel)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, advertisementsPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(claimAdButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(claimAdButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        unclaimedAdvertisementsTabPane.addTab("Unclaimed Advertisements", advertisementsPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(unclaimedAdvertisementsTabPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(unclaimedAdvertisementsTabPane)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void goButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goButtonActionPerformed
        this.category=categoryComboBox.getSelectedItem().toString();
        this.Sdate = periodComboBox.getSelectedItem().toString();
        this.date = Integer.parseInt(Sdate);
        this.keyword = descriptionTextField.getText();

        master.handleUserSTDTableRequest(category, date, keyword);

        // TODO add your handling code here
    }//GEN-LAST:event_goButtonActionPerformed

    private void categoryComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryComboBoxActionPerformed

    private void approveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approveButtonActionPerformed
        // TODO add your handling code here:
                int row = this.myAdvertisementsTable.getSelectedRow();
        
        if(row>=0){
            Advertisement_ID=Integer.parseInt((String)myAdvertisementsTable.getValueAt(row, 0));
        }
        master.handleApproveAdvertisement(Advertisement_ID);
    }//GEN-LAST:event_approveButtonActionPerformed

    private void claimAdButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_claimAdButtonActionPerformed
        // TODO add your handling code here:
                        int row = this.unclaimedAdvertisementsTable.getSelectedRow();
        
        if(row>=0){
            Advertisement_ID=Integer.parseInt((String)unclaimedAdvertisementsTable.getValueAt(row, 0));
        }
        master.handleClaimAdvertisement(Advertisement_ID);
    }//GEN-LAST:event_claimAdButtonActionPerformed

    private void periodComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_periodComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_periodComboBoxActionPerformed

    /**
     * @param args the command line arguments
     */
    
    //Populates the STD table for users in the view
    public void populateSTDTable(String[][] published_data){
        this.unclaimedAdvertisementsTable.setModel(new DefaultTableModel(published_data, advertisementsTableColumns));
    }
    
    //Populates the personal table for the user in the view
    public void populateMyTable(String[][] published_data){
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel advertisementsPanel;
    private javax.swing.JButton approveButton;
    private javax.swing.JComboBox<String> categoryComboBox;
    private javax.swing.JLabel categoryLabel;
    private javax.swing.JButton claimAdButton;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JTextField descriptionTextField;
    private javax.swing.JButton goButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lastLabel;
    private javax.swing.JLabel monthsLabel;
    private javax.swing.JPanel myAdvertisementsPanel;
    private javax.swing.JTable myAdvertisementsTable;
    private javax.swing.JComboBox<String> periodComboBox;
    private javax.swing.JLabel periodLabel;
    private javax.swing.JTabbedPane unclaimedAdvertisementsTabPane;
    private javax.swing.JTable unclaimedAdvertisementsTable;
    // End of variables declaration//GEN-END:variables
}
