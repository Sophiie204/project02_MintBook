<template>
    <div id="total_wrap">
        <HeaderPage style="position:fixed;z-index: 300;"></HeaderPage>
        <div id="center_wrap">
            <div class="headerpage"></div>
            <header>
                <div id="bottom_nav_wrap">
                    <ul>
                        <li>
                            <label>•</label>
                            <a href="*"> 베스트셀러</a>
                        </li>
                        <li>
                            <label>•</label>
                            <a href="*"> 이 주의 신간</a>
                        </li>
                        <li>
                            <label>•</label>
                            <a href="*"> 에디터's PICK</a>
                        </li>
                        <li>
                            <label>•</label>
                            <a href="*"> 이벤트</a>
                        </li>
                    </ul>
                </div>
                <div id="slider_wrap">
                    <el-carousel height="407px">
                        <el-carousel-item>
                            <img src="../assets/MainPage/slide1.png" alt="slide1">
                        </el-carousel-item>
                        <el-carousel-item>
                            <img src="../assets/MainPage/slide2.png" alt="slide2">
                        </el-carousel-item>
                        <el-carousel-item>
                            <img src="../assets/MainPage/slide3.png" alt="slide3">
                        </el-carousel-item>
                    </el-carousel>
                </div>
                <div id="notice_wrap">
                    <div>공지사항</div>
                    <div>MintBook 서버 검점 안내(4/17)</div>
                </div>
            </header>
            <section>
                <div class="content_wrap">
                    <div class="content_top">
                        <ul class="content_left">
                            <li>
                                <img src="../assets/MainPage/bestseller.png" alt="bestseller">
                            </li>
                            <li class="content_text">베스트셀러</li>
                        </ul>
                        <div class="content_right">
                            <label>더보기+</label>
                        </div>
                    </div>
                    <div class="content_bottom">
                        <div class="content_book_wrap">
                            <p class="c_ranking">01.</p>
                            <img src="../assets/MainPage/book1.jpg" alt="book1" class="c_image">
                            <p class="c_title">세이노의 가르침</p>
                            <p class="c_author">세이원·데이원</p>
                        </div>
                        <div class="content_book_wrap">
                            <p class="c_ranking">02.</p>
                            <img src="../assets/MainPage/book2.jpg" alt="book2" class="c_image">
                            <p class="c_title">세이노의 가르침</p>
                            <p class="c_author">세이원·데이원</p>
                        </div>
                        <div class="content_book_wrap">
                            <p class="c_ranking">03.</p>
                            <img src="../assets/MainPage/book3.jpg" alt="book3" class="c_image">
                            <p class="c_title">세이노의 가르침</p>
                            <p class="c_author">세이원·데이원</p>
                        </div>
                        <div class="content_book_wrap">
                            <p class="c_ranking">04.</p>
                            <img src="../assets/MainPage/book4.jpg" alt="book4" class="c_image">
                            <p class="c_title">세이노의 가르침</p>
                            <p class="c_author">세이원·데이원</p>
                        </div>
                        <div class="content_book_wrap">
                            <p class="c_ranking">05.</p>
                            <img src="../assets/MainPage/book5.jpg" alt="book5" class="c_image">
                            <p class="c_title">세이노의 가르침</p>
                            <p class="c_author">세이원·데이원</p>
                        </div>
                        <div class="content_book_wrap">
                            <p class="c_ranking">06.</p>
                            <img src="../assets/MainPage/book1.jpg" alt="book1" class="c_image">
                            <p class="c_title">세이노의 가르침</p>
                            <p class="c_author">세이원·데이원</p>
                        </div>
                        <div class="content_book_wrap">
                            <p class="c_ranking">07.</p>
                            <img src="../assets/MainPage/book2.jpg" alt="book2" class="c_image">
                            <p class="c_title">세이노의 가르침</p>
                            <p class="c_author">세이원·데이원</p>
                        </div>
                        <div class="content_book_wrap">
                            <p class="c_ranking">08.</p>
                            <img src="../assets/MainPage/book3.jpg" alt="book3" class="c_image">
                            <p class="c_title">세이노의 가르침</p>
                            <p class="c_author">세이원·데이원</p>
                        </div>
                        <div class="content_book_wrap">
                            <p class="c_ranking">09.</p>
                            <img src="../assets/MainPage/book4.jpg" alt="book4" class="c_image">
                            <p class="c_title">세이노의 가르침</p>
                            <p class="c_author">세이원·데이원</p>
                        </div>
                        <div class="content_book_wrap">
                            <p class="c_ranking">10.</p>
                            <img src="../assets/MainPage/book5.jpg" alt="book5" class="c_image">
                            <p class="c_title">세이노의 가르침</p>
                            <p class="c_author">세이원·데이원</p>
                        </div>
                    </div>
                </div>
                <div class="ad_wrap">
                    <img src="../assets/MainPage/ad1.jpg" alt="ad1">
                </div>
                <div class="content_wrap">
                    <div class="content_top">
                        <ul class="content_left">
                            <li>
                                <img src="../assets/MainPage/new.png" alt="new" id="new_img">
                            </li>
                            <li class="content_text">이 주의 신간</li>
                        </ul>
                        <div class="content_right">
                            <label>더보기+</label>
                        </div>
                    </div>
                    <div class="content_bottom">
                        <div class="content_book_wrap">
                            <img src="../assets/MainPage/book1.jpg" alt="book1" class="c_image">
                            <p class="c_title">세이노의 가르침</p>
                            <p class="c_author">세이원·데이원</p>
                        </div>
                        <div class="content_book_wrap">
                            <img src="../assets/MainPage/book2.jpg" alt="book2" class="c_image">
                            <p class="c_title">세이노의 가르침</p>
                            <p class="c_author">세이원·데이원</p>
                        </div>
                        <div class="content_book_wrap">
                            <img src="../assets/MainPage/book3.jpg" alt="book3" class="c_image">
                            <p class="c_title">세이노의 가르침</p>
                            <p class="c_author">세이원·데이원</p>
                        </div>
                        <div class="content_book_wrap">
                            <img src="../assets/MainPage/book4.jpg" alt="book4" class="c_image">
                            <p class="c_title">세이노의 가르침</p>
                            <p class="c_author">세이원·데이원</p>
                        </div>
                        <div class="content_book_wrap">
                            <img src="../assets/MainPage/book5.jpg" alt="book5" class="c_image">
                            <p class="c_title">세이노의 가르침</p>
                            <p class="c_author">세이원·데이원</p>
                        </div>
                    </div>
                </div>
                <div class="ad_wrap">
                    <img src="../assets/MainPage/ad2.jpg" alt="ad2">
                </div>
                <div class="content_wrap">
                    <div class="content_top">
                        <ul class="content_left">
                            <li>
                                <img src="../assets/MainPage/editorspick.png" alt="new" id="new_img">
                            </li>
                            <li class="content_text">에디터's PICK</li>
                        </ul>
                        <div class="content_right">
                            <label>더보기+</label>
                        </div>
                    </div>
                    <div class="content_bottom">
                        <div class="content_book_wrap">
                            <img src="../assets/MainPage/book1.jpg" alt="book1" class="c_image">
                            <p class="c_title">세이노의 가르침</p>
                            <p class="c_author">세이원·데이원</p>
                        </div>
                        <div class="content_book_wrap">
                            <img src="../assets/MainPage/book2.jpg" alt="book2" class="c_image">
                            <p class="c_title">세이노의 가르침</p>
                            <p class="c_author">세이원·데이원</p>
                        </div>
                        <div class="content_book_wrap">
                            <img src="../assets/MainPage/book3.jpg" alt="book3" class="c_image">
                            <p class="c_title">세이노의 가르침</p>
                            <p class="c_author">세이원·데이원</p>
                        </div>
                        <div class="content_book_wrap">
                            <img src="../assets/MainPage/book4.jpg" alt="book4" class="c_image">
                            <p class="c_title">세이노의 가르침</p>
                            <p class="c_author">세이원·데이원</p>
                        </div>
                        <div class="content_book_wrap">
                            <img src="../assets/MainPage/book5.jpg" alt="book5" class="c_image">
                            <p class="c_title">세이노의 가르침</p>
                            <p class="c_author">세이원·데이원</p>
                        </div>
                    </div>
                </div>
                <div>
                    <el-backtop :right="70" :bottom="70" style="color: #3DDCA3;"/>
                </div>
            </section>
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

