package miniproject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Theater {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "THEATER_ID")
	private Long id; // 영화관 번호

	private String name;
	private LocalDate closedDay; // 영화관 휴무일

	private Integer TotalStaff; // 영화관 직원 수
	private Integer TotalAmounts; // 영화관 수입

	@OneToMany(mappedBy = "theater")
	private List<ScreenHall> screenhalls = new ArrayList<ScreenHall>();

	@OneToMany(mappedBy = "theater")
	private List<Staff> staffs = new ArrayList<Staff>();

	// 영화관 -- 생성자
	public Theater() {
		super();
	}

	// 영화관 -- getter, setter
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

	public LocalDate getClosedDay() {
		return closedDay;
	}

	public void setClosedDay(LocalDate closedDay) {
		this.closedDay = closedDay;
	}

	public Integer getTotalStaff() {
		return TotalStaff;
	}

	public void setTotalStaff(List<Staff> staffs) {
//      TotalStaff = totalStaff;
		TotalStaff = 0; /// yeom
		TotalStaff = staffs.size(); /// yeom
	}

	public Integer getTotalAmounts() {
		return TotalAmounts;
	}

	public void setTotalAmounts(Integer totalAmounts) {
		TotalAmounts = totalAmounts;
	}

	public List<ScreenHall> getScreenhalls() {
		return screenhalls;
	}

	public void setScreenhalls(List<ScreenHall> screenhalls) {
		this.screenhalls = screenhalls;
	}

	public List<Staff> getStaffs() {
		return staffs;
	}

	public void setStaffs(List<Staff> staffs) {
		this.staffs = staffs;
	}

}