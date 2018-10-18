package com.tisv.agef.domains;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;

@Entity
@EqualsAndHashCode
@NoArgsConstructor
@RequiredArgsConstructor
public class PecaFeira implements Serializable {

    @ApiModelProperty(hidden = true)
    @Id
    @Getter private int id;

    @ApiModelProperty(value = "Preço da peça no estoque da feira.", example = "45.50", allowableValues = "range[0.01, infinity]", required = true)
    @NonNull @NotNull(message = "É obrigatório o preenchimento do preço.")
    @Positive(message = "O campo 'preço' deve conter um valor maior do que zero.")
    @Getter @Setter private Double preco;

    @ApiModelProperty(value = "Quantidade de peças no estoque da feira.", example = "25", allowableValues = "range[0, infinity]", required = true)
    @NonNull @NotNull(message = "É obrigatório o preenchimento da quantidade de peças.")
    @PositiveOrZero(message = "O campo 'quantidade' deve conter um valor maior ou igual à zero.")
    @Getter @Setter private Integer quantidade;

    @ApiModelProperty(value = "Id do modelo correspondente a peça.", example = "1", required = true)
    @MapsId
    @NonNull @NotNull(message = "É obrigatório o preenchimento do modelo.")
    @OneToOne
    @Getter @Setter private Modelo modelo;
}
