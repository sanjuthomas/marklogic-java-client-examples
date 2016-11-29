package org.sanju.ml.client.odm;

import org.junit.Before;
import org.junit.Test;
import org.sanju.ml.client.odm.pojo.Account;
import org.sanju.ml.client.odm.pojo.Client;
import org.sanju.ml.client.odm.pojo.QuoteRequest;

import junit.framework.Assert;

/**
 *
 * @author Sanju Thomas
 *
 */
public class TestQuoteRepository {

	private QuoteRepository quoteRepository;

	@Before
	public void setup(){
		this.quoteRepository = new QuoteRepositoryImpl();
	}

	@Test
	public void shouldSave(){
		final Client client = new Client("C110", new Account("A-100-1100"));
		final QuoteRequest quoteRequest = new QuoteRequest("Q-12-01-2015-123-123", "AAPL", 120, client);
		this.quoteRepository.save(quoteRequest);
	}

	@Test
	public void shouldFind(){
		final QuoteRequest quoteRequest = this.quoteRepository.find("Q-12-01-2015-123-123");
		Assert.assertEquals("Q-12-01-2015-123-123", quoteRequest.getId());
	}

}
