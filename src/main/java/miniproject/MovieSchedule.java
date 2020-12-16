package miniproject;

import java.time.LocalTime;

import javax.persistence.*;

@Entity
public class MovieSchedule extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MOVIE_SCHEDULE_ID")
	private Long id; // 영화 스케줄 번호

	// 상영관->스케쥴 일대다 단방향이기에 필요없지않을까?!
//   @ManyToOne
//   @JoinColumn(name = "SCREEN_HALL_ID")
//   private ScreenHall screenhall; // 상영관 번호

	@ManyToOne
	@JoinColumn(name = "MOVIE_ID")
	private Movie movie; // 영화 번호

	private LocalTime startTime; // 상영 시작시간
	private LocalTime endTime; // 상영 종료시간

	@ManyToOne
	@JoinColumn(name = "RESERVATION_ID")
	private Reservation reservation;

	// 게터, 세터
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		if (this.movie != null) {
			this.movie.getMs().remove(this);
		}
		this.movie = movie;
		movie.getMs().add(this);
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
}