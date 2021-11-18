package com.upgrad.bookmyconsultation.appointmentservice.appointmentservice.dao;

import com.upgrad.bookmyconsultation.appointmentservice.appointmentservice.entity.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentDao extends JpaRepository<AppointmentEntity, String> {

    AppointmentEntity getByAppointmentId(String appointmentId);
    List<AppointmentEntity> findByUserId(String userId);
}
