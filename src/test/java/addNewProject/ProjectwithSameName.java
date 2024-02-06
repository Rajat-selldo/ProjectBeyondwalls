package addNewProject;

import org.testng.annotations.Test;

import pom.beyondwalls.utility.BaseTest;
import pom.userActions.AddProject;

public class ProjectwithSameName extends BaseTest {

	
	public void TC02() {
//Project with Same name should not get added. 						(Script not working)
		AddNewProject add = new AddNewProject();
		add.addProject();
		
// write script for - Error should be shown when project is added with same name.
		
		AddProject errorValidation = new AddProject(driver);
		errorValidation.verifyingSameProjectName();
//		boolean isErrorDisplayed = errorValidation.verifyingSameProjectName();
//
//		if (isErrorDisplayed) {
//		    System.out.println("Error message is displayed! - Project with Same name will not get added. ");
//		} else {
//		    System.out.println("Error message is not displayed!");
//		}

	}
}
