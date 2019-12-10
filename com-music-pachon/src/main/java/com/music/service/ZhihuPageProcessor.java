package com.music.service;

import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.music.dao.SuperlottoMapper;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
//抓去数据分析
import us.codecraft.webmagic.selector.Html;

@Component
public class ZhihuPageProcessor implements PageProcessor {
	// 抓取网站的相关配置，包括：编码、抓取间隔、重试次数等
	private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

	@Autowired
	private SuperlottoMapper superlottoMapper;
	@Override
	public void process(Page page) {
		//发现后续的url地址抓取
		/*page.addTargetRequests(page.getHtml().links().regex("https://www\\.zhihu\\.com/question/\\d+/answer/\\d+.*").all());
        page.putField("title", page.getHtml().xpath("//h1[@class='QuestionHeader-title']/text()").toString());
        page.putField("answer", page.getHtml().xpath("//div[@class='QuestionAnswer-content']/tidyText()").toString());*/
		page.putField("periods", page.getHtml().xpath("//font[@class='cfont2']/strong/text()").toString());
		page.putField("first", page.getHtml().xpath("//div[@class='ball_box01']/ul/li[1]/text()").toString());
		page.putField("secondArea", page.getHtml().xpath("//div[@class='ball_box01']/ul/li[2]/text()").toString());
		page.putField("threeAreas", page.getHtml().xpath("//div[@class='ball_box01']/ul/li[3]/text()").toString());
		page.putField("fourAreas", page.getHtml().xpath("//div[@class='ball_box01']/ul/li[4]/text()").toString());
		page.putField("fiveArea", page.getHtml().xpath("//div[@class='ball_box01']/ul/li[5]/text()").toString());
		page.putField("sixArea", page.getHtml().xpath("//div[@class='ball_box01']/ul/li[6]/text()").toString());
		page.putField("sevenArea", page.getHtml().xpath("//div[@class='ball_box01']/ul/li[7]/text()").toString());
		//String xxx= page.getResultItems().get("periods");
	//	String teString = page.getResultItems().get("test");
	Long periods	=Long.parseLong( page.getResultItems().get("periods"));
        if (superlottoMapper.selectSuper(periods)>0) {
            // 如果是列表页，跳过此页，pipeline不进行后续处理
        	  page.setSkip(true);
        	//pipeline继续处理
           // page.setSkip(false);
        }
		    
	}

	@Override
	public Site getSite() {
		return site;
	}

}
