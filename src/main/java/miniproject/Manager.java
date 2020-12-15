package miniproject;

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
	
}