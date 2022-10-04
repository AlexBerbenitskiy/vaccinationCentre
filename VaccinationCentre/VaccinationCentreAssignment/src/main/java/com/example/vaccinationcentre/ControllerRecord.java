package com.example.vaccinationcentre;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ControllerRecord {

    public static ControllerRecord conR;

    @FXML
    public TextField txtSearchVc;
    @FXML
    public Button searchforVc;
    @FXML
    public ListView tableView;
    @FXML
    public ListView listViewRecord;
    @FXML
    public TextField txtRecordDate;
    @FXML
    public TextField txtRecordId;


    /**
     * This method finds the Vaccination Centre with the batch number that the user puts in.
     */
    public void searchVaccinations() {
        String soughtId = txtSearchVc.getText();
        AppointmentNode temp = VaccinationBooth.headAppointment;
        while (temp != null ){
            if(temp.getContents().getVaccinationId().equals(soughtId) || temp.getContents().getVaccinationType().equals(soughtId))
                listViewRecord.getItems().clear();
                listViewRecord.getItems().add( temp.getContents());
            temp = temp.next;


        }

    }

    /**
     * This method finds the Records with the Id number that the user puts in.
     */
    public void searchRecords() {
        String soughtId = txtSearchVc.getText();
        RecordNode temp = Appointment.headRecord;
        while (temp != null ){
            if(temp.getContents().getRecordId().equals(soughtId))
                listViewRecord.getItems().clear();
            listViewRecord.getItems().add( temp.getContents());
            temp = temp.next;


        }

    }




    /**
     * This method calls the method in VaccinationBooth and lets it view Appointments.
     */
    public void showAppointment(ActionEvent actionEvent) {
        tableView.getItems().clear();
        VaccinationBooth chosenB = (VaccinationBooth) tableView.getSelectionModel().getSelectedItem();
                ControllerAppointment.conA.listViewA.getSelectionModel().getSelectedItem();
        if (chosenB != null)
            tableView.getItems().clear();
        chosenB.showPendingAppointments();
    }


    /**
     * This method calls a method which in turn displays all record nodes and their contents.
     * @param actionEvent
     */
    public void showRecord(ActionEvent actionEvent) {
        tableView.getItems().clear();
        Appointment chosenB = (Appointment) tableView.getSelectionModel().getSelectedItem();
        ControllerAppointment.conA.listViewA.getSelectionModel().getSelectedItem();
        if (chosenB != null)
            tableView.getItems().clear();
        chosenB.showRecord();
    }


    /**
     * This method calls a method which creates a new record node with all the selected contents while also removing
     * the selected pending apointment.
     * @param actionEvent
     */
    @FXML
    public void addRecordToList(ActionEvent actionEvent) {
        Appointment chosenA = ((Appointment) tableView.getSelectionModel().getSelectedItem());
        if (chosenA != null)

        {
            chosenA.addRecord();
            deleteAppointmentBtn();
        }
    }

    /**
     * Deletes the selected appointment from the system
     */
    @FXML
    public void deleteAppointmentBtn(){
        int aToBeDeleted = tableView.getSelectionModel().getSelectedIndex();
        VaccinationBooth.deleteAppoinemtnt(aToBeDeleted);
        tableView.getItems().clear();
        VaccinationBooth.showPendingAppointments();
    }


    public void initialize(){
        conR=this;
    }
}
