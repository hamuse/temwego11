var page_vue = page_vue || {};
page_vue = {
        page : x =>{
            return'<div class="container">'+
            '<div id ="pageSize"></div>'+
            '  <ul id ="pagination"class="pagination">'+
            '    <li class="page-item"><a class="page-link" href="#">이전</a></li>'+
            '    <li class="page-item"><a class="page-link" href="#">1</a></li>'+
            '    <li class="page-item"><a class="page-link" href="#">2</a></li>'+
            '    <li class="page-item"><a class="page-link" href="#">3</a></li>'+
            '    <li class="page-item"><a class="page-link" href="#">다음</a></li>'+
            '  </ul>'+
            '</div>'
        }
}