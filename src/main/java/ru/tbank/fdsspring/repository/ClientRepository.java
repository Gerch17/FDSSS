package ru.tbank.fdsspring.repository;

import org.springframework.stereotype.Repository;
import ru.tbank.fdsspring.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
