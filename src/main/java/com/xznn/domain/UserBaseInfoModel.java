package com.xznn.domain;

/**
 *
 */
public class UserBaseInfoModel extends BaseModel {


    private static final long serialVersionUID = 1L;

    public UserBaseInfoModel() {
    }

    /**
     * @param uid        用户唯一标志符
     * @param name       用户昵称
     * @param sex        0-女 1-男
     * @param image      头像
     * @param phone      手机号
     * @param regIp      注册ip
     * @param registTime 注册时间戳(秒)
     * @param channelId  注册渠道
     */
    public UserBaseInfoModel(int uid, String name, int sex, String image, String phone, String regIp, int registTime, int channelId) {
        this.uid = uid;
        this.name = name;
        this.sex = sex;
        this.image = image;
        this.phone = phone;
        this.regIp = regIp;
        this.registTime = registTime;
        this.channelId = channelId;
    }

    private int submeterId = -1;

    public int getSubmeterId() {
        return submeterId;
    }

    public void setSubmeterId(int submeterId) {
        this.submeterId = submeterId;
    }

    @Override
    public long id() {
        return uid;
    }

    @Override
    public void setIdValue(long id) {
        this.uid = (int) id;
    }

    public static String[] PROPS = new String[]{"`submeterId`", "`uid`", "`name`", "`sex`", "`image`", "`phone`", "`regIp`", "`registTime`", "`channelId`", "`birth`", "`profession`", "`city`", "`tags`", "`voicePricePer`", "`voiceStartTime`", "`voiceEndTime`", "`voiceOpen`", "`videoPricePer`", "`videoStartTime`", "`videoEndTime`", "`videoOpen`", "`callStatus`", "`voiceRecommend`", "`imageLibrary`", "`sexCount`", "`state`", "`score`", "`unnotify`", "`latitude`", "`longitude`", "`unionId`"};

    @Override
    public Object[] insertPropValues() {
        return new Object[]{submeterId, uid, name, sex, image, phone, regIp, registTime, channelId, birth, profession, city, tags, voicePricePer, voiceStartTime, voiceEndTime, voiceOpen, videoPricePer, videoStartTime, videoEndTime, videoOpen, callStatus, voiceRecommend, imageLibrary, sexCount, state, score, unnotify, latitude, longitude, unionId};
    }

    @Override
    public String[] props() {
        return PROPS;
    }

    @Override
    public Object[] updatePropValues() {
        return new Object[]{submeterId, uid, name, sex, image, phone, regIp, registTime, channelId, birth, profession, city, tags, voicePricePer, voiceStartTime, voiceEndTime, voiceOpen, videoPricePer, videoStartTime, videoEndTime, videoOpen, callStatus, voiceRecommend, imageLibrary, sexCount, state, score, unnotify, latitude, longitude, unionId, uid};
    }


    private int uid;

    private String name;

    private int sex;

    private String image;

    private String phone;

    private String regIp;

    private int registTime;

    private int channelId;

    private int birth;

    private String profession;

    private String city;

    private String tags;

    private int voicePricePer;

    private int voiceStartTime;

    private int voiceEndTime;

    private int voiceOpen;

    private int videoPricePer;

    private int videoStartTime;

    private int videoEndTime;

    private int videoOpen;

    private int callStatus;

    private String voiceRecommend;

    private String imageLibrary;

    private int sexCount;

    private int state;

    private int score;

    private int unnotify;

    private float latitude;

    private float longitude;

    private String unionId;

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public int getUnnotify() {
        return unnotify;
    }

    public void setUnnotify(int unnotify) {
        this.unnotify = unnotify;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRegIp() {
        return regIp;
    }

    public void setRegIp(String regIp) {
        this.regIp = regIp;
    }

    public int getRegistTime() {
        return registTime;
    }

    public void setRegistTime(int registTime) {
        this.registTime = registTime;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public String getName() {
        return name;
    }

    public String getDecodeName() {
        return "Base64Utils.decode(name)";
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String image() {
        return "UrlConstant.getImageUrl(image)";
    }

    public int getBirth() {
        return birth;
    }

    public void setBirth(int birth) {
        this.birth = birth;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public int getVoicePricePer() {
        return voicePricePer;
    }

    public void setVoicePricePer(int voicePricePer) {
        this.voicePricePer = voicePricePer;
    }

    public int getVoiceStartTime() {
        return voiceStartTime;
    }

    public void setVoiceStartTime(int voiceStartTime) {
        this.voiceStartTime = voiceStartTime;
    }

    public int getVoiceEndTime() {
        return voiceEndTime;
    }

    public void setVoiceEndTime(int voiceEndTime) {
        this.voiceEndTime = voiceEndTime;
    }

    public int getVoiceOpen() {
        return voiceOpen;
    }

    public void setVoiceOpen(int voiceOpen) {
        this.voiceOpen = voiceOpen;
    }

    public int getVideoPricePer() {
        return videoPricePer;
    }

    public void setVideoPricePer(int videoPricePer) {
        this.videoPricePer = videoPricePer;
    }

    public int getVideoStartTime() {
        return videoStartTime;
    }

    public void setVideoStartTime(int videoStartTime) {
        this.videoStartTime = videoStartTime;
    }

    public int getVideoEndTime() {
        return videoEndTime;
    }

    public void setVideoEndTime(int videoEndTime) {
        this.videoEndTime = videoEndTime;
    }

    public int getVideoOpen() {
        return videoOpen;
    }

    public void setVideoOpen(int videoOpen) {
        this.videoOpen = videoOpen;
    }

    public String getVoiceRecommend() {
        return voiceRecommend;
    }

    public void setVoiceRecommend(String voiceRecommend) {
        this.voiceRecommend = voiceRecommend;
    }

    public String getImageLibrary() {
        return imageLibrary;
    }

    public void setImageLibrary(String imageLibrary) {
        this.imageLibrary = imageLibrary;
    }

    public int getSexCount() {
        return sexCount;
    }

    public void setSexCount(int sexCount) {
        this.sexCount = sexCount;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getCallStatus() {
        return callStatus;
    }

    public void setCallStatus(int callStatus) {
        this.callStatus = callStatus;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }


}
