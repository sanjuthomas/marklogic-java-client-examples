package org.sanju.ml.document.services.json;

import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.sanju.ml.document.pojo.DummyDocument;

/**
 *
 * @author Sanju Thomas
 *
 */
public class TestDocumentDelete {

	private JSONDocumentService documentService;

	@Before
	public void setUp(){
		this.documentService = new JSONDocumentService();
		final DummyDocument dummyDocument = new DummyDocument(1002, "Test Document from Delete Test");
		this.documentService.save(dummyDocument);
	}

	@Test
	public void shouldDelete(){
		final DummyDocument dummyDocument = new DummyDocument(1002);
		this.documentService.delete(dummyDocument);
		assertNull(this.documentService.find(dummyDocument));
	}

}
