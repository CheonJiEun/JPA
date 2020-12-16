package miniproject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Statistics {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "STATISTICS_ID")
	private Long id;

	private Integer totalClient;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getTotalClient() {
		return totalClient;
	}

	public void setTotalClient(Integer totalClient) {
		this.totalClient = totalClient;
	}

}
