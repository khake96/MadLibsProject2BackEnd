package madlibs;

//This class runs unit tests on the service layer of our Literary Madlibs project. The CI is
//handled through Jenkins and thus tests are run each time code is pushed to the repository
//prior to building and deploying on our AWS EC2.

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Timestamp;

import org.junit.jupiter.api.Test;

import com.revature.madlibs.Logger;
import com.revature.madlibs.models.CompletedStories;
import com.revature.madlibs.models.IncompleteStories;
import com.revature.madlibs.models.Login;
import com.revature.madlibs.models.StoryCategory;
import com.revature.madlibs.models.User;
import com.revature.madlibs.models.UserLevel;
import com.revature.madlibs.service.ServiceLogic;


class TestServiceLayer {
	
	ServiceLogic userActions = new ServiceLogic();
	Timestamp ts = new Timestamp(0);
	Logger logger = new Logger();

	// Initializing parameters to be used during testing for passing and failing cases.
	
	StoryCategory storyCatValid = new StoryCategory(1,"British Literature");
	UserLevel userLevelValid = new UserLevel(1, "Raw Amateur");
	UserLevel userLevelInvalid = new UserLevel(12, "Invalid");
	User userValid = new User("Jonathan", "Ministerial", 1987, userLevelValid, "jonathan234.heavy@email.com");
	User userInvalidDob = new User("Jonathan", "Ministerial", 102, userLevelValid, "jonathan234.heavy@email.com");
	User userInvalidFirstName = new User("", "Ministerial", 1987, userLevelValid, "jonathan234.heavy@email.com");
	User userInvalidLastName = new User("Jonathan", " ", 1987, userLevelValid, "jonathan234.heavy@email.com");
	User userInvalidEmail = new User("Jonathan", "Ministerial", 1987, userLevelValid, "jonathan234.heavy@emailcom");
	IncompleteStories incomStorValid = new IncompleteStories(1, userLevelValid, storyCatValid,"It was the best of times, it was the worst "
			+ "of times, it was the age of wisdom, it was the age of foolishness, it was the epoch of belief, it was the epoch of "
			+ "incredulity, it was the season of Light, it was the season of Darkness, it was the spring of hope, it was the winter "
			+ "of despair, we had everything before us, we had nothing before us, we were all going direct to heaven,we were all "
			+ "going direct the other way - in short, the period was so far like the present period, that some of its noisiest "
			+ "authorities insisted on its being received, for good or for evil, in the superlative degree of comparison only.", 
			"A Tale of Two Cities", 
			"It was the best of <<pn>>, it was the worst of times, it was the age of <<pn>>, it was the age of "
					+ "foolishness, it was the epoch of <<pn>>, it was the epoch of incredulity, it was the season of Light, it was"
					+ "the season of Darkness, it was the spring of hope, it was the winter of despair, we had everything before "
					+ "us, we had nothing before us, we were all going direct to heaven,we were all going direct the other way "
					+ "- in short, the period was so far like the present period, that some of its noisiest authorities insisted"
					+ " on its being received, for good or for evil, in the superlative degree of comparison only.", 
					"Charlse", 
					"Dickens", 3);
	CompletedStories comStoryValid = new CompletedStories("It was the best of <<hippos>>, it was the worst of times, it was the age of <<prime ministers>>, it was the age of "
					+ "foolishness, it was the epoch of <<toilets>>, it was the epoch of incredulity, it was the season of Light, it was"
					+ "the season of Darkness, it was the spring of hope, it was the winter of despair, we had everything before "
					+ "us, we had nothing before us, we were all going direct to heaven,we were all going direct the other way "
					+ "- in short, the period was so far like the present period, that some of its noisiest authorities insisted"
					+ " on its being received, for good or for evil, in the superlative degree of comparison only.", userValid, 3, incomStorValid);
	CompletedStories comStoryInvalidFirstName = new CompletedStories("It was the best of <<hippos>>, it was the worst of times, it was the age of <<prime ministers>>, it was the age of "
			+ "foolishness, it was the epoch of <<toilets>>, it was the epoch of incredulity, it was the season of Light, it was"
			+ "the season of Darkness, it was the spring of hope, it was the winter of despair, we had everything before "
			+ "us, we had nothing before us, we were all going direct to heaven,we were all going direct the other way "
			+ "- in short, the period was so far like the present period, that some of its noisiest authorities insisted"
			+ " on its being received, for good or for evil, in the superlative degree of comparison only.", userInvalidFirstName, 3, incomStorValid);
	CompletedStories comStoryInvalidLastName = new CompletedStories("It was the best of <<hippos>>, it was the worst of times, it was the age of <<prime ministers>>, it was the age of "
			+ "foolishness, it was the epoch of <<toilets>>, it was the epoch of incredulity, it was the season of Light, it was"
			+ "the season of Darkness, it was the spring of hope, it was the winter of despair, we had everything before "
			+ "us, we had nothing before us, we were all going direct to heaven,we were all going direct the other way "
			+ "- in short, the period was so far like the present period, that some of its noisiest authorities insisted"
			+ " on its being received, for good or for evil, in the superlative degree of comparison only.", userInvalidLastName, 3, incomStorValid);
	CompletedStories comStoryShortStory = new CompletedStories("The superlative degree of comparison only.", userValid, 3, incomStorValid);
	IncompleteStories incomStoryInvalidBookTitle = new IncompleteStories(1, userLevelValid, storyCatValid,"It was the best of times, it was the worst "
			+ "of times, it was the age of wisdom, it was the age of foolishness, it was the epoch of belief, it was the epoch of "
			+ "incredulity, it was the season of Light, it was the season of Darkness, it was the spring of hope, it was the winter "
			+ "of despair, we had everything before us, we had nothing before us, we were all going direct to heaven,we were all "
			+ "going direct the other way - in short, the period was so far like the present period, that some of its noisiest "
			+ "authorities insisted on its being received, for good or for evil, in the superlative degree of comparison only.", 
			"", 
			"It was the best of <<pn>>, it was the worst of times, it was the age of <<pn>>, it was the age of "
					+ "foolishness, it was the epoch of <<pn>>, it was the epoch of incredulity, it was the season of Light, it was"
					+ "the season of Darkness, it was the spring of hope, it was the winter of despair, we had everything before "
					+ "us, we had nothing before us, we were all going direct to heaven,we were all going direct the other way "
					+ "- in short, the period was so far like the present period, that some of its noisiest authorities insisted"
					+ " on its being received, for good or for evil, in the superlative degree of comparison only.", 
					"Charlse", 
					"Dickens", 3);
	CompletedStories comStoryInvalidParentStory = new CompletedStories("It was the best of <<hippos>>, it was the worst of times, it was the age of <<prime ministers>>, it was the age of "
			+ "foolishness, it was the epoch of <<toilets>>, it was the epoch of incredulity, it was the season of Light, it was"
			+ "the season of Darkness, it was the spring of hope, it was the winter of despair, we had everything before "
			+ "us, we had nothing before us, we were all going direct to heaven,we were all going direct the other way "
			+ "- in short, the period was so far like the present period, that some of its noisiest authorities insisted"
			+ " on its being received, for good or for evil, in the superlative degree of comparison only.", userValid, 3, incomStoryInvalidBookTitle);
	CompletedStories comStoryInvalidUpVote = new CompletedStories("It was the best of <<hippos>>, it was the worst of times, it was the age of <<prime ministers>>, it was the age of "
			+ "foolishness, it was the epoch of <<toilets>>, it was the epoch of incredulity, it was the season of Light, it was"
			+ "the season of Darkness, it was the spring of hope, it was the winter of despair, we had everything before "
			+ "us, we had nothing before us, we were all going direct to heaven,we were all going direct the other way "
			+ "- in short, the period was so far like the present period, that some of its noisiest authorities insisted"
			+ " on its being received, for good or for evil, in the superlative degree of comparison only.", userValid, -1, incomStorValid);
	Login loginValid = new Login("SallyAnders","Jm%@92yy", userValid);
	Login loginLongUserName = new Login("qpofejpqowjpoqejpqofijepqpqoweifjpqoweifjpqoweejpqowjpoqejpqofijepqpqoweifjpqoweifjpqoweifjqpejpqowjpoqejpqofijepqpqoweifjpqoweifjpqoweifjqpifjqpoweifjqpowefjpqwoe","Jm%@92yy", userValid);
	Login loginShortUserName = new Login("S","Jm%@92yy", userValid);
	Login loginInvalidUserName = new Login(" ","Jm%@92yy", userValid);
	Login loginLongPassword = new Login("SallyAnders","Jm%@92yy3454^$%ERTfwpe fe[wkef f fmekwmfwkefmwkefpo kewf wef ewfww", userValid);
	Login loginInvalidUser = new Login("SallyAnders","Jm%@92yy", userInvalidFirstName);
	Login loginShortPassword = new Login("SallyAnders","Jm%", userValid);
	Login loginMultipleInvalid = new Login("SallyAnder@##@ s","Jm", userValid);

	
// ********* VALID TEST CASES ********************************************//
	
