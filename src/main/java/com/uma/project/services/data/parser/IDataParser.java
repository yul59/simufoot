/**
 * 
 */
package com.uma.project.services.data.parser;

import java.util.List;

/**
 * @author HP
 *
 */
public interface IDataParser {

	public List<String> parseChampionship(String data);

	public List<String> parseTeams(String data);

}
