/**
 * 
 */
package com.uma.project.services.club;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.uma.project.domaine.entity.Club;
import com.uma.project.domaine.repository.ClubRepository;

/**
 * @author HP
 *
 */
@Component
public class ClubService {

	@Resource
	ClubRepository clubRepository;

	public Club getClub(int id) {

		Club club = clubRepository.findById(id);

		return club;
	}
}
