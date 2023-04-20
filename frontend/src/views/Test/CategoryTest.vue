<template>
    <div>
        <div style="display:grid; grid-template-columns: 1fr 4fr;">
            <div>
                <Categorycomp @myevent="handleList" style="margin-left: 100px;"></Categorycomp>
            </div>
            <div>
                <h1>카테고리별 리스트 페이지</h1>
            </div>
        </div>
    </div>
</template>

<script>
import router from '@/router';
import Categorycomp from './Categorycomp.vue';

export default {
    components : {
        Categorycomp
    },

    setup () {

        const handleList = (e) =>{
            alert(e);
            router.push(`/cs/${e}`)
        }

        return {
           handleList
        }
    }
}
</script>

<style lang="css" scoped>

</style>