//package com.xupt.stealage.service.impl;
//
//import com.github.pagehelper.PageHelper;
//import com.github.pagehelper.PageInfo;
//import com.xupt.stealage.common.result.PageResult;
//import com.xupt.stealage.service.BrowseRecordService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class BrowseRecordServiceImpl implements BrowseRecordService {
//
//    @Autowired
//    private BrowseRecordMapper browseRecordMapper;
//
//    @Override
//    public Integer addBrowseRecord(BrowseRecord browseRecord) {
//        return browseRecordMapper.insertSelective(browseRecord);
//    }
//
//    @Override
//    public PageResult<BrowseRecord> getByUserId(Integer userId, int offset, int size) {
//        BrowseRecordExample example = new BrowseRecordExample();
//        example.setOrderByClause("create_time desc");
//
//        PageHelper.offsetPage(offset, size, true);
//        List<BrowseRecord> browseRecordList = browseRecordMapper.selectByExample(example);
//        PageInfo<BrowseRecord> pageInfo = new PageInfo<>(browseRecordList);
//        browseRecordList = pageInfo.getList();
//        return PageResult.create(pageInfo, browseRecordList);
//    }
//}
