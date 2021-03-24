package exercicio.interfaces;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Caio Silva
 * 
 */
public class Gestao implements IGerenciadorTime{
	
	protected List<Jogador> jogadores = new ArrayList<Jogador>();
	protected List<Time> times = new ArrayList<Time>();
	
	@Override
	public void addJogador(Long id, String nome, LocalDate dataNascimento, 
			Integer nivelHabilidade, BigDecimal salario,Long idTime) {
		Time time;
		
		time = getTimeById(idTime);
		
		if (!validarJogador(id)) {	
			Jogador novoJogador = new Jogador(id, nome, dataNascimento, 
					nivelHabilidade, salario, idTime);
			
			if (this.jogadores.add(novoJogador)) {
				System.out.println("Cadastro realizado!");
				
				// Valida se o time já possui um capitão
				if (time.getIdJogadorCapitao().equals(0L)) {
					
					// O primeiro jogador de cada time será o capitão default
					setCapitao(novoJogador.getId());
				}
			}else {
				System.out.println("Ocorreu um erro ao cadastrar!");
			}
			
		}else {
			System.err.println("ID Jogador já cadastrado!");
		}
	}
	
	@Override
	public void addTime(Long id, String nome, LocalDate dataCriacao, 
			String corUniformePrincipal, String corUniformeSecundario) {
		
		if (!validarTime(id)) {
			Time novoTime = new Time(id, nome, dataCriacao, corUniformePrincipal, 
					corUniformeSecundario);
			
			this.times.add(novoTime);
		}else {
			System.err.println("ID Time já cadastrado!");
		}
	}
	
	@Override
	public void setCapitao(Long idJogador) {
		Jogador novoCapitao;
		Time time;
		
		novoCapitao = getJogadorById(idJogador);
		time = getTimeById(novoCapitao.getIdTime());
		time.setIdJogadorCapitao(idJogador);
	}
	
	@Override
	public Long getCapitao(Long idTime) {
		Long idCapitao = null;
			
		idCapitao = getTimeById(idTime).getIdJogadorCapitao();
		
		return idCapitao;
	}
	
	@Override
	public String getNomeJogador(Long idJogador) {
		
		return getJogadorById(idJogador).getNome();
	}
	
	@Override
	public String getNomeTime(Long idTime) {
		
		return getTimeById(idTime).getNome();
	}
	
	@Override
	public Long getJogadorMaiorSalario(Long idTime) {
		List<Jogador> jogadoresDoTime = getJogadoresByTime(idTime);
		BigDecimal maiorSalario = new BigDecimal(0);
		Long idMaisBemPago = 0L;
		
		for (Jogador jogador : jogadoresDoTime) {
			if (jogador.getSalario().compareTo(maiorSalario) > 0) {
				idMaisBemPago = jogador.getId();
				maiorSalario = jogador.getSalario();
			}
		}
		return idMaisBemPago;
	}
	
	@Override
	public BigDecimal getSalario(Long idJogador) {
		try {
			return getJogadorById(idJogador).getSalario();
		} catch (Exception e) {
			System.err.println("     getSalario() throws ValidarJogadorException");
			return null;
		}
		
	}
	
	@Override
	public Long getMelhorJogador(Long idTime) {
		List<Jogador> jogadoresDoTime = getJogadoresByTime(idTime);
		Integer maiorHabilidade = 0;
		Long idMaisHabilidoso = 0L;
		
		for (Jogador jogador : jogadoresDoTime) {
			if (jogador.getNivelHabilidade().compareTo(maiorHabilidade) > 0) {
				maiorHabilidade = jogador.getNivelHabilidade();
				idMaisHabilidoso = jogador.getId();
			}
		}
		return idMaisHabilidoso;
	}
	
