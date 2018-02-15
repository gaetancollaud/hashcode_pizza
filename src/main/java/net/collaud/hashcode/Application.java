package net.collaud.hashcode;

import java.util.Arrays;
import java.util.List;
import net.collaud.hashcode.common.writer.ZipSources;

/**
 *
 * @author Gaetan Collaud
 */
public class Application {

	public static void main(String[] args) {
		
		new Thread(new ZipSources("data/outputs/hashcode-2016.zip")
				.addFolder("src")
				.addFile("README.md")
				.addFile("pom.xml")
				.addFile("LICENSE")
				.addFile(".gitignore")
				.getRunnable())
				.start();
		
		List<String> files = Arrays.asList(
				"example",
				"small",
				"medium",
				"big"
				);
		
		files.parallelStream().forEach(f -> {
			String in = "data/inputs/"+f+".in";
			String out = "data/outputs/"+f+".out";
			new HashCodePizza(in, out).solve();
		});
		
	}
	
}
