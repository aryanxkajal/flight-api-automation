package com.flightbooking.utils;

import com.flightbooking.models.Passenger;
import java.util.HashMap;
import java.util.Map;

public class TestDataUtils {
    
    public static Map<String, String> getNewPassengerData() {
        Map<String, String> passengerData = new HashMap<>();
        String timestamp = String.valueOf(System.currentTimeMillis()).substring(7); // Last 6 digits
        
        passengerData.put("passengerId", "999" + timestamp.substring(0, 3));
        passengerData.put("passengerName", "TestUser" + timestamp.substring(0, 3));
        passengerData.put("passengerMobile", "98987" + timestamp.substring(0, 5));
        passengerData.put("passengerGender", "Male");
        passengerData.put("passengerAadhaarNumber", "1234567890" + timestamp.substring(0, 2));
        passengerData.put("passengerAddress", "Test Address " + timestamp.substring(0, 3));
        
        return passengerData;
    }
    
    public static Passenger createPassengerObject() {
        Map<String, String> data = getNewPassengerData();
        return new Passenger(
            data.get("passengerId"),
            data.get("passengerName"), 
            data.get("passengerMobile"),
            data.get("passengerGender"),
            data.get("passengerAadhaarNumber"),
            data.get("passengerAddress")
        );
    }
    
    public static Map<String, String> getInvalidPassengerData() {
        Map<String, String> invalidData = new HashMap<>();
        invalidData.put("passengerId", ""); // Empty ID
        invalidData.put("passengerName", "");
        invalidData.put("passengerMobile", "invalid");
        invalidData.put("passengerGender", "");
        invalidData.put("passengerAadhaarNumber", "123"); // Invalid format
        invalidData.put("passengerAddress", "");
        
        return invalidData;
    }
}