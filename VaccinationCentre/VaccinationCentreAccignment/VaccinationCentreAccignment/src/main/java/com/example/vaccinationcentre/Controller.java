package com.example.vaccinationcentre;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Scanner;

public class Controller {
    public static Controller con;

    @FXML
    public Button listButton;
    @FXML
    public Button reset;
    @FXML
    public ListView blankFieldListView;
    @FXML
    public TextArea blankFieldA;
    @FXML
    public TextField txtName;
    @FXML
    public TextField txtAddress;
    @FXML
    public TextField txtEircode;
    @FXML
    public TextField txtParking;


    public static VaccinationCentreNode head=null;
    Scanner input = new Scanner(System.in);





    //VACCINATION CENTRE METHODS ------------------------------------------------------------




    /**
     * This method displays all the vaccination centre nodes in a list view
     */
    @FXML
    public void showVc() {
        VaccinationCentreNode currentNode = head;
        blankFieldListView.getItems().clear();
        if(currentNode == null){
           blankFieldListView.getItems().add("no vaccination centres found");
        }
        else{
            String vcs = "";
            while
            (currentNode != null) {
                blankFieldListView.getItems().add(currentNode.contents);
                vcs += currentNode.contents + "\n ";
                currentNode = currentNode.next;
            }
        }
    }


    /**
     * This method collects the data required to create a vaccination centre.
     */
    public void addVaccinationCentre(){
        VaccinationCentre vc = new VaccinationCentre(txtName.getText(),txtAddress.getText(),txtEircode.getText(),txtParking.getText());
        addVcToList(vc);
    }

    /**
     * This method adds a new vaccination centre node to the top of the linked list
     * @param vc
     */
    public void addVcToList(VaccinationCentre vc){
        VaccinationCentreNode vcNode = new VaccinationCentreNode();
        vcNode.setContents(vc);
        vcNode.setNext(head);
        head = vcNode;
    }

    /**
     * Method which calls the delete method after selecting an item from the list view.
     */
    @FXML
    public void deleteVcBtn(){
        int vcToBeDeleted = blankFieldListView.getSelectionModel().getSelectedIndex();
        deleteVc(vcToBeDeleted);
        showVc();

    }

    /**
     * This method deletes an vaccination centre from the linked list by skipping over the node that is to be deleted
     * @param index
     */
    public void deleteVc(int index) {
        if(index == 0) {
            head = head.next;
        }else{
            VaccinationCentreNode vcNode = head;
            for(int i = 0; i < index - 1; i++) {
                vcNode = vcNode.next;
            }
            vcNode.next = vcNode.next.next;
        }
    }


    public void initialize(){

        con=this;
    }

    /**
     * This method resets the data in the program to its original state.
     * All list views, blank fields ect are cleared of data.
     * It also calls the clear() method from VaccinationCentre.
     * @param actionEvent
     */
    public void resetFacility(ActionEvent actionEvent) {
        blankFieldListView.getItems().clear();
        ControllerBooth.conB.blankField2.getItems().clear();
        ControllerBooth.conB.listVcBooth.getItems().clear();
        ControllerPatient.conP.blankFieldListViewP.getItems().clear();
        ControllerAppointment.conA.blankFieldListViewA.getItems().clear();
        ControllerAppointment.conA.listViewId.getItems().clear();
        ControllerAppointment.conA.listViewA.getItems().clear();
        ControllerRecord.conR.listViewRecord.getItems().clear();
        ControllerRecord.conR.tableView.getItems().clear();
        VaccinationCentre.clear();
    }
}