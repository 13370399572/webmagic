package com.music.dao;

import org.apache.ibatis.annotations.Mapper;

import com.music.common.Record;
import com.music.util.BaseMapper;

@Mapper
public interface RecordDao extends BaseMapper<Record> {
  
}
