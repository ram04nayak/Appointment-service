package com.upgrad.bookmyconsultation.appointmentservice.appointmentservice.service;

import com.upgrad.bookmyconsultation.appointmentservice.appointmentservice.dao.AvailabilityDao;
import com.upgrad.bookmyconsultation.appointmentservice.appointmentservice.dto.AvailabilityDTO;
import com.upgrad.bookmyconsultation.appointmentservice.appointmentservice.entity.AvailabilityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class AvailabilityServiceImpl implements AvailabilityService {
    @Autowired
    AvailabilityDao availabilityDao;
    @Override
    public void updateAvailability(String doctorId, AvailabilityDTO avail) {
        // check and delete existing entries, if any
        for(AvailabilityEntity a: availabilityDao.findByDoctorId(doctorId)){
            availabilityDao.delete(a);
        }
        //make entries for doctor's availability
        Map<String, List<String>> maps=avail.getSlots();
        AvailabilityEntity entity;
        for(Map.Entry<String,List<String>> entry:maps.entrySet()){

            List<String> timeSlot=entry.getValue();
            String date=entry.getKey();
            for(String s:timeSlot){
                entity=new AvailabilityEntity();
                entity.setTimeSlot(s);
                entity.setDoctorId(doctorId);
                entity.setAvailabilityDate(entry.getKey());
                entity.setBooked(false);
                availabilityDao.save(entity);
            }
        }
        }

    @Override
    public AvailabilityDTO getAvailability(String doctorId) {
        List<AvailabilityEntity> slots=availabilityDao.findByDoctorId(doctorId);
        AvailabilityDTO dto= new AvailabilityDTO();
        Map<String, List<String>> map= new HashMap<String, List<String>>() ;
        dto.setDoctorId(doctorId);
        for(AvailabilityEntity a : slots){
            String key;
            List<String> li;
            key=a.getAvailabilityDate();
            if(map.get(key) != null){
            li=map.get(key);
            li.add(a.getTimeSlot());}
            else{
                li=new ArrayList();
                li.add(a.getTimeSlot());
            }
            map.put(key,li);
        }
        dto.setSlots(map);
        return dto;
    }
}