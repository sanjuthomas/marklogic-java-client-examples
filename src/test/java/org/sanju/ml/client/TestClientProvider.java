package org.sanju.ml.client;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.marklogic.client.DatabaseClient;

/**
 *
 * @author Sanju Thomas
 *
 */
public class TestClientProvider {

	@Test
	public void shouldGetClient(){
		final DatabaseClient client = ClientProvider.getClient();
		assertEquals("JSON",  client.newJSONDocumentManager().getContentFormat().toString());
	}

}
