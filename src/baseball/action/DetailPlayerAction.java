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

public class DetailPlayerAction implements Action {
	private static final String TAG ="DetailPlayerAction : ";
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String playid=request.getParameter("playid");
		System.out.println(TAG+playid);
		
		BaseballRepository baseballRepository=BaseballRepository.getInstance();
		PlayerList playerlists=baseballRepository.detailPlayerList(Integer.parseInt(playid));
		
		Gson gson=new Gson();
		
		String playerlistJson=gson.toJson(playerlists);
		
		System.out.println(playerlistJson);

		Script.outJson(playerlistJson, response);
	}
}
