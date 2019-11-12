package com.sda.ams.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class RoomType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roomTypeId;
    private String name;
    private Double price;
    private Integer noOfGuests;
    @OneToMany(mappedBy = "roomTypeId")
    private List<Room> roomList;

    public RoomType(Integer roomTypeId, String name, Double price, Integer noOfGuests) {
        super();
        this.roomTypeId = roomTypeId;
        this.name = name;
        this.price = price;
        this.noOfGuests = noOfGuests;
    }

    public RoomType() {

    }

    public Integer getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(Integer roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getNoOfGuests() {
        return noOfGuests;
    }

    public void setNoOfGuests(Integer noOfGuests) {
        this.noOfGuests = noOfGuests;
    }

    @Override
    public String toString() {
        return "RoomType [roomTypeId=" + roomTypeId + ", name=" + name + ", price=" + price + ", noOfGuests=" + noOfGuests + "]";
    }

}
