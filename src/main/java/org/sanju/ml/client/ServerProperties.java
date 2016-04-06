package org.sanju.ml.client;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

/**
 *
 * @author Sanju Thomas
 *
 */
public class ServerProperties {

	public ServerProperties() {
		final Properties properties = new Properties();
		Reader reader = null;
		try {
			reader = new FileReader(new File("./src/main/resources/server.properties"));
			properties.load(reader);
		} catch (final IOException e) {
			throw new RuntimeException(e);
		}finally{
			if(reader != null){
				try {
					reader.close();
				} catch (final IOException e) {
					throw new RuntimeException(e);
				}
			}
		}
		this.server = (String) properties.get("server");
		this.port = Integer.valueOf((String) properties.get("port"));
		this.username = (String) properties.get("username");
		this.password = (String) properties.get("password");
	}


	private String server;
	private int port;
	private String username;
	private String password;


	public String getServer() {
		return this.server;
	}
	public void setServer(final String server) {
		this.server = server;
	}
	public int getPort() {
		return this.port;
	}
	public void setPort(final int port) {
		this.port = port;
	}
	public String getUsername() {
		return this.username;
	}
	public void setUsername(final String username) {
		this.username = username;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(final String password) {
		this.password = password;
	}

}
