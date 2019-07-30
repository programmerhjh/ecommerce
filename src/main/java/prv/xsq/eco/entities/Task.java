package prv.xsq.eco.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 洪家豪
 *         Created by acer on 2019/6/27.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    private long taskid;
    private String taskName;
    private String createTime;
    private String startTime;
    private String finishTime;
    private String taskType;
    private String taskStatus;
    private String taskParam;
}
