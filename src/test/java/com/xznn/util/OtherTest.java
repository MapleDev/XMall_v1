package com.xznn.util;

import com.alibaba.fastjson.JSON;
import com.xznn.domain.UserBaseInfoModel;
import junit.framework.TestCase;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public class OtherTest extends TestCase {

    private static Logger logger = Logger.getLogger(OtherTest.class);


    public void testJson() {
        String s = "{\"birth\":769363200,\"callStatus\":0,\"channelId\":3,\"city\":\"广东省 广州市 天河区\",\"decodeName\":\"夏浩文\",\"image\":\"10008/77I9K1D5IV73GLRKKK8C\",\"imageLibrary\":\"10008/VCHOIIJ8GTKSKTA79UU0|10008/Z6QAVUZ1Y9I1C2R98KDC|10008/9JP47YYC7FG3NRPHRACB|10008/8PRZ8QZQJFNU7X0LMH61|10008/78YVWKOJ933PAANZ7HRY|10008/STKU1QLJWDGSNCC3R4NE|10008/LNLK0BQG3R3MY8R16C8E|10008/BC7QHF59F7FOZ82Y1RML|10008/YEJRCCO56SPAG4FMH2CY\",\"name\":\"5aSP5rWp5paH\",\"regIp\":\"192.168.0.188\",\"registTime\":1539328583,\"score\":0,\"sex\":0,\"sexCount\":0,\"state\":0,\"submeterId\":8,\"tags\":\"泰勒斯威夫特_小奶狗_母老虎_美人儿_霸气御姐_小萝莉\",\"uid\":10008,\"unnotify\":0,\"videoEndTime\":0,\"videoOpen\":0,\"videoPricePer\":0,\"videoStartTime\":0,\"voiceEndTime\":0,\"voiceOpen\":0,\"voicePricePer\":0,\"voiceRecommend\":\"10008/XR2TZR4RYDG2FCCELEMZ\",\"voiceStartTime\":0}";
//        String s = "{\"birth\":769363200}";
//        String s = "{\"name\":\"5aSP5rWp5paH\"}";
        UserBaseInfoModel userBaseInfoModel = JSON.parseObject(s, UserBaseInfoModel.class);
        logger.info("userBaseInfoModel = " + userBaseInfoModel);

    }








}