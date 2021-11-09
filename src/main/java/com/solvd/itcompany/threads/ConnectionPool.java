package com.solvd.itcompany.threads;


import java.util.LinkedList;
import java.util.stream.IntStream;

public class ConnectionPool {

    private final LinkedList<Connection> connections;
    private static volatile ConnectionPool instance;


    private ConnectionPool(int sizeOfPool) {
        this.connections = new LinkedList<>();
        for(int i =0; i<sizeOfPool; i++){
            this.connections.add(new Connection(i));
        }
    }

    public static ConnectionPool getInstance(int sizeOfPool) {
        if (instance == null) {
            synchronized (ConnectionPool.class) {
                if (instance == null) {
                    instance = new ConnectionPool(sizeOfPool);
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        synchronized (this.connections) {
            while (this.connections.isEmpty()) {
                try {
                    connections.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return this.connections.poll();
        }
    }

    public void releaseConnection(Connection task) {
        synchronized (this.connections) {
            this.connections.offer(task);
            this.connections.notify();
        }
    }

}
