
package acme.features.administrator.costumisation;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.costumisations.Costumisation;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorCostumisationRepository extends AbstractRepository {

	@Query("select a from Costumisation a where a.id = ?1")
	Costumisation findOneById(int id);

	@Query("select a from Costumisation a")
	Collection<Costumisation> findManyAll();
}
