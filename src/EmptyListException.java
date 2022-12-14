public class EmptyListException extends ValueNotFoundException {
    public EmptyListException() {
        super();
    }
    public EmptyListException(String message) {
        super(message);
    }
}
