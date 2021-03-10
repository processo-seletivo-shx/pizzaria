package br.com.pizzaria.view.tabela;

import javax.swing.table.AbstractTableModel;

import br.com.pizzaria.model.entidades.pedido.Pedido;
import br.com.pizzaria.model.entidades.pedido.PedidoBebida;

public class BebidaTableModel extends AbstractTableModel {

	private Pedido pedido;

	private BebidaColumnModel columnModel;
	
	public BebidaTableModel(Pedido pedido, BebidaColumnModel columnModel) {
		this.pedido = pedido;
		this.columnModel = columnModel;
	}

	@Override
	public int getRowCount() {

		return pedido.getPedidoBebidas().size();
	}

	@Override
	public int getColumnCount() {

		return columnModel.getColumnCount();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		PedidoBebida pedidoBebida = pedido.getPedidoBebidas().get(rowIndex);

		if (columnIndex == 0) {
			return pedidoBebida.getBebida().getDescricao();
		}

		if (columnIndex == 1) {
			return pedidoBebida.getQuantidade();
		}
		
		return null;
	}
}
