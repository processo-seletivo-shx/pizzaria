package br.com.pizzaria.model.business;

import java.util.ArrayList;
import java.util.List;

import br.com.pizzaria.model.entidades.cardapio.Adicional;
import br.com.pizzaria.model.entidades.cardapio.Bebida;
import br.com.pizzaria.model.entidades.cardapio.Categoria;
import br.com.pizzaria.model.entidades.cardapio.Pizza;
import br.com.pizzaria.model.entidades.cardapio.Tamanho;
import br.com.pizzaria.model.entidades.cliente.Cliente;
import br.com.pizzaria.model.entidades.pedido.Pedido;
import br.com.pizzaria.model.entidades.pedido.PedidoBebida;
import br.com.pizzaria.model.entidades.pedido.PedidoCliente;
import br.com.pizzaria.model.entidades.pedido.PedidoPizza;
import br.com.pizzaria.model.entidades.pedido.PedidoTelaPrincipal;

public class PizzariaBusiness {

	private List<PedidoCliente> clientes = new ArrayList<>();
	private List<PedidoTelaPrincipal> pedidosTela = new ArrayList<>();

	public void adicionarPedido(Cliente cliente, Pedido pedido) {

		boolean achou = false;
		for (PedidoCliente pedidoCliente : clientes) {
			if (cliente.getNome().equalsIgnoreCase(pedidoCliente.getCliente().getNome())) {
				achou = true;
				aplicaValorTotalPedido(pedido);
				aplicaComboPromocao(pedido);
				aplicaPromocaoBebidas(pedido);
				removeSaldoBebidas(pedido);

				pedidoCliente.adicionarPedido(pedido);
			}
		}

		if (!achou) {
			aplicaValorTotalPedido(pedido);
			aplicaDescontoPrimeiraCompra(pedido);
			aplicaComboPromocao(pedido);
			aplicaPromocaoBebidas(pedido);
			removeSaldoBebidas(pedido);

			PedidoCliente pedidoCliente = new PedidoCliente();
			pedidoCliente.setCliente(cliente);
			pedidoCliente.adicionarPedido(pedido);

			clientes.add(pedidoCliente);
		}
	}

	public void removePedidoPizza(Pedido pedido, PedidoPizza pedidoPizza) {
		pedido.removePizzaPedido(pedidoPizza);
	}

	public void removePedidoBebida(Pedido pedido, PedidoBebida pedidoBebida) {
	   pedido.removeBebida(pedidoBebida);
	}

	private void removeSaldoBebidas(Pedido pedido) {

		for (PedidoBebida pedidoBebida : pedido.getPedidoBebidas()) {
			Bebida bebida = pedidoBebida.getBebida();
			bebida.setSaldo(bebida.getSaldo() - pedidoBebida.getQuantidade());
		}
	}
	
	private void aplicaPromocaoBebidas(Pedido pedido) {
		boolean promocaoAgua = false;
		for (PedidoBebida pedidoBebida : pedido.getPedidoBebidas()) {
			if (pedidoBebida.getBebida() == Bebida.CERVEJA_1L) {
				if (pedidoBebida.getQuantidade() >= 6) {
					promocaoAgua = true;
				
					break;
				}
			}
		}
		
		if (promocaoAgua) {
			if (Bebida.AGUA.getSaldo() > 0) {
				pedido.adicionaBebida(new PedidoBebida(Bebida.AGUA, 1));
			} else {
				pedido.setValorTotal(pedido.getValorTotal() - Bebida.AGUA.getPreco());
			}
		}
	}

	private void aplicaComboPromocao(Pedido pedido) {
		boolean pizzaGrande = false;
		boolean pizzaBroto = false;
		boolean refrigeranteLata = false;

		for (PedidoBebida pedidoBebida : pedido.getPedidoBebidas()) {
			if (pedidoBebida.getBebida() == Bebida.REFRIGERANTE_LATA) {
				refrigeranteLata = true;
			}
		}

		for (PedidoPizza pedidoPizza : pedido.getPedidoPizzas()) {
			if (pedidoPizza.getTamanho() == Tamanho.GRANDE) {
			   
			   if (pedidoPizza.getPizzaUnica() != null) {
			      Categoria categoria = pedidoPizza.getPizzaUnica().getCategoria();
			      
			      if (categoria == Categoria.CLASSICA || categoria == Categoria.VEGETARIANA) {
			         pizzaGrande = true;
			      }
            }
            else {
               Pizza pizzaSabor1 = pedidoPizza.getPizzasSabores().get(0);
               Pizza pizzaSabor2 = pedidoPizza.getPizzasSabores().get(1);

               Categoria categoria1 = pizzaSabor1.getCategoria();
               Categoria categoria2 = pizzaSabor2.getCategoria();

               if ((categoria1 == Categoria.CLASSICA || categoria1 == Categoria.VEGETARIANA)
                   || (categoria2 == Categoria.CLASSICA || categoria2 == Categoria.VEGETARIANA)) {
                  pizzaGrande = true;
               }
            }
			}
			
			if (pedidoPizza.getTamanho() == Tamanho.BROTO) {
			   if (pedidoPizza.getPizzaUnica() != null) {
			      Categoria categoria = pedidoPizza.getPizzaUnica().getCategoria();

               if (categoria == Categoria.DOCE) {
			         pizzaBroto = true;
			      }
			   } else {
               Pizza pizzaSabor1 = pedidoPizza.getPizzasSabores().get(0);
               Pizza pizzaSabor2 = pedidoPizza.getPizzasSabores().get(1);

               Categoria categoria1 = pizzaSabor1.getCategoria();
               Categoria categoria2 = pizzaSabor2.getCategoria();

               if (categoria1 == Categoria.DOCE || categoria2 == Categoria.DOCE) {
                  pizzaBroto = true;
               }
			   }
			}
		}

		if (pizzaGrande && pizzaBroto && refrigeranteLata) {
			pedido.setValorTotal(pedido.getValorTotal() * 0.75);
		}
	}

