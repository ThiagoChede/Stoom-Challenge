package com.stoom.challenge.exception;

public class EnderecoJaEncontradoException extends javax.persistence.NonUniqueResultException {
  public EnderecoJaEncontradoException() {
    super("endereco já existe!");
  }
  public EnderecoJaEncontradoException(String msg) {
    super(msg);
  }
}
