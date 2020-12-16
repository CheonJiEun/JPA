package miniproject;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("M")
public class Manager extends User {
	@Embedded
	private Period workPeriod;

	public Period getWorkPeriod() {
		return workPeriod;
	}

	public void setWorkPeriod(Period workPeriod) {
		this.workPeriod = workPeriod;
	}

	public Theater registerTheater(String name, List<Staff> staffs) {
		Theater theater = new Theater();
		theater.setClosedDay(LocalDate.of(2020, 12, 25));
		theater.setName(name);
		theater.setTotalAmounts(0);
		theater.setTotalStaff(staffs); /// yeom
		return theater;
	}

	public ScreenHall registerScreenHall(Theater theater, String name, String desc) {
		ScreenHall screenhall = new ScreenHall();
		screenhall.setDescription(desc);
		screenhall.setName(name);
		screenhall.setTotalSeats(10);
		screenhall.setTheater(theater);
		return screenhall;
	}

	/// yeom
	public MovieSchedule registerMovieSchedule(List<MovieSchedule> mss, Movie movie, LocalTime startTime,
			LocalTime endTime) {
		MovieSchedule movieschedule = new MovieSchedule();
		movieschedule.setMovie(movie);
		movieschedule.setStartTime(startTime);
		movieschedule.setEndTime(endTime);
		movieschedule.setCreatedBy(this.getName());
		movieschedule.setCreatedDate(LocalDateTime.now());
		mss.add(movieschedule);
		return movieschedule;
	}
	///

}