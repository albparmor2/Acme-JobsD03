
package acme.features.administrator.costumisation;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.costumisations.Costumisation;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractListService;

@Service
public class AdministratorCostumisationListService implements AbstractListService<Administrator, Costumisation> {

	@Autowired
	AdministratorCostumisationRepository repository;


	@Override
	public boolean authorise(final Request<Costumisation> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Costumisation> request, final Costumisation entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "spamWord", "threshold");
	}

	@Override
	public Collection<Costumisation> findMany(final Request<Costumisation> request) {
		assert request != null;

		Collection<Costumisation> result;

		result = this.repository.findManyAll();

		return result;
	}

}
