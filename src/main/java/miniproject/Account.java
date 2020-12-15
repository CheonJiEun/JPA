package miniproject;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Account {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ACCOUNT_ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;
	
	private String bank;
	private String accountNumber;
	private Integer balance;
	
	@OneToMany(mappedBy = "account")
	private List<Billing> billing = new ArrayList<Billing>();
	
	public Account(String bank, String accountNumber, Integer balance) {
		this.bank = bank;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	public List<Billing> getBilling() {
		return billing;
	}
	public void setBilling(List<Billing> billing) {
		this.billing = billing;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		if (this.user != null) {
			this.user.getAccount().remove(this);
		}
		this.user = user;
		user.getAccount().add(this);
	}
	
	
}