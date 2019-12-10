package com.music.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.music.common.Superlotto;
import com.music.dao.SuperlittoDao;

@Service
public class SuperlittoServicemipl implements SuperlittoService {
    
	@Autowired
	private SuperlittoDao superlittoDao;
	
	/**
	 * 添加期号
	 * @return
	 */
	public  int add(Superlotto superlotto)  {
		
	return	superlittoDao.insert(superlotto);
	}
     /**
      *更新不为null的值
      * @param superlotto
      * @return
      */
	public int update(Superlotto superlotto) {
		
		return superlittoDao.updateByPrimaryKeySelective(superlotto);
	}
	
	/**
	 * 根据主见进行删除
	 * @param id
	 * @return
	 */
	public int deletesuperlitto(Long id) {
	return	superlittoDao.deleteByPrimaryKey(id);
	}
	
	/**
	 * 根据主机id查询
	 * @param id
	 * @return
	 */
	public Superlotto selete(Long id) {
		return superlittoDao.selectByPrimaryKey(id);
	}
	
	public List<Superlotto> selectList() {
		return superlittoDao.selectAll();
	}
}

