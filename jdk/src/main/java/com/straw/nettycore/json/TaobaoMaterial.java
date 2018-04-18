package com.straw.nettycore.json;


import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 商品
 *
 * @author dongyushuai
 */

public class TaobaoMaterial implements Serializable {

    private static final long serialVersionUID = -5661913142804665410L;


    private String id;

    /**
     * 淘客点击链接
     */
    @JSONField(serialize = false)
    private transient String clickUrl;
    /**
     * 佣金比率
     */
    @JSONField(serialize = false)
    private String commissionRate;
    /**
     * 佣金类型
     */
    @JSONField(serialize = false)
    private transient String commissionType;
    /**
     * 商品&优惠券推广链接
     */

    private String couponClickUrl;
    /**
     * 优惠券结束时间
     */
    @JSONField(serialize = false)
    private Date couponEndTime;
    /**
     * 优惠券id
     */

    private String couponId;
    /**
     * 优惠券面额
     */

    private String couponInfo;
    /**
     * 优惠券剩余量
     */
    @JSONField(serialize = false)
    private Long couponRemainCount;
    /**
     * 优惠券开始时间
     */
    @JSONField(serialize = false)
    private Date couponStartTime;
    /**
     * 优惠券总量
     */
    @JSONField(serialize = false)
    private Long couponTotalCount;
    /**
     * 是否包含定向计划
     */
    @JSONField(serialize = false)
    private String includeDxjh;
    /**
     * 是否包含营销计划
     */
    @JSONField(serialize = false)
    private String includeMkt;
    /**
     * 定向计划信息
     */
    @JSONField(serialize = false)
    private String infoDxjh;
    /**
     * 商品地址
     */

    private String itemUrl;
    /**
     * 宝贝id
     */

    private Long numIid;
    /**
     * 商品主图
     */

    private String pictUrl;
    /**
     * 宝贝所在地
     */
    @JSONField(serialize = false)
    private String provcity;
    /**
     * 商品一口价格
     */

    private Float reservePrice;
    /**
     * 卖家id
     */
    @JSONField(serialize = false)
    private Long sellerId;
    /**
     * 店铺名称
     */

    private String shopTitle;
    /**
     * 商品小图列表
     */

    private List<String> smallImages;
    /**
     * 商品标题
     */

    private String title;
    /**
     * 月支出佣金
     */
    @JSONField(serialize = false)
    private Float tkTotalCommi;
    /**
     * 淘客30天月推广量
     */
    @JSONField(serialize = false)
    private Float tkTotalSales;
    /**
     * 卖家类型，0表示集市，1表示商城
     */
    @JSONField(serialize = false)
    private Long userType;
    /**
     * 30天销量
     */

    private Long volume;
    /**
     * 商品折扣价格
     */

    private Float zkFinalPrice;

    /**
     * 商品折扣比率（ [折扣价-优惠券] / [一口价] ）
     */

    private Float discountRate;

    @JSONField(serialize = false)
    private boolean ju;

    @JSONField(serialize = false)
    private Date juStart;

    @JSONField(serialize = false)
    private Date juEnd;


    private String openIid;

    @JSONField(serialize = false)
    private String storeId;

    //淘宝顶级分类
    @JSONField(serialize = false)
    private Long rootCid;

    //淘宝二级分类
    @JSONField(serialize = false)
    private Long branchCid;

    //淘宝三级分类
    @JSONField(serialize = false)
    private Long leafCid;

    //到手价

    private Float finalPrice;
    @JSONField(serialize = false)
    private Long solrDataVersion;

    public String getClickUrl() {
        return clickUrl;
    }

    public void setClickUrl(String clickUrl) {
        this.clickUrl = clickUrl;
    }

    public String getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(String commissionRate) {
        this.commissionRate = commissionRate;
    }

    public String getCommissionType() {
        return commissionType;
    }

    public void setCommissionType(String commissionType) {
        this.commissionType = commissionType;
    }

    public String getCouponClickUrl() {
        return couponClickUrl;
    }

    public void setCouponClickUrl(String couponClickUrl) {
        this.couponClickUrl = couponClickUrl;
    }

    public Date getCouponEndTime() {
        return couponEndTime;
    }

