package layers.objects;

import java.util.List;

import layers.db.SqlForumStorage;

public class Main {

	public static void main(String[] args) {
		SqlForumStorage storage = new SqlForumStorage();
		List<Category> categories = storage.findCategories();
		System.out.println(categories);
	}

}
