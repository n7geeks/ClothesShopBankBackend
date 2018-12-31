package com.bondif.clothesshop.core;

import com.bondif.clothesshop.models.Account;

import java.io.*;
import java.net.Socket;

public class ClientThread implements Runnable {
    private Socket clientSocket;
    private InputStream inputStream;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private OutputStream outputStream;
    private AccountDao accountDao;

    public ClientThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
        this.accountDao = new AccountDao();

        try {
            this.outputStream = this.clientSocket.getOutputStream();
            this.inputStream = this.clientSocket.getInputStream();
            this.in = new ObjectInputStream(inputStream);
            this.out = new ObjectOutputStream(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendInfosCompte() {
        try {
            Account receivedAccount = null;
            try {
                receivedAccount = (Account)in.readObject();
            } catch (ClassNotFoundException e) {
                out.writeObject(500);
            }
            Account account = accountDao.find(receivedAccount);
            if (account != null) {
                if(account.getAmount() >= receivedAccount.getAmount()) {
                    accountDao.withdrawal(account, receivedAccount.getAmount());
                    out.writeObject(200);
                } else {
                    out.writeObject(400);
                }
            } else {
                System.out.println("no account 404");
                out.writeObject(404);
            }
        } catch (IOException e) {
            try {
                out.writeObject(500);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        sendInfosCompte();
    }
}
