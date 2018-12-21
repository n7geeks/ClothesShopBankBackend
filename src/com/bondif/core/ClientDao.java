package com.bondif.core;

import com.bondif.models.Client;
import com.bondif.models.Compte;

import java.util.HashMap;
import java.util.Map;

public class ClientDao {
    private Map<Integer, Client> clients = new HashMap<>();

    public ClientDao() {
        Compte c1 = new Compte(1, 1000, null);
        Compte c2 = new Compte(2, 2000, null);
        Compte c3 = new Compte(3, 3000, null);

        clients.put(10, new Client(10, "BOUKHLIF", c1));
        clients.put(20, new Client(20, "KHALID", c2));
        clients.put(30, new Client(30, "WALID", c3));
    }

    public Map<Integer, Client> getClients() {
        return clients;
    }
}
