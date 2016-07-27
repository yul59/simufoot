/**
 * 
 */
package com.uma.project.services.data.initializer;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.uma.project.services.data.parser.IDataParser;
import com.uma.project.services.data.provider.DataProvider;

/**
 * @author HP
 *
 */
@Component
public class DataInitializerService extends DataProvider {

	@Resource
	IDataParser dataParser;

	public String getAllChampionship() {

		String url = providerUrl + "soccerseasons";
		// String url = providerUrl + "competitions/?season=2015";
		String data = this.callUrl(url);

		return dataParser.parseChampionship(data).toString();
	}

	public String getTeams(String idCompetitions) {

		String url = providerUrl + "competitions/" + idCompetitions + "/teams";
		String data = this.callUrl(url);

		return data;

		// return dataParser.parseChampionship(data).toString();

	}
}
