package miniproject;

import java.time.LocalDate;

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
	
	public Theater registerTheater(String name) {
		Theater theater = new Theater();
		theater.setClosedDay(LocalDate.of(2020, 12, 25));
		theater.setName(name);
		theater.setTotalAmounts(100000);
		theater.setTotalStaff(3);
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

}