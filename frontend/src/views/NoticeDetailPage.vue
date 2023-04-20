<template>
    <div>
        <div class="total_wrap">
            <HeaderPage style="position:fixed;z-index: 300;"></HeaderPage>
            <div class="center_wrap">
                <div class="headerpage"></div>
                <div id="divide_section">
                    <div id="category">
                        <p id="category_title">고객센터</p>
                        <ul>
                            <li><a href="/cs/register">1:1문의접수</a></li>
                            <li><a href="/faq">자주 묻는 질문</a></li>
                            <li><a href="/notice" id="bold">공지사항</a></li>
                        </ul>
                    </div>
                    <div id="section">
                        <p id="maintitle">공지사항</p>
                        <div id="notice_title">
                            <p id="title_left">&lt;배송비 정책 변경 안내&gt;</p>
                            <p id="title_right">2023.02.12</p>
                        </div>
                        <div id="notice_content">
                            <p>안녕하세요. 꿈을 키우는 세상 교보문고입니다.교보문고 서비스를 이용해 주시는 고객님께 감사드립니다.교보문고 영상정보처리기기 운영관리방침이 다음과 같이 일부 개정 될 예정으로 변경내용을 사전 공지하오니 서비스 이용에 참조하시기 바랍니다.1. 개정 사유ㅤ- 보관기간 변경</p>
                            <p>안녕하세요. 꿈을 키우는 세상 교보문고입니다.교보문고 서비스를 이용해 주시는 고객님께 감사드립니다.교보문고 영상정보처리기기 운영관리방침이 다음과 같이 일부 개정 될 예정으로 변경내용을 사전 공지하오니 서비스 이용에 참조하시기 바랍니다.1. 개정 사유ㅤ- 보관기간 변경</p>
                        </div>
                        <div id="btn_wrap">
                            <a href="/notice"><button id="event_btn">목록으로</button></a>
                        </div>
                    </div>
                </div>
            </div>
            <div>
                <el-backtop :right="70" :bottom="70" style="color: #3DDCA3;"/>
            </div>
        </div>
        <FooterPage></FooterPage>
    </div>
</template>

<script>
import HeaderPage from '@/components/HeaderPage.vue'
import FooterPage from '@/components/FooterPage.vue'

export default {

    components:{
    HeaderPage:HeaderPage,
    FooterPage:FooterPage
    },

    setup () {
        

        return {}
    }
}
</script>

<style lang="css" scoped>
    /* 초기화 */
    *{
        padding:0;
        margin:0;
    }

    ul,li{
        list-style: none;
    }

    a{
        text-decoration: none;
        color: black;
    }
    
    
     /*1200px 중앙정렬 */
     .center_wrap{
        width: 1200px;
        margin: 0 auto;
    }

    /*HeaderPage용 공백 */
    .headerpage{
    height: 95px;
    }

   /*페이지 타이틀 영역 */
   .maintitle_wrap{
        height: 30px;
        padding-bottom: 50px;
    }
    .maintitle_wrap > li{
        float: left;
    }

    .maintitle_wrap > li > img{
        width: 35px;
        margin-right: 10px;
    }

    #maintitle{
        font-size: 24px;
        font-weight: bold;
        margin-bottom: 50px;
        margin-top: 50px;
    }

     /*사이드 카테고리 영역*/
     #divide_section{
        display: grid;
        grid-template-columns: 247px auto;
    }

    #category{
        padding-top: 50px;
    }

    #category_title{
        font-size: 18px;
        font-weight: bold;
        margin-bottom: 25px;
    }

    #category > ul > li{
        font-size: 15px;
        margin-bottom: 10px;
    }

    #category > ul > li > a:hover{
        font-weight: bold;
        color: black;
    }

    #bold{
        font-weight: bold;
    }

    /*공지 제목 영역 */
    #notice_title{
        display: grid;
        grid-template-columns: auto 75px;
        padding-bottom: 30px;
        
    }
    #title_left{
        font-size: 18px;
        font-weight: bold;
    }
    #title_right{
        font-size: 14px;
        color: #575757;
    }

    /*공지 내용 영역 */
    #notice_content{
        padding-top: 50px;
        padding-bottom: 50px;
        border-top: 1px solid black;
        border-bottom: 1px solid rgb(194, 194, 194);
    }

    /*목록 버튼 */
    #btn_wrap{
        width: 100%;
        margin-top: 30px;
        text-align: center;
    }

    #event_btn{
        border: none;
        background: #3DDCA3;
        width: 200px;
        height: 40px;
        color: white;
        border-radius: 5px;
        cursor: pointer;
        
    }
</style>