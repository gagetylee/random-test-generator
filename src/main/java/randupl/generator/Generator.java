package randupl.generator;


import randupl.operation.CallableOperation;

import java.lang.reflect.Type;
import java.util.Random;

public class Generator {
    private final Random random;
    public Generator() {
        random = new Random();
    }

    public Object[] generateInputs(CallableOperation op) {
        Type[] inputTypes = op.getInputTypes();
        Object[] inputArr = new Object[inputTypes.length];
        for (int i = 0; i < inputTypes.length; i++) {
            // Add support for additional input types

            if (inputTypes[i].equals(Integer.TYPE)) {
                inputArr[i] = random.nextInt();
            }
            else if (inputTypes[i].equals(Double.TYPE)) {
                inputArr[i] = random.nextDouble();
            }
            else if (inputTypes[i].equals(Boolean.TYPE)) {
                inputArr[i] = random.nextBoolean();
            }
            else if (inputTypes[i].equals(Float.TYPE)) {
                inputArr[i] = random.nextFloat();
            }
        }
        return inputArr;
    }
}
