
package acme.features.administrator.costumisation;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.costumisations.Costumisation;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;

@Controller
@RequestMapping("/administrator/costumisation/")
public class AdministratorCostumisationController extends AbstractController<Administrator, Costumisation> {

	@Autowired
	private AdministratorCostumisationListService	listService;

	@Autowired
	private AdministratorCostumisationShowService	showService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}

}
