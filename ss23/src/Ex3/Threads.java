package Ex3;

public class Threads extends Thread {
    private SharedResource sharedResource;

    public Threads(SharedResource sharedResource, String name) {
        super(name);
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        sharedResource.printAlphabet();
    }
}