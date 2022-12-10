package com.xupt.stealage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xupt.stealage.common.result.PageResult;
import com.xupt.stealage.data.StealageStatus;
import com.xupt.stealage.mapper.StealageMapper;
import com.xupt.stealage.model.Stealage;
import com.xupt.stealage.model.StealageExample;
import com.xupt.stealage.service.StealageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StealageServiceImpl implements StealageService {

    @Autowired
    private StealageMapper stealageMapper;

    @Override
    public Integer addStealage(Stealage stealage) {
        return stealageMapper.insertSelective(stealage);
    }

    @Override
    public Stealage getById(Integer id) {
        return stealageMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Stealage> getByIds(List<Integer> ids) {
        StealageExample example = new StealageExample();
        example.createCriteria().andIdIn(ids);
        return stealageMapper.selectByExample(example);
    }

    @Override
    public PageResult<Stealage> getByStatuses(List<StealageStatus> stealageStatuses, int offset, int size) {
        StealageExample example = new StealageExample();
        example.setOrderByClause("create_time desc, stealage_time desc");
        example.createCriteria().andStatusIn(stealageStatuses.stream().map(Enum::name).collect(Collectors.toList()));

        return getByPage(example, offset, size);
    }

    @Override
    public PageResult<Stealage> getByName(String name, int offset, int size) {
        StealageExample example = new StealageExample();
        example.setOrderByClause("create_time desc, stealage_time desc");
        StealageExample.Criteria nameCriteria = example.createCriteria();
        nameCriteria.andNameLike("%" + name + "%");
        StealageExample.Criteria descriptionCriteria = example.createCriteria();
        descriptionCriteria.andDescriptionLike("%" + name + "%");
        StealageExample.Criteria placeCriteria = example.createCriteria();
        placeCriteria.andPlaceLike("%" + name + "%");
        example.or(nameCriteria);
        example.or(descriptionCriteria);
        example.or(placeCriteria);
        return getByPage(example, offset, size);
    }

    @Override
    public PageResult<Stealage> getByStealageTypeId(int stealageTypeId, int offset, int size) {
        StealageExample example = new StealageExample();
        example.createCriteria().andTypeIdEqualTo(stealageTypeId);
        example.setOrderByClause("create_time desc, stealage_time desc");

        return getByPage(example, offset,size);
    }

    @Override
    public PageResult<Stealage> getByIsRecruitment(boolean isRecruitment, int offset, int size) {
        StealageExample example = new StealageExample();
        example.setOrderByClause("create_time desc, stealage_time desc");
        example.createCriteria().andIsRecruitmentEqualTo(isRecruitment).andStatusIn(StealageStatus.UN_COMPLETED.stream().map(Enum::name).collect(Collectors.toList()));

        return getByPage(example, offset, size);
    }

    @Override
    public PageResult<Stealage> getByUserId(int userId, int offset, int size) {
        StealageExample example = new StealageExample();
        example.createCriteria().andUserIdEqualTo(userId);
        example.setOrderByClause("create_time desc, stealage_time desc");

        return getByPage(example, offset,size);
    }

    @Override
    public List<Integer> getDaysOfThisMonth() {
        LocalDate now = LocalDate.now(ZoneId.of("GMT+8"));
        LocalDate firstDay = now.with(TemporalAdjusters.firstDayOfMonth());
        Date firstDayDate = Date.from(LocalDateTime.of(firstDay, LocalTime.of(0, 0, 0)).atZone(ZoneId.of("GMT+8")).toInstant());
        LocalDate lastDay = now.with(TemporalAdjusters.lastDayOfMonth());
        Date lastDayDate = Date.from(LocalDateTime.of(lastDay, LocalTime.of(23, 59, 59)).atZone(ZoneId.of("GMT+8")).toInstant());

        StealageExample example = new StealageExample();
        example.createCriteria().andStealageTimeBetween(firstDayDate, lastDayDate);
        return stealageMapper.selectByExample(example).stream()
                .map(stealage -> LocalDateTime.ofInstant(stealage.getStealageTime().toInstant(), ZoneId.of("GMT+8")).getDayOfMonth())
                .sorted()
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public PageResult<Stealage> getByDayOfThisMonth(int day, int offset, int size) {
        LocalDate dayLocalDate = LocalDate.now(ZoneId.of("GMT+8")).withDayOfMonth(day);
        Date startDayDate = Date.from(LocalDateTime.of(dayLocalDate, LocalTime.of(0, 0, 0)).atZone(ZoneId.of("GMT+8")).toInstant());
        Date endDayDate = Date.from(LocalDateTime.of(dayLocalDate, LocalTime.of(23, 59, 59)).atZone(ZoneId.of("GMT+8")).toInstant());

        StealageExample example = new StealageExample();
        example.createCriteria().andStealageTimeBetween(startDayDate, endDayDate);
        example.setOrderByClause("create_time desc, stealage_time desc");
        return getByPage(example, offset,size);
    }

    @Override
    public Integer updateStealageById(Stealage stealage) {
        return stealageMapper.updateByPrimaryKeySelective(stealage);
    }

    private PageResult<Stealage> getByPage(StealageExample example, int offset, int size) {
        PageHelper.offsetPage(offset, size, true);
        List<Stealage> stealageList = stealageMapper.selectByExample(example);
        PageInfo<Stealage> pageInfo = new PageInfo<>(stealageList);
        stealageList = pageInfo.getList();
        return PageResult.create(pageInfo, stealageList);
    }
}
