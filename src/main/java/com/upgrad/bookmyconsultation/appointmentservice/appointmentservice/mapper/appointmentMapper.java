package com.upgrad.bookmyconsultation.appointmentservice.appointmentservice.mapper;
import com.upgrad.bookmyconsultation.appointmentservice.appointmentservice.dto.AppointementResponseDTO;
import com.upgrad.bookmyconsultation.appointmentservice.appointmentservice.dto.AppointmentrequestDTO;
import com.upgrad.bookmyconsultation.appointmentservice.appointmentservice.entity.AppointmentEntity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class appointmentMapper {
    public static AppointmentEntity AppointmentDTOToEntity(AppointmentrequestDTO appointmentDTO) throws Exception{
        AppointmentEntity appointmentEntity = new AppointmentEntity();
        appointmentEntity.setAppointmentDate(new SimpleDateFormat("yyyy-MM-dd").parse(appointmentDTO.getAppointmentDate()));
        appointmentEntity.setDoctorID(appointmentDTO.getDoctorID());
        appointmentEntity.setUserId(appointmentDTO.getUserId());
        appointmentEntity.setTimeSlot(appointmentDTO.getTimeSlot());

        return appointmentEntity;
    }

    public static AppointementResponseDTO AppointmentEntityToDto(AppointmentEntity entity) throws Exception{
        AppointementResponseDTO dto= new AppointementResponseDTO();
        dto.setAppointmentDate(entity.getAppointmentDate().toString());
        dto.setDoctorID(entity.getDoctorID());
        dto.setUserId(entity.getUserId());
        dto.setTimeSlot(entity.getTimeSlot());
        dto.setStatus(entity.getStatus());
        dto.setAppointmentId(entity.getAppointmentId());

        return dto;
    }
}