	// Check valid user
	@Test
	public void testBusinessLogicIsValidUser() {
		boolean result = userActions.isValidUser(userValid);
		//System.out.println("Valid User: "+ userValid.toString());
		com.revature.madlibs.Logger.log.debug("Valid User: "+ userValid.toString());
		assertTrue(result);
	}
	
	// Check valid login
	@Test
	public void testBusinessLogicIsValidLogin() {
		boolean result = userActions.isValidLogin(loginValid);
		//System.out.println("Valid Login: "+ loginValid.toString());
		com.revature.madlibs.Logger.log.debug("Valid User: "+ loginValid.toString());
		assertTrue(result);
	}
	
	
// *******INVALID TEST CASES *********************************************//

	// Check User invalid DOB
	@Test
	public void testBusinessLogicUserInvalidDOB() {
		boolean result = userActions.isValidUser(userInvalidDob);
		//System.out.println("Invalid user DOB: "+ userInvalidDob.toString());
		com.revature.madlibs.Logger.log.debug("Invalid user DOB: "+ userInvalidDob.toString());
		assertFalse(result);
	}


	// Check User invalid First Name
	@Test
	void testBusinessLogicUserInvalidFirstName() {
		boolean result = userActions.isValidUser(userInvalidFirstName);
		//System.out.println("Invalid user DOB: "+ userInvalidFirstName.toString());
		com.revature.madlibs.Logger.log.debug("Invalid user First Name: "+ userInvalidFirstName.toString());
		assertFalse(result);
	}

