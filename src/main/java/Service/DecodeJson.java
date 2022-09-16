package Service;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.json.Json;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonReader;

import entity.Employee;

public class DecodeJson {

	public static void main(String[] args) throws Exception {
		InputStream in = new FileInputStream("json/emp.json");
		JsonReader reader = Json.createReader(in);
		JsonObject jo = reader.readObject();
		JsonNumber id = jo.getJsonNumber("10001");
		String name = jo.getString("Thân Thị Đẹt");
		JsonNumber sal = jo.getJsonNumber("10000d");
		Employee emp = new Employee(id.longValue(), name, sal.doubleValue());
		System.out.println(emp);
	}

}
