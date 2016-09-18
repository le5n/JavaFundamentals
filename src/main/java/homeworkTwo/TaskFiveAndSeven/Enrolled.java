/**
Annotation "@Enrolled" reminds to check if this student is enrolled or not.
 */

package homeworkTwo.TaskFiveAndSeven;

import java.lang.annotation.*;

@Target(value= ElementType.FIELD)
@Retention(value= RetentionPolicy.RUNTIME)
@Documented
 @interface Enrolled {
   // boolean isEnroled() default true;
}
