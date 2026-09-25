package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TodoPage extends BasePage {

    public TodoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[data-testid=\"welcome\"]")
    private WebElement welcomeMessage;

    @FindBy(css = "[data-testid=\"add\"]")
    private WebElement addBtn;

    @FindBy(css = "[data-testid=\"todo-item\"]")
    private WebElement TodoItem;

    @FindBy(css = "[data-testid=\"delete\"]")
    private WebElement deleteBtn;

    @FindBy(css = "[data-testid=\"no-todos\"]")
    private WebElement noTodo;

    @Step
    public TodoPage load(){
        driver.get(ConfigUtils.getInstance().getBaseUrl() + EndPoint.API_TODO_ENDPOINT);
        return this;
    }

    @Step
    public boolean isWelcomeMessageDisplay(){
        return welcomeMessage.isDisplayed();
    }

    @Step
    public NewTodoPage clickOnPlusBtn() {
        addBtn.click();
        return new NewTodoPage(driver);
    }

    @Step
    public String getTodotext(){
        return TodoItem.getText();
    }

    @Step
    public TodoPage ClickOnDeleteBtn(){
        deleteBtn.click();
        return this;
    }

    @Step
    public boolean isNoTodoMessageDisplayed(){
        return noTodo.isDisplayed();
    }

}
