/**
 * 
 */
package com.uma.project.services.data.parser.json;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import com.uma.project.services.data.parser.IDataParser;

/**
 * @author HP
 *
 */
@Component
public class JsonDataParser implements IDataParser {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.uma.project.services.data.parser.IDataParser#parseChampionship(java
	 * .lang.String)
	 */
	@Override
	public List<String> parseChampionship(String data) {

		List<String> list = new ArrayList<String>();

		JSONParser parser = new JSONParser();

		try {

			Object obj = parser.parse(data);
			JSONArray array = (JSONArray) obj;

			int size = array.size();
			for (int i = 0; i < size; i++) {
				JSONObject champ = (JSONObject) array.get(i);
				// System.out.println("id=" + champ.get("id"));
				// System.out.println("caption=" + champ.get("caption"));
				list.add("id=" + champ.get("id") + " - caption="
						+ champ.get("caption"));
			}

		} catch (ParseException pe) {
			System.out.println("position: " + pe.getPosition());
			System.out.println(pe);
		}

		return list;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.uma.project.services.data.parser.IDataParser#parseTeams(java.lang
	 * .String)
	 */
	@Override
	public List<String> parseTeams(String data) {

		List<String> list = new ArrayList<String>();

		JSONParser parser = new JSONParser();

		try {

			Object obj = parser.parse(data);
			JSONObject teams = (JSONObject) obj;
			JSONArray array = (JSONArray) teams.get("teams");
			int size = array.size();
			for (int i = 0; i < size; i++) {
				JSONObject champ = (JSONObject) array.get(i);
				// System.out.println("id=" + champ.get("id"));
				// System.out.println("caption=" + champ.get("caption"));
				list.add("name =" + champ.get("name"));
			}

		} catch (ParseException pe) {
			System.out.println("position: " + pe.getPosition());
			System.out.println(pe);
		}

		return list;
	}
}
