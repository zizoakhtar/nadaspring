
package com.bezkoder.springjwt.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
@Getter
@Entity
@Table(	name = "users", 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "username"),
			@UniqueConstraint(columnNames = "email") 
		})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 20)
	private String username;

	@NotBlank
	@Size(max = 50)
	@Email
	private String email;

	@NotBlank
	@Size(max = 120)
	private String password;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	public User() {
	}

	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}

    private String qui;
    
    public String getQui() {
		return qui;
	}

	public void setQui(String qui) {
		this.qui = qui;
	}

	@LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy="useravis",cascade={CascadeType.REMOVE})
    @JsonBackReference
    private List<avis> avisList=new ArrayList<>() ;
   
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToOne(cascade={CascadeType.REMOVE})
    @JsonBackReference
    private proposition propo  ;

    @Transient
    @OneToOne(cascade={CascadeType.REMOVE})
    private Stage stage  ;

    private boolean valider;
private String telephone;
	public boolean isValider() {
        return valider;
    }

    public void setValider(boolean valider) {
        this.valider = valider;
    }


    public proposition getPropo() {
		return propo;
	}

	public void setPropo(proposition propo) {
		this.propo = propo;
	}



	public List<avis> getAvisList() {
		return avisList;
	}

	public void setAvisList(List<avis> avisList) {
		this.avisList = avisList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}
	

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
public String getTelepohone() 
{return telephone;}
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
}
