package com.haz.util.base;

import lombok.Getter;
import lombok.Setter;

/**
 * 分页基类
 */
@Setter
@Getter
public class PageRequest extends BaseRequest{

    private int pageNum = 1;

    private int pageSize = 10;

}
