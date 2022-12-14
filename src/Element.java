public class Element<V> {
    private V value;
    private Element<V> next;

    public Element(V newValue) {
        this.value = newValue;
        next = null;
    }

    public void setNext(Element element) {
        next = element;
    }

    public V getValue() {
        return value;
    }

    public Element getNext() {
        return next;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public void delete() {
        value = null;
        next = null;
    }
}
