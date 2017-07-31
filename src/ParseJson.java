import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.json.JSONObject;

public class ParseJson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Path path = FileSystems.getDefault().getPath("", "YP_local_deals_2016-01-05.json");
		List<String> lines;
		try {
			lines = Files.readAllLines(path, StandardCharsets.US_ASCII);
			JSONObject j  = new JSONObject(lines.get(0));
			System.out.println(j.keySet().toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}

}
