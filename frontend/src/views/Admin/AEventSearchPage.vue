<template>
    <div id="total_wrap">
        <div id="divide_wrap">
            <div id="nav_wrap">
                <admin-menu-page></admin-menu-page>
            </div>
            <div id="content_wrap">
                <p id="maintitle">진행여부:"진행중"</p>
                <p id="searchtotal">검색결과 3건</p>
                <button id="register">이벤트 등록</button>
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">No.</th>
                            <th scope="col">제목</th>
                            <th scope="col">등록날짜</th>
                            <th scope="col">시작날짜</th>
                            <th scope="col">만료날짜</th>
                            <th scope="col">진행여부</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="tmp of state.num" :key="tmp">
                            <th scope="row">{{ tmp }}</th>
                            <td>봄맞이 도서 이벤트</td>
                            <td>2023-03-24</td>
                            <td>2023-03-30</td>
                            <td>2023-04-30</td>
                            <td>진행중</td>
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