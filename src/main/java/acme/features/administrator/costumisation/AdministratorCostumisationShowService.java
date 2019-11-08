
package acme.features.administrator.costumisation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.costumisations.Costumisation;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorCostumisationShowService implements AbstractShowService<Administrator, Costumisation> {

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
	public Costumisation findOne(final Request<Costumisation> request) {
		assert request != null;

		Costumisation result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

}
