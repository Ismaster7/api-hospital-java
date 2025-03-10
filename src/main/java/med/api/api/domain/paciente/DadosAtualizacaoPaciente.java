package med.api.api.domain.paciente;

import jakarta.validation.constraints.NotNull;
import med.api.api.domain.endereco.DadosEndereco;

public record DadosAtualizacaoPaciente(
        @NotNull
        Long id,
        String nome,
        String cpf,
        String telefone,
        DadosEndereco endereco) {
}
