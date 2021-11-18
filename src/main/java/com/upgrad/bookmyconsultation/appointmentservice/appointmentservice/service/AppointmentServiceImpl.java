package com.upgrad.bookmyconsultation.appointmentservice.appointmentservice.service;

import com.upgrad.bookmyconsultation.appointmentservice.appointmentservice.dao.AppointmentDao;
import com.upgrad.bookmyconsultation.appointmentservice.appointmentservice.dto.AppointementResponseDTO;
import com.upgrad.bookmyconsultation.appointmentservice.appointmentservice.dto.AppointmentrequestDTO;
import com.upgrad.bookmyconsultation.appointmentservice.appointmentservice.entity.AppointmentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    AppointmentDao appointmentDao;
    @Override
    public AppointementResponseDTO addAppointments(AppointmentEntity appointment) {
        AppointementResponseDTO test = new AppointementResponseDTO();
        appointment.setStatus("PendingPayment");
        appointmentDao.save(appointment);
        //appointment.save();
        test.setUserId("123");
        test.setStatus("pending");
        test.setDoctorID("123");
        test.setAppointmentDate("2021-11-15");
        test.setAppointmentId("123");
        return test;
    }

    @Override
    public AppointmentEntity getAppointmentDetail(String appointmentId) {
        return appointmentDao.getByAppointmentId(appointmentId);
    }

    @Override
    public List<AppointmentEntity> getAppointmentDetailByUserId(String userId) {
        return appointmentDao.findByUserId(userId);
    }
}
