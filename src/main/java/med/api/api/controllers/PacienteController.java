package med.api.api.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.api.api.entities.Pacientes;
import med.api.api.medico.DadosAtualizacaoPaciente;
import med.api.api.medico.DadosCadastroPaciente;
import med.api.api.medico.DadosListagemPaciente;
import med.api.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    PacienteRepository pacienteRepository;
    @Transactional
    @PostMapping
    public void postPacientes( @RequestBody @Valid DadosCadastroPaciente paciente){
        pacienteRepository.save(new Pacientes(paciente));
        ;
    }
    @GetMapping
    public Page<DadosListagemPaciente> getPacientes(Pageable pageable)
    {
        return pacienteRepository.findAll(pageable).map(DadosListagemPaciente::new);
    }

    @GetMapping("/{id}")
    public Optional<Pacientes> getById(@PathVariable(value="id") Long id) {
        var nullo =  Optional.ofNullable(pacienteRepository.findById(id)); ;
        return nullo.get();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteById(@PathVariable(value="id") Long id) {
        var paciente = pacienteRepository.getReferenceById(id);
        paciente.setActive_status(false);
    }

    @PutMapping
    @Transactional
    public void updatePaciente(@RequestBody @Valid DadosAtualizacaoPaciente paciente){
        var pacienteAtua = pacienteRepository.getReferenceById(paciente.id());
        pacienteAtua.atualizarPaciente(paciente);

    }

}
