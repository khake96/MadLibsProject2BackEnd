package com.revature.madlibs.utils;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

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
		
		UserLevelDAO ulDao = new UserLevelDAO();
		UserDAO uDao = new UserDAO();
		LoginDAO loginDao = new LoginDAO();
		StoryCategoryDAO scDao = new StoryCategoryDAO();
		IncompletedStoriesDAO isDao = new IncompletedStoriesDAO();
		CompletedStoriesDAO csDao = new CompletedStoriesDAO();

		UserLevel ul = new UserLevel("Rank Amateur");
		User u = new User("John", "Smith", 2000, ul, "john.smith@gmail.com", Date.valueOf(LocalDate.now()));
		Login login = new Login("JohnSmith", "password", u);
		StoryCategory sc = new StoryCategory("British Literature");
		IncompleteStories is = new IncompleteStories(ul, sc, "It was the best of <<plural_n+1>>,"
				+ " it was the worst of <plural_n>, it was the age of wisdom, it was the age of "
				+ "<<plural_noun>>, it was the epoch of belief, it was the epoch of incredulity, "
				+ "it was the season of Light, it was the season of Darkness, it was the "
				+ "spring of hope, it was the winter of despair, we had everything before "
				+ "us, we had nothing before us, we were all <<verb>> direct to heaven,"
				+ " we were all <<verb>> direct the other way - in short, the period was so "
				+ "far like the present period, that some of its noisiest <<plural_noun>> "
				+ "insisted on its being received, for good or for evil, in the "
				+ "superlative degree of comparison only.", "Charles", "Dickens", 5);
		CompletedStories cs = new CompletedStories("it was the epoch of belief, it was the epoch of incredulity, it was the season of Light, it was the season of Darkness, it was the spring of hope, it was the winter of despair, we had everything before us, we had nothing before us, we were all going direct to heaven, we were all going direct the other way - in short, the period was so far like the present period, that some of its noisiest authorities insisted on its being received, for good or for evil, in the superlative degree of comparison only.",
				u, 2, is, Date.valueOf(LocalDate.now()));

		
		ulDao.insert(ul);
		uDao.insert(u);
		loginDao.insert(login);
		scDao.insert(sc);
		isDao.insert(is);
		csDao.insert(cs);
		
		List<StoryCategory> categoryList = scDao.findAll();
		
		System.out.println("user: "+ uDao.selectById(1));
		System.out.println("empty story: "+ uDao.selectById(1));
		System.out.println("completed story: "+csDao.selectById(1));
		
		
		System.out.println("Done");
//		HibernateUtilities.closeSession();

	}

}
