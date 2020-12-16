package miniproject;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("C")
public class Client extends User {

	//주민번호
	private String rpn;
	private String email;
	
	@OneToMany(mappedBy="client")
	private List<MovieReview> mr = new ArrayList<MovieReview>();
	
	public String getRpn() {
		return rpn;
	}
	public void setRpn(String rpn) {
		this.rpn = rpn;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Billing pay(Theater theater, Reservation reservation, Account account) {
		Billing billing = new Billing(theater.getName(), reservation.getPrice());
		billing.setAccount(account);
		billing.check();
		if (billing.getStatus().toString().equals("SUCCESS"))
			theater.setTotalAmounts(theater.getTotalAmounts()+reservation.getPrice());
		reservation.setBilling(billing);
		return billing;
	}
}

