package com.example.vaccinationcentre;

import javafx.fxml.FXML;

public class Appointment {

    private String date;
    private String time;
    private String vaccinationType;
    private String vaccinationId;
    private String vaccinatorDetails;
    private String patientId;
    public static RecordNode headRecord = null;

    public static Appointment cA;

    public Appointment(String date, String time, String vaccinationType, String vaccinationId, String vaccinatorDetails, String patientId) {
        this.date = date;
        this.time = time;
        this.vaccinationType = vaccinationType;

        if(Utilities.VCId(vaccinationId)) {
            this.vaccinationId = vaccinationId;
        }
        else {
            this.vaccinationId = "invalid Vaccination Id";
        }



        this.vaccinatorDetails = vaccinatorDetails;

        if(Utilities.validPPS(patientId)) {
            this.patientId = patientId;
        }
        else {
            this.patientId = "invalid Patient Id";
        }
    }

    //Getters

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getVaccinationType() {
        return vaccinationType;
    }

    public String getVaccinationId() {
        return vaccinationId;
    }

    public String getVaccinatorDetails() {
        return vaccinatorDetails;
    }

    public String getPatientId() {
        return patientId;
    }


    //Setters


    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setVaccinationType(String vaccinationType) {
        this.vaccinationType = vaccinationType;
    }

    public void setVaccinationId(String vaccinationId) {
        if(Utilities.VCId(vaccinationId)) {
            this.vaccinationId = vaccinationId;
        }
        else {
            this.vaccinationId = "invalid Vaccination Id";
        }
    }

    public void setVaccinatorDetails(String vaccinatorDetails) {
        this.vaccinatorDetails = vaccinatorDetails;
    }

    public void setPatientId(String patientId) {
        if(Utilities.validPPS(patientId)) {
            this.patientId = patientId;
        }
        else {
            this.patientId = "invalid Patient Id";
        }
    }

    // Record Methods ------------------------------------------------------------------------------------------------

    /**
     * This method collects the data required to create a Record
     */
    public void addRecord()
    {
        VaccinationRecord record = new VaccinationRecord(
                ControllerRecord.conR.txtRecordDate.getText(), ControllerRecord.conR.txtRecordId.getText());
        addRecordToList(record);
    }

    /**
     * This method adds a new record node to the top of the linked list
     * @param vaccinationRecord
     */
    public void addRecordToList(VaccinationRecord vaccinationRecord) {
        RecordNode recordNode = new RecordNode();
        recordNode.setContents(vaccinationRecord);
        recordNode.setNext(headRecord);
        headRecord = recordNode;
    }


    /**
     * This method displays all the Record nodes in a list view
     */
    @FXML
    public static void showRecord(){
        RecordNode currentNodeR = headRecord;
        ControllerBooth.conB.blankField2.getItems().clear();
        if(currentNodeR == null){
            ControllerRecord.conR.tableView.getItems().add("no Records found");
        }
        else{
            String ap = "";
            while
            (currentNodeR != null) {
                ControllerRecord.conR.tableView.getItems().clear();
                ControllerRecord.conR.tableView.getItems().add(currentNodeR.contents);
                ap += currentNodeR.contents + "\n ";
                currentNodeR = currentNodeR.next;
            }
        }
    }

    //--------------------------------------------------------------------------------------------------------------

    @Override
    public String toString() {
        return
                ",  date='" + date + '\'' +
                ",  time='" + time + '\'' +
                ",  vaccinationType='" + vaccinationType + '\'' +
                ",  vaccinationId='" + vaccinationId +'\'' +
                ",  vaccinatorDetails='" + vaccinatorDetails + '\'' +
                ",  patientId='" + patientId + '\'' +
                '}';
    }
    public void initialize(){
        cA=this;
    }
}
