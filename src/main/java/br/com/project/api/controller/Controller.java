package br.com.project.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.project.api.model.Person;
import br.com.project.api.repositories.PersonRepository;

@RestController
public class Controller {

  @Autowired
  private PersonRepository action;

  @PostMapping("/api")
  public Person register(@RequestBody Person obj) {
    return action.save(obj);
  }

  @GetMapping("/api")
  public List<Person> select() {
    return action.findAll();
  }

  @GetMapping("/api/{code}")
  public Person selectByCode(@PathVariable int code) {
    return action.findByCode(code);
  }

  @PutMapping("/api")
  public Person edit(@RequestBody Person obj) {
    return action.save(obj);
  }

  @DeleteMapping("/api/{code}")
  public void remove(@PathVariable int code) {
    Person person = selectByCode(code);
    action.delete(person);
  }
}
