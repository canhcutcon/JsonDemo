package Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;

import entity.Address;
import entity.Person;
import entity.Phone;

public class JavaPOJO2Json {
	private static final String FILE_NAME = "json/people.json";
	public static void main(String[] args) {
		List<Phone> phones = Arrays.asList(new Phone("Mobil", "0912333444"), new Phone("Vietel", "0984444555"));
		Address address = new Address("12 Nguyễn Văn Bảo, phường 4, Gò Vấp ", "HCM", "Việt Nam", 10000);
		Person p = new Person("John", "Tran", 30, address, phones);

		System.out.println(p);

		JsonObject json = toJson(p);
		System.out.println(json);
		try {
			export(FILE_NAME,json.asJsonArray());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void export(String fileName, JsonArray asJsonArray) throws FileNotFoundException {
		// TODO Auto-generated method stub
		PrintWriter out = new PrintWriter(new FileOutputStream(fileName), true);
		out.println(asJsonArray);
		out.close();
	}

	public static void export(String filePath, String json) throws Exception {
		PrintWriter out = new PrintWriter(new FileOutputStream(filePath), true);
		out.println(json);
		out.close();
	}

	private static JsonValue toJson(List<Phone> phoneNumbers) {
		JsonArrayBuilder builder = Json.createArrayBuilder();
		for (Phone ph : phoneNumbers) {
			builder.add(toJson(ph));
		}
		return builder.build();
	}

	private static JsonValue toJson(Address addr) {
		JsonObjectBuilder builder = Json.createObjectBuilder();
		return builder.add("streetAddress", addr.getStreetAdd()).add("city", addr.getCity())
				.add("state", addr.getState()).add("postalCode", addr.getPostalCode()).build();
	}

	private static JsonObject toJson(Person p) {

		JsonObjectBuilder builder = Json.createObjectBuilder();
		return builder.add("firstName", p.getFirstName()).add("lastName", p.getLastName()).add("age", p.getAge())
				.add("address", toJson(p.getAddress())).add("phoneNumbers", toJson(p.getPhoneNumbers())).build();

	}

	private static JsonValue toJson(Phone ph) {
		JsonObjectBuilder builder = Json.createObjectBuilder();
		return builder
				.add("type", ph.getType())
				.add("number", ph.getNumber())
				.build();
	}

	
}
