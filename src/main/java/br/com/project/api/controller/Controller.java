package br.com.project.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.project.api.model.Client;
import br.com.project.api.model.Person;
import br.com.project.api.repositories.PersonRepository;
import br.com.project.api.service.PersonService;

@RestController
public class Controller {

  @Autowired
  private PersonRepository action;

  @Autowired
  private PersonService service;

  @PostMapping("/api")
  public ResponseEntity<?> register(@RequestBody Person obj) {
    return service.register(obj);
  }

  @GetMapping("/api")
  public ResponseEntity<?> select() {
    return service.select();
  }

  @GetMapping("/api/{code}")
  public ResponseEntity<?> selectByCode(@PathVariable int code) {
    return service.selectByCode(code);
  }

  @GetMapping("/api/counter")
  public long counter() {
    return action.count();
  }

  @GetMapping("/api/orderNames")
  public List<Person> orderNames() {
    return action.findByOrderByName();
  }

  @GetMapping("/api/orderNames2")
  public List<Person> orderNames2() {
    return action.findByNameOrderByAge("Nicholas");
  }

  @GetMapping("/api/nameContaining")
  public List<Person> nameContaining() {
    return action.findByNameContaining("a");
  }

  @GetMapping("/api/startWith")
  public List<Person> nameStartWith() {
    return action.findByNameStartsWith("m");
  }

  @GetMapping("/api/endsWith")
  public List<Person> nameEndsWith() {
    return action.findByNameEndsWith("s");
  }

  @GetMapping("/api/sumAge")
  public int sumAges() {
    return action.sumAge();
  }

  @GetMapping("/api/age")
  public List<Person> ageGreaterOrEqual() {
    return action.ageGreaterOrEqual(20);
  }

  @GetMapping("/status")
  public ResponseEntity<?> status() {
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @PutMapping("/api")
  public ResponseEntity<?> edit(@RequestBody Person obj) {
    return service.edit(obj);
  }

  @DeleteMapping("/api/{code}")
  public ResponseEntity<?> remove(@PathVariable int code) {
    return service.remove(code);
  }

  @PostMapping("/clients")
  public void client(@Valid @RequestBody Client obj) {
  }
}
