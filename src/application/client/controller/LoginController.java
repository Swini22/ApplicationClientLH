package application.client.controller;

import network.Message;
import network.client.ServerProxy;

public class LoginController {
	
	private MessageHandler messageHandler;
	private ServerProxy serverProxy;

	public LoginController() {

		serverProxy = new ServerProxy(messageHandler) {
			@Override
			public void send(Message message) {
				// TODO Auto-generated method stub
				
			}
		};
	}
}
