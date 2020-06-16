package baseball.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import baseball.model.PlayerList;
import baseball.repository.BaseballRepository;
import baseball.util.Script;

public class AllPlayerAction implements Action {
	private static final String TAG ="AllPlayerAction : ";
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String teamid=request.getParameter("teamid");
		//System.out.println(TAG+teamid);
		
		BaseballRepository baseballRepository=BaseballRepository.getInstance();
		List<PlayerList> playerlists=baseballRepository.allPlayerList(Integer.parseInt(teamid));
		
		Gson gson=new Gson();
		
		String playerlistJson=gson.toJson(playerlists);
		
		System.out.println(playerlistJson);

		Script.outJson(playerlistJson, response);
	}
}
