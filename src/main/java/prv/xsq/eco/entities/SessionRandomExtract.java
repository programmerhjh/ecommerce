package prv.xsq.eco.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 洪家豪
 *         Created by acer on 2019/6/27.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SessionRandomExtract {

    private long taskid;
    private String sessionid;
    private String startTime;
    private String searchKeywords;
    private String clickCategoryIds;
}
