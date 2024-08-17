package nuclearSubmarine;

public class AtomicSubmarine {
    private String name;
    private EngineAtomicSub engine;

    public AtomicSubmarine(String name) {
        this.name = name;
        this.engine = new EngineAtomicSub();
    }

    public String getName() {
        return name;
    }

    public void setEngine(EngineAtomicSub engine) {
        this.engine = engine;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void startSailing() {
        System.out.println(name + " start sailing...");
        engine.start();
    }

    static class EngineAtomicSub {
        public void start() {
            System.out.println("Nuclear submarine engine started.");
        }
    }

}


