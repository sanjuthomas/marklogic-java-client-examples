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
public class TestDocumentPatch {

	private JSONDocumentService documentService;


	@Before
	public void setUp(){
		this.documentService = new JSONDocumentService();
		final DummyDocument dummyDocument = new DummyDocument(1003, "Test Document from Patch Test");
		dummyDocument.setAnExtraElement("An extra element");
		this.documentService.save(dummyDocument);
	}

	@Test
	public void shouldPatch(){
		final DummyDocument dummyDocument = new DummyDocument(1003);
		DummyDocument dummyDocumentDB = this.documentService.find(dummyDocument);
		assertEquals(1003, dummyDocumentDB.getId());
		assertEquals("Test Document from Patch Test", dummyDocumentDB.getName());
		assertEquals("An extra element", dummyDocumentDB.getAnExtraElement());

		this.documentService.patch(dummyDocument, "anExtraElement", "new value");

		dummyDocumentDB = this.documentService.find(dummyDocument);
		assertEquals(1003, dummyDocumentDB.getId());
		assertEquals("Test Document from Patch Test", dummyDocumentDB.getName());
		assertEquals("new value", dummyDocumentDB.getAnExtraElement());
	}

}
