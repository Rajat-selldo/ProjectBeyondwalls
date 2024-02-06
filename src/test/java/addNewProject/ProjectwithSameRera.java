package addNewProject;

import org.testng.annotations.Test;

import pom.beyondwalls.utility.BaseTest;
import pom.userActions.AddProject;

public class ProjectwithSameRera extends BaseTest {

	
	public void TC03() {
//Project with Same Rera No. should not get added. 					(Script not working)
		AddNewProject add = new AddNewProject();
		add.addProject();

//write script for - Error should be shown when project is added with same Rera No. 

		AddProject errorValidation = new AddProject(driver);
		boolean isErrorDisplayed = errorValidation.verifyingSameReraNo();

		if (isErrorDisplayed) {
			System.out.println("Error message is displayed! - Project with Same Rera No. will not get added.");
		} else {
			System.out.println("Error message is not displayed!");
		}

	}
}
