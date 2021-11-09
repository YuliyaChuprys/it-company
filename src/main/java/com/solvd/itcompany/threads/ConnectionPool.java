package com.solvd.itcompany.threads;


import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.IntStream;

public class ConnectionPool {

    private final Queue<Connection> connections;
    private final int size;

    private ConnectionPool(int sizeOfPool) {
        this.size = sizeOfPool;
        this.connections = new ConcurrentLinkedQueue<>();
        IntStream.range(0, this.size).boxed()
                .forEach(index -> {
                    this.connections.offer(new Connection(getConnection().getName()));
                });
    }

    private static ConnectionPool instance = null;

    public static ConnectionPool getInstance(int sizeOfPool) {
            synchronized (ConnectionPool.class) {
                if (instance == null) {
                    instance = new ConnectionPool(sizeOfPool);
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
