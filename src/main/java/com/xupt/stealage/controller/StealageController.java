package com.xupt.stealage.controller;

import com.google.common.collect.Lists;
import com.xupt.stealage.common.result.JsonResult;
import com.xupt.stealage.common.result.PageResult;
import com.xupt.stealage.controller.req.StealageReq;
import com.xupt.stealage.controller.resp.StealageResp;
import com.xupt.stealage.controller.resp.StealageStatusResp;
import com.xupt.stealage.data.StealageStatus;
import com.xupt.stealage.model.Stealage;
import com.xupt.stealage.model.StealageType;
import com.xupt.stealage.model.User;
import com.xupt.stealage.service.StealageService;
import com.xupt.stealage.service.StealageTypeService;
import com.xupt.stealage.service.UserService;
import com.xupt.stealage.util.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 失物招领相关接口
 */
@RestController
@RequestMapping(value = "/stealage")
@Slf4j
public class StealageController {

    @Value("${file.upload.path}")
    private String fileUploadPath;

    @Autowired
    private StealageService stealageService;

    @Autowired
    private StealageTypeService stealageTypeService;

    @Autowired
    private UserService userService;

    /**
     * 失物招领列表
     * @param userId userId
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @return
     */
    @RequestMapping(value = "/by/user_id", method = RequestMethod.GET)
    public JsonResult<PageResult<StealageResp>> queryByUserId(@RequestParam(name = "user_id") Integer userId,
                                                              @RequestParam(name = "page_num", defaultValue = "1") int pageNum,
                                                              @RequestParam(name = "page_size", defaultValue = "2147483647") int pageSize) {
        PageResult<Stealage> pageResult = stealageService.getByUserId(userId, (pageNum - 1) * pageSize, pageSize);
        return query(pageResult);
    }

    /**
     * 失物招领上传图片
     */
    @RequestMapping(value = "/upload_picture", method = RequestMethod.POST, consumes = "multipart/form-data")
    public JsonResult uploadPictures(@RequestParam(name = "file") MultipartFile file) {
        String path = FileUtils.uploadFile(fileUploadPath, file);
        return !StringUtils.isEmpty(path) ? JsonResult.success(path) : JsonResult.fail(-1, "失物招领上传图片失败！");
    }

    /**
     * 添加失物招领
     */
    @RequestMapping(method = RequestMethod.POST)
    public JsonResult addStealage(@Valid StealageReq stealageReq) {
        Integer result = stealageService.addStealage(StealageReq.convert(stealageReq));
        return result == 1 ? JsonResult.success() : JsonResult.fail(-1, "添加失败！");
    }

    /**
     * 删除失物招领
     */
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    public JsonResult deleteStealage(@PathVariable Integer id) {
        Integer result = stealageService.deleteStealage(id);
        return result == 1 ? JsonResult.success() : JsonResult.fail(-1, "删除失败！");
    }

    /**
     * 根据失物招领名称、描述、地址搜索
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public JsonResult<PageResult<StealageResp>> query(@RequestParam(name = "name") String name,
                                                      @RequestParam(name = "page_num", defaultValue = "1") int pageNum,
                                                      @RequestParam(name = "page_size", defaultValue = "2147483647") int pageSize) {
        PageResult<Stealage> pageResult = stealageService.getByName(name, (pageNum - 1) * pageSize, pageSize);
        JsonResult<PageResult<StealageResp>> jsonResult = query(pageResult);
        return jsonResult;
    }

    /**
     * 首页面
     */
    @RequestMapping(method = RequestMethod.GET)
    public JsonResult<PageResult<StealageResp>> query(@RequestParam(name = "page_num", defaultValue = "1") int pageNum,
                                                      @RequestParam(name = "page_size", defaultValue = "2147483647") int pageSize) {
        PageResult<Stealage> pageResult =
                stealageService.getByStatuses(Lists.newArrayList(StealageStatus.PENDING, StealageStatus.PROCESSING), (pageNum - 1) * pageSize, pageSize);
        return query(pageResult);
    }

    /**
     * 失物招领列表
     * @param stealageTypeId 失物招领类型id
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @return
     */
    @RequestMapping(value = "/by/stealage_type", method = RequestMethod.GET)
    public JsonResult<PageResult<StealageResp>> queryByStealageTypeId(@RequestParam(name = "stealage_type_id") Integer stealageTypeId,
                                                                      @RequestParam(name = "is_recruitment", required = false) Boolean isRecruitment,
                                                                      @RequestParam(name = "page_num", defaultValue = "1") int pageNum,
                                                                      @RequestParam(name = "page_size", defaultValue = "2147483647") int pageSize) {
        PageResult<Stealage> pageResult = stealageService.getByStealageTypeId(stealageTypeId, isRecruitment, (pageNum - 1) * pageSize, pageSize);
        return query(pageResult);
    }

