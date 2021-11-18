package com.upgrad.bookmyconsultation.appointmentservice.appointmentservice.entity;

//import lombok.Data;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Appointment")
public class AppointmentEntity {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name="appointment_id")
    private String appointmentId;
    @Column(name="appointment_date")
    private Date appointmentDate;
    @Column(name="created_date")
    private Date createdDate;
    @Column(name="doctor_id")
    private String doctorID;
    @Column(name="prior_medical_history")
    private String priorMedicalHistory;
    private String status;
    private String symptoms;
    @Column(name="time_slot")
    private String timeSlot;
    @Column(name="user_id")
    private String userId;
    @Column(name="user_email")
    private String userEmailId;
    @Column(name="user_name")
    private String userName;
    @Column(name="doctor_name")
    private String doctorName;
    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public String getPriorMedicalHistory() {
        return priorMedicalHistory;
    }

    public void setPriorMedicalHistory(String priorMedicalHistory) {
        this.priorMedicalHistory = priorMedicalHistory;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserEmailId() {
        return userEmailId;
    }

    public void setUserEmailId(String userEmailId) {
        this.userEmailId = userEmailId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }


}
