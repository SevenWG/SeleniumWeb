package com.sevenwg.web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CoursePage extends BasePage {
    public CoursePage(WebDriver webDriver) {
        super(webDriver);
    }
    /**
     * 添加购物车按钮
     * */
    public WebElement GetAddCartElement() {
        return GetElement("add_cart");
    }

    /**
     *
     * 立即购买按钮
     * */
    public WebElement GetBuyElement() {
        return GetElement("buy_now");
    }

    /**
     * 购物车数量
     * */
    public WebElement GetCartNumElement() {
        return GetElement("cart_num");
    }

    /**
     * 右上角购物车
     * */
    public WebElement GetCartElement() {
        return GetElement("cart");
    }

    /**
     * 获取模态框确定按钮
     * */
    public WebElement GetCartSureElement() {
        return GetElement("cart_already");
    }


    /**
     * 登陆状态信息
     * */

/*    public boolean GetUserIsLogin() {
        return GetCookie("apsid");
    }*/
}