    public void setCouponEndTime(Date couponEndTime) {
        this.couponEndTime = couponEndTime;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public String getCouponInfo() {
        return couponInfo;
    }

    public void setCouponInfo(String couponInfo) {
        this.couponInfo = couponInfo;
    }

    public Long getCouponRemainCount() {
        return couponRemainCount;
    }

    public void setCouponRemainCount(Long couponRemainCount) {
        this.couponRemainCount = couponRemainCount;
    }

    public Date getCouponStartTime() {
        return couponStartTime;
    }

    public void setCouponStartTime(Date couponStartTime) {
        this.couponStartTime = couponStartTime;
    }

    public Long getCouponTotalCount() {
        return couponTotalCount;
    }

    public void setCouponTotalCount(Long couponTotalCount) {
        this.couponTotalCount = couponTotalCount;
    }

    public String getIncludeDxjh() {
        return includeDxjh;
    }

    public void setIncludeDxjh(String includeDxjh) {
        this.includeDxjh = includeDxjh;
    }

    public String getIncludeMkt() {
        return includeMkt;
    }

    public void setIncludeMkt(String includeMkt) {
        this.includeMkt = includeMkt;
    }

    public String getInfoDxjh() {
        return infoDxjh;
    }

    public void setInfoDxjh(String infoDxjh) {
        this.infoDxjh = infoDxjh;
    }

    public String getItemUrl() {
        return itemUrl;
    }

    public void setItemUrl(String itemUrl) {
        this.itemUrl = itemUrl;
    }

    public Long getNumIid() {
        return numIid;
    }

    public void setNumIid(Long numIid) {
        this.numIid = numIid;
    }

    public String getPictUrl() {
        return pictUrl;
    }

    public void setPictUrl(String pictUrl) {
        this.pictUrl = pictUrl;
    }

    public String getProvcity() {
        return provcity;
    }

    public void setProvcity(String provcity) {
        this.provcity = provcity;
    }

    public Float getReservePrice() {
        return reservePrice;
    }

    public void setReservePrice(Float reservePrice) {
        this.reservePrice = reservePrice;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public String getShopTitle() {
        return shopTitle;
    }

    public void setShopTitle(String shopTitle) {
        this.shopTitle = shopTitle;
    }

    public List<String> getSmallImages() {
        return smallImages;
    }

    public void setSmallImages(List<String> smallImages) {
        this.smallImages = smallImages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getTkTotalCommi() {
        return tkTotalCommi;
    }

    public void setTkTotalCommi(Float tkTotalCommi) {
        this.tkTotalCommi = tkTotalCommi;
    }

    public Float getTkTotalSales() {
        return tkTotalSales;
    }

    public void setTkTotalSales(Float tkTotalSales) {
        this.tkTotalSales = tkTotalSales;
    }

    public Long getUserType() {
        return userType;
    }

    public void setUserType(Long userType) {
        this.userType = userType;
    }

    public Long getVolume() {
        return volume;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }

    public Float getZkFinalPrice() {
        return zkFinalPrice;
    }

    public void setZkFinalPrice(Float zkFinalPrice) {
        this.zkFinalPrice = zkFinalPrice;
    }

    public Float getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Float discountRate) {
        this.discountRate = discountRate;
    }

    public boolean isJu() {
        return ju;
    }

    public void setJu(boolean ju) {
        this.ju = ju;
    }

    public Date getJuStart() {
        return juStart;
    }

    public void setJuStart(Date juStart) {
        this.juStart = juStart;
    }

    public Date getJuEnd() {
        return juEnd;
    }

    public void setJuEnd(Date juEnd) {
        this.juEnd = juEnd;
    }

    public String getOpenIid() {
        return openIid;
    }

    public void setOpenIid(String openIid) {
        this.openIid = openIid;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getRootCid() {
        return rootCid;
    }

    public void setRootCid(Long rootCid) {
        this.rootCid = rootCid;
    }

    public Long getBranchCid() {
        return branchCid;
    }

    public void setBranchCid(Long branchCid) {
        this.branchCid = branchCid;
    }

    public Long getLeafCid() {
        return leafCid;
    }

    public void setLeafCid(Long leafCid) {
        this.leafCid = leafCid;
    }

    public Float getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(Float finalPrice) {
        this.finalPrice = finalPrice;
    }

    public Long getSolrDataVersion() {
        return solrDataVersion;
    }

    public void setSolrDataVersion(Long solrDataVersion) {
        this.solrDataVersion = solrDataVersion;
    }
}
