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
		printer.print("RichRailCommand gestart");
	}
	
	public void enterNewtraincommand(@NotNull RichRailParser.NewtraincommandContext ctx) {
		if (ctx.getChild(1).toString().equals("train")) {
			tc.createTrain(ctx.getChild(2).toString());
		}
		System.out.println("type " + ctx.getChild(1));
		System.out.println("id " + ctx.getChild(2));
	}

	public void enterNewwagoncommand(@NotNull RichRailParser.NewwagoncommandContext ctx) {
		if (ctx.getChildCount() == 5) {
			cc.createWagon(ctx.getChild(2).toString(), Integer.parseInt(ctx.getChild(4).toString()));
		} else if (ctx.getChildCount() == 3) {
			cc.createWagonWithoutSeats(ctx.getChild(2).toString());
		}
		System.out.println("aantal childs " + ctx.getChildCount());
		System.out.println("child 0 " + ctx.getChild(0));
	}

	public void enterNewlocomotivecommand(@NotNull RichRailParser.NewlocomotivecommandContext ctx) {
		cc.createLocomotive(ctx.getChild(2).getText());
		System.out.println(ctx.getText());
	}

	public void enterAddcommand(@NotNull RichRailParser.AddcommandContext ctx) {
		cc.addComponent(ctx.getChild(3).toString(), ctx.getChild(1).toString());
		System.out.println("aantal childs " + ctx.getChildCount());
	}

	public void enterGetcommand(@NotNull RichRailParser.GetcommandContext ctx) {
		System.out.println(ctx.getText());
		System.out.println(ctx.getChild(0).getText());
		System.out.println(ctx.getChild(1).getText());
		System.out.println(ctx.getChild(2).getText());
		if (ctx.getChild(1).getText().toLowerCase().equals("train")) {
			System.out.println(tc.getSeatsTrain(ctx.getChild(2).toString()));
		} else if (ctx.getChild(1).getText().toLowerCase().equals("wagon")) {
			System.out.println(cc.getSeatsComponent(ctx.getChild(2).toString()));
		}
		System.out.println("aantal childs " + ctx.getChildCount());
	}

	public void enterDelcommand(@NotNull RichRailParser.DelcommandContext ctx) {
		System.out.println(ctx.getChildCount());
		System.out.println(ctx.getText());
		if (ctx.getChild(1).getText().toLowerCase().equals("wagon")) {
			cc.deleteComponent(ctx.getChild(2).getText());
		} else if (ctx.getChild(1).getText().toLowerCase().equals("train")) {
			tc.deleteTrain(ctx.getChild(2).getText());
		}
	}

	public void enterRemcommand(@NotNull RichRailParser.RemcommandContext ctx) {
		System.out.println(ctx.getChildCount());
		System.out.println(ctx.getText());
		cc.removeComponent(ctx.getChild(3).getText(), ctx.getChild(1).getText());
	}
}
