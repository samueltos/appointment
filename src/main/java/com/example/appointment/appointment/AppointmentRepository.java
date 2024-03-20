package com.example.appointment.appointment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    @Query("from Appointment c where c.date = :date")
    Optional<List<Appointment>> findAllByDate(@Param("date") String date);
}
