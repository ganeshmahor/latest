package model;

import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;

public interface Services {
	
	MessageResponse conversation(String txt);
	String textToSpeech(String txt,String path);
	void speechToText();
	
}
