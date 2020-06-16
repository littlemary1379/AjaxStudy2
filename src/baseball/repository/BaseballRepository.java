package baseball.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import baseball.db.DBconnection;
import baseball.model.PlayerList;
import baseball.model.TeamList;

public class BaseballRepository {
	private static final String TAG="BaseballRepositroy : ";
	private static BaseballRepository instance=new BaseballRepository();
	private BaseballRepository() {}
	public static BaseballRepository getInstance() {
		return instance;
	}
	
	Connection conn= null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	public List<PlayerList> allPlayerList(int id) {
//		StringBuilder sb= new StringBuilder();
//		sb.append("select * ");
//		sb.append("from playerlist inner join teamlist ");
//		sb.append("on playerlist.teamname=teamlist.teamname ");
//		sb.append("where teamlist.teamid=?");
//		final String SQL=sb.toString();
		final String SQL="select * from playerlist inner join teamlist on playerlist.teamname=teamlist.teamname where teamlist.teamid=?";
		List<PlayerList> playerlists=new ArrayList<>();
		try {
			conn=DBconnection.DBconn();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				PlayerList playerlist=new PlayerList(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5)
						);
				//System.out.println("여기 왜 안들어와????");		
				playerlists.add(playerlist);
			}
			
			return playerlists;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(TAG+"allPlayerList : "+e.getMessage());
		}
		return null;
	}
	
	public PlayerList detailPlayerList(int id) {
		final String SQL="select * from playerlist inner join teamlist on playerlist.teamname=teamlist.teamname where playerlist.playid=?";
		try {
			conn=DBconnection.DBconn();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				PlayerList playerlist=new PlayerList(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5)
						);
				return playerlist;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(TAG+"detailPlayerList : "+e.getMessage());
		}
		return null;
	}
	
	public List<TeamList> allTeamList() {
		final String SQL="select * from teamlist";
		List<TeamList> teamlists=new ArrayList<TeamList>();
		try {
			conn=DBconnection.DBconn();
			pstmt=conn.prepareStatement(SQL);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				TeamList teamlist=new TeamList(
						rs.getInt(1),
						rs.getString(2)
						);
				teamlists.add(teamlist);
			}
			
			return teamlists;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(TAG+"allTeamList : "+e.getMessage());
		}
		return null;
	}
}
