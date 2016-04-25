package com.netease.mobile.autotest.test;

import com.netease.mobile.autotest.page.MainGridPage;
import com.netease.orange.robotium.OrangeSolo;

import android.app.Instrumentation;

/**
 * 匿名测试用例的基类
 * 
 * @author suixiang
 *
 */
public class AnonymousBaseTest extends BaseTestEx {
	
	public AnonymousBaseTest() throws Exception {
		super();
		logTag += this.getClass().getSimpleName();	
	}
	
	/**
	 * 无需登录，仅做Page初始化
	 */
	@Override
	public void initialization() throws Exception {
		gridPage = new MainGridPage(orange);
	}
}
