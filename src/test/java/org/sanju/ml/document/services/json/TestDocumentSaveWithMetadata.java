package org.sanju.ml.document.services.json;

import static org.junit.Assert.assertNull;

import java.util.Properties;

import org.junit.Before;
import org.junit.Test;
import org.sanju.ml.document.pojo.DummyDocument;

/**
 *
 * @author Sanju Thomas
 *
 */
public class TestDocumentSaveWithMetadata {

	private JSONDocumentWithMetadataService jsonDocumentWithMetadataService;

	@Before
	public void setUp(){
		this.jsonDocumentWithMetadataService = new JSONDocumentWithMetadataService();
	}

	@Test
	public void shouldSaveDocumentWithMetadata(){

		final DummyDocument document = new DummyDocument(1005);
		final Properties properties = new Properties();
		properties.put("property1", "value1");
		this.jsonDocumentWithMetadataService.save(document, properties);
		assertNull(this.jsonDocumentWithMetadataService.readProperties(document));

	}

}
