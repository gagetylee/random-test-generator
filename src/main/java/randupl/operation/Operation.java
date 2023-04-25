package randupl.operation;

public interface Operation {
    boolean isMethodCall();
    boolean isConstructorCall();
    boolean isConstantField();
    String getName();
}
