package com.music.test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.music.service.TuPian;
import com.music.service.ZhihuPageProcessor;
import com.music.service.ZhihuPipeline;

import us.codecraft.webmagic.Spider;

@Component
public class ZhihuTask {

	 private static final Logger LOGGER = LoggerFactory.getLogger(ZhihuPipeline.class);

	    @Autowired
	    private ZhihuPipeline zhihuPipeline;

	    @Autowired
	    private ZhihuPageProcessor zhihuPageProcessor;
	    
	    @Autowired
	    private TuPian tuPian;

	    private ScheduledExecutorService timer = Executors.newSingleThreadScheduledExecutor();

	    public void crawl() {
	        // 定时任务，每10分钟爬取一次
	        timer.scheduleWithFixedDelay(() -> {
	            Thread.currentThread().setName("zhihuCrawlerThread");
	            Thread.currentThread().setName("tupianThred");

	            try {
	            	
	            	Spider.create(tuPian).addUrl("https://www.imooc.com/").thread(2).start();
	            	
	                Spider.create(zhihuPageProcessor)
	                        // 从https://www.zhihu.com/explore开始抓
	                        /*.addUrl("https://www.zhihu.com/explore")*/
	                .addUrl("http://kaijiang.500.com/dlt.shtml")
	                
	                        // 抓取到的数据存数据库
	                        .addPipeline(zhihuPipeline)
	                        // 开启2个线程抓取
	                        .thread(2)
	                        // 异步启动爬虫
	                        .start();
	            } catch (Exception ex) {
	                LOGGER.error("定时抓取知乎数据线程执行异常", ex);
	            }
	        }, 0, 10, TimeUnit.MINUTES);
	    }
}
