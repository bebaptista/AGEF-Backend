package com.tisv.agef.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@EqualsAndHashCode
@NoArgsConstructor
@RequiredArgsConstructor
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"NOME", "TAMANHO"})})
public class Modelo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(hidden = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Getter private int id;

    @ApiModelProperty(value = "Nome do modelo.", example = "Camisa Polo", required = true)
    @NonNull @NotBlank(message = "É obrigatório o preenchimento do nome.")
    @Getter @Setter private String nome;

    @ApiModelProperty(value = "Tamanho do modelo.", example = "P", required = true)
    @NonNull @NotBlank(message = "É obrigatório o preenchimento do tamanho.")
    @Getter @Setter private String tamanho;
}
