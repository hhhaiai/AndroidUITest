package com.netease.mobile.autotest.test;

import android.R;
import android.test.ActivityInstrumentationTestCase2;
import com.robotium.solo.Solo;
import android.view.View;
//import org.junit.After;
//import org.junit.Before;
//import junit.framework.Test;
public class TestOne extends ActivityInstrumentationTestCase2 {
	private static String TARGET_PACKAGE_ID = "com.netease.pris";
	private static String LAUNCHER_ACTIVITY_FULL_CLASSNAME = "com.netease.pris.activity.PRISActivityFlasScreen";
	private static Class launcherActivityClass;
	private Solo solo;
	static{
		try{
			launcherActivityClass = Class.forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
		}catch(ClassNotFoundException e){
			throw new RuntimeException(e);
		}
	}
	@SuppressWarnings("unchecked")
	public TestOne(){
		super(TARGET_PACKAGE_ID,launcherActivityClass);
	}
	
	protected void setUp() throws Exception{
		solo = new Solo(getInstrumentation(),getActivity());
	}
	
	public void tearDown() throws Exception{
		try
		{
			solo.finalize();
		}catch(Throwable e) {
			e.printStackTrace();
		}
		getActivity().finish();
		super.tearDown();
	}
	public void testCase1(){
		System.out.println("This is the first testCase");
	}
}
