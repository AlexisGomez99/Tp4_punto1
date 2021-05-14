package ar.edu.unrn.modelo;

public class Empleado implements CalculadorEmpresa{

	private String nombre;
	private int sueldoBase;
	private int adicional;
	private int descuentos;
	
	public Empleado(String nombre, int sueldoBase, int adicional, int descuentos) {
		super();
		this.nombre = nombre;
		this.sueldoBase = sueldoBase;
		this.adicional = adicional;
		this.descuentos = descuentos;
	}
	
	@Override
	public int calcularSueldo() {
		System.out.println(this.nombre);
		return this.sueldoBase + this.adicional - this.descuentos;
	}

	
	
	public int sueldoBase() {
		return sueldoBase;
	}

	public int adicional() {
		return adicional;
	}

	public int descuentos() {
		return descuentos;
	}

	@Override
	public int calcularTotalSueldoEmpresa() {
		return calcularSueldo();
	}
	
}
