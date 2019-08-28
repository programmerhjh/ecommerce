package prv.xsq.eco.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 构造业务层 页面转换率返参
 * @author 洪家豪
 *         Created by acer on 2019/8/29.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageSplitConvertRateDTO{

    private Integer taskId;
    private List<PageSplitConvertRateXAndY> position;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PageSplitConvertRateXAndY {

        private String x;
        private String y;

    }
}


