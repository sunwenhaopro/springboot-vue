import { createApp} from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import { Button,Form, Field, CellGroup } from 'vant';
//引入css样式
import "./assets/css/global.css"
//引入elementUI-PLUS
import ElementPlus from 'element-plus'

//引入elementUI的css
import 'element-plus/dist/index.css'
//引入中文
import zhCn from 'element-plus/es/locale/lang/zh-cn'
// 直接将App.vue作为一个根节点
import VueAxios from 'vue-axios'
import axios from 'axios' 
// 设置反向代理，前端请求默认发送到 http://localhost:8082/
axios.defaults.baseURL = 'http://127.0.0.1:8081'
// 全局注册，之后可在其他组件中通过 this.$axios 发送数据
//Vue.prototype.$axios = axios
//Vue.config.productionTip = false





createApp(App).use(store).use(VueAxios,axios).use(router).use(Form).use(Field).use(Button).use(CellGroup).use(ElementPlus, { 
    locale: zhCn ,size: "small"
}).mount('#app')



