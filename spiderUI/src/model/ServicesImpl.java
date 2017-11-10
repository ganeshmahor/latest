package model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.json.simple.JSONObject;

import com.ibm.watson.developer_cloud.conversation.v1.Conversation;
import com.ibm.watson.developer_cloud.conversation.v1.model.InputData;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;
import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.AudioFormat;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;
import com.ibm.watson.developer_cloud.text_to_speech.v1.util.WaveUtils;

public class ServicesImpl implements Services {
	
	
	@Override
	public MessageResponse conversation(String txt) {
		/*Conversation service = new Conversation(Conversation.VERSION_DATE_2017_05_26);
		service.setUsernameAndPassword("a48e6b3f-61f2-42b4-b709-0893adf04cb5",
		                               "sT8MrMxJCYSk");

		String workspaceId = "4fafd949-6f2c-48fb-8820-905c380ec546";*/		
		
		Conversation service = new Conversation(Conversation.VERSION_DATE_2017_05_26);
		service.setUsernameAndPassword("8df98e02-04ae-4af5-83b4-87c24e9d07ec",
                "BMkvbhANCuSg");
		String workspaceId = "a4801029-50ec-4ac1-9e65-629977887a17";

		InputData input = new InputData.Builder(txt).build();
		MessageOptions options = new MessageOptions.Builder(workspaceId).input(input).build();

		MessageResponse response = service.message(options).execute();
		return response;
	}

	@Override
	public String textToSpeech(String txt,String path) {		
		JSONObject obj = new JSONObject();
		
		TextToSpeech service = new TextToSpeech();
		service.setUsernameAndPassword("8c414fb3-8ace-4209-9368-f25a4d1890d3", "zCzky0Y1Vxe0");

		try {
			MessageResponse response = this.conversation(txt);
			System.out.println("path=" + path);
			String audioFileName="hello_world.wav";
			String fileName= path+"\\"+audioFileName;
			String text = response.getOutput().getText().get(0);
			//String text = "The brain is an organ that serves as the center of the nervous system in all vertebrate and most invertebrate animals. The brain is located in the head, usually close to the sensory organs for senses such as vision. The brain is the most complex organ in a vertebrate's body. In a human, the cerebral cortex contains approximately 15–33 billion neurons,[1] each connected by synapses to several thousand other neurons. These neurons communicate with one another by means of long protoplasmic fibers called axons, which carry trains of signal pulses called action potentials to distant parts of the brain or body targeting specific recipient cells.";
			//String text = "how do you do";
			
			
			obj.put("text", text);
			obj.put("audio", audioFileName);
			
			File file = new File(fileName);
			file.createNewFile(); // if file already exists will do nothing
			
			
		  InputStream stream = service.synthesize(text, Voice.EN_MICHAEL,
		    AudioFormat.WAV).execute();
		  InputStream in = WaveUtils.reWriteWaveHeader(stream);
		  OutputStream out = new FileOutputStream(fileName); 
		  byte[] buffer = new byte[1024];
		  int length;
		  while ((length = in.read(buffer)) > 0) {
		    out.write(buffer, 0, length);
		  }
		  out.close();
		  in.close();
		  stream.close();
		  
		}
		catch (Exception e) {
		  e.printStackTrace();
		}
		
	   return obj.toJSONString();

	}

	@Override
	public void speechToText() {

	}

}
