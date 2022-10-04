package com.example.vaccinationcentre;

public class VaccinationCentreNode {
    VaccinationCentre contents; //Data in the current node
    VaccinationCentreNode next; //Reference for the next node


    public VaccinationCentre getContents() {
        return contents;
    }

    public void setContents(VaccinationCentre contents) {
        this.contents = contents;
    }

    public VaccinationCentreNode getNext() {
        return next;
    }

    public void setNext(VaccinationCentreNode next) {
        this.next = next;
    }

}
