public class LinkedList<V> {
    private Element<V> first;
    private Element<V> last;

    public LinkedList() {
        first = null;
        last = null;
    }

    public void empty() {
        first = null;
        last = null;
    }

    public void insertFirst(V value) {
        Element<V> element = new Element<>(value);
        element.setNext(first);
        first = element;
        if (isEmpty()) {
            last = element;
        }
    }

    public void insertLast(V value) {
        Element<V> element = new Element<>(value);
        if (!isEmpty()) {
            last.setNext(element);
        }
        last = element;
        if (isEmpty()) {
            first = element;
        }
    }

    public void print() {
        Element<V> element = first;
        while (element != null) {
            System.out.println(element.getValue());
            element = element.getNext();
        }
    }

    public boolean isEmpty() {
        return first == null || last == null;
    }

    public V getFirstValue() throws EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException("The list is empty");
        }
        return first.getValue();
    }

    public V getLastValue() throws EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException("The list is empty");
        }
        return last.getValue();
    }

    public int getNumElements() {
        Element<V> e = first;
        int counter = 0;
        while (e != null) {
            e = e.getNext();
            counter++;
        }
        return counter;
    }

    public V getValueAtPosition(int index) throws EmptyListException,
                                                InvalidIndexException {
        if (isEmpty()) {
            throw new EmptyListException("Empty list");
        }
        Element<V> e = first;
        for (int i = 0; i < index; i++) {
            if (e == null) {
                throw new InvalidIndexException();
            }
            e = e.getNext();
            if (e == null) {
                throw new InvalidIndexException();
            }
        }
        return e.getValue();
    }

    public void remove(V value) throws ValueNotFoundException,
            EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException("The list is empty");
        }

        Element<V> e = first;
        Element<V> temp = first;

        while (e != null) {
            if (e.getValue().equals(value)) {
                // delete Element
                if (e == first) {
                   first = e.getNext();
                } else {
                    temp.setNext(e.getNext());
                }
                if (e.getNext() == null) {
                    last = first == null ? null : temp;
                }
                return;
            } else {
                temp = e;
                e = e.getNext();
            }
        }
        throw new ValueNotFoundException("Object not found");
    }

    @Override
    public String toString() {
        String s = "";
        Element<V> e = first;
        boolean alreadyComma = false;
        while (e != null) {
            if (!alreadyComma) {
                alreadyComma = true;
            } else {
                s += ", ";
            }
            s += e.getValue();
            e = e.getNext();
        }
        return s;
    }
}
