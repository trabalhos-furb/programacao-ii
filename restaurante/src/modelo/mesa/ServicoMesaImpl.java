/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.mesa;

import java.util.Iterator;
import java.util.List;
import modelo.AbstractModel;
import modelo.Model;
import modelo.Persistence;

/**
 *
 * @author junio_000
 */
class ServicoMesaImpl extends AbstractModel<Mesa> implements ServicoMesa {

    private List<Mesa> mesas;

    ServicoMesaImpl() {
        carregarMesas();
    }

    @Override
    public void persistir() {
        final Persistence<Mesa> instance = Persistence.getInstance();
        instance.save(mesas, "Mesas");
    }

    private void carregarMesas() {
        final Persistence<Mesa> instance = Persistence.getInstance();
        this.mesas = instance.load("Mesas");
    }

    @Override
    public void addMesa() {
        this.mesas.add(new Mesa(this.mesas.size() + 1, Status.DISPONIVEL));
        this.notifyListeners();
    }

    @Override
    public Mesa getMesa(int codigo) {
        for (Mesa mesa : mesas) {
            if (mesa.getNumero() == codigo) {
                return mesa;
            }
        }
        return null;
    }

    @Override
    public Iterator<Mesa> iterator() {
        return this.mesas.iterator();
    }
}
