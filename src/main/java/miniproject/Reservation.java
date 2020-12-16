package miniproject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	private Integer seatNum;
	
	@OneToMany(mappedBy="reservation")
	private List<ReservationSeat> rs = new ArrayList<ReservationSeat>();
	
	@ManyToOne
	@JoinColumn(name = "MOVIE_SCHEDULE_ID")
	private MovieSchedule ms;
	   
	public Reservation() {
		this.reserveDate = LocalDate.now();
		this.price = 9000; //타입 지정안하면 성인 비용으로 지불
		this.seatNum = 1;
	}
	
	public Reservation(Integer price, Integer seatNum) {
		this.reserveDate = LocalDate.now();
		this.seatNum = seatNum;
		this.price = price*seatNum;
	}

	public Reservation(Integer price1, Integer seatNum1, Integer price2, Integer seatNum2) {
		this.reserveDate = LocalDate.now();
		this.seatNum = seatNum1+seatNum2;
		this.price = price1*seatNum1 + price2*seatNum2;
	}
	
	public Reservation(Integer price1, Integer seatNum1, Integer price2, Integer seatNum2, Integer price3, Integer seatNum3) {
		this.reserveDate = LocalDate.now();
		this.seatNum = seatNum1+seatNum2+seatNum3;
		this.price = price1*seatNum1 + price2*seatNum2 + price3*seatNum3;
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

	public Integer getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(Integer seatNum) {
		this.seatNum = seatNum;
	}

	public List<ReservationSeat> getRs() {
		return rs;
	}

	public void setRs(List<ReservationSeat> rs) {
		this.rs = rs;
	}

	public MovieSchedule getMs() {
		return ms;
	}

	public void setMs(MovieSchedule ms) {
		this.ms = ms;
	}
}
