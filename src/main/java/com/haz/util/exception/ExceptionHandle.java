//package com.haz.util.exception;
//
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.haz.util.base.ServerResponse;
//
//import lombok.extern.slf4j.Slf4j;
//
///**
// * 统一异常处理类
// * 
// * @version 1.0
// * @Author: aizhou.huang
// * @Date: Created in 14:10 2018/7/30
// */
//@Slf4j
//@ControllerAdvice
//public class ExceptionHandle {
//
//	/**
//	 * 判断错误是否是已定义的已知错误，不是则由系统错误代替，同时记录在log中
//	 * 
//	 * @param e
//	 * @return
//	 */
//	@ExceptionHandler(value = Exception.class)
//	@ResponseBody
//	public ServerResponse<?> exceptionGet(Exception e) {
//		if (e instanceof ServiceException) {
//			ServiceException exception = (ServiceException) e;
//			ServiceExceptionEnum exceptionEnum = exception.getExceptionEnum();
//			if (exceptionEnum != null) {
//				return ServerResponse.createByErrorCodeMessage(exceptionEnum.getCode(), exceptionEnum.getMessage());
//			}
//			return ServerResponse.createByErrorMessage(exception.getMessage());
//		}
//
//		log.error("【系统异常】:", e);
//		return ServerResponse.createByErrorCodeMessage(ServiceExceptionEnum.SYSTEM_ERROR.getCode(),
//				ServiceExceptionEnum.SYSTEM_ERROR.getMessage());
//	}
//}