/**
 * 
 */
package com.uma.project.domaine.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uma.project.domaine.entity.Club;

/**
 * @author HP
 *
 */
@Repository
public interface ClubRepository extends JpaRepository<Club, Serializable> {

	public Club findById(@Param("id") int id);

}
