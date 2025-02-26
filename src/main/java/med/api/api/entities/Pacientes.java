package med.api.api.entities;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;
import med.api.api.medico.DadosCadastroPaciente;
import med.api.api.medico.DadosAtualizacaoPaciente;

@Entity
@Table(name="pacientes")
@Getter
@Setter
@EqualsAndHashCode(of="id")
@AllArgsConstructor
@NoArgsConstructor
public class Pacientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
    @Embedded
    private Endereco endereco;
    private Boolean active_status;

    public Pacientes(@Valid DadosCadastroPaciente paciente) {
        this.nome = paciente.nome();
        this.cpf = paciente.cpf();
        this.telefone = paciente.telefone();
        this.endereco = new Endereco(paciente.endereco());
        this.active_status = true;
    }

    public void atualizarPaciente(DadosAtualizacaoPaciente paciente){
        if(paciente.nome() != null) setNome(paciente.nome());
        if(paciente.cpf() != null) setCpf(paciente.cpf());
        if(paciente.telefone() != null) setTelefone(paciente.telefone());
        if(paciente.endereco() != null) endereco.atualizarEndereco(paciente.endereco());
    }
}
