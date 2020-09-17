package com.company;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client extends Thread {
    Habitat habitat = null;

    Socket clientSocket = null;
    int port = 8031;
    ObjectInputStream ois = null;
    ObjectOutputStream oos = null;

    boolean isGoing = false;

    Client(Habitat h) throws IOException {
        this.habitat = h;
        clientSocket = new Socket("127.0.0.1", port);
        oos = new ObjectOutputStream(clientSocket.getOutputStream());
        ois = new ObjectInputStream(clientSocket.getInputStream());
        isGoing = true;

        this.start();
        showUsers();
    }


    @Override
    public void run() {
        super.run();
        while (isGoing) {
            try {
                Object obj = ois.readObject();
                if (obj != null) System.out.println((String) obj);
                if (obj.equals("users")) {
                    obj = ois.readObject();
                    String user = (String) obj;
                    obj = ois.readObject();
                    String log = (String) obj;

                    habitat.usersArea.setText(null);
                    habitat.usersArea.append(user);
                    habitat.logArea.append(log);
                } else {
                    if (obj.equals("pass")) {
                        String str = (String) ois.readObject();
                        habitat.logArea.append(str);
                    }
                    else {
                        if (obj.equals("exit")) {
                            ois.close();
                            oos.close();
                            clientSocket.close();
                            isGoing = false;
                        }
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }

    public void showUsers() {
        try {
            oos.writeObject("Show users");
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exit() {
        try {
            oos.writeObject("Exit");
            oos.writeObject(clientSocket.getLocalPort());
        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }

    public void passLvl(int level, int time) {
        try {
            oos.writeObject("Pass");

            oos.writeObject(this.clientSocket.getLocalPort());
            oos.writeObject(level);
            oos.writeObject(time);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}