	private void aplicaDescontoPrimeiraCompra(Pedido pedido) {
		pedido.setValorTotal(pedido.getValorTotal() * 0.9);
	}

	public double getValorTotalPedido(Pedido pedido) {
		double valorTotal = 0;
		double valorTotalBebidas = 0;
		double valorTotalPizzas = 0;
		for (PedidoBebida pedidoBebida : pedido.getPedidoBebidas()) {
			valorTotalBebidas += pedidoBebida.getQuantidade() * pedidoBebida.getBebida().getPreco();
		}

		for (PedidoPizza pedidoPizza : pedido.getPedidoPizzas()) {
			double valorPizzaPedido = 0;
			
			switch (pedidoPizza.getTamanho()) {
			case BIG:
				valorPizzaPedido += pedidoPizza.getMassa().getValorBig();
				break;
			case BROTO:
				valorPizzaPedido += pedidoPizza.getMassa().getValorBroto();
				break;
			case GRANDE:
				valorPizzaPedido += pedidoPizza.getMassa().getValorBroto();
				break;
			case MEDIA:
				valorPizzaPedido += pedidoPizza.getMassa().getValorMedia();
				break;
			default:
				break;
			}

			switch (pedidoPizza.getTamanho()) {
			case BIG:
				valorPizzaPedido += pedidoPizza.getBorda().getValorBig();
				break;
			case BROTO:
				valorPizzaPedido += pedidoPizza.getBorda().getValorBroto();
				break;
			case GRANDE:
				valorPizzaPedido += pedidoPizza.getBorda().getValorBroto();
				break;
			case MEDIA:
				valorPizzaPedido += pedidoPizza.getBorda().getValorMedia();
				break;
			default:
				break;
			}

			for (Adicional adicional : pedidoPizza.getAdicionais()) {
				switch (pedidoPizza.getTamanho()) {
				case BIG:
					valorPizzaPedido += adicional.getValorBig();
					break;
				case BROTO:
					valorPizzaPedido += adicional.getValorBroto();
					break;
				case GRANDE:
					valorPizzaPedido += adicional.getValorBroto();
					break;
				case MEDIA:
					valorPizzaPedido += adicional.getValorMedia();
					break;
				default:
					break;
				}
			}

			if (pedidoPizza.getPizzaUnica() != null) {
				valorPizzaPedido += getValorPizza(pedidoPizza, pedidoPizza.getPizzaUnica());
			} else {
			   Pizza pizzaSabor1 = pedidoPizza.getPizzasSabores().get(0);
            Pizza pizzaSabor2 = pedidoPizza.getPizzasSabores().get(1);
            
            double valorPizza1 = getValorPizza(pedidoPizza, pizzaSabor1);
            double valorPizza2 = getValorPizza(pedidoPizza, pizzaSabor2);
               
            if (valorPizza1 > valorPizza2) {
               valorPizzaPedido += valorPizza1;
            } else {
               valorPizzaPedido += valorPizza2;
            }
			}
			
			pedidoPizza.setValorTotal(valorPizzaPedido);
			valorTotalPizzas += valorPizzaPedido;
		}

		valorTotal = valorTotalBebidas + valorTotalPizzas;
		return valorTotal;
	}
	
	private double getValorPizza(PedidoPizza pedidoPizza, Pizza pizza) {
	   switch (pedidoPizza.getTamanho()) {
         case BIG:
            return pizza.getValorBig();
         case BROTO:
            return pizza.getValorBroto();
         case GRANDE:
            return pizza.getValorBroto();
         case MEDIA:
            return pizza.getValorMedia();
         default:
            return 0;
      }
	}

	private void aplicaValorTotalPedido(Pedido pedido) {
		pedido.setValorTotal(getValorTotalPedido(pedido));
	}

	private void aplicaValorTotalPedidoTelaPrincipal(PedidoTelaPrincipal pedidoTelaPrincipal, double valor) {
		pedidoTelaPrincipal.setValorTotal(pedidoTelaPrincipal.getValorTotal() + valor);
	}

