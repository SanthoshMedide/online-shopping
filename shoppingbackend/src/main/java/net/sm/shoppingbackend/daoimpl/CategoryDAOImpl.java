package net.sm.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.sm.shoppingbackend.dao.CategoryDAO;
import net.sm.shoppingbackend.dto.Category;


@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	private static List<Category> categories = new ArrayList<>(); 

	static {

		//adding 1st category
		Category category = new Category();
		category.setId(1);
		category.setName("Telivision");
		category.setDescription("desc for TV");
		category.setImageURL("CAT_1.png");
		categories.add(category);
		
		//adding 1st category
		category = new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("desc for Mob");
		category.setImageURL("CAT_2.png");
		categories.add(category);
		
		//adding 1st category
		category = new Category();
		category.setId(3);
		category.setName("Lappy");
		category.setDescription("desc for Lappy");
		category.setImageURL("CAT_3.png");
		categories.add(category);
	}


	public List<Category> list() {
		return categories;
	}


	@Override
	public Category get(int id) {
		for (Category category : categories) {
			if(category.getId()==id) {
				return category;
			}
		}
		return null;
	}

}
