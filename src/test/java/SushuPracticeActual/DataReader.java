package SushuPracticeActual;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
	
	public List<HashMap<String, String>> getJsonDataToMap() throws IOException{
		//read json to string
		String jsonContent = FileUtils.readFileToString(new File("//Users//prasa//eclipse-workspace//SeleniumFramework//src//test//java//SushuPracticeActual//Data"));
		//String to HashMap-JaksonDatbind
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){});
		return data;
	}

}
