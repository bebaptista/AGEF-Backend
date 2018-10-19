package com.tisv.agef.domains;

import com.fasterxml.jackson.annotation.JsonView;
import com.tisv.agef.jsonview.DefeitoView;
import com.tisv.agef.jsonview.ModeloView;
import com.tisv.agef.jsonview.PecaFeiraView;
import com.tisv.agef.jsonview.VendaView;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@EqualsAndHashCode(exclude = {"id", "deletado", "pecaFeira"})
@SQLDelete(sql = "UPDATE MODELO SET deletado = true WHERE id = ?")
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"NOME", "TAMANHO"})})
@ToString(exclude = "pecaFeira")
public class Modelo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(hidden = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({DefeitoView.Resumo.class, ModeloView.Resumo.class, PecaFeiraView.Resumo.class})
    @Getter @Id private int id;

    @ApiModelProperty(hidden = true)
    @OneToOne(cascade = CascadeType.MERGE, mappedBy = "modelo")
    @Getter PecaFeira pecaFeira;

    @ApiModelProperty(hidden = true)
    @Getter @Setter private Boolean deletado;

    @ApiModelProperty(value = "Nome do modelo.", example = "Camisa Polo", required = true)
    @JsonView({DefeitoView.Resumo.class, ModeloView.Resumo.class, PecaFeiraView.Resumo.class, VendaView.Resumo.class})
    @NotBlank(message = "É obrigatório o preenchimento do nome.")
    @Getter @Setter private String nome;

    @ApiModelProperty(value = "Tamanho do modelo.", example = "P", required = true)
    @JsonView({DefeitoView.Resumo.class, ModeloView.Resumo.class, PecaFeiraView.Resumo.class, VendaView.Resumo.class})
    @NotBlank(message = "É obrigatório o preenchimento do tamanho.")
    @Getter @Setter private String tamanho;

    public Modelo() {
        this.deletado = false;
    }

    public Modelo(String nome, String tamanho) {
        this.deletado = false;
        this.nome = nome;
        this.tamanho = tamanho;
    }
}
