<template>
  <div>
    <h3>수정 형식</h3>
    <!-- 제출 된 이벤트가 페이지를 다시 로드 하지 않도록 함-->
    <form @submit.prevent="onSubmit">
      <table>
        <tr>
          <td>번호</td>
          <td><input type="text" :value="board.boardNo" disabled></td>
        </tr>
        <tr>
          <td>등록일자</td>
          <td><input type="text" :value="board.regDate" disabled></td>
        </tr>
        <tr>
          <td>제목</td>
          <td><input type="text" v-model="title"></td>
        </tr>
        <tr>
          <td>작성자</td>
          <td><input type="text" :value="board.writer" disabled></td>
        </tr>
        <tr>
          <td>본문</td>
          <td><textarea v-model="content" rows="5"></textarea></td>
        </tr>
      </table>

      <div>
        <button type="submit">수정</button>
        <router-link :to="{ name: 'BoardReadPage', params: { boardNo: board.boardNo.toString() } }">
          취소
        </router-link>
      </div>
    </form>
  </div>
</template>

<script>
export default {
  name: 'BoardModifyForm',
  props: {
    board: {
      type: Object,
      required: true
    }
  },
  data () {
    return {
      title: '',
      content: ''
    }
  },
  methods: {
    onSubmit () {
      const { title, content } = this
      this.$emit('submit', { title, content })
    }
  },
  created () {
    this.title = this.board.title
    this.content = this.board.content
  }
}
</script>

