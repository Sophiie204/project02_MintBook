<template>
    <div id="total_wrap">
        <HeaderPage style="position:fixed;z-index: 300;"></HeaderPage>
        <div class="center_wrap">
            <div class="headerpage"></div>
            <div class="top_wrap">
                <div class="top_top_wrap">
                    <div id="top_top_left">
                        <p id="top_title">세이노의 가르침</p>
                        <p id="top_author">세이노(지은이)  |  데이원  |  2023년 03월 02일</p>
                    </div>
                    <div id="top_top_right">
                        <img src="../assets/BookDetailPage/share.png" alt="share">
                    </div>
                </div>
                <div class="top_bottom_wrap">
                    <div class="top_bottom_left">
                        <img src="../assets/MainPage/book5.jpg" alt="book">
                    </div>
                    <table class="top_bottom_right">
                        <tr>
                            <td class="right_left">정가</td>
                            <td class="right_right">25,000원</td>
                        </tr>
                        <tr class="line">
                            <td class="right_left">판매가</td>
                            <td class="right_right">
                                <label id="price">22,500원</label>
                                <label id="discount">(10%)</label>
                            </td>
                        </tr>
                        <tr>
                            <td class="right_left">적립금</td>
                            <td class="right_right">
                                <label>1,250원</label>
                                <label id="point">(5%)</label>
                            </td>
                        </tr>
                        <tr>
                            <td class="right_left">배송료</td>
                            <td class="right_right">15,000원 이상 무료배송</td>
                        </tr>
                        <tr class="line">
                            <td class="right_left">독자평점</td>
                            <td class="right_right">
                                <label id="review">3.0</label><label>/5점</label>
                            </td>
                        </tr>
                        <tr class="line"> 
                            <td class="right_left">수량</td>
                            <td class="right_right">
                                <el-input-number v-model="state.num" :min="1" :max="10" size="large" @change="handleChange(value)" />
                            </td>
                        </tr>
                        <tr>
                            <td colspan='2' id="button_top">
                                <button id="alarm">알림신청</button>
                            </td>
                        </tr>
                        <tr>
                            <td colspan='2' id="button_bottom">
                                <button id="like">♥</button>
                                <button id="cart">장바구니</button>
                                <button id="buy">바로구매</button>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
            <div class="content">
                <div class="aboutbook">
                    <p class="content_title">책소개</p>
                    <p class="content_content">한국과 미국, 전 세계를 오가며 ‘사장을 가르치는 사장’으로 알려진 『돈의 속성』의 저자 김승호 회장의 신간이다. 평생 사장으로 살아온 그의 경영철학 모두를 10여 년에 걸쳐 정리해 온 그는, 이번 『사장학개론』 책을 통해 120가지 주제로 그 내용을 모두 담아 완성했다.지난 7년간 3천 명의 사장 제자들을 만나 사장학 수업을 진행하며 현실에서 겪는 다양한 문제에 대해, 사장들이 묻는 공통적인 어려움이 존재했으며 그 문제들을 목차로 구성해 방향제시를 더했다.한국KCA사장학교에 합격하고 저자를 기다리고 있는 사장들을 만나기 위해 미국에 거주하는 기업인인 저자는 일 년에 두 번, 한국을 방문해왔다. 하지만 한정된 기회와 한정된 인원으로 제한되는 상황이 지속돼 사장학 수업 내용 전체를 담아 『사장학개론』 책으로 출판을 결정하게 되었다.</p>
                </div>
                <div class="aboutauthor">
                    <p class="content_title">작가정보</p>
                    <p class="content_content">필명 세이노는 현재까지 믿고 있는 것들에 대해 No라고 말하라(Say No)는 뜻이다. 2023년 기준 순자산 천억 원대 자산가다. 1955년생. 의사의 장남으로 태어나 서너 살 유년기부터 아버지의 가르침을 받았다. 아버지가 전 재산을 사기로 모두 날린 후 사망하면서 친부모를 모두 여의고 고교시절부터 생활고에 크게 시달렸다.고교 3학년 때 건강과 가난 때문에 휴학하고 친구 아버님과 친구들의 투자를 받아 사업을 했으나 실패 후 복학하여 고교를 4년 만에 졸업하고 입대했다. 공군사병으로 복무하는 동안 군부대 부동산 관리 업무와 도서관 관장을 맡았고, 제대 후 영어공부에 몰두하여 미8군 내 메릴랜드대학 분교에 입학하였다. 학비를 벌고자 보따리 장사부터 시작하여 과외ㆍ입시영어학원ㆍ번역업 등을 했다.결혼 후에는 거의 십여 년 이상 쉬는 날 없이 밤늦도록 일과 공부에 몰두하면서 의류업ㆍ정보처리ㆍ컴퓨터ㆍ음향기기ㆍ유통업ㆍ무역업 등으로 자산을 모으기 시작했다. 그 자산을 외환투자ㆍ부동산경매ㆍ주식 등으로 증대시켰고 학연ㆍ혈연ㆍ지연ㆍ정치적 배경 없이 홀로 현재의 자산을 이룩했다.세계적인 다국적 기업의 아시아 지역 부사장직도 겸임하였고 사업상 70여 개국을 여행했다. 국내에서 경영하였던 회사들은 수출탑과 산업훈장을 받았으며, 인재경영대상후보로 오르기도 했다.2003년부터는 사업을 줄여 왔고 광범위한 독서ㆍ음악ㆍ영화감상을 즐긴다. 가장 좋아하는 것은 문제를 해결하는 것, 사람을 가르치고 깨우치는 것이며, 가장 싫어하는 것은 접대 술자리, 기업 정치가들, 부자인 척하는 자들의 블러핑. 매년 십억 원대의 소득세를 2000년까지 5년 이상 세이노 개인이 납부하였고 2001년부터는 가족 단위로 납부하고 있다.</p>
                </div>
                <div class="aboutinfo">
                    <p class="content_title">기본정보</p>
                    <ul class="content_content">
                        <li>• ISBN: 9791188331888</li>
                        <li>• 출판일: 2023년 03월 02일</li>
                    </ul>
                </div>
            </div>
            <div class="review_section">
                <div class="review_title">
                    <label class="content_title">독자리뷰</label>
                    <label id="review_cnt"> (716)</label>
                </div>
                <div class="review_btn">
                    <div id="review_btn_left">
                        <select name="" id="">
                            <option value="">5점</option>
                            <option value="">4점</option>
                            <option value="">3점</option>
                            <option value="">2점</option>
                            <option value="">1점</option>
                        </select>
                    </div>
                    <div id="review_btn_right">
                        <button id="r_register_btn">리뷰등록</button>
                    </div>
                </div>
                <textarea name="" id="" rows="10" placeholder="내용을 10자 이상 입력해 주세요. 주제와 무관한 댓글, 악플, 배송문의 등의 글은 임의 삭제될 수 있습니다."></textarea>
                <div class="reviewlist_top">
                    <div class="reviewlist_top_left">
                        <label class="reviewpoint" id="pointred">4.5</label>
                        <label class="pointtotal">/5.0</label>
                        의 평점을 받았어요!
                    </div>
                    <div class="reviewlist_top_right">
                        <select name="" id="">
                            <option value="">최신순</option>
                            <option value="">별점순</option>
                        </select>
                 </div>
                </div>
                <table class="reviewlist">
                    <tr>
                        <td class="reviewlist_left">
                            <label class="reviewpoint">4.5</label>
                            <label class="pointtotal">/5.0</label>
                        </td>
                        <td class="reviewlist_right">
                            <p class="reviewer">wlg**** | 2023.03.31</p>
                            <p>세이노의 가르침 덕분에 인생의 길이 달라졌습니다.</p>
                        </td>
                    </tr>
                    <tr>
                        <td class="reviewlist_left">
                            <label class="reviewpoint">4.5</label>
                            <label class="pointtotal">/5.0</label>
                        </td>
                        <td class="reviewlist_right">
                            <p class="reviewer">wlg**** | 2023.03.31</p>
                            <p>세이노의 가르침 덕분에 인생의 길이 달라졌습니다.</p>
                        </td>
                    </tr>
                    <tr>
                        <td class="reviewlist_left">
                            <label class="reviewpoint">4.5</label>
                            <label class="pointtotal">/5.0</label>
                        </td>
                        <td class="reviewlist_right">
                            <p class="reviewer">wlg**** | 2023.03.31</p>
                            <p>세이노의 가르침 덕분에 인생의 길이 달라졌습니다.</p>
                        </td>
                    </tr>
                    <tr>
                        <td class="reviewlist_left">
                            <label class="reviewpoint">4.5</label>
                            <label class="pointtotal">/5.0</label>
                        </td>
                        <td class="reviewlist_right">
                            <p class="reviewer">wlg**** | 2023.03.31</p>
                            <p>세이노의 가르침 덕분에 인생의 길이 달라졌습니다.</p>
                        </td>
                    </tr>
                    <tr>
                        <td class="reviewlist_left">
                            <label class="reviewpoint">4.5</label>
                            <label class="pointtotal">/5.0</label>
                        </td>
                        <td class="reviewlist_right">
                            <p class="reviewer">wlg**** | 2023.03.31</p>
                            <p>세이노의 가르침 덕분에 인생의 길이 달라졌습니다.</p>
                        </td>
                    </tr>
                </table>
                <div class="example-pagination-block">
                    <el-pagination layout="prev, pager, next" :total="100"/>
                 </div>
            </div>
            <div class="recommend_section">
                <p class="content_title" id="recommend_title">이런 책도 추천해요!</p>
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
            <div class="cs_section">
                <div class="cs_top">
                    <div class="content_title">반품/교환안내</div>
                    <div class="cs_top_right">
                        <button id="csbutton">1:1문의</button>
                    </div>
                </div>
                <div class="cs_content">
                    <p>반품/교환방법</p>
                    <p>마이룸 > 주문관리 > 주문/배송내역 > 주문조회 > 반품/교환 신청, [1:1 상담 > 반품/교환/환불] 또는 고객센터 (1544-1900)* 오픈마켓, 해외배송 주문, 기프트 주문시 [1:1 상담>반품/교환/환불] 또는 고객센터 (1544-1900)</p>
                    <p class="blank"></p>
                    <p>반품/교환가능 기간</p>
                    <p>변심반품의 경우 수령 후 7일 이내,상품의 결함 및 계약내용과 다를 경우 문제점 발견 후 30일 이내</p>
                    <p class="blank"></p>
                    <p>반품/교환비용</p>
                    <p>변심 혹은 구매착오로 인한 반품/교환은 반송료 고객 부담</p>
                    <p class="blank"></p>
                    <p>반품/교환 불가 사유</p>
                    <p>1. 소비자의 책임 있는 사유로 상품 등이 손실 또는 훼손된 경우(단지 확인을 위한 포장 훼손은 제외) 2. 소비자의 사용, 포장 개봉에 의해 상품 등의 가치가 현저히 감소한 경우예 화장품, 식품, 가전제품(악세서리 포함) 등 3. 복제가 가능한 상품 등의 포장을 훼손한 경우예 음반/DVD/비디오, 소프트웨어, 만화책, 잡지, 영상 화보집4 소비자의 요청에 따라 개별적으로 주문 제작되는 상품의 경우 ((1)해외주문도서)5 디지털 컨텐츠인 eBook, 오디오북 등을 1회 이상 다운로드를 받았을 경우6. 시간의 경과에 의해 재판매가 곤란한 정도로 가치가 현저히 감소한 경우7. 전자상거래 등에서의 소비자보호에 관한 법률이 정하는 소비자 청약철회 제한 내용에 해당되는 경우</p>
                    <p class="blank"></p>
                    <p>상품 품절</p>
                    <p>공급사(출판사) 재고 사정에 의해 품절/지연될 수 있으며, 품절 시 관련 사항에 대해서는 이메일과 문자로 안내드리겠습니다.</p>
                    <p class="blank"></p>
                    <p>소비자 피해보상 환불 지연에 따른 배상</p>
                    <p>1) 상품의 불량에 의한 교환, A/S, 환불, 품질보증 및 피해보상 등에 관한 사항은 소비자분쟁 해결 기준 (공정거래위원회 고시)에 준하여 처리됨2) 대금 환불 및 환불지연에 따른 배상금 지급 조건, 절차 등은 전자상거래 등에서의 소비자 보호에 관한 법률에 따라 처리함</p>
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
import { reactive, ref } from 'vue'

