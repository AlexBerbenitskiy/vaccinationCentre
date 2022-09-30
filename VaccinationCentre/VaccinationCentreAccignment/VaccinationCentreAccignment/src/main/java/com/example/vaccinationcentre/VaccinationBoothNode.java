package com.example.vaccinationcentre;

public class VaccinationBoothNode {

    VaccinationBooth contents; //Data in the current node
    VaccinationBoothNode next; //Reference for the next node


    public VaccinationBooth getContents() {
        return contents;
    }

    public void setContents(VaccinationBooth contents) {
        this.contents = contents;
    }

    public VaccinationBoothNode getNext() {
        return next;
    }

    public void setNext(VaccinationBoothNode next) {
        this.next = next;
    }

}
