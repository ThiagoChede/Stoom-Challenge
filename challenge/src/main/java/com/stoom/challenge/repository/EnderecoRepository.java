package com.stoom.challenge.repository;

import com.stoom.challenge.model.Endereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, Long> {

  <T extends Endereco> T save(T endereco);

  Optional<Endereco> findByStreetName(String streetName);

  Optional<Endereco> findByZipcode(String zipcode);

  Optional<Endereco> findById(Long id);
}
