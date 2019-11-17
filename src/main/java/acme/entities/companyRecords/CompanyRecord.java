
package acme.entities.companyRecords;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.URL;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CompanyRecord extends DomainEntity {

	private final static long	serialVersionUID	= 1L;

	@NotBlank
	private String				name;

	@NotBlank
	private String				sector;

	@NotBlank
	private String				CEO;

	@NotBlank
	private String				activities;

	@URL
	private String				website;

	@NotBlank
	@Pattern(regexp = "^\\+\\d{1,3}\\ \\(\\d{1,4}\\)\\ \\d{6,10}$",
		message = "Phone number must adhere to the following pattern: ''+999 (9999) 999999'', where ''+999'' denotes an optional international prefix in range ''+1'' up to ''+999'', ''(9999)'' denotes an optional area code in range ''(0)'' up to ''(9999)'', and ''999999'' denotes a local phone number with a minimum of six digits and a maximum of ten digits")
	private String				contactPhone;

	@NotBlank
	@Email
	private String				contactEmail;

	@Min(value = 0)
	@Max(value = 5)
	private Integer				stars;


	public String getIncorporated() {
		String res = "Indeterminate";
		Integer x = this.name.length();
		String s = this.name.substring(x - 4, x);
		String s2 = this.name.substring(x - 3, x);
		if (s.equals("Inc.")) {
			res = "Yes";
		} else if (s2.equals("LLC")) {
			res = "No";
		}
		return res;
	}

}
