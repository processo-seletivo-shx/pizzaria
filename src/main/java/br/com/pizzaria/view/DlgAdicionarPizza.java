package br.com.pizzaria.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

import br.com.pizzaria.model.entidades.cardapio.Adicional;
import br.com.pizzaria.model.entidades.cardapio.Borda;
import br.com.pizzaria.model.entidades.cardapio.Massa;
import br.com.pizzaria.model.entidades.cardapio.Pizza;
import br.com.pizzaria.model.entidades.cardapio.Tamanho;
import br.com.pizzaria.model.entidades.pedido.PedidoPizza;
import br.com.pizzaria.view.tabela.AdicionalColumnModel;
import br.com.pizzaria.view.tabela.AdicionalTableModel;

public class DlgAdicionarPizza extends JDialog {
	private PedidoPizza pedidoPizza = new PedidoPizza();

	private final JButton botaoOk = new JButton("OK");
	private final JButton botaoCancelar = new JButton("Cancelar");
	private final JButton botaoAdicionarAdicional = new JButton("Adicionar adicional");
	
	private final AdicionalColumnModel columnModel = new AdicionalColumnModel();
	private final AdicionalTableModel tableModel = new AdicionalTableModel(pedidoPizza, columnModel);
	private final JTable grid = new JTable(tableModel, columnModel, null);
	private final JScrollPane pane = new JScrollPane(grid);

	private final JComboBox<Pizza> comboPizzaUnica = new JComboBox<>();

	private final JCheckBox checkSaborUnico = new JCheckBox();
	
	private final JComboBox<Pizza> comboPizzaSabor1 = new JComboBox<>();
	private final JComboBox<Pizza> comboPizzaSabor2 = new JComboBox<>();
	private final JComboBox<Tamanho> comboTamanho = new JComboBox<>();
	private final JComboBox<Borda> comboBorda = new JComboBox<>();
	private final JComboBox<Massa> comboMassa = new JComboBox<>();

	private boolean pressionouOk = false;

	public DlgAdicionarPizza() {
		setSize(500, 470);
		setLayout(null);
		setModal(true);
		
		setTitle("Adicionar pizza");
		
		adicionaColunasGrid();
		
		grid.getTableHeader().setReorderingAllowed(false);

		botaoOk.addActionListener(new ActionOk());
		botaoCancelar.addActionListener(new ActionCancelar());
		botaoAdicionarAdicional.addActionListener(new ActionAdicionarAdicionais());

		botaoOk.setSize(100, 30);
		botaoOk.setLocation(15, 390);

		botaoCancelar.setSize(100, 30);
		botaoCancelar.setLocation(150, 390);
		
		botaoAdicionarAdicional.setSize(200, 30);
		botaoAdicionarAdicional.setLocation(250, 390);

		checkSaborUnico.setLocation(100, 10);
		checkSaborUnico.setSize(30, 30);
		checkSaborUnico.addActionListener(new ActionSaborUnico());
		checkSaborUnico.setSelected(true);
		add(criaLabel("Sabor único", 10));
		
		comboPizzaUnica.setLocation(100, 40);
		comboPizzaUnica.setSize(250, 25);
		add(criaLabel("Pizza", 40));
		
		comboPizzaSabor1.setLocation(100, 70);
		comboPizzaSabor1.setSize(250, 25);
		add(criaLabel("Pizza sabor 1", 70));
		
		comboPizzaSabor2.setLocation(100, 100);
		comboPizzaSabor2.setSize(250, 25);
		add(criaLabel("Pizza sabor 2", 100));
		
		comboTamanho.setLocation(100, 130);
		comboTamanho.setSize(250, 25);
		add(criaLabel("Tamanho", 130));
		
		comboBorda.setLocation(100, 160);
		comboBorda.setSize(250, 25);
		add(criaLabel("Borda", 160));
		
		comboMassa.setLocation(100, 190);
		comboMassa.setSize(250, 25);
		add(criaLabel("Massa", 190));
		
		pane.setLocation(0, 220);
		pane.setSize(480, 155);
		
		add(checkSaborUnico);
		add(comboPizzaUnica);
		add(comboPizzaSabor1);
		add(comboPizzaSabor2);
		add(comboTamanho);
		add(comboBorda);
		add(comboMassa);

		add(pane);
		
		add(botaoOk);
		add(botaoCancelar);
		add(botaoAdicionarAdicional);

		for (Pizza pizza : Pizza.values()) {
			comboPizzaUnica.addItem(pizza);
			comboPizzaSabor1.addItem(pizza);
			comboPizzaSabor2.addItem(pizza);
		}
		
		for (Borda borda : Borda.values()) {
			comboBorda.addItem(borda);
		}
		
		for (Massa massa : Massa.values()) {
			comboMassa.addItem(massa);
		}
		
		for (Tamanho tamanho : Tamanho.values()) {
			comboTamanho.addItem(tamanho);
		}
		
		setPizzaSaborUnico(checkSaborUnico.isSelected());
	}
	
