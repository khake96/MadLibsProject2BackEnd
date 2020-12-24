package com.revature.madlibs.utils;

import com.revature.madlibs.DAO.CompletedStoriesDAO;
import com.revature.madlibs.DAO.IncompletedStoriesDAO;
import com.revature.madlibs.DAO.LoginDAO;
import com.revature.madlibs.DAO.StoryCategoryDAO;
import com.revature.madlibs.DAO.UserDAO;
import com.revature.madlibs.DAO.UserLevelDAO;
import com.revature.madlibs.models.CompletedStories;
import com.revature.madlibs.models.IncompleteStories;
import com.revature.madlibs.models.Login;
import com.revature.madlibs.models.StoryCategory;
import com.revature.madlibs.models.User;
import com.revature.madlibs.models.UserLevel;

public class Driver {

	public static void main(String[] args) {
		
		UserDAO uDao = new UserDAO();
		LoginDAO loginDao = new LoginDAO();
		CompletedStoriesDAO csDao = new CompletedStoriesDAO();
		IncompletedStoriesDAO isDao = new IncompletedStoriesDAO();
		StoryCategoryDAO scDao = new StoryCategoryDAO();
		UserLevelDAO ulDao = new UserLevelDAO();
		

		CompletedStories cs = new CompletedStories(1, "it was the epoch of belief, it was the epoch of incredulity, it was the season of Light, it was the season of Darkness, it was the spring of hope, it was the winter of despair, we had everything before us, we had nothing before us, we were all going direct to heaven, we were all going direct the other way - in short, the period was so far like the present period, that some of its noisiest authorities insisted on its being received, for good or for evil, in the superlative degree of comparison only.",
				100, 2, 1);
		IncompleteStories is = new IncompleteStories(1, 2, 1, "It was the best of <<plural_n+1>>,"
				+ " it was the worst of <plural_n>, it was the age of wisdom, it was the age of "
				+ "<<plural_noun>>, it was the epoch of belief, it was the epoch of incredulity, "
				+ "it was the season of Light, it was the season of Darkness, it was the "
				+ "spring of hope, it was the winter of despair, we had everything before "
				+ "us, we had nothing before us, we were all <<verb>> direct to heaven,"
				+ " we were all <<verb>> direct the other way - in short, the period was so "
				+ "far like the present period, that some of its noisiest <<plural_noun>> "
				+ "insisted on its being received, for good or for evil, in the "
				+ "superlative degree of comparison only.", 5);
		Login login = new Login("JohnSmith", "password", 100);
		StoryCategory sc = new StoryCategory(1, "British Literature");
		User u = new User(100, "John", "Smith", 2000, 2, "john.smith@gmail.com");
		UserLevel ul = new UserLevel(1, "Rank Amateur");
		
		uDao.insert(u);
		loginDao.insert(login);
		csDao.insert(cs);
		isDao.insert(is);
		scDao.insert(sc);
		ulDao.insert(ul);
		
		System.out.println("Done");

	}

}
