package controller;

import domain.Train;
import persistence.TrainDao;
import persistence.TrainOracleDaoImpl;
import ui.OutputPrinter;

public class TrainController {
	TrainDao tdao = new TrainOracleDaoImpl();

	private OutputPrinter printer;
	
	public TrainController(OutputPrinter printer) {
		this.printer = printer;
	}

	public boolean createTrain(String name) {
		Train train = new Train(name);
		if (tdao.createTrain(train)) {
			printer.print("Train created");
			return true;
		} else {
			return false;
		}
	}

	public boolean deleteTrain(String name) {
		return tdao.deleteTrain(name);
	}

	public int getSeatsTrain(String name) {
		return tdao.getSeatsTrain(name);
	}
}
