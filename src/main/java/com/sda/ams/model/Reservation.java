package com.sda.ams.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;
//import javax.persistence.Table;


@Entity
//@Table(name="reservation")
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer reservationId;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
			name = "reservation_room",
			joinColumns = { @JoinColumn(name = "reservationId") },
			inverseJoinColumns = { @JoinColumn(name = "roomId") }
	)
	private List<Room> roomList;
	
	@ManyToOne
	@JoinColumn(name="clientId")
	private Client clientId;

	private LocalDate startDate;
	private LocalDate endDate;

	public Integer getReservationId() {
		return reservationId;
	}

	public void setReservationId(Integer reservationId) {
		this.reservationId = reservationId;
	}


	public Client getClientId() {
		return clientId;
	}

	public void setClientId(Client clientId) {
		this.clientId = clientId;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}



	public List<Room> getRoomList() {
		return roomList;
	}

	public void setRoomList(List<Room> roomList) {
		this.roomList = roomList;
	}

	public Reservation(Integer reservationId, Client clientId, LocalDate startDate, LocalDate endDate) {
		super();
		this.reservationId = reservationId;
		this.clientId = clientId;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Reservation [reservationId=" + reservationId + ", roomList=" + roomList + ", clientId=" + clientId
				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}

}
