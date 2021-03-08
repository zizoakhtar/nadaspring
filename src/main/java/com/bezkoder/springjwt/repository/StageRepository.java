package com.bezkoder.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bezkoder.springjwt.models.Stage;

@Repository
public interface StageRepository extends JpaRepository<Stage, Long>{

    @Query("SELECT u FROM Stage u where u.stagiaire.id = :id")
	public Stage findStageByNote(@Param("id") Long id);

    @Query("SELECT count (u) FROM Stage u ")
    public int countstage();
    
    
    @Query("SELECT count(u) FROM Stage u where u.status =:ok")
   	public int findStageByStatus(String ok);

    @Query("SELECT s.pfe.name FROM Stage s JOIN proposition u where u.id_proposition = s.id")
    public String find();
    
}
