package prv.xsq.eco.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import prv.xsq.eco.dto.PageSplitConvertRateDTO;
import prv.xsq.eco.entities.*;
import prv.xsq.eco.service.PageService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author 洪家豪
 *         Created by acer on 2019/6/27.
 */
@Controller
public class IndexController {

    @Autowired
    private PageService pageService;

    @RequestMapping(value = "index")
    public String hello(HttpServletRequest request) {
        return "html/index";
    }

    @RequestMapping(value = "at")
    @ResponseBody
    public String accesstime(@RequestParam(value = "taskId", required = false) Integer taskId) {
        if (taskId != null) {
            SessionAggrStat sessionAggrStat = pageService.getSessionAggrStatByTaskId(taskId);
            return JSON.toJSONString(sessionAggrStat);
        }
        List<SessionAggrStat> sessionAggrStats = pageService.getAllSessionAggrStat();
        return JSON.toJSONString(sessionAggrStats);
    }

    @RequestMapping(value = "accesstime")
    public String accesstime() {
        return "html/accesstime";
    }

    @RequestMapping(value = "accessstep")
    public String accessstep(HttpServletRequest request) {
        return "html/accessstep";
    }

    @RequestMapping(value = "randomextract")
    public String randomextract(HttpServletRequest request) {
        return "html/randomextract";
    }

    /**
     * 分页获取SessionRandomExtract数据 前端请求参数默认为page和limit
     *
     * @param pageNum
     * @param column
     * @return
     */
    @RequestMapping(value = "re")
    @ResponseBody
    public String randomextract(@RequestParam(value = "taskId", required = false) Integer taskId, @RequestParam(value = "page", required = false, defaultValue = "1") Integer pageNum, @RequestParam(value = "limit", required = false, defaultValue = "10") Integer column) {
        PageHelper.startPage(pageNum, column);
        if (taskId != null) {
            List<SessionRandomExtract> extractByTaskId = pageService.getRandomExtractByTaskId(taskId, pageNum, column);
            PageInfo<SessionRandomExtract> pages = new PageInfo<>(extractByTaskId);
            PageFront pageFront = new PageFront(0, "success", extractByTaskId.size(), pages);
            return JSON.toJSONString(pageFront);
        }
        List<SessionRandomExtract> allRandomExtract = pageService.getAllRandomExtract(pageNum, column);
        PageInfo<SessionRandomExtract> pages = new PageInfo<>(allRandomExtract);
        PageFront pageFront = new PageFront(0, "success", allRandomExtract.size(), pages);
        return JSON.toJSONString(pageFront);
    }

    @RequestMapping(value = "task")
    public String task(HttpServletRequest request) {
        return "html/task";
    }

    /**
     * 分页获取Task数据 前端请求参数默认为page和limit
     *
     * @param pageNum
     * @param column
     * @return
     */
    @RequestMapping(value = "ts")
    @ResponseBody
    public String task(@RequestParam(value = "taskId", required = false) Integer taskId, @RequestParam(value = "page", required = false, defaultValue = "1") Integer pageNum, @RequestParam(value = "limit", required = false, defaultValue = "10") Integer column) {
        PageHelper.startPage(pageNum, column);
        if (taskId != null) {
            List<Task> tasksById = pageService.getTaskById(taskId, pageNum, column);
            PageInfo<Task> pages = new PageInfo<>(tasksById);
            PageFront pageFront = new PageFront(0, "success", tasksById.size(), pages);
            return JSON.toJSONString(pageFront);
        }
        List<Task> allTaskInfo = pageService.getAllTaskInfo(pageNum, column);
        PageInfo<Task> pages = new PageInfo<>(allTaskInfo);
        PageFront pageFront = new PageFront(0, "success", allTaskInfo.size(), pages);
        return JSON.toJSONString(pageFront);
    }

    /**
     * 获取topTenCategory扇形图所需数据
     *
     * @return
     */
    @RequestMapping(value = "ttc")
    @ResponseBody
    public String topTenCategory(@RequestBody Map map) {
        return JSON.toJSONString(pageService.getTopTenCategory(Integer.parseInt(map.get("type").toString())));
    }

    @RequestMapping(value = "category")
    public ModelAndView category(@RequestParam(value = "type") Integer type) {
        return new ModelAndView("html/category", "type", type);
    }

    @RequestMapping(value = "session")
    public String topTenSession() {
        return "html/session";
    }

    /**
     * 获取前十session
     *
     * @param taskId
     * @param pageNum
     * @param column
     * @return
     */
    @RequestMapping(value = "tts")
    @ResponseBody
    public String topTenSession(@RequestParam(value = "taskId", required = false) Integer taskId, @RequestParam(value = "page", required = false, defaultValue = "1") Integer pageNum, @RequestParam(value = "limit", required = false, defaultValue = "10") Integer column) {
        PageHelper.startPage(pageNum, column);
        if (taskId != null) {
            List<Top10Session> top10Sessions = pageService.getTopTenSessionByTaskId(taskId, pageNum, column);
            PageInfo<Top10Session> pages = new PageInfo<>(top10Sessions);
            PageFront pageFront = new PageFront(0, "success", top10Sessions.size(), pages);
            return JSON.toJSONString(pageFront);
        }
        List<Top10Session> allTopTenSession = pageService.getAllTopTenSession(pageNum, column);
        PageInfo<Top10Session> pages = new PageInfo<>(allTopTenSession);
        PageFront pageFront = new PageFront(0, "success", allTopTenSession.size(), pages);
        return JSON.toJSONString(pageFront);
    }


    @RequestMapping(value = "pscr")
    public String pageSplitConvertRate() {
        List<PageSplitConvertRateDTO> convertRate = pageService.getPageSplitConvertRate();
        return "html/pagesplitconvertrate";
    }

    /**
     * 页面分割率折线图数据
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "pscr_data")
    public String pageSplitConvertRateData() {
        return JSON.toJSONString(pageService.getPageSplitConvertRate());
    }

}