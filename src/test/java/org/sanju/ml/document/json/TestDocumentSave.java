package org.sanju.ml.document.json;

import org.junit.Before;
import org.junit.Test;
import org.sanju.ml.document.pojo.DummyDocument;

/**
 *
 * @author Sanju Thomas
 *
 */
public class TestDocumentSave {

	private JSONDocumentService documentService;

	@Before
	public void setUp(){
		this.documentService = new JSONDocumentService();
	}

	@Test
	public void shouldSave(){
		final DummyDocument dummyDocument = new DummyDocument(1000, "Test Document from Save Test");
		this.documentService.save(dummyDocument);
	}
}
