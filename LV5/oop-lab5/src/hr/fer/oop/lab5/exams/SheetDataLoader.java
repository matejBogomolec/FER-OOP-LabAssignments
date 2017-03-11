package hr.fer.oop.lab5.exams;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SheetDataLoader 
{
	public SheetDataLoader() throws IOException 
	{
		
	}
	public static List<SheetData> loadSheets(Path path) throws IOException
	{
		List<SheetData> list = new ArrayList<SheetData>();
		List<String> lines = Files.readAllLines( path, StandardCharsets.UTF_8);
		for (String c : lines)
		{
			String [] data = c.split("\t", 3);
			SheetData pom = new SheetData(data[0], data[1], Arrays.asList(data[2].split("\t")));
			list.add(pom);
		}
		return list;
	}
	
	public static Map<String, String[]> loadCorrectAnswers(Path path) throws IOException
	{
		Map<String, String[]> map = new LinkedHashMap<String, String[]>();
		List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_16);
		for (String c : lines)
		{
			String [] data = c.split("\t", 2);
			map.put(data[0], data[1].split("\t"));
		}
		return map;
	}
}

