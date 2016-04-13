package org.sanju.ml.document.services.json;

import org.sanju.ml.document.pojo.DummyDocument;
import org.sanju.ml.document.services.DocumentService;

import com.fasterxml.jackson.databind.JsonNode;
import com.marklogic.client.document.DocumentPage;
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

		final JSONDocumentManager documentManager = super.createDocumentManager();
		final JsonNode jsonNode = mapper.convertValue(dummyDocument, JsonNode.class);
		documentManager.write(super.generateURI(dummyDocument), new JacksonHandle(jsonNode));
	}


	public DummyDocument find(final DummyDocument dummyDocument){

		final JSONDocumentManager documentManager = this.createDocumentManager();
		final DocumentPage documentPage = documentManager.read(super.generateURI(dummyDocument));
		if(documentPage.hasNext()){
			JacksonHandle handle = new JacksonHandle();
			handle = documentPage.nextContent(handle);
			return mapper.convertValue(handle.get(), DummyDocument.class);
		}
		return null;
	}

	public void delete(final DummyDocument dummyDocument){

		final JSONDocumentManager documentManager = this.createDocumentManager();
		documentManager.delete(super.generateURI(dummyDocument));
	}

}
