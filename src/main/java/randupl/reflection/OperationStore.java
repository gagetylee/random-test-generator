package randupl.reflection;

import randupl.operation.CallableOperation;
import randupl.operation.ConstructorCall;
import randupl.operation.MethodCall;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.security.SignatureException;
import java.util.ArrayList;
import java.util.List;

public class OperationStore {
    private final List<CallableOperation> callableOperations;
    private final Class<?> targetClass;
    public OperationStore(Class<?> targetClass) {
        callableOperations = new ArrayList<>();
        this.targetClass = targetClass;

        try {
            fillFromClass();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public List<CallableOperation> getOperations() {
        return callableOperations;
    }

    private void fillFromClass() throws SignatureException {
        // Parse methods
        Method[] methods = targetClass.getDeclaredMethods();
        Constructor<?>[] constructors = targetClass.getConstructors();

        for (Method m : methods) {
            MethodCall method = new MethodCall(m, targetClass);
            callableOperations.add(method);
        }
        for (Constructor<?> c : constructors) {
            ConstructorCall constructor = new ConstructorCall(c);
            callableOperations.add(constructor);
        }
    }
}
