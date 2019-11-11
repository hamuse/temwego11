package com.wego.web.host;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
@Lazy
public class Host {
	private String hid,pwd,hname,ceoname,vompnttype,tel,addr,licensenum;
}
