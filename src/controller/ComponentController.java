package controller;

import domain.Locomotive;
import domain.Wagon;
import persistence.ComponentDao;
import persistence.ComponentOracleDaoImpl;
import ui.OutputPrinter;

public class ComponentController {
	ComponentDao cdao = new ComponentOracleDaoImpl();
	
	private OutputPrinter printer;
	
	public ComponentController(OutputPrinter printer) {
		this.printer = printer;
	}
	
	public boolean createLocomotive(String name) {
		Locomotive locomotive = new Locomotive(name);
		return cdao.createLocomotive(locomotive);
	}
	
	public boolean createWagonWithoutSeats(String name) {
		Wagon wagon = new Wagon(name, 20);
		return cdao.createWagon(wagon);
	}
	
	public boolean createWagon(String name, int seats) {
		Wagon wagon = new Wagon(name, seats);
		return cdao.createWagon(wagon);
	}
	
	public boolean addComponent(String trainName, String componentName) {
		return cdao.addComponent(trainName, componentName);
	}
	
	public boolean removeComponent(String trainName, String componentName) {
		return cdao.removeComponent(trainName, componentName);
	}
	
	public boolean deleteComponent(String componentName) {
		return cdao.deleteComponent(componentName);
	}
	
	public int getSeatsComponent(String name) {
		return cdao.getSeatsComponent(name);
	}
}
