package miniproject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="RESERVATION_SEAT")
public class ReservationSeat {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="RESERVATION_SEAT_ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="RESERVATION_ID")
	private Reservation reservation;
	
	
	@ManyToOne
	@JoinColumn(name="SEAR_ID")
	private Seat seat;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Reservation getReservation() {
		return reservation;
	}


	public void setReservation(Reservation reservation) {
		if (this.reservation != null) {
			this.reservation.getRs().remove(this);
		}
		this.reservation = reservation;
		reservation.getRs().add(this);
	}


	public Seat getSeat() {
		return seat;
	}


	public void setSeat(Seat seat) {
		if (this.seat != null) {
			this.seat.getRs().remove(this);
		}
		this.seat = seat;
		this.seat.getRs().add(this);
	}
	
	
}