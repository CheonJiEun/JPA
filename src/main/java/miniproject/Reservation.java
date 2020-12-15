package miniproject;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Reservation {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="RESERVATION_ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;
	
	@OneToOne
	@JoinColumn(name="BILLING_ID")
	private Billing billing;
	
	private LocalDate reserveDate;
	
	private LocalDate cancelDate;
	
	private LocalDate refundDate;
	
	private Integer price;
	
	@OneToOne
	@JoinColumn(name="SEAT_ID")
	private Seat seat;
	
	public Reservation() {
		this.reserveDate = LocalDate.now();
		this.price = 9000; //타입 지정안하면 성인 비용으로 지불
	}
	
	public Reservation(Integer price) {
		this.reserveDate = LocalDate.now();
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		if (this.user != null) {
			this.user.getReservation().remove(this);
		}
		this.user = user;
		user.getReservation().add(this);
	}

	public LocalDate getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(LocalDate cancelDate) {
		this.cancelDate = cancelDate;
	}

	public LocalDate getReserveDate() {
		return reserveDate;
	}

	public void setReserveDate(LocalDate reserveDate) {
		this.reserveDate = reserveDate;
	}

	public LocalDate getRefundDate() {
		return refundDate;
	}

	public void setRefundDate(LocalDate refundDate) {
		this.refundDate = refundDate;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Billing getBilling() {
		return billing;
	}

	public void setBilling(Billing billing) {
		this.billing = billing;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
		seat.setReservation(this);
	}


	
	
}