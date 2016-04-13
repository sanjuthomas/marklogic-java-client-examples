package org.sanju.ml.client;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.sanju.ml.client.ServerProperties;

/**
 *
 * @author Sanju Thomas
 *
 */
public class TestServerProperties {

	private ServerProperties serverProperties;

	@Before
	public void setUp(){
		this.serverProperties = new ServerProperties();
	}

	@Test
	public void shouldFindServerProperties(){
		assertEquals("localhost", this.serverProperties.getServer());
		assertEquals(12000, this.serverProperties.getPort());
		assertEquals("admin", this.serverProperties.getUsername());
		assertEquals("admin", this.serverProperties.getPassword());
	}

}
