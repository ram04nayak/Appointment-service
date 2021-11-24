package com.upgrad.bookmyconsultation.appointmentservice.appointmentservice.controller;

import com.upgrad.bookmyconsultation.appointmentservice.appointmentservice.dto.*;
import com.upgrad.bookmyconsultation.appointmentservice.appointmentservice.entity.AppointmentEntity;
import com.upgrad.bookmyconsultation.appointmentservice.appointmentservice.entity.DoctorEntity;
import com.upgrad.bookmyconsultation.appointmentservice.appointmentservice.mapper.appointmentMapper;
import com.upgrad.bookmyconsultation.appointmentservice.appointmentservice.service.AppointmentService;
import com.upgrad.bookmyconsultation.appointmentservice.appointmentservice.service.AvailabilityService;
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
    AvailabilityService availabilityService;

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


    @PostMapping(value = "/prescriptions", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity sendPrescription( @RequestBody PrescriptionDTO prescription) throws Exception {
        //AppointementResponseDTO savedAppointmentDTO = appointmentService.savePrescription(modelMapper.AppointmentDTOToEntity(appointmentDTO));
       /* MedicineDTO m1 = new MedicineDTO();
        MedicineDTO m2 = new MedicineDTO();
        m1.setDosage("1");
        m1.setDuration("1");
        m1.setFrequency("1");
        m1.setName("1");
        m1.setRemarks("1");
        m1.setType("1");
        m2.setDosage("2");
        m2.setDuration("2");
        m2.setFrequency("2");
        m2.setName("2");
        m2.setRemarks("2");
        m2.setType("2");
        ArrayList<MedicineDTO> m = new ArrayList<MedicineDTO>();
        m.add(m1);
        m.add(m2);
        PrescriptionDTO test = new PrescriptionDTO();
        test.setAppointmentId("123");
        test.setDoctorId("123");
        test.setUserId("123");
        test.setDiagnosis("123");
        test.setMedicineList(m);


        System.out.println(test); */

        System.out.println(prescription);
        return new ResponseEntity("success", HttpStatus.CREATED);
    }


    @PostMapping(value = "/doctor/{doctorId}/availability", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity insertAvailability( @PathVariable("doctorId") String doctorId, @RequestBody AvailabilityDTO avail) throws Exception {
            System.out.println(avail);
            System.out.println(avail.getSlots().keySet());
            availabilityService.updateAvailability(doctorId,avail);
            return new ResponseEntity("Success",HttpStatus.CREATED);
    }

    @GetMapping(value = "/doctor/{doctorId}/availability")
    public ResponseEntity getAvailability(@PathVariable("doctorId") String doctorId) throws Exception {
        //System.out.println("We are in  fetch appointment details by user id end point--" + userId);
        AvailabilityDTO avail= availabilityService.getAvailability(doctorId);
        /*List<AppointmentEntity> entities = appointmentService.getAppointmentDetailByUserId(userId);
        System.out.println("Count of fetched records is " + entities);
        List<AppointementResponseDTO> dtos = new ArrayList<AppointementResponseDTO>();
        for (AppointmentEntity e : entities) {
            dtos.add(appointmentMapper.AppointmentEntityToDto(e));
        } */
        return new ResponseEntity(avail,HttpStatus.OK);
    }
}
