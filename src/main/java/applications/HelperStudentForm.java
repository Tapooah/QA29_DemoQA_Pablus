package applications;

import models.StudentForm;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HelperStudentForm extends applications.HelperBase {
    public HelperStudentForm(WebDriver wd) {
        super(wd);
    }

    public void selectItemForms() {
        if (isElementPresent(By.id("close-fixedban"))) {
            click(By.id("close-fixedban"));
        }
        click(By.xpath("//div[@class='category-cards']/div[2]"));
        pause(500);
    }

    public void selectPracticeForm() {
        click(By.xpath("//span[.='Practice Form']"));
    }

    public void submit() {
        click(By.id("submit"));
    }

    public void fillForm(StudentForm model) {

        type(By.id("firstName"), model.getFirstName());
        type(By.id("lastName"), model.getLastName());
        type(By.id("userEmail"), model.getEmail());
        selectGender(model.getGender());
        type(By.id("userNumber"), model.getPhone());
//        typeBDay(By.id("dateOfBirthInput"), model.getBirthday());
        typeBDayWithCalendar(By.id("dateOfBirthInput"), model.getBirthday());
        addSubjectByEnter(model.getSubject());
        selectHobbies(model.getHobbies());
        type(By.id("currentAddress"), model.getAddress());
        typeState(model.getState());
    }

    private void typeState(String state) {
//        scroll(0, 40);
        type(By.id("react-select-3-input"),state);
        wd.findElement(By.id("react-select-3-input")).sendKeys(Keys.ENTER);
    }

    private void selectHobbies(String hobby) {
        String[] hobbies = hobby.split(" ");
        for (String s : hobbies) {
            switch (s) {
                case "Sports":
                    click(By.xpath("//label[normalize-space()='Sports']"));
                    break;
                case "Reading":
                    click(By.xpath("//label[normalize-space()='Reading']"));
                    break;
                case "Music":
                    click(By.xpath("//label[normalize-space()='Music']"));
                    break;
            }
        }
    }

    private void addSubjectByEnter(String subject) {
        type(By.id("subjectsInput"), subject);
//        wd.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);
        click(By.id("react-select-2-option-0"));
    }


    private void typeBDayWithCalendar(By locator, String birthday) {
//25 5 1990
        String[] data = birthday.split(" ");
        click(locator);

        new Select(wd.findElement(By.cssSelector(".react-datepicker__year-select"))).selectByValue(data[2]);
        pause(2000);
        new Select(wd.findElement(By.cssSelector(".react-datepicker__month-select"))).selectByIndex(Integer.parseInt(data[1]));

        int day = Integer.parseInt(data[0]);
//        wd.findElement(By.xpath("//div[text()='25']")).click();
        String loc = String.format("//div[text()='%s']", day);
//        click(By.xpath(loc));
        List<WebElement> daysList = wd.findElements(By.xpath(loc));
        WebElement clickableElement;

        if (daysList.size() > 1 && day > 15) {
            clickableElement = daysList.get(1);
        } else {
            clickableElement = daysList.get(0);
        }
        clickableElement.click();

//        pause(2000);
    }

    private void typeBDay(By locator, String birthday) {
        WebElement element = wd.findElement(locator);
        element.click();

        String os = System.getProperty("os.name");
        System.out.println(os);
        if (os.startsWith("Mac")) {
            element.sendKeys(Keys.chord(Keys.COMMAND + "a"));
        } else {
            element.sendKeys(Keys.chord(Keys.CONTROL + "a"));
        }

        element.sendKeys(birthday);
        element.sendKeys(Keys.ENTER);
//        pause(2000);
    }

    private void selectGender(String gender) {
        if (gender.equals("Male")) {
            click(By.xpath("//label[@for='gender-radio-1']"));
        } else if (gender.equals("Female")) {
            click(By.xpath("//label[@for='gender-radio-2']"));
        } else {
            click(By.xpath("//label[@for='gender-radio-3']"));
        }
    }

}


