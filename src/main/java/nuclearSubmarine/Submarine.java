package nuclearSubmarine;

import java.lang.annotation.*;

public @interface Submarine {
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)

    @interface SubmarineInfo {
        String description();
        int weight();
    }
}
