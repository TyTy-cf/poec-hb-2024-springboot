package fr.poec.springboot.instant_faking.repository;

import fr.poec.springboot.instant_faking.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    Optional<Country> findBySlug(String slug);

}