package exercicio.interfaces;

import java.math.BigDecimal;
import java.time.LocalDate;
/**
 * 
 * @author Caio Silva
 *
 */
public class Jogador {

	private Long id;
	private String nome;
	private LocalDate dataNascimento;
	private Integer nivelHabilidade;
	private BigDecimal salario;
	private Long idTime;
	
	public Jogador(Long id, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario,
			Long idTime) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.nivelHabilidade = nivelHabilidade;
		this.salario = salario;
		this.idTime = idTime;
	}

	protected Long getId() {
		return id;
	}

	protected String getNome() {
		return nome;
	}

	protected LocalDate getDataNascimento() {
		return dataNascimento;
	}

	protected Integer getNivelHabilidade() {
		return nivelHabilidade;
	}

	protected BigDecimal getSalario() {
		return salario;
	}

	protected Long getIdTime() {
		return idTime;
	}
	
	
}
