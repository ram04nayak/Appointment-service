package com.upgrad.bookmyconsultation.appointmentservice.appointmentservice.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.upgrad.bookmyconsultation.appointmentservice.appointmentservice.dto.MedicineDTO;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;


@Document(collection = "Prescription")
public class PrescriptionEntity {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String appointmentId;
    private String doctorId;
    private String doctorName;

    public PrescriptionEntity(String appointmentId, String doctorId, String doctorName, String userId, String diagnosis, ArrayList<MedicineDTO> medicineList) {
        this.appointmentId = appointmentId;
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.userId = userId;
        this.diagnosis = diagnosis;
        this.medicineList = medicineList;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
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

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public ArrayList<MedicineDTO> getMedicineList() {
        return medicineList;
    }

    public void setMedicineList(ArrayList<MedicineDTO> medicineList) {
        this.medicineList = medicineList;
    }

    private String userId;
    private String diagnosis;
    private ArrayList<MedicineDTO> medicineList;

    public PrescriptionEntity() {
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
