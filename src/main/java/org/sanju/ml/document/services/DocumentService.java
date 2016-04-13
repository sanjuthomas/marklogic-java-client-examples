package org.sanju.ml.document.services;

import org.sanju.ml.client.ClientProvider;
import org.sanju.ml.document.pojo.DummyDocument;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marklogic.client.DatabaseClient;
import com.marklogic.client.document.JSONDocumentManager;

/**
 *
 * @author Sanju Thomas
 *
 */
public class DocumentService {

	protected static final ObjectMapper mapper = new ObjectMapper();

	protected JSONDocumentManager createDocumentManager() {

		final DatabaseClient client = ClientProvider.getClient();
		final JSONDocumentManager documentManager = client.newJSONDocumentManager();
		return documentManager;
	}

	protected String generateURI(final DummyDocument dummyDocumnet){

		return "/"+dummyDocumnet.getClass().getSimpleName().toLowerCase()+"/"+dummyDocumnet.getId();
	}

}
