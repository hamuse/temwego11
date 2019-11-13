package com.wego.web.cmm;

import java.util.HashMap;

import com.wego.web.commu.Community;

@FunctionalInterface
public interface IConsumer<T> {
		public  void accept(T t);
}
