package nuclearSubmarine;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface SubmarineInfo {
    String description();
    int weight();
}

