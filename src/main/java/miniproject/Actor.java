package miniproject;

import javax.persistence.*;

@Embeddable
public class Actor {
   private Long id; // 배우 아이디
   private String name; // 배우 이름
   private String characterName;
   private String role;

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

	public String getCharacterName() {
		return characterName;
	}
	
	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
   
}