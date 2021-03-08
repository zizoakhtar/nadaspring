package com.bezkoder.springjwt.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "propositions")
public class proposition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_proposition;
    private  String propositionscanner ;
    @JsonIgnore
@OneToOne
@OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name ="User_id")
    private  User user ;
    private String Description;
    @Column(name = "type")
    private String type;
@OneToOne
private Stage p;

    public Stage getP() {
	return p;
}

public void setP(Stage p) {
	this.p = p;
}


	public proposition(String propositionscanner, User user, String type, String name) {
        this.propositionscanner = propositionscanner;
        this.user = user;
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="name")
    private String name ;
        public Long getId_proposition() {
        return id_proposition;
    }

    public void setId_proposition(Long id_proposition) {
        this.id_proposition = id_proposition;
    }

    public String getPropositionscanner() {
        return propositionscanner;
    }

    public void setPropositionscanner(String propositionscanner) {
        this.propositionscanner = propositionscanner;
    }

 

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

       public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

        public proposition() {
    }

    public proposition(String propositionscanner, String description, String type, String name) {
        this.propositionscanner = propositionscanner;
        Description = description;
        this.type = type;
        this.name = name;
    }

}
