package com.upgrad.bookmyconsultation.appointmentservice.appointmentservice.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;



@Entity
@Table(name="Availability")
public class AvailabilityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;



    @Column(name="availability_date")
    private String availabilityDate;
    @Column(name="doctor_id")
    private String doctorId;
    @Column(name="is_booked")
    private boolean isBooked;
    @Column(name="time_slot")
    private String timeSlot;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAvailabilityDate() {
        return availabilityDate;
    }

    public void setAvailabilityDate(String availabilityDate) {
        this.availabilityDate = availabilityDate;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    @Override
    public String toString() {
        return "AvailabilityEntity{" +
                "id=" + id +
                ", availabilityDate='" + availabilityDate + '\'' +
                ", doctorId='" + doctorId + '\'' +
                ", isBooked=" + isBooked +
                ", timeSlot='" + timeSlot + '\'' +
                '}';
    }
}
