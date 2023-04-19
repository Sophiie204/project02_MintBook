<template>
    <div class="total_wrap">
        <HeaderPage style="position:fixed;z-index: 300;"></HeaderPage>
        <div class="center_wrap">
            <div class="headerpage"></div>
            <div id="divide_section">
                <div id="category">
                    <p id="category_title">고객센터</p>
                    <ul>
                        <li><a href="*">1:1문의접수</a></li>
                        <li><a href="*">자주 묻는 질문</a></li>
                        <li><a href="*">공지사항</a></li>
                    </ul>
                </div>
                <div id="section">
                    <p id="maintitle">자주 묻는 질문</p>
                    <div class="accordion" id="accordionExample">
                        <div class="accordion-item">
                            <h2 class="accordion-header" id="headingOne">
                            <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                <label class="QText">Q.</label>&emsp;환불하려면 어떻게 해야 하나요?
                            </button>
                            </h2>
                            <div id="collapseOne" class="accordion-collapse collapse show" aria-labelledby="headingOne" data-bs-parent="#accordionExample">
                            <div class="accordion-body">
                                <strong>환불 안됩니다. </strong> 그냥 쓰세요.
                            </div>
                            </div>
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
        margin-top: 40px;
        margin-bottom: 50px;
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

    #category > ul > li:hover{
        font-weight: bold;
    }

    /*드롭다운 영역 */
    .QText{
        font-size: 36px;
        font-weight: bolder;
        color: #3DDCA3;
    }



</style>