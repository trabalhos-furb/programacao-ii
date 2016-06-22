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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void carregarMesas() {
        throw new UnsupportedOperationException("Not supported yet.");
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
        return new MesaIterator(this.mesas);
    }
}
