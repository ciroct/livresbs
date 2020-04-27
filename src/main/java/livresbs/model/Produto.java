package livresbs.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Table(name = "produtos")
@Entity
@NamedQueries({
	@NamedQuery(name = "Produto.listarTodos",
			    query = "select p from Produto p order by p.nome"),
	@NamedQuery(name = "Produto.consultarPorId",
                query = "select p from Produto p where p.id=?1"),
	@NamedQuery(name = "Produto.listarPorProdutor",
                query = "select p from Produto p where p.produtor=?1 order by p.nome")
})
public class Produto extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "nome", length = 255)
	private String nome;
	@Column(name = "categoria", length = 255)
	private String categoria;
	@Column(name = "unidade", length = 255)
	private String unidade;
	@Column(name = "preco")
	private Float preco;
	@Column(name = "prazo", length = 255)
	private String prazo;
	@Column(name = "previsao")
	@Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date previsao;
	@Column(name = "produtor", length = 255)
	private String produtor;
	@Column(name = "preco_produtor")
	private Float precoProdutor;
	@Column(name = "preco_mercado")
	private Float precoMercado;
	@Column(name = "preco_lojinha")
	private Float precoLojinha;
	@Column(name = "mensal")
	private Byte mensal;
	public Produto() {
		super();
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getUnidade() {
		return unidade;
	}
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	public Float getPreco() {
		return preco;
	}
	public void setPreco(Float preco) {
		this.preco = preco;
	}
	public String getPrazo() {
		return prazo;
	}
	public void setPrazo(String prazo) {
		this.prazo = prazo;
	}
	public Date getPrevisao() {
		return previsao;
	}
	public void setPrevisao(Date previsao) {
		this.previsao = previsao;
	}
	public String getProdutor() {
		return produtor;
	}
	public void setProdutor(String produtor) {
		this.produtor = produtor;
	}
	public Float getPrecoProdutor() {
		return precoProdutor;
	}
	public void setPrecoProdutor(Float precoProdutor) {
		this.precoProdutor = precoProdutor;
	}
	public Float getPrecoMercado() {
		return precoMercado;
	}
	public void setPrecoMercado(Float precoMercado) {
		this.precoMercado = precoMercado;
	}
	public Float getPrecoLojinha() {
		return precoLojinha;
	}
	public void setPrecoLojinha(Float precoLojinha) {
		this.precoLojinha = precoLojinha;
	}
	public Byte getMensal() {
		return mensal;
	}
	public void setMensal(Byte mensal) {
		this.mensal = mensal;
	}
	

}
