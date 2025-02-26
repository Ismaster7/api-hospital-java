package med.api.api.entities;

import jakarta.persistence.Embeddable;
import lombok.*;
import med.api.api.endereco.DadosEndereco;

@Getter
@Setter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;

    public  Endereco(DadosEndereco endereco) {
        this.logradouro = endereco.logradouro();
        this.numero = endereco.numero();
        this.bairro = endereco.bairro();
        this.cidade = endereco.cidade();
        this.estado = endereco.estado();

    }
    /*public Endereco(){

    }*/
    public void atualizarEndereco(DadosEndereco endereco){
        if(endereco.bairro() != null)setBairro(endereco.bairro());
        if(endereco.estado() != null)setEstado(endereco.estado());
        if(endereco.cidade() != null)setCidade(endereco.cidade());
        if(endereco.logradouro() != null)setLogradouro(endereco.logradouro());
        if(endereco.numero() != null)setNumero(endereco.numero());

    }
}
