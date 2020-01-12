package com.stoom.challenge.exception;

public class EnderecoNaoEncontradoException extends RuntimeException{


  public EnderecoNaoEncontradoException() {
    super("endereço não encontrado!");
  }
  public EnderecoNaoEncontradoException(String msg) {
    super(msg);
  }
}
