// Main.java
package Ex3;

public class Main {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        new Threads(sharedResource, "T1").start();
        new Threads(sharedResource, "T2").start();
    }
}