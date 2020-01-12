package com.stoom.challenge.controller;


import com.stoom.challenge.service.EnderecoService;
import com.stoom.challenge.model.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RequestMapping("/location")
@RestController
public class EnderecoController {

  private EnderecoService enderecoService;

  @Autowired
  private EnderecoController(EnderecoService enderecoService){
    this.enderecoService = enderecoService;
  }


  @GetMapping("{id}")
  @ResponseBody
  @ResponseStatus(code = HttpStatus.OK)
  public Endereco buscaPorId(@PathVariable("id") Long id) {
    return this.enderecoService.buscaPorId(id);
  }

  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  public Endereco cadastraEndereco(@Valid @RequestBody Endereco endereco) {
    return this.enderecoService.cadastra(endereco);
  }


  @PatchMapping("{id}")
  @ResponseBody
  @ResponseStatus(code = HttpStatus.OK)
  public Endereco alteraEndereco(@RequestBody Endereco endereco, @PathVariable("id") Long id){

    return this.enderecoService.updateParcialEndereco(endereco,id);
  }

  @DeleteMapping("{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deletaEndereco(Endereco endereco){
    this.enderecoService.deletaEndereco(endereco);

  }

}
