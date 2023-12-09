package ver1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestReflection {
    public static void main(String[] args) {
        TestModelForRef testModelForRef = new TestModelForRef(1, 2, "삼", "사");
        Class<? extends TestModelForRef> clazz = testModelForRef.getClass();
        Method[] methods = clazz.getDeclaredMethods();

        Arrays.stream(methods).filter(m -> m.getName().contains("get")).forEach(m -> {
            try {
                System.out.println(m.invoke(testModelForRef));
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
