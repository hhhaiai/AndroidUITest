package com.netease.mobile.autotest.page;

import com.netease.orange.robotium.OrangeSolo;
import com.netease.pris.R;

import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * 主界面
 * 
 * @author suixiang
 */
public class MainGridPage extends BasePage {
	private static final String LOG_TAG = "Pris-"
			+ MainGridPage.class.getSimpleName();
	public static final int TAB_INDICATOR = R.id.page_indicator;
	public static final int TAB_SUB_TITLE = R.id.title;
	private static final int TAB_DISCOVERY = 0;
	private static final int TAB_BOOKSHELF = 1;
	private static final int TAB_NEWS = 2;
	private static final int TAB_ACCOUNT = 3;
	private static final String NOT_LOGIN = "未登录";
	
	public MainGridPage(OrangeSolo orange) {
		super(orange);
		orange.waitForActivity("MainGridActivity");
	}
	
	/**
	 * 判断是不是首页
	 * 
	 * @return
	 */
	public boolean isMainGridPage() {
		orange.waitForActivity("MainGridActivity", 5000);
		View viMainTab = orange.getView(TAB_INDICATOR);
		return orange.waitForView(viMainTab);
	}
	
	/**
	 * 进入主页4个tab
	 * 
	 * @param tabIndex
	 */
	public void enterMainTab(int tabIndex) {
		System.out.println("进入关键代码部分了！前方高能！");
		switch (tabIndex) {
		case TAB_DISCOVERY:
			Log.i(LOG_TAG, "进入发现");
			break;
		case TAB_BOOKSHELF:
			Log.i(LOG_TAG, "进入书架");
			break;
		case TAB_NEWS:
			Log.i(LOG_TAG, "进入订阅");
			break;
		case TAB_ACCOUNT:
			Log.i(LOG_TAG, "进入账号");
		}
		System.out.println("TAB_INDICATOR到底有没有值，看这里："+TAB_INDICATOR);
		View viMainTab = orange.getView(TAB_INDICATOR);
		//System.out.println("orange能不能get到view1，看这里："+viMainTab.getId());
		orange.waitForView(viMainTab);
		System.out.println("orange.waitForView执行成功了没有，看这里！");
		System.out.println("TAB_SUB_TITLE到底有没有值，看这里："+TAB_SUB_TITLE);
		View viTab = orange.getView(viMainTab, TAB_SUB_TITLE, tabIndex);
		//System.out.println("orange能不能get到view2，看这里："+viTab.getId());
		orange.clickOnView(viTab);
		System.out.println("orange.clickOnView执行成功了没有，看这里！");
	}
	
	/**
	 * 判断是否登录状态
	 * 
	 * @return true 已登录；false 未登录
	 */
	public boolean isUserLogin() {
		enterMainTab(TAB_ACCOUNT);
		RelativeLayout profile_layout = (RelativeLayout) orange
				.getView(R.id.profile_layout);
		orange.waitForView(profile_layout, 15000, false);
		if (null == profile_layout) {
			return false;
		}
		if (orange.waitForText(NOT_LOGIN, 0, 15000, false, true)) {
			return false;

		}
		return true;
	}
	
	/**
	 * 进入设置
	 * 
	 * @return SettingPage
	 */
	public SettingPage enterSettingPage() {
		Log.d(LOG_TAG, "点击设置");
		enterMainTab(TAB_ACCOUNT);
		orange.sleep(30000);
		int screenheight = orange.getCurrentActivity().getResources()
				.getDisplayMetrics().heightPixels;
		int screenwidth = orange.getCurrentActivity().getResources()
				.getDisplayMetrics().widthPixels;
		orange.drag(100, 100, (int) (screenheight * 0.8),
				(int) (screenheight * 0.2), 1); //
		orange.waitForText("设置", 0, 30000, false);
		orange.clickOnText("设置");
		return new SettingPage(orange);
	}
	
	/**
	 * 根据loginText进入相应的登录界面
	 * 
	 * @param loginText
	 *            传入的文本，如“未登录”，“网易邮箱提醒”
	 * @return
	 */
	public LoginPage enterLoginPage(String loginText) {
		Log.d(LOG_TAG, "登录" + loginText);
		enterMainTab(TAB_ACCOUNT);

		orange.waitForText(loginText,1,4000);
		orange.clickOnText(loginText);
		return new LoginPage(orange);
	}
	/**
	 * 从“未登录”进入登录页面
	 * 
	 * @return LoginPage
	 */
	public LoginPage enterLoginPage() {
		return enterLoginPage("未登录");
		// return enterLoginPage1();
	}
}
