package miniproject;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) 
@DiscriminatorColumn(name="DTYPE")
public abstract class User {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="USER_ID")
	private Long id;
	
	private String name;
	private String password;
	private String phoneNumber;
	
	@OneToMany(mappedBy = "user")
	private List<Account> account = new ArrayList<Account>();
	
	@OneToMany(mappedBy = "user")
	private List<Reservation> reservation = new ArrayList<Reservation>();
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public List<Reservation> getReservation() {
		return reservation;
	}
	public void setReservation(List<Reservation> reservation) {
		this.reservation = reservation;
	}
	public List<Account> getAccount() {
		return account;
	}
	public void setAccount(List<Account> account) {
		this.account = account;
	}

}