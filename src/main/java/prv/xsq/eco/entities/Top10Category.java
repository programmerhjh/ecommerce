package prv.xsq.eco.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * top10品类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Top10Category {

	private long taskid;
	private long categoryid;
	private long clickCount;
	private long orderCount;
	private long payCount;
	
}
