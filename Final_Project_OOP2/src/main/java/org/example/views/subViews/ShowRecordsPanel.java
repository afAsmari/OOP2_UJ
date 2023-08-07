package org.example.views.subViews;

import org.example.CostumeWidgets.Label;
import org.example.CostumeWidgets.TextArea;
import org.example.CostumeWidgets.TextField;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class ShowRecordsPanel extends JPanel {
    Label firstName, lastName, dateOfBirth, gender, address, contactNumber, email, emergencyContact, medicalHistory;
    TextField firstNameValue, lastNameValue, dateOfBirthValue,genderValue, addressValue, contactNumberValue, emailValue, emergencyContactValue;
    TextArea medicalHistoryValue;

    JPanel mainPanel,secondryPanel, topPanel1, topPanel2, topPanel3, topPanel4, topPanel5;
    public ShowRecordsPanel(HashMap<String, Object> map){
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

        // initializing of empty labels
        firstNameValue = new TextField();
        lastNameValue = new TextField();
        dateOfBirthValue = new TextField();
        genderValue = new TextField();
        addressValue = new TextField();
        emailValue = new TextField();
        contactNumberValue = new TextField();
        emergencyContactValue = new TextField();
        medicalHistoryValue = new TextArea();

        // initializing the other labels
        if(map.get("first_name") != null)
            firstNameValue.setText((String) map.get("first_name"));
        if(map.get("last_name") != null)
            lastNameValue.setText((String) map.get("last_name"));
        if(map.get("date_of_birth") != null)
            dateOfBirthValue.setText((String) map.get("date_of_birth"));
        if(map.get("gender") != null)
            genderValue.setText((String) map.get("gender"));
        if(map.get("address") != null)
            addressValue.setText((String) map.get("address"));
        if(map.get("contact_number") != null)
            contactNumberValue.setText((String) map.get("contact_number"));
        if(map.get("email") != null)
            emailValue.setText((String) map.get("email"));
        if(map.get("emergency_contact") != null)
            emergencyContactValue.setText((String) map.get("emergency_contact"));
        if(map.get("medical_history") != null)
            medicalHistoryValue.setText((String) map.get("medical_history"));

        // initializing of second rate panels
        topPanel1 = new JPanel();
        topPanel2 = new JPanel();
        topPanel3 = new JPanel();
        topPanel4 = new JPanel();
        topPanel5 = new JPanel();

        topPanel1.setLayout(new GridLayout(2, 2));
        topPanel1.add(firstName);
        topPanel1.add(firstNameValue);
        topPanel1.add(lastName);
        topPanel1.add(lastNameValue);
        topPanel1.setBackground(Color.blue);

        topPanel2.setLayout(new GridLayout(2, 2));
        topPanel2.add(address);
        topPanel2.add(addressValue);
        topPanel2.add(email);
        topPanel2.add(emailValue);
        topPanel2.setBackground(Color.black);

        topPanel3.setLayout(new GridLayout(2, 2));
        topPanel3.add(contactNumber);
        topPanel3.add(contactNumberValue);
        topPanel3.add(emergencyContact);
        topPanel3.add(emergencyContactValue);
        topPanel3.setBackground(Color.red);

        topPanel4.setLayout(new GridLayout(0, 2));
        topPanel4.add(dateOfBirth);
        topPanel4.add(dateOfBirthValue);
        topPanel4.setBackground(Color.green);

        topPanel5.setLayout(new GridLayout(0, 2));
        topPanel5.add(medicalHistory);
        topPanel5.add(medicalHistoryValue);
        topPanel5.setBackground(Color.orange);

        secondryPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        secondryPanel.add(topPanel1);
        secondryPanel.add(topPanel2);
        secondryPanel.add(topPanel3);
        secondryPanel.add(topPanel4);
        secondryPanel.add(topPanel5);
        mainPanel = new JPanel();
        mainPanel.add(secondryPanel);

        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.add(mainPanel);

    }
}