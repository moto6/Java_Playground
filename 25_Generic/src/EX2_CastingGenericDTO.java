import java.io.Serializable;


public class EX2_CastingGenericDTO implements Serializable {
    private Object object;

    public void setObject(Object<T> object) {
        this.object = object;
    }

    public <T> getObject() {
        return this.object;
    }
}
