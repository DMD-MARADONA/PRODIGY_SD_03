package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Userview extends JFrame{

    private JButton btnDelete;
    private JButton btnSaveContact;
    private JButton btnEditContact;
    private JTextField tflEmailAdress;
    private JTextField tflName;
    private JTextField tflNumber;
    public JPanel mainPanel;
    private JTextArea txaReport;
    private String selectedContact;
    private Boolean booNewContact = true;
    private int intOperationCount = 0;
    private final int intArrContactsSize = 20;
    String[] arrContacts = new String[intArrContactsSize];
    JList<String> lstContacts;
    public Userview() {
        arrContacts[0] = "Danai 0638487596 drchitengud@gmail.com";
        lstContacts.setListData(arrContacts);
        btnEditContact.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                booNewContact = false;
                selectedContact = (String)lstContacts.getSelectedValue();
                lstContacts.clearSelection();
                String[] contactDetails = selectedContact.split(" ");
                int intLength = contactDetails.length;
                String strEmail = contactDetails[intLength-1];
                String strPhone = contactDetails[intLength-2];
                String strFullNames = "";
                for(int i = 0; i<intLength-2;i++){
                    if(i==0){
                        strFullNames = contactDetails[i];
                    }else{
                        strFullNames = strFullNames.concat(" " + contactDetails[i]);
                    }
                }
                tflName.setText(strFullNames);
                tflNumber.setText(strPhone);
                tflEmailAdress.setText(strEmail);
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedContact = (String)lstContacts.getSelectedValue();
                lstContacts.clearSelection();
                int i =0,x = 0,y = 1;
                for(String contact:arrContacts){
                    if (Objects.equals(contact, selectedContact)){
                        x = 1;
                    }
                    if(x==y){
                        arrContacts[i] = null;
                    }
                    if(x==y&&i<18){
                        if(arrContacts[i+1]!=null){
                            arrContacts[i] = arrContacts[i+1];
                        }
                    }
                    i++;
                }
                lstContacts.setListData(arrContacts);
                txaReport.setText(selectedContact + " Deleted");
            }
        });
        btnSaveContact.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String strName = tflName.getText();
                String strPhone = tflNumber.getText();
                String strEmail = tflEmailAdress.getText();
                String strContactUpdate = strName +" " + strPhone + " " + strEmail;
                if (!booNewContact) {
                    for(int i=0;i<intArrContactsSize;i++){
                        if(Objects.equals(arrContacts[i], selectedContact)&&intOperationCount==0){
                            arrContacts[i] = strContactUpdate;
                            intOperationCount++;
                        }
                    }
                    intOperationCount = 0;
                    txaReport.setText(selectedContact + " Updated");
                    booNewContact = true;
                } else {
                    for(int i=0;i<intArrContactsSize;i++){
                        if(arrContacts[i]==null&&intOperationCount==0){
                            arrContacts[i] = strContactUpdate;
                            intOperationCount++;
                        }
                    }
                    intOperationCount = 0;
                    txaReport.setText(strContactUpdate + " Saved");
                }
                lstContacts.setListData(arrContacts);
                tflName.setText(null);
                tflNumber.setText(null);
                tflEmailAdress.setText(null);
            }
        });
    }
}