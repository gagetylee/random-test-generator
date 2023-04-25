//import randupl.operation.ConstructorCall;
//import randupl.operation.MethodCall;
import randupl.output.TestCaseManager;
import randupl.reflection.OperationStore;

import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("Usage: java Main <class path>");
            System.exit(1);
        }

        String classFilePath = args[0];
        byte[] classFileBytes = Files.readAllBytes(Path.of(classFilePath));

        CustomClassLoader cl = new CustomClassLoader();
        Class<?> target = cl.loadClassFromBytes(classFileBytes);

        // Store operations of target class
        OperationStore os = new OperationStore(target);
        TestCaseManager tm = new TestCaseManager(os);

        tm.generateTests();
        tm.print();
    }
    static class CustomClassLoader extends ClassLoader {
        public Class<?> loadClassFromBytes(byte[] classBytes) {
            return defineClass(null, classBytes, 0, classBytes.length);
        }
    }
}