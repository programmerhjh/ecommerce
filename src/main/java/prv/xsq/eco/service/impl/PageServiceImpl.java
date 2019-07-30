package prv.xsq.eco.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prv.xsq.eco.dto.CategoryDTO;
import prv.xsq.eco.entities.SessionAggrStat;
import prv.xsq.eco.entities.SessionRandomExtract;
import prv.xsq.eco.entities.Task;
import prv.xsq.eco.entities.Top10Session;
import prv.xsq.eco.mapper.DataMapper;
import prv.xsq.eco.service.PageService;

import java.util.List;

/**
 * @author 洪家豪
 *         Created by acer on 2019/7/10.
 */
@Service
public class PageServiceImpl implements PageService{

    @Autowired
    private DataMapper dataMapper;

    @Override
    public List<SessionAggrStat> getAllSessionAggrStat() {
        return dataMapper.getAllSessionAggrStat();
    }

    @Override
    public SessionAggrStat getSessionAggrStatByTaskId(Integer taskId) {
        return dataMapper.getSessionAggrStatByTaskId(taskId);
    }

    @Override
    public List<SessionRandomExtract> getRandomExtractByTaskId(Integer taskId, Integer pageNum, Integer column) {
        return dataMapper.getRandomExtractByTaskId(taskId);
    }

    @Override
    public List<SessionRandomExtract> getAllRandomExtract(Integer pageNum, Integer column) {
        return dataMapper.getAllRandomExtract();
    }

    @Override
    public List<Task> getAllTaskInfo(Integer pageNum, Integer column) {
        return dataMapper.getAllTaskInfo();
    }

    @Override
    public List<Task> getTaskById(Integer taskId, Integer pageNum, Integer column) {
        return dataMapper.getTaskById(taskId);
    }

    @Override
    public List<CategoryDTO> getTopTenCategory(Integer type) {
        List<CategoryDTO> list = null;
        switch (type){
            case 1:
                list = dataMapper.getTopTenCategoryClickCount();
                break;
            case 2:
                list = dataMapper.getTopTenCategoryOrderCount();
                break;
            case 3:
                list = dataMapper.getTopTenCategoryPayCount();
                break;
        }
        return list;
    }

    @Override
    public List<Top10Session> getTopTenSessionByTaskId(Integer taskId, Integer pageNum, Integer column) {
        return dataMapper.getTopTenSessionByTaskId(taskId);
    }

    @Override
    public List<Top10Session> getAllTopTenSession(Integer pageNum, Integer column) {
        return dataMapper.getTopTenSession();
    }
}
