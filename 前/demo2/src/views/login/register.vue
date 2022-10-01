<template>
  <div id="register">
    <div class="login-box">
      <h2>注册系统</h2>
      <form>
        <div class="user-box">
          <input type="text" name="" required="" v-model="registerform.username" autocomplete = "new-password">
          <label>用户名</label>
        </div>
        <div class="user-box">
          <input type="password" name="" required="" v-model="registerform.password" autocomplete = "new-password">
          <label>密码</label>
        </div>
        <div class="user-box">
          <input type="repassword" name="passwordConfig" required="" v-model="registerform.repassword" autocomplete = "new-password">
          <label>请确认密码</label>
        </div>
        <div class="user-box">
          <input type="yzpassword" name="" required="" v-model="registerform.yzpassword" autocomplete = "new-password">
          <label>请输入验证码</label>
        </div>
       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;       
        <a class="nb" @click="signUp">
          <span></span>
          <span></span>
          <span></span>
          <span></span>
          注册
        </a>
        
      </form>
    </div>
  </div>
</template>
 
<script>
import request from "../../utils/request";
import axios from "axios";
import { ElMessage, ElMessageBox } from 'element-plus'
export default{
name:'Zhuce',
component:{},
data(){
  return{
    registerform:{
    username:'',
    password:'',
    repassword:'',
    yzpassword:'',
   }
  };  
 },
methods:{
  
    signUp() {
      
      axios.post('/login/signup',{
          username:this.registerform.username,
          password:this.registerform.password,
         
        })
        .then(res=>{
          if(res.data.code===200)
          { 
          
         this.$message({
         message:'注册成功，三秒后跳转至登陆界面',
         type:'success'
         })
         setTimeout(()=>{
		//需要延迟的代码 :3秒后延迟跳转到首页，可以加提示什么的
        this.$router.push('/')
        //延迟时间：3秒
         },3000)
      clearTimeout;
          }else{
             console.log('400')
            alert('注册失败');
          }
       })
     }
 
}
}
</script>

<style scoped>
#register {
  background: url(https://vkceyugu.cdn.bspapp.com/VKCEYUGU-b96599d7-a53c-4774-935d-82adf58002ac/ba5bf886-04b7-4582-854f-7a6ee8324c95.jpg);
  background-size: cover;
  width:100%;
  height:100%;
  position: fixed;
  caret-color: transparent;
}
	input:-webkit-autofill,
	input:-webkit-autofill:hover,
	input:-webkit-autofill:focus, 
	input:-webkit-autofill:active {
		transition-delay: 999999999s;
	    transition: color  999999999s ease-out, background-color  999999999s ease-out;
	    -webkit-transition-delay:  999999999s;
	    -webkit-transition: color  999999999s ease-out, background-color  999999999s ease-out;
	    -webkit-text-fill-color: #fff;
	}

.login-box {
  position: absolute;
  top: 50%;
  left: 50%;
  width: 400px;
  padding: 40px;
  transform: translate(-50%, -50%);
  background: rgba(0, 0, 0, .5);
  box-sizing: border-box;
  box-shadow: 0 15px 25px rgba(0, 0, 0, .6);
  border-radius: 10px;
}

.login-box h2 {
  margin: 0 0 30px;
  padding: 0;
  color: #fff;
  text-align: center;
}

.login-box .user-box {
  position: relative;
}
.login-box form a:hover{
 cursor:default;
}
.login-box h2:hover{
 cursor:default;

}
.login-box .user-box input {
  width: 100%;
  padding: 10px 0;
  font-size: 16px;
  color: #fff;
  margin-bottom: 30px;
  border: none;
  border-bottom: 1px solid #fff;
  outline: none;
  background: transparent;
}

.login-box .user-box label {
  position: absolute;
  top: 0;
  left: 0;
  padding: 10px 0;
  font-size: 16px;
  color: #fff;
  pointer-events: none;
  transition: .5s;
}

.login-box .user-box input:focus ~ label,
.login-box .user-box input:valid ~ label {
  top: -20px;
  left: 0;
  color: #03e9f4;
  font-size: 12px;
}

.login-box form a {
  position: center;
  display: block;
  padding: 10px;
  margin: auto;
  text-align:center;
  color: #03e9f4;
  font-size: 16px;
  text-decoration: none;
  text-transform: uppercase;
  overflow: hidden;
  transition: .5s;
  margin-top: 40px;
  letter-spacing: 4px;
}

.login-box a:hover {
  background: #03e9f4;
  color: #fff;
  border-radius: 5px;
  box-shadow: 0 0 5px #03e9f4,
  0 0 25px #03e9f4,
  0 0 50px #03e9f4,
  0 0 100px #03e9f4;
}

.login-box a span {
  position: absolute;
  display: block;
}
</style>
