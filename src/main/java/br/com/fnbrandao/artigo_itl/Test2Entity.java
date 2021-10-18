package br.com.fnbrandao.artigo_itl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Test2Entity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TESTE2_SEQ")
	@SequenceGenerator(sequenceName = "TESTE2_SEQ", allocationSize = 1, name = "TESTE2_SEQ")
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
