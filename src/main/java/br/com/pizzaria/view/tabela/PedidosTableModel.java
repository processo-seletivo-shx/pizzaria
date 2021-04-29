package br.com.pizzaria.view.tabela;

import java.text.NumberFormat;

import javax.swing.table.AbstractTableModel;

import br.com.pizzaria.model.business.PizzariaBusiness;
import br.com.pizzaria.model.entidades.pedido.PedidoTelaPrincipal;

public class PedidosTableModel extends AbstractTableModel {

	private PizzariaBusiness business;

	private PedidosColumnModel columnModel;
	
	public PedidosTableModel(PizzariaBusiness business, PedidosColumnModel columnModel) {
		this.business = business;
		this.columnModel = columnModel;
	}

	@Override
	public int getRowCount() {

		return business.getPedidosTelaPrincipal().size();
	}

	@Override
	public int getColumnCount() {

		return columnModel.getColumnCount();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		PedidoTelaPrincipal pedido = business.getPedidosTelaPrincipal().get(rowIndex);

		if (columnIndex == 0) {
			return pedido.getData();
		}

		if (columnIndex == 1) {
			return pedido.getQuantidadePedidos();
		}
		
		if (columnIndex == 2) {
			return NumberFormat.getCurrencyInstance().format(pedido.getValorTotal());
		}

		return null;
	}
}
