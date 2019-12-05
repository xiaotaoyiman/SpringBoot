package cn.ekgc.sms.util;

import java.util.Properties;

public class ConstantUtil {
	private static Properties props = new Properties();

	static {
		try {
			props.load(ConstantUtil.class.getClassLoader().getResourceAsStream("sms.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static final Integer PAGE_NUM = Integer.parseInt(props.getProperty("page.num"));
	public static final Integer PAGE_SIZE = Integer.parseInt(props.getProperty("page.size"));
}
