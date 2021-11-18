package com.upgrad.bookmyconsultation.appointmentservice.appointmentservice.controller;

import com.upgrad.bookmyconsultation.appointmentservice.appointmentservice.dto.AppointementResponseDTO;
import com.upgrad.bookmyconsultation.appointmentservice.appointmentservice.dto.AppointmentrequestDTO;
import com.upgrad.bookmyconsultation.appointmentservice.appointmentservice.entity.AppointmentEntity;
import com.upgrad.bookmyconsultation.appointmentservice.appointmentservice.entity.DoctorEntity;
import com.upgrad.bookmyconsultation.appointmentservice.appointmentservice.mapper.appointmentMapper;
import com.upgrad.bookmyconsultation.appointmentservice.appointmentservice.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.MessagingException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@RestController
public class AppointmentController {



    @Autowired
    AppointmentService appointmentService;

       @Autowired
       appointmentMapper modelMapper;



        @PostMapping(value = "/appointments", produces = MediaType.APPLICATION_JSON_VALUE,
                consumes = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity addAppointments( @RequestBody AppointmentrequestDTO appointmentDTO) throws Exception {
            AppointementResponseDTO savedAppointmentDTO = appointmentService.addAppointments(modelMapper.AppointmentDTOToEntity(appointmentDTO));
            return new ResponseEntity(savedAppointmentDTO, HttpStatus.CREATED);
        }

//
//        @PutMapping(value = "/doctors/{doctorId}/approve")
//        public ResponseEntity approveDoctorRegistration(@PathVariable("doctorId") String doctorId
//                , @RequestBody UpdateDoctorDTO updateDoctorDTO) throws Exception {
//            DoctorDTO detailDoctorServiceDTO = doctorService.updateDoctor(doctorId, updateDoctorDTO, "Active");
//            return new ResponseEntity(detailDoctorServiceDTO, HttpStatus.OK);
//        }
//
//        @PutMapping(value = "/doctors/{doctorId}/reject")
//        public ResponseEntity rejectDoctorRegistration(@PathVariable("doctorId") String doctorId
//                , @RequestBody UpdateDoctorDTO updateDoctorDTO) throws Exception {
//            DoctorDTO detailDoctorServiceDTO = doctorService.updateDoctor(doctorId, updateDoctorDTO, "Rejected");
//            return new ResponseEntity(detailDoctorServiceDTO, HttpStatus.OK);
//        }
//
        @GetMapping(value = "/appointments/{appointmentId}")
        public ResponseEntity<AppointmentEntity> getAppointmentDetail(@PathVariable("appointmentId") String appointmentId) throws Exception {
            System.out.println("We are in  fetch appointment details end point");
            AppointmentEntity entity = appointmentService.getAppointmentDetail( appointmentId);
            return new ResponseEntity(appointmentMapper.AppointmentEntityToDto( entity), HttpStatus.OK);

        }
    @GetMapping(value = "/users/{userId}/appointments")
    public ResponseEntity<List<AppointmentEntity>> getAppointmentDetails(@PathVariable("userId") String userId) throws Exception {
        System.out.println("We are in  fetch appointment details by user id end point--" + userId);
        List<AppointmentEntity> entities = appointmentService.getAppointmentDetailByUserId(userId);
        System.out.println("Count of fetched records is " + entities);
        List<AppointementResponseDTO> dtos = new ArrayList<AppointementResponseDTO>();
        for (AppointmentEntity e : entities) {
            dtos.add(appointmentMapper.AppointmentEntityToDto(e));
        }
        return new ResponseEntity(dtos,HttpStatus.OK);
    }

}
