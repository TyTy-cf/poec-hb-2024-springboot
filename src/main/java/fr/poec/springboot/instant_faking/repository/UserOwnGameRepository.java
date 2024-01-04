package fr.poec.springboot.instant_faking.repository;

import fr.poec.springboot.instant_faking.entity.UserOwnGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserOwnGameRepository extends JpaRepository<UserOwnGame, Long> {

}