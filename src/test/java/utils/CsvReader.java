package utils;

import java.io.*;
import java.util.*;

public class CsvReader {

	public static List<Map<String, String>> read(String filePath) {

		List<Map<String, String>> data = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//			try (FileReader fis = new FileReader(filePath);
//				     BufferedReader br = new BufferedReader(fis)) {
//
//				}
//			// 🔹 Read header
			String headerLine = br.readLine();
//			String[] headers = Arrays.stream(headerLine.split(",")).trim().toLowerCase().toArray(String[]::new);

			String[] headers = Arrays.stream(headerLine.split(",")).map(h -> h.replace("\uFEFF", "") // remove hidden
																										// BOM
					.trim().toLowerCase()).toArray(String[]::new);

			String line;

			while ((line = br.readLine()) != null) {

				if (line.trim().isEmpty())
					continue;

				// 🔥 DEBUG (remove later)
//				System.out.println("RAW LINE => " + line);
//				for (int i = 0; i < line.length(); i++) {
//					System.out.println(i + " -> " + (int) line.charAt(i));
//				}

				// 🔹 Split values
				String[] values = line.split(",");

				// 🔥 FIX: remove leading empty column if present
//				if (values.length > 0 && values[0].trim().isEmpty()) {
//					values = Arrays.copyOfRange(values, 1, values.length);
//				}

				// 🔹 Trim values
				//values = Arrays.stream(values).map(String::trim).toArray(String[]::new);

				// 🔹 Map row
				Map<String, String> row = new HashMap<>();

				for (int i = 0; i < headers.length; i++) {
					String value = (i < values.length) ? values[i] : "";
					row.put(headers[i], value);
				}

				data.add(row);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to read CSV", e);
		}

		return data;
	}
}