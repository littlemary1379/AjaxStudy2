package baseball.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import baseball.action.Action;
import baseball.action.AllPlayerAction;
import baseball.action.DetailPlayerAction;
import baseball.action.HomeAction;

@WebServlet("/base")
public class BaseballController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BaseballController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doprocess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doprocess(request, response);
	}
	protected void doprocess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd=request.getParameter("cmd");
		System.out.println("router : "+cmd);
		Action action=router(cmd);
		action.execute(request,response);
	}
	
	public Action router(String cmd) {
		if(cmd.equals("home")) {
			return new HomeAction();
		}else if(cmd.equals("allPlayer")) {
			return new AllPlayerAction();
		}else if(cmd.equals("detail")) {
			return new DetailPlayerAction();
		}
		return null;
	}
	
	

}
