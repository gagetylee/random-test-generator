package randupl.output;

import randupl.generator.Generator;
import randupl.operation.CallableOperation;
import randupl.reflection.OperationStore;

import java.util.ArrayList;
import java.util.List;

/**
 * Manager class for creation of randomly generated test cases
 */
public class TestCaseManager {
    private final CodeBuilder codeBuilder;
    private final Generator generator;
    private final OperationStore operationStore;
    private final List<TestCase> testCases;

    public TestCaseManager(OperationStore operationStore) {
        this.operationStore = operationStore;
        this.generator = new Generator();
        codeBuilder = new CodeBuilder();
        testCases = new ArrayList<>();
    }

    public void generateTests() {
        for (CallableOperation op: operationStore.getOperations()) {
            Object[] inputs = generator.generateInputs(op);
            if (op.isMethodCall()) {
                TestCase testCase = new TestCase(this.codeBuilder, op, inputs);
                testCases.add(testCase);
            }
        }
    }

    public void print() {
        System.out.println(codeBuilder.getCode());
    }
}
