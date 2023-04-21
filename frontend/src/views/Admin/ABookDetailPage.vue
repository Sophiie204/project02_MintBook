<template>
    <div id="total_wrap">
        <div id="divide_wrap">
            <div id="nav_wrap">
                <admin-menu-page></admin-menu-page>
            </div>
            <div id="content_wrap">
                <p id="maintitle">도서 상세</p>
                <button id="edit">수정</button>
                <table class="table">
                    <tbody>
                        <tr>
                            <th scope="row">도서명</th>
                            <td colspan="3">불행한 당신을 위하여</td>
                        </tr>
                        <tr>
                            <th scope="row">저자명</th>
                            <td>김다인</td>
                            <th scope="row">출판사</th>
                            <td>팩토리나인</td>
                        </tr>
                        <tr>
                            <th scope="row">출판일</th>
                            <td>2023-03-09</td>
                            <th scope="row">정가</th>
                            <td>12,900원</td>
                        </tr>
                        <tr>
                            <th scope="row">ISBN</th>
                            <td>129312124819</td>
                            <th scope="row">카테고리</th>
                            <td>자기계발</td>
                        </tr>
                        <tr>
                            <th scope="row">판매수</th>
                            <td>13</td>
                            <th scope="row">재고수</th>
                            <td>5</td>
                        </tr>
                        <tr>
                            <th scope="row">작가소개</th>
                            <td colspan="3">작가소개작가소개작가소개작가소개작가소개작가소개작가소개</td>
                        </tr>
                        <tr>
                            <th scope="row">책소개</th>
                            <td colspan="3">책소개책소개책소개책소개책소개책소개책소개책소개책소개책소개</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</template>

<script>
import { reactive } from 'vue';
import AdminMenuPage from '../../components/AdminMenuPage.vue';

export default {
    components:{
        AdminMenuPage
    },

    setup () {
        const state = reactive({
            num:["1","2","3","4","5","6","7","8","9","10"]
        })

        return {state}
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
        margin-bottom:20px;
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
        margin-top:30px;
    }

    th{
        background: rgb(184, 184, 184);
    }
    

    
</style>