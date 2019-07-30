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
public class SessionDetail {
    private long taskid;
    private long userid;
    private String sessionid;
    private long pageid;
    private String actionTime;
    private String searchKeyword;
    private long clickCategoryId;
    private long clickProductId;
    private String orderCategoryIds;
    private String orderProductIds;
    private String payCategoryIds;
    private String payProductIds;
}
