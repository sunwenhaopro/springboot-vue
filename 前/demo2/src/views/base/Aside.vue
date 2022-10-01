<template>
  <div>
    <el-menu
      style="
        width: 200px;
        min-height: calc(100vh - 50px);
      "
      :default-active="path"
      router
      class="el-menu-vertical-demo"
    >
      <!-- router是用来指定跳转页面用的 -->
      <el-sub-menu index="1">
        <template #title>
          <i class="el-icon-location"></i>
          <span>系统管理</span>
        </template>
        <el-menu-item index="/user">
          <i class="el-icon-document"></i>
          <span>考生管理</span>
        </el-menu-item>
        <el-menu-item index="/examroom">
          <i class="el-icon-document"></i>
          <span>考场管理</span>
        </el-menu-item>
      </el-sub-menu>
    </el-menu>

  </div>
</template>

<script>
import { ArrowDown } from "@element-plus/icons";

export default {
  components: { ArrowDown },
  data() {
    return {
      //用path绑定路由,显示高亮
      path: this.$route.path,
    };
  },
};
</script>

<style>
</style>