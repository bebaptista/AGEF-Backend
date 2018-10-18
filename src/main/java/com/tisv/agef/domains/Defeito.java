package com.tisv.agef.domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@EqualsAndHashCode
@NoArgsConstructor
@RequiredArgsConstructor
public class Defeito implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(hidden = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Getter private int id;

    @ApiModelProperty(value = "Quantidade de peças vendidas.", example = "2", required = true)
    @NonNull @NotNull(message = "É obrigatório o preenchimento da quantidade vendida.")
    @Positive(message = "O campo 'quantidade' deve conter um valor maior do que zero.")
    @Getter @Setter private Integer quantidade;

    @ApiModelProperty(value = "Data da venda.", example = "10-10-2018", required = true)
    @JsonFormat(pattern = "dd-MM-yyyy")
    @NonNull @NotNull(message = "É obrigatório o preenchimento da data da venda.")
    @PastOrPresent(message = "O campo 'data' deve conter uma data válida.")
    @Getter @Setter private LocalDate data;

    @ApiModelProperty(value = "Nome do modelo referente a peça vendida.", example = "Calça", required = true)
    @NonNull @NotBlank(message = "É obrigatório o preenchimento do nome.")
    @Getter @Setter private String nome;

    @ApiModelProperty(value = "Tamanho do modelo referente a peça vendida.", example = "40", required = true)
    @NonNull @NotBlank(message = "É obrigatório o preenchimento do tamanho.")
    @Getter @Setter private String tamanho;
}