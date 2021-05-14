package ar.edu.unrn.test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import ar.edu.unrn.modelo.Empleado;
import ar.edu.unrn.modelo.Encargado;

public class CalculadorEmpresaTest {

	@Test
	public void verificarQueSeCalculaElSueloDeUnEmpleado() {
		//set up
		Empleado unEmpleado= new Empleado("Alexis", 13000, 200, 350);
		int resultado = unEmpleado.calcularSueldo();
		int esperado= 13000 + 200 - 350;
		
		assertEquals(esperado,resultado);
		
	}
	
	@Test
	public void verificarQueSeCalculaElSueloDeUnEncargadoSinPersonal() {
		//set up
		Encargado unEncargado= new Encargado("Director","Alexis", 13000, 200, 350);
		int resultado = unEncargado.calcularSueldo();
		int esperado= 13000 + unEncargado.cantidadDeEmpleados()*200 - 350;
		
		assertEquals(esperado,resultado);
		System.out.println("-----------------------------");
	}
	@Test
	public void verificarQueSeCalculaElSueloDeUnEncargadoConPersonal() {
		//set up
		Encargado unEncargado= new Encargado("Director","Alexis", 13000, 200, 350);
		Empleado unEmpleado1= new Empleado("Martin", 13000, 200, 350);
		Encargado unEmpleado2= new Encargado("Gerente","Maria", 16000, 200, 350);
		Empleado unEmpleado3= new Empleado("Lucas", 13000, 200, 350);
		unEncargado.agregarEmpleadoACargo(unEmpleado1);
		unEncargado.agregarEmpleadoACargo(unEmpleado2);
		unEncargado.agregarEmpleadoACargo(unEmpleado3);
		int resultado = unEncargado.calcularSueldo();
		int esperado= 13000 + unEncargado.cantidadDeEmpleados()*200 - 350;
		
		assertEquals(esperado,resultado);
		System.out.println("-----------------------------");
	}
	@Test
	public void calcularSueldoTotalDeLaEmpresa() {
		//set up
		Encargado unEncargado= new Encargado("Director","Alexis", 20000, 300, 350);
		Empleado unEmpleado1= new Empleado("Martin", 13000, 200, 350);
		Empleado unEmpleado2= new Empleado("Lucas", 13000, 200, 350);
		Encargado unEmpleado3= new Encargado("Gerente","Maria", 16000, 200, 350);
		Empleado unEmpleado4= new Empleado("Leonel", 13000, 200, 350);
		Empleado unEmpleado5= new Empleado("Sofia", 13000, 200, 350);
		unEmpleado3.agregarEmpleadoACargo(unEmpleado4);
		unEmpleado3.agregarEmpleadoACargo(unEmpleado5);
		unEncargado.agregarEmpleadoACargo(unEmpleado1);
		unEncargado.agregarEmpleadoACargo(unEmpleado2);
		unEncargado.agregarEmpleadoACargo(unEmpleado3);
		int resultado = unEncargado.calcularTotalSueldoEmpresa();
		int esperado= (13000*4 )+ 20000+16000+ (3* 300) + (2* 200)+ (4*200) - (350*6);
		
		assertEquals(esperado,resultado);
		System.out.println("-----------------------------");
	}
}
