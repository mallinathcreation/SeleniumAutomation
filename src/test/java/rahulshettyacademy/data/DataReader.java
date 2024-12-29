package rahulshettyacademy.data;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {


public List<HashMap<String, String>> getJasonDataToMap(String filePath) throws IOException

{
	//read Jason to string
	
	//@SuppressWarnings("deprecation")
	String jasonContent = FileUtils.readFileToString(new File(filePath));
	
	//Convert string to Hash Map (Get a dependncy Jackson DataBind)
	ObjectMapper mapper = new ObjectMapper();
	List <HashMap<String, String>> data = mapper.readValue(jasonContent, new TypeReference<List<HashMap<String, String>>>(){});

	return data;
	
}
}
