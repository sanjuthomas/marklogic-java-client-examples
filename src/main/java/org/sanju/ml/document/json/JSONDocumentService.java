package org.sanju.ml.document.json;

import org.sanju.ml.document.pojo.DummyDocument;
import org.sanju.ml.document.services.DocumentService;

import com.fasterxml.jackson.databind.JsonNode;
import com.marklogic.client.document.JSONDocumentManager;
import com.marklogic.client.io.JacksonHandle;

/**
 *
 * @author Sanju Thomas
 *
 */
public class JSONDocumentService extends DocumentService{

	/**
	 *
	 * @param dummyDocument
	 */
	public void save(final DummyDocument dummyDocument){

		final JSONDocumentManager documentManager = this.createDocumentManager();
		final JsonNode jsonNode = mapper.convertValue(dummyDocument, JsonNode.class);
		documentManager.write(this.generateURI(dummyDocument), new JacksonHandle(jsonNode));
	}

}
