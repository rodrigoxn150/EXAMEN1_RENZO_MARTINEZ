package com.example.demo.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name="Mallacurricular")
@Entity
public class MallaCurricular {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMalla;
	private String ano;
	@OneToOne(mappedBy = "mallacurricular")
	private Universidad universidad;
	@OneToMany(mappedBy = "mallacurricular")
	private List<Curso>curso=new ArrayList<Curso>();
	public Integer getIdMalla() {
		return idMalla;
	}
	public void setIdMalla(Integer idMalla) {
		this.idMalla = idMalla;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	
}
