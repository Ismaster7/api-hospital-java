package med.api.api.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.api.api.entities.Medico;
import med.api.api.domain.medico.DadosAtualizacaoMedico;
import med.api.api.domain.medico.DadosCadastroMedico;
import med.api.api.domain.medico.DadosListagemMedico;
import med.api.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMedico dados){

        var medico = medicoRepository.save(new Medico(dados));
        return ResponseEntity.ok().body(medico);
    }

    @GetMapping
    public Page<DadosListagemMedico> getAllMedicos(@PageableDefault(size = 3, page=2) Pageable pageable){
        return medicoRepository.findAll(pageable).map(DadosListagemMedico::new);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados, UriComponentsBuilder uriComponentsBuilder){
        var medico = medicoRepository.getReferenceById(dados.id());
        medico.atualizarMedico(dados);
        var uri = uriComponentsBuilder.path("/medicos/{id}").queryParam("id", dados.id()).build().toUri();
       return ResponseEntity.created(uri).body(new DadosAtualizacaoMedico(medico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void remove(@PathVariable Long id){
        var medico = medicoRepository.getReferenceById(id);
        medico.setActiveStatus(false);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id){
        var medico = medicoRepository.getReferenceById(id);
        return ResponseEntity.ok().body(new DadosAtualizacaoMedico(medico));
    }


}
