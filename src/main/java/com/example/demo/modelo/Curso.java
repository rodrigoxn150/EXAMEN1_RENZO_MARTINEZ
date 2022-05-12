package com.example.demo.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Table(name="Cursos")
@Entity
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCurso;
	private String curso;
    private String descripcion;
    @ManyToMany(mappedBy = "profesor", cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    
    private List<Profesor>profesor = new ArrayList<Profesor>() ;
   @JoinColumn(name="id_malla",nullable = false, unique = true, foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_malla) references Mallacurricular (id_malla)"))
   @ManyToOne
    private MallaCurricular mallacurricular;
	public Integer getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
  
    
}
