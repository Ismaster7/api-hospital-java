package med.api.api.medico;

import med.api.api.entities.Medico;

public record DadosListagemMedico(Long id, String nome, String email, String telefone, String crm) {
    public DadosListagemMedico (Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getTelefone(), medico.getCrm());
    }
}
