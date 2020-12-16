package miniproject;

import javax.persistence.*;

@Entity
@DiscriminatorValue("S")
public class Staff extends User {

	@ManyToOne
	@JoinColumn(name = "THEATER_ID")
	private Theater theater;

	@Embedded
	private Period workPeriod;

	public Period getWorkPeriod() {
		return workPeriod;
	}

	public void setWorkPeriod(Period workPeriod) {
		this.workPeriod = workPeriod;
	}

	public Theater getTheater() {
		return theater;
	}

	public void setTheater(Theater theater) {
		this.theater = theater;
	}

}