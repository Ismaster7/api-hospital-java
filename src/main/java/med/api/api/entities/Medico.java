package med.api.api.entities;

import jakarta.persistence.*;
import lombok.*;
import med.api.api.medico.DadosAtualizacaoMedico;
import med.api.api.medico.DadosCadastroMedico;
import med.api.api.medico.Especialidade;

@Entity
@Table(name = "medico")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @Embedded
    private Endereco endereco;
    private Boolean active_status;

    public Medico(DadosCadastroMedico dados){
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
//        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(  dados.endereco());
        this.active_status = true;

    }

    public void atualizarMedico( DadosAtualizacaoMedico dados) {
        if(dados.nome() != null) setNome(dados.nome());
        if(dados.email() != null) setEmail(dados.email());
        if(dados.crm() != null) setCrm(dados.crm());
        if(dados.telefone() != null) setTelefone(dados.telefone());
        if(dados.especialidade() != null) setEspecialidade(dados.especialidade());
        if(dados.endereco() != null) endereco.atualizarEndereco(dados.endereco());

    }

}
