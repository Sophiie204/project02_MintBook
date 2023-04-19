<template>
    <div class="total_wrap">
        <HeaderPage style="position:fixed;z-index: 300;"></HeaderPage>
        <div class="center_wrap">
            <div class="headerpage"></div>
            <div id="divide_section">
                <div id="category">
                    <p id="category_title">카테고리</p>
                    <ul v-for="tmp of state.categorylist" :key="tmp">
                        <li id="category_list"><a href="/category">{{ tmp }}</a></li>
                    </ul>
                </div>
                <div id="booklist">
                    <ul class="maintitle_wrap">
                        <li><img src="../assets/CategoryPage/category.png" alt=""></li>
                        <li id="maintitle">소설</li>
                    </ul>
                    <table>
                        <tr>
                            <th>
                                <input type="checkbox" id="checktop" class="checkbox" v-model="checkAll">
                                <label for="checktop"></label>
                            </th>
                            <th colspan="3" class="list_top_right">
                                <button class="button1">찜</button>
                                <button class="button1">장바구니</button>
                                <button class="button2">바로구매</button>
                                <select name="" id="">
                                    <option value="">판매순</option>
                                    <option value="">최신순</option>
                                    <option value="">높은가격순</option>
                                    <option value="">낮은가격순</option>
                                </select>
                            </th>
                        </tr>

                        <tr id="table_bottom_tr" v-for="(item, idx) in state.list" :key="idx">
                            <td style="width:20px;">
                                <input type="checkbox" :id=item v-model="state.checked" :value="item" class="checkbox">
                                <label :for="item"></label>
                            </td>
                            <td style="width:150px; text-align: center;">
                                <img src="../assets/MainPage/book1.jpg" alt="boo1" id="img">
                            </td>
                            <td id="price_wrap">
                                <p id="title">세이노의 가르침</p>
                                <p id="author">세이노·데이원·2023.03.02</p>
                                <label id="dc">10%</label>
                                <label id="dc_price">6,480원</label>
                                <label id="price">7,200원</label>
                                <label id="point">|360p</label>
                                <div id="description">2000년부터 발표된 그의 주옥같은 글들, 독자들이 자발적으로 만든 제본서는 물론, 전자책과 앱까지 나왔던 세이노의 가르침이 드디어 전국 서점에서 독자들을 마주한다. 여러판본을 모으고2000년부터 발표된 그의 주옥같은 글들, 독자들이 자발적으로 만든 제본서는 물론, 전자책과 앱까지 나왔던 전국 서점에서 독자들을 마주한다. 여러판본을 모으고2000년부터 발표된 그의 주옥같은 글들, 독자들이 자발적으로 만든 제본서는 물론, 전자책과 앱까지 나왔던 세이노의 가르침이 드디어 전국 서점에서 독자들을 마주한다. 여러판본을 모으고2000년부터 발표된 그의 주옥같은 글들, 독자들이 자발적으로 만든 제본서는 물론, 전자책과 앱까지 나왔던 전국 서점에서 독자들을 마주한다. 여러판본을 모으고</div>
                            </td>
                            <td style="width:150px; text-align: right;">
                                <button class="button3">장바구니</button><br>
                                <button class="button4">바로구매</button><br>
                                <button class="button5">♥</button>
                            </td>
                        </tr>
                    </table>
                    <div class="example-pagination-block">
                        <el-pagination layout="prev, pager, next" :total="100"/>
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
import { reactive } from 'vue'

export default {
    
    components:{
    HeaderPage:HeaderPage,
    FooterPage:FooterPage
    },

    setup () {
        const state = reactive({
            list:["1","2","3","4","5","6","7","8","9","10"],
            categorylist:["소설","시/에세이",,"인문","가정/육아","요리","건강","취미/실용/스포츠","겅제/경영","자기계발","정치/사회","역사/문화","종교","예술/대중문화","중/고등참고서","기술/공학","외국어","과학","취업/수험서","여행","컴퓨터/IT","잡지","청소년"],
            checked:[]
            
        })

        return {
            state,
        }
    },
    computed:{
        checkAll:{
            get:function(){
                return this.state.list.length === this.state.checked.length;
            },
            set:function(e){
                this.state.checked = e ? this.state.list : [];
            }
        }
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

    #category_list{
        font-size: 15px;
        margin-bottom: 10px;
    }



    /*테이블 영역*/
    
    /*테이블 레이아웃 */
    table{
        width: 100%;
        border-collapse: collapse;
    }

    tr{
        border-bottom: 1px solid #CCCCCC;
    }

    th, td{
        padding: 10px;
    }

    .list_top_right{
        text-align: right;
    }

    .list_top_right > button{
        margin-right: 5px;
    }

    td > button{
        margin-bottom: 5px;
    }

    #table_bottom_tr > td{
        padding-top: 30px;
        padding-bottom: 30px;
    }

    /*체크박스 */
    .checkbox{
        display:none;
    }

    .checkbox + label{
        display: inline-block;
        width: 20px;
        height: 20px;
        border:1px solid #3DDCA3;
        border-radius: 4px;
        position: relative;
    }

    .checkbox:checked + label::after {
        content:'✓';
        font-size: 15px;
        background: #3DDCA3;
        color: white;
        width: 20px;
        height: 20px;
        text-align: center;
        position: absolute;
        left: 0;
        top:0;
    }
    

    /*드롭다운 */
    select{
        width: 115px;
        height: 36px;
        border-radius: 10px;
        font-size: 12px;
        text-align: center;
    }

    select > option {
        font-size: 12px;
        margin: 20px;
    }
    
    /*버튼 */
    button{
        width: 115px;
        height: 36px;
        border-radius: 10px;
        font-size: 12px;
        cursor: pointer;
    }

    .button1{
        border: 0.5px solid #B1B1B1;
        background: white;
    }

    .button2{
        border: 0.5px solid #3DDCA3;
        background: white;
        color: #3DDCA3;
    }

    .button3{
        border: 0.5px solid #DADADA;
        background: #DADADA;
    }

    .button4{
        border: 0.5px solid #3DDCA3;
        background: #3DDCA3;
        color: white;
    }
    .button5{
        border: 0.5px solid #B1B1B1;
        background: white;
        color: red;
        font-size: 18px;
    }

    /*테이블 내부 */
    #img{
        width: 90px;
        border: 0.5px solid #C6C4C4;
    }

    #title{
        font-size: 15px;
        font-weight: bold;
        margin-bottom: 3px;
    }

    #author{
        font-size: 13px;
        color: #998F8F;
        margin-bottom: 5px;
    }

    #dc{
        font-size: 13px;
        font-weight: bold;
        color: #3DDCA3;
    }

    #dc_price{
        font-size: 13px;
        font-weight: bold;
    }

    #price{
        font-size: 13px;
        text-decoration-line: line-through;
        color: #998F8F;
    }
    #point{
        font-size: 13px;
        color: #998F8F;
    }

    #description{
        font-size: 13px;
        margin-top: 10px;
        max-height: 40px;
        overflow: hidden;
        display: -webkit-box;
        -webkit-box-orient: vertical;
        -webkit-line-clamp: 2;
    }

    /* 페이지네이션 */
    .example-pagination-block{
        width: 320px;
        margin: 0 auto;
        margin-top: 50px;
    }
</style>