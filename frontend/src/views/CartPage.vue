<template>
    <div class="total_wrap">
        <HeaderPage style="position:fixed;z-index: 300;"></HeaderPage>
        <div class="center_wrap">
            <div class="headerpage"></div>
            <ul class="maintitle_wrap">
                <li><img src="../assets/Navigation/cart.png" alt=""></li>
                <li id="maintitle">장바구니</li>
            </ul>
            <table>
                <tr>
                    <th>
                        <input type="checkbox" id="checktop" class="checkbox" v-model="checkAll">
                        <label for="checktop"></label>
                    </th>
                    <th colspan="3" class="list_top_right">
                        <button class="button1">찜</button>
                        <button class="button2">바로구매</button>
                        <button class="button3">삭제</button>
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
                        <button class="button1" id="fontred">♥</button><br>
                        <button class="button4">바로구매</button><br>
                        <button class="button3">삭제</button>
                    </td>
                </tr>

            </table>
            <div class="example-pagination-block">
                <el-pagination layout="prev, pager, next" :total="100"/>
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
        /*초기화 */
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
        margin-left: 5px;
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
    #fontred{
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