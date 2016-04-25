package com.netease.mobile.autotest.page;
import com.netease.orange.robotium.OrangeSolo;
import com.netease.pris.R;

/**
 * 界面基类
 * 
 * @author suixiang
 */

public class BasePage {
	protected String logTag = "Pris-";

	protected OrangeSolo orange;
	protected static final int ROOT_VIEW = R.id.activity_base_framelayout;
	
	public BasePage(OrangeSolo orange) {
		logTag += this.getClass().getSimpleName();
		this.orange = orange;
	}
	
	/**
	 * 返回
	 */
	public void goBack() {
		orange.goBack();
	}
	
	/**
	 * 返回至首页
	 * 
	 * @return
	 */
//	public MainGridPage goBackToMainGridPage() {
//		orange.goBackToActivity("MainGridActivity");
//		return new MainGridPage(orange);
//	}
	
	/**
	 * 点击屏幕中央
	 */
	public void clickOnScreenCenter() {
		int screenheight = orange.getCurrentActivity().getResources()
				.getDisplayMetrics().heightPixels;
		int screenwidth = orange.getCurrentActivity().getResources()
				.getDisplayMetrics().widthPixels;
		orange.clickOnScreen(screenwidth / 2, screenheight / 2);
	}
}
