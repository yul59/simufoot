package com.uma.project;


import com.google.common.io.CharStreams;
import com.uma.project.services.data.parser.json.JsonDataParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class jsonDataParserTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void parseTeamsTest() {

        String jsonData = "";
        try {
            jsonData = this.loadFileString("/teams.json");
        } catch (final IOException e) {
            this.logger.debug("Exception sur le test parseTeamsTest : {}", e.getMessage());
        }

        this.logger.debug("resultat = {}", new JsonDataParser().parseTeams(jsonData).toString());
    }

    public String loadFileString(String file) throws IOException {
        final InputStream xmlStream = this.getClass().getResourceAsStream(file);
        final String teams = CharStreams.toString(new InputStreamReader(xmlStream));
        return teams;
    }
}
