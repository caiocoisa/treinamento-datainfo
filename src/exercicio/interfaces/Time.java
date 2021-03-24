package exercicio.interfaces;

import java.time.LocalDate;

/**
 * 
 * @author Caio Silva
 *
 */
public class Time {

	private Long id;
	private String nome;
	private LocalDate dataCriacao;
	private String corUniformePrincipal;
	private String corUniformeSecundario;
	private Long idJogadorCapitao;
	
	public Time(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal,
			String corUniformeSecundario) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataCriacao = dataCriacao;
		this.corUniformePrincipal = corUniformePrincipal;
		this.corUniformeSecundario = corUniformeSecundario;
		this.idJogadorCapitao = 0L;
	}

	protected Long getId() {
		return id;
	}

	protected String getNome() {
		return nome;
	}

	protected LocalDate getDataCriacao() {
		return dataCriacao;
	}

	protected Long getIdJogadorCapitao() {
		return idJogadorCapitao;
	}
	
	protected void setIdJogadorCapitao(Long idJogadorCapitao) {
		this.idJogadorCapitao = idJogadorCapitao;
	}
	
}
