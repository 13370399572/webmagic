package com.music.service;

import java.util.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.music.dao.CrawlerMapper;
import com.music.dao.SuperlottoMapper;
import com.music.entity.CmsContentPO;
import com.music.entity.Superlotto;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

//处理数据类

@Component
public class ZhihuPipeline implements Pipeline {
   
	@Autowired
    private CrawlerMapper crawlerMapper;
	
	@Autowired
	private SuperlottoMapper superlottoMapper;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ZhihuPipeline.class);
	
	@Override
	public void process(ResultItems resultItems, Task task) {
		// TODO Auto-generated method stub
		// String title = resultItems.get("title");
	      //  String answer = resultItems.get("answer");
		   Integer    first   = Integer.parseInt(resultItems.get("first")); 
		   Integer    secondArea   = Integer.parseInt(resultItems.get("secondArea")); 
		   Integer    threeAreas   = Integer.parseInt(resultItems.get("threeAreas")); 
		   Integer    fourAreas   = Integer.parseInt(resultItems.get("fourAreas")); 
		   Integer    fiveArea   = Integer.parseInt(resultItems.get("fiveArea")); 
		   Integer    sixArea   = Integer.parseInt(resultItems.get("sixArea")); 
		   Integer    sevenArea   = Integer.parseInt(resultItems.get("sevenArea")); 
		   Long    periods   = Long.parseLong(resultItems.get("periods")); 
	        /*CmsContentPO contentPO = new CmsContentPO();
	        contentPO.setContentId(UUID.randomUUID().toString());
	        contentPO.setTitle(title);
	        contentPO.setReleaseDate(new Date());
	        contentPO.setContent(answer);*/
		   Superlotto superlotto = new Superlotto();
		   superlotto.setFirst(first);
		   superlotto.setSecondArea(secondArea);
		   superlotto.setThreeAreas(threeAreas);
		   superlotto.setFourAreas(fourAreas);
		   superlotto.setFiveArea(fiveArea);
		   superlotto.setSixArea(sixArea);
		   superlotto.setSevenArea(sevenArea);
		   superlotto.setPeriods(periods);
		   superlotto.setId(UUID.randomUUID().toString());
		   

	        try {
	            boolean success = superlottoMapper.addSuper(superlotto) > 0;
	            LOGGER.info("保存知乎文章成功：{}", "hhh");
	        } catch (Exception ex) {
	            LOGGER.error("保存知乎文章失败", ex);
	        }
		
	}

}
