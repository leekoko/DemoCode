package com.leekoko.nytzj.flow.dao.spider;

import cn.hutool.http.HttpUtil;
import org.junit.Test;

public class SpiderTest {

    @Test
    public void spider(){
        String listContent = HttpUtil.get("https://s.taobao.com/search?q=%E7%94%B5%E5%8A%A8%E7%89%99%E5%88%B7&imgfile=&commend=all&ssid=s5-e&search_type=item&sourceId=tb.index&spm=a21bo.21814703.201856-taobao-item.1&ie=utf8&initiative_id=tbindexz_20170306");
        System.out.println(listContent);
    }

}
