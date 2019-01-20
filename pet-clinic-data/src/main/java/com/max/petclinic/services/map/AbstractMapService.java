package com.max.petclinic.services.map;

import com.max.petclinic.model.BaseEntity;

import java.util.*;

public class AbstractMapService<T extends BaseEntity, ID extends Long> {

    private Map<Long, T> map = new HashMap<>();

    Set<T> findAll(){
        return new HashSet(map.values());
    }

    T findById(ID id){
        return map.get(id);
    }

    void deleteById(ID id){
        map.remove(id);
    }

    void delete(T object){
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    T save(T object){
        if (object == null) {
            throw new IllegalArgumentException("object can not be null");
        }

        if (object.getId() == null) {
            object.setId(getNextId());
        }

        map.put(object.getId(), object);
        return object;
    }

    private Long getNextId() {
        if (map.isEmpty()) {
            return 1L;
        }

        return Collections.max(map.keySet()) + 1;
    }
}
