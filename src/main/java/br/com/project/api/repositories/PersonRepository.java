package br.com.project.api.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.project.api.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

  List<Person> findAll();

  Person findByCode(int code);
}
