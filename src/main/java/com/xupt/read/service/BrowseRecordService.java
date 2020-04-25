package com.xupt.read.service;

import com.xupt.read.common.result.PageResult;
import com.xupt.read.model.BrowseRecord;

public interface BrowseRecordService {

    Integer addBrowseRecord(BrowseRecord browseRecord);

    PageResult<BrowseRecord> getByUserId(Integer userId, int offset, int size);
}
