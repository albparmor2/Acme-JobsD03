
package acme.features.provider.requesta;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.requestas.Requesta;
import acme.entities.roles.Provider;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractListService;

@Service
public class ProviderRequestaListService implements AbstractListService<Provider, Requesta> {

	@Autowired
	ProviderRequestaRepository repository;


	@Override
	public boolean authorise(final Request<Requesta> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Requesta> request, final Requesta entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "moment", "title", "deadline", "reward");
	}

	@Override
	public Collection<Requesta> findMany(final Request<Requesta> request) {
		assert request != null;

		Collection<Requesta> result;

		result = this.repository.findManyAll();

		return result;
	}

}
