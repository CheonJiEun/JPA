package miniproject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Seat {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="SEAT_ID")
	private Long id;
	
	private String name;
	
	@OneToOne(mappedBy="seat")
	private Reservation reservation;
	
	@ManyToOne
	@JoinColumn(name = "SCREEN_HALL_ID")
	private ScreenHall screenhall;
	
	public Seat() {

	}

	public Seat(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public ScreenHall getScreenhall() {
		return screenhall;
	}

	public void setScreenhall(ScreenHall screenhall) {
		this.screenhall = screenhall;
	}

	
	
}