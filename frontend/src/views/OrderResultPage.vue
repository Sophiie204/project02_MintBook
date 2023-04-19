<template>
    <div id="total_wrap">
        <HeaderPage style="position:fixed;z-index: 300;"></HeaderPage>
        <div class="center_wrap">
            <div class="headerpage"></div>
            <ul class="maintitle_wrap">
                <li><img src="../assets/OrderResultPage/orderresult.png" alt=""></li>
                <li id="maintitle">주문완료</li>
            </ul>
            <p class="thanks">구매해주셔서 감사합니다!</p>
            <p class="thanks">배송현황 및 결제정보는 '마이페이지 > 구매내역'에서 확인 가능합니다.</p>
            <div id="orderdetail_wrap">
                <p class="minititle">기본/배송정보</p>
                <table class="ordertable">
                    <tr>
                        <td class="textbold">주문자명</td>
                        <td class="right">홍길동</td>
                        <td class="textbold">수령자명</td>
                        <td class="right">김철수</td>
                    </tr>
                    <tr>
                        <td class="textbold">배송지</td>
                        <td colspan="3" class="right">부산광역시 부산진구 중앙대로 668(A1프라자6층)</td>
                    </tr>
                    <tr>
                        <td class="textbold">전화번호</td>
                        <td class="right">051-123-1234</td>
                        <td class="textbold">휴대전화</td>
                        <td class="right">010-1234-1234</td>
                    </tr>
                    <tr>
                        <td class="textbold">주문번호</td>
                        <td class="right">001-1234-A49341</td>
                        <td class="textbold">배송방법</td>
                        <td class="right">택배</td>
                    </tr>
                    <tr>
                        <td class="textbold">주문접수일</td>
                        <td class="right">2023년 03월 31일 11시 44분</td>
                        <td class="textbold">수령예상일</td>
                        <td class="right">2023년 04월 01일</td>
                    </tr>
                    <tr>
                        <td class="textbold">상태</td>
                        <td colspan="3" class="right">결제완료</td>
                    </tr>
                </table>
            </div>
            <div id="paydetail_wrap">
                <p class="minititle" id="payinfo_title">결제정보</p>
                <table class="ordertable">
                    <tr>
                        <td class="textbold">총 주문 금액</td>
                        <td class="right">34,000원(상품가격34,000원 + 배송료0원)</td>
                    </tr>
                    <tr>
                        <td class="textbold">실 결제 금액</td>
                        <td class="right">
                            <label id="totalprice">19,600</label><label>원(포인트사용: 1,000원, 캐시사용:10,000원)</label>
                        </td>
                    </tr>
                    <tr>
                        <td class="textbold">결제방법</td>
                        <td class="right">신용카드(국민카드)</td>
                    </tr>
                </table>
            </div>
            <div id="button_wrap">
                <button id="gomyorder">구매내역 확인하기</button>
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
    margin-bottom: 40px;
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

    .thanks{
        font-size: 20px;
    }

    /*주문정보 영역 */

    #orderdetail_wrap{
        margin-top: 50px;
    }
    .ordertable{
        width: 100%;
        border: 1px solid rgb(190, 190, 190);
        border-collapse: collapse;
        padding-left: 30px;
        font-size: 14px;
        margin-top: 20px;
    }
    td{
        border: 1px solid rgb(98, 98, 98);
        vertical-align : middle;
        height: 36px;
    }

    .minititle{
        font-size: 16px;
        font-weight: bold;
    }

    .textbold{
        font-weight: bold;
        color: rgb(98, 98, 98);
        width: 100px;
        text-align: center;
        background: rgb(190, 190, 190);
    }

    .right{
        padding-left: 10px;
    }

    #totalprice{
        color: #3DDCA3;
        font-weight: bold;
    }

    #payinfo_title{
        margin-top: 20px;
    }

    #gomyorder{
        width: 250px;
        height: 40px;
        background: #3DDCA3;
        border: 1px solid #3DDCA3;
        border-radius: 6px;
        color: white;
        margin-left: 475px;
        margin-top: 30px;
        cursor: pointer;
    }
</style>