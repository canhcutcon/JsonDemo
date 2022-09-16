package Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

import entity.Address;
import entity.Person;
import entity.Phone;

public class Json2JavaPoJo {
	private static final String FILE_NAME = "json/people.json";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Person> persons = null;
		try {
			persons = getPerson(FILE_NAME);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		persons.forEach(p -> System.out.println(p));
	}
	
	private static String readFile(String fileName) throws Exception
	{
		File file = new File(fileName);
		 
        Reader reader = new FileReader(file);
        BufferedReader br = new BufferedReader(reader);
        
        String line;
        while((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
        return line;
        
	}

	private static List<Person> getPerson(String fileName) throws Exception {
		// TODO Auto-generated method stub
		List<Person> persons = new ArrayList<Person>();

		JsonReader reader = Json.createReader(new FileInputStream(new File(fileName)));
//		JsonObject o = reader.readObject();
//		
//		System.out.println(o);
//		JsonArray js = o.asJsonArray();
		JsonArray js = reader.read().asJsonArray();
		for (JsonValue jsonValue : js) {
			JsonObject jo = jsonValue.asJsonObject();

			// phone
			List<Phone> phones = new ArrayList<Phone>();
			JsonArray jAphone = jo.getJsonArray("phoneNumbers");
			for (JsonValue jsonValue2 : jAphone) {
				JsonObject joPh = jsonValue2.asJsonObject();
				Phone ph = new Phone(joPh.getString("type"), joPh.getString("number"));
				phones.add(ph);
			}

			// adress
			// Address
			JsonObject joAddr = jo.getJsonObject("address");
			Address addr = new Address(joAddr.getString("streetAddress"), joAddr.getString("city"),
					joAddr.getString("state"), joAddr.getInt("postalCode"));
			Person p = new Person(jo.getString("firstName"), jo.getString("lastName"), jo.getInt("age"), addr, phones);

			persons.add(p);

		}
		reader.close();

		return persons;
	}

}
