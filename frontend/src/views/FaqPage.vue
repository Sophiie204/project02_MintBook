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
                    <p id="maintitle">1:1문의접수</p>
                    
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





</style>