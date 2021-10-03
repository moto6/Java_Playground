package chp25_generic.ex4;



public class GenericSample<T>  {
    private T object;

    public void setObject(T object) {
        this.object = object;
    }

    public T getObject() {
        return this.object;
    }
}
