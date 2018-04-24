package assembler;

class InvalidOpCodeException extends Exception {
    public InvalidOperationCodeException(Statement statement) {
        super("Invalid operation code: " + statement.operation());
    }
}
