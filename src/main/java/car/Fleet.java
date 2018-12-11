package car;

import myannot.RunMe;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class Fleet {
    public static void main(String[] args) throws Throwable {
//        Object c = new MyCar("Red", 10);
//        Class cl = c.getClass();
//        System.out.println("Class name is " + cl.getName());

        Properties properties = new Properties();
        properties.load(Files.newBufferedReader(Paths.get("items.properties")));
        String classNameToLoad = properties.getProperty("item1");
        System.out.println("classname is " + classNameToLoad);
        Class cl = Class.forName(classNameToLoad);
        System.out.println("Classname is " + cl.getName());

//        System.setSecurityManager(new SecurityManager());

        Constructor cons = cl.getConstructor();
//        Object o = cl.newInstance();
        Object o = cons.newInstance();
        System.out.println("o is " + o);

        Method[] declaredMethods = cl.getDeclaredMethods();
        Method[] methods = cl.getMethods();

        System.out.println("Declared methods");
        for (Method m : declaredMethods) {
            System.out.println("> " + m);
            RunMe annot = m.getAnnotation(RunMe.class);
            if (annot != null) {
                System.out.println("**** RunMe found!!! value = " + annot.color());
                m.setAccessible(true);
                m.invoke(o);
            }
        }
//        System.out.println("Methods (not 'declared')");
//        for (Method m : methods) {
//            System.out.println(">> " + m);
//        }

//        Method toS = cl.getDeclaredMethod("toString");
//        Object retVal = toS.invoke(o);
//        System.out.println("Result of toString is " + retVal);

    }
}
