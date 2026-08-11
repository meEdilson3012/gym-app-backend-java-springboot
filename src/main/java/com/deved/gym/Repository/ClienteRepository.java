package com.deved.gym.Repository;

import com.deved.gym.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {

    Optional<Cliente> findByNumero(String numero);
    Optional<Cliente> findByCodigo(String codigo);
    Optional<Cliente> findByNome(String nome);

    @Query("select count(c) from Cliente c")
    Integer totalClientes();

}
