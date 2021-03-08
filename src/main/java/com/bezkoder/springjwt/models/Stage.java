package com.bezkoder.springjwt.models;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
//@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Stage {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

//	//encadrant université
	@ManyToOne
	@JoinColumn(name = "E_stage_id", nullable = true)
	private User enseig_stage;

	@ManyToOne
	@JoinColumn(name = "E_opt_id", nullable = true)
	private User enseig_option;
//

	@OneToOne
	@JoinColumn(name = "stagiaire", nullable = true)
	private User stagiaire ;



@Transient
private  String telephone;

	public String etablissement;
	public String adresse;
	
	private String status;
	public String enc_entreprise;
	public String mail_enc_entreprise;
	public String dateDeb;
	public String datefin;
	public String theme;
	public Float note_jury ;
	public Float note_rap ;
	public Float note_univ ;

		public Stage(User stagiaire,String theme, String dateDeb, String datefin,
			String etablissement, String adresse,
			String enc_entreprise, String mail_enc_entreprise, String telephone) {
		super();
		this.stagiaire = stagiaire;
		this.etablissement = etablissement;
		this.adresse = adresse;
		this.enc_entreprise = enc_entreprise;
		this.mail_enc_entreprise = mail_enc_entreprise;
		this.dateDeb = dateDeb;
		this.datefin = datefin;
		this.theme = theme;
		this.telephone=telephone;
	}

		public Stage(String theme) {
			super();
			this.theme = theme;
		}

		public Stage(User stagiaire, String theme) {
			this.stagiaire = stagiaire;
			this.theme = theme;
		}
@OneToOne
	private proposition pfe;
}

