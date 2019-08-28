package prv.xsq.eco.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author 洪家豪
 *         Created by acer on 2019/8/28.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PageSplitConvertRate {

    private Integer taskId;
    private String convertRate;

}
