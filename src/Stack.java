public class Stack {
    private LinkedList list;

    public Stack() {
        list = new LinkedList();
    }

    public void push(Object object) {
        list.insertLast(object);
    }

    public Object pop() throws EmptyListException {
        Object object = list.getLastValue();
        try {
            list.remove(object);
        } catch (ValueNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void empty() {
        list.empty();
    }

    @Override
    public String toString() {
        return list.toString();
    }

    public void print() {
        System.out.println(toString());
    }
}
