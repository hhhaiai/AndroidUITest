package com.netease.mobile.autotest.page;

import com.netease.orange.robotium.OrangeSolo;
import com.netease.pris.R;

import android.util.Log;
import android.view.View;

public class SettingPage extends BasePage {
	private static final String LOG_TAG = "Pris-"
			+ SettingPage.class.getSimpleName();
	private static final String BIND_ACCOUNT = "帐号绑定";
	private static final int LOG_OFF_VIEW = R.id.setting_switch_off_account;
	private static final String LOG_OFF_TEXT = "退出登录";
	private static final int LOGOUT_DIALOG = R.id.linearLayout_button;
	
	public SettingPage(OrangeSolo orange) {
		super(orange);
		orange.waitForText(BIND_ACCOUNT, 0, 20000, false, true);
	}
	
	/**
	 * 用户退出登录
	 * @return
	 */
	public MainGridPage logoffAccount() {
		orange.sleep(30000);
		orange.scrollToBottom();
		Log.d(LOG_TAG, "滑倒底部");
		View viLogoff = orange.getView(LOG_OFF_VIEW);
		
		// android 2.3.3可能无法识别该控件
		/*orange.waitForView(viLogoff, 5000, true);
		orange.clickOnView(viLogoff);*/
		//加保护，若没有滑动成功则再次滑动
		if(!orange.waitForText(LOG_OFF_TEXT,1,20000,false))
			{
			orange.scrollToBottom();
			orange.waitForText(LOG_OFF_TEXT,1,20000,false);
			}
		orange.clickOnText(LOG_OFF_TEXT);
		orange.waitForView(LOGOUT_DIALOG);
		orange.clickOnButton(1);
		orange.waitForViewDisappear(viLogoff);
		return new MainGridPage(orange);
	}
}
