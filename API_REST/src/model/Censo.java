package model;

public class Censo {
	private String ciudad;
	private String pais;
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
}
