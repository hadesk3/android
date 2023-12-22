package com.example.ck_room.Entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import java.util.Date;
import java.util.List;

@Entity(tableName = "Ticket")
public class Ticket {
    @PrimaryKey
    @NonNull
    private String Ticket_No;
    private String Passenger_Name;
    private String source;
    private String destination;
    private String classType;
    private int train_id;
    private String date;
    @Ignore
    private List<String> seat;

    // Constructor
    public Ticket()
    {

    }
    public Ticket(String ticket_No, String passenger_Name, String source, String destination, String classType, int train_id) {
        Ticket_No = ticket_No;
        Passenger_Name = passenger_Name;
        this.source = source;
        this.destination = destination;
        this.classType = classType;
        this.train_id = train_id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public int getTrain_id() {
        return train_id;
    }

    public void setTrain_id(int train_id) {
        this.train_id = train_id;
    }

    // Getters and setters
    public String getTicket_No() {
        return Ticket_No;
    }

    public void setTicket_No(String Ticket_No) {
        this.Ticket_No = Ticket_No;
    }

    public String getPassenger_Name() {
        return Passenger_Name;
    }

    public void setPassenger_Name(String Passenger_Name) {
        this.Passenger_Name = Passenger_Name;
    }

    public int getTrain_No() {
        return train_id;
    }

    public void setTrain_No(int Train_No) {
        this.train_id = Train_No;
    }

    public String getDate() {
        return date;
    }

    public List<String> getSeat() {
        return seat;
    }

    public void setSeat(List<String> seat) {
        this.seat = seat;
    }

    public void setDate(String date) {
        this.date = date;
    }
}