package randupl.output;

public class CodeBuilder  {
    private final StringBuilder code;
    public CodeBuilder() {
        code = new StringBuilder();
    }

    public void add(String text) {
        code.append(text);
    }

    public void addLine(String text) {
        code.append(text).append(System.lineSeparator());
    }

    public void indent() {
        code.append("\t");
    }

    public String getCode() {
        return code.toString();
    }
}
