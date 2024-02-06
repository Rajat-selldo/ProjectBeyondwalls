package addNewProject;

import org.testng.annotations.Test;

import pom.beyondwalls.utility.BaseTest;
import pom.userActions.AddProject;
import pom.userActions.LoginPage;

public class AddNewProject extends BaseTest {

	@Test
	public void addProject() {
		LoginPage logInPage = new LoginPage(driver);
		logInPage.logIn(prop("adminPhone"));

		AddProject addProject = new AddProject(driver);
		addProject.clickonProjects();
		addProject.clickonAddProject();
		addProject.enterProjectName("Project Shibuya" + Random("N", 3));
		addProject.enterDeveloperName("Staging QA Devs - Automator");
		addProject.selectProjectType("Residential"); // Residential & Commercial
		addProject.selectCategory("Completed"); // Completed, launch, Ongoing, Pre Launch
		addProject.selectSegments("Affordable"); // Affordable, Luxury, Ultra Luxury, Value
		addProject.selectSegments2("Luxury"); // Affordable, Luxury, Ultra Luxury, Value
//		addProject.enterLocation("WAKAD");
//		addProject.selectCity("Pune");
//		addProject.selectRegion("Wakad");
		addProject.clickonPossesionDate("02/02/2024");
		addProject.clickonLaunchDate("30/12/2022");
		addProject.enterRegistrationName("Project " + Random("A", 6));
		addProject.projectWebsiteLink("https://www.temporarysite.com/");
		addProject.enterReraNumber("A" + Random("N", 11));
//		addProject.selectActiveProject();
		addProject.enterConfigurations("1BHK, 2BHK");
		addProject.enterTotalLand("11");
		addProject.enterOngoingTowers("3");
		addProject.enterProjectunits(Random("N", 3));
		addProject.selectAmenities("Gym"); // Auditorium, Swimming pool, Internal Roads
		addProject.selectBanks("HDFC Bank");
		addProject.enterProjectStartsFrom("6600000");
		addProject.enterProjectPriceUpto("12000000");
		addProject.enterFlatno(Random("A", 1) + "-" + Random("N", 3));
		addProject.enterStreetName("QA " + Random("A", 9));
		addProject.enterCountry("India");
		addProject.enterState("Maharashtra");
		addProject.selectProjectCity("Pune");
		addProject.enterProjectPinCode(Random("N", 6));

		addProject.clickonSave();

	}

}
