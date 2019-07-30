package prv.xsq.eco.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * top10活跃session
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Top10Session {

	private long taskid;
	private long categoryid;
	private String sessionid;
	private long clickCount;

}
