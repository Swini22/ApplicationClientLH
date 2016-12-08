package application.client.controller;

import java.util.ArrayList;
import java.util.List;

import network.Message;
import network.client.ClientApplicationInterface;

public class MessageHandler implements ClientApplicationInterface  {
	
	List<MessageReceiverInterface> controllers = new ArrayList<MessageReceiverInterface>();
	
	@Override
	public void handleMessage(Message message) {
		for(MessageReceiverInterface controller :controllers){
			controller.handleMessage(message);
		}
	}
	
	public void register(MessageReceiverInterface controller) {
		controllers.add(controller);
	}
	
	public void unregister(MessageReceiverInterface controller) {
		controllers.remove(controller);
	}
}
