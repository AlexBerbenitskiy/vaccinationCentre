package com.example.vaccinationcentre;

//import com.thoughtworks.xstream.XStream;
//import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.*;

public class AppointmentNode {

    Appointment contents; //Data in the current node
    AppointmentNode next; //Reference for the next node

    public Appointment getContents() {
        return contents;
    }

    public void setContents(Appointment contents) {
        this.contents = contents;
    }

    public AppointmentNode getNext() {
        return next;
    }

    public void setNext(AppointmentNode next) {
        this.next = next;
    }


    /*
    public void loadAppointments() throws IOException, ClassNotFoundException {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("appointments.xml"));
        contents = (Appointment) is.readObject();
        is.close();
    }
    */


    public void saveAppointments() throws IOException {

        /*
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("appointments.xml"));
        out.writeObject(contents);
        out.close();
         */
    }
}