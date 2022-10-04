package com.example.vaccinationcentre;

public class Patient {

    private  String patientId;
    private String name;
    private String dateOfBirth;
    private String patientAddress;
    private String phoneNum;
    private String accessibility;


    public Patient(String patientId, String name, String dateOfBirth, String patientAddress, String phoneNum, String accessibility) {

        if(Utilities.validPPS(patientId))
        this.patientId = patientId;
        else {
            {
                patientId = "invalid patient ID";
            }
        }

        if(Utilities.max30Chars(name))
        {
            this.name = name;
        }
        else
        {
            this.name = name.substring(0,30); //if the name is over 30 characters it will cut the amount to 30
        }


        this.dateOfBirth = dateOfBirth;

        if(Utilities.max60Chars(patientAddress))
        {
            this.patientAddress = patientAddress;
        }
        else
        {
            this.patientAddress = name.substring(0,60); //if the name is over 30 characters it will cut the amount to 30
        }

        if(Utilities.onlyContainsNumbers(phoneNum)) {
            this.phoneNum = phoneNum;
        }
        else{
            this.phoneNum = "invalid floor level";
        }

        if(Utilities.max15Chars(accessibility))
        {
            this.accessibility = accessibility;        }
        else
        {
            this.accessibility = name.substring(0,15); //if the name is over 30 characters it will cut the amount to 30
        }


    }

//GETTERS
    public  String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getAccessibility() {
        return accessibility;
    }

//SETTERS
    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public void setName(String name){   if(Utilities.max30Chars(name))
    {
        this.name = name;
    }
    else
    {
        this.name = name.substring(0,30); //if the name is over 30 characters it will cut the amount to 30
    }}

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPatientAddress(String patientAddress) {
        if (Utilities.max60Chars(patientAddress)) {
            this.patientAddress = patientAddress;
        } else {
            this.patientAddress = name.substring(0, 60); //if the name is over 30 characters it will cut the amount to 30
        }
    }

    public void setPhoneNum(String phoneNum) {
        if (Utilities.onlyContainsNumbers(phoneNum)) {
            this.phoneNum = phoneNum;
        } else {
            this.phoneNum = "invalid floor level";
        }
    }

        public void setAccessibility(String accessibility) {
            if(Utilities.max15Chars(accessibility))
            {
                this.accessibility = accessibility;        }
            else
            {
                this.accessibility = name.substring(0,15); //if the name is over 30 characters it will cut the amount to 30
            }
            this.accessibility = accessibility;
    }


    //Record METHODS----------------------------------------------------------------------------------------------



  //-------------------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return "Patient {  " +
                "patientId='" + patientId + '\'' +
                ", name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", patientAddress='" + patientAddress + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", accessibility='" + accessibility + '\'' +
                '}';
    }


}
