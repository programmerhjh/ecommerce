package prv.xsq.eco.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prv.xsq.eco.dto.CategoryDTO;
import prv.xsq.eco.dto.PageSplitConvertRateDTO;
import prv.xsq.eco.entities.*;
import prv.xsq.eco.mapper.DataMapper;
import prv.xsq.eco.service.PageService;

import java.util.*;

/**
 * @author 洪家豪
 *         Created by acer on 2019/7/10.
 */
@Service
public class PageServiceImpl implements PageService{

    @Autowired
    private DataMapper dataMapper;

    /** 页面分割率中 convert_rate 字段 各个 X，Y 坐标值分割符 **/
    private static final String SRPARATOR = "\\|";

    /** 页面分割率中 convert_rate 字段 X，Y 坐标值中的分割符 **/
    private static final String XY_SRPARATOR = "\\=";

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

    @Override
    public List<PageSplitConvertRateDTO> getPageSplitConvertRate() {
        List<PageSplitConvertRate> convertRateList = dataMapper.getPageSplitConvertRate();
        List<PageSplitConvertRateDTO> dtoList = new ArrayList<>(convertRateList.size());
        for (int i = 0; i < convertRateList.size(); i++) {
            List<PageSplitConvertRateDTO.PageSplitConvertRateXAndY> xAndYList = getList(convertRateList.get(i));
            PageSplitConvertRateDTO temp = new PageSplitConvertRateDTO(convertRateList.get(i).getTaskId(), xAndYList);
            dtoList.add(temp);
        }
        return dtoList;
    }

    /**
     * 根据一个页面分割率实体获取其中的 X，Y 坐标，并对X坐标进行字典序排序
     * @param convertRate
     * @return
     */
    private List<PageSplitConvertRateDTO.PageSplitConvertRateXAndY> getList(PageSplitConvertRate convertRate){
        String params = convertRate.getConvertRate();
        String[] xyList = params.split(SRPARATOR);
        List<PageSplitConvertRateDTO.PageSplitConvertRateXAndY> result = new ArrayList<>(xyList.length);
        for (int i = 0; i < xyList.length; i++) {
            String[] xAndY = xyList[i].split(XY_SRPARATOR);
            PageSplitConvertRateDTO.PageSplitConvertRateXAndY temp = new PageSplitConvertRateDTO.PageSplitConvertRateXAndY(xAndY[0], xAndY[1]);
            result.add(temp);
        }

        Collections.sort(result, new Comparator<PageSplitConvertRateDTO.PageSplitConvertRateXAndY>() {
            @Override
            public int compare(PageSplitConvertRateDTO.PageSplitConvertRateXAndY o1, PageSplitConvertRateDTO.PageSplitConvertRateXAndY o2) {
                return o1.getX().compareTo(o2.getX());
            }
        });
        return result;
    }

}
