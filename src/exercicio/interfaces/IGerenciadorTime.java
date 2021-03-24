package exercicio.interfaces;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface IGerenciadorTime {
  public void addTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario);

  public void addJogador(Long id, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario, Long idTime);

  public void setCapitao(Long idJogador);

  public Long getCapitao(Long idTime);

  public String getNomeJogador(Long idJogador);

  public String getNomeTime(Long idTime);

  public Long getJogadorMaiorSalario(Long idTime);

  public BigDecimal getSalario(Long idJogador);

  public List<Long> getJogadores(Long idTime);

  public Long getMelhorJogador(Long idTime);

  public Long getPiorJogador(Long idTime);

  public Long getJogadorMaisVelho(Long idTime);

  public List<Long> getTimes();
}