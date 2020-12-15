package miniproject;

import java.time.LocalDate;
import javax.persistence.Embeddable;

@Embeddable
public class Period {
	private LocalDate startDate;
	private LocalDate endDate;
	
	public Period() {
		this.startDate = LocalDate.now();
		this.endDate = LocalDate.now();
	}
	
	public Period(LocalDate a, LocalDate b) {
		this.startDate = a;
		this.endDate = b;
	}


	public boolean isWork(LocalDate date) {
		if (date.compareTo(startDate) >= 0 && date.compareTo(endDate) <= 0)
			return true;
		else
			return false;
	}
}