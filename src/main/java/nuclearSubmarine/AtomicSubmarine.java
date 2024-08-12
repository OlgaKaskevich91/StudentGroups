package nuclearSubmarine;

public class AtomicSubmarine {
    private String name;

    public AtomicSubmarine(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void startSailing(){
        System.out.println(name+ " start sailing...");
        EngineAtomicSub.start();
    }

private static class EngineAtomicSub {
    public static void start() {
        System.out.println("Nuclear submarine engine started.");
    }
}

}
