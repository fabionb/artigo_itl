package br.com.fnbrandao.artigo_itl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Test1Entity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TESTE1_SEQ")
	@SequenceGenerator(sequenceName = "TESTE1_SEQ", allocationSize = 1, name = "TESTE1_SEQ")
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
