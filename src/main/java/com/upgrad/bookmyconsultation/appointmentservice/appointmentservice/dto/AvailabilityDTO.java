package com.upgrad.bookmyconsultation.appointmentservice.appointmentservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.GeneratedValue;


@JsonPropertyOrder({"id"})
public class AvailabilityDTO {


@Id
@GeneratedValue(generator = "system-uuid")
@GenericGenerator(name = "system-uuid", strategy = "uuid")
private String id;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "dd-MM-yyyy")
    @JsonFormat(pattern = "dd-MM-yyyy")

    private String availability_date;

    private String doctorId;
    private boolean isBooked;
    private String timeSlot;

    public void setId(String id) {
        this.id = id;
    }

    public void setAvailability_date(String availability_date) {
        this.availability_date = availability_date;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }


    public String getId() {
        return id;
    }

    public String getAvailability_date() {
        return availability_date;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public String getTimeSlot() {
        return timeSlot;
    }



public AvailabilityDTO() {
}

    @Override
    public String toString() {
        return "AvailabilityDTO{" +
                "id='" + id + '\'' +
                ", availability_date='" + availability_date + '\'' +
                ", doctorId='" + doctorId + '\'' +
                ", isBooked=" + isBooked +
                ", timeSlot='" + timeSlot + '\'' +
                '}';
    }
}
