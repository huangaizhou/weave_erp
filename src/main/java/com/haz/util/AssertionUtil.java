package com.haz.util;

import java.util.Collection;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import com.haz.util.exception.ServiceException;
import com.haz.util.exception.ServiceExceptionEnum;

/**
 * 断言业务异常处理
 * 
 * @author aizhou.huang
 * @date 2018年7月31日
 */
public class AssertionUtil {

	public static void isNull(Object obj, ServiceExceptionEnum exceptionEnum) {
		if (obj != null) {
			throw new ServiceException(exceptionEnum);
		}
	}

	public static void isNotNull(Object obj, ServiceExceptionEnum exceptionEnum) {
		if (obj == null) {
			throw new ServiceException(exceptionEnum);
		}
	}

	public static void isNotEmpty(String str, ServiceExceptionEnum exceptionEnum) {
		if (StringUtils.isEmpty(str)) {
			throw new ServiceException(exceptionEnum);
		}
	}

	public static void bitchNotEmpty(ServiceExceptionEnum exceptionEnum, String... objs) {
		if (StringUtils.isAnyEmpty(objs)) {
			throw new ServiceException(exceptionEnum);
		}
	}

	public static void isTrue(Boolean obj, ServiceExceptionEnum exceptionEnum) {
		if (!obj) {
			throw new ServiceException(exceptionEnum);
		}
	}

	public static void isNotTrue(Boolean obj, ServiceExceptionEnum exceptionEnum) {
		if (obj) {
			throw new ServiceException(exceptionEnum);
		}
	}

	public static void bitchNotNull(ServiceExceptionEnum exceptionEnum, Object... objs) {
		for (Object obj : objs) {
			if (obj instanceof String) {
				isNotEmpty((String) obj, exceptionEnum);
			} else {
				isNotNull(obj, exceptionEnum);
			}
		}
	}

	public static void collectionIsEmpty(Collection<?> obj, ServiceExceptionEnum exceptionEnum) {
		isTrue(!CollectionUtils.isEmpty(obj), exceptionEnum);
	}
}
