package med.api.api.domain.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import med.api.api.domain.endereco.DadosEndereco;

public record DadosCadastroMedico(
        @NotNull
        Long id,
        @NotNull
        String nome,
        @NotNull
        String email,
        @NotBlank
        String telefone,
        @NotNull
        @Size(min = 4, max = 6)
        String crm,
        @NotNull
        Especialidade especialidade,
        @NotNull
        @Valid
        DadosEndereco endereco) {

}
