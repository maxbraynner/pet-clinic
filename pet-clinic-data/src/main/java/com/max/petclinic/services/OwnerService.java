package com.max.petclinic.services;

import com.max.petclinic.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner, Long>{

    List<Owner> findByLastName(String lastName);

}
