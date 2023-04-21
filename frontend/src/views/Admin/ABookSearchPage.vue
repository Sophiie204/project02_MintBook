<template>
    <div id="total_wrap">
        <div id="divide_wrap">
            <div id="nav_wrap">
                <admin-menu-page></admin-menu-page>
            </div>
            <div id="content_wrap">
                <p id="maintitle">출판사:"팩토리나인"</p>
                <p id="searchtotal">검색결과 8건</p>
                <button id="register">도서등록</button>
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">No.</th>
                            <th scope="col">ISBN</th>
                            <th scope="col">도서명</th>
                            <th scope="col">저자명</th>
                            <th scope="col">출판사</th>
                            <th scope="col">출판일</th>
                            <th scope="col">재고수</th>
                            <th scope="col">정가</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="tmp of state.num" :key="tmp">
                            <th scope="row">{{ tmp }}</th>
                            <td>98746565163521</td>
                            <td>불행한 당신을 위하여</td>
                            <td>김다인</td>
                            <td>팩토리나인</td>
                            <td>2023-03-09</td>
                            <td>5</td>
                            <td>12,900원</td>
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

    #searchtotal{
        font-size: 20px;
        margin-bottom:20px;
    }

    button{
        width: 100px;
        border-radius: 5px;
        color: white;
        background: black;
        margin-bottom:30px;
    }

    #register{
        margin-left: 50px;
        float: right;
    }

    /*콘텐츠 하단 영역 */

    .table{
        width: 100%;
        margin-top:30px;
    }
    

    
</style>