	@Override
	public Long getPiorJogador(Long idTime) {
		List<Jogador> jogadoresDoTime = getJogadoresByTime(idTime);
		Integer menorHabilidade = Integer.MAX_VALUE;
		Long idMenosHabilidoso = 0L;
		
		for (Jogador jogador : jogadoresDoTime) {
			if (jogador.getNivelHabilidade().compareTo(menorHabilidade) < 0) {
				menorHabilidade = jogador.getNivelHabilidade();
				idMenosHabilidoso = jogador.getId();
			}
		}
		return idMenosHabilidoso;
	}
	
	@Override
	public Long getJogadorMaisVelho(Long idTime) {
		List<Jogador> jogadoresDoTime = getJogadoresByTime(idTime);
		LocalDate dataNasc = LocalDate.of(9999, 12, 31);
		Long idMaisVelho = 0L;
		
		for (Jogador jogador : jogadoresDoTime) {
			if (jogador.getDataNascimento().compareTo(dataNasc) < 0) {
				dataNasc = jogador.getDataNascimento();
				idMaisVelho = jogador.getId();
			}
		}
		return idMaisVelho;
	}
	
	@Override
	public List<Long> getJogadores(Long idTime) {
		List<Long> listaJogadores = new ArrayList<Long>();
		
		for (Jogador jogador : jogadores) {
			if (jogador.getIdTime().equals(idTime)) {
				listaJogadores.add(jogador.getId());
			}
		}
		return listaJogadores;
	}
	
	@Override
	public List<Long> getTimes() {
		List<Long> idTimes = new ArrayList<Long>();
		
		for (Time time : times) {
			idTimes.add(time.getId());
		}
		return idTimes;
	}
	
	/**
	 * Busca todos o jogadores de um determinado time.
	 * 
	 * @param idTime
	 * @return retorna a lista de jogadores
	 */
	private List<Jogador> getJogadoresByTime(Long idTime) {
		List<Jogador> jogadoresDoTime = new ArrayList<Jogador>();
		
		for (Jogador jogador : jogadores) {
			if (jogador.getIdTime().equals(idTime)) {
				jogadoresDoTime.add(jogador);
			}
		}
		return jogadoresDoTime;
	}
	
	/**
	 * Busca um determinado time na lista de Times
	 * 
	 * @param idTime
	 * @return o time com id correspondente
	 * @throws ValidarTimeException 
	 */
	private Time getTimeById(Long idTime) {
		
		if (validarTime(idTime)) {
			for (Time time : times) {
				if (time.getId().equals(idTime)) {
					return time;
				}
			}
			
		}else {
			System.err.println("Time não cadastrado!");
		}
		return null;
	}
	
	/**
	 * Busca um determinado jogador na lista de jogadores
	 * 
	 * @param idJogador
	 * @return jogador correspondente
	 * @throws ValidarJogadorException 
	 */
	private Jogador getJogadorById(Long idJogador) {
		if (validarJogador(idJogador)) {
			for (Jogador jogador : jogadores) {
				if (jogador.getId().equals(idJogador)) {
					return jogador;
				}
			}	
		}else {
			System.err.println("   getJogadorById() throws ValidarJogadorException");
		}
		return null;
	}
	
	/**
	 * Valida se um determinado id de time existe
	 * 
	 * @param idTime
	 * @return boolean
	 * @throws ValidarTimeException 
	 */
	protected boolean validarTime(Long idTime) {
		if (this.times != null) {
			for (Time time : times) {
				if (time.getId().equals(idTime)) {
					return true;
				}
			}
		}else {
			System.err.println(" validarTime() throws ValidarJogadorException");
		}
		return false;
	}
	
	/**
	 * Valida se um determinado id de jogador existe
	 * 
	 * @param idJogador
	 * @return boolean
	 * @throws ValidarJogadorException 
	 */
	protected boolean validarJogador(Long idJogador) {
		if (this.jogadores != null) {
			for (Jogador jogador : jogadores) {
				if (jogador.getId().equals(idJogador)) {
					return true;
				}
			}
		}else {
			System.err.println(" validarJogador() throws ValidarJogadorException");
		}
		return false;
	}
}
