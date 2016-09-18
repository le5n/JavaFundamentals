package homeworkTwo.TaskFiveAndSeven;

import java.lang.reflect.Field;

 class AnnotationEnrolled {
    void enrolledAnnotation(String className) throws Exception {
        Class<?> clazz = Class.forName(className);
        final Student student = new Student();

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(Enrolled.class)) {
                System.out.println("Check whether this student is enrolled or not");
            }
        }
    }
}
