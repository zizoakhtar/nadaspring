package com.bezkoder.springjwt.controllers;

import java.sql.Date;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.springjwt.models.Stage;
import com.bezkoder.springjwt.models.Statistiqque;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.models.avis;
import com.bezkoder.springjwt.models.proposition;
import com.bezkoder.springjwt.repository.StageRepository;
import com.bezkoder.springjwt.repository.UserRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class StageController {
	@Autowired
	   private UserController userController ;

	@Autowired
	StageRepository sr;
	@Autowired
    private JavaMailSender javaMailSender;

	@Autowired
	UserRepository ur;
	
	@DeleteMapping(value = "/delete/{id}" )
    public void Delete(@PathVariable(name = "id") Long id ) {
        sr.deleteById(id);

    }

@Bean
public JavaMailSender getJavaMailSender() {
    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
    mailSender.setHost("smtp.gmail.com");
    mailSender.setPort(587);

    mailSender.setUsername("zeinebsalah96@gmail.com");
    mailSender.setPassword("16091996");

    Properties props = mailSender.getJavaMailProperties();
    props.put("mail.transport.protocol", "smtp");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.debug", "true");

    return mailSender;
}

    @RequestMapping(value = "/update/{id}/{email}", method = RequestMethod.PUT)
    public Stage UpdateStage(@PathVariable(name = "id") Long id ,@PathVariable(name="email") String email) {
String msg="hello";

    	System.out.println("email"+email);
    	System.out.println("id"+id);
    	Stage p=sr.findById(id).get();
    	//System.out.println("stage"+p);
    	
    
    	User u =ur.findByEmail(email);


    	
    	p.setEnseig_stage(u);
		p.setStatus("en_cours");
		p.setId(id);             
      
    	return sr.save(p);   }
    
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN') or hasRole('RAPPORTEUR') or hasRole('ENCADRANT')")

    @RequestMapping(value = "/updatenc/{id}/{email}", method = RequestMethod.PUT)
    public Stage UpdateStagec(@PathVariable(name = "id") Long id ,@PathVariable(name="email") String email) {
String msg="hello";

    	System.out.println("email"+email);
    	System.out.println("id"+id);
    	Stage p=sr.findById(id).get();
    	//System.out.println("stage"+p);
    	
    
    	User u =ur.findByEmail(email);

p.setEnseig_option(u);
p.setStatus("en_cours");
		p.setId(id);             
      
    	return sr.save(p);   }
	 @GetMapping("/getSg/{id_user}")    
	    public String UpdssateStageNote(@PathVariable(name = "id_user") Long id_user ) {
	    	Stage s= sr.findById(id_user).get();
	    	return s.getStagiaire().getEmail();
	    
	    } 
    @GetMapping("/getStageByNote/{id_user}")    
    public Stage UpdateStageNote(@PathVariable(name = "id_user") Long id_user ) {
    	return sr.findStageByNote(id_user);
    
    }

    @RequestMapping(value = "/validation/{id}", method = RequestMethod.PUT)
    public Stage  validation(@PathVariable(name = "id") Long id )
    {
    	Stage stage=sr.findById(id).get();

if(	(stage.getNote_jury()>10)&&(stage.getNote_rap()>10)&&(stage.getNote_univ()>10))
    {
    stage.setStatus("validée");

    }
else
{
stage.setStatus("terminal");
}		
stage.setId(id);      
/*SimpleMailMessage msg = new SimpleMailMessage();
msg.setTo(stage.getStagiaire().getEmail());

msg.setSubject("bonjour votre stage de  "+stage.getTheme()+"est validéé veuillez contacter la direction d'esprit ");
msg.setText("votre proposition de  "+stage.getTheme()+"est accepter veuillez contacter la direction d'esprit ");

javaMailSender.send(msg);
*/return sr.save(stage);
    	
    }
    
    
    
    
    @RequestMapping(value = "/notEnc/{id}/{esprit}", method = RequestMethod.PUT)
    public Stage UpdateStaget(@PathVariable(name = "id") Long id ,@PathVariable(name="esprit")Float aa)
    		
    {

    	  Stage p=sr.findById(id).get();
    	  p.setNote_univ(aa);
     
    	p.setId(id);      

    	return sr.save(p);
    	}
    

    
    
    
    
    
    @RequestMapping(value = "/stat", method = RequestMethod.GET)
    public Statistiqque stat()
    {
    int n=sr.countstage();
    
    int encours=sr.findStageByStatus("en_cours");
    int enattente=sr.findStageByStatus("en_attente");
    int terminal=sr.findStageByStatus("terminal");
    
   encours=encours*100/n;
   terminal=terminal*100/n;
   enattente=enattente*100/n;
   Statistiqque e=new Statistiqque();
   e.setLabel1("en_cours");
   e.setNb1(encours);
   e.setLabel2("en_attente");
   e.setNb2(enattente);
   e.setLabel3("terminé");
   e.setNb3(terminal);
   
   
   
   
   return e;
   
    }
    
    
    @RequestMapping(value = "/NotJury/{id}/{note_jury}", method = RequestMethod.PUT)
    public Stage UpdateStagettt(@PathVariable(name = "id") Long id ,@PathVariable(name="note_jury")Float bb)
    		
    {

    	  Stage p=sr.findById(id).get();
    	  p.setNote_jury(bb);
    	p.setId(id);      

    	return sr.save(p);

    	} 
    
    @RequestMapping(value = "/NotRapp/{id}/{note_rapp}", method = RequestMethod.PUT)
    public Stage UpdateStagett(@PathVariable(name = "id") Long id ,@PathVariable(name="note_rapp")Float bb)
    		
    {

    	  Stage p=sr.findById(id).get();
    	  p.setNote_rap(bb);
    	p.setId(id);      

    	return sr.save(p);

    	}

    
@GetMapping("/getStageById/{id}")
public Stage get(@PathVariable Long id) {
	return sr.findById(id).get();
}

	@GetMapping(value = "/listStage" )
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN') or hasRole('RAPPORTEUR') or hasRole('ENCADRANT')")
	public List<Stage> propoList(){
		return  sr.findAll();

	}


	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	@PostMapping("/ajoutConv/{user_id}")
	public  ResponseEntity<String> addb(@PathVariable(value = "user_id") Long id_user,
			String theme,String dateDeb, String datefin,
			String etablissement, String adresse, 
			String enc_entreprise, String mail_enc_entreprise,String telephone
			) {
		  String message = "";
		    Stage a = new Stage(userController.user(id_user),theme, dateDeb, datefin,
			 etablissement, adresse, enc_entreprise,  mail_enc_entreprise,telephone);
		    userController.user(id_user).setTelephone(telephone);
		    a.setStatus("en_attente");
		   sr.save(a);
		         message = "You successfully add ";
		return ResponseEntity.status(HttpStatus.OK).body(message);
    }

		
		    }
