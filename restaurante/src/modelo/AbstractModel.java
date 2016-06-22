/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author junio_000
 */
public abstract class AbstractModel<T> implements Model<T> {
    
    private List<ModelChangeListener> listeners;

    protected AbstractModel() {
        listeners = new ArrayList<>();
    }
    
    @Override
    public void addListener(ModelChangeListener modelListener) {
        if (modelListener == null) {
            throw new IllegalArgumentException("O listner deve ser diferente de nulo");
        }
        this.listeners.add(modelListener);
    }
    
    protected void notifyListeners() {
        for (ModelChangeListener listener : listeners) {
            listener.executeOnChange();
        }
    }
}
