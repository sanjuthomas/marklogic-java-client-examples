package org.sanju.ml.document.services.json;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.sanju.ml.document.pojo.DummyDocument;
import org.sanju.ml.document.services.DocumentService;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.marklogic.client.document.JSONDocumentManager;
import com.marklogic.client.io.DocumentMetadataHandle;
import com.marklogic.client.io.JacksonHandle;

/**
 *
 * @author Sanju Thomas
 *
 */
public class JSONDocumentWithMetadataService extends DocumentService{

	/**
	 *
	 * @param dummyDocument
	 */
	public void save(final DummyDocument dummyDocument, final Properties properties){

		final DocumentMetadataHandle metadataHandle = new DocumentMetadataHandle();
		final Enumeration<Object> keys = properties.keys();
		while(keys.hasMoreElements()){
			final Object nextElement = keys.nextElement();
			metadataHandle.getProperties().put(nextElement.toString(), properties.get(nextElement));
		}
		final JSONDocumentManager documentManager = super.createDocumentManager();
		final JsonNode jsonNode = mapper.convertValue(dummyDocument, JsonNode.class);
		documentManager.write(super.generateURI(dummyDocument), metadataHandle, new JacksonHandle(jsonNode));
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> readProperties(final DummyDocument dummyDocument){

		final JSONDocumentManager documentManager = this.createDocumentManager();
		final JacksonHandle jsonHandle = new JacksonHandle();
		documentManager.readMetadata(super.generateURI(dummyDocument), jsonHandle).get();
		final ObjectMapper mapper = new ObjectMapper();
		final JsonNode jsonNode = jsonHandle.get().get("properties");
		if (null != jsonNode) {
			return mapper.convertValue(jsonNode, Map.class);
		}
		return new HashMap<String, Object>();
	}

}
