package med.api.api.medico;

import med.api.api.entities.Pacientes;

public record DadosListagemPaciente(Long id, String nome, String telefone ) {
    public DadosListagemPaciente (Pacientes paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getTelefone());

        }
    }

