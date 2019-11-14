"use strict"
function CheckExtension(x){
	let flag = false
	let regex = new RegEx("(.*?)\.(exe|sh|zip|alz)$");
    let maxSize = 5242880; // 5MB
    if(x.fsize >= maxSize) {
        alert('파일사이즈초과')
        return true
    }
    if(regx.test(x.fname)) {
        alert('해당종류의 파일은 업로드 할 수 없습니다.')
        return true
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

