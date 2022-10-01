
<template>
  <!-- 后台的框架 -->
  <div>
    <!-- 头部栏 -->
    <Header :admin="admin" />
    <!-- 主体 -->
    <div style="display: flex">
      <!-- 侧边栏 -->
      <Aside />
      <!-- 内容区域 -->
      <router-view style="flex: 1" />
    </div>
  </div>
</template>

// 这个为后台的框架模板,头部导航栏,侧边栏,以及中心展示区<router-view/>

<script>
//导入components下的admin下的组件
import Header from "@/views/base/Header.vue";
import Aside from "@/views/base/Aside.vue";
import request from "@/utils/request";

export default {
  name: "Layout",
  components: {
    Header,
    Aside,
  },
  data(){
    return{
      admin:{username:'小鸡'}
    }
  },
  methods:{
    
    
  }
};
</script>

<style>
</style>