package ar.edu.unrn.modelo;

import java.util.ArrayList;
import java.util.List;

public class Encargado implements CalculadorEmpresa {
	private String rol;
	private List<CalculadorEmpresa> empleadosACargo= new ArrayList<CalculadorEmpresa>();
	private String nombre;
	private int sueldoBase;
	private int adicional;
	private int descuentos;
	
	public Encargado(String rol,String nombre, int sueldoBase, int adicional, int descuentos) {
		this.rol= rol;
		this.nombre = nombre;
		this.sueldoBase = sueldoBase;
		this.adicional = adicional;
		this.descuentos = descuentos;
	}
	
	@Override
	public int calcularSueldo() {
		System.out.println(this.nombre);
		System.out.println("cantidad de encargados: "+ empleadosACargo.size());
		return this.sueldoBase + empleadosACargo.size()*this.adicional - this.descuentos;
	}
	
	public int cantidadDeEmpleados() {
		
		return empleadosACargo.size();
	}
	public void agregarEmpleadoACargo(CalculadorEmpresa empleado) {
		empleadosACargo.add(empleado);
		
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
		int total= calcularSueldo();
		for(CalculadorEmpresa empleado: empleadosACargo) {
			total=total + empleado.calcularTotalSueldoEmpresa();
		}
		return total;
	}

}
