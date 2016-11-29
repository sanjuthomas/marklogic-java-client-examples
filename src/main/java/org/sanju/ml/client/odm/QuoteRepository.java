package org.sanju.ml.client.odm;

import org.sanju.ml.client.odm.pojo.QuoteRequest;

/**
 *
 * @author Sanju Thomas
 *
 */
public interface QuoteRepository {

	void save(final QuoteRequest quoteRequest);
	QuoteRequest find(final String id);

}