	private void adicionaColunasGrid() {
		columnModel.addColumn(criaColuna(columnModel, "Adicional", 480));
	}

	private TableColumn criaColuna(DefaultTableColumnModel columnModel, String titulo, int tamanho) {

		TableColumn column = new TableColumn();
		column.setHeaderValue(titulo);
		column.setResizable(false);
		column.setWidth(tamanho);
		column.setMaxWidth(tamanho);
		column.setMinWidth(tamanho);
		column.setModelIndex(columnModel.getColumnCount());
		return column;
	}

	private JLabel criaLabel(String string, int linha) {

		JLabel label = new JLabel(string);
		label.setLocation(10, linha);
		label.setSize(100, 25);

		return label;
	}

	public PedidoPizza getPedidoPizza() {

		return pedidoPizza;
	}

	public boolean pressionouOk() {

		return pressionouOk;
	}

	private class ActionOk implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (checkSaborUnico.isSelected()) {
				pedidoPizza.setPizzaUnica((Pizza) comboPizzaUnica.getSelectedItem());
			} else {
				if (!testaSaboresIguais(comboPizzaSabor1, comboPizzaSabor2)) {
					return;
				}
				
				pedidoPizza.adicionaSabor1((Pizza) comboPizzaSabor1.getSelectedItem());
				pedidoPizza.adicionaSabor2((Pizza) comboPizzaSabor2.getSelectedItem());
			}
			
			pedidoPizza.setBorda((Borda) comboBorda.getSelectedItem());
			pedidoPizza.setMassa((Massa) comboMassa.getSelectedItem());
			pedidoPizza.setTamanho((Tamanho) comboTamanho.getSelectedItem());
			
			DlgAdicionarPizza.this.pressionouOk = true;
			DlgAdicionarPizza.this.pedidoPizza = pedidoPizza;

			DlgAdicionarPizza.this.setVisible(false);
		}
	}
	
	private class ActionSaborUnico implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JCheckBox check = (JCheckBox) e.getSource();
			if (check.isSelected()) {
				comboPizzaUnica.setEnabled(true);
				
				comboPizzaSabor1.setEnabled(false);
				comboPizzaSabor2.setEnabled(false);
			} else {
				comboPizzaUnica.setEnabled(false);

				comboPizzaSabor1.setEnabled(true);
				comboPizzaSabor2.setEnabled(true);
			}
		}
	}
	
	private void setPizzaSaborUnico(boolean saborUnico) {
		if (saborUnico) {
			comboPizzaUnica.setEnabled(true);
			
			comboPizzaSabor1.setEnabled(false);
			comboPizzaSabor2.setEnabled(false);
		} else {
			comboPizzaUnica.setEnabled(false);
			
			comboPizzaSabor1.setEnabled(true);
			comboPizzaSabor2.setEnabled(true);
		}
	}

	private boolean testaSaboresIguais(JComboBox<Pizza> comboPizzaSabor1, JComboBox<Pizza> comboPizzaSabor2) {
		Pizza pizzaSabor1 = (Pizza) comboPizzaSabor1.getSelectedItem();
		Pizza pizzaSabor2 = (Pizza) comboPizzaSabor2.getSelectedItem();
		
		if (pizzaSabor1 != pizzaSabor2) {
			return true;
		}

		JOptionPane.showMessageDialog(botaoOk, "Sabores não podem ser iguais!");
		return false;
	}

	private class ActionCancelar implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			DlgAdicionarPizza.this.setVisible(false);
		}

	}
	
	private class ActionAdicionarAdicionais implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {

				DlgAdicionarAdicionais dialog = new DlgAdicionarAdicionais();
				dialog.setVisible(true);

				if (!dialog.pressionouOk()) {
					return;
				}

				Adicional adicional = dialog.getAdicional();

				pedidoPizza.adicionaAdicional(adicional);

				tableModel.fireTableDataChanged();
			} catch (Exception ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(botaoAdicionarAdicional, ex.getLocalizedMessage());
			}
		}
	}
}
