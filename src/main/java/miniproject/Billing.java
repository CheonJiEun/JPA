package miniproject;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Billing {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="BILLING_ID")
	private Long id;

	@ManyToOne
	@JoinColumn(name="ACCOUNT_ID")
	private Account account;
	
	//결제금액
	private Integer payment;
	
	//결제일시
	private LocalDateTime payDate;
	
	//가맹점명
	private String store;
	
	@Enumerated(EnumType.STRING)
	private PayStatus status;
	
	
	public Billing(String store, Integer payment) {
		this.store = store;
		this.payment = payment;
		this.payDate = LocalDateTime.now();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		if (this.account != null) {
			this.account.getBilling().remove(this);
		}
		this.account = account;
		account.getBilling().add(this);
	}
	
	public void check() {
		if (this.account.getBalance() >= payment) {
			this.account.setBalance(this.account.getBalance()-payment);
			this.status = PayStatus.SUCCESS;
		}
		else
		{
			this.status = PayStatus.CANCEL;
		}
	}

	public Integer getPayment() {
		return payment;
	}

	public void setPayment(Integer payment) {
		this.payment = payment;
	}

	public LocalDateTime getPayDate() {
		return payDate;
	}

	public void setPayDate(LocalDateTime payDate) {
		this.payDate = payDate;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public PayStatus getStatus() {
		return status;
	}

	public void setStatus(PayStatus status) {
		this.status = status;
	}
	
	
	
}