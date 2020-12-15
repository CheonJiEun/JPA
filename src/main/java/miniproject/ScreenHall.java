package miniproject;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class ScreenHall {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SCREEN_HALL_ID")
	private Long id; // 상영관 번호
	private String name; // 상영관 이름
	private Integer totalSeats; // 상영관 총 좌석수

	@Lob
	private String description; // 상영관 특이사항

	@ManyToOne
	@JoinColumn(name = "THEATER_ID")
	private Theater theater;

	// 상영관 -- 생성자
	public ScreenHall() {
	}

	public ScreenHall(String name) {
		this.name = name;
	}

	// 상영관 -- Getter, Setter
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(Integer totalSeats) {
		this.totalSeats = totalSeats;
	}

	public Seat registerSeat(String name) {
		Seat seat = new Seat(name);
		seat.setScreenhall(this);
		return seat;
	}
	public Theater getTheater() {
		return theater;
	}

	public void setTheater(Theater theater) {
		this.theater = theater;
	}

}