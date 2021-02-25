<template>
  <div id="board">
    <h2>Board List</h2>
    <router-link :to="{ name: 'BoardRegisterPage' }">
      글쓰기
    </router-link>
    <!--    컴포넌트 보드리스트의 보드를 보여준다.-->
    <board-list :boards="boards"/>
  </div>
</template>

<script>
import BoardList from '@/components/BoardList'
import { mapState, mapActions } from 'vuex'
export default {
  name: 'BoardListPage',
  components: {
    BoardList
  },
  //게시판을 만들어준다. STATE에 설정된 기본 세팅 값을 가져온다.
  computed: {
    ...mapState(['boards'])
  },
  mounted () {
    this.fetchBoardList()
  },
  methods: {
    ...mapActions(['fetchBoardList'])
  }
}
</script>

