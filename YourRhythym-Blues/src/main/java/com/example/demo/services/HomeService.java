package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Category;
import com.example.demo.models.Product;
import com.example.demo.models.User;
import com.example.demo.models.Vendor;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.repositories.VendorRepository;

@Service
public class HomeService {

	@Autowired
	private UserRepository uRepo;
	@Autowired
	private VendorRepository vRepo;
	
	@Autowired 
	private CategoryRepository cRepo;
	@Autowired
	private ProductRepository pRepo;

	public @Valid Vendor createVendor(@Valid Vendor vendor) {
		// TODO Auto-generated method stub
		String hashed = BCrypt.hashpw(vendor.getPassword(), BCrypt.gensalt());
		vendor.setPassword(hashed);
		return vRepo.save(vendor);
	}

	public User createUser(@Valid User user) {
		// TODO Auto-generated method stub
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return uRepo.save(user);
	}

	public boolean authenticateUser(String email, String password) {
		User user = uRepo.findByEmail(email);
		if (user == null) {
			return false;
		} else {
			if (BCrypt.checkpw(password, user.getPassword())) {
				return true;
			} else {
				return false;
			}
		}
	}

	public User findUserById(Long id) {
		// TODO Auto-generated method stub
		return uRepo.findById(id).orElse(null);
	}

	public @Valid User findByEmail(String email) {
		// TODO Auto-generated method stub
		return uRepo.findByEmail(email);
	}

	public @Valid User updateUser(Long id, User user) {
		// TODO Auto-generated method stub
		List<User> users = (List<User>) uRepo.findAll();
		for (User u: users) {
			if (u.getId()==id) {
				u = user;
				 return uRepo.save(u);
			}
		}
		return null;

	}

	public @Valid Category addCategory(@Valid Category category) {
		// TODO Auto-generated method stub
		return cRepo.save(category);
	}

	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		return pRepo.save(product);
	}

	public List<Category> AllCategories() {
		// TODO Auto-generated method stub
		return (List<Category>) cRepo.findAll();
	}

	public Vendor findVendor(Long id) {
		// TODO Auto-generated method stub
		return vRepo.findById(id).orElse(null);
	}

	
		public boolean authenticateVendor(String email, String password) {
			Vendor vendor = vRepo.findByEmail(email);
			if (vendor == null) {
				return false;
			} else {
				if (BCrypt.checkpw(password, vendor.getPassword())) {
					return true;
				} else {
					return false;
				}
			}
		}

		public @Valid Vendor findByVendorEmail(String email) {
			// TODO Auto-generated method stub
			return vRepo.findByEmail(email);
		}

		public void createDirectory(String imgdir) {
			// TODO Auto-generated method stub
			
		}

		public Category findCategory(Long cid) {
			// TODO Auto-generated method stub
			return cRepo.findById(cid).orElse(null);
		}

		public List<Product> findAllProducts() {
			// TODO Auto-generated method stub
			return (List<Product>) pRepo.findAll();
		}

		public Product findProduct(Long id) {
			// TODO Auto-generated method stub
			return pRepo.findById(id).orElse(null);
		}

		public List<Category> findCategories() {
			// TODO Auto-generated method stub
			return (List<Category>) cRepo.findAll();
		}

		public List<Product> findProductByCategory(Category cat) {
			// TODO Auto-generated method stub
			return pRepo.findAllByCategory(cat);
		}
	
}
