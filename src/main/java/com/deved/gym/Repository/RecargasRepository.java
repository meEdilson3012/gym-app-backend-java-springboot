package com.deved.gym.Repository;

import com.deved.gym.Model.Passe;
import com.deved.gym.Model.Recargas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface RecargasRepository extends JpaRepository<Recargas,Long> {

    @Query("SELECT p FROM Recargas p WHERE p.cliente.codigo=:codigo")
    List<Recargas> clienterecarga(@Param("codigo") String codigo);

    @Query("select count(r) from Recargas r")
    Integer totalRecargas();

    @Query("select count(r) from Recargas r where r.data=:data")
    Integer totalRecargas(@Param("data")LocalDate data);
}
