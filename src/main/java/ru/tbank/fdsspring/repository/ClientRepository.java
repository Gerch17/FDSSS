package ru.tbank.fdsspring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.tbank.fdsspring.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.stream.Stream;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query(value = """
        SELECT * FROM client
        LIMIT :limit
        OFFSET :offset
    """, nativeQuery = true)
    List<Client> findClientsPage(int limit, int offset);

    @Query(value = """
        SELECT * FROM client;
    """, nativeQuery = true)
    Stream<Client> findAllClients();

    @Query("""
        SELECT c FROM Client c WHERE c.name = :name
    """)
    List<Client> findClientsByName(String name);

}
