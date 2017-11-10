package samples;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ServicesImpl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibm.watson.developer_cloud.conversation.v1.Conversation;
import com.ibm.watson.developer_cloud.conversation.v1.model.InputData;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;
import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.AudioFormat;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;
import com.ibm.watson.developer_cloud.text_to_speech.v1.util.WaveUtils;

@Controller
@RequestMapping("/ajax")
public class AjaxController {

	private static final int BUFFER_SIZE = 4096;
	
	@RequestMapping(value = "/hello", method = RequestMethod.POST)
	@ResponseBody
	public String hello(ModelMap model) {

		return "hello";
	}
	
	
	@RequestMapping(value = "/mic", method = RequestMethod.GET)
	public String mic(ModelMap model) {

		return "mic2";
	}
	
/*	@RequestMapping(value = "/mic",method = RequestMethod.GET)
	public String printHello(ModelMap model) {
	      model.addAttribute("message", "Hello Spring MVC Framework!");
	      return "hello";
	   }
*/
	

	@RequestMapping(value = "/textToText", method = RequestMethod.POST)
	@ResponseBody
	public String textToText(@RequestParam("userReq") String userReq) {
		System.out.println("in test to text req=" + userReq);
		Conversation service = new Conversation(
				Conversation.VERSION_DATE_2017_05_26);
		service.setUsernameAndPassword("a48e6b3f-61f2-42b4-b709-0893adf04cb5",
				"sT8MrMxJCYSk");

		String workspaceId = "4fafd949-6f2c-48fb-8820-905c380ec546";

		InputData input = new InputData.Builder(userReq).build();
		MessageOptions options = new MessageOptions.Builder(workspaceId).input(
				input).build();

		MessageResponse response = service.message(options).execute();

		System.out.println(response);
		return response.toString();
	}

	@RequestMapping(value = "/textToSpeech", method = RequestMethod.POST)
	@ResponseBody
	public String textToSpeech(@RequestParam("userReq") String userReq) {

		System.out.println("in textToSpeech req=" + userReq);
		Conversation service = new Conversation(
				Conversation.VERSION_DATE_2017_05_26);
		service.setUsernameAndPassword("a48e6b3f-61f2-42b4-b709-0893adf04cb5",
				"sT8MrMxJCYSk");

		String workspaceId = "4fafd949-6f2c-48fb-8820-905c380ec546";

		InputData input = new InputData.Builder(userReq).build();
		MessageOptions options = new MessageOptions.Builder(workspaceId).input(
				input).build();

		MessageResponse response = service.message(options).execute();

		System.out.println(response.getOutput().getText());
		// return response.toString();
		TextToSpeech textToSpeech = new TextToSpeech();
		service.setUsernameAndPassword("8c414fb3-8ace-4209-9368-f25a4d1890d3",
				"zCzky0Y1Vxe0");

		try {
			String text = "This class teaches you how to build your first Android app..";
			InputStream stream = textToSpeech.synthesize(text,
					Voice.EN_MICHAEL, AudioFormat.WAV).execute();
			InputStream in = WaveUtils.reWriteWaveHeader(stream);
			OutputStream out = new FileOutputStream("hello_world.wav");
			byte[] buffer = new byte[1024];
			int length;
			while ((length = in.read(buffer)) > 0) {
				out.write(buffer, 0, length);
			}
			out.close();
			in.close();
			stream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "textToSpeech";
	}

	@RequestMapping(value = "/speechToText", method = RequestMethod.POST)
	@ResponseBody
	public String speechToText(ModelMap model) {

		return "speechToText";
	}

	@RequestMapping(value = "/speechToSpeech", method = RequestMethod.POST)
	@ResponseBody
	public String speechToSpeech(HttpServletRequest request,
			@RequestParam("userReq") String userReq) throws IOException {
		System.out.println(userReq);
		ServletContext servletContext;
		// String path =
		// request.getSession().getServletContext().getRealPath("/WEB-INF/audio/");
		//String path = request.getSession().getServletContext().getRealPath("/resources/audio");
		String path = request.getSession().getServletContext().getRealPath("WEB-INF/audio");
		
		/*File file = new File(path+File.separator+"text.txt");
		file.createNewFile(); 
		file.getPath();*/
		
		ServicesImpl s = new ServicesImpl();
		String output=s.textToSpeech(userReq, path);
		return output;
	}

	
	
	@RequestMapping(value = "/downloadSpeech", method = RequestMethod.GET)
	@ResponseBody
	public void downloadSpeech(HttpServletRequest request,
            HttpServletResponse response,@RequestParam("userReq") String fileName) throws IOException {
		String filePath=""+fileName;
		 // get absolute path of the application
        ServletContext context = request.getServletContext();
        String appPath = context.getRealPath("WEB-INF/audio"); 
        // construct the complete absolute path of the file
        String fullPath = appPath+ File.separator + filePath;    
        System.out.println("appPath = " + fullPath);
        File downloadFile = new File(fullPath);
        FileInputStream inputStream = new FileInputStream(downloadFile);
         
        // get MIME type of the file
        String mimeType = context.getMimeType(fullPath);
        if (mimeType == null) {
            // set to binary type if MIME mapping not found
            mimeType = "audio/x-wav"; //"text/plain";//"audio/x-wav"; //"application/octet-stream";
            
        }
        System.out.println("MIME type: " + mimeType);
 
        // set content attributes for the response
        response.setContentType(mimeType);
        response.setContentLength((int) downloadFile.length());
 
        // set headers for the response
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",
                downloadFile.getName());
        response.setHeader(headerKey, headerValue);
 
        // get output stream of the response
        OutputStream outStream = response.getOutputStream();
 
        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead = -1;
 
        // write bytes read from the input stream into the output stream
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }
 
