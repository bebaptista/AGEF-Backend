package com.tisv.agef.domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import com.tisv.agef.jsonview.DefeitoView;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
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
    @JsonView(DefeitoView.Resumo.class)
    @Getter @Id private int id;

    @ApiModelProperty(value = "Peça vendida na feira.", required = true)
    @JsonView(DefeitoView.Resumo.class)
    @ManyToOne
    @NonNull @NotNull(message = "É obrigatório o preenchimento da peça vendida.")
    @Getter @Setter private PecaFeira pecaFeira;

    @ApiModelProperty(value = "Quantidade de peças vendidas.", example = "2", required = true)
    @JsonView(DefeitoView.Resumo.class)
    @NonNull @NotNull(message = "É obrigatório o preenchimento da quantidade vendida.")
    @Positive(message = "O campo 'quantidade' deve conter um valor maior do que zero.")
    @Getter @Setter private Integer quantidade;

    @ApiModelProperty(value = "Data da venda.", example = "10/10/2018", required = true)
    @JsonFormat(pattern = "dd/MM/yyyy")
    @JsonView(DefeitoView.Resumo.class)
    @NonNull @NotNull(message = "É obrigatório o preenchimento da data da venda.")
    @PastOrPresent(message = "O campo 'data' deve conter uma data válida.")
    @Getter @Setter private LocalDate data;
}