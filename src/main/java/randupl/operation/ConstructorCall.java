package randupl.operation;

import randupl.output.CallableOperationVisitor;

import java.lang.reflect.Constructor;
import java.lang.reflect.Type;

public final class ConstructorCall extends CallableOperation {

    private final Constructor<?> constructor;

    public ConstructorCall(Constructor<?> constructor) {
        super(constructor.getDeclaringClass(), constructor.getParameterTypes(), null);
        this.constructor = constructor;
    }

    @Override
    public String getName() {
        return "constructor";
    }

    @Override
    public void accept(CallableOperationVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public Object execute(Object instance, Object... input) {
        return null;
    }
}
