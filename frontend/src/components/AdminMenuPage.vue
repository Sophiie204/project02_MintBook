<template>
    <div id="nav_total_wrap">
        <div id="menu_top">
            <label>
                <img src="../assets/AdminPage/adminlogo.png" alt="">
            </label>
            <label id="admintext">Admin</label>
        </div>
        <div id="menu_bottom">
            <ul>
                <li><a href="/admin/book">도서 관리</a></li>
                <li><a href="/admin/book">주문 관리</a></li>
                <li><a href="/admin/book">회원 관리</a></li>
                <li><a href="/admin/book">리뷰 관리</a></li>
                <li><a href="/admin/book">1:1문의 관리</a></li>
                <li><a href="/admin/book">이벤트 관리</a></li>
                <li><a href="/admin/book">공지 관리</a></li>
                <li><a href="/admin/book">통계</a></li>
            </ul>
        </div>
    </div>
</template>

<script>
import { reactive } from 'vue'

export default {
    setup () {

        const state = reactive({
            
        })

        return {
            state,
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
    a:hover{
        color: black;
        font-weight: bold;
    }
    
    #nav_total_wrap{
        width: 290px;
        background: rgb(194, 194, 194);
        text-align: center;
    }
    img{
        width: 40px;
    }
    #admintext{
        font-size: 24px;
        font-weight: bold;
    }

    #menu_top{
        padding-top: 50px;
    }

    #menu_bottom{
        margin-top: 60px;
    }

    #menu_bottom > ul > li{
        padding-bottom: 20px;
    }

    
</style>