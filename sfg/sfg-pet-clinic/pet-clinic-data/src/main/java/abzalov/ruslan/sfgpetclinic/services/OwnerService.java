package abzalov.ruslan.sfgpetclinic.services;

import abzalov.ruslan.sfgpetclinic.model.Owner;

public interface OwnerService extends BasicService<Owner> {

    Owner findByLastName(String lastName);
}
