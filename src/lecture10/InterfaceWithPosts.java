package lecture10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import base.BaseObject;

public class InterfaceWithPosts extends BaseObject {

	public static void main(String[] args) throws Exception {
		String user_posts = "/Users/dosapats/git/neu-sep-15/src/lecture10/user_posts";
		String user_posts_objects_file = "/Users/dosapats/git/neu-sep-15/src/lecture10/user_posts_objects";
		File file = new File(user_posts_objects_file);
		// Map<String, User> users = createUserPostsMap(file);
		Map<String, User> users = createUserPostsMapUsingObjects(file);
		System.out.println(users);
		while (true) {
			System.out
					.println("Enter the post in the format <User>:<Post> - Type quit to exit");
			String line = getLineFromConsole();
			if (line.equals("quit")) {
				break;
			}
			User u = createUser(line);
			System.out.println("Created User -> " + u.toString());
			User findUserFromMap = users.get(u.name);
			if (findUserFromMap == null) {
				users.put(u.name, u);
				continue;
			} else {
				findUserFromMap.posts.addAll(u.posts);
			}
		}
		// writePostsIntoFile(file, users);
		writePostsIntoFileUsingObject(file, users);
	}

	private static void writePostsIntoFileUsingObject(File file,
			Map<String, User> users) throws Exception {
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(users);
		fos.close();
		oos.close();
	}

	private static Map<String, User> createUserPostsMapUsingObjects(File file)
			throws Exception {
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			Map<String, User> map = (Map<String, User>) o;
			return map;
		} catch (Exception e) {
			System.out.println("Exception.. " + e);
			return new HashMap<String, User>();
		} finally {
			fis.close();
			if (ois != null)
				ois.close();
		}
	}

	private static void writePostsIntoFile(File file, Map<String, User> users)
			throws Exception {
		FileOutputStream fos = new FileOutputStream(file);
		PrintStream ps = new PrintStream(fos);
		for (User user : users.values()) {
			ps.println(user.toString());
		}
		fos.close();
		ps.close();
	}

	private static Map<String, User> createUserPostsMap(File file)
			throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(file)));
		Map<String, User> userMap = new HashMap<String, User>();
		while (true) {
			String line = br.readLine();
			if (line == null)
				break;
			User user = createUser(line);
			userMap.put(user.name, user);
		}
		return userMap;
	}

	private static User createUser(String line) {
		StringTokenizer st = new StringTokenizer(line, ":,");
		User user = new User();
		user.name = st.nextToken().trim();
		while (st.hasMoreTokens()) {
			user.posts.add(st.nextToken().trim());
		}
		return user;
	}

}
