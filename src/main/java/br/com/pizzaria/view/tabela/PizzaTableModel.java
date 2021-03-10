package br.com.pizzaria.view.tabela;

import javax.swing.table.AbstractTableModel;

import br.com.pizzaria.model.entidades.cardapio.Pizza;
import br.com.pizzaria.model.entidades.pedido.Pedido;
import br.com.pizzaria.model.entidades.pedido.PedidoPizza;

public class PizzaTableModel extends AbstractTableModel {

	private Pedido pedido;

	private PizzaColumnModel columnModel;
	
	public PizzaTableModel(Pedido pedido, PizzaColumnModel columnModel) {
		this.pedido = pedido;
		this.columnModel = columnModel;
	}

	@Override
	public int getRowCount() {

		return pedido.getPedidoPizzas().size();
	}

	@Override
	public int getColumnCount() {

		return columnModel.getColumnCount();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		PedidoPizza pedido = this.pedido.getPedidoPizzas().get(rowIndex);

		if (columnIndex == 0) {
			if (pedido.getPizzaUnica() != null) {
				return pedido.getPizzaUnica().getDescricao();
			} else {
				Pizza pizza1 = pedido.getPizzasSabores().get(0);
				Pizza pizza2 = pedido.getPizzasSabores().get(1);
				return pizza1.getDescricao() + ", " + pizza2.getDescricao();
			}
		}

		if (columnIndex == 1) {
			return pedido.getBorda().getDescricao();
		}
		
		if (columnIndex == 2) {
			return pedido.getMassa().getDescricao();
		}
		
		if (columnIndex == 3) {
			return pedido.getTamanho().name();
		}

		if (columnIndex == 4) {
			return pedido.getQuantidadeAdicionais();
		}

		return null;
	}
}
