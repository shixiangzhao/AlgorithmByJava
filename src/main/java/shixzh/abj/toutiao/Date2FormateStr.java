package shixzh.abj.toutiao;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期转换，将Date类型的对象，转换成”2017-3-25 08:23:22”格式的字符串
 * Date类型的日期是常用的数据对象，包括日志打印，数据存储，
 * 但是平时使用时，往往希望日期以固定格式来显示，比较规范，所以需要转换。
 * 实现思路：常用的日期格式转换类是SimpleDateFormat，直接调用该类的方法即可
 * @author shixzh
 *
 */
public class Date2FormateStr {

	public static String date2String(Date date) {
		SimpleDateFormat sfd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sfd.format(date);
	}

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		System.out.println(date2String(date));
	}
}
