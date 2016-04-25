package com.netease.mobile.autotest.page;

import com.netease.orange.robotium.OrangeSolo;
import com.netease.pris.R;

import android.util.Log;
import android.widget.EditText;

public class LoginPage extends BasePage {
	private static final int USERNAME = R.id.ui_login_name;
	private static final int PASSWORD = R.id.ui_login_password;
	private static final int BTN_LOGIN = R.id.ui_login_button_login;
	private static final String LOG_TAG = "Pris-" + LoginPage.class.getSimpleName();
	public LoginPage(OrangeSolo orange) {
		super(orange);
	}
	
	/**
	 * 是否是登录页面
	 * 
	 * @return
	 */
	public boolean isLoginPage() {
		return orange.waitForActivity("LoginCollectionActivity");
	}
	
	/**
	 * 输入用户名
	 * 
	 * @param userName
	 */
	public void enterUsername(String userName) {
		Log.d(LOG_TAG, "输入用户名");
		EditText edtUsername = (EditText) orange.getView(USERNAME);
		orange.clearEditText(edtUsername);
		orange.enterText(edtUsername, userName);
	}
	
	/**
	 * 输入密码
	 * 
	 * @param passWord
	 */
	public void enterPassword(String passWord) {
		Log.d(LOG_TAG, "输入密码");
		EditText edtPassword = (EditText) orange.getView(PASSWORD);
		orange.clearEditText(edtPassword);
		orange.enterText(edtPassword, passWord);
	}
	
	/**
	 * 点击登录按钮
	 * 
	 * @return
	 */
	public MainGridPage clickOnLoginButton() {
		Log.d(LOG_TAG, "点击登录按钮");
		orange.clickOnView(orange.getView(BTN_LOGIN));
		orange.waitForViewDisappear(orange.getView(BTN_LOGIN));
		return new MainGridPage(orange);
	}
}
