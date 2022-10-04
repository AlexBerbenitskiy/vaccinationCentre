package com.example.vaccinationcentre;
import javafx.fxml.FXML;

public class VaccinationBooth {

    private String boothId;
    private String floorLevel;
    private String accessInfo;
    public static AppointmentNode headAppointment = null;

    public VaccinationBooth(String boothId, String floorLevel, String accessInfo) {
        this.boothId = boothId;

        if(Utilities.onlyContainsNumbers(floorLevel)) {
            this.floorLevel = floorLevel;
        }
        else{
            this.floorLevel = "invalid floor level";
        }

        this.accessInfo = accessInfo;
    }

    //Getters
    public String getBoothId() {
        return boothId;
    }

    public String getFloorLevel() {
        return floorLevel;
    }

    public String getAccessInfo() {
        return accessInfo;
    }


    //Setters
    public void setBoothId(String boothId) {
        this.boothId = boothId;
    }

    public void setFloorLevel(String floorLevel) {
        if (Utilities.onlyContainsNumbers(floorLevel)) {
            this.floorLevel = floorLevel;
        } else {
            this.floorLevel = "invalid floor level";
        }
    }

    public void setAccessInfo(String accessInfo) {
        this.accessInfo = accessInfo;
    }


    //Appointment Methods----------------------------------------------------------------------------


    /**
     * This method collects the data required to create an Appointment.
     */
    public void addAppointment() {
        Appointment appointment = new Appointment(
                ControllerAppointment.conA.txtAppDate.getText(), ControllerAppointment.conA.txtAppTime.getText(),
                ControllerAppointment.conA.txtAppVcType.getText(), ControllerAppointment.conA.txtAppVcId.getText(),
                ControllerAppointment.conA.txtAppVcDetails.getText(), ControllerAppointment.conA.listViewId.getId());
        addAppointmentToList(appointment);
    }


    /**
     * This method adds a new appointment node to the top of the linked list
     * @param appointment
     */
    public void addAppointmentToList(Appointment appointment){
        AppointmentNode appNode = new AppointmentNode();
        appNode.setContents(appointment);
        appNode.setNext(headAppointment);
        headAppointment = appNode;
    }


    /**
     * This method displays all the Appointment nodes in a list view
     */
    @FXML
    public static void showAppointment(){
        AppointmentNode currentNodeA = headAppointment;
        ControllerBooth.conB.blankField2.getItems().clear();
        if(currentNodeA == null){
            ControllerAppointment.conA.blankFieldListViewA.getItems().add("no Appointments found");
        }
        else{
            String ap = "";
            while
            (currentNodeA != null) {
                ControllerAppointment.conA.blankFieldListViewA.getItems().add(currentNodeA.contents);
                ap += currentNodeA.contents + "\n ";
                currentNodeA = currentNodeA.next;
            }
        }
    }


    /**
     * This method displays all the Appointment nodes in a list view
     */
    @FXML
    public static void showPendingAppointments(){
        AppointmentNode currentNodeA = headAppointment;
        ControllerBooth.conB.blankField2.getItems().clear();
        if(currentNodeA == null){
            ControllerRecord.conR.tableView.getItems().add("no Appointments found");
        }
        else{
            String ap = "";
            while
            (currentNodeA != null) {
                ControllerRecord.conR.tableView.getItems().clear();
                ControllerRecord.conR.tableView.getItems().add(currentNodeA.contents);
                ap += currentNodeA.contents + "\n ";
                currentNodeA = currentNodeA.next;
            }
        }
    }

    /**
     * This method was discovered on https://blog.devgenius.io/how-to-make-a-custom-linkedlist-3deee9d5d9e4
     * This method deletes an appointment from the linked list by skipping over the node that is to be deleted
     * @param index
     */
    public static void deleteAppoinemtnt(int index) {
        if(index == 0) {
            headAppointment = headAppointment.next;
        }else{
            AppointmentNode aNode = headAppointment;
            for(int i = 0; i < index - 1; i++) {
                aNode = aNode.next;
            }
            aNode.next = aNode.next.next;
        }
    }


    //------------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return
             //   "Vaccination Centre= '" + VaccinationCentre.vaccinationName() + '\'' + ",  " +
                        " boothId ='" + boothId + '\'' +
                ",   floorLevel= '" + floorLevel + '\'' +
                ",   accessInfo= '" + accessInfo + '\'' +
                '}';
    }
}
