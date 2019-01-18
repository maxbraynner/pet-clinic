package com.max.petclinic.services;

import com.max.petclinic.model.Owner;

import java.util.List;
import java.util.Set;

public interface OwnerService {

    List<Owner> findByLastName(String lastName);

    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();

}
