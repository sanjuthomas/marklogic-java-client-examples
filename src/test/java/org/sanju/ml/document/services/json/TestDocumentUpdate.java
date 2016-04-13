package org.sanju.ml.document.services.json;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.sanju.ml.document.pojo.DummyDocument;

/**
 *
 * @author Sanju Thomas
 *
 */
public class TestDocumentUpdate {

	private JSONDocumentService documentService;

	@Before
	public void setUp(){
		this.documentService = new JSONDocumentService();
	}

	@Test
	public void shouldSave(){
		final DummyDocument dummyDocument = new DummyDocument(1000, "Test Document from Save Test");
		this.documentService.save(dummyDocument);
		final DummyDocument dummyDocumentFromDB = this.documentService.find(new DummyDocument(1000));
		assertEquals(1000, dummyDocumentFromDB.getId());
		assertEquals("Test Document from Save Test", dummyDocumentFromDB.getName());
	}
}
