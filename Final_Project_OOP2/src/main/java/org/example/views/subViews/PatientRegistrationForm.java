package org.example.views.subViews;

import org.example.CostumeWidgets.*;
import org.example.views.ExceptionWindow;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import static org.example.serveces.crud.insertOrUpdateQueriesBuilder.insertToPatientsTable;

public class PatientRegistrationForm extends JPanel {
    Label firstName, lastName, dateOfBirth, gender, address, contactNumber, email, emergencyContact, medicalHistory;
    TextField firstNameTextField, lastNameTextField, dateOfBirthTextField, addressTextField, contactNumberTextField, emailTextField, emergencyContactTextField;
    String[] genders = {"Male", "Female"};
    ComboBox genderDropDownMenu;
    TextArea medicalHistoryTextArea;
    Button registerButton;
    JPanel topPanel, topPanel1, topPanel2, topPanel3, topPanel4, bottomPanel, bottomPanel1, buttonPanel;

    public PatientRegistrationForm(){
        this.setLayout(new GridLayout(2, 0));

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

        // initializing of text fields
        firstNameTextField = new TextField(8);
        lastNameTextField = new TextField(8);
        dateOfBirthTextField = new TextField(8);
        addressTextField = new TextField(8);
        contactNumberTextField = new TextField(8);
        emailTextField = new TextField(8);
        emergencyContactTextField = new TextField(8);

        // initializing of combo box
        genderDropDownMenu = new ComboBox(genders);

        // initializing of text area
        medicalHistoryTextArea = new TextArea(3, 16);
        medicalHistoryTextArea.setLineWrap(true);
        medicalHistoryTextArea.setWrapStyleWord(true);

        // initializing of button
        registerButton = new Button("Register new Patient");
        registerButton.addActionListener(new RegistrationAction());

        // initializing of second rate panels
        topPanel1 = new JPanel();
        topPanel2 = new JPanel();
        topPanel3 = new JPanel();
        topPanel4 = new JPanel();
        bottomPanel1 = new JPanel();
        buttonPanel = new JPanel();

        // top panel 1 configurations
        topPanel1.setLayout(new GridLayout(0, 4));
        topPanel1.add(firstName);
        topPanel1.add(firstNameTextField);
        topPanel1.add(lastName);
        topPanel1.add(lastNameTextField);

        // top panel 2 configurations
        topPanel2.setLayout(new GridLayout(0, 4));
        topPanel2.add(dateOfBirth);
        topPanel2.add(dateOfBirthTextField);
        topPanel2.add(gender);
        topPanel2.add(genderDropDownMenu);

        // top panel 3 configurations
        topPanel3.setLayout(new GridLayout(0, 4));
        topPanel3.add(address);
        topPanel3.add(addressTextField);
        topPanel3.add(email);
        topPanel3.add(emailTextField);

        // top panel 4 configurations
        topPanel4.setLayout(new GridLayout(0, 4));
        topPanel4.add(contactNumber);
        topPanel4.add(contactNumberTextField);
        topPanel4.add(emergencyContact);
        topPanel4.add(emergencyContactTextField);

        // bottom panel 1 configurations
        bottomPanel1.setLayout(new GridLayout(2, 0));
        bottomPanel1.add(medicalHistoryTextArea);
        bottomPanel1.add(buttonPanel);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(registerButton);

        // adding the rest of the panels
        topPanel = new JPanel(new GridLayout(4, 0));
        bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        topPanel.add(topPanel1);
        topPanel.add(topPanel2);
        topPanel.add(topPanel3);
        topPanel.add(topPanel4);
        bottomPanel.add(bottomPanel1);
        this.add(topPanel);
        this.add(bottomPanel);
    }

    private class RegistrationAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            //TODO validation
            if(firstName.getText() == "")
                new ExceptionWindow("enter a first name");
            else if(firstName.getText().length() > 50)
                new ExceptionWindow("first name should be less than 50");
            else if(lastName.getText() == "")
                new ExceptionWindow("enter a last name");
            else if(lastName.getText().length() > 50)
                new ExceptionWindow("last name should be less than 50");
            //TODO registration
            HashMap<String, Object> map = new HashMap<>();
            map.put("first_name", firstNameTextField.getText());
            map.put("last_name", lastNameTextField.getText());
            if(!dateOfBirthTextField.getText().isEmpty())
                map.put("date_of_birth", dateOfBirthTextField.getText());
            map.put("gender", (String) genderDropDownMenu.getSelectedItem());
            if(!addressTextField.getText().isEmpty())
                map.put("address", addressTextField.getText());
            if(!emailTextField.getText().isEmpty())
                map.put("email", email.getText());
            if(!contactNumberTextField.getText().isEmpty())
                map.put("contact_number", contactNumberTextField.getAction());
            if(!emergencyContactTextField.getText().isEmpty())
                map.put("emergency_contact", emergencyContactTextField.getText());
            if(!medicalHistoryTextArea.getText().isEmpty())
                map.put("medical_history", medicalHistoryTextArea.getText());

            insertToPatientsTable(map);

            //TODO empty all fields
        }
    }
}
