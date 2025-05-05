package com.hospital_vm.cl.hospital_vm.repository;
import com.hospital_vm.cl.hospital_vm.model.Paciente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long>{

    @Query(value = "SELECT * FROM Paciente ", nativeQuery = true)
    List<Paciente> findAll();

    @Query("SELECT p FROM Paciente p WHERE p.apellidos= :apellido")
    List<Paciente> findByApellidos(@Param("apellidos") String apellidos);

    @Query(value = "SELECT * FROM Paciente  WHERE correo= :correo", nativeQuery = true)
    Paciente findByCorreo(String correo);

    @Query(value = "SELECT * FROM Paciente  WHERE nombres= :nombres AND apellidos= :apellidos", nativeQuery = true)
    List<Paciente> findByNombresAndApellidos(String nombres, String apellidos);

    @Query(value = "DELETE FROM Paciente  WHERE id= :id", nativeQuery = true)
    void deleteById(Long id);
}
