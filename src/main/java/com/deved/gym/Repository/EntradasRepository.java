package com.deved.gym.Repository;


import com.deved.gym.Model.Entradas;
import com.deved.gym.Model.Recargas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EntradasRepository extends JpaRepository<Entradas,Long> {

    @Query("SELECT e FROM Entradas e Where e.cliente.codigo=:codigo and e.data=:data")
    Optional<Entradas> jaEntrou(@Param("codigo") String codigo, @Param("data")LocalDate data);

    @Query("SELECT p FROM Entradas p WHERE p.cliente.codigo=:codigo")
    List<Entradas> clienteEntradas(@Param("codigo") String codigo);

    @Query("select count(r) from Entradas r where r.data=:data")
    Integer totalEntradas(@Param("data")LocalDate data);
}
