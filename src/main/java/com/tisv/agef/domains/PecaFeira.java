package com.tisv.agef.domains;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;

@Entity
@EqualsAndHashCode(exclude = {"id", "deletado", "preco", "quantidade"})
@NoArgsConstructor
@SQLDelete(sql = "UPDATE PECA_FEIRA SET deletado = true WHERE id = ?")
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"MODELO_ID"})})
@ToString
public class PecaFeira implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(hidden = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Getter private int id;

    @ApiModelProperty(hidden = true)
    @Getter @Setter private Boolean deletado = false;

    @ApiModelProperty(value = "Preço da peça no estoque da feira.", example = "45.50", allowableValues = "range[0.01, infinity]", required = true)
    @NotNull(message = "É obrigatório o preenchimento do preço.")
    @Positive(message = "O campo 'preço' deve conter um valor maior do que zero.")
    @Getter @Setter private Double preco;

    @ApiModelProperty(value = "Quantidade de peças no estoque da feira.", example = "25", allowableValues = "range[0, infinity]", required = true)
    @NotNull(message = "É obrigatório o preenchimento da quantidade de peças.")
    @PositiveOrZero(message = "O campo 'quantidade' deve conter um valor maior ou igual à zero.")
    @Getter @Setter private Integer quantidade;

    @ApiModelProperty(value = "Id do modelo correspondente a peça.", example = "1", required = true)
    @NotNull(message = "É obrigatório o preenchimento do modelo.")
    @OneToOne
    @Getter @Setter private Modelo modelo;

    public PecaFeira(Double preco, Integer quantidade, Modelo modelo) {
        this.deletado = false;
        this.preco = preco;
        this.quantidade = quantidade;
        this.modelo = modelo;
    }
}