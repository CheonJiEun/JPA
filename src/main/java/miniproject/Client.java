package miniproject;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("C")
public class Client extends User {

	//�ֹε�Ϲ�ȣ
	private String rpn;
	private String email;
	
	
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
	
}
