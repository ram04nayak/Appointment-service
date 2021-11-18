package com.upgrad.bookmyconsultation.appointmentservice.appointmentservice.service;

import com.upgrad.bookmyconsultation.appointmentservice.appointmentservice.dto.AppointementResponseDTO;
import com.upgrad.bookmyconsultation.appointmentservice.appointmentservice.dto.AppointmentrequestDTO;
import com.upgrad.bookmyconsultation.appointmentservice.appointmentservice.entity.AppointmentEntity;

import java.util.List;

public interface AppointmentService {
    public AppointementResponseDTO addAppointments(AppointmentEntity appointmen) ;

    AppointmentEntity getAppointmentDetail(String appointmentId);

    List<AppointmentEntity> getAppointmentDetailByUserId(String userId);
}
