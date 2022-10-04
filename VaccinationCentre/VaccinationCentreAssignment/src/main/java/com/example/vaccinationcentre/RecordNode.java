package com.example.vaccinationcentre;

public class RecordNode {

    VaccinationRecord contents; //Data in the current node
    RecordNode next; //Reference for the next node

    public VaccinationRecord getContents() {
        return contents;
    }

    public void setContents(VaccinationRecord contents) {
        this.contents = contents;
    }

    public RecordNode getNext() {
        return next;
    }

    public void setNext(RecordNode next) {
        this.next = next;
    }
}
