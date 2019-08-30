package com.aot.pharma.workflow;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class ConfigurationProperties {

	private static final String CONFIG_FILE = "/pharma.properties";

	public static File readFileFromClasspath() {
		final URL fileUrl = ConfigurationProperties.class.getResource(CONFIG_FILE);
		return new File(fileUrl.getFile());
	}

	public static Properties getConfiguration() throws FileNotFoundException, IOException {
		final Properties properties = new Properties();
		try {
			InputStream input = new FileInputStream(readFileFromClasspath());
			properties.load(input);
		}catch (Exception e) {
			
		}
		return properties;
	}
}
