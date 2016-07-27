/**
 * 
 */
package com.uma.project.domaine.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author HP
 *
 */
@Entity
public class Club {

	@Id
	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
