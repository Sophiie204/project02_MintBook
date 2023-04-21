<template>
    <div id="total_wrap">
        <div id="divide_wrap">
            <div id="nav_wrap">
                <admin-menu-page></admin-menu-page>
            </div>
            <div id="content_wrap">
                <p id="maintitle">주문 상세</p>
                <p>주문 상품 정보</p>
                <table class="table">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>상품명</th>
                            <th>수량</th>
                            <th>가격</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>1</td>
                            <td>불행한 당신을 위하여</td>
                            <td>1</td>
                            <td>16,500원</td>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td>불행한 당신을 위하여</td>
                            <td>1</td>
                            <td>16,500원</td>
                        </tr>
                    </tbody>
                </table>
                <p>기본/배송정보</p>
                <table class="table">
                    <tbody>
                        <tr>
                            <th>주문자명</th>
                            <td>홍길동</td>
                            <th>수령자명</th>
                            <td>김철수</td>
                        </tr>
                        <tr>
                            <th>배송지</th>
                            <td colspan="3">부산광역시 부산진구 중앙대로</td>
                        </tr>
                        <tr>
                            <th>전화번호</th>
                            <td>051-2341-2341</td>
                            <th>휴대전</th>
                            <td>010-2341-2341</td>
                        </tr>
                        <tr>
                            <th>주문번호</th>
                            <td>012-22341-A2df3141</td>
                            <th>배송방법</th>
                            <td>택배</td>
                        </tr>
                        <tr>
                            <th>주문접수일</th>
                            <td>2023년03월31일 11시 44분</td>
                            <th>수령예상일</th>
                            <td>2023년 04월 01일</td>
                        </tr>
                        <tr>
                            <th>상태</th>
                            <td colspan="3">
                                <select>
                                    <option value="status">환불접수</option>
                                    <option value="status">환불진행중</option>
                                    <option value="status">환불완료</option>
                                    <option value="status">반품접수</option>
                                    <option value="status">반품진행중</option>
                                    <option value="status">반품완료</option>
                                </select>
                                <button>상태변경</button>
                            </td>
                        </tr>
                    </tbody>
                </table>
                <p>결제정보</p>
                <table class="table">
                    <tr>
                        <th>총 주문 금액</th>
                        <td>3,4000원(상품가격 34,000원+배송료0원)</td>
                    </tr>
                    <tr>
                        <th>실 결제 금액</th>
                        <td>
                            <label id="price">19,600</label><label>원(포인트사용:1,000원+캐시사용:10,000원)</label>
                        </td>
                    </tr>
                    <tr>
                        <th>결제방법</th>
                        <td>신용카드(국민카드)</td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</template>

<script>
import AdminMenuPage from '../../components/AdminMenuPage.vue';

export default {
    components:{
        AdminMenuPage
    },

    setup () {

        return {}
    }
}
</script>
import 
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
    a:hover{
        color: black;
        font-weight: bold;
    }

    /*전체 페이지 영역 */
    #divide_wrap{
        /* width: 1920px; */
        display: grid;
        grid-template-columns: 290px auto;
    }

    #content_wrap{
        padding-left: 30px;
        padding-right: 30px;
    }

    /*사이드메뉴 영역 */
    #nav_wrap{
        background: rgb(223, 223, 223);
        height: 100vh;
    }

    /*콘텐츠 상단 영역 */
    #maintitle{
        font-size: 24px;
        font-weight: bold;
        margin-top: 50px;
        margin-bottom:30px;
    }

    button{
        width: 100px;
        border-radius: 5px;
        color: white;
        background: black;
        margin-bottom:30px;
    }

    #edit{
        margin-left: 50px;
        float: right;
    }

    /*콘텐츠 하단 영역 */

    .table{
        width: 100%;
        margin-top:20px;
        margin-bottom: 30px;
        border: 1px solid black;
    }
    
    p{
        font-weight: bold;
        margin-bottom: 20px;
    }

    #price{
        font-weight: bold;
        color: #3DDCA3;
    }

    
</style>