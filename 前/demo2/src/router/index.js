import { createRouter, createWebHashHistory } from 'vue-router'
import Login from '../views/login/login.vue'
import register from '../views/login/register.vue'
import AddMood from "../views/AddMood"
const routes =[ // 路由规则
{
  path: '/home',
  meta:{
    title:'首页'
    },
  name: 'Layout',
  component: () => import('../layout/Layout.vue'),
  redirect: "/user",//当访问/时自动访问到home界面里面
  children: [
    //子路由,用来展示表格界面
    {
      path: '/user',
      name: 'user',
      component: () => import(/* webpackChunkName: "about" */ '../views/user/user.vue')
    },
    {
      path: '/examroom',
      name: 'examroom',
      component: () => import(/* webpackChunkName: "about" */ '../views/examroom/index.vue')
    }
  ]
},
{
  path:'/',
  name:'login',
  component:Login,
},
{
 path:'/add',
name:'AddMood',
component:AddMood,
},
{
    path:"/login/signup",
    name:'signup',
    component:register,
},

]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router




 



