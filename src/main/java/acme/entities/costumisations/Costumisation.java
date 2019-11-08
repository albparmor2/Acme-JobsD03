
package acme.entities.costumisations;

import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Costumisation extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				spamWord;

	@Min(value = 0)
	@Max(value = 100)
	private Double				threshold;

}
