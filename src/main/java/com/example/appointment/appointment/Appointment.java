package com.example.appointment.appointment;


import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "appointment")
public class Appointment implements Serializable {
    @Id
    @SequenceGenerator(
            name = "appointment_sequence",
            sequenceName = "appointment_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "appointment_sequence"
    )
    private Long appointmentId;

    private String name;
    private String email;
    private Long phoneNumber;

    private String address;
    private String city;
    private String state;
    private Integer zipCode;
    private String purpose;

    private String date;
    private Integer startTime;


    public Appointment() {
    }

    public Appointment(Long appointmentId, String name, String email, Long phoneNumber, String address, String city, String state, Integer zipCode, String purpose, String date, Integer startTime) {
        this.appointmentId = appointmentId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.purpose = purpose;
        this.date = date;
        this.startTime = startTime;
    }

    public Appointment(String name, String email, Long phoneNumber, String address, String city, String state, Integer zipCode, String purpose, String date, Integer startTime) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.purpose = purpose;
        this.date = date;
        this.startTime = startTime;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }


    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId=" + appointmentId +
                ", firstName='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", address=" + address +
                ", city=" + city +
                ", state=" + state +
                ", zip cpde=" + zipCode +
                ", purpose='" + purpose + '\'' +
                ", date=" + date +
                ", startTime=" + startTime +
                '}';
    }
}
