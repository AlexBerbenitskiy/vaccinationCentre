package com.example.vaccinationcentre;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ControllerAppointment {

    public static ControllerAppointment conA;

    @FXML
    public TextField txtAppDate;
    @FXML
    public TextField txtAppTime;
    @FXML
    public TextField txtAppVcType;
    @FXML
    public TextField txtAppVcId;
    @FXML
    public TextField txtAppVcDetails;
    @FXML
    public TextField txtPatientDetails;
    @FXML
    public Button AppListBooths;
    @FXML
    public TextArea blankFieldA;
    @FXML
    public ListView listViewA;
    @FXML
    public ComboBox comBox;
    @FXML
    public ListView blankFieldListViewA;
    @FXML
    public ListView listViewId;


    //CALLED METHODS FROM Vaccination Booth -----------------------------------------------------------------------

    /**
     * This method lists all vaccination booths in a list view
     */
    @FXML
    public void appListBooths() {
        VaccinationBoothNode currentNode = VaccinationCentre.headBooth;
        listViewA.getItems().clear();
        if(currentNode == null){
            listViewA.getItems().add("no vaccination Booths found");
        }
        else if (currentNode != null){
            while(currentNode != null) {
                listViewA.getItems().add(currentNode.getContents());
                currentNode = currentNode.next;
            }
        }
    }

    /**
     * Calls a method from Controller Patient which displays patient Ids in the desired list view.
     */
    @FXML
    public void appListIds() {
        listViewId.getItems().clear();
        ControllerPatient.showPatientsGivenList(listViewId);
        }


    /**
     * This method calls the method in VaccinationBooth and lets it view Appointments.
     */
    public void showAppointment(ActionEvent actionEvent) {
        VaccinationBooth chosenB = (VaccinationBooth) listViewA.getSelectionModel().getSelectedItem();
        if (chosenB != null)
            blankFieldListViewA.getItems().clear();
            chosenB.showAppointment();
    }

    /**
     * This method calls a method which in turn creates a new Appointment node after collecting all the requires contents
     * @param actionEvent
     */
    public void addAppointmentToList(ActionEvent actionEvent) {
        VaccinationBooth chosenVb = (VaccinationBooth) listViewA.getSelectionModel().getSelectedItem();
        if (chosenVb != null)

        {
            chosenVb.addAppointment();
        }
    }

    /**
     * Calls a method which deleted the selected appointment from the system.
     */
    @FXML
    public void deleteAppointmentBtn(){
        int aToBeDeleted = blankFieldListViewA.getSelectionModel().getSelectedIndex();
        VaccinationBooth.deleteAppoinemtnt(aToBeDeleted);
        blankFieldListViewA.getItems().clear();
        VaccinationBooth.showAppointment();
    }



    // ----------------------------------------------------------------------------------------------------------------------------

    public void initialize(){
        conA=this;
    }
}