	public List<PedidoTelaPrincipal> getPedidosTelaPrincipal() {
		pedidosTela.clear();

		for (PedidoCliente cliente : clientes) {
			List<Pedido> pedidosCliente = cliente.getPedidos();

			for (Pedido pedidoCliente : pedidosCliente) {

				boolean achouData = false;
				PedidoTelaPrincipal pedidoTelaData = null;

				for (PedidoTelaPrincipal pedidoTela : pedidosTela) {
					if (pedidoCliente.getData().equals(pedidoTela.getData())) {
						achouData = true;
						pedidoTelaData = pedidoTela;
					}
				}

				PedidoTelaPrincipal pedidoTelaPrincipal = null;

				if (achouData) {
					pedidoTelaPrincipal = pedidoTelaData;
				} else {
					pedidoTelaPrincipal = new PedidoTelaPrincipal();
					pedidosTela.add(pedidoTelaPrincipal);
					pedidoTelaPrincipal.setData(pedidoCliente.getData());
				}

				pedidoTelaPrincipal.setQuantidadePedidos(
						pedidoTelaPrincipal.getQuantidadePedidos() + pedidoCliente.getQuantidadePedidos());
				aplicaValorTotalPedidoTelaPrincipal(pedidoTelaPrincipal, pedidoCliente.getValorTotal());
			}
		}

		return new ArrayList<>(pedidosTela);
	}
	
	public Pizza getMaisConsumidoPorCategoria(Categoria categoria) {

	   Pizza maisConsumida = null;
	   int qtdMaisConsumida = 0;
	   Pizza[] todasPizzasCardapio = Pizza.values();
	   
      for (Pizza pizzaCardapio : todasPizzasCardapio) {
         
         if (pizzaCardapio.getCategoria() != categoria) {
            continue;
         }
         
         int qtdPizzaAtual = 0;
         
         for (PedidoCliente cliente : clientes) {
            List<Pedido> pedidosCliente = cliente.getPedidos();
            
            for (Pedido pedidoCliente : pedidosCliente) {
               List<PedidoPizza> pedidoPizzas = pedidoCliente.getPedidoPizzas();
               
               for (PedidoPizza pedidoPizza : pedidoPizzas) {
                  
                  if (pedidoPizza.getPizzaUnica() != null) {
                      if (pedidoPizza.getPizzaUnica() == pizzaCardapio) {
                         qtdPizzaAtual++;
                      }
                  } else {
                     Pizza pizzaSabor1 = pedidoPizza.getPizzasSabores().get(0);
                     Pizza pizzaSabor2 = pedidoPizza.getPizzasSabores().get(1);

                     if (pizzaSabor1 == pizzaCardapio || pizzaSabor2 == pizzaCardapio) {
                        qtdPizzaAtual++;
                     }
                  }
               }
            }
         }
         
         if (qtdPizzaAtual > qtdMaisConsumida) {
            qtdMaisConsumida = qtdPizzaAtual;
            maisConsumida = pizzaCardapio;
         }
      }
      
      return maisConsumida;
	}
	
	public double getPercentualMediaDiaria(String data) {
	   double lucroTotalBebida = 0;
	   double lucroTotalPizza = 0;
	   
	   for (PedidoCliente cliente : clientes) {
	      List<Pedido> pedidos = cliente.getPedidos();
	      for (Pedido pedido : pedidos) {
            if (!data.equals(pedido.getData())) {
               continue;
            }
            
            List<PedidoBebida> pedidoBebidas = pedido.getPedidoBebidas();
            List<PedidoPizza> pedidoPizzas = pedido.getPedidoPizzas();
            
            for (PedidoBebida pedidoBebida : pedidoBebidas) {
               double valorBebida = pedidoBebida.getBebida().getPreco() * pedidoBebida.getQuantidade();
               lucroTotalBebida += (valorBebida * 0.1);
            }
            
            for (PedidoPizza pedidoPizza : pedidoPizzas) {
               double valorPizza = 0;
               
               if (pedidoPizza.getPizzaUnica() != null) {
                  valorPizza = getValorPizza(pedidoPizza, pedidoPizza.getPizzaUnica());
               } else {
                  Pizza pizzaSabor1 = pedidoPizza.getPizzasSabores().get(0);
                  Pizza pizzaSabor2 = pedidoPizza.getPizzasSabores().get(1);
                  
                  double valorPizza1 = getValorPizza(pedidoPizza, pizzaSabor1);
                  double valorPizza2 = getValorPizza(pedidoPizza, pizzaSabor2);
                     
                  if (valorPizza1 > valorPizza2) {
                     valorPizza = valorPizza1;
                  } else {
                     valorPizza = valorPizza2;
                  }
               }
               
               lucroTotalPizza += valorPizza * 0.3;
            }
         }
      }
	   double lucroTotal = lucroTotalPizza + lucroTotalBebida;
	   
      return ( lucroTotal * 100 ) / 150;
	}

   public List<PedidoCliente> getClientes() {
      return new ArrayList<>(clientes);
   }
}
