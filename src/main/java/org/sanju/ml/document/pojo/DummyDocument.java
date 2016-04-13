package org.sanju.ml.document.pojo;

/**
 *
 * @author Sanju Thomas
 *
 */
public class DummyDocument {

	public DummyDocument(final int id, final String name){
		this.id = id;
		this.name = name;
	}

	private int id;
	private String name;

	public int getId() {
		return this.id;
	}
	public void setId(final int id) {
		this.id = id;
	}
	public String getName() {
		return this.name;
	}
	public void setName(final String name) {
		this.name = name;
	}

}
