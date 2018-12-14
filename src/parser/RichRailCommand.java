package parser;

import org.antlr.v4.runtime.misc.NotNull;

import controller.ComponentController;
import controller.TrainController;
import ui.OutputPrinter;

public class RichRailCommand extends RichRailBaseListener {
	private ComponentController cc;
	private TrainController tc;

	private OutputPrinter printer;
	
	public RichRailCommand(OutputPrinter printer) {
		this.printer = printer;
		cc = new ComponentController(printer);
		tc = new TrainController(printer);
	}
	
	public void enterNewtraincommand(@NotNull RichRailParser.NewtraincommandContext ctx) {
		if (tc.createTrain(ctx.getChild(2).getText())) {
			printer.print("train " + ctx.getChild(2).getText() + " created");
		} else {
			printer.print("train " + ctx.getChild(2).getText() + " already exists");
		}
	}

	public void enterNewwagoncommand(@NotNull RichRailParser.NewwagoncommandContext ctx) {
		if (ctx.getChildCount() == 5) {
			if (cc.createWagon(ctx.getChild(2).getText(), Integer.parseInt(ctx.getChild(4).getText()))) {
				printer.print("wagon " + ctx.getChild(2).getText() + " created with " + ctx.getChild(4).getText() + " seats");
			} else {
				printer.print("wagon " + ctx.getChild(2).getText() + " already exists");
			}
		} else if (ctx.getChildCount() == 3) {
			if (cc.createWagonWithoutSeats(ctx.getChild(2).toString())) {
				printer.print("wagon " + ctx.getChild(2).getText() + " created");
			} else {
				printer.print("wagon " + ctx.getChild(2).getText() + " already exist");
			}
		}
	}

	public void enterNewlocomotivecommand(@NotNull RichRailParser.NewlocomotivecommandContext ctx) {
		if (cc.createLocomotive(ctx.getChild(2).getText())) {
			printer.print("locomotive " + ctx.getChild(2).getText() + " created");
		} else {
			printer.print("locomotive" + ctx.getChild(2).getText() + " already exists");
		}
	}

	public void enterAddcommand(@NotNull RichRailParser.AddcommandContext ctx) {
		if (cc.addComponent(ctx.getChild(3).getText(), ctx.getChild(1).getText())) {
			printer.print("component " + ctx.getChild(1).getText() + " added to train " + ctx.getChild(3).getText());
		} else {
			printer.print("component " + ctx.getChild(1).getText() + " or train " + ctx.getChild(3).getText() + " does not exist");
		}
	}

	public void enterGetcommand(@NotNull RichRailParser.GetcommandContext ctx) {
		if (ctx.getChild(1).getText().toLowerCase().equals("train")) {
			int seats = tc.getSeatsTrain(ctx.getChild(2).getText());
			if (seats != -1) {
				printer.print("number of seats in train " + ctx.getChild(2).getText() + ": " + seats);
			} else {
				printer.print("train " + ctx.getChild(2).getText() + " doesn't exist");
			}
		} else if (ctx.getChild(1).getText().toLowerCase().equals("wagon")) {
			int seats = cc.getSeatsComponent(ctx.getChild(2).getText());
			if (seats != -1) {
				printer.print("number of seats in wagon " + ctx.getChild(2).getText() + ": " + seats);
			} else {
				printer.print("wagon " + ctx.getChild(2).getText() + "doesn't exist");
			}
		}
	}

	public void enterDelcommand(@NotNull RichRailParser.DelcommandContext ctx) {
		if (ctx.getChild(1).getText().toLowerCase().equals("wagon")) {
			if (cc.deleteComponent(ctx.getChild(2).getText())) {
				printer.print("wagon " + ctx.getChild(2).getText() + " deleted");
			} else {
				printer.print("wagon" + ctx.getChild(2).getText() + " is being used in a train");
			}
		} else if (ctx.getChild(1).getText().toLowerCase().equals("train")) {
			if (tc.deleteTrain(ctx.getChild(2).getText())) {
				printer.print("train " + ctx.getChild(2).getText() + " deleted");
			} else {
				printer.print("train " + ctx.getChild(2).getText() + " doesn't exist");
			}
		}
	}

	public void enterRemcommand(@NotNull RichRailParser.RemcommandContext ctx) {
		if (cc.removeComponent(ctx.getChild(3).getText(), ctx.getChild(1).getText())) {
			printer.print("component " + ctx.getChild(1).getText() + " removed from train " + ctx.getChild(3).getText());
		} else {
			printer.print("component " + ctx.getChild(1).getText() + " was not connected to train " + ctx.getChild(3).getText());
		}
	}
}
