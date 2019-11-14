package com.wego.web.product;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.wego.web.usr.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
@Lazy
public class Product { 
	private String pdtname, hid, price, hosttype, type, odnum, redate, paytype, cancel, uid;
}
