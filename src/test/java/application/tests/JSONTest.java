package application.tests;

import org.apache.juneau.json.JsonParser;
import org.apache.juneau.json.JsonSerializer;
import org.apache.juneau.parser.ParseException;
import org.apache.juneau.serializer.SerializeException;

public class JSONTest {

	public static void main(String[] args) throws SerializeException, ParseException {
		String[] skill = {"Java", "JS", "C#", "Selenium", "Playwright"};
		Employee ep = new Employee("Satpal", 1234, "QA", skill);
		
		JsonSerializer js = JsonSerializer.DEFAULT_READABLE;
		String json = js.serialize(ep);
		System.out.println(json);
		
		JsonParser jp = JsonParser.DEFAULT;
		Employee ep1 = jp.parse(json, Employee.class);
		System.out.println(ep1.toString());
		
		
		
	}

}
