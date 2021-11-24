package com.upgrad.bookmyconsultation.appointmentservice.appointmentservice.dao;

import com.upgrad.bookmyconsultation.appointmentservice.appointmentservice.entity.AppointmentEntity;
import com.upgrad.bookmyconsultation.appointmentservice.appointmentservice.entity.AvailabilityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvailabilityDao extends JpaRepository<AvailabilityEntity, Long> {
  List<AvailabilityEntity> findByDoctorId(String doctorId);

}