    /**
     * 失物招领列表
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @return
     */
    @RequestMapping(value = "/by/status", method = RequestMethod.GET)
    public JsonResult<PageResult<StealageResp>> queryByStatus(@RequestParam(name = "status") String status,
                                                              @RequestParam(name = "page_num", defaultValue = "1") int pageNum,
                                                              @RequestParam(name = "page_size", defaultValue = "2147483647") int pageSize) {
        PageResult<Stealage> pageResult = stealageService.getByStatuses(Lists.newArrayList(StealageStatus.valueOf(status)), (pageNum - 1) * pageSize, pageSize);
        return query(pageResult);
    }

    /**
     * 失物招领列表
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @return
     */
    @RequestMapping(value = "/by/is_recruitment", method = RequestMethod.GET)
    public JsonResult<PageResult<StealageResp>> queryByIsRecruitment(@RequestParam(name = "is_recruitment") boolean isRecruitment,
                                                                     @RequestParam(name = "page_num", defaultValue = "1") int pageNum,
                                                                     @RequestParam(name = "page_size", defaultValue = "2147483647") int pageSize) {
        PageResult<Stealage> pageResult = stealageService.getByIsRecruitment(isRecruitment, (pageNum - 1) * pageSize, pageSize);
        return query(pageResult);
    }

    /**
     * 失物招领轮播图
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @return
     */
    @RequestMapping(value = "/by/is_recruitment/carousel", method = RequestMethod.GET)
    public JsonResult<List<List<StealageResp>>> queryByIsRecruitment(@RequestParam(name = "is_recruitment") boolean isRecruitment,
                                                                     @RequestParam(name = "split") int split,
                                                                     @RequestParam(name = "page_num", defaultValue = "1") int pageNum,
                                                                     @RequestParam(name = "page_size", defaultValue = "9") int pageSize) {
        PageResult<Stealage> pageResult = stealageService.getByIsRecruitment(isRecruitment, (pageNum - 1) * pageSize, pageSize);
        List<StealageResp> stealageResps = query(pageResult).getData().getItems();
        return JsonResult.success(Lists.partition(stealageResps, split));
    }

    /**
     * 失物招领状态列表
     */
    @RequestMapping(value = "/stealage_statues", method = RequestMethod.GET)
    public JsonResult<List<StealageStatusResp>> queryStealageStatues() {
        List<StealageStatusResp> stealageStatusResps = Arrays.stream(StealageStatus.values()).map(StealageStatusResp::convert).collect(Collectors.toList());
        return JsonResult.success(stealageStatusResps);
    }

    /**
     * 失物招领时间列表
     */
    @RequestMapping(value = "/days_of_this_maonth", method = RequestMethod.GET)
    public JsonResult<List<Integer>> queryDaysOfThisMonth() {
        List<Integer> days = stealageService.getDaysOfThisMonth();
        return JsonResult.success(days);
    }

    /**
     * 失物招领列表
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @return
     */
    @RequestMapping(value = "/by/day", method = RequestMethod.GET)
    public JsonResult<PageResult<StealageResp>> queryByDay(@RequestParam(name = "day") int day,
                                                           @RequestParam(name = "page_num", defaultValue = "1") int pageNum,
                                                           @RequestParam(name = "page_size", defaultValue = "2147483647") int pageSize) {
        PageResult<Stealage> pageResult = stealageService.getByDayOfThisMonth(day, (pageNum - 1) * pageSize, pageSize);
        return query(pageResult);
    }

    /**
     * 详情
     * @return
     */
    @RequestMapping(value = "/{id}/get_info", method = RequestMethod.GET)
    public JsonResult<StealageResp> geStealageInfo(@PathVariable Integer id) {
        Stealage stealage = stealageService.getById(id);
        if (stealage == null) {
            return JsonResult.fail(-1, "获取失物招领详情失败，无对应" + id + "的失物招领");
        }
        StealageType stealageType = stealageTypeService.getById(stealage.getTypeId());
        User user = userService.getById(stealage.getUserId());
        return JsonResult.success(StealageResp.convert(stealage, stealageType, user));
    }

    private JsonResult<PageResult<StealageResp>> query(PageResult<Stealage> pageResult) {
        List<Integer> stealageTypeIds = pageResult.getItems().stream().map(Stealage::getTypeId).distinct().collect(Collectors.toList());
        List<StealageType> stealageTypes = stealageTypeService.getByIds(stealageTypeIds);
        List<Integer> userIds = pageResult.getItems().stream().map(Stealage::getUserId).distinct().collect(Collectors.toList());
        List<User> users = userService.getByIds(userIds);

        List<StealageResp> stealageResps = pageResult.getItems().stream().map(stealage -> StealageResp.convert(stealage, stealageTypes, users)).collect(Collectors.toList());
        PageResult<StealageResp> respPageResult = PageResult.fromPageResult(stealageResps, pageResult);
        return JsonResult.success(respPageResult);
    }
}
