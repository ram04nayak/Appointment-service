package com.upgrad.bookmyconsultation.appointmentservice.appointmentservice.dto;

public class MedicineDTO{
     private String name;
    private String type;
    private String dosage;
    private String duration;
    private String frequency;
    private String remarks;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    @Override
    public String toString() {
        return "MedicineDTO{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", dosage='" + dosage + '\'' +
                ", duration='" + duration + '\'' +
                ", frequency='" + frequency + '\'' +
                ", remark='" + remarks + '\'' +
                '}';
    }


}
