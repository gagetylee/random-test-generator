package randupl.output;

import randupl.operation.ConstructorCall;
import randupl.operation.MethodCall;

public interface CallableOperationVisitor {
    void visit(MethodCall methodCall);
    void visit(ConstructorCall constructorCall);
}
