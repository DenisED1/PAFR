package parser;

import org.antlr.v4.runtime.misc.NotNull;

import controller.ComponentController;
import controller.TrainController;

public class RichRailCommand extends RichRailBaseListener {
	ComponentController cc = new ComponentController();
	TrainController tc = new TrainController();
	public void enterNewtraincommand(@NotNull RichRailParser.NewtraincommandContext ctx) {
		if (ctx.getChild(1).toString().equals("train")) {
			tc.createTrain(ctx.getChild(2).toString());
		}
//		else if (ctx.getChild(1).toString().equals("wagon")) {
//			//checken of er een aantal seats mee wordt gegeven?
//			System.out.println("Command proc");
//			cc.createWagonWithoutSeats(ctx.getChild(2).toString());
//		} else if (ctx.getChild(1).toString().equals("locomotive")) {
//			cc.createLocomotive(ctx.getChild(2).toString());
//		}
		System.out.println("type " + ctx.getChild(1));
		System.out.println("id " + ctx.getChild(2));
	}
	
	public void enterNewwagoncommand(@NotNull RichRailParser.NewwagoncommandContext ctx) {
		if (ctx.getChildCount() == 5) {

		} else if (ctx.getChildCount() == 3) {

		}
		System.out.println("aantal childs " + ctx.getChildCount());
		System.out.println("child 0 " + ctx.getChild(0));
	}
}
