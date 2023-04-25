package randupl.output;

import randupl.operation.CallableOperation;

public class TestCase {
    private final CodeBuilder cb;
    private final CodeGenerationVisitor visitor;
    private final CallableOperation operation;
    private final Object[] input;

    public TestCase(CodeBuilder codeBuilder, CallableOperation operation, Object... input) {
        this.operation = operation;
        this.input = input;
        this.cb = codeBuilder;
        visitor = new CodeGenerationVisitor(cb);
        build();
    }

    private void assertTrue(String a, String b) {
        cb.add("assertTrue(");
        cb.add(a);
        cb.add(".equals(");
        cb.add(b);
        cb.add("));");
        cb.addLine("");
    }

    private void assertNotNull(String a) {
        cb.add("assertNotNull(");
        cb.add(a);
        cb.add(");");
        cb.addLine("");
    }

    private void build() {
        cb.add("TEST_");
        cb.add(operation.getName());
        cb.addLine("() {");
        cb.indent();
        cb.add(operation.getDeclaringType().getSimpleName());
        cb.add(" obj = new ");
        cb.add(operation.getDeclaringType().getSimpleName());
        cb.addLine("();");
        cb.indent();
        cb.add(operation.getOutputType().getSimpleName());
        cb.add(" res = ");
        operation.accept(visitor);
        cb.add("(");
        for (int i = 0; i < input.length; i++) {
            cb.add(input[i].toString());
            if (i < input.length - 1) {
                cb.add(", ");
            }
        }
        cb.add(");");
        cb.addLine("");
        cb.indent();
        assertNotNull("res");
        cb.addLine("}");
    }
}
