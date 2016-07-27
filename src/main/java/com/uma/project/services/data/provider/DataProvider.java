/**
 * 
 */
package com.uma.project.services.data.provider;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author HP
 *
 */
public abstract class DataProvider {

	@Value("${com.uma.project.services.data.provider.url}")
	protected String providerUrl;

	public String callUrl(String myURL) {

		System.out.println("Requested URL:" + myURL);

		StringBuilder sb = new StringBuilder();
		URLConnection urlConn = null;
		InputStreamReader in = null;

		try {
			URL url = new URL(myURL);
			urlConn = url.openConnection();

			if (urlConn != null) {
				urlConn.setReadTimeout(60 * 1000);
			}

			if (urlConn != null && urlConn.getInputStream() != null) {

				in = new InputStreamReader(urlConn.getInputStream(),
						Charset.defaultCharset());
				BufferedReader bufferedReader = new BufferedReader(in);

				if (bufferedReader != null) {
					int cp;
					while ((cp = bufferedReader.read()) != -1) {
						sb.append((char) cp);
					}
					bufferedReader.close();
				}
			}

			in.close();

		} catch (Exception e) {
			throw new RuntimeException("Exception while calling URL:" + myURL,
					e);
		}

		return sb.toString();
	}

}
