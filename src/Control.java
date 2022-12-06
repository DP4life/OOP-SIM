public class Control {

	Model model;
	View view;
	public Control(Model _model, View _view){
		model = _model;
		view = _view;
	}

	public static void ViewExplorerInventory(Explorer explorer){
		View.DisplayExplorerInventory(explorer.getWeapon(), explorer.getArmor(), explorer.getInventory(), explorer.getInventoryIndex());
	}

	public static void ViewExplorerStats(Explorer explorer){
		View.DisplayExplorerStats(explorer.GetHealth(), explorer.getRadiation(), explorer.getThirst(), explorer.getHunger());
	}

	public static String ControlPrepare(Game game){
		return View.ViewPrepare(game);
	}
	
	public static void ControlEndPrepare(){
		View.ViewEndPrepare();
	}

	public void GameplayLoop(){
		//Gameplay Loop
		while(model.game.won == false){
			model.game.Setup();
			model.game.Prepare();
			// enemies[0].Interaction(explorer);
			while(model.explorer.died == false){
				model.game.Next();
				
			}
		}
	}
	
}
