package randupl.output;

import randupl.operation.ConstructorCall;
import randupl.operation.MethodCall;

public class CodeGenerationVisitor implements CallableOperationVisitor {
    private final CodeBuilder codeBuilder;
    public CodeGenerationVisitor(CodeBuilder codeBuilder) {
        this.codeBuilder = codeBuilder;
    }
    @Override
    public void visit(MethodCall methodCall) {
        codeBuilder.add("obj.");
        codeBuilder.add(methodCall.getName());
    }

    @Override
    public void visit(ConstructorCall constructorCall) {
        codeBuilder.add(constructorCall.toString());
    }
}
