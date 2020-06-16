package baseball.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class Script {

	public static void outJson(String msg, HttpServletResponse response) {
		try {
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/json; charset=utf-8");
			System.out.println("json 변환");
			PrintWriter out = response.getWriter();
			
			out.print(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
