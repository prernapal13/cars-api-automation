package cars.utilities;

import static java.nio.charset.StandardCharsets.ISO_8859_1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import gherkin.deps.com.google.gson.Gson;

public class ReadTestData {

	private static final String TEST_DATA_LOCATION = "./src/testdata/";

	public static CarResponse getCarResponseFromTestData(String filename) {
		return new Gson().fromJson(getText(filename), CarResponse.class);
	}

	private static String getText(String filename) {

		StringBuilder contentBuilder = new StringBuilder();
		String filepath = TEST_DATA_LOCATION + filename + ".txt";
		try (Stream<String> stream = Files.lines(Paths.get(filepath), ISO_8859_1)) {
			stream.forEach(s -> contentBuilder.append(s));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return contentBuilder.toString();
	}

}
