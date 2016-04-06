package org.sanju.ml.client;
import com.marklogic.client.DatabaseClient;
import com.marklogic.client.DatabaseClientFactory;
import com.marklogic.client.DatabaseClientFactory.Authentication;

/**
 *
 * @author Sanju Thomas
 *
 */
public class ClientProvider {

	private static final ServerProperties serverProperties = new ServerProperties();

	public static DatabaseClient getClient(){
		return  DatabaseClientFactory.newClient(serverProperties.getServer(), serverProperties.getPort(),
				serverProperties.getUsername(), serverProperties.getPassword(), Authentication.DIGEST);
	}

}
