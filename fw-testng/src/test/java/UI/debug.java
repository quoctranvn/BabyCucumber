package UI;

import com.qt.core.config.annotation.PageObject;
import org.reflections.Reflections;

public class debug {

    public static void main(String[] args) {

        System.out.println("Scanning using Reflections:");

        Reflections ref = new Reflections("pages");
        for (Class<?> cl : ref.getTypesAnnotatedWith(PageObject.class)) {
            PageObject findable = cl.getAnnotation(PageObject.class);
            System.out.printf("Found class: %s, with meta name: %s%n",
                    cl.getSimpleName(), findable.toString());
        }
    }

}
