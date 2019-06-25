package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Censo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long indice;
	@Column
	private String ciudad;
	@Column
	private String pais;
	@Column
	private Integer poblacion;

	public Censo() {
	}

	public Censo(String ciudad, String pais, Integer poblacion) {
		super();
		this.ciudad = ciudad;
		this.pais = pais;
		this.poblacion = poblacion;
	}

	public Integer getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(Integer poblacion) {
		this.poblacion = poblacion;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	@Override
	public String toString() {
		return "Censo [idCenso=" + indice + ", ciudad=" + ciudad + ", pais=" + pais + ", poblacion=" + poblacion + "]";
	}
}
