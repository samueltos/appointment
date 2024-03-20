package com.example.appointment.appointment;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {
    public final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> allAppointment(){
        return appointmentRepository.findAll();
    }

    public Appointment appointment(Appointment appointment){
        return appointmentRepository.save(appointment);
    }

    public Appointment updateAppointment(Appointment appointment){
        return appointmentRepository.save(appointment);
    }

    public void removeAppointment(Long id){
        appointmentRepository.deleteById(id);
    }

    public List<AppointmentDTO> bookedAppointments(){
        List<Appointment> appointment = allAppointment();
        ModelMapper modelMapper = new ModelMapper();
        return Arrays.asList(modelMapper.map(appointment, AppointmentDTO[].class));
    }

    public Appointment bookedAppointment(Long id){
        return appointmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Appointment cannot be found"));
    }

    public List<TimeDTO> bookedTimeAppointment(String date){
        Optional<List<Appointment>> bookedTime = appointmentRepository.findAllByDate(date);
        ModelMapper modelMapper = new ModelMapper();

        if (bookedTime.isEmpty()){
            return new ArrayList<>();
        }else {
            return Arrays.asList(modelMapper.map(bookedTime, TimeDTO[].class));
        }
    }

}
