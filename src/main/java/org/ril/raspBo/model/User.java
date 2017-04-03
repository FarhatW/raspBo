package org.ril.raspBo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/*
 * This is our model class and it corresponds to Country table in database
 */
@Entity
@Table(name= "user")
public class User {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name= "first_name")
	private String first_name;

	@Column(name= "last_name")
	private String last_name;

	@Column(name="email")
	private String  email;

	@Column(name= "phone")
	private String  phone;

	@Column(name="qrid")
	private String qr_code_id;

	@OneToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name= "user_has_company", joinColumns=@JoinColumn(name= "company_id", referencedColumnName="id"))
	private List<Company> companyId =  new ArrayList<>();

	@OneToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name= "user_has_groupe", joinColumns=@JoinColumn(name="groupe_id", referencedColumnName="id"))
	private List<Groupe> groupeId =  new ArrayList<>();


	public User() {
		super();
	}

	public User(String first_name, String last_name, String email, String phone, String qr_code_id) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.phone = phone;
		this.qr_code_id = qr_code_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getQr_code_id() {
		return qr_code_id;
	}

	public void setQr_code_id(String qr_code_id) {
		this.qr_code_id = qr_code_id;
	}
}