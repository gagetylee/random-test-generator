package randupl.operation;
import randupl.output.CallableOperationVisitor;
import java.lang.reflect.Type;

public abstract class CallableOperation implements Operation {
    private final Class<?> declaringType;
    private final Class<?>[] inputTypes;
    private final Class<?> outputType;

    public CallableOperation(Class<?> declaringType, Class<?>[] inputTypes, Class<?> outputType) {
        this.declaringType = declaringType;
        this.inputTypes = inputTypes;
        this.outputType = outputType;
    }

    public Class<?> getDeclaringType() {
        return this.declaringType;
    }

    public Class<?>[] getInputTypes() {
        return this.inputTypes;
    }

    public Class<?> getOutputType() {
        return this.outputType;
    }
    @Override
    public boolean isMethodCall() {
        return false;
    }

    @Override
    public boolean isConstructorCall() {
        return false;
    }

    @Override
    public boolean isConstantField() {
        return false;
    }

    public abstract Object execute(Object instance, Object... input);

    public abstract void accept(CallableOperationVisitor visitor);
}
