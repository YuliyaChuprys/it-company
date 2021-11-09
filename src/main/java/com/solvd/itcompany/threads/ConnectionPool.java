package com.solvd.itcompany.threads;


import java.util.LinkedList;
import java.util.stream.IntStream;

public class ConnectionPool {

    private final LinkedList<Connection> connections;
    private final int size;

    private ConnectionPool(int sizeOfPool) {
        this.size = sizeOfPool;
        this.connections = new LinkedList<>();
        IntStream.range(0, this.size).boxed()
                .forEach(index -> {
                    this.connections.offer(new Connection(getConnection().getName()));
                });
    }

    private static ConnectionPool instance = null;

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
