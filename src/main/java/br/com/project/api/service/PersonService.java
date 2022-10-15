package br.com.project.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.project.api.model.Message;
import br.com.project.api.model.Person;
import br.com.project.api.repositories.PersonRepository;

@Service
public class PersonService {

  @Autowired
  private Message message;

  @Autowired
  private PersonRepository action;

  public ResponseEntity<?> register(Person obj) {
    if (obj.getName().equals("")) {
      message.setMessage("O nome precisa ser preenchido");
      return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
    if (obj.getAge() < 0) {
      message.setMessage("Informe uma idade válida");
      return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    return new ResponseEntity<>(action.save(obj), HttpStatus.CREATED);
  }

  // metodo para selecionar pessoas
  public ResponseEntity<?> select() {
    return new ResponseEntity<>(action.findAll(), HttpStatus.OK);
  }

  // metodo para selecionar pessoas pelo codigo
  public ResponseEntity<?> selectByCode(int code) {
    if (action.countByCode(code) == 0) {
      message.setMessage("Não foi encontrada nenhuma pessoa");
      return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(action.findByCode(code), HttpStatus.OK);
  }

  // metodo para editar dados
  public ResponseEntity<?> edit(Person obj) {
    if (action.countByCode(obj.getCode()) == 0) {
      message.setMessage("O código informado não existe");
      return new ResponseEntity<>(message.getMessage(), HttpStatus.BAD_REQUEST);
    }
    if (obj.getName().equals("") || obj.getAge() < 0) {
      message.setMessage("O nome informado não existe ou idade não pode ser inserida");
      return new ResponseEntity<>(message.getMessage(), HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(action.save(obj), HttpStatus.OK);
  }

  // metodo para remover registros

  public ResponseEntity<?> remove(int code) {
    if (action.countByCode(code) == 0) {
      message.setMessage("O código informado não existe");
      return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    Person obj = action.findByCode(code);
    action.delete(obj);
    message.setMessage("Pessoa removida com sucesso");
    return new ResponseEntity<>(message, HttpStatus.OK);
  }

}
