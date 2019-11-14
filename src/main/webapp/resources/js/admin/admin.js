"use strict";
var admin = admin || {};
admin = (() => {
    const WHEN_ERR = 'admin 호출하는 js가 없습니다.';
    let context, js, css, img;
    let navi_vuejs, auth_vuejs;
    let navijs;
    let init = () => {
        context = $.ctx()
        js = $.js()
        css = $.css()
        img = $.img()
        navi_vuejs = js + '/vue/navi_vue.js'
        navijs = js + '/cmm/navi.js'
    }
    
    let onCreate = () => {
        alert('환영합니다.')
        init()
        $.when(
                $.getScript(navi_vuejs),
                $.getScript(navijs)
            ).done(() => {
                alert('admin onCreate done alert')
                setContentView()
            })
            .fail(() => {
                WHEN_ERR
            })
    }
    
    let setContentView = () => { //js  에서의 맨 처음 화면이다. 
        //      $('#login_form_id').remove()
        $('body').empty()
        $(navi_vue.navi()).appendTo('body')
        $('#nav_scroller_id').remove()
        navi.onCreate()

        $('<table id="tab">' +
                '  <tr>' +
                '  </tr>' +
                '</table>') // key값 무조건 string이기 때문에 '' 생량가능 value는 생략 불가, json이기때문에 , 로 속성 추가                            
            .css({
                width: '80%',
                height: '80%',
                border: '1px solid black',
                margin: '0 auto'
            })
            .appendTo('body') // body에 오버로딩

        $.each(
            [{
                    id: 'left',
                    width: '20%'
                },
                {
                    id: 'right',
                    width: '80%'
                }
            ],
            (i, j) => {
                $('<td id="' + j.id + '"></td>')
                    .css({
                        border: '1px solid #ddd',
                        width: j.width,
                        'vertical-align': 'top'
                    })
                    .appendTo('#tab tr')
            })

        $.each([ // name을 주고 구분
                {
                    txt: '웹크롤링',
                    name: 'web_crawl'
                },
                {
                    txt: '고객관리',
                    name: 'cust_mgmt'
                },
                {
                    txt: '커뮤니티관리',
                    name: 'comm_mgmt'
                },
                {
                    txt: '상품조회',
                    name: 'pdt_mgmt'
                },
                {
                    txt: '상품수정',
                    name: 'item_mod'
                },
                {
                    txt: '상품삭제',
                    name: 'item_del'
                }
            ],
            (i, j) => {
                $('<div name="' + j.name + '">' + j.txt + '</div>')
                    .appendTo('#left')
                    .click(function() {
                        $(this).addClass('active')
                        $(this).siblings().removeClass('active')
                        switch ($(this).attr('name')) {
                            case 'web_crawl':
                                web_crawl()
                                break
                            case 'cust_mgmt':
                            	cust_mgmt()
                                break 
                                
                            case 'comm_mgmt':
                            	comm_mgmt()
                                break
                            case 'pdt_mgmt':
                            	pdt_mgmt()
                                break
                            case 'item_mod':

                                break
                            case 'item_del':

                                break
                        }
                    })
            })
        $('#left div').css({
            border: '1px solid #ddd',
            margin: 'auto 0',
            'line-height': '50px'
        })
    }
    let web_crawl = () => {
    	   $('#right').empty()
           $('<form id="crawl_form_id" action="">'+
               '  <select name="site" size="1" >'+    //    multiple
               '  </select>'+
               '  <br>'+
   /*            '  <button id="news_btn">이동</button>'+
               '</form>'+
               '<form class="form-inline my-2 my-lg-0">'+*/
               '  <input class="form-control mr-sm-2" type="text" value="스톤애견풀빌라" placeholder="Search" aria-label="Search">'+
//               '  <button id="crawl_btn" class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>'+
               '</form>')
           .addClass('form-inline my-2 my-lg-0')
           .appendTo('#right')
           $('#crawl_form_id').css({padding : '0 auto', 'padding-top' : '5%'  })    //'padding-top' : '5%'
           $('#crawl_form_id select').css({ 'margin-left' : '30%' , 'margin-right' : '1%'})
           
           $.each(['직접입력','naver.com', 'daum.net', 'google.com', 'youtube.com'], (i, j)=>{
               $('<option value="'+ j +'">'+ j +'</option>')
               .appendTo('#crawl_form_id select')
           })
           
           $('<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>')
           .appendTo('#crawl_form_id')
           .click(e=>{
               e.preventDefault()        
               let arr = [$('form#crawl_form_id select[name="site"]').val(),
                           $('form#crawl_form_id input[type="text"]').val()]
               
               if( !$.fn.nullChecker(arr) ){            
           //        alert(arr[0] + ', '+ arr[1])
                   $.getJSON( context+ '/tx/crawling/' + arr[0] +'/' + arr[1], d=>{        // form 태그의 id란 뜻
                       alert(d.msg)
                   })
               }
           })
    }
    let pdt_mgmt=()=>{
    	$('#right').empty()
    	$('<a>상품 테이블 생성</a></br>')
    	.appendTo('#right')
    	.click(e=>{
    		e.preventDefault()
    		$.getJSON(context+'/products/create/table', d=>{
    			alert('상품 테이블 생성 : ' + d.msg)
    		})

    	})

    	$('<a>상품 테이블 삭제</a></br>')
    	.appendTo('#right')
    	.click(e=>{
    		e.preventDefault()
    		$.getJSON(context+'/products/drop/table', d=>{
    			alert('PRODUCT 테이블 삭제 : ' + d.msg)
    		})

    	})
    	$('<a>상품 대량정보 입력</a></br>')
    	.appendTo('#right')
    	.click(e=>{
    		e.preventDefault()
    		$.getJSON(context+'/tx/register/products', d=>{
    			alert('PRODUCT 대량등록 : ' + d.msg)
    		})

    	})
    }
    let comm_mgmt=()=>{
    	$('#right').empty()
    	$('<a>커뮤니티 테이블 생성</a></br>')
    	.appendTo('#right')
    	.click(e=>{
    		e.preventDefault()
    		$.getJSON(context+'/articles/create/table', d=>{
    			alert('커뮤니티 테이블 생성 성공여부 : ' + d.msg)
    		})
    	})
    	   	$('<a>커뮤니티 대량정보 입력</a></br>')
    	.appendTo('#right')
    	.click(e=>{
    		e.preventDefault()
    		$.getJSON(context+'/tx/write/communities', d=>{
    			alert('커뮤니티 글 수 : ' + d.pdtCount)
    		})

    	})
    	 $('<a>커뮤니티 테이블 삭제</a></br>')
       .appendTo('#right')
       .click(e=>{
           e.preventDefault()
           $.getJSON(context+'/community/drop/table', d=>{
               alert('테이블 삭제 여부 : ' + d.msg)
           })
       })
    }
    let cust_mgmt=()=>{
    	$('#right').empty()
    	$('<a>데이터베이스 생성</a></br>')
    	.appendTo('#right')
    	.click(e=>{
    		e.preventDefault()
    		$.getJSON(context+'/cmm/create/db', d=>{
    			alert('데이터베이스 생성 성공여부 : ' + d.msg)
    		})
    	})
    	$('<a>고객 테이블 생성</a></br>')
    	.appendTo('#right')
    	.click(e=>{
    		e.preventDefault()
    		$.getJSON(context+'/users/create/table', d=>{
    			alert('고객 테이블 생성 : ' + d.msg)
    		})
    	})
    	$('<a>고객 테이블 삭제</a></br>')
    	.appendTo('#right')
    	.click(e=>{
    		e.preventDefault()
    		$.getJSON(context+'/users/drop/table', d=>{
    			alert('고객 테이블 삭제 : ' + d.msg)
    		})

    	})
    	
    	$('<a>고객 대량정보 입력</a></br>')
    	.appendTo('#right')
    	.click(e=>{
    		e.preventDefault()
    		$.getJSON(context+'/tx/register/users', d=>{
    			alert('일괄등록된 유저의 수 : ' + d.userCount)
    		})

    	})
    	
    }
    return {onCreate}

})();