        inputStream.close();
        outStream.close();
		
	}
	
	
	
	
	
	 /*@RequestMapping("/stream")
	    public StreamingResponseBody handleRequest () {

		 	System.out.println("Stream");
	        return new StreamingResponseBody() {
	            @Override
	            public void writeTo (OutputStream out) throws IOException {
	                for (int i = 0; i < 1000; i++) {
	                    out.write((Integer.toString(i) + " - ")
	                                        .getBytes());
	                    out.flush();
	                    try {
	                        Thread.sleep(5);
	                    } catch (InterruptedException e) {
	                        e.printStackTrace();
	                    }
	                }
	            }
	        };
	    }*/
	
	/*@RequestMapping(value = "/stream", method = RequestMethod.GET,
	        produces = { MediaType.APPLICATION_OCTET_STREAM_VALUE })
	public HttpEntity<byte[]> speechToSpeech(HttpServletRequest request,
			@RequestParam("userReq") String userReq,
	         HttpServletResponse response) throws IOException,
	        ServletException {
	    System.out.println("[GroupListController downloadRecipientFile]");
	    
	    System.out.println(userReq);
		ServletContext servletContext;
		// String path =
		// request.getSession().getServletContext().getRealPath("/WEB-INF/audio/");
		String path = request.getSession().getServletContext().getRealPath("/");
		String path1 = request.getSession().getServletContext().getContextPath();
		System.out.println("path1=" + path1);
		ServicesImpl s = new ServicesImpl();
		s.textToSpeech("Hello", path);
	    
	    VoiceAudioLibrary dGroup = audioClipService.findAudioClip(id);
	    if (dGroup == null || dGroup.getAudioData() == null
	            || dGroup.getAudioData().length <= 0) {
	        throw new ServletException("No clip found/clip has not data, id="
	                + id);
	    }
	    HttpHeaders header = new HttpHeaders();
	   
	    //header.setContentType(new MediaType("audio", "mp3"));
	    header.setContentType(new MediaType("audio", "vnd.wave");
	    header.setContentLength(dGroup.getAudioData().length);
	    return new HttpEntity<byte[]>(dGroup.getAudioData(), header);
	}
	*/
	

}
