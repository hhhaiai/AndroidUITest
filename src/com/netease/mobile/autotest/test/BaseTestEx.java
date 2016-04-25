package com.netease.mobile.autotest.test;

import com.netease.mobile.autotest.page.LoginPage;
import com.netease.mobile.autotest.page.MainGridPage;
import com.netease.mobile.autotest.page.SettingPage;
import com.netease.orange.framework.annotation.ActivityInstrumentationTestCase3;
import com.netease.orange.robotium.OrangeSolo;
import com.netease.pris.R;

import android.app.Instrumentation;
import android.content.Intent;
import android.util.Log;

public abstract class BaseTestEx extends ActivityInstrumentationTestCase3 {

	protected String logTag = "Pris-";
	
	public static final int FUNCTION_GUIDE = R.id.imageView_close;
	public static final int FUNCTION_GUIDE_TOP = R.id.imageView_top_arrows;
	public static final int FRESH_PROGRESS = R.id.refresh_progress;
	protected MainGridPage gridPage;
	protected OrangeSolo orange;
	protected SettingPage settingPage;
	protected LoginPage loginPage;
	
	public BaseTestEx() throws Exception {
		super("com.netease.pris", "com.netease.pris.activity.MainGridActivity");
		System.out.println("This is BaseTestEx的构造函数");
	}

	public void setUp() throws Exception {
		super.setUp();
		Instrumentation instrumentation = getInstrumentation();
		orange = new OrangeSolo(instrumentation);
		final String targetPackage = instrumentation.getTargetContext()
				.getPackageName();

		Intent intent = new Intent(Intent.ACTION_MAIN);
		intent.setClassName(targetPackage,
				"com.netease.pris.activity.MainGridActivity");
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		instrumentation.getTargetContext().startActivity(intent);
		orange.waitForActivity("com.netease.pris.activity.MainGridActivity", 5000);
		//modified by suixiang
		gridPage = new MainGridPage(orange);
	}
	
	
	public void tearDown() throws Exception {
		super.tearDown();
		Log.i(logTag, "tearDown");
		gridPage = null;
		loginPage = null;
		settingPage = null;
		orange.finishOpenedActivities();
		try {
			orange.finalize();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void initialization() throws Exception {
		// TODO Auto-generated method stub
		
	}
}
