package br.com.project.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.project.api.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

  List<Person> findAll();

  Person findByCode(int code);

  List<Person> findByOrderByName();

  List<Person> findByNameOrderByAge(String name);

  List<Person> findByNameContaining(String word);

  List<Person> findByNameStartsWith(String word);

  List<Person> findByNameEndsWith(String word);

  @Query(value = "SELECT SUM(age) FROM persons", nativeQuery = true)
  int sumAge();

  @Query(value = "SELECT * FROM persons WHERE age >= :age", nativeQuery = true)
  List<Person> ageGreaterOrEqual(int age);

  int countByCode(int code);

}
