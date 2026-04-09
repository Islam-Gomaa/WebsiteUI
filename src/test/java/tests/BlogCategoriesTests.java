package tests;

import base.BaseTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.admin.BasePage;
import pages.admin.Blogs.BlogCategoriesPage;
import utilities.AuthHelper;
import utils.Assertions;

import static dataReader.ReadDataFromJson.dataModel;

public class BlogCategoriesTests extends BaseTests {

    BasePage basePage;
    BlogCategoriesPage blogCategoriesPage;

    @BeforeMethod
    public void setupAdminSession() {
        openAdmin();
        basePage = AuthHelper.login(driver);
    }

    @Test(priority = 1)
    public void shouldAddEditAndDeleteBlogCategorySuccessfully(){

        // ====== Control Panel ======
        blogCategoriesPage = basePage.openBlogCategories();
        blogCategoriesPage
                .clickAddButton()
                .enterArabicTitle(dataModel().BlogCategories.titleArabic)
                .enterEnglishTitle(dataModel().BlogCategories.titleEnglish)
                .enterDescriptionArabic(dataModel().BlogCategories.descriptionAR)
                .enterDescriptionEnglish(dataModel().BlogCategories.descriptionEN)
                .clickSubmit();

        Assertions.myAssertTrue(
                basePage.isSuccessIconDisplayed()
                        && basePage.isSuccessMessageDisplayed(),
                "Success popup is not displayed correctly"
        );
        Assertions.myAssertEquals(
                basePage.getSuccessMessage(),
                "Created successfully");

        blogCategoriesPage
                .closePopUpIcon()
                .searchInputs(dataModel().BlogCategories.titleEnglish);

        Assertions.myAssertEquals(
                basePage.getTableSearchResult(),
                dataModel().BlogCategories.titleEnglish);

        blogCategoriesPage
                .searchInputs(dataModel().BlogCategories.titleEnglish)
                .clickSearchResult()
                .clickEdit()
                .enterArabicTitle(dataModel().BlogCategories.editTitleArabic)
                .enterEnglishTitle(dataModel().BlogCategories.editTitleEnglish)
                .enterDescriptionArabic(dataModel().BlogCategories.editDescriptionAR)
                .enterDescriptionEnglish(dataModel().BlogCategories.editDescriptionEN)
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

        blogCategoriesPage
                .closePopUpIcon()
                .searchInputs(dataModel().BlogCategories.editTitleEnglish);

        Assertions.myAssertEquals(
                basePage.getTableSearchResult(),
                dataModel().BlogCategories.editTitleEnglish);

        blogCategoriesPage
                .searchInputs(dataModel().BlogCategories.editTitleEnglish)
                .clickSearchResult()
                .clickDelete();

        Assertions.myAssertTrue(
                basePage.isSuccessIconDisplayed()
                        && basePage.isSuccessMessageDisplayed(),
                "Success popup is not displayed correctly");

        Assertions.myAssertEquals(
                basePage.getSuccessMessage(),
                "Deleted successfully");

        blogCategoriesPage
                .closePopUpIcon()
                .clearSearchInputs()
                .searchInputs(dataModel().BlogCategories.editTitleEnglish);

        Assertions.myAssertTrue(
                basePage.isNoDataMessageCorrect(),
                "No data message is not displayed after search"
        );

    }
}


