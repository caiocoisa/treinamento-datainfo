package exercicio.interfaces;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Programa {

	public static void main(String[] args) {

		LocalDate dataJ1 = LocalDate.of(1982, 2, 15);
		LocalDate dataJ2 = LocalDate.of(1984, 10, 29);
		LocalDate dataJ3 = LocalDate.of(1979, 11, 18);
		LocalDate dataJ4 = LocalDate.of(1983, 4, 22);
		
		LocalDate dataT1 = LocalDate.of(2021, 3, 1);
		
		Gestao gestao = new Gestao();
		
		gestao.getSalario(132L);
		
		gestao.addTime(901L, "Capivara FC", dataT1, "Azul", "Branco");
		
		gestao.addJogador(1L, "Carlinhos Bala", dataJ1, 90, new BigDecimal(110000), 901L);
		gestao.addJogador(2L, "Kuki", dataJ2, 92, new BigDecimal(185000), 901L);
		gestao.addJogador(3L, "Magrao", dataJ3, 91, new BigDecimal(95000), 901L);
		gestao.addJogador(4L, "Graffite", dataJ4, 99, new BigDecimal(122000), 901L);
		
//		System.out.println("Jogadores: "+gestao.getJogadores(901L));
//		
//		System.out.println("Mais Habilidoso: "+gestao.getMelhorJogador(901L));
//		
//		System.out.println("Menos Habilidoso: "+gestao.getPiorJogador(901L));
//		
//		System.out.println("Capitão: "+gestao.getCapitao(901L));
//		gestao.setCapitao(3L);
//		System.out.println("Capitão: "+gestao.getCapitao(901L));
//		
//		System.out.println("Nome jogador por ID: "+gestao.getNomeJogador(2L));
//		
//		System.out.println("Nome Time: "+gestao.getNomeTime(901L));
//		
//		System.out.println("Maior Salario: "+gestao.getJogadorMaiorSalario(901L));
//		
//		System.out.println("Mais Velho: "+gestao.getJogadorMaisVelho(901L));
//		
//		System.out.println("Salario jogador 3L: "+gestao.getSalario(3L));

	}

}
