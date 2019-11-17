
package acme.features.provider.requesta;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.requestas.Requesta;
import acme.entities.roles.Provider;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.datatypes.Money;
import acme.framework.services.AbstractCreateService;

@Service
public class ProviderRequestaCreateService implements AbstractCreateService<Provider, Requesta> {

	@Autowired
	ProviderRequestaRepository repository;


	@Override
	public boolean authorise(final Request<Requesta> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Requesta> request, final Requesta entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "moment");

	}

	@Override
	public void unbind(final Request<Requesta> request, final Requesta entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "ticker", "title", "description", "deadline", "reward");
	}

	@Override
	public Requesta instantiate(final Request<Requesta> request) {
		Requesta result;

		result = new Requesta();

		return result;
	}

	@Override
	public void validate(final Request<Requesta> request, final Requesta entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		Requesta r = null;

		r = this.repository.existRequesta(entity.getTicker());
		errors.state(request, r == null, "ticker", "provider.requesta.form.error.existRequest");

		Boolean confirm = request.getModel().getBoolean("confirmRequesta");
		errors.state(request, confirm, "confirmRequesta", "acme.error.confirm");

		Money reward = entity.getReward();
		if (!errors.hasErrors("reward")) {
			errors.state(request, reward.getAmount() > 0, "reward", "acme.money.error.positive");
			errors.state(request, reward.getCurrency().equals("€"), "reward", "acme.money.error.currency");
		}
	}

	@Override
	public void create(final Request<Requesta> request, final Requesta entity) {
		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		this.repository.save(entity);
	}

}
