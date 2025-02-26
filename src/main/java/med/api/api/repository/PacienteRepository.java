package med.api.api.repository;

import med.api.api.entities.Pacientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Pacientes, Long> {

}
