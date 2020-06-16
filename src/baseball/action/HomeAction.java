package baseball.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import baseball.model.TeamList;
import baseball.repository.BaseballRepository;

public class HomeAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BaseballRepository baseballRepository=BaseballRepository.getInstance();
		List<TeamList> teamlists=baseballRepository.allTeamList();
		
		request.setAttribute("teamlists", teamlists);
		RequestDispatcher dis = request.getRequestDispatcher("home.jsp");
		dis.forward(request, response);
		
	}

}
