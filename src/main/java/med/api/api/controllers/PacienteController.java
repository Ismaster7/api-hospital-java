package med.api.api.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.api.api.entities.Pacientes;
import med.api.api.medico.DadosAtualizacaoPaciente;
import med.api.api.medico.DadosCadastroPaciente;
import med.api.api.medico.DadosListagemPaciente;
import med.api.api.repository.PacienteRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity postPacientes( @RequestBody @Valid DadosCadastroPaciente paciente){
        pacienteRepository.save(new Pacientes(paciente));
        ResponseEntity.ok().build();
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public  ResponseEntity<Page<DadosListagemPaciente>>  getPacientes(Pageable pageable)
    {
        var page = pacienteRepository.findAll(pageable).map(DadosListagemPaciente::new);
        return ResponseEntity.ok(page);

    }

    @GetMapping("/{id}")
    public Optional<Pacientes> getById(@PathVariable(value="id") Long id) {
        var nullo =  Optional.ofNullable(pacienteRepository.findById(id)); ;
        return nullo.get();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteById(@PathVariable(value="id") Long id) {
        var paciente = pacienteRepository.getReferenceById(id);
        paciente.setActive_status(false);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity updatePaciente(@RequestBody @Valid DadosAtualizacaoPaciente paciente){
        var pacienteAtua = pacienteRepository.getReferenceById(paciente.id());
        pacienteAtua.atualizarPaciente(paciente);
        return ResponseEntity.ok(pacienteAtua);

    }

}
