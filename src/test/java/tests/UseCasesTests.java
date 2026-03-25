package tests;

import base.BaseTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.admin.BasePage;
import pages.admin.DataEntry.UseCasesPage;
import utilities.AuthHelper;
import utils.Assertions;

import static dataReader.ReadDataFromJson.dataModel;

public class UseCasesTests extends BaseTests {

    BasePage basePage;
    UseCasesPage useCasesPage;

    @BeforeMethod
    public void login() {
        basePage = AuthHelper.login(driver);
    }

    @Test(priority = 1)
    public void addUseCaseTest() throws InterruptedException {

        useCasesPage = basePage.openUseCases();

        useCasesPage
                .clickAddButton()
                .enterArabicTitle(dataModel().UseCases.titleAR)
                .enterEnglishTitle(dataModel().UseCases.titleEN)
                .enterArabicContent(dataModel().UseCases.contentAR)
                .enterEnglishContent(dataModel().UseCases.contentEN)
                .uploadArabicImage(System.getProperty("user.dir")+ "/src/test/resources/images/" + dataModel().UseCases.imageAR)
                .uploadEnglishImage(System.getProperty("user.dir")+ "/src/test/resources/images/" + dataModel().UseCases.imageEN)
                .clickSubmit();

        Assertions.myAssertTrue(
                basePage.isSuccessIconDisplayed()
                        && basePage.isSuccessMessageDisplayed(),
                "Success popup is not displayed correctly"
        );

        Assertions.myAssertEquals(
                basePage.getSuccessMessage(),
                "Created successfully"
        );
    }

    @Test(priority = 2)
    public void verifyAfterAddUseCaseTest() {

        useCasesPage = basePage.openUseCases();
        useCasesPage
                .searchInputs(dataModel().UseCases.titleEN);

        Assertions.myAssertEquals(
                basePage.getTableSearchResult(),
                dataModel().UseCases.titleEN
        );
    }

    @Test(priority = 3)
    public void editUseCaseTest() {

        useCasesPage = basePage.openUseCases();
        useCasesPage
                .searchInputs(dataModel().UseCases.titleEN)
                .clickSearchResult()
                .clickEditFeature()
                .enterArabicTitle(dataModel().UseCases.editTitleAR)
                .enterEnglishTitle(dataModel().UseCases.editTitleEN)
                .clickSubmit();

        Assertions.myAssertTrue(
                basePage.isSuccessIconDisplayed()
                        && basePage.isSuccessMessageDisplayed(),
                "Success popup is not displayed correctly"
        );

        Assertions.myAssertEquals(
                basePage.getSuccessMessage(),
                "Updated successfully"
        );
    }

    @Test(priority = 4)
    public void verifyAfterEditUseCaseTest() {

        useCasesPage = basePage.openUseCases();
        useCasesPage
                .searchInputs(dataModel().UseCases.editTitleEN);


        Assertions.myAssertEquals(
                basePage.getTableSearchResult(),
                dataModel().UseCases.editTitleEN
        );
    }

    @Test(priority = 5)
    public void deleteUseCaseTest() {

        useCasesPage = basePage.openUseCases();
        useCasesPage
                .searchInputs(dataModel().UseCases.editTitleEN)
                .clickSearchResult()
                .clickDeleteFeature();

        Assertions.myAssertTrue(
                basePage.isSuccessIconDisplayed()
                        && basePage.isSuccessMessageDisplayed(),
                "Success popup is not displayed correctly"
        );

        Assertions.myAssertEquals(
                basePage.getSuccessMessage(),
                "Deleted successfully"
        );
    }

    @Test(priority = 6)
    public void verifyAfterDeleteUseCaseTest() {

        useCasesPage = basePage.openUseCases();
        useCasesPage
                .searchInputs(dataModel().UseCases.editTitleEN);

        // assertion on control panel
        Assertions.myAssertEquals(
                basePage.getNoDataAvailableMessage(),
                "No data available"
        );
    }
}


