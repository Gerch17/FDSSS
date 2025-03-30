package ru.tbank.fdsspring.model;

import lombok.Builder;
import lombok.Data;
import ru.tbank.fdsspring.entity.Client;

import java.util.List;

@Data
@Builder
public class ClientsPage {

    private int pageAmount;

    private int pageSize;

    private int pageNumber;

    private List<Client> clients;

}
