package miniproject;

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

@Entity
public class Seat {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="SEAT_ID")
	private Long id;
	
	private String name;

	@OneToMany(mappedBy="seat")
	private List<ReservationSeat> rs = new ArrayList<ReservationSeat>();
	
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

	public ScreenHall getScreenhall() {
		return screenhall;
	}

	public void setScreenhall(ScreenHall screenhall) {
		if (this.screenhall != null) {
			this.screenhall.getSeat().remove(this);
		}
		this.screenhall = screenhall;
		this.screenhall.getSeat().add(this);
	}

	public List<ReservationSeat> getRs() {
		return rs;
	}

	public void setRs(List<ReservationSeat> rs) {
		this.rs = rs;
	}

	
	
}