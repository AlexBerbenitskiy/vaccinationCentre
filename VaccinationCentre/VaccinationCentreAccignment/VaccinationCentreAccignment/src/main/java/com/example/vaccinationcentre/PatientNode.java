package com.example.vaccinationcentre;

public class PatientNode {

    Patient contents; //Data in the current node
    PatientNode next; //Reference for the next node

    public Patient getContents() {
        return contents;
    }

    public void setContents(Patient contents) {
        this.contents = contents;
    }

    public PatientNode getNext() {
        return next;
    }

    public void setNext(PatientNode next) {
        this.next = next;
    }
}
