package com.bezkoder.springjwt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bezkoder.springjwt.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);

	//Boolean existsByEmail(String email);

	 @Query("SELECT u FROM User u where u.qui  = ?1 ")
	 public List<User> findusers_enc(String qui);
	 

	    public User findByEmail(String email);

    Boolean existsByEmail(String email);
    @Query("SELECT u FROM User u where u.valider  = ?1 ")
    public List<User> findByRole( boolean valider);


}
