package com.deved.gym.Repository;


import com.deved.gym.Model.Passe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PasseRepository extends JpaRepository<Passe,Long> {

    @Query("SELECT p FROM Passe p WHERE p.cliente.codigo=:codigo and p.estado=true ")
    Optional<Passe> clientePasse(@Param("codigo") String codigo);

}
