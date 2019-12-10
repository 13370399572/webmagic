package com.music.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.music.common.Record;
import com.music.dao.RecordDao;

@Service
public class RecordServiceImpl implements RecordService {

	@Autowired
	private RecordDao recordDao;
	
	@Override
	public int inserRecord(Record record) {
	return  recordDao.insert(record);
	}

}
