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
public class TestDocumentFind {

	private JSONDocumentService documentService;

	@Before
	public void setUp(){
		this.documentService = new JSONDocumentService();
		final DummyDocument dummyDocument = new DummyDocument(1001, "Test Document from Find Test");
		this.documentService.save(dummyDocument);
	}
	@Test
	public void shouldFind(){
		final DummyDocument dummyDocument = new DummyDocument(1001);
		final DummyDocument dummyDocumentFromDB = this.documentService.find(dummyDocument);
		assertEquals(1001, dummyDocumentFromDB.getId());
		assertEquals("Test Document from Find Test", dummyDocumentFromDB.getName());
	}
}