	// Check User invalid Last Name
	@Test
	void testBusinessLogicUserInvalidLastName() {
		boolean result = userActions.isValidUser(userInvalidLastName);
		//System.out.println("Invalid user DOB: "+ userInvalidLastName.toString());
		com.revature.madlibs.Logger.log.debug("Invalid user lastName: "+ userInvalidLastName.toString());
		assertFalse(result);
	}


	// Check User invalid e-mail
	@Test
	void testBusinessLogicUserInvalidEmail() {
		boolean result = userActions.isValidUser(userInvalidEmail);
		//System.out.println("Invalid user DOB: "+ userInvalidEmail.toString());
		com.revature.madlibs.Logger.log.debug("Invalid user e-mail: "+ userInvalidEmail.toString());
		assertFalse(result);
	}
	
	// Check Completed Story Short Story
	@Test
	void testBusinessLogicCompStoryShortStory() {
		boolean result = userActions.isValidCompletedStory(comStoryShortStory);
		//System.out.println("Invalid user DOB: "+ userInvalidEmail.toString());
		com.revature.madlibs.Logger.log.debug("Invalid user e-mail: "+ comStoryShortStory.toString());
		assertFalse(result);
	}
	
	// Check Completed Story Invalid UpVote Count
	@Test
	void testBusinessLogicCompStoryInvalidUpVote() {
		boolean result = userActions.isValidCompletedStory(comStoryInvalidUpVote);
		//System.out.println("Invalid user DOB: "+ userInvalidEmail.toString());
		com.revature.madlibs.Logger.log.debug("Invalid user e-mail: "+ comStoryInvalidUpVote.toString());
		assertFalse(result);
	}
	
	// Check Login Long User Name
	@Test
	void testBusinessLogicLoginLongUserName() {
		boolean result = userActions.isValidLogin(loginLongUserName);
		//System.out.println("Invalid user DOB: "+ userInvalidEmail.toString());
		com.revature.madlibs.Logger.log.debug("Invalid user e-mail: "+ loginLongUserName.toString());
		assertFalse(result);
	}
	
	// Check Login Short User Name
	@Test
	void testBusinessLogicLoginShortUserName() {
		boolean result = userActions.isValidLogin(loginShortUserName);
		//System.out.println("Invalid user DOB: "+ userInvalidEmail.toString());
		com.revature.madlibs.Logger.log.debug("Invalid user e-mail: "+ loginShortUserName.toString());
		assertFalse(result);
	}
	
	// Check Login Invalid User Name
	@Test
	void testBusinessLogicLoginInvalidUserName() {
		boolean result = userActions.isValidLogin(loginInvalidUserName);
		//System.out.println("Invalid user DOB: "+ userInvalidEmail.toString());
		com.revature.madlibs.Logger.log.debug("Invalid user e-mail: "+ loginInvalidUserName.toString());
		assertFalse(result);
	}
	
	// Check Login Long Password
	@Test
	void testBusinessLogicLoginLongPassword() {
		boolean result = userActions.isValidLogin( loginLongPassword);
		//System.out.println("Invalid user DOB: "+ userInvalidEmail.toString());
		com.revature.madlibs.Logger.log.debug("Invalid user e-mail: "+  loginLongPassword.toString());
		assertFalse(result);
	}
	
	// Check Login Multiple Invalid
	@Test
	void testBusinessLogicLoginMultipleInvalid() {
		boolean result = userActions.isValidLogin(loginMultipleInvalid);
		//System.out.println("Invalid user DOB: "+ userInvalidEmail.toString());
		com.revature.madlibs.Logger.log.debug("Invalid user e-mail: "+  loginMultipleInvalid.toString());
		assertFalse(result);
	}
	
	// Check Login Short Password
	@Test
	void testBusinessLogicLoginShortPassword() {
		boolean result = userActions.isValidLogin(loginShortPassword);
		//System.out.println("Invalid user DOB: "+ userInvalidEmail.toString());
		com.revature.madlibs.Logger.log.debug("Invalid user e-mail: "+ loginShortPassword.toString());
		assertFalse(result);
	}
	
}
