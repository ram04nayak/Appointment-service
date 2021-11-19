package com.upgrad.bookmyconsultation.appointmentservice.appointmentservice.dto;


import java.util.ArrayList;
import java.util.List;

public class PrescriptionDTO {
    private String appointmentId;
    private String doctorId;
    private String doctorName;
    private String userId;
    private String diagnosis;
    private ArrayList<MedicineDTO> medicineList;
    public String getAppointmentId() {
        return appointmentId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getUserId() {
        return userId;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public List<MedicineDTO> getMedicineList() {
        return medicineList;
    }
    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public void setMedicineList(ArrayList<MedicineDTO> medicineList) {
        this.medicineList = medicineList;
    }


    @Override
    public String toString() {
        return "PrescriptionDTO{" +
                "appointmentId='" + appointmentId + '\'' +
                ", doctorId='" + doctorId + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", userId='" + userId + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                ", medicineList=" + medicineList +
                '}';
    }
}
