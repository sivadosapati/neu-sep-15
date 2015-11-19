package lecture10;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class User implements Serializable {
	public String name;
	public Collection<String> posts = new ArrayList<String>();

	public String toString() {
		return name + ":" + convertPostsToCSV();
	}

	private String convertPostsToCSV() {
		StringBuilder builder = new StringBuilder();
		for (String p : posts) {
			builder.append(p + ",");
		}
		return builder.toString();
	}
}
