package br.com.pizzaria.view.tabela;

import javax.swing.table.AbstractTableModel;

import br.com.pizzaria.model.entidades.cardapio.Adicional;
import br.com.pizzaria.model.entidades.pedido.PedidoPizza;

public class AdicionalTableModel extends AbstractTableModel {

	private PedidoPizza pedido;

	private AdicionalColumnModel columnModel;

	public AdicionalTableModel(PedidoPizza pedido, AdicionalColumnModel columnModel) {
		this.pedido = pedido;
		this.columnModel = columnModel;
	}

	@Override
	public int getRowCount() {

		return pedido.getAdicionais().size();
	}

	@Override
	public int getColumnCount() {

		return columnModel.getColumnCount();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		Adicional adicional = pedido.getAdicionais().get(rowIndex);

		if (columnIndex == 0) {
			return adicional.getDescricao();
		}

		return null;
	}
}
