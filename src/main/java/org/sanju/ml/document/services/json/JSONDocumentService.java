package org.sanju.ml.document.services.json;

import org.sanju.ml.document.pojo.DummyDocument;
import org.sanju.ml.document.services.DocumentService;

import com.fasterxml.jackson.databind.JsonNode;
import com.marklogic.client.document.DocumentMetadataPatchBuilder.PatchHandle;
import com.marklogic.client.document.DocumentPage;
import com.marklogic.client.document.DocumentPatchBuilder;
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

	/**
	 *
	 * @param dummyDocument
	 * @return
	 */
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

	/**
	 *
	 * @param dummyDocument
	 */
	public void delete(final DummyDocument dummyDocument){

		final JSONDocumentManager documentManager = this.createDocumentManager();
		documentManager.delete(super.generateURI(dummyDocument));
	}


	/**
	 * Patch let you update the document with partial content. Just like an SQL update on the specific columns.
	 *
	 * @param dummyDocument
	 */
	public void patch(final DummyDocument dummyDocument, final String key, final String value ){

		final JSONDocumentManager documentManager = this.createDocumentManager();
		final DocumentPatchBuilder newPatchBuilder = documentManager.newPatchBuilder();
		final PatchHandle patchBldr =  newPatchBuilder.replaceValue(key, value).build();
		documentManager.patch(super.generateURI(dummyDocument), patchBldr);
	}

}
