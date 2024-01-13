package entrataDemo;   //package declaration

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EnterDataUtilityClass {
	public static String getpfdata(String key) throws IOException {  //This method is used to read data from a logindata.properties file
		FileInputStream file = new FileInputStream(
				"C:\\Users\\Admin\\eclipse-workspace\\entrata\\logindata.properties");
		Properties p = new Properties();
		p.load(file);
		String value = p.getProperty(key);
		return value;

	}
}
