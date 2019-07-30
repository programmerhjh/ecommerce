package prv.xsq.eco.mapper;

import org.apache.ibatis.annotations.*;
import prv.xsq.eco.dto.CategoryDTO;
import prv.xsq.eco.entities.*;

import java.util.List;

/**
 * @author 洪家豪
 *         Created by acer on 2019/6/27.
 */
@Mapper
public interface DataMapper {

    /**
     * 获取所有的SessionAggrStat信息
     * @return
     */
    @Results(id = "sessionAggrStatMap", value = {
            @Result(property = "taskid", column = "task_id"),
            @Result(property = "session_count", column = "session_count"),
            @Result(property = "visit_length_1s_3s_ratio", column = "1s_3s"),
            @Result(property = "visit_length_4s_6s_ratio", column = "4s_6s"),
            @Result(property = "visit_length_7s_9s_ratio", column = "7s_9s"),
            @Result(property = "visit_length_10s_30s_ratio", column = "10s_30s"),
            @Result(property = "visit_length_30s_60s_ratio", column = "30s_60s"),
            @Result(property = "visit_length_1m_3m_ratio", column = "1m_3m"),
            @Result(property = "visit_length_3m_10m_ratio", column = "3m_10m"),
            @Result(property = "visit_length_10m_30m_ratio", column = "10m_30m"),
            @Result(property = "visit_length_30m_ratio", column = "30m"),
            @Result(property = "step_length_1_3_ratio", column = "1_3"),
            @Result(property = "step_length_4_6_ratio", column = "4_6"),
            @Result(property = "step_length_7_9_ratio", column = "7_9"),
            @Result(property = "step_length_10_30_ratio", column = "10_30"),
            @Result(property = "step_length_30_60_ratio", column = "30_60"),
            @Result(property = "step_length_60_ratio", column = "60")
    })
    @Select(value = "SELECT * FROM session_aggr_stat")
    List<SessionAggrStat> getAllSessionAggrStat();

    /**
     * 根据任务ID获取某一个SessionAggrStat信息
     * @param taskId 任务ID
     * @return
     */
    @ResultMap(value = "sessionAggrStatMap")
    @Select(value = "SELECT * FROM session_aggr_stat WHERE task_id=#{taskId}")
    SessionAggrStat getSessionAggrStatByTaskId(Integer taskId);

    /**
     * 获取某个任务的随机行为
     * @param taskId
     * @return
     */
    @Results(id = "sessionRandomExtractMap",value = {
            @Result(property = "taskid", column = "task_id"),
            @Result(property = "sessionid", column = "session_id"),
            @Result(property = "startTime", column = "start_time"),
            @Result(property = "searchKeywords", column = "search_keywords"),
            @Result(property = "clickCategoryIds", column = "click_category_ids"),
    })
    @Select(value = "SELECT * FROM session_random_extract WHERE task_id=#{taskId}")
    List<SessionRandomExtract> getRandomExtractByTaskId(Integer taskId);

    /**
     * 获取所有随机行为
     * @return
     */
    @ResultMap(value = "sessionRandomExtractMap")
    @Select(value = "SELECT * FROM session_random_extract")
    List<SessionRandomExtract> getAllRandomExtract();

    /**
     * 获取所有的任务信息
     * @return
     */
    @Results(id = "taskMap", value = {
            @Result(property = "taskid", column = "task_id"),
            @Result(property = "taskName", column = "task_name"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "startTime", column = "start_time"),
            @Result(property = "finishTime", column = "finish_time"),
            @Result(property = "taskType", column = "task_type"),
            @Result(property = "taskStatus", column = "task_status"),
            @Result(property = "taskParam", column = "task_param")
    })
    @Select(value = "SELECT * FROM task")
    List<Task> getAllTaskInfo();

    /**
     * 根据任务ID查出具体任务
     * @param taskId
     * @return
     */
    @ResultMap(value = "taskMap")
    @Select(value = "SELECT * FROM task WHERE task_id=#{taskId}")
    List<Task> getTaskById(Integer taskId);

    /**
     * 查询categoryTOP10表所有数据
     * @return
     */
    @Results(value = {
            @Result(property = "taskId", column = "task_id"),
            @Result(property = "data", column = "click_count")
    })
    @Select(value = "SELECT task_id, AVG(click_count) click_count FROM top10_category GROUP BY task_id;")
    List<CategoryDTO> getTopTenCategoryClickCount();

    @Results(value = {
            @Result(property = "taskId", column = "task_id"),
            @Result(property = "data", column = "order_count")
    })
    @Select(value = "SELECT task_id, AVG(order_count) order_count FROM top10_category GROUP BY task_id;")
    List<CategoryDTO> getTopTenCategoryOrderCount();

    @Results(value = {
            @Result(property = "taskId", column = "task_id"),
            @Result(property = "data", column = "pay_count")
    })
    @Select(value = "SELECT task_id, AVG(pay_count) pay_count FROM top10_category GROUP BY task_id;")
    List<CategoryDTO> getTopTenCategoryPayCount();

    /**
     * 获取所有Session信息
     * @return
     */
    @Results(id = "topSessionMap", value = {
            @Result(property = "taskid", column = "task_id"),
            @Result(property = "categoryid", column = "category_id"),
            @Result(property = "sessionid", column = "session_id"),
            @Result(property = "clickCount", column = "click_count")
    })
    @Select(value = "SELECT * FROM top10_category_session")
    List<Top10Session> getTopTenSession();

    /**
     * 根据任务ID获取具体的session信息
     * @param taskId
     * @return
     */
    @ResultMap(value = "topSessionMap")
    @Select(value = "SELECT * FROM top10_category_session WHERE task_id=#{taskId}")
    List<Top10Session> getTopTenSessionByTaskId(Integer taskId);

}
