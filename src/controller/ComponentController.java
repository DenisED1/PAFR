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
		printer.print("ComponentController gestart");
	}
	
	public boolean createLocomotive(String name) {
		Locomotive locomotive = new Locomotive(name);
		if (cdao.createLocomotive(locomotive)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean createWagonWithoutSeats(String name) {
		System.out.println("createWagonWithoutSeats()");
		printer.print("Dit is een test");
		int seats = 20;
		Wagon wagon = new Wagon(name, seats);
		if (cdao.createWagon(wagon)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean createWagon(String name, int seats) {
		Wagon wagon = new Wagon(name, seats);
		if (cdao.createWagon(wagon)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean addComponent(String trainName, String componentName) {
		return cdao.addComponent(trainName, componentName);
	}
	
	public boolean removeComponent(String trainName, String componentName) {
		//place remove counter fixen
		return cdao.removeComponent(trainName, componentName);
	}
	
	public boolean deleteComponent(String componentName) {
		return cdao.deleteComponent(componentName);
	}
	
	public int getSeatsComponent(String name) {
		return cdao.getSeatsComponent(name);
	}
}
