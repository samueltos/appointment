package com.example.appointment.appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "api/appointment")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Appointment>> appointments(){
        List<Appointment> appointments = appointmentService.allAppointment();
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Appointment> appointment(@RequestBody Appointment appointment){
        Appointment newAppoint = appointmentService.appointment(appointment);
        return new ResponseEntity<>(newAppoint, HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<Appointment> appointments(@RequestBody Appointment appointment){
        Appointment newAppoint = appointmentService.updateAppointment(appointment);
        return new ResponseEntity<>(newAppoint, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> appointments(@PathVariable Long id){
        appointmentService.removeAppointment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/booked")
    public ResponseEntity<List<AppointmentDTO>> bookAppointments(){
        List<AppointmentDTO> appointments = appointmentService.bookedAppointments();
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> appointment(@PathVariable Long id){
        Appointment appointment = appointmentService.bookedAppointment(id);
        return new ResponseEntity<>(appointment, HttpStatus.OK);
    }

    @GetMapping("/time/{name}")
    public ResponseEntity<List<TimeDTO>> appointment(@PathVariable String name){
        List<TimeDTO> bookedTime = appointmentService.bookedTimeAppointment(name);
        return new ResponseEntity<>(bookedTime, HttpStatus.OK);
    }

}
