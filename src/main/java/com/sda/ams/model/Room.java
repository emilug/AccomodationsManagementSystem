package com.sda.ams.model;

import java.util.List;

import javax.persistence.*;
//import javax.persistence.Table;

@Entity
//@Table(name="room")
public class Room {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer roomId;

	@ManyToOne
	@JoinColumn(name="roomTypeId", nullable=false)
	private RoomType roomTypeId;

	@ManyToMany(mappedBy = "roomList")
	private List<Reservation> reservationList;

	private String roomName;

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

//	public Room(Integer roomId, RoomType roomTypeId, List<Reservation> reservationList) {
//		super();
//		this.roomId = roomId;
//		this.roomTypeId = roomTypeId;
//		this.reservationList = reservationList;
//	}

	public Room(RoomType roomTypeId, List<Reservation> reservationList, String roomName) {
		this.roomTypeId = roomTypeId;
		this.reservationList = reservationList;
		this.roomName = roomName;
	}

	public Room() {

    }

    public List<Reservation> getReservationList() {
		return reservationList;
	}

	public void setReservationList(List<Reservation> reservationList) {
		this.reservationList = reservationList;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public RoomType getRoomTypeId() {
		return roomTypeId;
	}

	public void setRoomTypeId(RoomType roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

//	@Override
//	public String toString() {
//		return "Room [roomId=" + roomId + ", roomTypeId=" + roomTypeId + ", reservationList=" + reservationList + "]";
//	}

	@Override
	public String toString() {
		return "Room{" +
				"roomId=" + roomId +
				", roomTypeId=" + roomTypeId +
				", reservationList=" + reservationList +
				", roomName='" + roomName + '\'' +
				'}';
	}
}
