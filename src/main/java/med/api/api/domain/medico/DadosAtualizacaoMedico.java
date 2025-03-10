package med.api.api.domain.medico;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import med.api.api.entities.Endereco;
import med.api.api.entities.Medico;

public record DadosAtualizacaoMedico(
        @NotNull
        Long id,

        String nome,

        String email,

        String telefone,
        @Size(min = 4, max = 6)
        String crm,

        Especialidade especialidade,

        Endereco endereco
) {
        public DadosAtualizacaoMedico (Medico medico){
                this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getTelefone(), medico.getCrm(), medico.getEspecialidade(), medico.getEndereco());
        }

}
