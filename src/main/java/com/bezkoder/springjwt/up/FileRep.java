package com.bezkoder.springjwt.up;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRep extends JpaRepository<FileInfo, Long>{

}
