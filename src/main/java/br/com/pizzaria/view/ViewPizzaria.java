package br.com.pizzaria.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

import br.com.pizzaria.model.business.PizzariaBusiness;
import br.com.pizzaria.model.entidades.cliente.Cliente;
import br.com.pizzaria.model.entidades.pedido.Pedido;
import br.com.pizzaria.model.entidades.pedido.PedidoTelaPrincipal;
import br.com.pizzaria.view.tabela.PedidosColumnModel;
import br.com.pizzaria.view.tabela.PedidosTableModel;

public class ViewPizzaria extends JFrame {

	private final PizzariaBusiness business = new PizzariaBusiness();

	private final PedidosColumnModel columnModel = new PedidosColumnModel();
	private final PedidosTableModel tableModel = new PedidosTableModel(business, columnModel);
	private final JTable gridPedidos = new JTable(tableModel, columnModel, null);

	private final JScrollPane pane = new JScrollPane(gridPedidos);

	private final JButton botaoAdicionarPedido = new JButton("Adicionar pedido");
	private final JButton botaoMediaDiaria = new JButton("Média diária");
	private final JButton botaoMaisConsumido = new JButton("Mais consumido por categoria");

	public ViewPizzaria() {

		setTitle("Lanches!");
		setLayout(null);
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		pane.setSize(770, 500);
		pane.setLocation(0, 0);

		adicionaColunasGrid();

		gridPedidos.getTableHeader().setReorderingAllowed(false);

		add(pane);

		configuraBotoes();

		add(botaoAdicionarPedido);
		add(botaoMediaDiaria);
		add(botaoMaisConsumido);
		
		atualizaTitulo();
	}

	private void atualizaTitulo() {

		setTitle("Pizzaria!!!");
	}

	private void configuraBotoes() {

		botaoAdicionarPedido.setSize(140, 30);
		botaoAdicionarPedido.setLocation(1, 520);
		botaoAdicionarPedido.addActionListener(new ActionAdicionarPedido());
		
		botaoMediaDiaria.setSize(140, 30);
		botaoMediaDiaria.setLocation(150, 520);
		botaoMediaDiaria.addActionListener(new ActionMediaDiaria());
		
		botaoMaisConsumido.setSize(200, 30);
		botaoMaisConsumido.setLocation(300, 520);
		botaoMaisConsumido.addActionListener(new ActionMaisConsumido());
	}

	private void adicionaColunasGrid() {
		columnModel.addColumn(criaColuna("Data", 260));
		columnModel.addColumn(criaColuna("Quantidade de pedidos", 260));
		columnModel.addColumn(criaColuna("Valor total", 240));
	}

	private TableColumn criaColuna(String titulo, int tamanho) {
		TableColumn column = new TableColumn();
		column.setHeaderValue(titulo);
		column.setResizable(false);
		column.setWidth(tamanho);
		column.setMaxWidth(tamanho);
		column.setMinWidth(tamanho);
		column.setModelIndex(columnModel.getColumnCount());
		return column;
	}

	private class ActionAdicionarPedido implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			try {
				DlgAdicionarPedido dialog = new DlgAdicionarPedido(business);
				dialog.setVisible(true);

				if (!dialog.pressionouOk()) {
					return;
				}

				Cliente cliente = dialog.getCliente();
				Pedido pedido = dialog.getPedido();

				business.adicionarPedido(cliente, pedido);

				tableModel.fireTableDataChanged();

				atualizaTitulo();
			} catch (Exception ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(botaoAdicionarPedido, ex.getLocalizedMessage());
			}

		}
	}
	

	private class ActionMediaDiaria implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			try {
				int linhaSelecionada = gridPedidos.getSelectedRow();
				
				PedidoTelaPrincipal pedidoTela = business.getPedidosTelaPrincipal().get(linhaSelecionada);
			} catch (Exception ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(botaoAdicionarPedido, ex.getLocalizedMessage());
			}
		}
	}
	
	private class ActionMaisConsumido implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
}
