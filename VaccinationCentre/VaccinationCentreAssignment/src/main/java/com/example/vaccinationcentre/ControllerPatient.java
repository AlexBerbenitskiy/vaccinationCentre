package com.example.vaccinationcentre;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


public class ControllerPatient {
    public static PatientNode headPatient = null;

    public static ControllerPatient conP;

    @FXML
    public ListView listViewP;
    @FXML
    public ListView blankFieldListViewP;
    @FXML
    public TextField txtPatientId;
    @FXML
    public TextField txtPatientName;
    @FXML
    public TextField txtPatientDoB;
    @FXML
    public TextField txtPatientAddress;
    @FXML
    public TextField txtPatientNum;
    @FXML
    public TextField txtPatientAccess;
    @FXML
    public Button listVcBoothsP;
    @FXML
    public TextField searchPatientArea;
    @FXML
    public ListView listViewSearchPatient;


    //CALLED METHODS FROM PATIENT -----------------------------------------------------------------------




   /* public void showBoothListView() {
        VaccinationCentreNode currentNode = Controller.head;
        listVcBoothsP.getItems().clear();
        if (currentNode != null){
            while(currentNode != null) {
                ControllerBooth.conB.listVcBooth.getItems().add(currentNode.getContents());
                currentNode = currentNode.next;
            }
        }
    }
    */

    //This method calls the method in VaccinationCentre and lets it view vaccination centres.
   // public void showPatient(ActionEvent actionEvent) {
   ///     Patient chosenPatient = (Patient) listViewP.getSelectionModel().getSelectedItem();
   //     if (chosenPatient ;
    //    else
    //        chosenPatient.showPatients();
 //   }

 //   public void addPatientToList(ActionEvent actionEvent) {
 //      String chosenP = "";
  //          if (chosenP != null)

  //          {
               // addPatient();
  //          }
  //      }




    // METHODS FROM PATIENT ----------------------------------------------------------------------------------------------------------------------------

    /**
     * This method finds the patient with the PPS number that the user puts in.
     */
    public void findPatient() {
        String soughtId = searchPatientArea.getText();
        PatientNode temp = headPatient;
        while (temp != null ){
            if(temp.getContents().getPatientId().equals(soughtId))
                listViewSearchPatient.getItems().clear();
                listViewSearchPatient.getItems().add( temp.getContents());
            temp = temp.next;


            }
        }

    /**
     * This method collects the data required to create a patient.
     */
    public void addPatient() {
        Patient patient = new Patient(
                ControllerPatient.conP.txtPatientId.getText(), ControllerPatient.conP.txtPatientName.getText(),
                ControllerPatient.conP.txtPatientDoB.getText(), ControllerPatient.conP.txtPatientAddress.getText(),
                ControllerPatient.conP.txtPatientNum.getText(), ControllerPatient.conP.txtPatientAccess.getText());
        addPatientToList(patient);
    }

    /**
     * This method adds a new patient node to the top of the linked list
     * @param patient
     */
    public void addPatientToList(Patient patient){
        PatientNode patientNode = new PatientNode();
        patientNode.setContents(patient);
        patientNode.setNext(headPatient);
        headPatient = patientNode;
    }


    /**
     * This method displays all the Patient nodes in a list view
     */
    public void showPatients() {
        PatientNode currentNodeP = headPatient;
        blankFieldListViewP.getItems().clear();  // clears the list view to make sure the data displayed does not stack.
        if(currentNodeP == null){
            blankFieldListViewP.getItems().add("no vaccination centres found");
        }
        else{
            String pts = ""; //empty string for patients
            while(currentNodeP != null) {
                blankFieldListViewP.getItems().add(currentNodeP.contents); //adds the contents of each node one by one.
                pts += currentNodeP.contents + "\n "; //fills the string pts with the current node's contents
                currentNodeP = currentNodeP.next; //goes on to the next node until theres none left
            }
        }
    }

    /**
     * This method displays all the Patient nodes in a list view
     */
    public static void showPatientsGivenList(ListView theList) {
        PatientNode currentNodeP = headPatient;
        theList.getItems().clear();  // clears the list view to make sure the data displayed does not stack.
        if(currentNodeP == null){
            theList.getItems().add("no patients  found");
        }
        else{
           // String pts = ""; //empty string for patients
            while(currentNodeP != null) {
                theList.getItems().add(currentNodeP.getContents().getPatientId()); //adds the contents of each node one by one.
               // pts += currentNodeP.contents + "\n "; //fills the string pts with the current node's contents
                currentNodeP = currentNodeP.next; //goes on to the next node until theres none left
            }
        }
    }

    /**
     * Method which calls the delete method after selecting an item from the list view.
     */
    @FXML
    public void deletePtBtn(){
        int ptToBeDeleted = blankFieldListViewP.getSelectionModel().getSelectedIndex(); // selects a patient to be deleted
        deletePatient(ptToBeDeleted); //calls the delete method from above to delete the selected patient
        showPatients();
    }

    //This method was discovered on https://blog.devgenius.io/how-to-make-a-custom-linkedlist-3deee9d5d9e4
    /**
     * This method deleted a patient from the linked list by skipping over the node that is to be deleted
     * @param index
     */
    public static void deletePatient(int index) {
        if(index == 0) {
            headPatient = headPatient.next;
        }else{
            PatientNode PNode = headPatient;
            for(int i = 0; i < index - 1; i++) {
                PNode = PNode.next;
            }
            PNode.next = PNode.next.next;
        }
    }




    //----------------------------------------------------------------------------------
    public void initialize(){

        conP=this;
    }
}


