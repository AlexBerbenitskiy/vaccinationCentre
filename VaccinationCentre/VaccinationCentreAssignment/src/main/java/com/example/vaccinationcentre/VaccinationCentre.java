package com.example.vaccinationcentre;
import javafx.fxml.FXML;

import java.util.Scanner;


public class VaccinationCentre {


    private String vaccinationName;
    private String address;
    private String eircode;
    private String parkingSpaces;
    public static VaccinationBoothNode headBooth = null;
    Scanner input = new Scanner(System.in);

    public VaccinationCentre(String vaccinationName, String address, String eircode, String parkingSpaces) {
        this.vaccinationName = vaccinationName;
        this.address = address;


       if(Utilities.validEircode(eircode)) {
           this.eircode = eircode;
       }
          else
          {
               this.eircode = "invalid format Eircode";
           }
          

          if(Utilities.onlyContainsNumbers(parkingSpaces)) {
              this.parkingSpaces = parkingSpaces;
          }
              else{
                  this.parkingSpaces = "invalid number of parking spaces";
              }

    }

    //getters
    public String getVaccinationName() {
        return vaccinationName;
    }

    public String getEircode() {
        return eircode;
    }

    public String getParkingSpaces() {
        return parkingSpaces;
    }

    public String getAddress() {
        return address;
    }

    //setters
    public void setAddress(String address) {
        this.address = address;
    }

    public void setVaccinationName(String vaccinationName) {
        this.vaccinationName = vaccinationName;
    }

    public void setEircode(String eircode) {
        if (Utilities.validEircode(eircode)) {
            this.eircode = eircode;
        } else {
            this.eircode = "invalid format Eircode";

        }
    }

    public void setParkingSpaces(String parkingSpaces) {
        this.parkingSpaces = parkingSpaces;
    }





    //----------------------BOOTH METHODS----------------------------------------------------------


    /**
     * This method collects the data required to create a Booth.
     */
    public void addVaccinationBooth() {
        VaccinationBooth vb = new VaccinationBooth(ControllerBooth.conB.txtBoothId.getText(), ControllerBooth.conB.txtFloor.getText(), ControllerBooth.conB.txtAccess.getText());
        addBoothToList(vb);
    }

    /**
     * This method adds a new node to the top of the linked list
     * @param booth
     */
    public void addBoothToList(VaccinationBooth booth){
        VaccinationBoothNode boothNode = new VaccinationBoothNode();
        boothNode.setContents(booth);
        boothNode.setNext(headBooth);
        headBooth = boothNode;
    }


    /**
     * This method displays all the vaccination booth nodes in a list view
     */
    @FXML
    public static void showBooth() {
        VaccinationBoothNode currentNodeB = headBooth;
       ControllerBooth.conB.blankField2.getItems().clear();
        if(currentNodeB == null){
            ControllerBooth.conB.blankField2.getItems().add("no vaccination centres found");
        }
        else{
            String vcs = "";
            while
            (currentNodeB != null) {
                ControllerBooth.conB.blankField2.getItems().add(currentNodeB.contents);
                vcs += currentNodeB.contents + "\n ";
                currentNodeB = currentNodeB.next;
            }

        }
    }


    /**
     * This method clears data from all nodes.
     */
 public static void clear(){
        Controller.con.head=null;
        headBooth = null;
        VaccinationBooth.headAppointment = null;
        ControllerPatient.headPatient = null;
        Appointment.headRecord = null;
    }


    /**
     * This method deletes a vaccination booth from the linked list by skipping over the node that is to be deleted
     * @param index
     */
    public static void deleteBooth(int index) {
        if(index == 0) {
            headBooth = headBooth.next;
        }else{
            VaccinationBoothNode bNode = headBooth;
            for(int i = 0; i < index - 1; i++) {
                bNode = bNode.next;
            }
            bNode.next = bNode.next.next;
        }
    }


    //---------------------------------------------------------------------------------------


    public void initialize(){
    }

    @Override
    public String toString() {
        return
                "Vaccination Centre Name=' " + vaccinationName + '\'' +
                ",  address=' " + address + '\'' +
                ",  eircode=' " + eircode + '\'' +
                ",  parkingSpaces=' " + parkingSpaces + '\'' +
                '}';
    }
}
