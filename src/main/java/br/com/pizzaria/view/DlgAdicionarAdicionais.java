package br.com.pizzaria.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;

import br.com.pizzaria.model.entidades.cardapio.Adicional;

public class DlgAdicionarAdicionais extends JDialog {
	private Adicional adicional;

	private final JButton botaoOk = new JButton("OK");
	private final JButton botaoCancelar = new JButton("Cancelar");

	private final JComboBox<Adicional> comboAdicionais = new JComboBox<>();

	private boolean pressionouOk = false;

	public DlgAdicionarAdicionais() {
		setSize(500, 300);
		setLayout(null);
		setModal(true);

		setTitle("Adicionar adicional");

		botaoOk.addActionListener(new ActionOk());
		botaoCancelar.addActionListener(new ActionCancelar());

		botaoOk.setSize(100, 30);
		botaoOk.setLocation(15, 210);

		botaoCancelar.setSize(100, 30);
		botaoCancelar.setLocation(150, 210);

		comboAdicionais.setLocation(100, 10);
		comboAdicionais.setSize(250, 25);
		add(criaLabel("Adicional", 10));

		add(comboAdicionais);

		add(botaoOk);
		add(botaoCancelar);

		for (Adicional adicional : Adicional.values()) {
			comboAdicionais.addItem(adicional);
		}
	}

	private JLabel criaLabel(String string, int linha) {

		JLabel label = new JLabel(string);
		label.setLocation(10, linha);
		label.setSize(100, 25);

		return label;
	}

	public Adicional getAdicional() {

		return adicional;
	}

	public boolean pressionouOk() {

		return pressionouOk;
	}

	private class ActionOk implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			pressionouOk = true;

			DlgAdicionarAdicionais.this.adicional = (Adicional) comboAdicionais.getSelectedItem();

			DlgAdicionarAdicionais.this.setVisible(false);
		}
	}

	private class ActionCancelar implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			DlgAdicionarAdicionais.this.setVisible(false);
		}

	}
}
