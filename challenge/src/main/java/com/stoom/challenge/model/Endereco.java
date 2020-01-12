package com.stoom.challenge.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity(name="endereco")
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class Endereco {

  @Id
  @GeneratedValue
  @Column(name="id")
  private long id;


  @Column(name = "rua")
  @NotNull(message="Nome da rua deve ser preenchida.")
  private String streetName;

  @Column(name = "numero")
  @NotNull(message="Numero deve ser informado.")
  private long number;

  @Column(name = "complemento")
  private String complement;

  @Column(name = "vizinhanca")
  private String neighbourhood;

  @Column(name = "cidade")
  @NotNull(message="Cidade deve ser preenchida.")
  private String city;

  @Column(name = "estado")
  @NotNull(message="O Estado deve ser preenchido.")
  private String state;

  @Column(name = "pais")
  @NotNull(message="O Pais deve ser informado.")
  private String country;

  @Column(name = "codigo_postal")
  @NotNull(message="O Codigo postal deve ser informado.")
  private String zipcode;

  @Column(name="latitude", precision = 10, scale = 8)
  private BigDecimal latitude;

  @Column(name="longitude",precision = 11, scale = 8)
  private BigDecimal longitude;
}
