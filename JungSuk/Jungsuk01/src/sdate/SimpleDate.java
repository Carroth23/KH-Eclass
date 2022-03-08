package sdate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SimpleDate {
	public static void main(String[] args) throws ParseException {
		DateFormat df = new SimpleDateFormat("yyyy년 MM월 dd일");
		DateFormat df2 = new SimpleDateFormat("yyyy/MM/dd");
		long today = System.currentTimeMillis();
		System.out.println(today);
		System.out.println(df.format(today));
	}
}
