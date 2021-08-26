package com.hg.uxdemo.net;

import com.google.gson.annotations.SerializedName;
import com.hg.zero.net.callback.contract.ZListLimitDataInfo;

/**
 * 分页信息
 * <p>
 * Created by Hollow Goods on 2021-08-26.
 */
public class ListLimitDataInfo implements ZListLimitDataInfo {

    private int totalCount;

    @SerializedName("currPage")
    private int pageIndex;

    private int pageSize;

    private int totalPage;

    private Object list;

    @Override
    public int getTotalCount() {
        return totalCount;
    }

    @Override
    public int getPageIndex() {
        return pageIndex;
    }

    @Override
    public int getPageSize() {
        return pageSize;
    }

    @Override
    public int getTotalPage() {
        return totalPage;
    }

    @Override
    public Object getList() {
        return list;
    }
}
