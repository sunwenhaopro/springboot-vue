<template>
  <div
    style="
      height: 50px;
      line-height: 50px;
      border-bottom: 1px solid #ccc;
      display: flex;
      background-color: #e5e5e5;
    "
  >
    <div
      style="
        width: 200px;
        padding-left: 20px;
        font-weight: bold;
        color: dodgerblue;
      "
    >
     <el-avatar :size="40" @error="errorHandler">
      <img
        src="@/assets/swh.png">
      />
    </el-avatar>
     
      CtrlCV管理平台
    </div>
    <div style="flex: 1"></div>
    <div style="width: 100px">
      CtrlCV  <el-button type="text"  @click="$router.push('/')" >退出</el-button>
        
    </div>
  </div>
</template>

<script>
import { ArrowDown } from "@element-plus/icons";

export default {
  name: "Header",
  props: ["admin"],
  components: { ArrowDown },

  data() {
    return {};
  },
};
</script>

<style>
@import url("//unpkg.com/element-ui@2.15.6/lib/theme-chalk/index.css");
</style>