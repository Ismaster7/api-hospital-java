package med.api.api.domain.paciente;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import med.api.api.domain.endereco.DadosEndereco;

public record DadosCadastroPaciente(
        @NotNull
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        Long id,
        @NotBlank
        @Size(min = 2, max = 20)
        String nome,
        @NotBlank
        String cpf,
        @NotBlank
        String telefone,
        @Valid
        DadosEndereco endereco) {
}
