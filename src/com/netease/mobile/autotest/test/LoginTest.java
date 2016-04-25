package com.netease.mobile.autotest.test;

import com.netease.orange.framework.Assert;
import com.netease.orange.framework.annotation.Description;
import com.netease.orange.framework.annotation.ScreenShot;

import android.util.Log;

/**
 * 登录测试用例
 * 
 * @author suixiang
 */
public class LoginTest extends AnonymousBaseTest {
	private static final String LOG_TAG = "Pris-" + LoginTest.class.getSimpleName();
	
	public LoginTest() throws Exception {
		super();
		System.out.println("This is LoginTest LoginTest()");
	}
	public void setUp() throws Exception {
		System.out.println("This is LoginTest setUp()1");
		super.setUp();
		System.out.println("This is LoginTest setUp()2");
//		if (gridPage.isUserLogin()) {
//			settingPage = gridPage.enterSettingPage();
//			gridPage = settingPage.logoffAccount();
//			int screenheight = orange.getCurrentActivity().getResources().getDisplayMetrics().heightPixels;
//			int screenwidth = orange.getCurrentActivity().getResources().getDisplayMetrics().widthPixels;
//			orange.drag(100, 100,(int)(screenheight*0.2),  (int)(screenheight*0.8), 1); //
//			Assert.assertTrue("用户注销失败", !gridPage.isUserLogin());
//		}
	}
	
	/**
	 * 启动登录-登录
	 * 
	 * @checkpoint 输入正确密码登录
	 * @checkpoint 网络正常 登陆账号
	 * @checkpoint 进入登陆界面
	 * 
	 */
	@ScreenShot
	@Description(value = "成功登录")
	public void testSucceedToLogin() {
		System.out.println("This is LoginTest testSucceedToLogin()");
		Log.i(LOG_TAG, "Start: testSucceedToLogin------------------------");
		loginPage = gridPage.enterLoginPage();
		boolean isLoginPage = loginPage.isLoginPage();
		Assert.assertTrue("进入登录界面", isLoginPage);
		loginPage.enterUsername("androidauto7@163.com");
		loginPage.enterPassword("qa1234");
		gridPage = loginPage.clickOnLoginButton();
		boolean isMainPage = gridPage.isMainGridPage();
		Assert.assertTrue("使用正确的用户名密码，不能成功登录", isMainPage); 
		boolean isUserLogin = gridPage.isUserLogin();
		Assert.assertTrue("用户登录失败", isUserLogin);
	}
}
