package org.hibernate.herencia.model.single;

import jakarta.persistence.Entity;

@Entity
public class Externo extends Employee {

	private String empresa;

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	
	}
