package com.flightbooking.models;

public class Passenger {
    private String passengerId;
    private String passengerName;
    private String passengerMobile;
    private String passengerGender;
    private String passengerAadhaarNumber;
    private String passengerAddress;
    
    // Constructor
    public Passenger() {}
    
    public Passenger(String passengerId, String passengerName, String passengerMobile, 
                    String passengerGender, String passengerAadhaarNumber, String passengerAddress) {
        this.passengerId = passengerId;
        this.passengerName = passengerName;
        this.passengerMobile = passengerMobile;
        this.passengerGender = passengerGender;
        this.passengerAadhaarNumber = passengerAadhaarNumber;
        this.passengerAddress = passengerAddress;
    }
    
    // Getters and Setters
    public String getPassengerId() { return passengerId; }
    public void setPassengerId(String passengerId) { this.passengerId = passengerId; }
    
    public String getPassengerName() { return passengerName; }
    public void setPassengerName(String passengerName) { this.passengerName = passengerName; }
    
    public String getPassengerMobile() { return passengerMobile; }
    public void setPassengerMobile(String passengerMobile) { this.passengerMobile = passengerMobile; }
    
    public String getPassengerGender() { return passengerGender; }
    public void setPassengerGender(String passengerGender) { this.passengerGender = passengerGender; }
    
    public String getPassengerAadhaarNumber() { return passengerAadhaarNumber; }
    public void setPassengerAadhaarNumber(String passengerAadhaarNumber) { this.passengerAadhaarNumber = passengerAadhaarNumber; }
    
    public String getPassengerAddress() { return passengerAddress; }
    public void setPassengerAddress(String passengerAddress) { this.passengerAddress = passengerAddress; }
}