package miniproject;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class ScreenHall {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SCREEN_HALL_ID")
	private Long id; // �󿵰� ��ȣ
	private String name; // �󿵰� �̸�
	private Integer totalSeats; // �󿵰� �� �¼���

	@Lob
	private String description; // �󿵰� Ư�̻���

	@ManyToOne
	@JoinColumn(name = "THEATER_ID")
	private Theater theater;

	@OneToMany(mappedBy="screenhall")
	private List<Seat> seat = new ArrayList<Seat>();
	
	@OneToMany
	@JoinColumn(name="SCREEN_HALL_ID")
	private List<MovieSchedule> ms = new ArrayList<MovieSchedule>();

	// �󿵰� -- ������
	public ScreenHall() {
	}

	public ScreenHall(String name) {
		this.name = name;
	}

	// �󿵰� -- Getter, Setter
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

	public Theater getTheater() {
		return theater;
	}

	public void setTheater(Theater theater) {
		if (this.theater !=null) {
			this.theater.getScreenhalls().remove(this);
		}
		this.theater = theater;
		theater.getScreenhalls().add(this);
	}

	public List<Seat> getSeat() {
		return seat;
	}

	public void setSeat(List<Seat> seat) {
		this.seat = seat;
	}

	public List<MovieSchedule> getMs() {
		return ms;
	}

	public void setMs(List<MovieSchedule> ms) {
		this.ms = ms;
	}

}

