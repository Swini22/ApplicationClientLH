package application.client.controller;

import network.Message;

public interface MessageReceiverInterface {
	
	void handleMessage(Message msg);
}
