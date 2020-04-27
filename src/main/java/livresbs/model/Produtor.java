package livresbs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "Produtores")
@NamedQueries({
	@NamedQuery(name = "Produtor.listarTodos",
			    query = "select p from Produtor p order by p.produtor"),
	@NamedQuery(name = "Produtor.consultarPorId",
    			query = "select p from Produtor p where p.id=?1")
})
@Entity
public class Produtor extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "Produtor")
	private String produtor;

	public Produtor() {
		super();
	}

	public String getProdutor() {
		return produtor;
	}

	public void setProdutor(String produtor) {
		this.produtor = produtor;
	}
	
}
