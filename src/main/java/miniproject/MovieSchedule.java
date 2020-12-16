package miniproject;

import java.time.LocalTime;

import javax.persistence.*;

@Entity
public class MovieSchedule extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MOVIE_SCHEDULE_ID")
	private Long id; // ��ȭ ������ ��ȣ

	// �󿵰�->������ �ϴ�� �ܹ����̱⿡ �ʿ����������?!
//   @ManyToOne
//   @JoinColumn(name = "SCREEN_HALL_ID")
//   private ScreenHall screenhall; // �󿵰� ��ȣ

	@ManyToOne
	@JoinColumn(name = "MOVIE_ID")
	private Movie movie; // ��ȭ ��ȣ

	private LocalTime startTime; // �� ���۽ð�
	private LocalTime endTime; // �� ����ð�

	@ManyToOne
	@JoinColumn(name = "RESERVATION_ID")
	private Reservation reservation;

	// ����, ����
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