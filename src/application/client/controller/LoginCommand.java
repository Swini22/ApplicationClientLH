package application.client.controller;

import application.client.view.PlayGroundView;

public class LoginCommand extends Command{
	
	private PlayGroundView playGroundView;

	public LoginCommand(PlayGroundView playGroundView) {
		this.playGroundView = playGroundView;
	}


	@Override
	public void doCommand() { 
		if (checkLogin()){
			String text = playGroundView.getGameLog().getText();
			playGroundView.getGameLog().setText(text+ "User"+ 
			playGroundView.getLoginField().getText() +" has joined Game \n");
			playGroundView.updatePlayGroundView();
		}
	}

	
	private boolean checkLogin(){
		if (!playGroundView.getLoginField().getText().equals("")){
			return true;
		}else{
			return false;
		}
	}
}
