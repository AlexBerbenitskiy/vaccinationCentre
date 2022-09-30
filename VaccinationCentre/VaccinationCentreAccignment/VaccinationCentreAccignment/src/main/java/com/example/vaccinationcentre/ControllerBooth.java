package com.example.vaccinationcentre;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ControllerBooth {

    public static ControllerBooth conB;

    @FXML
    public ListView blankField2;

    @FXML
    public Button listBooths;

    @FXML
    public Button addBooth;

    @FXML
    public TextField txtAccess;

    @FXML
    public TextField txtBoothId;

    @FXML
    public ListView listVcBooth;

    @FXML
    public TextField txtFloor;



    //CALLED METHODS FROM VACCINATION CENTRE-----------------------------------------------------------------------


    /**
     * Method which calls the delete method after selecting an item from the list view.
     */
    @FXML
    public void deleteBoothBtn(){
        int vcToBeDeleted = blankField2.getSelectionModel().getSelectedIndex();
        VaccinationCentre.deleteBooth(vcToBeDeleted);
        VaccinationCentre.showBooth();
    }


    /**
     * This method displays the vaccination centres in a list view
     */
    @FXML
    public void showVcListView() {
        VaccinationCentreNode currentNode = Controller.con.head;
        listVcBooth.getItems().clear();
        if(currentNode == null){
            listVcBooth.getItems().add("no vaccination Booths found");
        }
        else if (currentNode != null){
            while(currentNode != null) {
                listVcBooth.getItems().add(currentNode.getContents());
                currentNode = currentNode.next;
            }
        }
    }

    /**
     * This method calls the method in VaccinationCentre and lets it view booths.
     */
    public void showBooth(ActionEvent actionEvent) {
        VaccinationCentre chosenVc = (VaccinationCentre) listVcBooth.getSelectionModel().getSelectedItem();
        if (chosenVc != null)
            chosenVc.showBooth();
    }


    /**
     * This method calls the add booth method from vaccination centre which adds all the required data and creates a booth
     * As well as that this method adds the chosen vaccination centre to be associated with the booth
     * @param actionEvent
     */
    public void addBoothToList(ActionEvent actionEvent) {
        VaccinationCentre chosenVc = (VaccinationCentre) listVcBooth.getSelectionModel().getSelectedItem();
        if (chosenVc != null)

        {
            chosenVc.addVaccinationBooth();
        }
    }


    // ----------------------------------------------------------------------------------------------------------------------------

    public void initialize(){
        conB=this;
    }
}
