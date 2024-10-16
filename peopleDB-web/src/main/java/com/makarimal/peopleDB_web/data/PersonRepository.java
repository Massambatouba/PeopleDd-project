package com.makarimal.peopleDB_web.data;

import com.makarimal.peopleDB_web.biz.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
}
