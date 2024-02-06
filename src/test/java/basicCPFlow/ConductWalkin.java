package basicCPFlow;

import java.io.IOException;

import org.testng.annotations.Test;

import pom.beyondwalls.utility.BaseTest;
import pom.userActions.AddWalkin;
import pom.userActions.LoginPage;

public class ConductWalkin extends BaseTest {

	@Test
	public void conductWalkin() throws InterruptedException, IOException {
		AddWalkin addWalkinForm = new AddWalkin(driver);
//After walk-in is added, then mark walk-in as conducted and document upload flow 
//		addWalkinForm.markAsConducted();
//		addWalkinForm.uploadDocumentsonWalkin();
//		System.out.println("Mark as Conducted method is successfully running.");
	}

}
