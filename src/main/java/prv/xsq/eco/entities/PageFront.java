package prv.xsq.eco.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 洪家豪
 *         Created by acer on 2019/7/12.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageFront {
    private Integer code;
    private String msg;
    private Integer count;
    private Object data;
}
