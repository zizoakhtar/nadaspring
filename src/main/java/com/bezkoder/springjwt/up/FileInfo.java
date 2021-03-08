package com.bezkoder.springjwt.up;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.bezkoder.springjwt.models.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class FileInfo {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
  private String url;
  @JsonIgnore
  @ManyToOne
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name ="User_id")
  private  User user ;

 
public FileInfo(String name, String url) {
	super();
	this.name = name;
	this.url = url;
}

public FileInfo(String name, String url, User user2) {
    this.name = name;
    this.url = url;
    this.user=user;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUrl() {
    return this.url;
  }

  public void setUrl(String url) {
    this.url = url;
  }
}
