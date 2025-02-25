package ies.castillodeluna.psp.jpa.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ies.castillodeluna.psp.jpa.entities.Person;

public interface PersonRepository extends CrudRepository<Person,Long>{
    
    List<Person> findByProgrammingLanguage(String programmingLanguage);

    @Query("select p from Person p where p.programmingLanguage = ?1 and p.name = ?2")
    List<Person> buscarPorProgramacionNombre(String programmingLanguage , String name);

    List<Person> findByProgrammingLanguageAndName(String programmingLanguage , String name);

    @Query("select p.name, p.programmingLanguage from Person p")
    List<Object[]> obtenerPersonData();

    @Query("select p.name , p.programmingLanguage from Person p where p.programmingLanguage = ?1 and p.name = ?2")
    List<Object[]> obtenerPersonData(String programmingLanguage , String name);

    @Query("select p from Person p where p.id = ?1")
    Optional<Person> findOne(Long id);

    @Query("select p from Person p where p.name = ?1")
    Optional<Person> findOneName(String name);

    @Query("select p from Person p where p.name like %?1%")
    Optional<Person> findOneLikeName(String name);

    Optional<Person> findOneByNameContaining(String name);

}
