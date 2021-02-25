<template>
  <div>
    <h3>게시판</h3>
    <table border="1">
      <tr>
        <th align="center" width="80">번호</th>
        <th align="center" width="320">제목</th>
        <th align="center" width="100">작성자</th>
        <th align="center" width="180">등록일자(버그수정중)</th>
      </tr>
      <!--보드가 있으면 || 어레이 및 길이가 0이라면 > 결국 데이터가 없다면 -->
      <tr v-if="!boards || (Array.isArray(boards) && boards.length === 0)">
        <td colspan="4">
          List is empty
        </td>
      </tr>
      <!--  데이터가 있으면 꺼내와서 아래와 같이 게시글이 작성된다. -->
      <tr v-else v-for="board in boards" :key="board.boardNo">
        <td align="center">{{ board.boardNo }}</td>
        <td align="left">
          <router-link :to="{ name: 'BoardReadPage',
                  params: { boardNo: board.boardNo.toString() } }">
            {{ board.title }}
          </router-link>
        </td>
        <td align="right">{{ board.writer }}</td>
        <td align="center">{{ board.regDate }}</td>
      </tr>
    </table>
  </div>
</template>
<!--중복되는 속성 모듈관리 -->
<script>
export default {
  name: 'BoardList',
  props: {
    boards: {
      type: Array
    }
  }
}
</script>