export default {
    
    components:{
    HeaderPage:HeaderPage,
    FooterPage:FooterPage
    },

    setup () {
        const state = reactive({
            num: ref(1),
        })

        const handleChange = (value) => {
            console.log(value)
        }

        return {
            state,
            handleChange
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

    /*상단영역 */
    /*제목&공유 영역 */
    
    .top_wrap{
        margin-top: 50px;
        padding-bottom: 100px;
        border-bottom: 0.5px solid #BDBDBD;
    }
    
    .top_top_wrap{
        display: grid;
        grid-template-columns: 9fr 1fr;
        padding-bottom: 10px;
        border-bottom: 0.5px solid #BDBDBD;
    }

    #top_title{
        font-size: 32px;
        font-weight: bold;
    }

    #top_author{
        font-size: 16px;
        color: #6F6F6F;
        margin-top: 10px;
    }

    #top_top_right {
        text-align: right;
    }

    #top_top_right > img {
        width: 30px;
        margin-top: 20px;
    }

    /*이미지&가격 영역 */
    .top_bottom_wrap{
        display: grid;
        grid-template-columns: 1fr 1fr;
        margin-top: 30px;
    }

    .top_bottom_left > img{
        width: 419px;
        box-shadow: 5px 5px 5px 3px rgb(227, 227, 227);
    }

    .top_bottom_right{
        width: 100%;
        border-collapse: collapse;
    }

    .right_left{
        font-size: 20px;
        width: 150px
    }

    .right_right{
        font-size: 20px;
    }

    #price{
        font-size: 28px;
        color: #3DDCA3;
    }
    #discount, #point{
        color: #7C7C7C;
    }
    #review{
        font-weight: bold;
        color: #DF7474;
    }

    /*버튼 */
    #alarm{
        width: 135px;
        height: 44px;
        border: 1px solid #7C7C7C;
        border-radius: 10px;
        background: white;
    }

    #button_top{
        text-align: right;
    }

    #button_bottom > button{
        width: 193px;
        height: 62px;
        border-radius: 10px;
        font-size: 18px;
    }

    #like{
        border: 0.5px solid #b1b1b1;
        background-color: white;
        color: red;
        margin-right: 10.5px;
    }

    #cart{
        border: 0.5px solid #DADADA;
        background: #DADADA;
        margin-right: 10.5px;
    }

    #buy{
        border: 0.5px solid #3DDCA3;
        background: #3DDCA3;
        color: white;
    }

    .line{
        border-bottom: 0.5px solid #BDBDBD;
    }

    /*콘텐츠 영역 */
    .content{
        margin-top: 100px;
        border-bottom: 0.5px solid #BDBDBD;
    }
    .content_title{
        font-size: 32px;
        color: #3DDCA3;
        margin-bottom: 30px;
    }

    .content_content{
        font-size: 14px;
        color: #808080;
    }

    .content > div{
        margin-top: 50px;
        margin-bottom: 100px;
    }

    /*리뷰 영역 */

    .review_section{
        margin-top: 50px;
        padding-bottom: 200px;
    }
    .review_title{
        margin-bottom: 50px;
    }

    #review_cnt{
        color: #808080;
        font-size: 32px;
    }

    .review_btn{
        display: grid;
        grid-template-columns: 1fr 1fr;
        margin-bottom: 20px;
    }

    button{
        width: 115px;
        height: 36px;
        border-radius: 10px;
        font-size: 12px;
        cursor: pointer;
    }

    select{
        width: 130px;
        height: 36px;
        border-radius: 10px;
        font-size: 12px;
        text-align: center;
        color: #3DDCA3;
        font-weight: bold;
        
    }

    select > option {
        font-size: 12px;
        margin: 20px;
    }

    #r_register_btn{
        border: 1px solid #3DDCA3;
        background: #3DDCA3;
        color: white;
    }
    
    #review_btn_left{
        text-align: left;
    }
    
    #review_btn_right{
        text-align: right;
    }

    textarea{
        border: 1px solid black;
        border-radius: 10px;
        width: 1200px;
        height: 239px;
        resize: none;
        outline: none;
        padding: 20px;
        box-sizing:border-box;
        margin-bottom: 50px;
    }
    /*리뷰리스트영역 */
    .reviewlist_top{
        display: grid;
        grid-template-columns: 1fr 1fr;
        font-size: 24px;
        padding-bottom: 20px;
        border-bottom: 0.5px solid #BDBDBD;
    }

    .reviewpoint{
        font-size: 36px;
        color: #3DDCA3;
        font-weight: bold;
    }

    .pointtotal{
        font-size: 20px;
        color: #878787;
    }

    #pointred{
        color: #DF7474;
    }

    .reviewlist_top_right{
        text-align: right;
    }

    /* 리뷰리스트 테이블영역 */

    .reviewlist{
        width: 100%;
        border-collapse: collapse;
    }

    .reviewlist_left, .reviewlist_right{
        padding-top: 25px;
        padding-bottom: 25px;
        border-bottom: 0.5px solid #BDBDBD;
    }
    .reviewlist_left{
        width: 120px;
        
    }

    .reviewer{
        color: #818181;
        margin-bottom: 10px;
    }

    .example-pagination-block{
        width: 320px;
        margin: 0 auto;
        margin-top: 50px;
    }

    /*추천영역 */

    .recommend_section{
        padding-bottom: 100px;
        border-bottom: 0.5px solid #BDBDBD;

    }

    #recommend_title{
        color: black;
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

    /*반품교환안내 영역*/

    .cs_top{
        display: grid;
        grid-template-columns: 1fr 1fr;
        margin-top: 100px;
    }

    .cs_top_right{
        text-align: right;
    }

    #csbutton{
        border: 1px solid #3DDCA3;
        background: #3DDCA3;
        color: white;
    }
    
    .cs_content{
        width: 1200px;
        color: #818181;
    }

    .blank{
        margin-bottom: 15px;
    }


    

    

    

    
    
    

</style>