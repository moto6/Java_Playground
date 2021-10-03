package chp25_generic.ex3_lagacy;

import java.io.Serializable;


public class EX1_CastingDTO implements Serializable {
    private Object object;

    public void setObject(Object object) {
        this.object = object;
    }

    public Object getObject() {
        return this.object;
    }
}
