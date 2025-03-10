package med.api.api.domain.endereco;

import med.api.api.entities.Endereco;

public record DadosEndereco(String logradouro,
                            String numero,
                            String bairro,
                            String cidade,
                            String estado) {
    public DadosEndereco(Endereco endereco) {
        this(endereco.getLogradouro(), endereco.getNumero(), endereco.getBairro(), endereco.getCidade(), endereco.getEstado());
    }
}
