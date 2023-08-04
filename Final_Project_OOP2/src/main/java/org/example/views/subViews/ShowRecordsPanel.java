package org.example.views.subViews;

import org.example.CostumeWidgets.Label;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class ShowRecordsPanel extends JPanel {
    Label firstName, lastName, dateOfBirth, gender, address, contactNumber, email, emergencyContact, medicalHistory;
    Label firstNameValue, lastNameValue, dateOfBirthValue,genderValue, addressValue, contactNumberValue, emailValue, emergencyContactValue, medicalHistoryValue;

    JPanel mainPanel, topPanel1, topPanel2, topPanel3, topPanel4;
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
        firstNameValue = new Label("");
        lastNameValue = new Label("");
        dateOfBirthValue = new Label("");
        genderValue = new Label("");
        addressValue = new Label("");
        emailValue = new Label("");
        contactNumberValue = new Label("");
        emergencyContactValue = new Label("");
        medicalHistoryValue = new Label("");

        // initializing the other labels
        if(map.get("first_name") != null)
            firstNameValue = new Label((String) map.get("first-name"));
        if(map.get("last_name") != null)
            lastNameValue = new Label((String) map.get("last_name"));
        if(map.get("date_of_birth") != null)
            dateOfBirthValue = new Label((String) map.get("date_of_birth"));
        if(map.get("gender") != null)
            genderValue = new Label((String) map.get("gender"));
        if(map.get("address") != null)
            addressValue = new Label((String) map.get("address"));
        if(map.get("contact_number") != null)
            contactNumberValue = new Label((String) map.get("contact_number"));
        if(map.get("email") != null)
            emailValue = new Label((String) map.get("email"));
        if(map.get("emergency_contact") != null)
            emergencyContactValue = new Label((String) map.get("emergency_contact"));
        if(map.get("medical_history") != null)
            medicalHistoryValue = new Label((String) map.get("medical_history"));

        // initializing of second rate panels
        topPanel1 = new JPanel();
        topPanel2 = new JPanel();
        topPanel3 = new JPanel();
        topPanel4 = new JPanel();

        topPanel1.setLayout(new GridLayout(0, 6));
        topPanel1.add(firstName);
        topPanel1.add(firstNameValue);
        topPanel1.add(lastName);
        topPanel1.add(lastNameValue);
        topPanel1.add(dateOfBirth);
        topPanel1.add(dateOfBirthValue);

        topPanel2.setLayout(new GridLayout(0, 6));
        topPanel2.add(address);
        topPanel2.add(addressValue);
        topPanel2.add(email);
        topPanel2.add(emailValue);
        topPanel2.add(contactNumber);
        topPanel2.add(contactNumberValue);

        topPanel3.setLayout(new GridLayout(0, 2));
        topPanel3.add(emergencyContact);
        topPanel3.add(emergencyContactValue);

        topPanel4.setLayout(new FlowLayout(FlowLayout.CENTER));
        topPanel4.add(medicalHistory);
        topPanel4.add(medicalHistoryValue);

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(0, 4));
        mainPanel.add(topPanel1);
        mainPanel.add(topPanel2);
        mainPanel.add(topPanel3);
        mainPanel.add(topPanel4);
        this.setLayout(new BorderLayout());
        this.add(mainPanel, BorderLayout.CENTER);

    }
}
