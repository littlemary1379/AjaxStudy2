package baseball.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayerList {
	private int playid;
	private String playnum;
	private String teamname;
	private String playname;
	private String playposition;
}