/*HeaderPage용 공백 */
.headerpage{
    height: 95px;
}
/* header영역 */

#center_wrap{
    width: 1200px;
    margin: 0 auto;
}

#bottom_nav_wrap{
    height: 93px;
    border-bottom: 0.5px solid #e0dddd;
}

#bottom_nav_wrap > ul {
    padding-top: 50px;
}

#bottom_nav_wrap > ul > li {
    float: left;
    margin-right: 45px;
}

#bottom_nav_wrap > ul > li > a{
    font-size: 15px;
    font-weight: bold;
    color: rgb(75, 75, 75);
}


#bottom_nav_wrap > ul > li > label{
    color: #3DDCA3;
}

/* 슬라이드 영역 */
#slider_wrap{
    padding-top: 10px;
}

/* 공지사항 영역 */
#notice_wrap{
    height: 47px;
    display: grid;
    grid-template-columns: 150px auto;
    line-height: 47px;
    color: grey;
    font-size: 13px;
    margin-top: 20px;
    border-bottom: 0.5px solid #e0dddd;
}
#notice_wrap > div:first-child{
    text-align: center;
}

/* 베스트셀러 영역 */
.content_wrap{
    /* height: 970px; */
    margin-top: 50px;
}

.content_top{
    height: 34px;
    line-height: 34px;
}

.content_left > li {
    float:left;
    margin-right: 10px;
}

.content_text{
    font-size: 24px;
    font-weight: bold;
}

.content_left > li > img{
    height: 34px;
}

.content_right > label{
    float:right;
    font-size: 16px;
    font-weight: light;
}

.content_bottom{
    display: grid;
    grid-template-columns: 1fr 1fr 1fr 1fr 1fr;
    margin-top: 40px;
}

.content_book_wrap{
    margin-bottom:20px;
}

.c_ranking{
    font-size: 36px;
    font-weight: bolder;
    color: #3DDCA3;
}

.c_image{
    width: 210px;
    border: 0.5px solid #C6C4C4;
}

.c_title{
    font-size: 15px;
}

.c_author{
    font-size: 13px;
    color: #998F8F;
}

/* 광고 영역 */
.ad_wrap{
    margin-top: 80px;
    margin-bottom: 80px;
}
.ad_wrap > img{
    border-radius: 25px;
}




</style>