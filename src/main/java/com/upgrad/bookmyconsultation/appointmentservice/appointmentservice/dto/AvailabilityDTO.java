package com.upgrad.bookmyconsultation.appointmentservice.appointmentservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.GeneratedValue;
import java.util.List;
import java.util.Map;


public class AvailabilityDTO {

    private String doctorId;

    private Map<String, List<String>> slots;
    public Map<String, List<String>> getSlots() {
        return slots;
    }

    public void setSlots(Map<String, List<String>> slots) {
        this.slots = slots;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    @Override
    public String toString() {
        return "AvailabilityDTO{" +
                "doctorId='" + doctorId + '\'' +
                ", slots=" + slots +
                '}';
    }
}
