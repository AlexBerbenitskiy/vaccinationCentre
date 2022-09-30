package com.example.vaccinationcentre;

public class VaccinationRecord{
    private String recordCreationDate;
    private String recordId;

    public VaccinationRecord(String recordCreationDate, String recordId) {
        this.recordCreationDate = recordCreationDate;
        this.recordId = recordId;
    }

    public String getRecordCreationDate() {
        return recordCreationDate;
    }

    public void setRecordCreationDate(String recordCreationDate) {
        this.recordCreationDate = recordCreationDate;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    @Override
    public String toString() {
        return "VaccinationRecord{" +
                "recordCreationDate='" + recordCreationDate + '\'' +
                ", recordId='" + recordId + '\'' +
                '}';
    }
}
