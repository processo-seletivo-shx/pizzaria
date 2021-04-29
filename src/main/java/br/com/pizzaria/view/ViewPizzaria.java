package br.com.pizzaria.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

import br.com.pizzaria.model.business.PizzariaBusiness;
import br.com.pizzaria.model.entidades.cardapio.Categoria;
import br.com.pizzaria.model.entidades.cardapio.Pizza;
import br.com.pizzaria.model.entidades.cliente.Cliente;
import br.com.pizzaria.model.entidades.pedido.Pedido;
import br.com.pizzaria.model.entidades.pedido.PedidoBebida;
import br.com.pizzaria.model.entidades.pedido.PedidoCliente;
import br.com.pizzaria.model.entidades.pedido.PedidoPizza;
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
	private final JButton botaoMediaDiaria = new JButton("Média diaria");
	private final JButton botaoMaisConsumido = new JButton("Mais consumido por categoria");
   private final JButton botaoListarPedidos = new JButton("Listar pedidos");

	public ViewPizzaria() {

		setTitle("Pizzas!");
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
		add(botaoListarPedidos);

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

		botaoListarPedidos.setSize(200, 30);
		botaoListarPedidos.setLocation(500, 520);
		botaoListarPedidos.addActionListener(new ActionListarPedidos());
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

				if (linhaSelecionada < 0) {
	            JOptionPane.showMessageDialog(botaoMediaDiaria, "Nenhum item foi selecionado");
	            return;
				}

				PedidoTelaPrincipal pedidoTela = business.getPedidosTelaPrincipal().get(linhaSelecionada);

				double percentualMediaDiaria = business.getPercentualMediaDiaria(pedidoTela.getData());
            JOptionPane.showMessageDialog(botaoMediaDiaria, "Percentual da meta diária é de " + String.valueOf(percentualMediaDiaria) + "%");
			} catch (Exception ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(botaoMediaDiaria, ex.getLocalizedMessage());
			}
		}
	}

	private class ActionMaisConsumido implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
		   Pizza pizzaClassica = business.getMaisConsumidoPorCategoria(Categoria.CLASSICA);
         Pizza pizzaDoce = business.getMaisConsumidoPorCategoria(Categoria.DOCE);
         Pizza pizzaVegetariana = business.getMaisConsumidoPorCategoria(Categoria.VEGETARIANA);

         if (pizzaClassica == null ) {
            JOptionPane.showMessageDialog(botaoMaisConsumido, "Nenhuma pizza clássica foi consumida");
         } else {
            JOptionPane.showMessageDialog(botaoMaisConsumido, "Categoria clássica mais consumida: " + pizzaClassica);
         }

         if (pizzaDoce == null ) {
            JOptionPane.showMessageDialog(botaoMaisConsumido, "Nenhuma pizza doce foi consumida");
         } else {
            JOptionPane.showMessageDialog(botaoMaisConsumido, "Categoria doce mais consumida: " + pizzaDoce);
         }

         if (pizzaVegetariana == null ) {
            JOptionPane.showMessageDialog(botaoMaisConsumido, "Nenhuma pizza vegetariana foi consumida");
         } else {
            JOptionPane.showMessageDialog(botaoMaisConsumido, "Categoria vegetariana mais consumida: " + pizzaVegetariana);
         }
		}
	}

	private class ActionListarPedidos implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         // • Para cada objeto de pedido cliente, imprimir:
         //
         // ◦ Nome do cliente
         // ◦ Valor total do pedido
         // ◦ Pizzas (tratar somente as pizzas de 1 sabor):
         // ▪ Nome da pizza
         // ▪ Tamanho da pizza
         // ▪ Borda da pizza
         // ▪ Tipo da massa da pizza
         // ▪ Quantidade de adicionais
         // ◦ Bebidas
         // ▪ Nome da bebida
         // ▪ Quantidade


         List<PedidoCliente> clientes = business.getClientes();

         System.out.println("Detalhes dos pedidos");

         for (PedidoCliente pedidoCliente : clientes) {
            System.out.println("");
            System.out.println("");

            System.out.println("Nome do cliente: " + pedidoCliente.getCliente().getNome());

            List<Pedido> pedidos = pedidoCliente.getPedidos();

            for (Pedido pedido : pedidos) {
               System.out.println("Valor total do pedido: " + pedido.getValorTotal());

               List<PedidoPizza> pedidoPizzas = pedido.getPedidoPizzas();
               List<PedidoBebida> pedidoBebidas = pedido.getPedidoBebidas();

               for (int i = 0; i < pedidoPizzas.size(); i++) {
                  PedidoPizza pedidoPizza = pedidoPizzas.get(i);

                  if (pedidoPizza.getPizzaUnica() == null) {
                     continue;
                  }

                  System.out.println();
                  System.out.println("Pizza " + (i + 1));
                  System.out.println("Nome da pizza: " + pedidoPizza.getPizzaUnica().getDescricao());
                  System.out.println("Tamanho: " + pedidoPizza.getTamanho());
                  System.out.println("Borda: " + pedidoPizza.getBorda().getDescricao());
                  System.out.println("Tipo da massa: " + pedidoPizza.getMassa().getDescricao());
                  System.out.println("Quantidade de adicionais: " + pedidoPizza.getQuantidadeAdicionais());
                  System.out.println();
               }

               for (PedidoBebida pedidoBebida : pedidoBebidas) {
                  System.out.println("Nome da bebida: " + pedidoBebida.getBebida().getDescricao() + ", Quantidade: " + pedidoBebida.getQuantidade());
               }
            }
         }
      }
	}

}
