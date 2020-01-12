package com.stoom.challenge.service;

import com.stoom.challenge.util.ApiGeocodingResponses;
import com.stoom.challenge.util.BeansUtil;
import com.stoom.challenge.exception.EnderecoNaoEncontradoException;
import com.stoom.challenge.model.Endereco;
import com.stoom.challenge.repository.EnderecoRepository;
import com.stoom.challenge.util.GeocodingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Slf4j
@Service
public class EnderecoService {

  @Autowired
  private EnderecoRepository enderecoRepository;

  @Autowired
  private GeocodingService geocodingService;


  public Endereco buscaPorId(Long idEndereco) {

    return this.enderecoRepository.findById(idEndereco).orElseThrow(EnderecoNaoEncontradoException::new);
  }

  @Transactional
  public Endereco cadastra(Endereco endereco) {

    log.info("Cadastro de Endereço: " + endereco);

    if((endereco.getLatitude() == null) && (endereco.getLongitude() == null)){
      endereco  = this.addCoordinate(endereco);
    }
    return enderecoRepository.save(endereco);

  }


  public Endereco addCoordinate(Endereco endereco) {
    ApiGeocodingResponses api = geocodingService.apiConsumer(endereco);
    if(api != null) {
      endereco.setLatitude(api.getResults().get(0).getGeometry().getLocation().getLat());
      endereco.setLongitude(api.getResults().get(0).getGeometry().getLocation().getLng());
      return endereco;
    }
    return endereco;
  }

  public Endereco updateParcialEndereco(Endereco endereco,Long id) {

    Endereco enderecoBanco = this.buscaPorId(id);

    BeansUtil<Endereco> bean = new BeansUtil<>();

    Endereco cervejaNova = bean.copyNonNullProperties(endereco, enderecoBanco);

    return this.save(cervejaNova);
  }
  public Endereco save(Endereco endereco) {
    return this.enderecoRepository.save(endereco);
  }


  public void deletaEndereco(Endereco endereco) {
    enderecoRepository.delete(endereco);
  }
}
