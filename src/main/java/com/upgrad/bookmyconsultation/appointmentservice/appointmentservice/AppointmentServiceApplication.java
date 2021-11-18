package com.upgrad.bookmyconsultation.appointmentservice.appointmentservice;

import com.upgrad.bookmyconsultation.appointmentservice.appointmentservice.mapper.appointmentMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppointmentServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(AppointmentServiceApplication.class, args);
	}

		@Bean
		public appointmentMapper modelMapper(){
			return new appointmentMapper();

	}

}
