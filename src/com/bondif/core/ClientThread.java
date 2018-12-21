package com.bondif.core;

import com.bondif.models.Client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket clientSocket;
    private InputStream inputStream;
    private OutputStream outputStream;
    private ClientDao clientDao;

    public ClientThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
        this.clientDao = new ClientDao();

        try {
            this.outputStream = this.clientSocket.getOutputStream();
            this.inputStream = this.clientSocket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        start();
    }


    public void sendInfosCompte() {
        try {
            int clientId = inputStream.read();
            System.out.println("Client id : " + clientId);
            Client client = clientDao.getClients().get(clientId);
            System.out.println("Compte : " + client.getCompte());
            ObjectOutputStream objectOs = new ObjectOutputStream(outputStream);
            objectOs.writeObject(client.getCompte());
            objectOs.flush();
            objectOs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.println("client 1");
        sendInfosCompte();
    }
}
