package com.bezkoder.springjwt.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.springjwt.models.Stage;
import com.bezkoder.springjwt.repository.StageRepository;

@Service
public class StageService {
@Autowired
StageRepository sr;
	public void notenc(Stage s,Float n1)
	{
		
		s.setNote_univ(n1);
		
	}
}
