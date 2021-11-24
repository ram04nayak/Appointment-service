package com.upgrad.bookmyconsultation.appointmentservice.appointmentservice.service;

import com.upgrad.bookmyconsultation.appointmentservice.appointmentservice.dto.AvailabilityDTO;

public interface AvailabilityService {
    void updateAvailability(String doctorId, AvailabilityDTO avail);

    AvailabilityDTO getAvailability(String doctorId);
}
