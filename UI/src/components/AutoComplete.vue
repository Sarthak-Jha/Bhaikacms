<template>
<div>
    <select  v-for="results in autoCompResult.seasonalVideoProgram" :key="results.content.id" name="dropdown" v-model="selectPrograms">
    <option>results.content.name</option>
  </select>
     </div>
</template>

<script>
import { mapGetters } from 'vuex';
export default {
    name:'AutoComplete',
    computed : {
    ...mapGetters([
      'autoCompResult'
    ])
  }
    
}
</script>