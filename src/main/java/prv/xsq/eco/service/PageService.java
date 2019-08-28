package prv.xsq.eco.service;

import prv.xsq.eco.dto.CategoryDTO;
import prv.xsq.eco.dto.PageSplitConvertRateDTO;
import prv.xsq.eco.entities.*;

import java.util.List;

/**
 * @author 洪家豪
 *         Created by acer on 2019/6/27.
 */
public interface PageService {

    /**
     * 获取所有的SessionAggrStat信息
     * @return
     */
    List<SessionAggrStat> getAllSessionAggrStat();

    /**
     * 根据任务ID获取某一个SessionAggrStat信息
     * @param taskId 任务ID
     * @return
     */
    SessionAggrStat getSessionAggrStatByTaskId(Integer taskId);

    /**
     * 获取某个任务的随机行为
     * @param taskId
     * @return
     */
    List<SessionRandomExtract> getRandomExtractByTaskId(Integer taskId, Integer pageNum, Integer column);

    /**
     * 获取所有随机行为
     * @return
     */
    List<SessionRandomExtract> getAllRandomExtract(Integer pageNum, Integer column);

    /**
     * 获取所有的任务信息
     * @return
     */
    List<Task> getAllTaskInfo(Integer pageNum, Integer column);

    /**
     * 根据任务ID查出具体任务
     * @param taskId
     * @return
     */
    List<Task> getTaskById(Integer taskId, Integer pageNum, Integer column);

    /**
     * 查询category表特定的行为数据
     * @param type 1代表查询click数据，2代表查询order数据，3代表查询pay数据
     * @return
     */
    List<CategoryDTO> getTopTenCategory(Integer type);

    /**
     * 根据taskId查询session表特定的行为数据
     * @param taskId
     * @return
     */
    List<Top10Session> getTopTenSessionByTaskId(Integer taskId, Integer pageNum, Integer column);

    /**
     * 分页获取前十session信息
     * @param pageNum
     * @param column
     * @return
     */
    List<Top10Session> getAllTopTenSession(Integer pageNum, Integer column);

    /**
     * 获取所有的页面分割转换率
     * @return
     */
    List<PageSplitConvertRateDTO> getPageSplitConvertRate();

}
