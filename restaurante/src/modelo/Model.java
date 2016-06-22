/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author junio_000
 */
public interface Model<T> extends Iterable<T> {

    void addListener(ModelChangeListener modelListener);
    
    void persistir();
}
