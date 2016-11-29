package org.sanju.ml.client.odm;

import org.sanju.ml.client.ClientProvider;
import org.sanju.ml.client.odm.pojo.QuoteRequest;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.pojo.PojoRepository;

/**
 *
 * @author Sanju Thomas
 *
 */
public class QuoteRepositoryImpl implements QuoteRepository{

	@Override
	public void save(final QuoteRequest quoteRequest) {

		final DatabaseClient client = ClientProvider.getClient();
		final PojoRepository<QuoteRequest, String> repository = client.newPojoRepository(QuoteRequest.class, String.class);
		repository.write(quoteRequest);
	}

	@Override
	public QuoteRequest find(final String id) {

		final DatabaseClient client = ClientProvider.getClient();
		final PojoRepository<QuoteRequest, String> repository = client.newPojoRepository(QuoteRequest.class, String.class);
		return repository.read(id);
	}

}
