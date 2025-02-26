package med.api.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import med.api.api.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(
        @NotNull
        Long id,

        String nome,

        String email,

        String telefone,
        @Size(min = 4, max = 6)
        String crm,

        Especialidade especialidade,

        DadosEndereco endereco
) {

}
