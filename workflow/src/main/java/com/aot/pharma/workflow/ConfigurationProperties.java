package com.aot.pharma.workflow;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationProperties {

	private static final String CONFIG_FILE = "pharma.properties";


	public static Properties getConfiguration() throws FileNotFoundException, IOException {
		final Properties properties;
        try (InputStream input = ConfigurationProperties.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
        	properties = new Properties();
            if (input != null) {
            	properties.load(input);
            }
        }
		return properties;
	}
}
