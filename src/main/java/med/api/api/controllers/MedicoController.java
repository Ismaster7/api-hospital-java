package med.api.api.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.api.api.entities.Medico;
import med.api.api.medico.DadosAtualizacaoMedico;
import med.api.api.medico.DadosCadastroMedico;
import med.api.api.medico.DadosListagemMedico;
import med.api.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){

        medicoRepository.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedico> getAllMedicos(@PageableDefault(size = 3, page=2) Pageable pageable){
        return medicoRepository.findAll(pageable).map(DadosListagemMedico::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados){
        var medico = medicoRepository.getReferenceById(dados.id());
        medico.atualizarMedico(dados);


    }

    @DeleteMapping("/{id}")
    @Transactional
    public void remove(@PathVariable Long id){
        var medico = medicoRepository.getReferenceById(id);
        medico.setActive_status(false);
    }
}
