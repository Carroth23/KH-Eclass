package kh.web.dto;

public class ContactDTO {
	private int id;
	private String name;
	private String contact;
	
	public ContactDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ContactDTO(int id, String name, String contact) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
}
