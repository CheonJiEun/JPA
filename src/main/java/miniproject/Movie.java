package miniproject;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Movie extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MOVIE_ID")
	private Long id; // ��ȭ ��ȣ

	private String name; // ��ȭ �̸�
	private String director; // ����
	private String story; // �ٰŸ�
	private Integer limitAge; // ���� ����

	@ElementCollection
	@CollectionTable(name = "ACTOR", joinColumns = @JoinColumn(name = "MOVIE_ID"))
	private List<Actor> actors = new ArrayList<Actor>();

	private LocalDate openDay; // ������
	private LocalTime runTime; // �� �ð�

	private Integer totalAudience;

	@OneToMany(mappedBy = "movie")
	private List<MovieSchedule> ms = new ArrayList<MovieSchedule>();

	@OneToMany(mappedBy = "movie")
	private List<MovieReview> mr = new ArrayList<MovieReview>();

	@OneToOne
	@JoinColumn(name = "STATISTICS_ID")
	private Statistics statistics;


	public Movie() {
	}

	public Movie(Manager manager, String name, String director, LocalDate openDay) {
		this.name = name;
		this.director = director;
		this.openDay = openDay;
		this.limitAge = 12; // 12�� default
		this.runTime = LocalTime.of(2, 30); // 150�� default
		this.setCreatedDate(LocalDateTime.now());
		this.setCreatedBy(manager.getName());
	}
	///

	// ����, ����
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	public Integer getLimitAge() {
		return limitAge;
	}

	public void setLimitAge(Integer limitAge) {
		this.limitAge = limitAge;
	}

	public LocalDate getOpenDay() {
		return openDay;
	}

	public void setOpenDay(LocalDate openDay) {
		this.openDay = openDay;
	}

	public LocalTime getRunTime() {
		return runTime;
	}

	public void setRunTime(LocalTime runTime) {
		this.runTime = runTime;
	}

	public Integer getTotalAudience() {
		return totalAudience;
	}

	public void setTotalAudience(Integer totalAudience) {
		this.totalAudience = totalAudience;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<MovieSchedule> getMs() {
		return ms;
	}

	public void setMs(List<MovieSchedule> ms) {
		this.ms = ms;
	}

	public List<MovieReview> getMr() {
		return mr;
	}

	public void setMr(List<MovieReview> mr) {
		this.mr = mr;
	}

	public Statistics getStatistics() {
		return statistics;
	}

	public void setStatistics(Statistics statistics) {
		this.statistics = statistics;
	}

}