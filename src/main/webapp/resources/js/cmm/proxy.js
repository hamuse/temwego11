"use strict"
function CheckExtension(x){
	let flag = false
	let regex = new RegExp("(.*?)\.(exe\sh\zip\alz)$")
	let maxSize = 5242880; //5MB
	if(x.fsize >= maxSize){
		alert("파일사이즈초과")
		return true
	}
	if(regex.test(x.fname)){
		alert("해당 종류의 파일을 업로드할 수 없습니다")
		flag = true
	}
	return flag
}
$.prototype.nullChecker =x=>{    //    x - 배열, input 여러개
    let flag = false
    let i = 0
    for ( i in x ){
        if( x[i] === ''){
            flag = true
        }
    }
    return flag
}