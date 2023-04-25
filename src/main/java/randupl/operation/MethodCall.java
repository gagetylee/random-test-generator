package randupl.operation;

import randupl.output.CallableOperationVisitor;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

public final class MethodCall extends CallableOperation {
    private final Method method;
    private final boolean isStatic;

    /**
     * Creates a new method call from reflection type
     * @param method - Reflection method
     */
    public MethodCall(Method method, Class<?> declaringType) {
        super(declaringType, method.getParameterTypes(), method.getReturnType());

        this.method = method;
        this.isStatic = Modifier.isStatic(method.getModifiers() & Modifier.methodModifiers());
    }

    @Override
    public void accept(CallableOperationVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public boolean isMethodCall() {
        return true;
    }

    @Override
    public String toString() {
        return method.toString();
    }

    @Override
    public String getName() {
        return method.getName();
    }

    @Override
    public Object execute(Object instance, Object... input) {
        try {
            return method.invoke(instance, input);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}
