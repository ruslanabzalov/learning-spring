package abzalov.ruslan.sfgpetclinic.services;

import abzalov.ruslan.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
