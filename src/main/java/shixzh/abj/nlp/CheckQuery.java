package shixzh.abj.nlp;

import java.util.ArrayList;
import java.util.List;

/**
 * 有一个百万级的字符串集合(worddic)，worddict中每个字符串的长度为2~5个汉字。
 * 对任意一个查询串(query)，定义该query对worddic模糊匹配的条件为：
 * 该query内部移除最多6个连续汉字后，与worddic中某个词完全匹配。
 * 例如：worddic中有"百度公司"这个字符串，query"北京百度网络技术有限公司"，
 * 该query即可通过移除6个连续字符('网络技术有限')来匹配"百度公司";
 * 给出数据结构dict的设计并完成check_query函数
 * 
 * @author Cienet
 *
 */
public class CheckQuery {

	public static void main(String[] args) {
		WordDic wd = new WordDic("百度公司", 4);
		WordDic wd1 = new WordDic("东莨菪", 3);
		WordDic wd2 = new WordDic("大家快递费", 5);
		List<WordDic> wdList = new ArrayList<>();
		wdList.add(wd2);
		wdList.add(wd1);
		wdList.add(wd);
		String query = "北京百度网络技术有限公司";
		System.out.println("能否找到匹配字符串：" + checkQuery(wdList, query, query.length()));
	}

	/**
	 * @brief: query match function
	 * @param worddcit:字符串集合，可以在这儿自定义词典的数据结构worddic;
	 * @param query:
	 *            query，用户输入的字符串;
	 * @param querylen:
	 *            query的长度;
	 * @param return:
	 *            1表示该query可以模糊匹配词典中某个字符串，-1表示其它;
	 */
	public static int checkQuery(List<WordDic> worddict, String query, int querylen) {

		return -1;
	}
}
