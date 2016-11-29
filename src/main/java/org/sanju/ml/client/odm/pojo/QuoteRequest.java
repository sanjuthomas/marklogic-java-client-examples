package org.sanju.ml.client.odm.pojo;

import com.marklogic.client.pojo.annotation.Id;

/**
 *
 * @author Sanju Thomas
 *
 */

public class QuoteRequest {

	public QuoteRequest(){}

	public QuoteRequest(final String id, final String symbol, final int quantity, final Client client){
		this.id = id;
		this.symbol = symbol;
		this.quantity = quantity;
		this.client = client;
	}

	private String id;
	private String symbol;
	private int quantity;
	private Client client;


	public Client getClient() {
		return this.client;
	}
	public void setClient(final Client client) {
		this.client = client;
	}
	@Id
	public String getId() {
		return this.id;
	}
	public void setId(final String id) {
		this.id = id;
	}
	public String getSymbol() {
		return this.symbol;
	}
	public void setSymbol(final String symbol) {
		this.symbol = symbol;
	}
	public int getQuantity() {
		return this.quantity;
	}
	public void setQuantity(final int quantity) {
		this.quantity = quantity;
	}

}
