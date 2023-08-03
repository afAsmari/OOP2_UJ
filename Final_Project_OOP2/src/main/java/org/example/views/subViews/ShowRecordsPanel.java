package org.example.views.subViews;

import org.example.CostumeWidgets.*;

import javax.swing.*;

public class ShowRecordsPanel extends JPanel {
    Label firstName, lastName, dateOfBirth, gender, address, contactNumber, email, emergencyContact, medicalHistory;

    public ShowRecordsPanel(){
        // initializing of labels
        firstName = new Label("First Name:");
        lastName = new Label("Last Name:");
        dateOfBirth = new Label("Date Of Birth:");
        gender = new Label("Gender:");
        address = new Label("Address:");
        contactNumber = new Label("Contact Number:");
        email = new Label("Email: ");
        emergencyContact = new Label("Emergency Contact:");
        medicalHistory = new Label("Medical History:");


    }
}
