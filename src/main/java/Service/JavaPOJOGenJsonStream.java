package Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.json.Json;
import javax.json.stream.JsonGenerator;

import entity.Address;
import entity.Person;
import entity.Phone;

public class JavaPOJOGenJsonStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Phone> phones = Arrays.asList(new Phone("Mobil", "0912333444"), new Phone("Vietel", "0984444555"));
		Address addr = new Address("12 Nguyễn Văn Bảo, phường 4, Gò Vấp ", "HCM", "Việt Nam", 10000);
		Person p = new Person("John", "Tran", 30, addr, phones);

		System.out.println(p);
		JsonGenerator generator = null;
		try {
			generator = Json.createGenerator(new FileWriter("json/z.json"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		generator
		.writeStartObject()
			.write("firstName", "John")
			.write("lastName", "Smith")
			.write("age", 25)
				.writeStartObject("address")
				.write("streetAddress", "21 2nd Street")
				.write("city", "New York")
				.write("state", "NY")
				.write("postalCode", "10021")
			.writeEnd()
			.writeStartArray("phoneNumber")
				.writeStartObject()
				.write("type", "home")
				.write("number", "212 555-1234")
				.writeEnd()
				.writeStartObject()
				.write("type", "fax")
				.write("number", "646 555-4567")
				.writeEnd()
			.writeEnd()
		.writeEnd();
		generator.close();
	}

}
