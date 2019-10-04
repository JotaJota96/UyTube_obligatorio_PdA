package JPAControllerClasses;

import java.util.ArrayList;

public class ParDeObjetos {
    private Object element;
    private Object orderField;

    public ParDeObjetos(Object element, Object orderField) {
        this.element = element;
        this.orderField = orderField;
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public Object getOrderField() {
        return orderField;
    }

    public void setOrderField(Object orderField) {
        this.orderField = orderField;
    }
    
    
    public static ArrayList<Object> extraerElementos(ArrayList<ParDeObjetos> lista){
        ArrayList<Object> ret = new ArrayList();
        for (ParDeObjetos par : lista){
            ret.add(par.getElement());
        }
        return ret;
    }
    
    
}
